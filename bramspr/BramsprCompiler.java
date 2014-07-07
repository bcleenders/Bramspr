package bramspr;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.util.TraceClassVisitor;

import bramspr.BramsprParser.*;
import bramspr.symboltable.CompositeSymbol;
import bramspr.symboltable.EnumerationSymbol;
import bramspr.symboltable.FunctionSymbol;
import bramspr.symboltable.Symbol;
import bramspr.symboltable.TypeSymbol;
import bramspr.symboltable.VariableSymbol;

//public class BramsprCompiler implements BramsprVisitor<Integer> {
public class BramsprCompiler extends BramsprBaseVisitor<Symbol> implements Opcodes {

	private ParseTreeProperty<Symbol> parseTreeproperty;
	TraceClassVisitor tcw;
	FieldVisitor fv;
	MethodVisitor mv;

	/**
	 * Contains the last label of every scope we have visited. Grows one every time a scope is opened. These labels are used in the elements of
	 * {@link #variables} as closing scopes.
	 */
	private Stack<Label> closingScopeLabels = new Stack<Label>();

	/**
	 * Opens a new scope (reserves a closing label)
	 * 
	 * @ensures this.closingScopeLabels.size() = old.closingScopeLabels.size() + 1
	 */
	private void openScope() {
		this.closingScopeLabels.push(new Label());
	}

	/**
	 * Closes a scope by popping and writing a scope from the closingScopeLabels stack to assembly
	 */
	private void closeScope() {
		Label closingLabel = this.closingScopeLabels.pop();
		mv.visitLabel(closingLabel);
	}

	/**
	 * Maintains a list of the variables we have visited. Stores name, type, opening_label, closing_label (excl.) This allows us to do a massive
	 * mv.visitLocalVariable(...) iteration at the end of the class, to declare the variables.
	 */
	private ArrayList<VariableSymbol> variables = new ArrayList<VariableSymbol>();

	public BramsprCompiler() {

	}

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

	public byte[] compile(ParseTree tree, ParseTreeProperty<Symbol> ptp) throws Exception {
		// De ClassWriter is niet toegankelijk voor andere functies; werk via de TraceClassVisitor
		ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS | ClassWriter.COMPUTE_FRAMES);
		this.tcw = new TraceClassVisitor(cw, new PrintWriter(System.out));
		this.parseTreeproperty = ptp;

		this.tcw.visit(V1_7, ACC_PUBLIC + ACC_SUPER, "Bramspr", null, "java/lang/Object", null);

		{
			mv = this.tcw.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
			mv.visitCode();
			Label startLabel = new Label();
			mv.visitLabel(startLabel);
			mv.visitLineNumber(0, startLabel);
			mv.visitVarInsn(ALOAD, 0);
			mv.visitMethodInsn(INVOKESPECIAL, "java/lang/Object", "<init>", "()V");

			mv.visitInsn(RETURN);
			Label endLabel = new Label();
			mv.visitLabel(endLabel);
			mv.visitLocalVariable("this", "LBramspr;", null, startLabel, endLabel, 0);
			mv.visitMaxs(2, 1);
			mv.visitEnd();
		}

		// eval method
		mv = this.tcw.visitMethod(ACC_PUBLIC + ACC_STATIC, "main", "([Ljava/lang/String;)V", null, null);
		mv.visitCode();

		this.openScope();
		// Dit start het compilen van de code!
		visit(tree);
		this.closeScope();

		// Nu nog even de variabelen declareren (incl. scope!)
		for (int i = 0; i < this.variables.size(); i++) {
			VariableSymbol var = this.variables.get(i);

			TypeSymbol type = var.getReturnType();
			String signature = null;

			if (type instanceof CompositeSymbol) {
				signature = ((CompositeSymbol) type).getShortIdentifier();
			} else if (type instanceof EnumerationSymbol) {
				signature = "I"; // Enums are represented as integer values, allowing easy comparisons.
			} else {
				System.err.println("Unknown type at variable declaration.");
				System.exit(1);
			}

			mv.visitLocalVariable(var.getIdentifier(), signature, null, var.openingLabel, var.closingLabel, var.getNumber());
		}

		mv.visitInsn(RETURN);
		// max stack and max locals automatically computed (COMPUTE_MAXS)
		mv.visitMaxs(0, 0);
		mv.visitEnd();

		byte[] code = cw.toByteArray();
		return code;
	}

	public Symbol visitPureDeclaration(PureDeclarationContext ctx) {
		// Alle IDENTIFIER's binnen deze declaration komen in de parsetreeproperty voor, en ze bevatten de VariableSymbol's

		Label openingLabel = new Label();
		Label closingLabel = this.closingScopeLabels.peek();

		for (int i = 0; i < ctx.IDENTIFIER().size(); i++) {
			VariableSymbol symbol = (VariableSymbol) this.parseTreeproperty.get(ctx.IDENTIFIER(i));
			symbol.setOpenCloseLabels(openingLabel, closingLabel);
			this.variables.add(symbol);

			TypeSymbol type = symbol.getReturnType();

			// Geef primitieve types hun standaard waarden.
			if (type.equals(BramsprChecker.INTEGER)) {
				// Integers beginnen bij 0
				mv.visitInsn(ICONST_0);
				mv.visitIntInsn(ISTORE, symbol.getNumber());
			} else if (type.equals(BramsprChecker.BOOLEAN)) {
				// Booleans beginnen als false
				mv.visitInsn(ICONST_0);
				mv.visitIntInsn(ISTORE, symbol.getNumber());
			} else if (type.equals(BramsprChecker.CHARACTER)) {
				// Characters beginnen als a
				int charCode = (int) 'a';
				mv.visitIntInsn(BIPUSH, charCode);
				mv.visitIntInsn(ISTORE, symbol.getNumber());
			} else if (type.equals(BramsprChecker.STRING)) {
				mv.visitLdcInsn("");
				mv.visitVarInsn(ASTORE, symbol.getNumber());
			}
		}

		// Vanaf hier mogen de variabelen gebruikt worden.
		mv.visitLabel(openingLabel);

		return null;
	}

	@Override
	public Symbol visitInstantiatingDeclaration(InstantiatingDeclarationContext ctx) {
		Label openingLabel = new Label();
		Label closingLabel = this.closingScopeLabels.peek();

		// Laten we iig alvast even kijken wat er op de stack moet komen te staan:
		visit(ctx.expression()); // Stack: a ->

		for (int i = 0; i < ctx.IDENTIFIER().size(); i++) {
			VariableSymbol symbol = (VariableSymbol) this.parseTreeproperty.get(ctx.IDENTIFIER(i));
			symbol.setOpenCloseLabels(openingLabel, closingLabel);
			this.variables.add(symbol);

			TypeSymbol type = symbol.getReturnType();
			int memAddr = symbol.getNumber();

			// Even kopi�ren, anders zijn we het zo kwijt!
			mv.visitInsn(DUP);

			if (this.isJBCPrimitive(type)) {
				// Mooi; dit kunnen we assigned met ISTORE
				mv.visitIntInsn(ISTORE, memAddr);
			} else {
				mv.visitIntInsn(ASTORE, memAddr);
			}
		}

		// Er stond er nog ��n op de stack... haal maar weg!
		mv.visitInsn(POP);

		// Vanaf hier mogen de variabelen gebruikt worden.
		mv.visitLabel(openingLabel);

		return null;
	}

	@Override
	/**
	 * Produces the JBC for a statement. A statement leaves no additional values on the stack.
	 * @param ctx the context of the statement.
	 */
	public Symbol visitStatement(StatementContext ctx) {
		if (ctx.assignment() != null) {
			visitAssignment(ctx.assignment());
			// Assignments leave something on the stack; statements should not do that so we have to POP it.
			mv.visitInsn(POP);
			return null;
		} else {
			return super.visitStatement(ctx);
		}
	}

	/**
	 * Geeft het Symbol terug van de assignable die hier gevisit wordt. Zet niets op de stack.
	 */
	public Symbol visitBasicAssignable(BasicAssignableContext ctx) {
		// Een basicAssignable is eigenlijk een variabele; geef deze maar terug (bevat mem. address en type info)
		VariableSymbol variable = (VariableSymbol) this.parseTreeproperty.get(ctx);

		// System.out.println("var " + variable.getIdentifier() + " is at memory position " + variable.getNumber() + ".");

		return variable;
	}

	/**
	 * Let op; een assignment is een expression, en laat dus een waarde op de stack staan!
	 */
	public Symbol visitAssignment(AssignmentContext ctx) {
		// Zet de waarde van de expression op de stack (kunnen we zo gaan toewijzen)
		visit(ctx.expression()); // Stack: a ->

		for (int i = 0; i < ctx.assignable().size(); i++) {
			mv.visitInsn(DUP); // Stack: a a ->

			VariableSymbol assignable = (VariableSymbol) visit(ctx.assignable(i));
			int memaddr = assignable.getNumber();

			TypeSymbol type = assignable.getReturnType();

			if (this.isJBCPrimitive(type)) {
				mv.visitIntInsn(ISTORE, memaddr); // Stack: a ->
			} else if (type.equals(BramsprChecker.STRING)) {
				mv.visitIntInsn(ASTORE, memaddr); // Stack: a ->
			} else {
				System.err.println("Invalid assignment; unimplemented type!");
				System.exit(1);
			}
		}

		return null;
	}

	public Symbol visitAssignableExpression(AssignableExpressionContext ctx) {
		VariableSymbol variable = (VariableSymbol) visit(ctx.assignable());
		TypeSymbol type = variable.getReturnType();

		if (this.isJBCPrimitive(type)) {
			mv.visitIntInsn(ILOAD, variable.getNumber());
		} else if (variable.getReturnType().equals(BramsprChecker.STRING)) {
			mv.visitIntInsn(ALOAD, variable.getNumber());
		}

		return null;
	}

	@Override
	/**
	 * Produces the JBC to swap two assignables.
	 * If the assignables are not primitive, references are swapped rather than the values.
	 */
	public Symbol visitSwap(SwapContext ctx) {
		VariableSymbol x = (VariableSymbol) visit(ctx.assignable(0));
		VariableSymbol y = (VariableSymbol) visit(ctx.assignable(1));
		TypeSymbol type = x.getReturnType();

		int memAddrX = x.getNumber();
		int memAddrY = y.getNumber();

		if (this.isJBCPrimitive(type)) { // Het is een int/bool/char/enum!
			mv.visitIntInsn(ILOAD, memAddrX); // Stack: x ->
			mv.visitIntInsn(ILOAD, memAddrY); // Stack: x y ->
			mv.visitIntInsn(ISTORE, memAddrX); // Stack: x ->
			mv.visitIntInsn(ISTORE, memAddrY); // Stack: ->
		} else { // Het is een object (-achtig iets)
			// Helaas, we kunnen niet gewoon de waarde pakken. Gelukkig kunnen we wel de referentie wisselen!
			mv.visitIntInsn(ALOAD, memAddrX); // Stack: x ->
			mv.visitIntInsn(ALOAD, memAddrY); // Stack: x y ->
			mv.visitIntInsn(ASTORE, memAddrX); // Stack: x ->
			mv.visitIntInsn(ASTORE, memAddrY); // Stack: ->
		}

		return null;
	}
	
	@Override
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
	 * Genereert lazy evaluation voor vergelijkingen tussen meerdere integer waardes
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

		// Zet de eerste waarde op de stack
		visit(arithmeticContexts[0]); // Stack is nu a ->

		Label jumpIfFalseEncountered = new Label();

		// Skip de eerste; die staat al op de stack!
		for (int i = 1; i < arithmeticContexts.length; i++) {
			visit(arithmeticContexts[i]); // Stack is nu a b ->

			mv.visitInsn(DUP_X1); // Stack is nu b a b ->

			// Als a > b (dus ! a <= b), jump dan naar de false state.
			mv.visitJumpInsn(complementOpCode, jumpIfFalseEncountered); // Stack is nu b ->
		}

		// Er staat nu nog een b op de stack; pop die.
		mv.visitInsn(POP);
		// De uitkomst is true; zet een 1 op de stack
		mv.visitInsn(ICONST_1);

		Label endOfExpression = new Label();
		mv.visitJumpInsn(GOTO, endOfExpression);
		mv.visitFrame(Opcodes.F_APPEND, 3, new Object[] { Opcodes.INTEGER, Opcodes.INTEGER, Opcodes.INTEGER }, 0, null);

		// Label waar naartoe gejumpt wordt bij een true
		mv.visitLabel(jumpIfFalseEncountered);
		// Er staat nog wel een b op de stack; pop die.
		mv.visitInsn(POP);
		// De uitkomst is false; zet een 0 op de stack
		mv.visitInsn(ICONST_0);

		// Hier wordt naartoe gesprongen als er false uitkomt (jump over de true heen)
		mv.visitLabel(endOfExpression);
		mv.visitFrame(Opcodes.F_SAME1, 0, null, 1, new Object[] { Opcodes.INTEGER });

	}
	
	/**
	 * Produces the JBC for comparing two non-int types (i.e. char, bool, enum or composite).
	 * Leaves one boolean value on the stack.
	 * @param ctx
	 * @return
	 */
	public Symbol visitUniversalEqualsToExpression(UniversalEqualsToExpressionContext ctx) {
		TypeSymbol type = (TypeSymbol) this.parseTreeproperty.get(ctx);
		
		// Put both expressions on the stack.
		visit(ctx.expression(0));
		visit(ctx.expression(1));
		
		if(this.isJBCPrimitive(type)) {
			Label foundTrue = new Label();
			mv.visitJumpInsn(IF_ICMPEQ, foundTrue);
			// We didn't jump, so the values are not equal. Put false on the stack.
			mv.visitInsn(ICONST_0);
			Label end = new Label();
			// Avoid putting both false and true on the stack: jump to the end.
			mv.visitJumpInsn(GOTO, end);
			mv.visitLabel(foundTrue);
			// This is where we jump to if the values were equal!
			mv.visitFrame(Opcodes.F_APPEND,1, new Object[] {Opcodes.INTEGER}, 0, null);
			mv.visitInsn(ICONST_1);
			mv.visitLabel(end);
			mv.visitFrame(Opcodes.F_SAME1, 0, null, 1, new Object[] {Opcodes.INTEGER});
		} else {
			// Compare using the default Java libraries...
			mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/Object", "equals", "(Ljava/lang/Object;)Z");
		}
		
		return null;
	}
	
	/**
	 * Produces the JBC for comparing two non-int types (i.e. char, bool, enum or composite).
	 * Leaves one boolean value on the stack.
	 * @param ctx
	 * @return
	 */
	public Symbol visitUniversalNotEqualsToExpression(UniversalNotEqualsToExpressionContext ctx) {
		TypeSymbol type = (TypeSymbol) this.parseTreeproperty.get(ctx);
		
		// Put both expressions on the stack.
		visit(ctx.expression(0));
		visit(ctx.expression(1));
		
		if(this.isJBCPrimitive(type)) {
			Label foundTrue = new Label();
			mv.visitJumpInsn(IF_ICMPNE, foundTrue);
			// We didn't jump, so the values are equal. Put false on the stack.
			mv.visitInsn(ICONST_0);
			Label end = new Label();
			// Avoid putting both false and true on the stack: jump to the end.
			mv.visitJumpInsn(GOTO, end);
			mv.visitLabel(foundTrue);
			// This is where we jump to if the values were unequal!
			mv.visitFrame(Opcodes.F_APPEND,1, new Object[] {Opcodes.INTEGER}, 0, null);
			mv.visitInsn(ICONST_1);
			mv.visitLabel(end);
			mv.visitFrame(Opcodes.F_SAME1, 0, null, 1, new Object[] {Opcodes.INTEGER});
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

	public Symbol visitIntegerLiteral(IntegerLiteralContext ctx) {
		int value = Integer.parseInt(ctx.getText());
		mv.visitIntInsn(BIPUSH, value);
		return null;
	}

	@Override
	public Symbol visitExplicitEnumerationLiteral(ExplicitEnumerationLiteralContext ctx) {
		EnumerationSymbol es = (EnumerationSymbol) this.parseTreeproperty.get(ctx);
		// in the format "enum.DAY.MONDAY", monday is the second IDENTIFIER (thus index 1)
		int fieldId = es.getFieldId(ctx.IDENTIFIER(1).getText());

		// System.out.println("field id is " + fieldId);

		mv.visitIntInsn(BIPUSH, fieldId);

		return null;
	}

	public Symbol visitCharacterLiteral(CharacterLiteralContext ctx) {
		String character = ctx.CHARACTER().getText();
		
		// Ont-escape het maar:
		character = character.replace("\\n", "\n"); // \n naar een echte linebreak
		character = character.replace("\\\\", "\\"); // \\ -> \
		character = character.replace("'\\''", "'''"); // \' -> '
		
		// 'c'.charAt(1) -> c
		int charCode = (int) character.charAt(1);

		mv.visitIntInsn(BIPUSH, charCode);

		return null;
	}

	public Symbol visitStringLiteral(StringLiteralContext ctx) {
		String s = ctx.getText();

		// Haal de " aan beide kanten weg
		s = (String) s.subSequence(1, s.length() - 1);

		// Vervang '\\' door '\', en \n door een linebreak
		s = s.replace("\\\\", "\\").replace("\\n", "\n");

		// Zet een pointer naar deze stringliteral op de stack
		mv.visitLdcInsn(s);

		return null;
	}

	public Symbol visitBooleanLiteral(BooleanLiteralContext ctx) {
		if (ctx.BOOLEAN().getSymbol().getText().equals("true")) {
			mv.visitInsn(ICONST_1);
		} else {
			mv.visitInsn(ICONST_0);
		}
		return null;
	}

	@Override
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
	public Symbol visitAndExpression(AndExpressionContext ctx) {
		// Zet boolean 1 op de stack
		visit(ctx.expression(0));

		// Zet boolean 2 op de stack
		visit(ctx.expression(1));

		mv.visitInsn(IAND);

		return null;
	}

	@Override
	public Symbol visitOrExpression(OrExpressionContext ctx) {
		// Zet boolean 1 op de stack
		visit(ctx.expression(0));

		// Zet boolean 2 op de stack
		visit(ctx.expression(1));

		mv.visitInsn(IOR);

		return null;
	}

	@Override
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
	public Symbol visitBlockStructure(BlockStructureContext ctx) {
		this.openScope();
		for (int i = 0; i < ctx.statement().size(); i++) {
			visit(ctx.statement(i));
		}
		this.closeScope();
		return null;
	}

	public Symbol visitIfStructure(IfStructureContext ctx) {
		boolean hasElseBlock = (ctx.ELSE() != null);

		// Eerst even kijken op basis waarvan we gaan beslissen.
		visit(ctx.expression()); // Stack: b ->

		// Als e false is, springen we hier naartoe.
		Label startElse = new Label();
		// Als e true is, springen we na het uitvoeren van het if block hier naartoe
		Label endElse = new Label();

		// IFEQ zet ICONST_0 op de stack, en vergelijkt daarmee.
		// Eigenlijk is IFEQ dus IFNOTTRUE
		mv.visitJumpInsn(IFEQ, startElse); // Stack: <empty>

		// Hier komt het if block
		visit(ctx.blockStructure(0));

		// Als er geen else block is, hoeven we er ook niet overheen te springen. Spaart een GOTO!
		if (hasElseBlock) {
			mv.visitJumpInsn(GOTO, endElse); // Spring over het else blok heen
		}

		mv.visitLabel(startElse);
		mv.visitFrame(Opcodes.F_APPEND, 1, new Object[] { Opcodes.INTEGER }, 0, null);

		// Als er geen else block is, dan was het startElse label het laatste dat tot deze structuur behoort!
		if (hasElseBlock) {
			// Hier komt het else block
			visit(ctx.blockStructure(1));
			// Dit is het eind van de if/else structuur!
			mv.visitLabel(endElse);
			mv.visitFrame(Opcodes.F_SAME, 0, null, 0, null);
		}

		return null;
	}

	@Override
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

	public Symbol visitPlusMinusExpression(PlusMinusExpressionContext ctx) {
		Label earlyJump = new Label();
		Label midwayJump = new Label();
		Label finalJump = new Label();

		// @formatter:off
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
	 * @return null for any input
	 */
	public Symbol visitFunctionDeclaration(FunctionDeclarationContext ctx) {
		// Functions are inlined, so the declaration does not produce new ASM code.
		return null;
	}

	/**
	 * Produces the JBC for a functioncall. Because functions are inlined, it uses the declaration for code generation.
	 */
	public Symbol visitFunctionCall(FunctionCallContext ctx) {
		FunctionSymbol function = (FunctionSymbol) this.parseTreeproperty.get(ctx);

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
					mv.visitMethodInsn(INVOKEVIRTUAL, "java/util/Scanner", "next", "()Ljava/lang/String;");
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

			// Done: we can return now!
			return null;
		}

		// This contains the function code!
		FunctionDeclarationContext declaration = function.declarationContext;

		// @formatter:off
		// Open a new scope
		this.openScope();
		
			// Hier kan een identifier gezien worden als variabele, de eerste IDENTIFIER is de naam van de functie.
			for (int i = 1; i < ctx.expression().size(); i++) {
				// Copied from assignmentExpression
				int memAddr = this.parseTreeproperty.get(declaration.IDENTIFIER(i)).getNumber();
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
		
		this.closeScope();
		// @formatter:on

		return null;
	}

	/**
	 * Visits a possible enumeration; this is either an fieldaccess or an enumeration. If it is an enumeration, this function puts one int value on the stack.
	 * If it is a field access <NOT IMPLEMENTED YET>
	 * 
	 * @param ctx
	 *            either a field access or an enumeration.
	 * @return
	 */
	@Override
	public Symbol visitPotentialEnumerationLiteral(PotentialEnumerationLiteralContext ctx) {
		Symbol symbol = this.parseTreeproperty.get(ctx);

		if (symbol instanceof EnumerationSymbol) {
			EnumerationSymbol es = (EnumerationSymbol) this.parseTreeproperty.get(ctx);
			// in the format "day.MONDAY", monday is the second IDENTIFIER (thus index 1)
			int fieldId = es.getFieldId(ctx.IDENTIFIER(1).getText());

			mv.visitIntInsn(BIPUSH, fieldId);
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
}
