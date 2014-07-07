package bramspr;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonToken;
import org.antlr.v4.runtime.CommonTokenFactory;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.UnbufferedCharStream;
import org.antlr.v4.runtime.UnbufferedTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

import bramspr.symboltable.Symbol;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
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
	public static void main(String[] args) {
		System.out.println("**** Bramspr Compiler v0.1.0 ****");

		String inputFile = null;
		if (args.length > 0) {
			inputFile = args[0];
		}
		InputStream is = System.in;
		if (inputFile != null) {
			try {
				is = new FileInputStream(inputFile);
			} catch (FileNotFoundException e) {
				System.out.println("The Bramspr compiler could not find this file ('" + inputFile + "').");
				System.out.println("Please ensure that this is a valid path, and that the compiler has read access.");
				System.exit(1);
			}
		}
		CharStream input = new UnbufferedCharStream(is);

		System.out.println("Start lexing...");
		BramsprLexer lex = new BramsprLexer(input);
		lex.setTokenFactory(new CommonTokenFactory(true));
		TokenStream tokens = new UnbufferedTokenStream<CommonToken>(lex);

		System.out.println("Start parsing...");
		BramsprParser parser = new BramsprParser(tokens);
		ParseTree tree = parser.program();

		System.out.println("Start checking...");
		BramsprChecker checker = new BramsprChecker();
		ParseTreeProperty<Symbol> ptp = checker.check(tree);
		System.out.println("Finished checking.");

		System.out.println("Start compiling...");
		BramsprCompiler compiler = new BramsprCompiler();
		byte[] code = compiler.compile(tree, ptp);
		System.out.println("Finished compiling.");

		String filename = "Bramspr.class";

		try {
			FileOutputStream fos = new FileOutputStream(filename);
			fos.write(code);
			fos.close();
		} catch (IOException e) {
			System.out.println("Could not write output to file '" + filename + "'.");
			System.out.println("Exiting.");
			System.exit(1);
		}
		
		System.out.println("Finished compiling, execute 'java " + filename + "' to run the compiled file.");
	}
}
