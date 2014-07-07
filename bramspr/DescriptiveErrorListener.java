package bramspr;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

public class DescriptiveErrorListener extends BaseErrorListener {
	public static DescriptiveErrorListener INSTANCE = new DescriptiveErrorListener();
	
	int errorCount = 0;

	@Override
	public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {

		String sourceName = recognizer.getInputStream().getSourceName();
		if (sourceName != null && !sourceName.isEmpty()) {
			sourceName = String.format("%s:%d:%d: ", sourceName, line, charPositionInLine);
		}

		System.err.println(sourceName + "line " + line + ":" + charPositionInLine + " " + msg);
		
		errorCount++;
	}
}