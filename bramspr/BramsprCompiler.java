package bramspr;

import static org.objectweb.asm.Opcodes.ACC_PUBLIC;
import static org.objectweb.asm.Opcodes.ACC_STATIC;

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

import bramspr.BramsprParser.AdditionExpressionContext;
import bramspr.BramsprParser.AssignmentContext;
import bramspr.BramsprParser.FunctionCallContext;
import bramspr.BramsprParser.NumberLiteralContext;

//public class BramsprCompiler implements BramsprVisitor<Void> {
public class BramsprCompiler extends BramsprBaseVisitor<Void> {

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

		this.tcw.visit(Opcodes.V1_7, Opcodes.ACC_PUBLIC + Opcodes.ACC_SUPER, "Bramspr", null, "java/lang/Object", null);

		{
			mv = this.tcw.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
			mv.visitCode();
			Label l0 = new Label();
			mv.visitLabel(l0);
			mv.visitLineNumber(3, l0);
			mv.visitVarInsn(Opcodes.ALOAD, 0);
			mv.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/lang/Object", "<init>", "()V");

			Label l3 = new Label();
			mv.visitLabel(l3);
			mv.visitLineNumber(3, l3);
			mv.visitInsn(Opcodes.RETURN);
			Label l4 = new Label();
			mv.visitLabel(l4);
			mv.visitLocalVariable("this", "LBramspr;", null, l0, l4, 0);
			mv.visitMaxs(2, 1);
			mv.visitEnd();
		}

		// eval method
		mv = this.tcw.visitMethod(ACC_PUBLIC + ACC_STATIC, "main", "([Ljava/lang/String;)V", null, null);
		mv.visitCode();

		// Dit start het compilen van de code!
		visit(tree);

		mv.visitInsn(Opcodes.RETURN);
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
		mv.visitInsn(Opcodes.POP);
		
//		this.dumpAssembly();

		return null;
	}
	
	public Void visitFunctionCall(FunctionCallContext ctx) {
		// TODO echte implementatie!

		
		// zet even wat leuks op de stack
		mv.visitIntInsn(Opcodes.BIPUSH, 10);
		
		// laad een system.out reference
		mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
		
		// de te printen waarde moet boven staan; wissel de top waardes om
		mv.visitInsn(Opcodes.SWAP);
		
		// print de topwaarde van de stack
		mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(I)V");

		this.dumpAssembly();
		
		return null;
	}

	public Void visitNumberLiteral(NumberLiteralContext ctx) {
		int value = Integer.parseInt(ctx.getText());
		mv.visitIntInsn(Opcodes.BIPUSH, value);
		return null;
	}

	@Override
	public Void visitAdditionExpression(AdditionExpressionContext ctx) {
		// Zet de linkerkant op de stack
		visit(ctx.arithmetic(0));
		// Zet de rechterkant op de stack
		visit(ctx.arithmetic(1));
		// Tel ze op
		mv.visitInsn(Opcodes.IADD);

		System.out.println("ADD");

		return null;
	}
}
