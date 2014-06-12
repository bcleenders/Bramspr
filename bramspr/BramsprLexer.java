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
		TYPE=26, PRINT=27, GETINT=28, GETCHAR=29, GETBOOL=30, ENUM=31, RETURN=32, 
		COLON=33, SEMICOLON=34, LEFT_PARENTHESIS=35, RIGHT_PARENTHESIS=36, LEFT_BRACE=37, 
		RIGHT_BRACE=38, LEFT_BLOCKBRACE=39, RIGHT_BLOCKBRACE=40, COMMA=41, DOT=42, 
		STRING=43, CHARACTER=44, IDENTIFIER=45, NUMBER=46, TRUE=47, FALSE=48, 
		BOOL=49, COMMENT=50, BLOCKCOMMENT=51, WHITESPACE=52;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"':='", "'<>'", "'+'", "'-'", "'*'", "'/'", "'%'", "SMALLER_THAN", "'<='", 
		"GREATER_THAN", "'>='", "'='", "'=/='", "'+-'", "'^'", "'!'", "'&'", "'|'", 
		"'!&'", "LOGIC", "'if'", "'then'", "'else'", "'while'", "'function'", 
		"'type'", "'print'", "'getint'", "'getchar'", "'getbool'", "'enum'", "'return'", 
		"':'", "';'", "'('", "')'", "'{'", "'}'", "'['", "']'", "','", "'.'", 
		"STRING", "CHARACTER", "IDENTIFIER", "NUMBER", "'true'", "'false'", "BOOL", 
		"COMMENT", "BLOCKCOMMENT", "WHITESPACE"
	};
	public static final String[] ruleNames = {
		"BECOMES", "SWAP", "PLUS", "MINUS", "MULTIPLICATION", "DIVISION", "MODULUS", 
		"SMALLER_THAN", "SMALLER_THAN_EQUALS_TO", "GREATER_THAN", "GREATER_THAN_EQUALS_TO", 
		"EQUALS_TO", "NOT_EQUALS_TO", "PLUSMINUS", "POWER", "NOT", "AND", "OR", 
		"XOR", "LOGIC", "IF", "THEN", "ELSE", "WHILE", "FUNCTION", "TYPE", "PRINT", 
		"GETINT", "GETCHAR", "GETBOOL", "ENUM", "RETURN", "COLON", "SEMICOLON", 
		"LEFT_PARENTHESIS", "RIGHT_PARENTHESIS", "LEFT_BRACE", "RIGHT_BRACE", 
		"LEFT_BLOCKBRACE", "RIGHT_BLOCKBRACE", "COMMA", "DOT", "STRING", "CHARACTER", 
		"IDENTIFIER", "NUMBER", "TRUE", "FALSE", "BOOL", "COMMENT", "BLOCKCOMMENT", 
		"WHITESPACE", "DIGIT", "LETTER", "ESCAPED"
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
		case 49: COMMENT_action((RuleContext)_localctx, actionIndex); break;

		case 50: BLOCKCOMMENT_action((RuleContext)_localctx, actionIndex); break;

		case 51: WHITESPACE_action((RuleContext)_localctx, actionIndex); break;
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
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\2\66\u015d\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\3\2\3\2\3\2\3\3\3\3\3\3\3\4"+
		"\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\f"+
		"\3\f\3\f\3\r\3\r\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\21\3\21"+
		"\3\22\3\22\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3\25\5\25\u00a3\n\25\3\26"+
		"\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\33"+
		"\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35"+
		"\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37"+
		"\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3 \3!\3!\3!\3!\3!\3!\3!\3\"\3\""+
		"\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3+\3,\3,\3,\7,\u0106"+
		"\n,\f,\16,\u0109\13,\3,\3,\3-\3-\3-\3-\7-\u0111\n-\f-\16-\u0114\13-\3"+
		"-\3-\3.\3.\3.\7.\u011b\n.\f.\16.\u011e\13.\3/\6/\u0121\n/\r/\16/\u0122"+
		"\3\60\3\60\3\60\3\60\3\60\3\61\3\61\3\61\3\61\3\61\3\61\3\62\3\62\5\62"+
		"\u0132\n\62\3\63\3\63\3\63\3\63\7\63\u0138\n\63\f\63\16\63\u013b\13\63"+
		"\3\63\3\63\3\64\3\64\3\64\3\64\7\64\u0143\n\64\f\64\16\64\u0146\13\64"+
		"\3\64\3\64\3\64\3\64\3\64\3\65\6\65\u014e\n\65\r\65\16\65\u014f\3\65\3"+
		"\65\3\66\3\66\3\67\3\67\38\38\38\38\58\u015c\n8\5\u0107\u0112\u01449\3"+
		"\3\1\5\4\1\7\5\1\t\6\1\13\7\1\r\b\1\17\t\1\21\n\1\23\13\1\25\f\1\27\r"+
		"\1\31\16\1\33\17\1\35\20\1\37\21\1!\22\1#\23\1%\24\1\'\25\1)\26\1+\27"+
		"\1-\30\1/\31\1\61\32\1\63\33\1\65\34\1\67\35\19\36\1;\37\1= \1?!\1A\""+
		"\1C#\1E$\1G%\1I&\1K\'\1M(\1O)\1Q*\1S+\1U,\1W-\1Y.\1[/\1]\60\1_\61\1a\62"+
		"\1c\63\1e\64\2g\65\3i\66\4k\2\1m\2\1o\2\1\3\2\5\4\2\f\f\17\17\5\2\13\f"+
		"\16\17\"\"\4\2C\\c|\u0167\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2"+
		"\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2"+
		"\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3"+
		"\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2"+
		"\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67"+
		"\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2"+
		"\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2"+
		"\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]"+
		"\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2"+
		"\2\2\3q\3\2\2\2\5t\3\2\2\2\7w\3\2\2\2\ty\3\2\2\2\13{\3\2\2\2\r}\3\2\2"+
		"\2\17\177\3\2\2\2\21\u0081\3\2\2\2\23\u0083\3\2\2\2\25\u0086\3\2\2\2\27"+
		"\u0088\3\2\2\2\31\u008b\3\2\2\2\33\u008d\3\2\2\2\35\u0091\3\2\2\2\37\u0094"+
		"\3\2\2\2!\u0096\3\2\2\2#\u0098\3\2\2\2%\u009a\3\2\2\2\'\u009c\3\2\2\2"+
		")\u00a2\3\2\2\2+\u00a4\3\2\2\2-\u00a7\3\2\2\2/\u00ac\3\2\2\2\61\u00b1"+
		"\3\2\2\2\63\u00b7\3\2\2\2\65\u00c0\3\2\2\2\67\u00c5\3\2\2\29\u00cb\3\2"+
		"\2\2;\u00d2\3\2\2\2=\u00da\3\2\2\2?\u00e2\3\2\2\2A\u00e7\3\2\2\2C\u00ee"+
		"\3\2\2\2E\u00f0\3\2\2\2G\u00f2\3\2\2\2I\u00f4\3\2\2\2K\u00f6\3\2\2\2M"+
		"\u00f8\3\2\2\2O\u00fa\3\2\2\2Q\u00fc\3\2\2\2S\u00fe\3\2\2\2U\u0100\3\2"+
		"\2\2W\u0102\3\2\2\2Y\u010c\3\2\2\2[\u0117\3\2\2\2]\u0120\3\2\2\2_\u0124"+
		"\3\2\2\2a\u0129\3\2\2\2c\u0131\3\2\2\2e\u0133\3\2\2\2g\u013e\3\2\2\2i"+
		"\u014d\3\2\2\2k\u0153\3\2\2\2m\u0155\3\2\2\2o\u015b\3\2\2\2qr\7<\2\2r"+
		"s\7?\2\2s\4\3\2\2\2tu\7>\2\2uv\7@\2\2v\6\3\2\2\2wx\7-\2\2x\b\3\2\2\2y"+
		"z\7/\2\2z\n\3\2\2\2{|\7,\2\2|\f\3\2\2\2}~\7\61\2\2~\16\3\2\2\2\177\u0080"+
		"\7\'\2\2\u0080\20\3\2\2\2\u0081\u0082\7@\2\2\u0082\22\3\2\2\2\u0083\u0084"+
		"\7>\2\2\u0084\u0085\7?\2\2\u0085\24\3\2\2\2\u0086\u0087\7@\2\2\u0087\26"+
		"\3\2\2\2\u0088\u0089\7@\2\2\u0089\u008a\7?\2\2\u008a\30\3\2\2\2\u008b"+
		"\u008c\7?\2\2\u008c\32\3\2\2\2\u008d\u008e\7?\2\2\u008e\u008f\7\61\2\2"+
		"\u008f\u0090\7?\2\2\u0090\34\3\2\2\2\u0091\u0092\7-\2\2\u0092\u0093\7"+
		"/\2\2\u0093\36\3\2\2\2\u0094\u0095\7`\2\2\u0095 \3\2\2\2\u0096\u0097\7"+
		"#\2\2\u0097\"\3\2\2\2\u0098\u0099\7(\2\2\u0099$\3\2\2\2\u009a\u009b\7"+
		"~\2\2\u009b&\3\2\2\2\u009c\u009d\7#\2\2\u009d\u009e\7(\2\2\u009e(\3\2"+
		"\2\2\u009f\u00a3\5#\22\2\u00a0\u00a3\5%\23\2\u00a1\u00a3\5\'\24\2\u00a2"+
		"\u009f\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a2\u00a1\3\2\2\2\u00a3*\3\2\2\2"+
		"\u00a4\u00a5\7k\2\2\u00a5\u00a6\7h\2\2\u00a6,\3\2\2\2\u00a7\u00a8\7v\2"+
		"\2\u00a8\u00a9\7j\2\2\u00a9\u00aa\7g\2\2\u00aa\u00ab\7p\2\2\u00ab.\3\2"+
		"\2\2\u00ac\u00ad\7g\2\2\u00ad\u00ae\7n\2\2\u00ae\u00af\7u\2\2\u00af\u00b0"+
		"\7g\2\2\u00b0\60\3\2\2\2\u00b1\u00b2\7y\2\2\u00b2\u00b3\7j\2\2\u00b3\u00b4"+
		"\7k\2\2\u00b4\u00b5\7n\2\2\u00b5\u00b6\7g\2\2\u00b6\62\3\2\2\2\u00b7\u00b8"+
		"\7h\2\2\u00b8\u00b9\7w\2\2\u00b9\u00ba\7p\2\2\u00ba\u00bb\7e\2\2\u00bb"+
		"\u00bc\7v\2\2\u00bc\u00bd\7k\2\2\u00bd\u00be\7q\2\2\u00be\u00bf\7p\2\2"+
		"\u00bf\64\3\2\2\2\u00c0\u00c1\7v\2\2\u00c1\u00c2\7{\2\2\u00c2\u00c3\7"+
		"r\2\2\u00c3\u00c4\7g\2\2\u00c4\66\3\2\2\2\u00c5\u00c6\7r\2\2\u00c6\u00c7"+
		"\7t\2\2\u00c7\u00c8\7k\2\2\u00c8\u00c9\7p\2\2\u00c9\u00ca\7v\2\2\u00ca"+
		"8\3\2\2\2\u00cb\u00cc\7i\2\2\u00cc\u00cd\7g\2\2\u00cd\u00ce\7v\2\2\u00ce"+
		"\u00cf\7k\2\2\u00cf\u00d0\7p\2\2\u00d0\u00d1\7v\2\2\u00d1:\3\2\2\2\u00d2"+
		"\u00d3\7i\2\2\u00d3\u00d4\7g\2\2\u00d4\u00d5\7v\2\2\u00d5\u00d6\7e\2\2"+
		"\u00d6\u00d7\7j\2\2\u00d7\u00d8\7c\2\2\u00d8\u00d9\7t\2\2\u00d9<\3\2\2"+
		"\2\u00da\u00db\7i\2\2\u00db\u00dc\7g\2\2\u00dc\u00dd\7v\2\2\u00dd\u00de"+
		"\7d\2\2\u00de\u00df\7q\2\2\u00df\u00e0\7q\2\2\u00e0\u00e1\7n\2\2\u00e1"+
		">\3\2\2\2\u00e2\u00e3\7g\2\2\u00e3\u00e4\7p\2\2\u00e4\u00e5\7w\2\2\u00e5"+
		"\u00e6\7o\2\2\u00e6@\3\2\2\2\u00e7\u00e8\7t\2\2\u00e8\u00e9\7g\2\2\u00e9"+
		"\u00ea\7v\2\2\u00ea\u00eb\7w\2\2\u00eb\u00ec\7t\2\2\u00ec\u00ed\7p\2\2"+
		"\u00edB\3\2\2\2\u00ee\u00ef\7<\2\2\u00efD\3\2\2\2\u00f0\u00f1\7=\2\2\u00f1"+
		"F\3\2\2\2\u00f2\u00f3\7*\2\2\u00f3H\3\2\2\2\u00f4\u00f5\7+\2\2\u00f5J"+
		"\3\2\2\2\u00f6\u00f7\7}\2\2\u00f7L\3\2\2\2\u00f8\u00f9\7\177\2\2\u00f9"+
		"N\3\2\2\2\u00fa\u00fb\7]\2\2\u00fbP\3\2\2\2\u00fc\u00fd\7_\2\2\u00fdR"+
		"\3\2\2\2\u00fe\u00ff\7.\2\2\u00ffT\3\2\2\2\u0100\u0101\7\60\2\2\u0101"+
		"V\3\2\2\2\u0102\u0107\7$\2\2\u0103\u0106\5o8\2\u0104\u0106\n\2\2\2\u0105"+
		"\u0103\3\2\2\2\u0105\u0104\3\2\2\2\u0106\u0109\3\2\2\2\u0107\u0108\3\2"+
		"\2\2\u0107\u0105\3\2\2\2\u0108\u010a\3\2\2\2\u0109\u0107\3\2\2\2\u010a"+
		"\u010b\7$\2\2\u010bX\3\2\2\2\u010c\u0112\7)\2\2\u010d\u010e\7^\2\2\u010e"+
		"\u0111\7)\2\2\u010f\u0111\n\2\2\2\u0110\u010d\3\2\2\2\u0110\u010f\3\2"+
		"\2\2\u0111\u0114\3\2\2\2\u0112\u0113\3\2\2\2\u0112\u0110\3\2\2\2\u0113"+
		"\u0115\3\2\2\2\u0114\u0112\3\2\2\2\u0115\u0116\7)\2\2\u0116Z\3\2\2\2\u0117"+
		"\u011c\5m\67\2\u0118\u011b\5m\67\2\u0119\u011b\5k\66\2\u011a\u0118\3\2"+
		"\2\2\u011a\u0119\3\2\2\2\u011b\u011e\3\2\2\2\u011c\u011a\3\2\2\2\u011c"+
		"\u011d\3\2\2\2\u011d\\\3\2\2\2\u011e\u011c\3\2\2\2\u011f\u0121\5k\66\2"+
		"\u0120\u011f\3\2\2\2\u0121\u0122\3\2\2\2\u0122\u0120\3\2\2\2\u0122\u0123"+
		"\3\2\2\2\u0123^\3\2\2\2\u0124\u0125\7v\2\2\u0125\u0126\7t\2\2\u0126\u0127"+
		"\7w\2\2\u0127\u0128\7g\2\2\u0128`\3\2\2\2\u0129\u012a\7h\2\2\u012a\u012b"+
		"\7c\2\2\u012b\u012c\7n\2\2\u012c\u012d\7u\2\2\u012d\u012e\7g\2\2\u012e"+
		"b\3\2\2\2\u012f\u0132\5_\60\2\u0130\u0132\5a\61\2\u0131\u012f\3\2\2\2"+
		"\u0131\u0130\3\2\2\2\u0132d\3\2\2\2\u0133\u0134\7\61\2\2\u0134\u0135\7"+
		"\61\2\2\u0135\u0139\3\2\2\2\u0136\u0138\n\2\2\2\u0137\u0136\3\2\2\2\u0138"+
		"\u013b\3\2\2\2\u0139\u0137\3\2\2\2\u0139\u013a\3\2\2\2\u013a\u013c\3\2"+
		"\2\2\u013b\u0139\3\2\2\2\u013c\u013d\b\63\2\2\u013df\3\2\2\2\u013e\u013f"+
		"\7\61\2\2\u013f\u0140\7,\2\2\u0140\u0144\3\2\2\2\u0141\u0143\13\2\2\2"+
		"\u0142\u0141\3\2\2\2\u0143\u0146\3\2\2\2\u0144\u0145\3\2\2\2\u0144\u0142"+
		"\3\2\2\2\u0145\u0147\3\2\2\2\u0146\u0144\3\2\2\2\u0147\u0148\7,\2\2\u0148"+
		"\u0149\7\61\2\2\u0149\u014a\3\2\2\2\u014a\u014b\b\64\3\2\u014bh\3\2\2"+
		"\2\u014c\u014e\t\3\2\2\u014d\u014c\3\2\2\2\u014e\u014f\3\2\2\2\u014f\u014d"+
		"\3\2\2\2\u014f\u0150\3\2\2\2\u0150\u0151\3\2\2\2\u0151\u0152\b\65\4\2"+
		"\u0152j\3\2\2\2\u0153\u0154\4\62;\2\u0154l\3\2\2\2\u0155\u0156\t\4\2\2"+
		"\u0156n\3\2\2\2\u0157\u0158\7^\2\2\u0158\u015c\7$\2\2\u0159\u015a\7^\2"+
		"\2\u015a\u015c\7^\2\2\u015b\u0157\3\2\2\2\u015b\u0159\3\2\2\2\u015cp\3"+
		"\2\2\2\20\2\u00a2\u0105\u0107\u0110\u0112\u011a\u011c\u0122\u0131\u0139"+
		"\u0144\u014f\u015b";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}