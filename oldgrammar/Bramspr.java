package oldgrammar;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonToken;
import org.antlr.v4.runtime.CommonTokenFactory;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.UnbufferedCharStream;
import org.antlr.v4.runtime.UnbufferedTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * The driver class for the Bramspr compiler. Contains the main method.
 */
public class Bramspr {

	/**
	 * The method to use to compile a Bramspr program. Provide a filename as argument. The filename should refer to a Bramspr file. This method then lexes,
	 * parses, context-checks and finally compiles the program to a Java Bytecode .class-file. During this process, the program will be checked for syntactic or
	 * contextual errors, and will report those when encountered.
	 * 
	 * @param args
	 *            The filename of the Bramspr-file that is to be compiled.
	 */
	public static void main(String[] args) throws Exception {
		System.out.println("**** Bramspr Compiler v0.1.0 ****");

		String inputFile = null;
		if (args.length > 0) {
			inputFile = args[0];
		}
		InputStream is = System.in;
		if (inputFile != null) {
			is = new FileInputStream(inputFile);
		}
		CharStream input = new UnbufferedCharStream(is);

		System.out.println("Start lexing...");
		BramsprLexer lex = new BramsprLexer(input);
		lex.setTokenFactory(new CommonTokenFactory(true));
		TokenStream tokens = new UnbufferedTokenStream<CommonToken>(lex);

		System.out.println("Start parsing...");
		Bramspr_OldParser parser = new Bramspr_OldParser(tokens);
		ParseTree tree = parser.program();
	}
}
