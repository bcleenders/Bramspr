// Generated from C:\Users\Jasper\eclipse_workspace\Bramspr\src\BramsprLexer.g4 by ANTLR 4.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class BramsprLexer extends Lexer {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		BECOMES=1, MULTIPLICATION=2, PLUS=3, MINUS=4, DIVISION=5, MODULUS=6, SMALLER_THAN=7, 
		SMALLER_THAN_EQUALS_TO=8, GREATER_THAN=9, GREATER_THAN_EQUALS_TO=10, EQUALS_TO=11, 
		NOT_EQUALS_TO=12, COMPARATOR=13, NOT=14, AND=15, OR=16, XOR=17, IF=18, 
		THEN=19, ELSE=20, COLON=21, SEMICOLON=22, LEFT_PARENTHESIS=23, RIGHT_PARENTHESIS=24, 
		LEFT_CURLY_BRACKET=25, RIGHT_CURLY_BRACKET=26, IDENTIFIER=27, LETTER=28, 
		NUMBER=29, DIGIT=30, WHITESPACE=31;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"BECOMES", "'*'", "'+'", "'-'", "DIVISION", "'%'", "SMALLER_THAN", "SMALLER_THAN_EQUALS_TO", 
		"GREATER_THAN", "GREATER_THAN_EQUALS_TO", "'='", "NOT_EQUALS_TO", "COMPARATOR", 
		"'!'", "AND", "OR", "XOR", "'if'", "'then'", "'else'", "':'", "';'", "'('", 
		"')'", "'{'", "'}'", "IDENTIFIER", "LETTER", "NUMBER", "DIGIT", "WHITESPACE"
	};
	public static final String[] ruleNames = {
		"BECOMES", "MULTIPLICATION", "PLUS", "MINUS", "DIVISION", "MODULUS", "SMALLER_THAN", 
		"SMALLER_THAN_EQUALS_TO", "GREATER_THAN", "GREATER_THAN_EQUALS_TO", "EQUALS_TO", 
		"NOT_EQUALS_TO", "COMPARATOR", "NOT", "AND", "OR", "XOR", "IF", "THEN", 
		"ELSE", "COLON", "SEMICOLON", "LEFT_PARENTHESIS", "RIGHT_PARENTHESIS", 
		"LEFT_CURLY_BRACKET", "RIGHT_CURLY_BRACKET", "IDENTIFIER", "LETTER", "NUMBER", 
		"DIGIT", "WHITESPACE"
	};


	public BramsprLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "BramsprLexer.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 30: WHITESPACE_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void WHITESPACE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: skip();  break;
		}
	}

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\2!\u00af\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \3\2"+
		"\3\2\3\2\5\2E\n\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t"+
		"\3\t\3\t\5\tV\n\t\3\n\3\n\3\13\3\13\3\13\5\13]\n\13\3\f\3\f\3\r\3\r\3"+
		"\r\5\rd\n\r\3\16\3\16\3\16\3\16\3\16\3\16\5\16l\n\16\3\17\3\17\3\20\3"+
		"\20\3\20\5\20s\n\20\3\21\3\21\3\21\5\21x\n\21\3\22\3\22\3\22\5\22}\n\22"+
		"\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\26"+
		"\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\34"+
		"\7\34\u009b\n\34\f\34\16\34\u009e\13\34\3\35\3\35\3\36\6\36\u00a3\n\36"+
		"\r\36\16\36\u00a4\3\37\3\37\3 \6 \u00aa\n \r \16 \u00ab\3 \3 \2!\3\3\1"+
		"\5\4\1\7\5\1\t\6\1\13\7\1\r\b\1\17\t\1\21\n\1\23\13\1\25\f\1\27\r\1\31"+
		"\16\1\33\17\1\35\20\1\37\21\1!\22\1#\23\1%\24\1\'\25\1)\26\1+\27\1-\30"+
		"\1/\31\1\61\32\1\63\33\1\65\34\1\67\35\19\36\1;\37\1= \1?!\2\3\2\4\4\2"+
		"\61\61\u00f9\u00f9\5\2\13\f\16\17\"\"\u00be\2\3\3\2\2\2\2\5\3\2\2\2\2"+
		"\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2"+
		"\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2"+
		"\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2"+
		"\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2"+
		"\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2"+
		"\2\3D\3\2\2\2\5F\3\2\2\2\7H\3\2\2\2\tJ\3\2\2\2\13L\3\2\2\2\rN\3\2\2\2"+
		"\17P\3\2\2\2\21U\3\2\2\2\23W\3\2\2\2\25\\\3\2\2\2\27^\3\2\2\2\31c\3\2"+
		"\2\2\33k\3\2\2\2\35m\3\2\2\2\37r\3\2\2\2!w\3\2\2\2#|\3\2\2\2%~\3\2\2\2"+
		"\'\u0081\3\2\2\2)\u0086\3\2\2\2+\u008b\3\2\2\2-\u008d\3\2\2\2/\u008f\3"+
		"\2\2\2\61\u0091\3\2\2\2\63\u0093\3\2\2\2\65\u0095\3\2\2\2\67\u0097\3\2"+
		"\2\29\u009f\3\2\2\2;\u00a2\3\2\2\2=\u00a6\3\2\2\2?\u00a9\3\2\2\2AE\7A"+
		"\2\2BC\7<\2\2CE\7?\2\2DA\3\2\2\2DB\3\2\2\2E\4\3\2\2\2FG\7,\2\2G\6\3\2"+
		"\2\2HI\7-\2\2I\b\3\2\2\2JK\7/\2\2K\n\3\2\2\2LM\t\2\2\2M\f\3\2\2\2NO\7"+
		"\'\2\2O\16\3\2\2\2PQ\7@\2\2Q\20\3\2\2\2RV\7A\2\2ST\7>\2\2TV\7?\2\2UR\3"+
		"\2\2\2US\3\2\2\2V\22\3\2\2\2WX\7@\2\2X\24\3\2\2\2Y]\7A\2\2Z[\7@\2\2[]"+
		"\7?\2\2\\Y\3\2\2\2\\Z\3\2\2\2]\26\3\2\2\2^_\7?\2\2_\30\3\2\2\2`d\7A\2"+
		"\2ab\7#\2\2bd\7?\2\2c`\3\2\2\2ca\3\2\2\2d\32\3\2\2\2el\5\17\b\2fl\5\21"+
		"\t\2gl\5\23\n\2hl\5\25\13\2il\5\27\f\2jl\5\31\r\2ke\3\2\2\2kf\3\2\2\2"+
		"kg\3\2\2\2kh\3\2\2\2ki\3\2\2\2kj\3\2\2\2l\34\3\2\2\2mn\7#\2\2n\36\3\2"+
		"\2\2os\7A\2\2pq\7(\2\2qs\7(\2\2ro\3\2\2\2rp\3\2\2\2s \3\2\2\2tx\7A\2\2"+
		"uv\7~\2\2vx\7~\2\2wt\3\2\2\2wu\3\2\2\2x\"\3\2\2\2y}\7A\2\2z{\7#\2\2{}"+
		"\7(\2\2|y\3\2\2\2|z\3\2\2\2}$\3\2\2\2~\177\7k\2\2\177\u0080\7h\2\2\u0080"+
		"&\3\2\2\2\u0081\u0082\7v\2\2\u0082\u0083\7j\2\2\u0083\u0084\7g\2\2\u0084"+
		"\u0085\7p\2\2\u0085(\3\2\2\2\u0086\u0087\7g\2\2\u0087\u0088\7n\2\2\u0088"+
		"\u0089\7u\2\2\u0089\u008a\7g\2\2\u008a*\3\2\2\2\u008b\u008c\7<\2\2\u008c"+
		",\3\2\2\2\u008d\u008e\7=\2\2\u008e.\3\2\2\2\u008f\u0090\7*\2\2\u0090\60"+
		"\3\2\2\2\u0091\u0092\7+\2\2\u0092\62\3\2\2\2\u0093\u0094\7}\2\2\u0094"+
		"\64\3\2\2\2\u0095\u0096\7\177\2\2\u0096\66\3\2\2\2\u0097\u009c\59\35\2"+
		"\u0098\u009b\59\35\2\u0099\u009b\5=\37\2\u009a\u0098\3\2\2\2\u009a\u0099"+
		"\3\2\2\2\u009b\u009e\3\2\2\2\u009c\u009a\3\2\2\2\u009c\u009d\3\2\2\2\u009d"+
		"8\3\2\2\2\u009e\u009c\3\2\2\2\u009f\u00a0\4c|\2\u00a0:\3\2\2\2\u00a1\u00a3"+
		"\5=\37\2\u00a2\u00a1\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00a2\3\2\2\2\u00a4"+
		"\u00a5\3\2\2\2\u00a5<\3\2\2\2\u00a6\u00a7\4\62;\2\u00a7>\3\2\2\2\u00a8"+
		"\u00aa\t\3\2\2\u00a9\u00a8\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\u00a9\3\2"+
		"\2\2\u00ab\u00ac\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\u00ae\b \2\2\u00ae"+
		"@\3\2\2\2\17\2DU\\ckrw|\u009a\u009c\u00a4\u00ab";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}