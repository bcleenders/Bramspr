package bramspr;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Stack;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.util.TraceClassVisitor;

import bramspr.BramsprParser.AccessOnAssignableContext;
import bramspr.BramsprParser.BasicAssignableContext;
import bramspr.BramsprParser.FieldAccessContext;
import bramspr.BramsprParser.*;
import bramspr.symboltable.CompositeSymbol;
import bramspr.symboltable.EnumerationSymbol;
import bramspr.symboltable.FunctionSymbol;
import bramspr.symboltable.Symbol;
import bramspr.symboltable.TypeSymbol;
import bramspr.symboltable.VariableSymbol;

//public class BramsprCompiler implements BramsprVisitor<Integer> {
public class BramsprCompiler extends BramsprBaseVisitor<Symbol> implements Opcodes {
	/** The name of the main class this code will compile to, e.g. "Bramspr" or "Math" */
	private String mainFileName;

	/**
	 * Whether the compiler is in a "read" state, or in a "write" state. <br />
	 * 
	 * If it's in a write state, field access should put a reference on the stack. <br />
	 * 
	 * If it's in read access, the value of the field should be put on the stack.
	 */
	private boolean inReadAccessToField = true;

	/**
	 * The "decoration" of our parsetree: maps Contexts to Symbols
	 */
	private ParseTreeProperty<Symbol> parseTreeproperty;
	/**
	 * The main visitor; contains all the bytecode of our generated code.
	 */
	TraceClassVisitor tcw;
	FieldVisitor fv;
	MethodVisitor mv;

	// Memory management!
	/**
	 * The number of variables declared at any given time Starts at 2, to leave room for the arguments (single reference) and $this
	 */
	private int variablesDeclaredNow = 2;
	/** The number of variables declared in the current level */
	private Stack<Integer> variablesDeclaredInLevel = new Stack<Integer>();

	/**
	 * Contains the last label of every scope we have visited. Grows one every time a scope is opened. These labels are used in the elements of
	 * {@link #variables} to mark the end of their scope.
	 */
	private Stack<Label> closingScopeLabels = new Stack<Label>();

	/**
	 * Opens a new scope (reserves a closing label).
	 * 
	 * @ensures this.closingScopeLabels.size() = old.closingScopeLabels.size() + 1
	 */
	private void openScope() {
		this.closingScopeLabels.push(new Label());

		// We just opened a new scope; there are no variables declared in this one yet...
		this.variablesDeclaredInLevel.add(0);
	}

	/**
	 * To be called when visiting a variableDeclaration (also the implicit ones: the parameters in a functioncall). Sets the memory address of the parameter,
	 * increases the counter and makes sure that the scope of visibility is taken care of.
	 * 
	 * @param variable
	 *            the newly declared variable that needs a place in our memory
	 * @return the memory address assigned to the variable
	 * @ensure this.variablesDeclaredNow = old.variablesDeclaredNow + 1
	 * @ensure memory address is not used by another variable
	 */
	private int claimMemAddr(VariableSymbol variable) {
		variable.setMemAddr(this.variablesDeclaredNow);
		this.variablesDeclaredNow++;
		int declaredInCurrentLevel = this.variablesDeclaredInLevel.pop();
		this.variablesDeclaredInLevel.push(declaredInCurrentLevel + 1);

		// Create a copy of the VariableSymbol, to make sure it won't be changed accidentally later or in the program.
		VariableSymbol copy = new VariableSymbol(variable.getIdentifier(), variable.getReturnType(), variable.isConstant());
		copy.setMemAddr(variable.getMemAddr());
		this.variables.add(copy);

		// This denotes the start of this variable's visibility.
		Label openingLabel = new Label();
		mv.visitLabel(openingLabel);

		// And this will denote the end of this variable's visibility.
		Label closingLabel = this.closingScopeLabels.peek();
		copy.setOpenCloseLabels(openingLabel, closingLabel);

		return variable.getMemAddr();
	}

	/**
	 * Closes a scope by popping and writing a scope from the closingScopeLabels stack to assembly. This ensures variables are not visible too long.
	 */
	private void closeScope() {
		Label closingLabel = this.closingScopeLabels.pop();
		mv.visitLabel(closingLabel);

		// The variables are no longer needed: release their memoryaddresses
		this.variablesDeclaredNow = this.variablesDeclaredNow - variablesDeclaredInLevel.pop();
	}

	/**
	 * Maintains a list of the variables we have visited. Stores name, type, opening_label, closing_label (excl.) This allows us to do a massive
	 * mv.visitLocalVariable(...) iteration at the end of the class, to declare the variables.
	 */
	private ArrayList<VariableSymbol> variables = new ArrayList<VariableSymbol>();

	/**
	 * This stores a list of classnames and bytecode. It always stores at least one element; the main class.
	 */
	private ArrayList<BramsprClass> classes = new ArrayList<BramsprClass>();

	/**
	 * Prints a (somewhat) human-readable dump of the assembly to the standard output.
	 */
	public void dumpAssembly() {
		System.out.println("*** STARTING DUMP ***");
		List<Object> log = this.tcw.p.text;
		for (int i = 0; i < this.tcw.p.text.size(); i++) {
			if (log.get(i) instanceof ArrayList<?>) {
				@SuppressWarnings("unchecked")
				ArrayList<String> currEntry = (ArrayList<String>) log.get(i);
				for (int j = 0; j < currEntry.size(); j++) {
					System.out.print(currEntry.get(j));
				}
			} else {
				System.out.print(log.get(i));
			}
		}
		System.out.println("*** FINISHED DUMP ***");
	}

	/**
	 * Generates bytecode for the JVM from a parsetree. The generated bytecode contains a main class that semantically matches the bramspr sourcecode that
	 * produced the parsetree and parsetreeproperty.
	 * 
	 * @param tree
	 *            the parsetree generated from the sourcecode
	 * @param ptp
	 *            a map from Contexts to Symbols, containing the information needed to link variables, functions, types and enums to their declaration.
	 * @param className
	 *            the name of the file, which corresponds to the name of the class.
	 * @return Java bytecode array that can be written to a file and executed by calling java className
	 */
	public ArrayList<BramsprClass> compile(ParseTree tree, ParseTreeProperty<Symbol> ptp, String className) {
		ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS | ClassWriter.COMPUTE_FRAMES);
		this.tcw = new TraceClassVisitor(cw, new PrintWriter(System.out));
		this.parseTreeproperty = ptp;
		this.mainFileName = className;

		this.tcw.visit(V1_7, ACC_PUBLIC + ACC_SUPER, className, null, "java/lang/Object", null);

		{ // Class initializer of the outerclass
			mv = this.tcw.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
			mv.visitCode();

			// Set start and end labels
			Label startLabel = new Label();
			Label endLabel = new Label();

			mv.visitLabel(startLabel);
			mv.visitVarInsn(ALOAD, 0);
			mv.visitMethodInsn(INVOKESPECIAL, "java/lang/Object", "<init>", "()V");
			mv.visitInsn(RETURN);
			mv.visitLabel(endLabel);
			mv.visitLocalVariable("this", "L" + className + ";", null, startLabel, endLabel, 0);
			mv.visitMaxs(1, 1);
			mv.visitEnd();
		}

		{ // main method
			mv = this.tcw.visitMethod(ACC_PUBLIC + ACC_STATIC, "main", "([Ljava/lang/String;)V", null, null);
			mv.visitCode();

			// Create an instance of the outerclass
			Label l0 = new Label();
			mv.visitLabel(l0);
			mv.visitLineNumber(11, l0);
			mv.visitTypeInsn(NEW, this.mainFileName);
			mv.visitInsn(DUP);
			mv.visitMethodInsn(INVOKESPECIAL, this.mainFileName, "<init>", "()V");
			// Put it in the memory, location 1!
			mv.visitVarInsn(ASTORE, 1);
			Label l1 = new Label();
			mv.visitLabel(l1);

			// Open the program scope
			this.openScope();
			// Compile the code
			visit(tree);
			// Close the program scope
			this.closeScope();

			mv.visitInsn(RETURN);

			Label l4 = new Label();
			mv.visitLabel(l4);
			mv.visitLocalVariable("args", "[Ljava/lang/String;", null, l0, l4, 0);
			mv.visitLocalVariable("outerClass", "L" + this.mainFileName + ";", null, l1, l4, 1);

			// Now let's visit all those variables we've been using throughout the program...
			for (int i = 0; i < this.variables.size(); i++) {
				VariableSymbol var = this.variables.get(i);

				TypeSymbol type = var.getReturnType();
				String signature = null;

				if (this.isJBCPrimitive(type)) {
					signature = type.getDescriptor();
				} else if (type instanceof CompositeSymbol) {
					signature = "L" + type.getDescriptor() + ";";
				} else if (type instanceof EnumerationSymbol) {
					signature = "I"; // Enums are represented as integer values, allowing easy comparisons.
				} else {
					System.err.println("Unknown type at variable declaration.");
					System.exit(1);
				}

				mv.visitLocalVariable(var.getIdentifier(), signature, null, var.openingLabel, var.closingLabel, var.getMemAddr());
			}

			// max stack and max locals automatically computed, only needed for Java 8 and above and Java 7 without flags
			mv.visitMaxs(0, 0);
			// That's all for now...
			mv.visitEnd();
		}

		byte[] code = cw.toByteArray();

		this.classes.add(new BramsprClass(className, code));

		return this.classes;
	}

	/**
	 * Produces the JBC to declare a variable and assign it a default value (0, false, a or ""). Does not leave anything on the stack.
	 * 
	 * @param ctx
	 *            the node in the parsetree representing the pureDeclaration
	 */
	public Symbol visitPureVariableDeclaration(PureVariableDeclarationContext ctx) {
		// Alle IDENTIFIER's binnen deze declaration komen in de parsetreeproperty voor, en ze bevatten de VariableSymbol's

		for (int i = 0; i < ctx.IDENTIFIER().size(); i++) {
			VariableSymbol symbol = (VariableSymbol) this.parseTreeproperty.get(ctx.IDENTIFIER(i));
			int memAddr = this.claimMemAddr(symbol);

			TypeSymbol type = symbol.getReturnType();

			// Geef primitieve types hun standaard waarden.
			if (type.equals(BramsprChecker.INTEGER)) {
				// Integers beginnen bij 0
				mv.visitInsn(ICONST_0);
				mv.visitIntInsn(ISTORE, memAddr);
			} else if (type.equals(BramsprChecker.BOOLEAN)) {
				// Booleans beginnen als false
				mv.visitInsn(ICONST_0);
				mv.visitIntInsn(ISTORE, memAddr);
			} else if (type.equals(BramsprChecker.CHARACTER)) {
				// Characters beginnen als a
				int charCode = (int) 'a';
				mv.visitIntInsn(BIPUSH, charCode);
				mv.visitIntInsn(ISTORE, memAddr);
			} else if (type.equals(BramsprChecker.STRING)) {
				mv.visitLdcInsn("");
				mv.visitVarInsn(ASTORE, memAddr);
			}
		}

		return null;
	}

	@Override
	/**
	 * Produces the JBC to declare a variable and immediately assign it a value. Does not leave anything on the stack.
	 * @param ctx the node in the parsetree representing the instantiatingDeclaration
	 */
	public Symbol visitInstantiatingVariableDeclaration(InstantiatingVariableDeclarationContext ctx) {
		Label openingLabel = new Label();
		Label closingLabel = this.closingScopeLabels.peek();

		// Laten we iig alvast even kijken wat er op de stack moet komen te staan:
		visit(ctx.expression()); // Stack: a ->

		for (int i = 0; i < ctx.IDENTIFIER().size(); i++) {
			VariableSymbol symbol = (VariableSymbol) this.parseTreeproperty.get(ctx.IDENTIFIER(i));
			int memAddr = this.claimMemAddr(symbol);
			symbol.setOpenCloseLabels(openingLabel, closingLabel);

			TypeSymbol type = symbol.getReturnType();

			// Copy it, otherwise it'll be gone!
			mv.visitInsn(DUP);

			if (this.isJBCPrimitive(type)) {
				// Mooi; dit kunnen we assigned met ISTORE
				mv.visitIntInsn(ISTORE, memAddr);
			} else {
				mv.visitIntInsn(ASTORE, memAddr);
			}
		}

		// Er stond er nog één op de stack... haal maar weg!
		mv.visitInsn(POP);

		// Vanaf hier mogen de variabelen gebruikt worden.
		mv.visitLabel(openingLabel);

		return null;
	}

	@Override
	/**
	 * Produces the JBC for a statement. A statement leaves no additional values on the stack.
	 * @param ctx the node in the parsetree representing the statement.
	 */
	public Symbol visitStatement(StatementContext ctx) {
		if (ctx.command() != null && ctx.command().assignment() != null) {
			visitAssignment(ctx.command().assignment());
			// Assignments leave something on the stack; statements should not do that so we have to POP it.
			mv.visitInsn(POP);
			return null;
		} else {
			// If it isn't an assignment, just visit it as usual.
			return super.visitStatement(ctx);
		}
	}

	@Override
	/**
	 * Generates the JBC for a (field) access on an assignable, e.g. car.brand.<br />
	 * Puts one value on the stack: either the value of the field or a reference to the object the field belongs to (depending on the value of {@link #inReadAccessToField}) 
	 */
	public Symbol visitAccessOnAssignable(AccessOnAssignableContext ctx) {
		if (this.inReadAccessToField) {
			// Get the field (leaves reference to object on the stack)
			visit(ctx.assignable());

			// Get the fieldAccessExpression node in the parsetree (it can't be an arrayAccess, cause that's not implemented yet)
			FieldAccessContext fieldAccess = (FieldAccessContext) ctx.access();

			// Get the type of object that is being accessed (so the type resulting from our left tree
			CompositeSymbol accessedObjectType = (CompositeSymbol) this.parseTreeproperty.get(fieldAccess);

			// Get the descriptor of that type
			String typeDescriptor = accessedObjectType.getDescriptor();

			// The name of the field that we are accessing
			String fieldName = fieldAccess.IDENTIFIER().getText();

			// Get the signature of the type resulting from the accessExpression
			String fieldTypeSignature = accessedObjectType.getFieldType(fieldName).getSignature();

			mv.visitFieldInsn(GETFIELD, typeDescriptor, fieldName, fieldTypeSignature);
		} else {
			// Give a reference to the object that contains the field (and that we're accessing right now)
			this.inReadAccessToField = true;
			visit(ctx.assignable()); // Leaves a reference to the object on the stack.
			this.inReadAccessToField = false;
		}

		return null;
	}

	/**
	 * Returns the VariableSymbol of the assignable (e.g. "x") visited, but does not produce JBC.
	 * 
	 * @param ctx
	 *            the node in the parsetree representing the basicAssignable
	 * @return the VariableSymbol corresponding to the variable that this assignable represents.
	 */
	public Symbol visitBasicAssignable(BasicAssignableContext ctx) {
		VariableSymbol variable = (VariableSymbol) this.parseTreeproperty.get(ctx);

		if (this.inReadAccessToField) {
			// We want the value
			if (this.isJBCPrimitive(variable.getReturnType())) {
				mv.visitIntInsn(ILOAD, variable.getMemAddr()); // Load the (primitive typed) value onto the stack
			} else {
				mv.visitIntInsn(ALOAD, variable.getMemAddr()); // Load the value onto the stack
			}
		} else {
			// We want the reference on the stack
			mv.visitIntInsn(ASTORE, variable.getMemAddr());
		}

		return null;
	}

	/**
	 * Assigns a value to one or more assignables (e.g. b := (1 + (x := 2)) = 3). Also leaves that value on the stack, so it can be used in an expression. If
	 * the assignment is used as a statement, the statement visitor pops the value.
	 * 
	 * @param ctx
	 *            the node in the parsetree representing the assignment
	 */
	public Symbol visitAssignment(AssignmentContext ctx) {
		// Zet de waarde van de expression op de stack (kunnen we zo gaan toewijzen)
		visit(ctx.expression()); // Stack: a ->

		for (int i = 0; i < ctx.assignable().size(); i++) { // Stack: a ->
			mv.visitInsn(DUP); // Stack: a a ->

			TypeSymbol type = (TypeSymbol) this.parseTreeproperty.get(ctx);
			this.storeValue(ctx.assignable(i), type);
		}

		return null;
	}

	@Override
	/**
	 * Produces the JBC to swap two assignables by pushing their values on the stack and assigning them again.
	 * If the assignables are not primitive, references are swapped rather than the values.
	 * @param ctx the node in the parsetree representing the swap
	 */
	public Symbol visitSwap(SwapContext ctx) {
		TypeSymbol assignableType = (TypeSymbol) this.parseTreeproperty.get(ctx);

		visit(ctx.assignable(0)); // Stack: val1
		visit(ctx.assignable(1)); // Stack: val1 val2

		this.storeValue(ctx.assignable(0), assignableType);
		this.storeValue(ctx.assignable(1), assignableType);

		return null;
	}

	/**
	 * Stores a value on the stack in an assignable, either by setting the reference or by setting a field.
	 * 
	 * @param assignable what (variable or variable field) we are assigning to
	 * @param assignableType what type we are assigning to it (INTEGER, STRING, PERSON, etc.)
	 */
	private void storeValue(AssignableContext assignable, TypeSymbol assignableType) {
		// Do we store a primitive type or a reference to an object?
		int storeOpCode = this.isJBCPrimitive(assignableType) ? ISTORE : ASTORE;

		// Let's check what the signature of the type is
		String fieldTypeSignature = assignableType.getSignature();

		if (assignable.children.size() == 1) { // It's a basicAssignable (no field access etc.)
			// Get the context
			BasicAssignableContext basicAssignableContext = (BasicAssignableContext) assignable;
			// Get the variable represented by the context
			VariableSymbol variable = (VariableSymbol) this.parseTreeproperty.get(basicAssignableContext);
			// Get the memory address of that variable
			int memAddr = variable.getMemAddr();
			// Store the value in that memory address
			mv.visitIntInsn(storeOpCode, memAddr);// Stack: val1
		} else {

			/* child 0 is an assignable, child 1 is an accessExpression. Child 1 of child 1 is an IDENTIFIER.
			 * 			assignable
			 * 	   (0) /          \ (1)
			 * assignable		accessExpression
			 *             (0) /                \ (1)
			 *               DOT		    IDENTIFIER
			 * 				
			 */
			// Get the type of whatever we're accessing
			CompositeSymbol type = (CompositeSymbol) this.parseTreeproperty.get(assignable.getChild(1));
			String compositeTypeDescriptor = type.getDescriptor();

			// Get the name of the field we're accessing
			String fieldName = assignable.getChild(1).getChild(1).getText();

			// Switch state to write access: we want the reference to the field instead!
			this.inReadAccessToField = false;
			visit(assignable); // Stack: val1 val2 ref1
			mv.visitInsn(SWAP); // Stack: val1 ref1 val2
			mv.visitFieldInsn(PUTFIELD, compositeTypeDescriptor, fieldName, fieldTypeSignature); // Stack: val1
			this.inReadAccessToField = true;
		}
	}

	@Override
	/**
	 * Generates the JBC code voor an equalsToExpression (1+1 = 2 = 3-1). Uses the {@link #visitMultipleComparisonExpression(int, ArithmeticContext[])} method, 
	 * just like the other integer comparators. This produces a lazy evaluation that compares two or more integers and puts a boolean on the stack.
	 * @param ctx the parsetree node representing the equalsToExpression
	 */
	public Symbol visitEqualsToExpression(EqualsToExpressionContext ctx) {
		// Maak een lijstje met alle "parameters"
		ArithmeticContext[] arithmeticContexts = new ArithmeticContext[ctx.arithmetic().size()];
		for (int i = 0; i < ctx.arithmetic().size(); i++) {
			arithmeticContexts[i] = ctx.arithmetic(i);
		}

		visitMultipleComparisonExpression(IF_ICMPEQ, arithmeticContexts);

		return null;
	}

	@Override
	/**
	 * Generates the JBC code voor an notEqualsToExpression (1+1 =/= 3 =/= 2). Uses the {@link #visitMultipleComparisonExpression(int, ArithmeticContext[])} method, 
	 * just like the other integer comparators. This produces a lazy evaluation that compares two or more integers and puts a boolean on the stack.
	 * @param ctx the parsetree node representing the notEqualsToExpression
	 */
	public Symbol visitNotEqualsToExpression(NotEqualsToExpressionContext ctx) {
		// Maak een lijstje met alle "parameters"
		ArithmeticContext[] arithmeticContexts = new ArithmeticContext[ctx.arithmetic().size()];
		for (int i = 0; i < ctx.arithmetic().size(); i++) {
			arithmeticContexts[i] = ctx.arithmetic(i);
		}

		visitMultipleComparisonExpression(IF_ICMPNE, arithmeticContexts);

		return null;
	}

	@Override
	/**
	 * Generates the JBC code voor a greaterThanExpression (3 > 2 > 1). Uses the {@link #visitMultipleComparisonExpression(int, ArithmeticContext[])} method, 
	 * just like the other integer comparators. This produces a lazy evaluation that compares two or more integers and puts a boolean on the stack.
	 * @param ctx the parsetree node representing the greaterThanExpression
	 */
	public Symbol visitGreaterThanExpression(GreaterThanExpressionContext ctx) {
		// Maak een lijstje met alle "parameters"
		ArithmeticContext[] arithmeticContexts = new ArithmeticContext[ctx.arithmetic().size()];
		for (int i = 0; i < ctx.arithmetic().size(); i++) {
			arithmeticContexts[i] = ctx.arithmetic(i);
		}

		visitMultipleComparisonExpression(IF_ICMPGT, arithmeticContexts);

		return null;
	}

	@Override
	/**
	 * Generates the JBC code voor a greaterThanEqualsToExpression (3 >= 2 >= 1+1). Uses the {@link #visitMultipleComparisonExpression(int, ArithmeticContext[])} method, 
	 * just like the other integer comparators. This produces a lazy evaluation that compares two or more integers and puts a boolean on the stack.
	 * @param ctx the parsetree node representing the greaterThanEqualsToExpression
	 */
	public Symbol visitGreaterThanEqualsToExpression(GreaterThanEqualsToExpressionContext ctx) {
		// Maak een lijstje met alle "parameters"
		ArithmeticContext[] arithmeticContexts = new ArithmeticContext[ctx.arithmetic().size()];
		for (int i = 0; i < ctx.arithmetic().size(); i++) {
			arithmeticContexts[i] = ctx.arithmetic(i);
		}

		visitMultipleComparisonExpression(IF_ICMPGE, arithmeticContexts);

		return null;
	}

	@Override
	/**
	 * Generates the JBC code voor a smallerThanExpression (1 < 2 < 3). Uses the {@link #visitMultipleComparisonExpression(int, ArithmeticContext[])} method, 
	 * just like the other integer comparators. This produces a lazy evaluation that compares two or more integers and puts a boolean on the stack.
	 * @param ctx the parsetree node representing the smallerThanExpression
	 */
	public Symbol visitSmallerThanExpression(SmallerThanExpressionContext ctx) {
		// Maak een lijstje met alle "parameters"
		ArithmeticContext[] arithmeticContexts = new ArithmeticContext[ctx.arithmetic().size()];
		for (int i = 0; i < ctx.arithmetic().size(); i++) {
			arithmeticContexts[i] = ctx.arithmetic(i);
		}

		visitMultipleComparisonExpression(IF_ICMPLT, arithmeticContexts);

		return null;
	}

	@Override
	/**
	 * Generates the JBC code voor a smallerThanEqualsToExpression (1 <= 2 <= 1+1). Uses the {@link #visitMultipleComparisonExpression(int, ArithmeticContext[])} method, 
	 * just like the other integer comparators. This produces a lazy evaluation that compares two or more integers and puts a boolean on the stack.
	 * @param ctx the parsetree node representing the smallerThanEqualsToExpression
	 */
	public Symbol visitSmallerThanEqualsToExpression(SmallerThanEqualsToExpressionContext ctx) {
		// Maak een lijstje met alle "parameters"
		ArithmeticContext[] arithmeticContexts = new ArithmeticContext[ctx.arithmetic().size()];
		for (int i = 0; i < ctx.arithmetic().size(); i++) {
			arithmeticContexts[i] = ctx.arithmetic(i);
		}

		visitMultipleComparisonExpression(IF_ICMPLE, arithmeticContexts);

		return null;
	}

	/**
	 * Generates a lazy evaluation comparison between two or more integers. Possible comparators are: <, <=, =, =/=, >= and >. Upon the first false value, the
	 * expression yields false. This function is used by the integer comparators.
	 */
	private void visitMultipleComparisonExpression(int comparisonOpCode, ArithmeticContext[] arithmeticContexts) {
		int complementOpCode = 0;

		/* We switchen op basis van de negatie (springen bij een false). We kunnen dus of normaal vergelijken, en dan de negatie pakken, of we vergelijken met
		 * de tegenovergestelde Opcode.
		 * Dit is de tweede optie; die spaart een negatie, omdat deze impliciet is door de comparator om te draaien.
		 * Dus i.p.v. if(! (a >b)) doen wij if(a <= b), omdat !(a>b) == a<=b
		 */
		switch (comparisonOpCode) {
		case IF_ICMPEQ:
			complementOpCode = IF_ICMPNE;
			break;
		case IF_ICMPGE:
			complementOpCode = IF_ICMPLT;
			break;
		case IF_ICMPGT:
			complementOpCode = IF_ICMPLE;
			break;
		case IF_ICMPLE:
			complementOpCode = IF_ICMPGT;
			break;
		case IF_ICMPLT:
			complementOpCode = IF_ICMPGE;
			break;
		case IF_ICMPNE:
			complementOpCode = IF_ICMPEQ;
			break;
		default:
			System.err.println("Invalid op code");
			System.exit(1);
		}

		// Put the first value on the stack
		visit(arithmeticContexts[0]); // Stack: a ->

		Label jumpIfFalseEncountered = new Label();

		// Skip the first; it's already on the stack. (start at i=1)
		for (int i = 1; i < arithmeticContexts.length; i++) {
			visit(arithmeticContexts[i]); // Stack: a b ->

			mv.visitInsn(DUP_X1); // Stack: b a b ->

			// If a > b (thus ! a <= b), jump to false
			mv.visitJumpInsn(complementOpCode, jumpIfFalseEncountered); // Stack: b ->
		}
		// If we made it this far without jumping to false, it means the expression yields true.
		// Pop the leftover b from the stack
		mv.visitInsn(POP);
		// Put true on the stack.
		mv.visitInsn(ICONST_1);

		Label endOfExpression = new Label();
		mv.visitJumpInsn(GOTO, endOfExpression);
		mv.visitFrame(Opcodes.F_APPEND, 3, new Object[] { Opcodes.INTEGER, Opcodes.INTEGER, Opcodes.INTEGER }, 0, null);

		// Jump to this label when the expression yields false.
		mv.visitLabel(jumpIfFalseEncountered);
		// Pop the leftover b from the stack
		mv.visitInsn(POP);
		// Put false on the stack
		mv.visitInsn(ICONST_0);

		// After putting true on the stack, we jump to this label to avoid putting both true and false on the stack.
		mv.visitLabel(endOfExpression);
		mv.visitFrame(Opcodes.F_SAME1, 0, null, 1, new Object[] { Opcodes.INTEGER });

	}

	/**
	 * Produces the JBC for comparing two non-int types (i.e. char, bool, enum or composite). Leaves one boolean value on the stack.
	 */
	public Symbol visitUniversalEqualsToExpression(UniversalEqualsToExpressionContext ctx) {
		TypeSymbol type = (TypeSymbol) this.parseTreeproperty.get(ctx);

		// Put both expressions on the stack.
		visit(ctx.expression(0));
		visit(ctx.expression(1));

		if (this.isJBCPrimitive(type)) {
			Label foundTrue = new Label();
			mv.visitJumpInsn(IF_ICMPEQ, foundTrue);
			// We didn't jump, so the values are not equal. Put false on the stack.
			mv.visitInsn(ICONST_0);
			Label end = new Label();
			// Avoid putting both false and true on the stack: jump to the end.
			mv.visitJumpInsn(GOTO, end);
			mv.visitLabel(foundTrue);
			// This is where we jump to if the values were equal!
			mv.visitFrame(Opcodes.F_APPEND, 1, new Object[] { Opcodes.INTEGER }, 0, null);
			mv.visitInsn(ICONST_1);
			mv.visitLabel(end);
			mv.visitFrame(Opcodes.F_SAME1, 0, null, 1, new Object[] { Opcodes.INTEGER });
		} else {
			// Compare using the default Java libraries...
			mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/Object", "equals", "(Ljava/lang/Object;)Z");
		}

		return null;
	}

	/**
	 * Produces the JBC for comparing two non-int types (i.e. char, bool, enum or composite). Leaves one boolean value on the stack.
	 */
	public Symbol visitUniversalNotEqualsToExpression(UniversalNotEqualsToExpressionContext ctx) {
		TypeSymbol type = (TypeSymbol) this.parseTreeproperty.get(ctx);

		// Put both expressions on the stack.
		visit(ctx.expression(0));
		visit(ctx.expression(1));

		if (this.isJBCPrimitive(type)) {
			Label foundTrue = new Label();
			mv.visitJumpInsn(IF_ICMPNE, foundTrue);
			// We didn't jump, so the values are equal. Put false on the stack.
			mv.visitInsn(ICONST_0);
			Label end = new Label();
			// Avoid putting both false and true on the stack: jump to the end.
			mv.visitJumpInsn(GOTO, end);
			mv.visitLabel(foundTrue);
			// This is where we jump to if the values were unequal!
			mv.visitFrame(Opcodes.F_APPEND, 1, new Object[] { Opcodes.INTEGER }, 0, null);
			mv.visitInsn(ICONST_1);
			mv.visitLabel(end);
			mv.visitFrame(Opcodes.F_SAME1, 0, null, 1, new Object[] { Opcodes.INTEGER });
		} else {
			// Compare using the default Java libraries...
			mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/Object", "equals", "(Ljava/lang/Object;)Z");
			// Zet 1 (true) op de stack
			mv.visitInsn(ICONST_1);
			// XOR -> (true XOR a) == NOT a
			mv.visitInsn(IXOR);
		}

		return null;
	}

	@Override
	/**
	 * Produces the JBC that pushes an integer literal on the stack. The checker has already verified whether it's the correct format and in the correct range.
	 */
	public Symbol visitIntegerLiteral(IntegerLiteralContext ctx) {
		int value = Integer.parseInt(ctx.getText());
		mv.visitLdcInsn(new Integer(value));
		return null;
	}

	@Override
	/**
	 * Produces the JBC that pushes an enum value (e.g. enumeration.day.MONDAY) on the stack. This value is represented as an integer.
	 * Enums are "limited" to 2^31 fields... so we should be ok for a while!
	 */
	public Symbol visitExplicitEnumerationLiteral(ExplicitEnumerationLiteralContext ctx) {
		EnumerationSymbol es = (EnumerationSymbol) this.parseTreeproperty.get(ctx);
		// In the format "enum.DAY.MONDAY", monday is the second IDENTIFIER (thus index 1)
		int fieldId = es.getFieldId(ctx.IDENTIFIER(1).getText());
		// Push it on the stack!
		mv.visitLdcInsn(new Integer(fieldId));

		return null;
	}

	/**
	 * Produces the JBC code for pushing a character on the stack. It also unescapes \n, \\ (an escaped backslash) and \' before pushing them onto the stack.
	 */
	public Symbol visitCharacterLiteral(CharacterLiteralContext ctx) {
		String character = ctx.CHARACTER().getText();

		character = character.replace("\\n", "\n"); // \n naar een echte linebreak
		character = character.replace("\\\\", "\\"); // \\ -> \
		character = character.replace("'\\''", "'''"); // \' -> '

		// 'c'.charAt(1) -> c
		int charCode = (int) character.charAt(1);

		mv.visitLdcInsn(new Integer(charCode));

		return null;
	}

	/**
	 * Produces the JBC that pushes a reference to a String literal onto the stack. It also unescapes \\, \n and \".
	 */
	public Symbol visitStringLiteral(StringLiteralContext ctx) {
		String s = ctx.getText();

		// Haal de " aan beide kanten weg
		s = (String) s.subSequence(1, s.length() - 1);

		// Vervang '\\' door '\', en \n door een linebreak
		s = s.replace("\\\\", "\\").replace("\\n", "\n").replace("\\\"", "\"");

		// Zet een pointer naar deze stringliteral op de stack
		mv.visitLdcInsn(s);

		return null;
	}

	/**
	 * Generates the JBC that pushes a boolean literal (0 or 1) on the stack.
	 */
	public Symbol visitBooleanLiteral(BooleanLiteralContext ctx) {
		if (ctx.BOOLEAN().getSymbol().getText().equals("true")) {
			mv.visitInsn(ICONST_1);
		} else {
			mv.visitInsn(ICONST_0);
		}
		return null;
	}

	@Override
	/**
	 * Generates the JBC that executes the two expressions, adds or subtracts their return values and pushes it on the stack.
	 */
	public Symbol visitAdditionExpression(AdditionExpressionContext ctx) {
		// Zet de linkerkant op de stack
		visit(ctx.arithmetic(0));
		// Zet de rechterkant op de stack
		visit(ctx.arithmetic(1));

		if (ctx.PLUS() != null) {
			mv.visitInsn(IADD);
		} else if (ctx.MINUS() != null) {
			mv.visitInsn(ISUB);
		}

		return null;
	}

	@Override
	/**
	 * Generates the JBC that executes the two expressions, multiplies, divides or takes the modulus of their return values and pushes it on the stack.
	 */
	public Symbol visitMultiplicationExpression(MultiplicationExpressionContext ctx) {
		// Zet de linkerkant op de stack
		visit(ctx.arithmetic(0));
		// Zet de rechterkant op de stack
		visit(ctx.arithmetic(1));

		if (ctx.MULTIPLICATION() != null) {
			mv.visitInsn(IMUL);
		} else if (ctx.MODULUS() != null) {
			mv.visitInsn(IREM);
		} else if (ctx.DIVISION() != null) {
			mv.visitInsn(IDIV);
		}

		return null;
	}

	@Override
	/**
	 * Generates the JBC that executes an expression, possibly changes its sign and pushes it on the stack.
	 */
	public Symbol visitSignExpression(SignExpressionContext ctx) {
		// Zet de linkerkant op de stack
		visit(ctx.arithmetic());

		if (ctx.MINUS() != null) {
			mv.visitInsn(INEG);
		}
		// De + doet niets (+2 == 2). Laten we maar geen assembly ervoor maken (OPTIMALISATIE!!! WOOHOOO)

		return null;
	}

	@Override
	/**
	 * Generates the JBC that executes two expressions and raises the return value of one to the return value of the other and pushes the result on the stack.
	 * If an int overflow occurs, MAX_INT is pushed on the stack.
	 */
	public Symbol visitPowerExpression(PowerExpressionContext ctx) {
		// Zet de base op de stack
		visit(ctx.arithmetic(0));
		// En maak er een double van:
		mv.visitInsn(I2D);

		// Zet de exponent op de stack
		visit(ctx.arithmetic(1));
		// En maak er een double van:
		mv.visitInsn(I2D);

		// Ga maar machtsverheffen (regelt Java intern voor ons)
		mv.visitMethodInsn(INVOKESTATIC, "java/lang/Math", "pow", "(DD)D");
		// En maak er weer een int van
		mv.visitInsn(D2I);

		return null;
	}

	@Override
	/**
	 * Generates the JBC that executes two expressions, performs a logical AND operation and pushes the result on the stack.
	 * The generated code is not lazy! So false & foo() will execute foo().
	 */
	public Symbol visitAndExpression(AndExpressionContext ctx) {
		// Zet boolean 1 op de stack
		visit(ctx.expression(0));

		// Zet boolean 2 op de stack
		visit(ctx.expression(1));

		mv.visitInsn(IAND);

		return null;
	}

	@Override
	/**
	 * Generates the JBC that executes two expressions, performs a logical OR operation and pushes the result on the stack.
	 * The generated code is not lazy! So true | foo() will execute foo().
	 */
	public Symbol visitOrExpression(OrExpressionContext ctx) {
		// Zet boolean 1 op de stack
		visit(ctx.expression(0));

		// Zet boolean 2 op de stack
		visit(ctx.expression(1));

		mv.visitInsn(IOR);

		return null;
	}

	@Override
	/**
	 * Generates the JBC that executes an expression, performs a logical NOT operation and pushes the result on the stack.
	 */
	public Symbol visitNotExpression(NotExpressionContext ctx) {
		// Zet boolean 1 op de stack
		visit(ctx.expression());

		// Zet 1 (true) op de stack
		mv.visitInsn(ICONST_1);
		// XOR -> true XOR a == NOT a
		mv.visitInsn(IXOR);

		return null;
	}

	@Override
	/**
	 * Opens a new scope for the block structure, and generates the JBC for that block.
	 */
	public Symbol visitBlockStructure(BlockStructureContext ctx) {
		this.openScope();
		for (int i = 0; i < ctx.statement().size(); i++) {
			visit(ctx.statement(i));
		}
		this.closeScope();
		return null;
	}

	/**
	 * Generates JBC for the ifStructure. It evaluates an expression, if the expression yields false it jumps to the else block. If there is no else block
	 * specified in the Bramspr code, then it isn't generated either.
	 */
	public Symbol visitIfStructure(IfStructureContext ctx) {
		boolean hasElseBlock = (ctx.ELSE() != null);

		// Eerst even kijken op basis waarvan we gaan beslissen.
		visit(ctx.expression()); // Stack: b ->

		// Als e false is, springen we hier naartoe.
		Label enfIfCode = new Label();
		// Als e true is, springen we na het uitvoeren van het if block hier naartoe
		Label endElse = new Label();

		// IFEQ zet ICONST_0 op de stack, en vergelijkt daarmee.
		// Eigenlijk is IFEQ dus IFNOTTRUE
		mv.visitJumpInsn(IFEQ, enfIfCode); // Stack: <empty>

		// Here is the if block
		visit(ctx.blockStructure(0));

		// If there is no else block, then we don't have to make this jump either!
		if (hasElseBlock) {
			mv.visitJumpInsn(GOTO, endElse); // Jump over the else block.
		}

		mv.visitLabel(enfIfCode);
		mv.visitFrame(Opcodes.F_APPEND, 1, new Object[] { Opcodes.INTEGER }, 0, null);

		// If there is no else specified, just skip generating the labels etc.
		if (hasElseBlock) {
			visit(ctx.blockStructure(1));
			mv.visitLabel(endElse);
			mv.visitFrame(Opcodes.F_SAME, 0, null, 0, null);
		}

		return null;
	}

	@Override
	/**
	 * Generates the JBC for a while structure. A while loop makes a jump back up every time the expression is evaluated and yields true.
	 * It leaves nothing on the stack.
	 */
	public Symbol visitWhileStructure(WhileStructureContext ctx) {
		// First iteration, we jump over the code to first evaluate the expression
		Label beforeExpression = new Label();
		mv.visitJumpInsn(GOTO, beforeExpression);

		// Jump back to this label at the end of every iteration
		Label beforeCode = new Label();
		mv.visitLabel(beforeCode);
		mv.visitFrame(Opcodes.F_APPEND, 1, new Object[] { Opcodes.INTEGER }, 0, null);

		// And this is the code that's being executed in the while loop
		visit(ctx.blockStructure());

		// Hier wordt de allereerste keer naartoe gesprongen.
		mv.visitLabel(beforeExpression);
		mv.visitFrame(Opcodes.F_SAME, 0, null, 0, null);

		// Execute the control expression
		visit(ctx.expression());

		// If the control expression yielded true, do another iteration.
		mv.visitJumpInsn(IFNE, beforeCode);

		return null;
	}

	/**
	 * Generates the JBC for a plusMinusExpression (7 = 10 +- 4). It evaluates three expressions, and leaves a single boolean value on the stack.
	 * 
	 * @param ctx
	 *            the node representing the plusMinusExpression
	 */
	public Symbol visitPlusMinusExpression(PlusMinusExpressionContext ctx) {
		Label earlyJump = new Label();
		Label midwayJump = new Label();
		Label finalJump = new Label();

		// @formatter:off
		/*
		 * This function performs some complicated operations because it is not allowed to evaluate an argument twice.
		 * The comments on the right show what the stack looks like after execution of the command on the line.
		 */
		// ASM code								       Stack (rechts is top)
		visit(ctx.arithmetic(1));					// e1
		visit(ctx.arithmetic(2));					// e1 e2
		mv.visitInsn(DUP2);							// e1 e2 e1 e2
		mv.visitInsn(ISUB);							// e1 e2 (e1 - e2)
		mv.visitInsn(DUP_X2);						// (e1 - e2) e1 e2 (e1 - e2)
		mv.visitInsn(POP);							// (e1 - e2) e1 e2
		mv.visitInsn(IADD);							// (e1 - e2) (e1 + e2)
		
		visit(ctx.arithmetic(0));					// (e1 - e2) (e1 + e2) e0
		
		mv.visitInsn(DUP_X1);					 	// (e1 - e2) e0 (e1 + e2) e0
		mv.visitJumpInsn(IF_ICMPLT, earlyJump);  	// (e1 - e2) e0
		mv.visitJumpInsn(IF_ICMPGT, midwayJump); 	// (e1 - e2) e0
		
		// It's in the right range! Set true on the stack, and jump to the end!
		mv.visitInsn(ICONST_1);						// true
		mv.visitJumpInsn(GOTO, finalJump); 			// true
		
		// Start of the code handling a statement resulting in false:
		mv.visitLabel(earlyJump);					// (e1 - e2) e0
		mv.visitFrame(Opcodes.F_APPEND, 1, new Object[] { Opcodes.INTEGER }, 0, null);
		mv.visitInsn(POP2);							// <empty stack>
		mv.visitLabel(midwayJump);					// <empty stack>
		mv.visitFrame(Opcodes.F_APPEND, 1, new Object[] { Opcodes.INTEGER }, 0, null);
		mv.visitInsn(ICONST_0);						// false
		
		// Everything ends here, leaving a true (1) or a false (0) on the stack
		mv.visitLabel(finalJump);					// true/false
		mv.visitFrame(Opcodes.F_SAME, 1, new Object[] { Opcodes.INTEGER }, 0, null);

		// @formatter:on

		return null;
	}

	@Override
	/**
	 * Produces the JBC for a function declaration. Because all functions are inlined for maximum performance, the declaration does not produce any JBC.
	 */
	public Symbol visitFunctionDeclaration(FunctionDeclarationContext ctx) {
		// Functions are inlined, so the declaration does not produce new ASM code.
		return null;
	}

	/**
	 * Produces the JBC for a functioncall. Because functions are inlined, it uses the declaration for code generation. Thus, the produced JBC is effectively a
	 * new block with some default variables and a return value. Note that the bindings still refer to the bindings as they were during the declaration of the
	 * function.
	 */
	public Symbol visitFunctionCall(FunctionCallContext ctx) {
		FunctionSymbol function = (FunctionSymbol) this.parseTreeproperty.get(ctx);

		// Open a new scope
		this.openScope();

		// The "primitive" functions have a null context!
		if (function.declarationContext == null) {

			// Is it one of the put, or one of the get functions?
			if (ctx.IDENTIFIER().getText().startsWith("put")) {
				// It's a put function!
				mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
				visit(ctx.expression(0));

				if (ctx.IDENTIFIER().getText().equals("putString")) {
					mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "print", "(Ljava/lang/String;)V");
				} else if (ctx.IDENTIFIER().getText().equals("putInt")) {
					mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "print", "(I)V");
				} else if (ctx.IDENTIFIER().getText().equals("putChar")) {
					mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "print", "(C)V");
				} else if (ctx.IDENTIFIER().getText().equals("putBool")) {
					mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "print", "(Z)V");
				} else {
					System.err.println("Attempting to invoke invalid primitive function!");
					System.exit(1);
				}
			} else {
				mv.visitTypeInsn(NEW, "java/util/Scanner");
				mv.visitInsn(DUP);
				mv.visitFieldInsn(GETSTATIC, "java/lang/System", "in", "Ljava/io/InputStream;");
				mv.visitMethodInsn(INVOKESPECIAL, "java/util/Scanner", "<init>", "(Ljava/io/InputStream;)V");

				if (ctx.IDENTIFIER().getText().equals("getString")) {
					mv.visitMethodInsn(INVOKEVIRTUAL, "java/util/Scanner", "nextLine", "()Ljava/lang/String;");
				} else if (ctx.IDENTIFIER().getText().equals("getInt")) {
					mv.visitMethodInsn(INVOKEVIRTUAL, "java/util/Scanner", "nextInt", "()I");
				} else if (ctx.IDENTIFIER().getText().equals("getChar")) {
					// Laad een string op de stack
					mv.visitMethodInsn(INVOKEVIRTUAL, "java/util/Scanner", "next", "()Ljava/lang/String;");
					mv.visitInsn(ICONST_0);
					// Neem het eerste character van die string (index = 0)
					mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/String", "charAt", "(I)C");
				} else if (ctx.IDENTIFIER().getText().equals("getBool")) {
					mv.visitMethodInsn(INVOKEVIRTUAL, "java/util/Scanner", "nextBoolean", "()Z");
				} else {
					System.err.println("Attempting to invoke invalid primitive function!");
					System.exit(1);
				}
			}

		} else {

			// This contains the function code!
			FunctionDeclarationContext declaration = function.declarationContext;

			// @formatter:off
		
			// Hier kan een identifier gezien worden als variabele, de eerste IDENTIFIER is de naam van de functie.
			for (int i = 0; i < ctx.expression().size(); i++) {
				// Copied from assignmentExpression
				VariableSymbol varsymbol = (VariableSymbol) this.parseTreeproperty.get(declaration.IDENTIFIER(i + 1));
				int memAddr = this.claimMemAddr(varsymbol);
				visit(ctx.expression(i));
				TypeSymbol type = function.parameters[i];
				if (type.equals(BramsprChecker.INTEGER)) {
					mv.visitIntInsn(ISTORE, memAddr); // Stack: a ->
				} else if (type.equals(BramsprChecker.CHARACTER)) {
					mv.visitIntInsn(ISTORE, memAddr); // Stack: a ->
				} else if (type.equals(BramsprChecker.BOOLEAN)) {
					mv.visitIntInsn(ISTORE, memAddr); // Stack: a ->
				} else if (type.equals(BramsprChecker.STRING)) {
					mv.visitIntInsn(ASTORE, memAddr); // Stack: a ->
				} else if (type instanceof EnumerationSymbol) {
					// Enums are stored as ints
					mv.visitIntInsn(ISTORE, memAddr); // Stack: a ->
				} else {
					System.err.println("Invalid assignment; unimplemented type!");
					System.exit(1);
				}
			}
		
			// Adds JBC code from stuff inside the function.
			for (int i = 0; i < declaration.statement().size(); i++) {
				visit(declaration.statement(i));
			}
			
			if(declaration.RETURN() != null) {
				// Dit is het return statement; laat een waarde achter op de stack
				visit(declaration.expression());
			}
		}
		
		this.closeScope();
		// @formatter:on

		return null;
	}

	/**
	 * Visits a possible enumeration; this is either an fieldaccess or an enumeration. If it is an enumeration, this function puts one int value on the stack.
	 * If it is a field access, the value of the field is put on the stack (since a potentialEnumerationLiteral is always read access, never write access).
	 * 
	 * @param ctx
	 *            either a field access or an enumeration.
	 */
	@Override
	public Symbol visitPotentialEnumerationLiteral(PotentialEnumerationLiteralContext ctx) {
		Symbol symbol = this.parseTreeproperty.get(ctx);
		String fieldName = ctx.IDENTIFIER(1).getText();

		if (symbol instanceof EnumerationSymbol) {
			EnumerationSymbol es = (EnumerationSymbol) this.parseTreeproperty.get(ctx);
			// in the format "day.MONDAY", monday is the second IDENTIFIER (thus index 1)
			int fieldId = es.getFieldId(fieldName);

			mv.visitIntInsn(BIPUSH, fieldId);
		} else {
			// It's not an enumeration, so it has to be a field access on a variable of a user-defined type (it has fields)
			VariableSymbol variable = (VariableSymbol) symbol;
			int memAddr = variable.getMemAddr();
			mv.visitIntInsn(ALOAD, memAddr); // Puts the reference to this variable on the stack

			// We have the reference to the composite, now read the field!
			CompositeSymbol returnType = (CompositeSymbol) variable.getReturnType();
			String typeClassDescriptor = returnType.getDescriptor();
			String returnTypeSignature = returnType.getFieldType(fieldName).getSignature();
			// Awesome! Now that we know that, put the value on the stack:
			mv.visitFieldInsn(GETFIELD, typeClassDescriptor, fieldName, returnTypeSignature);
		}

		return null;
	}

	/** The number of currently defined types in the program. */
	int numberOfTypes = 0;

	@Override
	/**
	 * Creates a new inner class to store the information of the composite.
	 */
	public Symbol visitCompositeDeclaration(CompositeDeclarationContext ctx) {
		/** Symbol denoting the type we're declaring here */
		CompositeSymbol symbol = (CompositeSymbol) this.parseTreeproperty.get(ctx);
		/** e.g. CA */
		String innerClassName = symbol.setDescriptor(this.mainFileName, this.numberOfTypes);
		/** e.g. Bramspr$CA */
		String fileName = symbol.getDescriptor();

		// Before we create the inner class, we have to visit it first
		this.tcw.visitInnerClass(symbol.getDescriptor(), this.mainFileName, innerClassName, ACC_PUBLIC);

		// Now we can start creating the inner class. Note that this uses new writers!
		ClassWriter innerCW = new ClassWriter(ClassWriter.COMPUTE_MAXS | ClassWriter.COMPUTE_FRAMES);
		FieldVisitor innerFV;
		MethodVisitor innerMV;

		innerCW.visit(V1_7, ACC_SUPER | ACC_PUBLIC, fileName, null, "java/lang/Object", null);
		innerCW.visitInnerClass(fileName, this.mainFileName, innerClassName, ACC_PUBLIC);

		for (Entry<String, TypeSymbol> field : symbol.fields.entrySet()) { // Repeat:
			String fieldName = field.getKey();
			TypeSymbol fieldType = field.getValue();

			innerFV = innerCW.visitField(ACC_PUBLIC, fieldName, fieldType.getSignature(), null, null);
			innerFV.visitEnd();
		}

		{
			innerFV = innerCW.visitField(ACC_FINAL + ACC_SYNTHETIC, "this$0", "L" + this.mainFileName + ";", null, null);
			innerFV.visitEnd();
		}

		{
			// Thanks to AMSifier;
			innerMV = innerCW.visitMethod(ACC_PUBLIC, "<init>", "(L" + this.mainFileName + ";)V", null, null);
			innerMV.visitCode();
			Label l0 = new Label();
			innerMV.visitLabel(l0);
			innerMV.visitLineNumber(4, l0);
			innerMV.visitVarInsn(ALOAD, 0);
			innerMV.visitVarInsn(ALOAD, 1);
			innerMV.visitFieldInsn(PUTFIELD, fileName, "this$0", "L" + this.mainFileName + ";");
			innerMV.visitVarInsn(ALOAD, 0);
			innerMV.visitMethodInsn(INVOKESPECIAL, "java/lang/Object", "<init>", "()V");
			innerMV.visitInsn(RETURN);
			Label l3 = new Label();
			innerMV.visitLabel(l3);
			innerMV.visitLocalVariable("this", "L" + fileName + ";", null, l0, l3, 0);
			innerMV.visitMaxs(2, 2);
			innerMV.visitEnd();
		}
		innerCW.visitEnd();

		byte[] bytecode = innerCW.toByteArray();
		// Save this for later:
		BramsprClass newType = new BramsprClass(fileName, bytecode);
		this.classes.add(newType);

		this.numberOfTypes++;

		return null;
	}

	/**
	 * Generates the JBC for a (field) access on an atomic, e.g. foo().numerOfWheels.<br />
	 * Puts one value on the stack: either the value of the field or a reference to the object the field belongs to (depending on the value of {@link #inReadAccessToField}) 
	 */
	@Override
	public Symbol visitAccessOnAtomicExpression(AccessOnAtomicExpressionContext ctx) {
		if (this.inReadAccessToField) {
			// Get the field (leaves reference to object on the stack)
			visit(ctx.atomic());

			// Get the fieldAccessExpression node in the parsetree (it can't be an arrayAccess, cause that's not implemented yet)
			FieldAccessContext fieldAccess = (FieldAccessContext) ctx.access();

			// Get the type of object that is being accessed (so the type resulting from our left tree
			CompositeSymbol accessedObjectType = (CompositeSymbol) this.parseTreeproperty.get(fieldAccess);

			// Get the descriptor of that type
			String typeDescriptor = accessedObjectType.getDescriptor();

			// The name of the field that we are accessing
			String fieldName = fieldAccess.IDENTIFIER().getText();

			// Get the signature of the type resulting from the accessExpression
			String fieldTypeSignature = accessedObjectType.getFieldType(fieldName).getSignature();

			mv.visitFieldInsn(GETFIELD, typeDescriptor, fieldName, fieldTypeSignature);
		} else {
			// Give a reference to the object that contains the field (and that we're accessing right now)
			this.inReadAccessToField = true;
			visit(ctx.atomic()); // Leaves a reference to the object on the stack.
			this.inReadAccessToField = false;
		}
		return null;
	}

	/**
	 * Generates the JBC for a composite literal. Creates a new instantion of the class belonging to the composite and set
	 */
	public Symbol visitCompositeLiteral(CompositeLiteralContext ctx) {
		CompositeSymbol type = (CompositeSymbol) this.parseTreeproperty.get(ctx);

		// Create the new object
		mv.visitTypeInsn(NEW, type.getDescriptor());
		mv.visitInsn(DUP);
		mv.visitVarInsn(ALOAD, 1);
		mv.visitInsn(DUP);
		mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/Object", "getClass", "()Ljava/lang/Class;");
		mv.visitInsn(POP);
		mv.visitMethodInsn(INVOKESPECIAL, type.getDescriptor(), "<init>", "(L" + this.mainFileName + ";)V");
		// There now is a reference to the instantiated object on the stack

		// Note: the identifier index is always one ahead of the expression index.
		for (int i = 0; i < ctx.expression().size(); i++) {
			// Copy the reference
			mv.visitInsn(DUP);

			visit(ctx.expression(i));
			String fieldName = ctx.IDENTIFIER(i + 1).getText();
			TypeSymbol fieldType = type.getFieldType(fieldName);

			// Put the value in the field.
			mv.visitFieldInsn(PUTFIELD, type.getDescriptor(), fieldName, fieldType.getSignature());
		}

		return null;
	}

	/**
	 * Tests whether a type is a JBC primitive. The JBC primitives are (as far as we're concerned) integer, boolean, character and enumerations. Note that
	 * doubles etc. are not part of our language. These "primitives" are all stored as int values, and can be handled with the I functions, e.g. ISTORE, IADD,
	 * etc.
	 * 
	 * @param type
	 *            the type to be checked
	 * @return true iff type is an enum, integer, character or boolean
	 */
	private boolean isJBCPrimitive(TypeSymbol type) {
		if (type.equals(BramsprChecker.INTEGER)) {
			return true;
		}
		if (type.equals(BramsprChecker.CHARACTER)) {
			return true;
		}
		if (type.equals(BramsprChecker.BOOLEAN)) {
			return true;
		}
		if (type instanceof EnumerationSymbol) {
			return true;
		}

		return false;
	}

	/**
	 * This class is only used to store a classname - bytecode pair, since Java does not have a pair class.
	 */
	public class BramsprClass {
		public String className;
		public byte[] bytecode;

		public BramsprClass(String className, byte[] bytecode) {
			this.className = className;
			this.bytecode = bytecode;
		}
	}
}
