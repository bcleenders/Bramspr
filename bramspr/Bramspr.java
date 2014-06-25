package bramspr;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonToken;
import org.antlr.v4.runtime.CommonTokenFactory;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.UnbufferedCharStream;
import org.antlr.v4.runtime.UnbufferedTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.FileInputStream;
import java.io.InputStream;

public class Bramspr {
	public static void main(String[] args) throws Exception {
		System.out.println("**** Bramspr Compiler v0.0.1 ****");
		
		String inputFile = null;
		if (args.length > 0)
			inputFile = args[0];
		InputStream is = System.in;
		if (inputFile != null) {
			is = new FileInputStream(inputFile);
		}
		CharStream input = new UnbufferedCharStream(is);
		
		System.out.println("Start lexing");
		BramsprLexer lex = new BramsprLexer(input);
		lex.setTokenFactory(new CommonTokenFactory(true));
		TokenStream tokens = new UnbufferedTokenStream<CommonToken>(lex);
		
		System.out.println("Start parsing");
		BramsprParser parser = new BramsprParser(tokens);		
		ParseTree tree = parser.program(); // parse!
		
		System.out.println("Start checking");
		BramsprChecker checker = new BramsprChecker();
		checker.visit(tree);
		System.out.println("Finished checking");
	}
}
