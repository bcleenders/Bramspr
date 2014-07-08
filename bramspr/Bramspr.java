package bramspr;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonToken;
import org.antlr.v4.runtime.CommonTokenFactory;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.UnbufferedCharStream;
import org.antlr.v4.runtime.UnbufferedTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

import bramspr.BramsprCompiler.BramsprClass;
import bramspr.symboltable.Symbol;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

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
		System.out.println("**** Bramspr Compiler ****");

		InputStream is = System.in;
		String outputFile = "Bramspr.class";

		if (args.length > 0) {
			String inputFile = args[0];
			try {
				is = new FileInputStream(inputFile);
			} catch (FileNotFoundException e) {
				System.out.println("The Bramspr compiler could not find this file ('" + inputFile + "').");
				System.out.println("Please ensure that this is a valid path, and that the compiler has read access.");
				System.exit(1);
			}
			
			if(inputFile.endsWith(".spr")) {
				outputFile = inputFile.replace(".spr", ".class");
			}
		}
		
		// If the user specified an output file, let's see what it is... (.class is optional)
		if (args.length > 1) {
			outputFile = args[1];
			outputFile = outputFile.replace(".class", ""); // Remove extension
		}

		// Now let's see what the classname will be... Remove the .class and anything before the last / or \
		String mainClassName = outputFile;
		mainClassName = mainClassName.contains("/") ? mainClassName.substring(mainClassName.lastIndexOf('/') + 1) : mainClassName;
		mainClassName = mainClassName.contains("\\") ? mainClassName.substring(mainClassName.lastIndexOf('\\') + 1) : mainClassName;
		
		String pathToFolder = outputFile.substring(0, outputFile.length() - mainClassName.length());

		CharStream input = new UnbufferedCharStream(is);

		// Start lexing
		BramsprLexer lexer = new BramsprLexer(input);
		lexer.removeErrorListeners();
		lexer.addErrorListener(DescriptiveErrorListener.INSTANCE);
		lexer.setTokenFactory(new CommonTokenFactory(true));
		TokenStream tokens = new UnbufferedTokenStream<CommonToken>(lexer);
		
		// Stop after seeing an error
		if(DescriptiveErrorListener.INSTANCE.errorCount > 0) {
			System.err.println("Found " + DescriptiveErrorListener.INSTANCE.errorCount + " errors: stopped compiling.");
			System.exit(1);
		}

		// Start parsing
		BramsprParser parser = new BramsprParser(tokens);
		parser.removeErrorListeners();
		parser.addErrorListener(DescriptiveErrorListener.INSTANCE);
		ParseTree tree = parser.program();
		
		// Stop after seeing an error
		if(DescriptiveErrorListener.INSTANCE.errorCount > 0) {
			System.err.println("Found " + DescriptiveErrorListener.INSTANCE.errorCount + " errors: stopped compiling.");
			System.exit(1);
		}
		

		// Start context checking
		BramsprChecker checker = new BramsprChecker();
		ParseTreeProperty<Symbol> ptp = checker.check(tree);

		// Start code generation
		BramsprCompiler compiler = new BramsprCompiler();
		ArrayList<BramsprClass> classes = compiler.compile(tree, ptp, mainClassName);
		
		System.out.println("Writing " + classes.size() + " class files to folder '" + pathToFolder + "'.");

		// Process one class at a time (there may be inner classes, which need to be stored in separate files)
		for(int i = 0; i < classes.size(); i++) {
			BramsprCompiler.BramsprClass c = classes.get(i);
			String name = c.className;
			byte[] code = c.bytecode;
			
			String pathToFile = pathToFolder + name + ".class";
			
			try {
				FileOutputStream fos = new FileOutputStream(pathToFile);
				fos.write(code);
				fos.close();
			} catch (IOException e) {
				System.out.println("Could not write output to file '" + pathToFile + "'.");
				System.out.println("Exiting.");
				System.exit(1);
			}
		}

		System.out.println("Finished compiling.");
		System.out.println("To execute compiled code, visit '" + pathToFolder + "' in the console/commandline and run: ");
		System.out.println("      java " + mainClassName);
	}
}
