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
		TYPE=26, PRINT=27, GETINT=28, GETCHAR=29, GETBOOL=30, PUTINT=31, PUTCHAR=32, 
		PUTBOOL=33, PUTSTRING=34, ENUM=35, RETURN=36, FINAL=37, COLON=38, SEMICOLON=39, 
		LEFT_PARENTHESIS=40, RIGHT_PARENTHESIS=41, LEFT_BRACE=42, RIGHT_BRACE=43, 
		LEFT_BLOCKBRACE=44, RIGHT_BLOCKBRACE=45, COMMA=46, DOT=47, BOOL=48, STRING=49, 
		CHARACTER=50, IDENTIFIER=51, NUMBER=52, COMMENT=53, BLOCKCOMMENT=54, WHITESPACE=55;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"':='", "'<>'", "'+'", "'-'", "'*'", "'/'", "'%'", "'<'", "'<='", "'>'", 
		"'>='", "'='", "'=/='", "'+-'", "'^'", "'!'", "'&'", "'|'", "'!&'", "LOGIC", 
		"'if'", "'then'", "'else'", "'while'", "'function'", "'type'", "'print'", 
		"'getInt'", "'getChar'", "'getBool'", "'putInt'", "'putChar'", "'putBool'", 
		"'putString'", "'enum'", "'return'", "'final'", "':'", "';'", "'('", "')'", 
		"'{'", "'}'", "'['", "']'", "','", "'.'", "BOOL", "STRING", "CHARACTER", 
		"IDENTIFIER", "NUMBER", "COMMENT", "BLOCKCOMMENT", "WHITESPACE"
	};
	public static final String[] ruleNames = {
		"BECOMES", "SWAP", "PLUS", "MINUS", "MULTIPLICATION", "DIVISION", "MODULUS", 
		"SMALLER_THAN", "SMALLER_THAN_EQUALS_TO", "GREATER_THAN", "GREATER_THAN_EQUALS_TO", 
		"EQUALS_TO", "NOT_EQUALS_TO", "PLUSMINUS", "POWER", "NOT", "AND", "OR", 
		"XOR", "LOGIC", "IF", "THEN", "ELSE", "WHILE", "FUNCTION", "TYPE", "PRINT", 
		"GETINT", "GETCHAR", "GETBOOL", "PUTINT", "PUTCHAR", "PUTBOOL", "PUTSTRING", 
		"ENUM", "RETURN", "FINAL", "COLON", "SEMICOLON", "LEFT_PARENTHESIS", "RIGHT_PARENTHESIS", 
		"LEFT_BRACE", "RIGHT_BRACE", "LEFT_BLOCKBRACE", "RIGHT_BLOCKBRACE", "COMMA", 
		"DOT", "BOOL", "STRING", "CHARACTER", "IDENTIFIER", "NUMBER", "COMMENT", 
		"BLOCKCOMMENT", "WHITESPACE", "DIGIT", "LETTER", "ESCAPED"
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
		case 52: COMMENT_action((RuleContext)_localctx, actionIndex); break;

		case 53: BLOCKCOMMENT_action((RuleContext)_localctx, actionIndex); break;

		case 54: WHITESPACE_action((RuleContext)_localctx, actionIndex); break;
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
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\29\u0186\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\3\2\3\2\3\2"+
		"\3\3\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3"+
		"\n\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3"+
		"\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3\25\5"+
		"\25\u00a9\n\25\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30"+
		"\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32"+
		"\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34"+
		"\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36"+
		"\3\36\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3 \3 \3 \3!"+
		"\3!\3!\3!\3!\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3#\3"+
		"#\3#\3#\3#\3#\3$\3$\3$\3$\3$\3%\3%\3%\3%\3%\3%\3%\3&\3&\3&\3&\3&\3&\3"+
		"\'\3\'\3(\3(\3)\3)\3*\3*\3+\3+\3,\3,\3-\3-\3.\3.\3/\3/\3\60\3\60\3\61"+
		"\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\5\61\u0139\n\61\3\62\3\62\3\62"+
		"\7\62\u013e\n\62\f\62\16\62\u0141\13\62\3\62\3\62\3\63\3\63\3\63\3\63"+
		"\7\63\u0149\n\63\f\63\16\63\u014c\13\63\3\63\3\63\3\64\3\64\3\64\7\64"+
		"\u0153\n\64\f\64\16\64\u0156\13\64\3\65\6\65\u0159\n\65\r\65\16\65\u015a"+
		"\3\66\3\66\3\66\3\66\7\66\u0161\n\66\f\66\16\66\u0164\13\66\3\66\3\66"+
		"\3\67\3\67\3\67\3\67\7\67\u016c\n\67\f\67\16\67\u016f\13\67\3\67\3\67"+
		"\3\67\3\67\3\67\38\68\u0177\n8\r8\168\u0178\38\38\39\39\3:\3:\3;\3;\3"+
		";\3;\5;\u0185\n;\5\u013f\u014a\u016d<\3\3\1\5\4\1\7\5\1\t\6\1\13\7\1\r"+
		"\b\1\17\t\1\21\n\1\23\13\1\25\f\1\27\r\1\31\16\1\33\17\1\35\20\1\37\21"+
		"\1!\22\1#\23\1%\24\1\'\25\1)\26\1+\27\1-\30\1/\31\1\61\32\1\63\33\1\65"+
		"\34\1\67\35\19\36\1;\37\1= \1?!\1A\"\1C#\1E$\1G%\1I&\1K\'\1M(\1O)\1Q*"+
		"\1S+\1U,\1W-\1Y.\1[/\1]\60\1_\61\1a\62\1c\63\1e\64\1g\65\1i\66\1k\67\2"+
		"m8\3o9\4q\2\1s\2\1u\2\1\3\2\5\4\2\f\f\17\17\5\2\13\f\16\17\"\"\4\2C\\"+
		"c|\u0190\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2"+
		"\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27"+
		"\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2"+
		"\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2"+
		"\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2"+
		"\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2"+
		"\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S"+
		"\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2"+
		"\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2"+
		"\2m\3\2\2\2\2o\3\2\2\2\3w\3\2\2\2\5z\3\2\2\2\7}\3\2\2\2\t\177\3\2\2\2"+
		"\13\u0081\3\2\2\2\r\u0083\3\2\2\2\17\u0085\3\2\2\2\21\u0087\3\2\2\2\23"+
		"\u0089\3\2\2\2\25\u008c\3\2\2\2\27\u008e\3\2\2\2\31\u0091\3\2\2\2\33\u0093"+
		"\3\2\2\2\35\u0097\3\2\2\2\37\u009a\3\2\2\2!\u009c\3\2\2\2#\u009e\3\2\2"+
		"\2%\u00a0\3\2\2\2\'\u00a2\3\2\2\2)\u00a8\3\2\2\2+\u00aa\3\2\2\2-\u00ad"+
		"\3\2\2\2/\u00b2\3\2\2\2\61\u00b7\3\2\2\2\63\u00bd\3\2\2\2\65\u00c6\3\2"+
		"\2\2\67\u00cb\3\2\2\29\u00d1\3\2\2\2;\u00d8\3\2\2\2=\u00e0\3\2\2\2?\u00e8"+
		"\3\2\2\2A\u00ef\3\2\2\2C\u00f7\3\2\2\2E\u00ff\3\2\2\2G\u0109\3\2\2\2I"+
		"\u010e\3\2\2\2K\u0115\3\2\2\2M\u011b\3\2\2\2O\u011d\3\2\2\2Q\u011f\3\2"+
		"\2\2S\u0121\3\2\2\2U\u0123\3\2\2\2W\u0125\3\2\2\2Y\u0127\3\2\2\2[\u0129"+
		"\3\2\2\2]\u012b\3\2\2\2_\u012d\3\2\2\2a\u0138\3\2\2\2c\u013a\3\2\2\2e"+
		"\u0144\3\2\2\2g\u014f\3\2\2\2i\u0158\3\2\2\2k\u015c\3\2\2\2m\u0167\3\2"+
		"\2\2o\u0176\3\2\2\2q\u017c\3\2\2\2s\u017e\3\2\2\2u\u0184\3\2\2\2wx\7<"+
		"\2\2xy\7?\2\2y\4\3\2\2\2z{\7>\2\2{|\7@\2\2|\6\3\2\2\2}~\7-\2\2~\b\3\2"+
		"\2\2\177\u0080\7/\2\2\u0080\n\3\2\2\2\u0081\u0082\7,\2\2\u0082\f\3\2\2"+
		"\2\u0083\u0084\7\61\2\2\u0084\16\3\2\2\2\u0085\u0086\7\'\2\2\u0086\20"+
		"\3\2\2\2\u0087\u0088\7>\2\2\u0088\22\3\2\2\2\u0089\u008a\7>\2\2\u008a"+
		"\u008b\7?\2\2\u008b\24\3\2\2\2\u008c\u008d\7@\2\2\u008d\26\3\2\2\2\u008e"+
		"\u008f\7@\2\2\u008f\u0090\7?\2\2\u0090\30\3\2\2\2\u0091\u0092\7?\2\2\u0092"+
		"\32\3\2\2\2\u0093\u0094\7?\2\2\u0094\u0095\7\61\2\2\u0095\u0096\7?\2\2"+
		"\u0096\34\3\2\2\2\u0097\u0098\7-\2\2\u0098\u0099\7/\2\2\u0099\36\3\2\2"+
		"\2\u009a\u009b\7`\2\2\u009b \3\2\2\2\u009c\u009d\7#\2\2\u009d\"\3\2\2"+
		"\2\u009e\u009f\7(\2\2\u009f$\3\2\2\2\u00a0\u00a1\7~\2\2\u00a1&\3\2\2\2"+
		"\u00a2\u00a3\7#\2\2\u00a3\u00a4\7(\2\2\u00a4(\3\2\2\2\u00a5\u00a9\5#\22"+
		"\2\u00a6\u00a9\5%\23\2\u00a7\u00a9\5\'\24\2\u00a8\u00a5\3\2\2\2\u00a8"+
		"\u00a6\3\2\2\2\u00a8\u00a7\3\2\2\2\u00a9*\3\2\2\2\u00aa\u00ab\7k\2\2\u00ab"+
		"\u00ac\7h\2\2\u00ac,\3\2\2\2\u00ad\u00ae\7v\2\2\u00ae\u00af\7j\2\2\u00af"+
		"\u00b0\7g\2\2\u00b0\u00b1\7p\2\2\u00b1.\3\2\2\2\u00b2\u00b3\7g\2\2\u00b3"+
		"\u00b4\7n\2\2\u00b4\u00b5\7u\2\2\u00b5\u00b6\7g\2\2\u00b6\60\3\2\2\2\u00b7"+
		"\u00b8\7y\2\2\u00b8\u00b9\7j\2\2\u00b9\u00ba\7k\2\2\u00ba\u00bb\7n\2\2"+
		"\u00bb\u00bc\7g\2\2\u00bc\62\3\2\2\2\u00bd\u00be\7h\2\2\u00be\u00bf\7"+
		"w\2\2\u00bf\u00c0\7p\2\2\u00c0\u00c1\7e\2\2\u00c1\u00c2\7v\2\2\u00c2\u00c3"+
		"\7k\2\2\u00c3\u00c4\7q\2\2\u00c4\u00c5\7p\2\2\u00c5\64\3\2\2\2\u00c6\u00c7"+
		"\7v\2\2\u00c7\u00c8\7{\2\2\u00c8\u00c9\7r\2\2\u00c9\u00ca\7g\2\2\u00ca"+
		"\66\3\2\2\2\u00cb\u00cc\7r\2\2\u00cc\u00cd\7t\2\2\u00cd\u00ce\7k\2\2\u00ce"+
		"\u00cf\7p\2\2\u00cf\u00d0\7v\2\2\u00d08\3\2\2\2\u00d1\u00d2\7i\2\2\u00d2"+
		"\u00d3\7g\2\2\u00d3\u00d4\7v\2\2\u00d4\u00d5\7K\2\2\u00d5\u00d6\7p\2\2"+
		"\u00d6\u00d7\7v\2\2\u00d7:\3\2\2\2\u00d8\u00d9\7i\2\2\u00d9\u00da\7g\2"+
		"\2\u00da\u00db\7v\2\2\u00db\u00dc\7E\2\2\u00dc\u00dd\7j\2\2\u00dd\u00de"+
		"\7c\2\2\u00de\u00df\7t\2\2\u00df<\3\2\2\2\u00e0\u00e1\7i\2\2\u00e1\u00e2"+
		"\7g\2\2\u00e2\u00e3\7v\2\2\u00e3\u00e4\7D\2\2\u00e4\u00e5\7q\2\2\u00e5"+
		"\u00e6\7q\2\2\u00e6\u00e7\7n\2\2\u00e7>\3\2\2\2\u00e8\u00e9\7r\2\2\u00e9"+
		"\u00ea\7w\2\2\u00ea\u00eb\7v\2\2\u00eb\u00ec\7K\2\2\u00ec\u00ed\7p\2\2"+
		"\u00ed\u00ee\7v\2\2\u00ee@\3\2\2\2\u00ef\u00f0\7r\2\2\u00f0\u00f1\7w\2"+
		"\2\u00f1\u00f2\7v\2\2\u00f2\u00f3\7E\2\2\u00f3\u00f4\7j\2\2\u00f4\u00f5"+
		"\7c\2\2\u00f5\u00f6\7t\2\2\u00f6B\3\2\2\2\u00f7\u00f8\7r\2\2\u00f8\u00f9"+
		"\7w\2\2\u00f9\u00fa\7v\2\2\u00fa\u00fb\7D\2\2\u00fb\u00fc\7q\2\2\u00fc"+
		"\u00fd\7q\2\2\u00fd\u00fe\7n\2\2\u00feD\3\2\2\2\u00ff\u0100\7r\2\2\u0100"+
		"\u0101\7w\2\2\u0101\u0102\7v\2\2\u0102\u0103\7U\2\2\u0103\u0104\7v\2\2"+
		"\u0104\u0105\7t\2\2\u0105\u0106\7k\2\2\u0106\u0107\7p\2\2\u0107\u0108"+
		"\7i\2\2\u0108F\3\2\2\2\u0109\u010a\7g\2\2\u010a\u010b\7p\2\2\u010b\u010c"+
		"\7w\2\2\u010c\u010d\7o\2\2\u010dH\3\2\2\2\u010e\u010f\7t\2\2\u010f\u0110"+
		"\7g\2\2\u0110\u0111\7v\2\2\u0111\u0112\7w\2\2\u0112\u0113\7t\2\2\u0113"+
		"\u0114\7p\2\2\u0114J\3\2\2\2\u0115\u0116\7h\2\2\u0116\u0117\7k\2\2\u0117"+
		"\u0118\7p\2\2\u0118\u0119\7c\2\2\u0119\u011a\7n\2\2\u011aL\3\2\2\2\u011b"+
		"\u011c\7<\2\2\u011cN\3\2\2\2\u011d\u011e\7=\2\2\u011eP\3\2\2\2\u011f\u0120"+
		"\7*\2\2\u0120R\3\2\2\2\u0121\u0122\7+\2\2\u0122T\3\2\2\2\u0123\u0124\7"+
		"}\2\2\u0124V\3\2\2\2\u0125\u0126\7\177\2\2\u0126X\3\2\2\2\u0127\u0128"+
		"\7]\2\2\u0128Z\3\2\2\2\u0129\u012a\7_\2\2\u012a\\\3\2\2\2\u012b\u012c"+
		"\7.\2\2\u012c^\3\2\2\2\u012d\u012e\7\60\2\2\u012e`\3\2\2\2\u012f\u0130"+
		"\7v\2\2\u0130\u0131\7t\2\2\u0131\u0132\7w\2\2\u0132\u0139\7g\2\2\u0133"+
		"\u0134\7h\2\2\u0134\u0135\7c\2\2\u0135\u0136\7n\2\2\u0136\u0137\7u\2\2"+
		"\u0137\u0139\7g\2\2\u0138\u012f\3\2\2\2\u0138\u0133\3\2\2\2\u0139b\3\2"+
		"\2\2\u013a\u013f\7$\2\2\u013b\u013e\5u;\2\u013c\u013e\n\2\2\2\u013d\u013b"+
		"\3\2\2\2\u013d\u013c\3\2\2\2\u013e\u0141\3\2\2\2\u013f\u0140\3\2\2\2\u013f"+
		"\u013d\3\2\2\2\u0140\u0142\3\2\2\2\u0141\u013f\3\2\2\2\u0142\u0143\7$"+
		"\2\2\u0143d\3\2\2\2\u0144\u014a\7)\2\2\u0145\u0146\7^\2\2\u0146\u0149"+
		"\7)\2\2\u0147\u0149\n\2\2\2\u0148\u0145\3\2\2\2\u0148\u0147\3\2\2\2\u0149"+
		"\u014c\3\2\2\2\u014a\u014b\3\2\2\2\u014a\u0148\3\2\2\2\u014b\u014d\3\2"+
		"\2\2\u014c\u014a\3\2\2\2\u014d\u014e\7)\2\2\u014ef\3\2\2\2\u014f\u0154"+
		"\5s:\2\u0150\u0153\5s:\2\u0151\u0153\5q9\2\u0152\u0150\3\2\2\2\u0152\u0151"+
		"\3\2\2\2\u0153\u0156\3\2\2\2\u0154\u0152\3\2\2\2\u0154\u0155\3\2\2\2\u0155"+
		"h\3\2\2\2\u0156\u0154\3\2\2\2\u0157\u0159\5q9\2\u0158\u0157\3\2\2\2\u0159"+
		"\u015a\3\2\2\2\u015a\u0158\3\2\2\2\u015a\u015b\3\2\2\2\u015bj\3\2\2\2"+
		"\u015c\u015d\7\61\2\2\u015d\u015e\7\61\2\2\u015e\u0162\3\2\2\2\u015f\u0161"+
		"\n\2\2\2\u0160\u015f\3\2\2\2\u0161\u0164\3\2\2\2\u0162\u0160\3\2\2\2\u0162"+
		"\u0163\3\2\2\2\u0163\u0165\3\2\2\2\u0164\u0162\3\2\2\2\u0165\u0166\b\66"+
		"\2\2\u0166l\3\2\2\2\u0167\u0168\7\61\2\2\u0168\u0169\7,\2\2\u0169\u016d"+
		"\3\2\2\2\u016a\u016c\13\2\2\2\u016b\u016a\3\2\2\2\u016c\u016f\3\2\2\2"+
		"\u016d\u016e\3\2\2\2\u016d\u016b\3\2\2\2\u016e\u0170\3\2\2\2\u016f\u016d"+
		"\3\2\2\2\u0170\u0171\7,\2\2\u0171\u0172\7\61\2\2\u0172\u0173\3\2\2\2\u0173"+
		"\u0174\b\67\3\2\u0174n\3\2\2\2\u0175\u0177\t\3\2\2\u0176\u0175\3\2\2\2"+
		"\u0177\u0178\3\2\2\2\u0178\u0176\3\2\2\2\u0178\u0179\3\2\2\2\u0179\u017a"+
		"\3\2\2\2\u017a\u017b\b8\4\2\u017bp\3\2\2\2\u017c\u017d\4\62;\2\u017dr"+
		"\3\2\2\2\u017e\u017f\t\4\2\2\u017ft\3\2\2\2\u0180\u0181\7^\2\2\u0181\u0185"+
		"\7$\2\2\u0182\u0183\7^\2\2\u0183\u0185\7^\2\2\u0184\u0180\3\2\2\2\u0184"+
		"\u0182\3\2\2\2\u0185v\3\2\2\2\20\2\u00a8\u0138\u013d\u013f\u0148\u014a"+
		"\u0152\u0154\u015a\u0162\u016d\u0178\u0184";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}