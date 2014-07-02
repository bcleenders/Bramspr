package bramspr;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.tree.ParseTree;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.util.TraceClassVisitor;

import bramspr.BramsprParser.*;

//public class BramsprCompiler implements BramsprVisitor<Void> {
public class BramsprCompiler extends BramsprBaseVisitor<Void> implements Opcodes {

	TraceClassVisitor tcw;
	FieldVisitor fv;
	MethodVisitor mv;

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

	public byte[] compile(ParseTree tree) {
		// De ClassWriter is niet toegankelijk voor andere functies; werk via de TraceClassVisitor
		ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS | ClassWriter.COMPUTE_FRAMES );
		this.tcw = new TraceClassVisitor(cw, new PrintWriter(System.out));

		/*
		 *  Ga voor Java version 6; version 7 heeft stack map frames en dat willen we niet.
		 *  Als je Java 7 wil, moet je V1_6 door V1_7 vervangen, en bytecode runnen met een -XX:-UseSplitVerifier flag
		 */
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

		// Dit start het compilen van de code!
		visit(tree);

		mv.visitInsn(RETURN);
		// max stack and max locals automatically computed (COMPUTE_MAXS)
		mv.visitMaxs(0, 0);
		mv.visitEnd();

		byte[] code = cw.toByteArray();
		return code;
	}

	public Void visitAssignment(AssignmentContext ctx) {
		// Zet de waarde van de expression op de stack (kunnen we zo gaan toewijzen)
		visit(ctx.expression());

		// TODO meerdere toewijzingen tegelijkertijd (dup)

		// Fake het toewijzen TODO
		mv.visitInsn(POP);

		// this.dumpAssembly();

		return null;
	}

	public Void visitFunctionCall(FunctionCallContext ctx) {
		// TODO echte implementatie!

		// zet even wat leuks op de stack
		// mv.visitIntInsn(BIPUSH, 10);

		visit(ctx.expression(0));

		// laad een system.out reference
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
	public Void visitSmallerThanEqualsToExpression(SmallerThanEqualsToExpressionContext ctx) {
		// Zet de eerste waarde op de stack
		visit(ctx.arithmetic(0)); // Stack is nu a ->

		Label jumpIfTrueEncountered = new Label();

		// Skip de eerste
		for (int i = 1; i < ctx.arithmetic().size(); i++) {
			visit(ctx.arithmetic(i)); // Stack is nu a b ->

			mv.visitInsn(DUP_X1); // Stack is nu b a b ->

			// Als a <= b, jump dan naar de true state.
			mv.visitJumpInsn(IF_ICMPLE, jumpIfTrueEncountered); // Stack is nu b ->
		}

		// Er staat nu nog een b op de stack; pop die.
		mv.visitInsn(POP);
		// De uitkomst is false; zet een 0 op de stack
		mv.visitInsn(ICONST_0);

		Label endOfExpression = new Label();
		mv.visitJumpInsn(GOTO, endOfExpression);
		mv.visitFrame(Opcodes.F_APPEND, 3, new Object[] { Opcodes.INTEGER, Opcodes.INTEGER, Opcodes.INTEGER }, 0, null);

		// Label waar naartoe gejumpt wordt bij een true
		mv.visitLabel(jumpIfTrueEncountered);
		// Er staat nog wel een b op de stack; pop die.
		mv.visitInsn(POP);
		// De uitkomst is true; zet een 1 op de stack
		mv.visitInsn(ICONST_1);

		// Hier wordt naartoe gesprongen als er false uitkomt (jump over de true heen)
		mv.visitLabel(endOfExpression);
		mv.visitFrame(Opcodes.F_SAME1, 0, null, 1, new Object[] { Opcodes.INTEGER });

		return null;
	}

	public Void visitNumberLiteral(NumberLiteralContext ctx) {
		int value = Integer.parseInt(ctx.getText());
		mv.visitIntInsn(BIPUSH, value);
		return null;
	}

	public Void visitCharacterLiteral(CharacterLiteralContext ctx) {
		String character = ctx.CHARACTER().getText();

		// 'c'.charAt(1) -> c
		int charCode = Character.getNumericValue(character.charAt(1));

		mv.visitIntInsn(BIPUSH, charCode);

		return null;
	}

	public Void visitStringLiteral(StringLiteralContext ctx) {
		String s = ctx.getText();
		s.subSequence(1, s.length() - 1);

		// Vervang '\\' door '\', en \n door een linebreak
		s = s.replace("\\\\", "\\").replace("\\n", "\n");

		mv.visitLdcInsn(s);

		return null;
	}

	public Void visitBooleanLiteral(BooleanLiteralContext ctx) {
		if (ctx.BOOLEAN().getSymbol().getText().equals("true")) {
			mv.visitInsn(ICONST_1);
		} else {
			mv.visitInsn(ICONST_0);
		}
		return null;
	}

	@Override
	public Void visitAdditionExpression(AdditionExpressionContext ctx) {
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
	public Void visitMultiplicationExpression(MultiplicationExpressionContext ctx) {
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
	public Void visitSignExpression(SignExpressionContext ctx) {
		// Zet de linkerkant op de stack
		visit(ctx.arithmetic());

		if (ctx.MINUS() != null) {
			mv.visitInsn(INEG);
		}
		// De + doet niets (+2 == 2). Laten we maar geen assembly ervoor maken (OPTIMALISATIE!!! WOOHOOO)

		return null;
	}

	@Override
	public Void visitPowerExpression(PowerExpressionContext ctx) {
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
	public Void visitAndExpression(AndExpressionContext ctx) {
		// Zet boolean 1 op de stack
		visit(ctx.expression(0));

		// Zet boolean 2 op de stack
		visit(ctx.expression(1));

		mv.visitInsn(IAND);

		return null;
	}

	@Override
	public Void visitOrExpression(OrExpressionContext ctx) {
		// Zet boolean 1 op de stack
		visit(ctx.expression(0));

		// Zet boolean 2 op de stack
		visit(ctx.expression(1));

		mv.visitInsn(IOR);

		return null;
	}

	@Override
	public Void visitNotExpression(NotExpressionContext ctx) {
		// Zet boolean 1 op de stack
		visit(ctx.expression());

		// Zet 1 (true) op de stack
		mv.visitIntInsn(ILOAD, 1);
		// XOR -> true XOR a == NOT a
		mv.visitInsn(IXOR);

		return null;
	}
}
