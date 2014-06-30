package bramspr;

import static org.objectweb.asm.Opcodes.ACC_PUBLIC;
import static org.objectweb.asm.Opcodes.ACC_STATIC;
import static org.objectweb.asm.Opcodes.ARETURN;

import org.antlr.v4.runtime.tree.ParseTree;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import bramspr.BramsprParser.AdditionExpressionContext;
import bramspr.BramsprParser.AssignmentContext;
import bramspr.BramsprParser.PureDeclarationContext;

//public class BramsprCompiler implements BramsprVisitor<Void> {
public class BramsprCompiler extends BramsprBaseVisitor<Void> {

	ClassWriter classWriter;
	FieldVisitor fieldVisitor;
    MethodVisitor methodVisitor;

	public BramsprCompiler() {

	}

	public byte[] compile(ParseTree tree) {
		this.classWriter = new ClassWriter(ClassWriter.COMPUTE_MAXS);

		classWriter.visit(Opcodes.V1_7, Opcodes.ACC_PUBLIC + Opcodes.ACC_SUPER, "Bramspr", null, "java/lang/Object", null);

		// eval method
		MethodVisitor mv = classWriter.visitMethod(ACC_PUBLIC | ACC_STATIC, "program", "()Ljava/lang/Object;", null, null);

		// Dit start het compilen van de code!
		visit(tree);
		
		mv.visitInsn(ARETURN);
		// max stack and max locals automatically computed (COMPUTE_MAXS)
		mv.visitMaxs(0, 0);
		mv.visitEnd();

		byte[] code = classWriter.toByteArray();
		return code;
	}

	@Override
	public Void visitPureDeclaration(PureDeclarationContext ctx) {
		return null;
	}
	
	public Void visitAssignment(AssignmentContext ctx) {
		
		return null;
	}

	@Override
	public Void visitAdditionExpression(AdditionExpressionContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}
}
