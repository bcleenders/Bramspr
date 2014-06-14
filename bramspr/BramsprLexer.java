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
		TYPE=26, PRINT=27, GETINT=28, GETCHAR=29, GETBOOL=30, PUTINT=31, PUTCHAR=32, 
		PUTBOOL=33, ENUM=34, RETURN=35, FINAL=36, COLON=37, SEMICOLON=38, LEFT_PARENTHESIS=39, 
		RIGHT_PARENTHESIS=40, LEFT_BRACE=41, RIGHT_BRACE=42, LEFT_BLOCKBRACE=43, 
		RIGHT_BLOCKBRACE=44, COMMA=45, DOT=46, STRING=47, CHARACTER=48, IDENTIFIER=49, 
		NUMBER=50, TRUE=51, FALSE=52, BOOL=53, COMMENT=54, BLOCKCOMMENT=55, WHITESPACE=56;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"':='", "'<>'", "'+'", "'-'", "'*'", "'/'", "'%'", "SMALLER_THAN", "'<='", 
		"GREATER_THAN", "'>='", "'='", "'=/='", "'+-'", "'^'", "'!'", "'&'", "'|'", 
		"'!&'", "LOGIC", "'if'", "'then'", "'else'", "'while'", "'function'", 
		"'type'", "'print'", "'getInt'", "'getChar'", "'getBool'", "'putInt'", 
		"'putChar'", "'putBool'", "'enum'", "'return'", "'final'", "':'", "';'", 
		"'('", "')'", "'{'", "'}'", "'['", "']'", "','", "'.'", "STRING", "CHARACTER", 
		"IDENTIFIER", "NUMBER", "'true'", "'false'", "BOOL", "COMMENT", "BLOCKCOMMENT", 
		"WHITESPACE"
	};
	public static final String[] ruleNames = {
		"BECOMES", "SWAP", "PLUS", "MINUS", "MULTIPLICATION", "DIVISION", "MODULUS", 
		"SMALLER_THAN", "SMALLER_THAN_EQUALS_TO", "GREATER_THAN", "GREATER_THAN_EQUALS_TO", 
		"EQUALS_TO", "NOT_EQUALS_TO", "PLUSMINUS", "POWER", "NOT", "AND", "OR", 
		"XOR", "LOGIC", "IF", "THEN", "ELSE", "WHILE", "FUNCTION", "TYPE", "PRINT", 
		"GETINT", "GETCHAR", "GETBOOL", "PUTINT", "PUTCHAR", "PUTBOOL", "ENUM", 
		"RETURN", "FINAL", "COLON", "SEMICOLON", "LEFT_PARENTHESIS", "RIGHT_PARENTHESIS", 
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
		case 53: COMMENT_action((RuleContext)_localctx, actionIndex); break;

		case 54: BLOCKCOMMENT_action((RuleContext)_localctx, actionIndex); break;

		case 55: WHITESPACE_action((RuleContext)_localctx, actionIndex); break;
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
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\2:\u0182\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\3\2\3"+
		"\2\3\2\3\3\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n"+
		"\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\16\3\16\3\16\3\16\3\17\3\17\3"+
		"\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3"+
		"\25\5\25\u00ab\n\25\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\30\3\30"+
		"\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32"+
		"\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34"+
		"\3\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36"+
		"\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3 \3 \3"+
		" \3!\3!\3!\3!\3!\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3#\3#\3#\3#"+
		"\3#\3$\3$\3$\3$\3$\3$\3$\3%\3%\3%\3%\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3"+
		"*\3*\3+\3+\3,\3,\3-\3-\3.\3.\3/\3/\3\60\3\60\3\60\7\60\u012b\n\60\f\60"+
		"\16\60\u012e\13\60\3\60\3\60\3\61\3\61\3\61\3\61\7\61\u0136\n\61\f\61"+
		"\16\61\u0139\13\61\3\61\3\61\3\62\3\62\3\62\7\62\u0140\n\62\f\62\16\62"+
		"\u0143\13\62\3\63\6\63\u0146\n\63\r\63\16\63\u0147\3\64\3\64\3\64\3\64"+
		"\3\64\3\65\3\65\3\65\3\65\3\65\3\65\3\66\3\66\5\66\u0157\n\66\3\67\3\67"+
		"\3\67\3\67\7\67\u015d\n\67\f\67\16\67\u0160\13\67\3\67\3\67\38\38\38\3"+
		"8\78\u0168\n8\f8\168\u016b\138\38\38\38\38\38\39\69\u0173\n9\r9\169\u0174"+
		"\39\39\3:\3:\3;\3;\3<\3<\3<\3<\5<\u0181\n<\5\u012c\u0137\u0169=\3\3\1"+
		"\5\4\1\7\5\1\t\6\1\13\7\1\r\b\1\17\t\1\21\n\1\23\13\1\25\f\1\27\r\1\31"+
		"\16\1\33\17\1\35\20\1\37\21\1!\22\1#\23\1%\24\1\'\25\1)\26\1+\27\1-\30"+
		"\1/\31\1\61\32\1\63\33\1\65\34\1\67\35\19\36\1;\37\1= \1?!\1A\"\1C#\1"+
		"E$\1G%\1I&\1K\'\1M(\1O)\1Q*\1S+\1U,\1W-\1Y.\1[/\1]\60\1_\61\1a\62\1c\63"+
		"\1e\64\1g\65\1i\66\1k\67\1m8\2o9\3q:\4s\2\1u\2\1w\2\1\3\2\5\4\2\f\f\17"+
		"\17\5\2\13\f\16\17\"\"\4\2C\\c|\u018c\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2"+
		"\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2"+
		"\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3"+
		"\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3"+
		"\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65"+
		"\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3"+
		"\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2"+
		"\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2"+
		"[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3"+
		"\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\3y\3\2\2"+
		"\2\5|\3\2\2\2\7\177\3\2\2\2\t\u0081\3\2\2\2\13\u0083\3\2\2\2\r\u0085\3"+
		"\2\2\2\17\u0087\3\2\2\2\21\u0089\3\2\2\2\23\u008b\3\2\2\2\25\u008e\3\2"+
		"\2\2\27\u0090\3\2\2\2\31\u0093\3\2\2\2\33\u0095\3\2\2\2\35\u0099\3\2\2"+
		"\2\37\u009c\3\2\2\2!\u009e\3\2\2\2#\u00a0\3\2\2\2%\u00a2\3\2\2\2\'\u00a4"+
		"\3\2\2\2)\u00aa\3\2\2\2+\u00ac\3\2\2\2-\u00af\3\2\2\2/\u00b4\3\2\2\2\61"+
		"\u00b9\3\2\2\2\63\u00bf\3\2\2\2\65\u00c8\3\2\2\2\67\u00cd\3\2\2\29\u00d3"+
		"\3\2\2\2;\u00da\3\2\2\2=\u00e2\3\2\2\2?\u00ea\3\2\2\2A\u00f1\3\2\2\2C"+
		"\u00f9\3\2\2\2E\u0101\3\2\2\2G\u0106\3\2\2\2I\u010d\3\2\2\2K\u0113\3\2"+
		"\2\2M\u0115\3\2\2\2O\u0117\3\2\2\2Q\u0119\3\2\2\2S\u011b\3\2\2\2U\u011d"+
		"\3\2\2\2W\u011f\3\2\2\2Y\u0121\3\2\2\2[\u0123\3\2\2\2]\u0125\3\2\2\2_"+
		"\u0127\3\2\2\2a\u0131\3\2\2\2c\u013c\3\2\2\2e\u0145\3\2\2\2g\u0149\3\2"+
		"\2\2i\u014e\3\2\2\2k\u0156\3\2\2\2m\u0158\3\2\2\2o\u0163\3\2\2\2q\u0172"+
		"\3\2\2\2s\u0178\3\2\2\2u\u017a\3\2\2\2w\u0180\3\2\2\2yz\7<\2\2z{\7?\2"+
		"\2{\4\3\2\2\2|}\7>\2\2}~\7@\2\2~\6\3\2\2\2\177\u0080\7-\2\2\u0080\b\3"+
		"\2\2\2\u0081\u0082\7/\2\2\u0082\n\3\2\2\2\u0083\u0084\7,\2\2\u0084\f\3"+
		"\2\2\2\u0085\u0086\7\61\2\2\u0086\16\3\2\2\2\u0087\u0088\7\'\2\2\u0088"+
		"\20\3\2\2\2\u0089\u008a\7@\2\2\u008a\22\3\2\2\2\u008b\u008c\7>\2\2\u008c"+
		"\u008d\7?\2\2\u008d\24\3\2\2\2\u008e\u008f\7@\2\2\u008f\26\3\2\2\2\u0090"+
		"\u0091\7@\2\2\u0091\u0092\7?\2\2\u0092\30\3\2\2\2\u0093\u0094\7?\2\2\u0094"+
		"\32\3\2\2\2\u0095\u0096\7?\2\2\u0096\u0097\7\61\2\2\u0097\u0098\7?\2\2"+
		"\u0098\34\3\2\2\2\u0099\u009a\7-\2\2\u009a\u009b\7/\2\2\u009b\36\3\2\2"+
		"\2\u009c\u009d\7`\2\2\u009d \3\2\2\2\u009e\u009f\7#\2\2\u009f\"\3\2\2"+
		"\2\u00a0\u00a1\7(\2\2\u00a1$\3\2\2\2\u00a2\u00a3\7~\2\2\u00a3&\3\2\2\2"+
		"\u00a4\u00a5\7#\2\2\u00a5\u00a6\7(\2\2\u00a6(\3\2\2\2\u00a7\u00ab\5#\22"+
		"\2\u00a8\u00ab\5%\23\2\u00a9\u00ab\5\'\24\2\u00aa\u00a7\3\2\2\2\u00aa"+
		"\u00a8\3\2\2\2\u00aa\u00a9\3\2\2\2\u00ab*\3\2\2\2\u00ac\u00ad\7k\2\2\u00ad"+
		"\u00ae\7h\2\2\u00ae,\3\2\2\2\u00af\u00b0\7v\2\2\u00b0\u00b1\7j\2\2\u00b1"+
		"\u00b2\7g\2\2\u00b2\u00b3\7p\2\2\u00b3.\3\2\2\2\u00b4\u00b5\7g\2\2\u00b5"+
		"\u00b6\7n\2\2\u00b6\u00b7\7u\2\2\u00b7\u00b8\7g\2\2\u00b8\60\3\2\2\2\u00b9"+
		"\u00ba\7y\2\2\u00ba\u00bb\7j\2\2\u00bb\u00bc\7k\2\2\u00bc\u00bd\7n\2\2"+
		"\u00bd\u00be\7g\2\2\u00be\62\3\2\2\2\u00bf\u00c0\7h\2\2\u00c0\u00c1\7"+
		"w\2\2\u00c1\u00c2\7p\2\2\u00c2\u00c3\7e\2\2\u00c3\u00c4\7v\2\2\u00c4\u00c5"+
		"\7k\2\2\u00c5\u00c6\7q\2\2\u00c6\u00c7\7p\2\2\u00c7\64\3\2\2\2\u00c8\u00c9"+
		"\7v\2\2\u00c9\u00ca\7{\2\2\u00ca\u00cb\7r\2\2\u00cb\u00cc\7g\2\2\u00cc"+
		"\66\3\2\2\2\u00cd\u00ce\7r\2\2\u00ce\u00cf\7t\2\2\u00cf\u00d0\7k\2\2\u00d0"+
		"\u00d1\7p\2\2\u00d1\u00d2\7v\2\2\u00d28\3\2\2\2\u00d3\u00d4\7i\2\2\u00d4"+
		"\u00d5\7g\2\2\u00d5\u00d6\7v\2\2\u00d6\u00d7\7K\2\2\u00d7\u00d8\7p\2\2"+
		"\u00d8\u00d9\7v\2\2\u00d9:\3\2\2\2\u00da\u00db\7i\2\2\u00db\u00dc\7g\2"+
		"\2\u00dc\u00dd\7v\2\2\u00dd\u00de\7E\2\2\u00de\u00df\7j\2\2\u00df\u00e0"+
		"\7c\2\2\u00e0\u00e1\7t\2\2\u00e1<\3\2\2\2\u00e2\u00e3\7i\2\2\u00e3\u00e4"+
		"\7g\2\2\u00e4\u00e5\7v\2\2\u00e5\u00e6\7D\2\2\u00e6\u00e7\7q\2\2\u00e7"+
		"\u00e8\7q\2\2\u00e8\u00e9\7n\2\2\u00e9>\3\2\2\2\u00ea\u00eb\7r\2\2\u00eb"+
		"\u00ec\7w\2\2\u00ec\u00ed\7v\2\2\u00ed\u00ee\7K\2\2\u00ee\u00ef\7p\2\2"+
		"\u00ef\u00f0\7v\2\2\u00f0@\3\2\2\2\u00f1\u00f2\7r\2\2\u00f2\u00f3\7w\2"+
		"\2\u00f3\u00f4\7v\2\2\u00f4\u00f5\7E\2\2\u00f5\u00f6\7j\2\2\u00f6\u00f7"+
		"\7c\2\2\u00f7\u00f8\7t\2\2\u00f8B\3\2\2\2\u00f9\u00fa\7r\2\2\u00fa\u00fb"+
		"\7w\2\2\u00fb\u00fc\7v\2\2\u00fc\u00fd\7D\2\2\u00fd\u00fe\7q\2\2\u00fe"+
		"\u00ff\7q\2\2\u00ff\u0100\7n\2\2\u0100D\3\2\2\2\u0101\u0102\7g\2\2\u0102"+
		"\u0103\7p\2\2\u0103\u0104\7w\2\2\u0104\u0105\7o\2\2\u0105F\3\2\2\2\u0106"+
		"\u0107\7t\2\2\u0107\u0108\7g\2\2\u0108\u0109\7v\2\2\u0109\u010a\7w\2\2"+
		"\u010a\u010b\7t\2\2\u010b\u010c\7p\2\2\u010cH\3\2\2\2\u010d\u010e\7h\2"+
		"\2\u010e\u010f\7k\2\2\u010f\u0110\7p\2\2\u0110\u0111\7c\2\2\u0111\u0112"+
		"\7n\2\2\u0112J\3\2\2\2\u0113\u0114\7<\2\2\u0114L\3\2\2\2\u0115\u0116\7"+
		"=\2\2\u0116N\3\2\2\2\u0117\u0118\7*\2\2\u0118P\3\2\2\2\u0119\u011a\7+"+
		"\2\2\u011aR\3\2\2\2\u011b\u011c\7}\2\2\u011cT\3\2\2\2\u011d\u011e\7\177"+
		"\2\2\u011eV\3\2\2\2\u011f\u0120\7]\2\2\u0120X\3\2\2\2\u0121\u0122\7_\2"+
		"\2\u0122Z\3\2\2\2\u0123\u0124\7.\2\2\u0124\\\3\2\2\2\u0125\u0126\7\60"+
		"\2\2\u0126^\3\2\2\2\u0127\u012c\7$\2\2\u0128\u012b\5w<\2\u0129\u012b\n"+
		"\2\2\2\u012a\u0128\3\2\2\2\u012a\u0129\3\2\2\2\u012b\u012e\3\2\2\2\u012c"+
		"\u012d\3\2\2\2\u012c\u012a\3\2\2\2\u012d\u012f\3\2\2\2\u012e\u012c\3\2"+
		"\2\2\u012f\u0130\7$\2\2\u0130`\3\2\2\2\u0131\u0137\7)\2\2\u0132\u0133"+
		"\7^\2\2\u0133\u0136\7)\2\2\u0134\u0136\n\2\2\2\u0135\u0132\3\2\2\2\u0135"+
		"\u0134\3\2\2\2\u0136\u0139\3\2\2\2\u0137\u0138\3\2\2\2\u0137\u0135\3\2"+
		"\2\2\u0138\u013a\3\2\2\2\u0139\u0137\3\2\2\2\u013a\u013b\7)\2\2\u013b"+
		"b\3\2\2\2\u013c\u0141\5u;\2\u013d\u0140\5u;\2\u013e\u0140\5s:\2\u013f"+
		"\u013d\3\2\2\2\u013f\u013e\3\2\2\2\u0140\u0143\3\2\2\2\u0141\u013f\3\2"+
		"\2\2\u0141\u0142\3\2\2\2\u0142d\3\2\2\2\u0143\u0141\3\2\2\2\u0144\u0146"+
		"\5s:\2\u0145\u0144\3\2\2\2\u0146\u0147\3\2\2\2\u0147\u0145\3\2\2\2\u0147"+
		"\u0148\3\2\2\2\u0148f\3\2\2\2\u0149\u014a\7v\2\2\u014a\u014b\7t\2\2\u014b"+
		"\u014c\7w\2\2\u014c\u014d\7g\2\2\u014dh\3\2\2\2\u014e\u014f\7h\2\2\u014f"+
		"\u0150\7c\2\2\u0150\u0151\7n\2\2\u0151\u0152\7u\2\2\u0152\u0153\7g\2\2"+
		"\u0153j\3\2\2\2\u0154\u0157\5g\64\2\u0155\u0157\5i\65\2\u0156\u0154\3"+
		"\2\2\2\u0156\u0155\3\2\2\2\u0157l\3\2\2\2\u0158\u0159\7\61\2\2\u0159\u015a"+
		"\7\61\2\2\u015a\u015e\3\2\2\2\u015b\u015d\n\2\2\2\u015c\u015b\3\2\2\2"+
		"\u015d\u0160\3\2\2\2\u015e\u015c\3\2\2\2\u015e\u015f\3\2\2\2\u015f\u0161"+
		"\3\2\2\2\u0160\u015e\3\2\2\2\u0161\u0162\b\67\2\2\u0162n\3\2\2\2\u0163"+
		"\u0164\7\61\2\2\u0164\u0165\7,\2\2\u0165\u0169\3\2\2\2\u0166\u0168\13"+
		"\2\2\2\u0167\u0166\3\2\2\2\u0168\u016b\3\2\2\2\u0169\u016a\3\2\2\2\u0169"+
		"\u0167\3\2\2\2\u016a\u016c\3\2\2\2\u016b\u0169\3\2\2\2\u016c\u016d\7,"+
		"\2\2\u016d\u016e\7\61\2\2\u016e\u016f\3\2\2\2\u016f\u0170\b8\3\2\u0170"+
		"p\3\2\2\2\u0171\u0173\t\3\2\2\u0172\u0171\3\2\2\2\u0173\u0174\3\2\2\2"+
		"\u0174\u0172\3\2\2\2\u0174\u0175\3\2\2\2\u0175\u0176\3\2\2\2\u0176\u0177"+
		"\b9\4\2\u0177r\3\2\2\2\u0178\u0179\4\62;\2\u0179t\3\2\2\2\u017a\u017b"+
		"\t\4\2\2\u017bv\3\2\2\2\u017c\u017d\7^\2\2\u017d\u0181\7$\2\2\u017e\u017f"+
		"\7^\2\2\u017f\u0181\7^\2\2\u0180\u017c\3\2\2\2\u0180\u017e\3\2\2\2\u0181"+
		"x\3\2\2\2\20\2\u00aa\u012a\u012c\u0135\u0137\u013f\u0141\u0147\u0156\u015e"+
		"\u0169\u0174\u0180";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}