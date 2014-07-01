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
		ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS);
		this.tcw = new TraceClassVisitor(cw, new PrintWriter(System.out));

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
		mv.visitIntInsn(BIPUSH, 10);

		// laad een system.out reference
		mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");

		// de te printen waarde moet boven staan; wissel de top waardes om
		mv.visitInsn(SWAP);

		// print de topwaarde van de stack
		mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(I)V");

//		this.dumpAssembly();

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
	
	public Void visitBooleanLiteral(BooleanLiteralContext ctx) {
		if(ctx.BOOLEAN().getSymbol().getText().equals("true")) {
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

		System.out.println("ADD");

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
