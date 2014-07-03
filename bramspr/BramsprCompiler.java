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
	 * Contains the last label of every scope we have visited.
	 * Grows one every time a scope is opened. These labels are used in the elements of {@link #variables} as closing scopes.
	 */
	private Stack<Label> closingScopeLabels = new Stack<Label>();
	
	/**
	 * Opens a new scope (reserves a closing label)
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
	 * Maintains a list of the variables we have visited. Stores name, type, opening_label, closing_label (excl.)
	 * This allows us to do a massive mv.visitLocalVariable(...) iteration at the end of the class, to declare the variables.
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

	public byte[] compile(ParseTree tree, ParseTreeProperty<Symbol> ptp) {
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
			mv.visitLocalVariable(var.getIdentifier(), ((CompositeSymbol) var.getReturnType()).getShortIdentifier(), null, var.openingLabel, var.closingLabel, var.getNumber());
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
	 * Geeft het Symbol terug van de assignable die hier gevisit wordt.
	 * Zet niets op de stack.
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

	/**
	 * Genereert lazy evaluation voor smaller than equals to (<=)
	 */
	public Symbol visitSmallerThanEqualsToExpression(SmallerThanEqualsToExpressionContext ctx) {
		// Zet de eerste waarde op de stack
		visit(ctx.arithmetic(0)); // Stack is nu a ->

		Label jumpIfFalseEncountered = new Label();

		// Skip de eerste
		for (int i = 1; i < ctx.arithmetic().size(); i++) {
			visit(ctx.arithmetic(i)); // Stack is nu a b ->

			mv.visitInsn(DUP_X1); // Stack is nu b a b ->

			// Als a > b (dus ! a <= b), jump dan naar de false state.
			mv.visitJumpInsn(IF_ICMPGT, jumpIfFalseEncountered); // Stack is nu b ->
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

		return null;
	}

	public Symbol visitNumberLiteral(NumberLiteralContext ctx) {
		int value = Integer.parseInt(ctx.getText());
		mv.visitIntInsn(BIPUSH, value);
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
		s.subSequence(1, s.length() - 1);

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
		mv.visitIntInsn(ILOAD, 1);
		// XOR -> true XOR a == NOT a
		mv.visitInsn(IXOR);

		return null;
	}
}
