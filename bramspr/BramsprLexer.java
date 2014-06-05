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
		TYPE=26, PRINT=27, ENUM=28, COLON=29, SEMICOLON=30, LEFT_PARENTHESIS=31, 
		RIGHT_PARENTHESIS=32, LEFT_BRACE=33, RIGHT_BRACE=34, LEFT_BLOCKBRACE=35, 
		RIGHT_BLOCKBRACE=36, COMMA=37, STRING=38, CHARACTER=39, IDENTIFIER=40, 
		NUMBER=41, COMMENT=42, BLOCKCOMMENT=43, WHITESPACE=44;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"':='", "'<>'", "'+'", "'-'", "'*'", "'/'", "'%'", "SMALLER_THAN", "'<='", 
		"GREATER_THAN", "'>='", "'='", "'=/='", "'+-'", "'^'", "'!'", "'&'", "'|'", 
		"'!&'", "LOGIC", "'if'", "'then'", "'else'", "'while'", "'function'", 
		"'type'", "'print'", "'enum'", "':'", "';'", "'('", "')'", "'{'", "'}'", 
		"'['", "']'", "','", "STRING", "CHARACTER", "IDENTIFIER", "NUMBER", "COMMENT", 
		"BLOCKCOMMENT", "WHITESPACE"
	};
	public static final String[] ruleNames = {
		"BECOMES", "SWAP", "PLUS", "MINUS", "MULTIPLICATION", "DIVISION", "MODULUS", 
		"SMALLER_THAN", "SMALLER_THAN_EQUALS_TO", "GREATER_THAN", "GREATER_THAN_EQUALS_TO", 
		"EQUALS_TO", "NOT_EQUALS_TO", "PLUSMINUS", "POWER", "NOT", "AND", "OR", 
		"XOR", "LOGIC", "IF", "THEN", "ELSE", "WHILE", "FUNCTION", "TYPE", "PRINT", 
		"ENUM", "COLON", "SEMICOLON", "LEFT_PARENTHESIS", "RIGHT_PARENTHESIS", 
		"LEFT_BRACE", "RIGHT_BRACE", "LEFT_BLOCKBRACE", "RIGHT_BLOCKBRACE", "COMMA", 
		"STRING", "CHARACTER", "IDENTIFIER", "NUMBER", "COMMENT", "BLOCKCOMMENT", 
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
		case 41: COMMENT_action((RuleContext)_localctx, actionIndex); break;

		case 42: BLOCKCOMMENT_action((RuleContext)_localctx, actionIndex); break;

		case 43: WHITESPACE_action((RuleContext)_localctx, actionIndex); break;
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
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\2.\u011e\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\3\2\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\5\3"+
		"\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3"+
		"\r\3\r\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22"+
		"\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3\25\5\25\u0093\n\25\3\26\3\26\3\26"+
		"\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33"+
		"\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\36"+
		"\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'\3"+
		"\'\7\'\u00d6\n\'\f\'\16\'\u00d9\13\'\3\'\3\'\3(\3(\3(\3(\7(\u00e1\n(\f"+
		"(\16(\u00e4\13(\3(\3(\3)\3)\3)\7)\u00eb\n)\f)\16)\u00ee\13)\3*\6*\u00f1"+
		"\n*\r*\16*\u00f2\3+\3+\3+\3+\7+\u00f9\n+\f+\16+\u00fc\13+\3+\3+\3,\3,"+
		"\3,\3,\7,\u0104\n,\f,\16,\u0107\13,\3,\3,\3,\3,\3,\3-\6-\u010f\n-\r-\16"+
		"-\u0110\3-\3-\3.\3.\3/\3/\3\60\3\60\3\60\3\60\5\60\u011d\n\60\5\u00d7"+
		"\u00e2\u0105\61\3\3\1\5\4\1\7\5\1\t\6\1\13\7\1\r\b\1\17\t\1\21\n\1\23"+
		"\13\1\25\f\1\27\r\1\31\16\1\33\17\1\35\20\1\37\21\1!\22\1#\23\1%\24\1"+
		"\'\25\1)\26\1+\27\1-\30\1/\31\1\61\32\1\63\33\1\65\34\1\67\35\19\36\1"+
		";\37\1= \1?!\1A\"\1C#\1E$\1G%\1I&\1K\'\1M(\1O)\1Q*\1S+\1U,\2W-\3Y.\4["+
		"\2\1]\2\1_\2\1\3\2\5\4\2\f\f\17\17\5\2\13\f\16\17\"\"\4\2C\\c|\u0127\2"+
		"\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2"+
		"\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2"+
		"\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2"+
		"\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2"+
		"\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2"+
		"\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2"+
		"\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U"+
		"\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\3a\3\2\2\2\5d\3\2\2\2\7g\3\2\2\2\ti\3\2"+
		"\2\2\13k\3\2\2\2\rm\3\2\2\2\17o\3\2\2\2\21q\3\2\2\2\23s\3\2\2\2\25v\3"+
		"\2\2\2\27x\3\2\2\2\31{\3\2\2\2\33}\3\2\2\2\35\u0081\3\2\2\2\37\u0084\3"+
		"\2\2\2!\u0086\3\2\2\2#\u0088\3\2\2\2%\u008a\3\2\2\2\'\u008c\3\2\2\2)\u0092"+
		"\3\2\2\2+\u0094\3\2\2\2-\u0097\3\2\2\2/\u009c\3\2\2\2\61\u00a1\3\2\2\2"+
		"\63\u00a7\3\2\2\2\65\u00b0\3\2\2\2\67\u00b5\3\2\2\29\u00bb\3\2\2\2;\u00c0"+
		"\3\2\2\2=\u00c2\3\2\2\2?\u00c4\3\2\2\2A\u00c6\3\2\2\2C\u00c8\3\2\2\2E"+
		"\u00ca\3\2\2\2G\u00cc\3\2\2\2I\u00ce\3\2\2\2K\u00d0\3\2\2\2M\u00d2\3\2"+
		"\2\2O\u00dc\3\2\2\2Q\u00e7\3\2\2\2S\u00f0\3\2\2\2U\u00f4\3\2\2\2W\u00ff"+
		"\3\2\2\2Y\u010e\3\2\2\2[\u0114\3\2\2\2]\u0116\3\2\2\2_\u011c\3\2\2\2a"+
		"b\7<\2\2bc\7?\2\2c\4\3\2\2\2de\7>\2\2ef\7@\2\2f\6\3\2\2\2gh\7-\2\2h\b"+
		"\3\2\2\2ij\7/\2\2j\n\3\2\2\2kl\7,\2\2l\f\3\2\2\2mn\7\61\2\2n\16\3\2\2"+
		"\2op\7\'\2\2p\20\3\2\2\2qr\7@\2\2r\22\3\2\2\2st\7>\2\2tu\7?\2\2u\24\3"+
		"\2\2\2vw\7@\2\2w\26\3\2\2\2xy\7@\2\2yz\7?\2\2z\30\3\2\2\2{|\7?\2\2|\32"+
		"\3\2\2\2}~\7?\2\2~\177\7\61\2\2\177\u0080\7?\2\2\u0080\34\3\2\2\2\u0081"+
		"\u0082\7-\2\2\u0082\u0083\7/\2\2\u0083\36\3\2\2\2\u0084\u0085\7`\2\2\u0085"+
		" \3\2\2\2\u0086\u0087\7#\2\2\u0087\"\3\2\2\2\u0088\u0089\7(\2\2\u0089"+
		"$\3\2\2\2\u008a\u008b\7~\2\2\u008b&\3\2\2\2\u008c\u008d\7#\2\2\u008d\u008e"+
		"\7(\2\2\u008e(\3\2\2\2\u008f\u0093\5#\22\2\u0090\u0093\5%\23\2\u0091\u0093"+
		"\5\'\24\2\u0092\u008f\3\2\2\2\u0092\u0090\3\2\2\2\u0092\u0091\3\2\2\2"+
		"\u0093*\3\2\2\2\u0094\u0095\7k\2\2\u0095\u0096\7h\2\2\u0096,\3\2\2\2\u0097"+
		"\u0098\7v\2\2\u0098\u0099\7j\2\2\u0099\u009a\7g\2\2\u009a\u009b\7p\2\2"+
		"\u009b.\3\2\2\2\u009c\u009d\7g\2\2\u009d\u009e\7n\2\2\u009e\u009f\7u\2"+
		"\2\u009f\u00a0\7g\2\2\u00a0\60\3\2\2\2\u00a1\u00a2\7y\2\2\u00a2\u00a3"+
		"\7j\2\2\u00a3\u00a4\7k\2\2\u00a4\u00a5\7n\2\2\u00a5\u00a6\7g\2\2\u00a6"+
		"\62\3\2\2\2\u00a7\u00a8\7h\2\2\u00a8\u00a9\7w\2\2\u00a9\u00aa\7p\2\2\u00aa"+
		"\u00ab\7e\2\2\u00ab\u00ac\7v\2\2\u00ac\u00ad\7k\2\2\u00ad\u00ae\7q\2\2"+
		"\u00ae\u00af\7p\2\2\u00af\64\3\2\2\2\u00b0\u00b1\7v\2\2\u00b1\u00b2\7"+
		"{\2\2\u00b2\u00b3\7r\2\2\u00b3\u00b4\7g\2\2\u00b4\66\3\2\2\2\u00b5\u00b6"+
		"\7r\2\2\u00b6\u00b7\7t\2\2\u00b7\u00b8\7k\2\2\u00b8\u00b9\7p\2\2\u00b9"+
		"\u00ba\7v\2\2\u00ba8\3\2\2\2\u00bb\u00bc\7g\2\2\u00bc\u00bd\7p\2\2\u00bd"+
		"\u00be\7w\2\2\u00be\u00bf\7o\2\2\u00bf:\3\2\2\2\u00c0\u00c1\7<\2\2\u00c1"+
		"<\3\2\2\2\u00c2\u00c3\7=\2\2\u00c3>\3\2\2\2\u00c4\u00c5\7*\2\2\u00c5@"+
		"\3\2\2\2\u00c6\u00c7\7+\2\2\u00c7B\3\2\2\2\u00c8\u00c9\7}\2\2\u00c9D\3"+
		"\2\2\2\u00ca\u00cb\7\177\2\2\u00cbF\3\2\2\2\u00cc\u00cd\7]\2\2\u00cdH"+
		"\3\2\2\2\u00ce\u00cf\7_\2\2\u00cfJ\3\2\2\2\u00d0\u00d1\7.\2\2\u00d1L\3"+
		"\2\2\2\u00d2\u00d7\7$\2\2\u00d3\u00d6\5_\60\2\u00d4\u00d6\n\2\2\2\u00d5"+
		"\u00d3\3\2\2\2\u00d5\u00d4\3\2\2\2\u00d6\u00d9\3\2\2\2\u00d7\u00d8\3\2"+
		"\2\2\u00d7\u00d5\3\2\2\2\u00d8\u00da\3\2\2\2\u00d9\u00d7\3\2\2\2\u00da"+
		"\u00db\7$\2\2\u00dbN\3\2\2\2\u00dc\u00e2\7)\2\2\u00dd\u00de\7^\2\2\u00de"+
		"\u00e1\7)\2\2\u00df\u00e1\n\2\2\2\u00e0\u00dd\3\2\2\2\u00e0\u00df\3\2"+
		"\2\2\u00e1\u00e4\3\2\2\2\u00e2\u00e3\3\2\2\2\u00e2\u00e0\3\2\2\2\u00e3"+
		"\u00e5\3\2\2\2\u00e4\u00e2\3\2\2\2\u00e5\u00e6\7)\2\2\u00e6P\3\2\2\2\u00e7"+
		"\u00ec\5]/\2\u00e8\u00eb\5]/\2\u00e9\u00eb\5[.\2\u00ea\u00e8\3\2\2\2\u00ea"+
		"\u00e9\3\2\2\2\u00eb\u00ee\3\2\2\2\u00ec\u00ea\3\2\2\2\u00ec\u00ed\3\2"+
		"\2\2\u00edR\3\2\2\2\u00ee\u00ec\3\2\2\2\u00ef\u00f1\5[.\2\u00f0\u00ef"+
		"\3\2\2\2\u00f1\u00f2\3\2\2\2\u00f2\u00f0\3\2\2\2\u00f2\u00f3\3\2\2\2\u00f3"+
		"T\3\2\2\2\u00f4\u00f5\7\61\2\2\u00f5\u00f6\7\61\2\2\u00f6\u00fa\3\2\2"+
		"\2\u00f7\u00f9\n\2\2\2\u00f8\u00f7\3\2\2\2\u00f9\u00fc\3\2\2\2\u00fa\u00f8"+
		"\3\2\2\2\u00fa\u00fb\3\2\2\2\u00fb\u00fd\3\2\2\2\u00fc\u00fa\3\2\2\2\u00fd"+
		"\u00fe\b+\2\2\u00feV\3\2\2\2\u00ff\u0100\7\61\2\2\u0100\u0101\7,\2\2\u0101"+
		"\u0105\3\2\2\2\u0102\u0104\13\2\2\2\u0103\u0102\3\2\2\2\u0104\u0107\3"+
		"\2\2\2\u0105\u0106\3\2\2\2\u0105\u0103\3\2\2\2\u0106\u0108\3\2\2\2\u0107"+
		"\u0105\3\2\2\2\u0108\u0109\7,\2\2\u0109\u010a\7\61\2\2\u010a\u010b\3\2"+
		"\2\2\u010b\u010c\b,\3\2\u010cX\3\2\2\2\u010d\u010f\t\3\2\2\u010e\u010d"+
		"\3\2\2\2\u010f\u0110\3\2\2\2\u0110\u010e\3\2\2\2\u0110\u0111\3\2\2\2\u0111"+
		"\u0112\3\2\2\2\u0112\u0113\b-\4\2\u0113Z\3\2\2\2\u0114\u0115\4\62;\2\u0115"+
		"\\\3\2\2\2\u0116\u0117\t\4\2\2\u0117^\3\2\2\2\u0118\u0119\7^\2\2\u0119"+
		"\u011d\7$\2\2\u011a\u011b\7^\2\2\u011b\u011d\7^\2\2\u011c\u0118\3\2\2"+
		"\2\u011c\u011a\3\2\2\2\u011d`\3\2\2\2\17\2\u0092\u00d5\u00d7\u00e0\u00e2"+
		"\u00ea\u00ec\u00f2\u00fa\u0105\u0110\u011c";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}