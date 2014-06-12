// Generated from D:\studie\Compilerbouw\bramspr\bramspr\src\BramsprLexer.g4 by ANTLR 4.1
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
		TYPE=26, PRINT=27, GETINT=28, GETCHAR=29, GETBOOL=30, ENUM=31, COLON=32, 
		SEMICOLON=33, LEFT_PARENTHESIS=34, RIGHT_PARENTHESIS=35, LEFT_BRACE=36, 
		RIGHT_BRACE=37, LEFT_BLOCKBRACE=38, RIGHT_BLOCKBRACE=39, COMMA=40, STRING=41, 
		CHARACTER=42, IDENTIFIER=43, NUMBER=44, TRUE=45, FALSE=46, BOOL=47, COMMENT=48, 
		BLOCKCOMMENT=49, WHITESPACE=50;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"':='", "'<>'", "'+'", "'-'", "'*'", "'/'", "'%'", "SMALLER_THAN", "'<='", 
		"GREATER_THAN", "'>='", "'='", "'=/='", "'+-'", "'^'", "'!'", "'&'", "'|'", 
		"'!&'", "LOGIC", "'if'", "'then'", "'else'", "'while'", "'function'", 
		"'type'", "'print'", "'getint'", "'getchar'", "'getbool'", "'enum'", "':'", 
		"';'", "'('", "')'", "'{'", "'}'", "'['", "']'", "','", "STRING", "CHARACTER", 
		"IDENTIFIER", "NUMBER", "'true'", "'false'", "BOOL", "COMMENT", "BLOCKCOMMENT", 
		"WHITESPACE"
	};
	public static final String[] ruleNames = {
		"BECOMES", "SWAP", "PLUS", "MINUS", "MULTIPLICATION", "DIVISION", "MODULUS", 
		"SMALLER_THAN", "SMALLER_THAN_EQUALS_TO", "GREATER_THAN", "GREATER_THAN_EQUALS_TO", 
		"EQUALS_TO", "NOT_EQUALS_TO", "PLUSMINUS", "POWER", "NOT", "AND", "OR", 
		"XOR", "LOGIC", "IF", "THEN", "ELSE", "WHILE", "FUNCTION", "TYPE", "PRINT", 
		"GETINT", "GETCHAR", "GETBOOL", "ENUM", "COLON", "SEMICOLON", "LEFT_PARENTHESIS", 
		"RIGHT_PARENTHESIS", "LEFT_BRACE", "RIGHT_BRACE", "LEFT_BLOCKBRACE", "RIGHT_BLOCKBRACE", 
		"COMMA", "STRING", "CHARACTER", "IDENTIFIER", "NUMBER", "TRUE", "FALSE", 
		"BOOL", "COMMENT", "BLOCKCOMMENT", "WHITESPACE", "DIGIT", "LETTER", "ESCAPED"
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
		case 47: COMMENT_action((RuleContext)_localctx, actionIndex); break;

		case 48: BLOCKCOMMENT_action((RuleContext)_localctx, actionIndex); break;

		case 49: WHITESPACE_action((RuleContext)_localctx, actionIndex); break;
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
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\2\64\u0150\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\4\65\t\65\4\66\t\66\3\2\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\5\3\5\3\6"+
		"\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3\r\3\r"+
		"\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23"+
		"\3\23\3\24\3\24\3\24\3\25\3\25\3\25\5\25\u009f\n\25\3\26\3\26\3\26\3\27"+
		"\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33"+
		"\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35"+
		"\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3\37"+
		"\3\37\3\37\3 \3 \3 \3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3"+
		"\'\3(\3(\3)\3)\3*\3*\3*\7*\u00f9\n*\f*\16*\u00fc\13*\3*\3*\3+\3+\3+\3"+
		"+\7+\u0104\n+\f+\16+\u0107\13+\3+\3+\3,\3,\3,\7,\u010e\n,\f,\16,\u0111"+
		"\13,\3-\6-\u0114\n-\r-\16-\u0115\3.\3.\3.\3.\3.\3/\3/\3/\3/\3/\3/\3\60"+
		"\3\60\5\60\u0125\n\60\3\61\3\61\3\61\3\61\7\61\u012b\n\61\f\61\16\61\u012e"+
		"\13\61\3\61\3\61\3\62\3\62\3\62\3\62\7\62\u0136\n\62\f\62\16\62\u0139"+
		"\13\62\3\62\3\62\3\62\3\62\3\62\3\63\6\63\u0141\n\63\r\63\16\63\u0142"+
		"\3\63\3\63\3\64\3\64\3\65\3\65\3\66\3\66\3\66\3\66\5\66\u014f\n\66\5\u00fa"+
		"\u0105\u0137\67\3\3\1\5\4\1\7\5\1\t\6\1\13\7\1\r\b\1\17\t\1\21\n\1\23"+
		"\13\1\25\f\1\27\r\1\31\16\1\33\17\1\35\20\1\37\21\1!\22\1#\23\1%\24\1"+
		"\'\25\1)\26\1+\27\1-\30\1/\31\1\61\32\1\63\33\1\65\34\1\67\35\19\36\1"+
		";\37\1= \1?!\1A\"\1C#\1E$\1G%\1I&\1K\'\1M(\1O)\1Q*\1S+\1U,\1W-\1Y.\1["+
		"/\1]\60\1_\61\1a\62\2c\63\3e\64\4g\2\1i\2\1k\2\1\3\2\5\4\2\f\f\17\17\5"+
		"\2\13\f\16\17\"\"\4\2C\\c|\u015a\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2"+
		"\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2"+
		"\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2"+
		"\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2"+
		"\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2"+
		"\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2"+
		"\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O"+
		"\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2"+
		"\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\3m\3\2\2\2"+
		"\5p\3\2\2\2\7s\3\2\2\2\tu\3\2\2\2\13w\3\2\2\2\ry\3\2\2\2\17{\3\2\2\2\21"+
		"}\3\2\2\2\23\177\3\2\2\2\25\u0082\3\2\2\2\27\u0084\3\2\2\2\31\u0087\3"+
		"\2\2\2\33\u0089\3\2\2\2\35\u008d\3\2\2\2\37\u0090\3\2\2\2!\u0092\3\2\2"+
		"\2#\u0094\3\2\2\2%\u0096\3\2\2\2\'\u0098\3\2\2\2)\u009e\3\2\2\2+\u00a0"+
		"\3\2\2\2-\u00a3\3\2\2\2/\u00a8\3\2\2\2\61\u00ad\3\2\2\2\63\u00b3\3\2\2"+
		"\2\65\u00bc\3\2\2\2\67\u00c1\3\2\2\29\u00c7\3\2\2\2;\u00ce\3\2\2\2=\u00d6"+
		"\3\2\2\2?\u00de\3\2\2\2A\u00e3\3\2\2\2C\u00e5\3\2\2\2E\u00e7\3\2\2\2G"+
		"\u00e9\3\2\2\2I\u00eb\3\2\2\2K\u00ed\3\2\2\2M\u00ef\3\2\2\2O\u00f1\3\2"+
		"\2\2Q\u00f3\3\2\2\2S\u00f5\3\2\2\2U\u00ff\3\2\2\2W\u010a\3\2\2\2Y\u0113"+
		"\3\2\2\2[\u0117\3\2\2\2]\u011c\3\2\2\2_\u0124\3\2\2\2a\u0126\3\2\2\2c"+
		"\u0131\3\2\2\2e\u0140\3\2\2\2g\u0146\3\2\2\2i\u0148\3\2\2\2k\u014e\3\2"+
		"\2\2mn\7<\2\2no\7?\2\2o\4\3\2\2\2pq\7>\2\2qr\7@\2\2r\6\3\2\2\2st\7-\2"+
		"\2t\b\3\2\2\2uv\7/\2\2v\n\3\2\2\2wx\7,\2\2x\f\3\2\2\2yz\7\61\2\2z\16\3"+
		"\2\2\2{|\7\'\2\2|\20\3\2\2\2}~\7@\2\2~\22\3\2\2\2\177\u0080\7>\2\2\u0080"+
		"\u0081\7?\2\2\u0081\24\3\2\2\2\u0082\u0083\7@\2\2\u0083\26\3\2\2\2\u0084"+
		"\u0085\7@\2\2\u0085\u0086\7?\2\2\u0086\30\3\2\2\2\u0087\u0088\7?\2\2\u0088"+
		"\32\3\2\2\2\u0089\u008a\7?\2\2\u008a\u008b\7\61\2\2\u008b\u008c\7?\2\2"+
		"\u008c\34\3\2\2\2\u008d\u008e\7-\2\2\u008e\u008f\7/\2\2\u008f\36\3\2\2"+
		"\2\u0090\u0091\7`\2\2\u0091 \3\2\2\2\u0092\u0093\7#\2\2\u0093\"\3\2\2"+
		"\2\u0094\u0095\7(\2\2\u0095$\3\2\2\2\u0096\u0097\7~\2\2\u0097&\3\2\2\2"+
		"\u0098\u0099\7#\2\2\u0099\u009a\7(\2\2\u009a(\3\2\2\2\u009b\u009f\5#\22"+
		"\2\u009c\u009f\5%\23\2\u009d\u009f\5\'\24\2\u009e\u009b\3\2\2\2\u009e"+
		"\u009c\3\2\2\2\u009e\u009d\3\2\2\2\u009f*\3\2\2\2\u00a0\u00a1\7k\2\2\u00a1"+
		"\u00a2\7h\2\2\u00a2,\3\2\2\2\u00a3\u00a4\7v\2\2\u00a4\u00a5\7j\2\2\u00a5"+
		"\u00a6\7g\2\2\u00a6\u00a7\7p\2\2\u00a7.\3\2\2\2\u00a8\u00a9\7g\2\2\u00a9"+
		"\u00aa\7n\2\2\u00aa\u00ab\7u\2\2\u00ab\u00ac\7g\2\2\u00ac\60\3\2\2\2\u00ad"+
		"\u00ae\7y\2\2\u00ae\u00af\7j\2\2\u00af\u00b0\7k\2\2\u00b0\u00b1\7n\2\2"+
		"\u00b1\u00b2\7g\2\2\u00b2\62\3\2\2\2\u00b3\u00b4\7h\2\2\u00b4\u00b5\7"+
		"w\2\2\u00b5\u00b6\7p\2\2\u00b6\u00b7\7e\2\2\u00b7\u00b8\7v\2\2\u00b8\u00b9"+
		"\7k\2\2\u00b9\u00ba\7q\2\2\u00ba\u00bb\7p\2\2\u00bb\64\3\2\2\2\u00bc\u00bd"+
		"\7v\2\2\u00bd\u00be\7{\2\2\u00be\u00bf\7r\2\2\u00bf\u00c0\7g\2\2\u00c0"+
		"\66\3\2\2\2\u00c1\u00c2\7r\2\2\u00c2\u00c3\7t\2\2\u00c3\u00c4\7k\2\2\u00c4"+
		"\u00c5\7p\2\2\u00c5\u00c6\7v\2\2\u00c68\3\2\2\2\u00c7\u00c8\7i\2\2\u00c8"+
		"\u00c9\7g\2\2\u00c9\u00ca\7v\2\2\u00ca\u00cb\7k\2\2\u00cb\u00cc\7p\2\2"+
		"\u00cc\u00cd\7v\2\2\u00cd:\3\2\2\2\u00ce\u00cf\7i\2\2\u00cf\u00d0\7g\2"+
		"\2\u00d0\u00d1\7v\2\2\u00d1\u00d2\7e\2\2\u00d2\u00d3\7j\2\2\u00d3\u00d4"+
		"\7c\2\2\u00d4\u00d5\7t\2\2\u00d5<\3\2\2\2\u00d6\u00d7\7i\2\2\u00d7\u00d8"+
		"\7g\2\2\u00d8\u00d9\7v\2\2\u00d9\u00da\7d\2\2\u00da\u00db\7q\2\2\u00db"+
		"\u00dc\7q\2\2\u00dc\u00dd\7n\2\2\u00dd>\3\2\2\2\u00de\u00df\7g\2\2\u00df"+
		"\u00e0\7p\2\2\u00e0\u00e1\7w\2\2\u00e1\u00e2\7o\2\2\u00e2@\3\2\2\2\u00e3"+
		"\u00e4\7<\2\2\u00e4B\3\2\2\2\u00e5\u00e6\7=\2\2\u00e6D\3\2\2\2\u00e7\u00e8"+
		"\7*\2\2\u00e8F\3\2\2\2\u00e9\u00ea\7+\2\2\u00eaH\3\2\2\2\u00eb\u00ec\7"+
		"}\2\2\u00ecJ\3\2\2\2\u00ed\u00ee\7\177\2\2\u00eeL\3\2\2\2\u00ef\u00f0"+
		"\7]\2\2\u00f0N\3\2\2\2\u00f1\u00f2\7_\2\2\u00f2P\3\2\2\2\u00f3\u00f4\7"+
		".\2\2\u00f4R\3\2\2\2\u00f5\u00fa\7$\2\2\u00f6\u00f9\5k\66\2\u00f7\u00f9"+
		"\n\2\2\2\u00f8\u00f6\3\2\2\2\u00f8\u00f7\3\2\2\2\u00f9\u00fc\3\2\2\2\u00fa"+
		"\u00fb\3\2\2\2\u00fa\u00f8\3\2\2\2\u00fb\u00fd\3\2\2\2\u00fc\u00fa\3\2"+
		"\2\2\u00fd\u00fe\7$\2\2\u00feT\3\2\2\2\u00ff\u0105\7)\2\2\u0100\u0101"+
		"\7^\2\2\u0101\u0104\7)\2\2\u0102\u0104\n\2\2\2\u0103\u0100\3\2\2\2\u0103"+
		"\u0102\3\2\2\2\u0104\u0107\3\2\2\2\u0105\u0106\3\2\2\2\u0105\u0103\3\2"+
		"\2\2\u0106\u0108\3\2\2\2\u0107\u0105\3\2\2\2\u0108\u0109\7)\2\2\u0109"+
		"V\3\2\2\2\u010a\u010f\5i\65\2\u010b\u010e\5i\65\2\u010c\u010e\5g\64\2"+
		"\u010d\u010b\3\2\2\2\u010d\u010c\3\2\2\2\u010e\u0111\3\2\2\2\u010f\u010d"+
		"\3\2\2\2\u010f\u0110\3\2\2\2\u0110X\3\2\2\2\u0111\u010f\3\2\2\2\u0112"+
		"\u0114\5g\64\2\u0113\u0112\3\2\2\2\u0114\u0115\3\2\2\2\u0115\u0113\3\2"+
		"\2\2\u0115\u0116\3\2\2\2\u0116Z\3\2\2\2\u0117\u0118\7v\2\2\u0118\u0119"+
		"\7t\2\2\u0119\u011a\7w\2\2\u011a\u011b\7g\2\2\u011b\\\3\2\2\2\u011c\u011d"+
		"\7h\2\2\u011d\u011e\7c\2\2\u011e\u011f\7n\2\2\u011f\u0120\7u\2\2\u0120"+
		"\u0121\7g\2\2\u0121^\3\2\2\2\u0122\u0125\5[.\2\u0123\u0125\5]/\2\u0124"+
		"\u0122\3\2\2\2\u0124\u0123\3\2\2\2\u0125`\3\2\2\2\u0126\u0127\7\61\2\2"+
		"\u0127\u0128\7\61\2\2\u0128\u012c\3\2\2\2\u0129\u012b\n\2\2\2\u012a\u0129"+
		"\3\2\2\2\u012b\u012e\3\2\2\2\u012c\u012a\3\2\2\2\u012c\u012d\3\2\2\2\u012d"+
		"\u012f\3\2\2\2\u012e\u012c\3\2\2\2\u012f\u0130\b\61\2\2\u0130b\3\2\2\2"+
		"\u0131\u0132\7\61\2\2\u0132\u0133\7,\2\2\u0133\u0137\3\2\2\2\u0134\u0136"+
		"\13\2\2\2\u0135\u0134\3\2\2\2\u0136\u0139\3\2\2\2\u0137\u0138\3\2\2\2"+
		"\u0137\u0135\3\2\2\2\u0138\u013a\3\2\2\2\u0139\u0137\3\2\2\2\u013a\u013b"+
		"\7,\2\2\u013b\u013c\7\61\2\2\u013c\u013d\3\2\2\2\u013d\u013e\b\62\3\2"+
		"\u013ed\3\2\2\2\u013f\u0141\t\3\2\2\u0140\u013f\3\2\2\2\u0141\u0142\3"+
		"\2\2\2\u0142\u0140\3\2\2\2\u0142\u0143\3\2\2\2\u0143\u0144\3\2\2\2\u0144"+
		"\u0145\b\63\4\2\u0145f\3\2\2\2\u0146\u0147\4\62;\2\u0147h\3\2\2\2\u0148"+
		"\u0149\t\4\2\2\u0149j\3\2\2\2\u014a\u014b\7^\2\2\u014b\u014f\7$\2\2\u014c"+
		"\u014d\7^\2\2\u014d\u014f\7^\2\2\u014e\u014a\3\2\2\2\u014e\u014c\3\2\2"+
		"\2\u014fl\3\2\2\2\20\2\u009e\u00f8\u00fa\u0103\u0105\u010d\u010f\u0115"+
		"\u0124\u012c\u0137\u0142\u014e";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}