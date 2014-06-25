// Generated from C:\Users\Jasper\eclipse_workspace\Bramspr\src\BramsprLexer.g4 by ANTLR 4.1
package bramspr;
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
		BECOMES=1, SWAP=2, PLUS=3, MINUS=4, MULTIPLICATION=5, DIVISION=6, MODULUS=7, 
		SMALLER_THAN=8, SMALLER_THAN_EQUALS_TO=9, GREATER_THAN=10, GREATER_THAN_EQUALS_TO=11, 
		EQUALS_TO=12, NOT_EQUALS_TO=13, PLUSMINUS=14, POWER=15, NOT=16, AND=17, 
		OR=18, XOR=19, LOGIC=20, IF=21, THEN=22, ELSE=23, WHILE=24, FUNCTION=25, 
		COMPOSITE=26, ENUM=27, RETURN=28, CONSTANT=29, COLON=30, SEMICOLON=31, 
		LEFT_PARENTHESIS=32, RIGHT_PARENTHESIS=33, LEFT_BRACE=34, RIGHT_BRACE=35, 
		LEFT_BLOCKBRACE=36, RIGHT_BLOCKBRACE=37, COMMA=38, DOT=39, BOOL=40, STRING=41, 
		CHARACTER=42, IDENTIFIER=43, NUMBER=44, COMMENT=45, BLOCKCOMMENT=46, WHITESPACE=47;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"':='", "'<>'", "'+'", "'-'", "'*'", "'/'", "'%'", "'<'", "'<='", "'>'", 
		"'>='", "'='", "'=/='", "'+-'", "'^'", "'!'", "'&'", "'|'", "'!&'", "LOGIC", 
		"'if'", "'then'", "'else'", "'while'", "'function'", "'composite'", "'enum'", 
		"'return'", "'constant'", "':'", "';'", "'('", "')'", "'{'", "'}'", "'['", 
		"']'", "','", "'.'", "BOOL", "STRING", "CHARACTER", "IDENTIFIER", "NUMBER", 
		"COMMENT", "BLOCKCOMMENT", "WHITESPACE"
	};
	public static final String[] ruleNames = {
		"BECOMES", "SWAP", "PLUS", "MINUS", "MULTIPLICATION", "DIVISION", "MODULUS", 
		"SMALLER_THAN", "SMALLER_THAN_EQUALS_TO", "GREATER_THAN", "GREATER_THAN_EQUALS_TO", 
		"EQUALS_TO", "NOT_EQUALS_TO", "PLUSMINUS", "POWER", "NOT", "AND", "OR", 
		"XOR", "LOGIC", "IF", "THEN", "ELSE", "WHILE", "FUNCTION", "COMPOSITE", 
		"ENUM", "RETURN", "CONSTANT", "COLON", "SEMICOLON", "LEFT_PARENTHESIS", 
		"RIGHT_PARENTHESIS", "LEFT_BRACE", "RIGHT_BRACE", "LEFT_BLOCKBRACE", "RIGHT_BLOCKBRACE", 
		"COMMA", "DOT", "BOOL", "STRING", "CHARACTER", "IDENTIFIER", "NUMBER", 
		"COMMENT", "BLOCKCOMMENT", "WHITESPACE", "DIGIT", "LETTER", "ESCAPED"
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
		case 44: COMMENT_action((RuleContext)_localctx, actionIndex); break;

		case 45: BLOCKCOMMENT_action((RuleContext)_localctx, actionIndex); break;

		case 46: WHITESPACE_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void WHITESPACE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 2: skip();  break;
		}
	}
	private void BLOCKCOMMENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1: skip();  break;
		}
	}
	private void COMMENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: skip();  break;
		}
	}

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\2\61\u0140\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\3\2"+
		"\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3"+
		"\n\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\16\3\16\3\16\3\16\3\17\3\17"+
		"\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\24\3\25\3\25"+
		"\3\25\5\25\u0099\n\25\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\30\3\30"+
		"\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32"+
		"\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33"+
		"\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\36\3\36"+
		"\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3"+
		"#\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3)\3)\3)\3)\3)\3)\3)\5)\u00f3"+
		"\n)\3*\3*\3*\7*\u00f8\n*\f*\16*\u00fb\13*\3*\3*\3+\3+\3+\3+\7+\u0103\n"+
		"+\f+\16+\u0106\13+\3+\3+\3,\3,\3,\7,\u010d\n,\f,\16,\u0110\13,\3-\6-\u0113"+
		"\n-\r-\16-\u0114\3.\3.\3.\3.\7.\u011b\n.\f.\16.\u011e\13.\3.\3.\3/\3/"+
		"\3/\3/\7/\u0126\n/\f/\16/\u0129\13/\3/\3/\3/\3/\3/\3\60\6\60\u0131\n\60"+
		"\r\60\16\60\u0132\3\60\3\60\3\61\3\61\3\62\3\62\3\63\3\63\3\63\3\63\5"+
		"\63\u013f\n\63\5\u00f9\u0104\u0127\64\3\3\1\5\4\1\7\5\1\t\6\1\13\7\1\r"+
		"\b\1\17\t\1\21\n\1\23\13\1\25\f\1\27\r\1\31\16\1\33\17\1\35\20\1\37\21"+
		"\1!\22\1#\23\1%\24\1\'\25\1)\26\1+\27\1-\30\1/\31\1\61\32\1\63\33\1\65"+
		"\34\1\67\35\19\36\1;\37\1= \1?!\1A\"\1C#\1E$\1G%\1I&\1K\'\1M(\1O)\1Q*"+
		"\1S+\1U,\1W-\1Y.\1[/\2]\60\3_\61\4a\2\1c\2\1e\2\1\3\2\5\4\2\f\f\17\17"+
		"\5\2\13\f\16\17\"\"\4\2C\\c|\u014a\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2"+
		"\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3"+
		"\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2"+
		"\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2"+
		"\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2"+
		"\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2"+
		"\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2"+
		"O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3"+
		"\2\2\2\2]\3\2\2\2\2_\3\2\2\2\3g\3\2\2\2\5j\3\2\2\2\7m\3\2\2\2\to\3\2\2"+
		"\2\13q\3\2\2\2\rs\3\2\2\2\17u\3\2\2\2\21w\3\2\2\2\23y\3\2\2\2\25|\3\2"+
		"\2\2\27~\3\2\2\2\31\u0081\3\2\2\2\33\u0083\3\2\2\2\35\u0087\3\2\2\2\37"+
		"\u008a\3\2\2\2!\u008c\3\2\2\2#\u008e\3\2\2\2%\u0090\3\2\2\2\'\u0092\3"+
		"\2\2\2)\u0098\3\2\2\2+\u009a\3\2\2\2-\u009d\3\2\2\2/\u00a2\3\2\2\2\61"+
		"\u00a7\3\2\2\2\63\u00ad\3\2\2\2\65\u00b6\3\2\2\2\67\u00c0\3\2\2\29\u00c5"+
		"\3\2\2\2;\u00cc\3\2\2\2=\u00d5\3\2\2\2?\u00d7\3\2\2\2A\u00d9\3\2\2\2C"+
		"\u00db\3\2\2\2E\u00dd\3\2\2\2G\u00df\3\2\2\2I\u00e1\3\2\2\2K\u00e3\3\2"+
		"\2\2M\u00e5\3\2\2\2O\u00e7\3\2\2\2Q\u00f2\3\2\2\2S\u00f4\3\2\2\2U\u00fe"+
		"\3\2\2\2W\u0109\3\2\2\2Y\u0112\3\2\2\2[\u0116\3\2\2\2]\u0121\3\2\2\2_"+
		"\u0130\3\2\2\2a\u0136\3\2\2\2c\u0138\3\2\2\2e\u013e\3\2\2\2gh\7<\2\2h"+
		"i\7?\2\2i\4\3\2\2\2jk\7>\2\2kl\7@\2\2l\6\3\2\2\2mn\7-\2\2n\b\3\2\2\2o"+
		"p\7/\2\2p\n\3\2\2\2qr\7,\2\2r\f\3\2\2\2st\7\61\2\2t\16\3\2\2\2uv\7\'\2"+
		"\2v\20\3\2\2\2wx\7>\2\2x\22\3\2\2\2yz\7>\2\2z{\7?\2\2{\24\3\2\2\2|}\7"+
		"@\2\2}\26\3\2\2\2~\177\7@\2\2\177\u0080\7?\2\2\u0080\30\3\2\2\2\u0081"+
		"\u0082\7?\2\2\u0082\32\3\2\2\2\u0083\u0084\7?\2\2\u0084\u0085\7\61\2\2"+
		"\u0085\u0086\7?\2\2\u0086\34\3\2\2\2\u0087\u0088\7-\2\2\u0088\u0089\7"+
		"/\2\2\u0089\36\3\2\2\2\u008a\u008b\7`\2\2\u008b \3\2\2\2\u008c\u008d\7"+
		"#\2\2\u008d\"\3\2\2\2\u008e\u008f\7(\2\2\u008f$\3\2\2\2\u0090\u0091\7"+
		"~\2\2\u0091&\3\2\2\2\u0092\u0093\7#\2\2\u0093\u0094\7(\2\2\u0094(\3\2"+
		"\2\2\u0095\u0099\5#\22\2\u0096\u0099\5%\23\2\u0097\u0099\5\'\24\2\u0098"+
		"\u0095\3\2\2\2\u0098\u0096\3\2\2\2\u0098\u0097\3\2\2\2\u0099*\3\2\2\2"+
		"\u009a\u009b\7k\2\2\u009b\u009c\7h\2\2\u009c,\3\2\2\2\u009d\u009e\7v\2"+
		"\2\u009e\u009f\7j\2\2\u009f\u00a0\7g\2\2\u00a0\u00a1\7p\2\2\u00a1.\3\2"+
		"\2\2\u00a2\u00a3\7g\2\2\u00a3\u00a4\7n\2\2\u00a4\u00a5\7u\2\2\u00a5\u00a6"+
		"\7g\2\2\u00a6\60\3\2\2\2\u00a7\u00a8\7y\2\2\u00a8\u00a9\7j\2\2\u00a9\u00aa"+
		"\7k\2\2\u00aa\u00ab\7n\2\2\u00ab\u00ac\7g\2\2\u00ac\62\3\2\2\2\u00ad\u00ae"+
		"\7h\2\2\u00ae\u00af\7w\2\2\u00af\u00b0\7p\2\2\u00b0\u00b1\7e\2\2\u00b1"+
		"\u00b2\7v\2\2\u00b2\u00b3\7k\2\2\u00b3\u00b4\7q\2\2\u00b4\u00b5\7p\2\2"+
		"\u00b5\64\3\2\2\2\u00b6\u00b7\7e\2\2\u00b7\u00b8\7q\2\2\u00b8\u00b9\7"+
		"o\2\2\u00b9\u00ba\7r\2\2\u00ba\u00bb\7q\2\2\u00bb\u00bc\7u\2\2\u00bc\u00bd"+
		"\7k\2\2\u00bd\u00be\7v\2\2\u00be\u00bf\7g\2\2\u00bf\66\3\2\2\2\u00c0\u00c1"+
		"\7g\2\2\u00c1\u00c2\7p\2\2\u00c2\u00c3\7w\2\2\u00c3\u00c4\7o\2\2\u00c4"+
		"8\3\2\2\2\u00c5\u00c6\7t\2\2\u00c6\u00c7\7g\2\2\u00c7\u00c8\7v\2\2\u00c8"+
		"\u00c9\7w\2\2\u00c9\u00ca\7t\2\2\u00ca\u00cb\7p\2\2\u00cb:\3\2\2\2\u00cc"+
		"\u00cd\7e\2\2\u00cd\u00ce\7q\2\2\u00ce\u00cf\7p\2\2\u00cf\u00d0\7u\2\2"+
		"\u00d0\u00d1\7v\2\2\u00d1\u00d2\7c\2\2\u00d2\u00d3\7p\2\2\u00d3\u00d4"+
		"\7v\2\2\u00d4<\3\2\2\2\u00d5\u00d6\7<\2\2\u00d6>\3\2\2\2\u00d7\u00d8\7"+
		"=\2\2\u00d8@\3\2\2\2\u00d9\u00da\7*\2\2\u00daB\3\2\2\2\u00db\u00dc\7+"+
		"\2\2\u00dcD\3\2\2\2\u00dd\u00de\7}\2\2\u00deF\3\2\2\2\u00df\u00e0\7\177"+
		"\2\2\u00e0H\3\2\2\2\u00e1\u00e2\7]\2\2\u00e2J\3\2\2\2\u00e3\u00e4\7_\2"+
		"\2\u00e4L\3\2\2\2\u00e5\u00e6\7.\2\2\u00e6N\3\2\2\2\u00e7\u00e8\7\60\2"+
		"\2\u00e8P\3\2\2\2\u00e9\u00ea\7v\2\2\u00ea\u00eb\7t\2\2\u00eb\u00ec\7"+
		"w\2\2\u00ec\u00f3\7g\2\2\u00ed\u00ee\7h\2\2\u00ee\u00ef\7c\2\2\u00ef\u00f0"+
		"\7n\2\2\u00f0\u00f1\7u\2\2\u00f1\u00f3\7g\2\2\u00f2\u00e9\3\2\2\2\u00f2"+
		"\u00ed\3\2\2\2\u00f3R\3\2\2\2\u00f4\u00f9\7$\2\2\u00f5\u00f8\5e\63\2\u00f6"+
		"\u00f8\n\2\2\2\u00f7\u00f5\3\2\2\2\u00f7\u00f6\3\2\2\2\u00f8\u00fb\3\2"+
		"\2\2\u00f9\u00fa\3\2\2\2\u00f9\u00f7\3\2\2\2\u00fa\u00fc\3\2\2\2\u00fb"+
		"\u00f9\3\2\2\2\u00fc\u00fd\7$\2\2\u00fdT\3\2\2\2\u00fe\u0104\7)\2\2\u00ff"+
		"\u0100\7^\2\2\u0100\u0103\7)\2\2\u0101\u0103\n\2\2\2\u0102\u00ff\3\2\2"+
		"\2\u0102\u0101\3\2\2\2\u0103\u0106\3\2\2\2\u0104\u0105\3\2\2\2\u0104\u0102"+
		"\3\2\2\2\u0105\u0107\3\2\2\2\u0106\u0104\3\2\2\2\u0107\u0108\7)\2\2\u0108"+
		"V\3\2\2\2\u0109\u010e\5c\62\2\u010a\u010d\5c\62\2\u010b\u010d\5a\61\2"+
		"\u010c\u010a\3\2\2\2\u010c\u010b\3\2\2\2\u010d\u0110\3\2\2\2\u010e\u010c"+
		"\3\2\2\2\u010e\u010f\3\2\2\2\u010fX\3\2\2\2\u0110\u010e\3\2\2\2\u0111"+
		"\u0113\5a\61\2\u0112\u0111\3\2\2\2\u0113\u0114\3\2\2\2\u0114\u0112\3\2"+
		"\2\2\u0114\u0115\3\2\2\2\u0115Z\3\2\2\2\u0116\u0117\7\61\2\2\u0117\u0118"+
		"\7\61\2\2\u0118\u011c\3\2\2\2\u0119\u011b\n\2\2\2\u011a\u0119\3\2\2\2"+
		"\u011b\u011e\3\2\2\2\u011c\u011a\3\2\2\2\u011c\u011d\3\2\2\2\u011d\u011f"+
		"\3\2\2\2\u011e\u011c\3\2\2\2\u011f\u0120\b.\2\2\u0120\\\3\2\2\2\u0121"+
		"\u0122\7\61\2\2\u0122\u0123\7,\2\2\u0123\u0127\3\2\2\2\u0124\u0126\13"+
		"\2\2\2\u0125\u0124\3\2\2\2\u0126\u0129\3\2\2\2\u0127\u0128\3\2\2\2\u0127"+
		"\u0125\3\2\2\2\u0128\u012a\3\2\2\2\u0129\u0127\3\2\2\2\u012a\u012b\7,"+
		"\2\2\u012b\u012c\7\61\2\2\u012c\u012d\3\2\2\2\u012d\u012e\b/\3\2\u012e"+
		"^\3\2\2\2\u012f\u0131\t\3\2\2\u0130\u012f\3\2\2\2\u0131\u0132\3\2\2\2"+
		"\u0132\u0130\3\2\2\2\u0132\u0133\3\2\2\2\u0133\u0134\3\2\2\2\u0134\u0135"+
		"\b\60\4\2\u0135`\3\2\2\2\u0136\u0137\4\62;\2\u0137b\3\2\2\2\u0138\u0139"+
		"\t\4\2\2\u0139d\3\2\2\2\u013a\u013b\7^\2\2\u013b\u013f\7$\2\2\u013c\u013d"+
		"\7^\2\2\u013d\u013f\7^\2\2\u013e\u013a\3\2\2\2\u013e\u013c\3\2\2\2\u013f"+
		"f\3\2\2\2\20\2\u0098\u00f2\u00f7\u00f9\u0102\u0104\u010c\u010e\u0114\u011c"+
		"\u0127\u0132\u013e";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}