package bramspr;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;

//public class BramsprCompiler implements BramsprVisitor<Suit> {
public class BramsprCompiler extends BramsprBaseVisitor<Suit> {
	
	ClassWriter classWriter;
	
	public BramsprCompiler() {
		this.classWriter = new ClassWriter(ClassWriter.COMPUTE_MAXS);
		
		classWriter.visit(Opcodes.V1_5, Opcodes.ACC_PUBLIC, "myProgram", null, "java/lang/Object", null);
		
		byte[] code = classWriter.toByteArray();
	}
}
