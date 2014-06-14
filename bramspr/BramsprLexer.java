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
		PUTBOOL=33, ENUM=34, RETURN=35, COLON=36, SEMICOLON=37, LEFT_PARENTHESIS=38, 
		RIGHT_PARENTHESIS=39, LEFT_BRACE=40, RIGHT_BRACE=41, LEFT_BLOCKBRACE=42, 
		RIGHT_BLOCKBRACE=43, COMMA=44, DOT=45, STRING=46, CHARACTER=47, IDENTIFIER=48, 
		NUMBER=49, TRUE=50, FALSE=51, BOOL=52, COMMENT=53, BLOCKCOMMENT=54, WHITESPACE=55;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"':='", "'<>'", "'+'", "'-'", "'*'", "'/'", "'%'", "SMALLER_THAN", "'<='", 
		"GREATER_THAN", "'>='", "'='", "'=/='", "'+-'", "'^'", "'!'", "'&'", "'|'", 
		"'!&'", "LOGIC", "'if'", "'then'", "'else'", "'while'", "'function'", 
		"'type'", "'print'", "'getint'", "'getchar'", "'getbool'", "'putint'", 
		"'putchar'", "'putbool'", "'enum'", "'return'", "':'", "';'", "'('", "')'", 
		"'{'", "'}'", "'['", "']'", "','", "'.'", "STRING", "CHARACTER", "IDENTIFIER", 
		"NUMBER", "'true'", "'false'", "BOOL", "COMMENT", "BLOCKCOMMENT", "WHITESPACE"
	};
	public static final String[] ruleNames = {
		"BECOMES", "SWAP", "PLUS", "MINUS", "MULTIPLICATION", "DIVISION", "MODULUS", 
		"SMALLER_THAN", "SMALLER_THAN_EQUALS_TO", "GREATER_THAN", "GREATER_THAN_EQUALS_TO", 
		"EQUALS_TO", "NOT_EQUALS_TO", "PLUSMINUS", "POWER", "NOT", "AND", "OR", 
		"XOR", "LOGIC", "IF", "THEN", "ELSE", "WHILE", "FUNCTION", "TYPE", "PRINT", 
		"GETINT", "GETCHAR", "GETBOOL", "PUTINT", "PUTCHAR", "PUTBOOL", "ENUM", 
		"RETURN", "COLON", "SEMICOLON", "LEFT_PARENTHESIS", "RIGHT_PARENTHESIS", 
		"LEFT_BRACE", "RIGHT_BRACE", "LEFT_BLOCKBRACE", "RIGHT_BLOCKBRACE", "COMMA", 
		"DOT", "STRING", "CHARACTER", "IDENTIFIER", "NUMBER", "TRUE", "FALSE", 
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
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\29\u017a\b\1\4\2\t"+
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
		"$\3$\3$\3$\3$\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3+\3,\3,"+
		"\3-\3-\3.\3.\3/\3/\3/\7/\u0123\n/\f/\16/\u0126\13/\3/\3/\3\60\3\60\3\60"+
		"\3\60\7\60\u012e\n\60\f\60\16\60\u0131\13\60\3\60\3\60\3\61\3\61\3\61"+
		"\7\61\u0138\n\61\f\61\16\61\u013b\13\61\3\62\6\62\u013e\n\62\r\62\16\62"+
		"\u013f\3\63\3\63\3\63\3\63\3\63\3\64\3\64\3\64\3\64\3\64\3\64\3\65\3\65"+
		"\5\65\u014f\n\65\3\66\3\66\3\66\3\66\7\66\u0155\n\66\f\66\16\66\u0158"+
		"\13\66\3\66\3\66\3\67\3\67\3\67\3\67\7\67\u0160\n\67\f\67\16\67\u0163"+
		"\13\67\3\67\3\67\3\67\3\67\3\67\38\68\u016b\n8\r8\168\u016c\38\38\39\3"+
		"9\3:\3:\3;\3;\3;\3;\5;\u0179\n;\5\u0124\u012f\u0161<\3\3\1\5\4\1\7\5\1"+
		"\t\6\1\13\7\1\r\b\1\17\t\1\21\n\1\23\13\1\25\f\1\27\r\1\31\16\1\33\17"+
		"\1\35\20\1\37\21\1!\22\1#\23\1%\24\1\'\25\1)\26\1+\27\1-\30\1/\31\1\61"+
		"\32\1\63\33\1\65\34\1\67\35\19\36\1;\37\1= \1?!\1A\"\1C#\1E$\1G%\1I&\1"+
		"K\'\1M(\1O)\1Q*\1S+\1U,\1W-\1Y.\1[/\1]\60\1_\61\1a\62\1c\63\1e\64\1g\65"+
		"\1i\66\1k\67\2m8\3o9\4q\2\1s\2\1u\2\1\3\2\5\4\2\f\f\17\17\5\2\13\f\16"+
		"\17\"\"\4\2C\\c|\u0184\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2"+
		"\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25"+
		"\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2"+
		"\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2"+
		"\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3"+
		"\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2"+
		"\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2"+
		"Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3"+
		"\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2"+
		"\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\3w\3\2\2\2\5z\3\2\2\2\7}\3\2\2\2\t"+
		"\177\3\2\2\2\13\u0081\3\2\2\2\r\u0083\3\2\2\2\17\u0085\3\2\2\2\21\u0087"+
		"\3\2\2\2\23\u0089\3\2\2\2\25\u008c\3\2\2\2\27\u008e\3\2\2\2\31\u0091\3"+
		"\2\2\2\33\u0093\3\2\2\2\35\u0097\3\2\2\2\37\u009a\3\2\2\2!\u009c\3\2\2"+
		"\2#\u009e\3\2\2\2%\u00a0\3\2\2\2\'\u00a2\3\2\2\2)\u00a8\3\2\2\2+\u00aa"+
		"\3\2\2\2-\u00ad\3\2\2\2/\u00b2\3\2\2\2\61\u00b7\3\2\2\2\63\u00bd\3\2\2"+
		"\2\65\u00c6\3\2\2\2\67\u00cb\3\2\2\29\u00d1\3\2\2\2;\u00d8\3\2\2\2=\u00e0"+
		"\3\2\2\2?\u00e8\3\2\2\2A\u00ef\3\2\2\2C\u00f7\3\2\2\2E\u00ff\3\2\2\2G"+
		"\u0104\3\2\2\2I\u010b\3\2\2\2K\u010d\3\2\2\2M\u010f\3\2\2\2O\u0111\3\2"+
		"\2\2Q\u0113\3\2\2\2S\u0115\3\2\2\2U\u0117\3\2\2\2W\u0119\3\2\2\2Y\u011b"+
		"\3\2\2\2[\u011d\3\2\2\2]\u011f\3\2\2\2_\u0129\3\2\2\2a\u0134\3\2\2\2c"+
		"\u013d\3\2\2\2e\u0141\3\2\2\2g\u0146\3\2\2\2i\u014e\3\2\2\2k\u0150\3\2"+
		"\2\2m\u015b\3\2\2\2o\u016a\3\2\2\2q\u0170\3\2\2\2s\u0172\3\2\2\2u\u0178"+
		"\3\2\2\2wx\7<\2\2xy\7?\2\2y\4\3\2\2\2z{\7>\2\2{|\7@\2\2|\6\3\2\2\2}~\7"+
		"-\2\2~\b\3\2\2\2\177\u0080\7/\2\2\u0080\n\3\2\2\2\u0081\u0082\7,\2\2\u0082"+
		"\f\3\2\2\2\u0083\u0084\7\61\2\2\u0084\16\3\2\2\2\u0085\u0086\7\'\2\2\u0086"+
		"\20\3\2\2\2\u0087\u0088\7@\2\2\u0088\22\3\2\2\2\u0089\u008a\7>\2\2\u008a"+
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
		"\u00d3\7g\2\2\u00d3\u00d4\7v\2\2\u00d4\u00d5\7k\2\2\u00d5\u00d6\7p\2\2"+
		"\u00d6\u00d7\7v\2\2\u00d7:\3\2\2\2\u00d8\u00d9\7i\2\2\u00d9\u00da\7g\2"+
		"\2\u00da\u00db\7v\2\2\u00db\u00dc\7e\2\2\u00dc\u00dd\7j\2\2\u00dd\u00de"+
		"\7c\2\2\u00de\u00df\7t\2\2\u00df<\3\2\2\2\u00e0\u00e1\7i\2\2\u00e1\u00e2"+
		"\7g\2\2\u00e2\u00e3\7v\2\2\u00e3\u00e4\7d\2\2\u00e4\u00e5\7q\2\2\u00e5"+
		"\u00e6\7q\2\2\u00e6\u00e7\7n\2\2\u00e7>\3\2\2\2\u00e8\u00e9\7r\2\2\u00e9"+
		"\u00ea\7w\2\2\u00ea\u00eb\7v\2\2\u00eb\u00ec\7k\2\2\u00ec\u00ed\7p\2\2"+
		"\u00ed\u00ee\7v\2\2\u00ee@\3\2\2\2\u00ef\u00f0\7r\2\2\u00f0\u00f1\7w\2"+
		"\2\u00f1\u00f2\7v\2\2\u00f2\u00f3\7e\2\2\u00f3\u00f4\7j\2\2\u00f4\u00f5"+
		"\7c\2\2\u00f5\u00f6\7t\2\2\u00f6B\3\2\2\2\u00f7\u00f8\7r\2\2\u00f8\u00f9"+
		"\7w\2\2\u00f9\u00fa\7v\2\2\u00fa\u00fb\7d\2\2\u00fb\u00fc\7q\2\2\u00fc"+
		"\u00fd\7q\2\2\u00fd\u00fe\7n\2\2\u00feD\3\2\2\2\u00ff\u0100\7g\2\2\u0100"+
		"\u0101\7p\2\2\u0101\u0102\7w\2\2\u0102\u0103\7o\2\2\u0103F\3\2\2\2\u0104"+
		"\u0105\7t\2\2\u0105\u0106\7g\2\2\u0106\u0107\7v\2\2\u0107\u0108\7w\2\2"+
		"\u0108\u0109\7t\2\2\u0109\u010a\7p\2\2\u010aH\3\2\2\2\u010b\u010c\7<\2"+
		"\2\u010cJ\3\2\2\2\u010d\u010e\7=\2\2\u010eL\3\2\2\2\u010f\u0110\7*\2\2"+
		"\u0110N\3\2\2\2\u0111\u0112\7+\2\2\u0112P\3\2\2\2\u0113\u0114\7}\2\2\u0114"+
		"R\3\2\2\2\u0115\u0116\7\177\2\2\u0116T\3\2\2\2\u0117\u0118\7]\2\2\u0118"+
		"V\3\2\2\2\u0119\u011a\7_\2\2\u011aX\3\2\2\2\u011b\u011c\7.\2\2\u011cZ"+
		"\3\2\2\2\u011d\u011e\7\60\2\2\u011e\\\3\2\2\2\u011f\u0124\7$\2\2\u0120"+
		"\u0123\5u;\2\u0121\u0123\n\2\2\2\u0122\u0120\3\2\2\2\u0122\u0121\3\2\2"+
		"\2\u0123\u0126\3\2\2\2\u0124\u0125\3\2\2\2\u0124\u0122\3\2\2\2\u0125\u0127"+
		"\3\2\2\2\u0126\u0124\3\2\2\2\u0127\u0128\7$\2\2\u0128^\3\2\2\2\u0129\u012f"+
		"\7)\2\2\u012a\u012b\7^\2\2\u012b\u012e\7)\2\2\u012c\u012e\n\2\2\2\u012d"+
		"\u012a\3\2\2\2\u012d\u012c\3\2\2\2\u012e\u0131\3\2\2\2\u012f\u0130\3\2"+
		"\2\2\u012f\u012d\3\2\2\2\u0130\u0132\3\2\2\2\u0131\u012f\3\2\2\2\u0132"+
		"\u0133\7)\2\2\u0133`\3\2\2\2\u0134\u0139\5s:\2\u0135\u0138\5s:\2\u0136"+
		"\u0138\5q9\2\u0137\u0135\3\2\2\2\u0137\u0136\3\2\2\2\u0138\u013b\3\2\2"+
		"\2\u0139\u0137\3\2\2\2\u0139\u013a\3\2\2\2\u013ab\3\2\2\2\u013b\u0139"+
		"\3\2\2\2\u013c\u013e\5q9\2\u013d\u013c\3\2\2\2\u013e\u013f\3\2\2\2\u013f"+
		"\u013d\3\2\2\2\u013f\u0140\3\2\2\2\u0140d\3\2\2\2\u0141\u0142\7v\2\2\u0142"+
		"\u0143\7t\2\2\u0143\u0144\7w\2\2\u0144\u0145\7g\2\2\u0145f\3\2\2\2\u0146"+
		"\u0147\7h\2\2\u0147\u0148\7c\2\2\u0148\u0149\7n\2\2\u0149\u014a\7u\2\2"+
		"\u014a\u014b\7g\2\2\u014bh\3\2\2\2\u014c\u014f\5e\63\2\u014d\u014f\5g"+
		"\64\2\u014e\u014c\3\2\2\2\u014e\u014d\3\2\2\2\u014fj\3\2\2\2\u0150\u0151"+
		"\7\61\2\2\u0151\u0152\7\61\2\2\u0152\u0156\3\2\2\2\u0153\u0155\n\2\2\2"+
		"\u0154\u0153\3\2\2\2\u0155\u0158\3\2\2\2\u0156\u0154\3\2\2\2\u0156\u0157"+
		"\3\2\2\2\u0157\u0159\3\2\2\2\u0158\u0156\3\2\2\2\u0159\u015a\b\66\2\2"+
		"\u015al\3\2\2\2\u015b\u015c\7\61\2\2\u015c\u015d\7,\2\2\u015d\u0161\3"+
		"\2\2\2\u015e\u0160\13\2\2\2\u015f\u015e\3\2\2\2\u0160\u0163\3\2\2\2\u0161"+
		"\u0162\3\2\2\2\u0161\u015f\3\2\2\2\u0162\u0164\3\2\2\2\u0163\u0161\3\2"+
		"\2\2\u0164\u0165\7,\2\2\u0165\u0166\7\61\2\2\u0166\u0167\3\2\2\2\u0167"+
		"\u0168\b\67\3\2\u0168n\3\2\2\2\u0169\u016b\t\3\2\2\u016a\u0169\3\2\2\2"+
		"\u016b\u016c\3\2\2\2\u016c\u016a\3\2\2\2\u016c\u016d\3\2\2\2\u016d\u016e"+
		"\3\2\2\2\u016e\u016f\b8\4\2\u016fp\3\2\2\2\u0170\u0171\4\62;\2\u0171r"+
		"\3\2\2\2\u0172\u0173\t\4\2\2\u0173t\3\2\2\2\u0174\u0175\7^\2\2\u0175\u0179"+
		"\7$\2\2\u0176\u0177\7^\2\2\u0177\u0179\7^\2\2\u0178\u0174\3\2\2\2\u0178"+
		"\u0176\3\2\2\2\u0179v\3\2\2\2\20\2\u00a8\u0122\u0124\u012d\u012f\u0137"+
		"\u0139\u013f\u014e\u0156\u0161\u016c\u0178";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}