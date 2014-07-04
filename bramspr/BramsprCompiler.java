package bramspr;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
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
		}

		// Vanaf hier mogen de variabelen gebruikt worden.
		mv.visitLabel(openingLabel);

		return null;
	}

	/**
	 * Geeft het Symbol terug van de assignable die hier gevisit wordt. Zet niets op de stack.
	 */
	public Symbol visitBasicAssignable(BasicAssignableContext ctx) {
		// Een basicAssignable is eigenlijk een variabele; geef deze maar terug (bevat mem. address en type info)
		VariableSymbol variable = (VariableSymbol) this.parseTreeproperty.get(ctx);

		System.out.println("var " + variable.getIdentifier() + " is at memory position " + variable.getNumber() + ".");

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

			if (type.equals(BramsprChecker.INTEGER)) {
				mv.visitIntInsn(ISTORE, memaddr); // Stack: a ->
			} else if (type.equals(BramsprChecker.CHARACTER)) {
				mv.visitIntInsn(ISTORE, memaddr); // Stack: a ->
			} else if (type.equals(BramsprChecker.BOOLEAN)) {
				mv.visitIntInsn(ISTORE, memaddr); // Stack: a ->
			} else if (type.equals(BramsprChecker.STRING)) {
				mv.visitIntInsn(ASTORE, memaddr); // Stack: a ->
			} else if (type instanceof EnumerationSymbol) {
				// Enums are stored as ints
				mv.visitIntInsn(ISTORE, memaddr); // Stack: a ->
			} else {
				System.err.println("Invalid assignment; unimplemented type!");
				System.exit(1);
			}
		}

		// TODO dit moet weer weg om het een expression te maken!
		mv.visitInsn(POP);

		return null;
	}

	public Symbol visitAssignableExpression(AssignableExpressionContext ctx) {
		Symbol variable = visit(ctx.assignable());
		mv.visitIntInsn(ILOAD, variable.getNumber());

		return null;
	}

	@Override
	public Symbol visitSwap(SwapContext ctx) {
		Symbol x = visit(ctx.assignable(0));
		Symbol y = visit(ctx.assignable(1));

		int memAddrX = x.getNumber();
		int memAddrY = y.getNumber();

		// TODO testen wat gebeurt als er een string/record staat
		// zowel voor "referenties" als voor fieldaccess; x.day <> y.day, maar ook firstName <> lastName
		mv.visitIntInsn(ILOAD, memAddrX); // Stack: x ->
		mv.visitIntInsn(ILOAD, memAddrY); // Stack: x y ->
		mv.visitIntInsn(ISTORE, memAddrX); // Stack: x ->
		mv.visitIntInsn(ISTORE, memAddrY); // Stack: ->

		return null;
	}

	/*
	 * Functies: nieuwe scope openen & inlinen?
	 * Recursive calls kunnen niet, dus inlining is eindig...
	 */
	public Symbol visitFunctionCall(FunctionCallContext ctx) {
		// TODO echte implementatie!

		visit(ctx.expression(0));
		mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");

		// de te printen waarde moet boven staan; wissel de top waardes om
		mv.visitInsn(SWAP);

		if (ctx.IDENTIFIER().getText().equals("putString")) { // TODO dit is tijdelijk!
			mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "print", "(Ljava/lang/String;)V");
		} else {
			mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "print", "(I)V");
		}

		// this.dumpAssembly();

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

		// We switchen op basis van de negatie. We kunnen dus of normaal vergelijken, en dan de negatie pakken, of we vergelijken met de tegenovergestelde
		// Opcode.
		// (dit is de tweede optie; die spaart operaties!)
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

	public Symbol visitNumberLiteral(NumberLiteralContext ctx) {
		int value = Integer.parseInt(ctx.getText());
		mv.visitIntInsn(BIPUSH, value);
		return null;
	}

	@Override
	public Symbol visitExplicitEnumerationLiteral(ExplicitEnumerationLiteralContext ctx) {
		EnumerationSymbol es = (EnumerationSymbol) this.parseTreeproperty.get(ctx);
		// in the format "enum.DAY.MONDAY", monday is the second IDENTIFIER (thus index 1)
		int fieldId = es.getFieldId(ctx.IDENTIFIER(1).getText());

		System.out.println("field id is " + fieldId);

		mv.visitIntInsn(BIPUSH, fieldId);

		return null;
	}

	public Symbol visitCharacterLiteral(CharacterLiteralContext ctx) {
		String character = ctx.CHARACTER().getText();

		// 'c'.charAt(1) -> c
		int charCode = Character.getNumericValue(character.charAt(1));

		mv.visitIntInsn(BIPUSH, charCode);

		return null;
	}

	public Symbol visitStringLiteral(StringLiteralContext ctx) {
		String s = ctx.getText();

		// Haal de " aan beide kanten weg
		s = (String) s.subSequence(1, s.length() - 1);

		// Vervang '\\' door '\', en \n door een linebreak
		s = s.replace("\\\\", "\\").replace("\\n", "\n");

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
}



















