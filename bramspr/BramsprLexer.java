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
		PUTBOOL=33, PUTSTRING=34, ENUM=35, RETURN=36, FINAL=37, TRUE=38, FALSE=39, 
		COLON=40, SEMICOLON=41, LEFT_PARENTHESIS=42, RIGHT_PARENTHESIS=43, LEFT_BRACE=44, 
		RIGHT_BRACE=45, LEFT_BLOCKBRACE=46, RIGHT_BLOCKBRACE=47, COMMA=48, DOT=49, 
		STRING=50, CHARACTER=51, IDENTIFIER=52, NUMBER=53, BOOL=54, COMMENT=55, 
		BLOCKCOMMENT=56, WHITESPACE=57;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"':='", "'<>'", "'+'", "'-'", "'*'", "'/'", "'%'", "'<'", "'<='", "'>'", 
		"'>='", "'='", "'=/='", "'+-'", "'^'", "'!'", "'&'", "'|'", "'!&'", "LOGIC", 
		"'if'", "'then'", "'else'", "'while'", "'function'", "'type'", "'print'", 
		"'getInt'", "'getChar'", "'getBool'", "'putInt'", "'putChar'", "'putBool'", 
		"'putString'", "'enum'", "'return'", "'final'", "'true'", "'false'", "':'", 
		"';'", "'('", "')'", "'{'", "'}'", "'['", "']'", "','", "'.'", "STRING", 
		"CHARACTER", "IDENTIFIER", "NUMBER", "BOOL", "COMMENT", "BLOCKCOMMENT", 
		"WHITESPACE"
	};
	public static final String[] ruleNames = {
		"BECOMES", "SWAP", "PLUS", "MINUS", "MULTIPLICATION", "DIVISION", "MODULUS", 
		"SMALLER_THAN", "SMALLER_THAN_EQUALS_TO", "GREATER_THAN", "GREATER_THAN_EQUALS_TO", 
		"EQUALS_TO", "NOT_EQUALS_TO", "PLUSMINUS", "POWER", "NOT", "AND", "OR", 
		"XOR", "LOGIC", "IF", "THEN", "ELSE", "WHILE", "FUNCTION", "TYPE", "PRINT", 
		"GETINT", "GETCHAR", "GETBOOL", "PUTINT", "PUTCHAR", "PUTBOOL", "PUTSTRING", 
		"ENUM", "RETURN", "FINAL", "TRUE", "FALSE", "COLON", "SEMICOLON", "LEFT_PARENTHESIS", 
		"RIGHT_PARENTHESIS", "LEFT_BRACE", "RIGHT_BRACE", "LEFT_BLOCKBRACE", "RIGHT_BLOCKBRACE", 
		"COMMA", "DOT", "STRING", "CHARACTER", "IDENTIFIER", "NUMBER", "BOOL", 
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
		case 54: COMMENT_action((RuleContext)_localctx, actionIndex); break;

		case 55: BLOCKCOMMENT_action((RuleContext)_localctx, actionIndex); break;

		case 56: WHITESPACE_action((RuleContext)_localctx, actionIndex); break;
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
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\2;\u018e\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\3\2\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3"+
		"\t\3\n\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\16\3\16\3\16\3\16\3\17"+
		"\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\24\3\25"+
		"\3\25\3\25\5\25\u00ad\n\25\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\30"+
		"\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32"+
		"\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34"+
		"\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36"+
		"\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3"+
		" \3 \3 \3!\3!\3!\3!\3!\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3#\3#"+
		"\3#\3#\3#\3#\3#\3#\3#\3#\3$\3$\3$\3$\3$\3%\3%\3%\3%\3%\3%\3%\3&\3&\3&"+
		"\3&\3&\3&\3\'\3\'\3\'\3\'\3\'\3(\3(\3(\3(\3(\3(\3)\3)\3*\3*\3+\3+\3,\3"+
		",\3-\3-\3.\3.\3/\3/\3\60\3\60\3\61\3\61\3\62\3\62\3\63\3\63\3\63\7\63"+
		"\u0142\n\63\f\63\16\63\u0145\13\63\3\63\3\63\3\64\3\64\3\64\3\64\7\64"+
		"\u014d\n\64\f\64\16\64\u0150\13\64\3\64\3\64\3\65\3\65\3\65\7\65\u0157"+
		"\n\65\f\65\16\65\u015a\13\65\3\66\6\66\u015d\n\66\r\66\16\66\u015e\3\67"+
		"\3\67\5\67\u0163\n\67\38\38\38\38\78\u0169\n8\f8\168\u016c\138\38\38\3"+
		"9\39\39\39\79\u0174\n9\f9\169\u0177\139\39\39\39\39\39\3:\6:\u017f\n:"+
		"\r:\16:\u0180\3:\3:\3;\3;\3<\3<\3=\3=\3=\3=\5=\u018d\n=\5\u0143\u014e"+
		"\u0175>\3\3\1\5\4\1\7\5\1\t\6\1\13\7\1\r\b\1\17\t\1\21\n\1\23\13\1\25"+
		"\f\1\27\r\1\31\16\1\33\17\1\35\20\1\37\21\1!\22\1#\23\1%\24\1\'\25\1)"+
		"\26\1+\27\1-\30\1/\31\1\61\32\1\63\33\1\65\34\1\67\35\19\36\1;\37\1= "+
		"\1?!\1A\"\1C#\1E$\1G%\1I&\1K\'\1M(\1O)\1Q*\1S+\1U,\1W-\1Y.\1[/\1]\60\1"+
		"_\61\1a\62\1c\63\1e\64\1g\65\1i\66\1k\67\1m8\1o9\2q:\3s;\4u\2\1w\2\1y"+
		"\2\1\3\2\5\4\2\f\f\17\17\5\2\13\f\16\17\"\"\4\2C\\c|\u0198\2\3\3\2\2\2"+
		"\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2"+
		"\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2"+
		"\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2"+
		"\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2"+
		"\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2"+
		"\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2"+
		"\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W"+
		"\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2"+
		"\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2"+
		"\2q\3\2\2\2\2s\3\2\2\2\3{\3\2\2\2\5~\3\2\2\2\7\u0081\3\2\2\2\t\u0083\3"+
		"\2\2\2\13\u0085\3\2\2\2\r\u0087\3\2\2\2\17\u0089\3\2\2\2\21\u008b\3\2"+
		"\2\2\23\u008d\3\2\2\2\25\u0090\3\2\2\2\27\u0092\3\2\2\2\31\u0095\3\2\2"+
		"\2\33\u0097\3\2\2\2\35\u009b\3\2\2\2\37\u009e\3\2\2\2!\u00a0\3\2\2\2#"+
		"\u00a2\3\2\2\2%\u00a4\3\2\2\2\'\u00a6\3\2\2\2)\u00ac\3\2\2\2+\u00ae\3"+
		"\2\2\2-\u00b1\3\2\2\2/\u00b6\3\2\2\2\61\u00bb\3\2\2\2\63\u00c1\3\2\2\2"+
		"\65\u00ca\3\2\2\2\67\u00cf\3\2\2\29\u00d5\3\2\2\2;\u00dc\3\2\2\2=\u00e4"+
		"\3\2\2\2?\u00ec\3\2\2\2A\u00f3\3\2\2\2C\u00fb\3\2\2\2E\u0103\3\2\2\2G"+
		"\u010d\3\2\2\2I\u0112\3\2\2\2K\u0119\3\2\2\2M\u011f\3\2\2\2O\u0124\3\2"+
		"\2\2Q\u012a\3\2\2\2S\u012c\3\2\2\2U\u012e\3\2\2\2W\u0130\3\2\2\2Y\u0132"+
		"\3\2\2\2[\u0134\3\2\2\2]\u0136\3\2\2\2_\u0138\3\2\2\2a\u013a\3\2\2\2c"+
		"\u013c\3\2\2\2e\u013e\3\2\2\2g\u0148\3\2\2\2i\u0153\3\2\2\2k\u015c\3\2"+
		"\2\2m\u0162\3\2\2\2o\u0164\3\2\2\2q\u016f\3\2\2\2s\u017e\3\2\2\2u\u0184"+
		"\3\2\2\2w\u0186\3\2\2\2y\u018c\3\2\2\2{|\7<\2\2|}\7?\2\2}\4\3\2\2\2~\177"+
		"\7>\2\2\177\u0080\7@\2\2\u0080\6\3\2\2\2\u0081\u0082\7-\2\2\u0082\b\3"+
		"\2\2\2\u0083\u0084\7/\2\2\u0084\n\3\2\2\2\u0085\u0086\7,\2\2\u0086\f\3"+
		"\2\2\2\u0087\u0088\7\61\2\2\u0088\16\3\2\2\2\u0089\u008a\7\'\2\2\u008a"+
		"\20\3\2\2\2\u008b\u008c\7>\2\2\u008c\22\3\2\2\2\u008d\u008e\7>\2\2\u008e"+
		"\u008f\7?\2\2\u008f\24\3\2\2\2\u0090\u0091\7@\2\2\u0091\26\3\2\2\2\u0092"+
		"\u0093\7@\2\2\u0093\u0094\7?\2\2\u0094\30\3\2\2\2\u0095\u0096\7?\2\2\u0096"+
		"\32\3\2\2\2\u0097\u0098\7?\2\2\u0098\u0099\7\61\2\2\u0099\u009a\7?\2\2"+
		"\u009a\34\3\2\2\2\u009b\u009c\7-\2\2\u009c\u009d\7/\2\2\u009d\36\3\2\2"+
		"\2\u009e\u009f\7`\2\2\u009f \3\2\2\2\u00a0\u00a1\7#\2\2\u00a1\"\3\2\2"+
		"\2\u00a2\u00a3\7(\2\2\u00a3$\3\2\2\2\u00a4\u00a5\7~\2\2\u00a5&\3\2\2\2"+
		"\u00a6\u00a7\7#\2\2\u00a7\u00a8\7(\2\2\u00a8(\3\2\2\2\u00a9\u00ad\5#\22"+
		"\2\u00aa\u00ad\5%\23\2\u00ab\u00ad\5\'\24\2\u00ac\u00a9\3\2\2\2\u00ac"+
		"\u00aa\3\2\2\2\u00ac\u00ab\3\2\2\2\u00ad*\3\2\2\2\u00ae\u00af\7k\2\2\u00af"+
		"\u00b0\7h\2\2\u00b0,\3\2\2\2\u00b1\u00b2\7v\2\2\u00b2\u00b3\7j\2\2\u00b3"+
		"\u00b4\7g\2\2\u00b4\u00b5\7p\2\2\u00b5.\3\2\2\2\u00b6\u00b7\7g\2\2\u00b7"+
		"\u00b8\7n\2\2\u00b8\u00b9\7u\2\2\u00b9\u00ba\7g\2\2\u00ba\60\3\2\2\2\u00bb"+
		"\u00bc\7y\2\2\u00bc\u00bd\7j\2\2\u00bd\u00be\7k\2\2\u00be\u00bf\7n\2\2"+
		"\u00bf\u00c0\7g\2\2\u00c0\62\3\2\2\2\u00c1\u00c2\7h\2\2\u00c2\u00c3\7"+
		"w\2\2\u00c3\u00c4\7p\2\2\u00c4\u00c5\7e\2\2\u00c5\u00c6\7v\2\2\u00c6\u00c7"+
		"\7k\2\2\u00c7\u00c8\7q\2\2\u00c8\u00c9\7p\2\2\u00c9\64\3\2\2\2\u00ca\u00cb"+
		"\7v\2\2\u00cb\u00cc\7{\2\2\u00cc\u00cd\7r\2\2\u00cd\u00ce\7g\2\2\u00ce"+
		"\66\3\2\2\2\u00cf\u00d0\7r\2\2\u00d0\u00d1\7t\2\2\u00d1\u00d2\7k\2\2\u00d2"+
		"\u00d3\7p\2\2\u00d3\u00d4\7v\2\2\u00d48\3\2\2\2\u00d5\u00d6\7i\2\2\u00d6"+
		"\u00d7\7g\2\2\u00d7\u00d8\7v\2\2\u00d8\u00d9\7K\2\2\u00d9\u00da\7p\2\2"+
		"\u00da\u00db\7v\2\2\u00db:\3\2\2\2\u00dc\u00dd\7i\2\2\u00dd\u00de\7g\2"+
		"\2\u00de\u00df\7v\2\2\u00df\u00e0\7E\2\2\u00e0\u00e1\7j\2\2\u00e1\u00e2"+
		"\7c\2\2\u00e2\u00e3\7t\2\2\u00e3<\3\2\2\2\u00e4\u00e5\7i\2\2\u00e5\u00e6"+
		"\7g\2\2\u00e6\u00e7\7v\2\2\u00e7\u00e8\7D\2\2\u00e8\u00e9\7q\2\2\u00e9"+
		"\u00ea\7q\2\2\u00ea\u00eb\7n\2\2\u00eb>\3\2\2\2\u00ec\u00ed\7r\2\2\u00ed"+
		"\u00ee\7w\2\2\u00ee\u00ef\7v\2\2\u00ef\u00f0\7K\2\2\u00f0\u00f1\7p\2\2"+
		"\u00f1\u00f2\7v\2\2\u00f2@\3\2\2\2\u00f3\u00f4\7r\2\2\u00f4\u00f5\7w\2"+
		"\2\u00f5\u00f6\7v\2\2\u00f6\u00f7\7E\2\2\u00f7\u00f8\7j\2\2\u00f8\u00f9"+
		"\7c\2\2\u00f9\u00fa\7t\2\2\u00faB\3\2\2\2\u00fb\u00fc\7r\2\2\u00fc\u00fd"+
		"\7w\2\2\u00fd\u00fe\7v\2\2\u00fe\u00ff\7D\2\2\u00ff\u0100\7q\2\2\u0100"+
		"\u0101\7q\2\2\u0101\u0102\7n\2\2\u0102D\3\2\2\2\u0103\u0104\7r\2\2\u0104"+
		"\u0105\7w\2\2\u0105\u0106\7v\2\2\u0106\u0107\7U\2\2\u0107\u0108\7v\2\2"+
		"\u0108\u0109\7t\2\2\u0109\u010a\7k\2\2\u010a\u010b\7p\2\2\u010b\u010c"+
		"\7i\2\2\u010cF\3\2\2\2\u010d\u010e\7g\2\2\u010e\u010f\7p\2\2\u010f\u0110"+
		"\7w\2\2\u0110\u0111\7o\2\2\u0111H\3\2\2\2\u0112\u0113\7t\2\2\u0113\u0114"+
		"\7g\2\2\u0114\u0115\7v\2\2\u0115\u0116\7w\2\2\u0116\u0117\7t\2\2\u0117"+
		"\u0118\7p\2\2\u0118J\3\2\2\2\u0119\u011a\7h\2\2\u011a\u011b\7k\2\2\u011b"+
		"\u011c\7p\2\2\u011c\u011d\7c\2\2\u011d\u011e\7n\2\2\u011eL\3\2\2\2\u011f"+
		"\u0120\7v\2\2\u0120\u0121\7t\2\2\u0121\u0122\7w\2\2\u0122\u0123\7g\2\2"+
		"\u0123N\3\2\2\2\u0124\u0125\7h\2\2\u0125\u0126\7c\2\2\u0126\u0127\7n\2"+
		"\2\u0127\u0128\7u\2\2\u0128\u0129\7g\2\2\u0129P\3\2\2\2\u012a\u012b\7"+
		"<\2\2\u012bR\3\2\2\2\u012c\u012d\7=\2\2\u012dT\3\2\2\2\u012e\u012f\7*"+
		"\2\2\u012fV\3\2\2\2\u0130\u0131\7+\2\2\u0131X\3\2\2\2\u0132\u0133\7}\2"+
		"\2\u0133Z\3\2\2\2\u0134\u0135\7\177\2\2\u0135\\\3\2\2\2\u0136\u0137\7"+
		"]\2\2\u0137^\3\2\2\2\u0138\u0139\7_\2\2\u0139`\3\2\2\2\u013a\u013b\7."+
		"\2\2\u013bb\3\2\2\2\u013c\u013d\7\60\2\2\u013dd\3\2\2\2\u013e\u0143\7"+
		"$\2\2\u013f\u0142\5y=\2\u0140\u0142\n\2\2\2\u0141\u013f\3\2\2\2\u0141"+
		"\u0140\3\2\2\2\u0142\u0145\3\2\2\2\u0143\u0144\3\2\2\2\u0143\u0141\3\2"+
		"\2\2\u0144\u0146\3\2\2\2\u0145\u0143\3\2\2\2\u0146\u0147\7$\2\2\u0147"+
		"f\3\2\2\2\u0148\u014e\7)\2\2\u0149\u014a\7^\2\2\u014a\u014d\7)\2\2\u014b"+
		"\u014d\n\2\2\2\u014c\u0149\3\2\2\2\u014c\u014b\3\2\2\2\u014d\u0150\3\2"+
		"\2\2\u014e\u014f\3\2\2\2\u014e\u014c\3\2\2\2\u014f\u0151\3\2\2\2\u0150"+
		"\u014e\3\2\2\2\u0151\u0152\7)\2\2\u0152h\3\2\2\2\u0153\u0158\5w<\2\u0154"+
		"\u0157\5w<\2\u0155\u0157\5u;\2\u0156\u0154\3\2\2\2\u0156\u0155\3\2\2\2"+
		"\u0157\u015a\3\2\2\2\u0158\u0156\3\2\2\2\u0158\u0159\3\2\2\2\u0159j\3"+
		"\2\2\2\u015a\u0158\3\2\2\2\u015b\u015d\5u;\2\u015c\u015b\3\2\2\2\u015d"+
		"\u015e\3\2\2\2\u015e\u015c\3\2\2\2\u015e\u015f\3\2\2\2\u015fl\3\2\2\2"+
		"\u0160\u0163\5M\'\2\u0161\u0163\5O(\2\u0162\u0160\3\2\2\2\u0162\u0161"+
		"\3\2\2\2\u0163n\3\2\2\2\u0164\u0165\7\61\2\2\u0165\u0166\7\61\2\2\u0166"+
		"\u016a\3\2\2\2\u0167\u0169\n\2\2\2\u0168\u0167\3\2\2\2\u0169\u016c\3\2"+
		"\2\2\u016a\u0168\3\2\2\2\u016a\u016b\3\2\2\2\u016b\u016d\3\2\2\2\u016c"+
		"\u016a\3\2\2\2\u016d\u016e\b8\2\2\u016ep\3\2\2\2\u016f\u0170\7\61\2\2"+
		"\u0170\u0171\7,\2\2\u0171\u0175\3\2\2\2\u0172\u0174\13\2\2\2\u0173\u0172"+
		"\3\2\2\2\u0174\u0177\3\2\2\2\u0175\u0176\3\2\2\2\u0175\u0173\3\2\2\2\u0176"+
		"\u0178\3\2\2\2\u0177\u0175\3\2\2\2\u0178\u0179\7,\2\2\u0179\u017a\7\61"+
		"\2\2\u017a\u017b\3\2\2\2\u017b\u017c\b9\3\2\u017cr\3\2\2\2\u017d\u017f"+
		"\t\3\2\2\u017e\u017d\3\2\2\2\u017f\u0180\3\2\2\2\u0180\u017e\3\2\2\2\u0180"+
		"\u0181\3\2\2\2\u0181\u0182\3\2\2\2\u0182\u0183\b:\4\2\u0183t\3\2\2\2\u0184"+
		"\u0185\4\62;\2\u0185v\3\2\2\2\u0186\u0187\t\4\2\2\u0187x\3\2\2\2\u0188"+
		"\u0189\7^\2\2\u0189\u018d\7$\2\2\u018a\u018b\7^\2\2\u018b\u018d\7^\2\2"+
		"\u018c\u0188\3\2\2\2\u018c\u018a\3\2\2\2\u018dz\3\2\2\2\20\2\u00ac\u0141"+
		"\u0143\u014c\u014e\u0156\u0158\u015e\u0162\u016a\u0175\u0180\u018c";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}