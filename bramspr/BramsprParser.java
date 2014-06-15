// Generated from D:\studie\Compilerbouw\bramspr\bramspr\src\Bramspr.g4 by ANTLR 4.1
package bramspr;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class BramsprParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		FUNCTION=25, LOGIC=20, WHILE=24, PUTINT=31, NOT=16, AND=17, PUTCHAR=32, 
		CHARACTER=48, IF=21, TYPE=26, FINAL=36, THEN=22, SMALLER_THAN=8, RIGHT_PARENTHESIS=40, 
		COMMA=45, IDENTIFIER=49, LEFT_PARENTHESIS=39, RETURN=35, DIVISION=6, BLOCKCOMMENT=55, 
		PLUS=3, GREATER_THAN_EQUALS_TO=11, COMMENT=54, DOT=46, RIGHT_BRACE=42, 
		XOR=19, GETBOOL=30, GREATER_THAN=10, GETCHAR=29, SWAP=2, ELSE=23, PLUSMINUS=14, 
		BOOL=53, NUMBER=50, BECOMES=1, WHITESPACE=56, POWER=15, PUTBOOL=33, SEMICOLON=38, 
		MINUS=4, TRUE=51, PRINT=27, EQUALS_TO=12, GETINT=28, LEFT_BLOCKBRACE=43, 
		RIGHT_BLOCKBRACE=44, COLON=37, ENUM=34, MODULUS=7, LEFT_BRACE=41, OR=18, 
		MULTIPLICATION=5, NOT_EQUALS_TO=13, FALSE=52, SMALLER_THAN_EQUALS_TO=9, 
		STRING=47;
	public static final String[] tokenNames = {
		"<INVALID>", "':='", "'<>'", "'+'", "'-'", "'*'", "'/'", "'%'", "SMALLER_THAN", 
		"'<='", "GREATER_THAN", "'>='", "'='", "'=/='", "'+-'", "'^'", "'!'", 
		"'&'", "'|'", "'!&'", "LOGIC", "'if'", "'then'", "'else'", "'while'", 
		"'function'", "'type'", "'print'", "'getInt'", "'getChar'", "'getBool'", 
		"'putInt'", "'putChar'", "'putBool'", "'enum'", "'return'", "'final'", 
		"':'", "';'", "'('", "')'", "'{'", "'}'", "'['", "']'", "','", "'.'", 
		"STRING", "CHARACTER", "IDENTIFIER", "NUMBER", "'true'", "'false'", "BOOL", 
		"COMMENT", "BLOCKCOMMENT", "WHITESPACE"
	};
	public static final int
		RULE_program = 0, RULE_block = 1, RULE_declaration = 2, RULE_variabledeclaration = 3, 
		RULE_finaldeclaration = 4, RULE_typedeclaration = 5, RULE_fielddeclaration = 6, 
		RULE_primitiveTypeDenoter = 7, RULE_functiondeclaration = 8, RULE_enumdeclaration = 9, 
		RULE_functioncall = 10, RULE_statement = 11, RULE_ifstatement = 12, RULE_whilestatement = 13, 
		RULE_assignment = 14, RULE_swapstatement = 15, RULE_expression = 16;
	public static final String[] ruleNames = {
		"program", "block", "declaration", "variabledeclaration", "finaldeclaration", 
		"typedeclaration", "fielddeclaration", "primitiveTypeDenoter", "functiondeclaration", 
		"enumdeclaration", "functioncall", "statement", "ifstatement", "whilestatement", 
		"assignment", "swapstatement", "expression"
	};

	@Override
	public String getGrammarFileName() { return "Bramspr.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public BramsprParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BramsprListener ) ((BramsprListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BramsprListener ) ((BramsprListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(34); block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public List<TerminalNode> RIGHT_BRACE() { return getTokens(BramsprParser.RIGHT_BRACE); }
		public TerminalNode LEFT_BRACE(int i) {
			return getToken(BramsprParser.LEFT_BRACE, i);
		}
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
		}
		public TerminalNode RIGHT_BRACE(int i) {
			return getToken(BramsprParser.RIGHT_BRACE, i);
		}
		public List<TerminalNode> LEFT_BRACE() { return getTokens(BramsprParser.LEFT_BRACE); }
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BramsprListener ) ((BramsprListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BramsprListener ) ((BramsprListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PLUS) | (1L << MINUS) | (1L << NOT) | (1L << IF) | (1L << WHILE) | (1L << FUNCTION) | (1L << TYPE) | (1L << GETINT) | (1L << GETCHAR) | (1L << GETBOOL) | (1L << PUTINT) | (1L << PUTCHAR) | (1L << PUTBOOL) | (1L << ENUM) | (1L << LEFT_PARENTHESIS) | (1L << LEFT_BRACE) | (1L << STRING) | (1L << CHARACTER) | (1L << IDENTIFIER) | (1L << NUMBER) | (1L << BOOL))) != 0)) {
				{
				setState(42);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(36); declaration();
					}
					break;

				case 2:
					{
					setState(37); statement();
					}
					break;

				case 3:
					{
					setState(38); match(LEFT_BRACE);
					setState(39); block();
					setState(40); match(RIGHT_BRACE);
					}
					break;
				}
				}
				setState(46);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclarationContext extends ParserRuleContext {
		public FinaldeclarationContext finaldeclaration() {
			return getRuleContext(FinaldeclarationContext.class,0);
		}
		public FunctiondeclarationContext functiondeclaration() {
			return getRuleContext(FunctiondeclarationContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(BramsprParser.SEMICOLON, 0); }
		public EnumdeclarationContext enumdeclaration() {
			return getRuleContext(EnumdeclarationContext.class,0);
		}
		public TypedeclarationContext typedeclaration() {
			return getRuleContext(TypedeclarationContext.class,0);
		}
		public VariabledeclarationContext variabledeclaration() {
			return getRuleContext(VariabledeclarationContext.class,0);
		}
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BramsprListener ) ((BramsprListener)listener).enterDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BramsprListener ) ((BramsprListener)listener).exitDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_declaration);
		try {
			setState(56);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(47); variabledeclaration();
				setState(48); match(SEMICOLON);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(50); finaldeclaration();
				setState(51); match(SEMICOLON);
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(53); functiondeclaration();
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(54); typedeclaration();
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(55); enumdeclaration();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariabledeclarationContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER(int i) {
			return getToken(BramsprParser.IDENTIFIER, i);
		}
		public List<TerminalNode> IDENTIFIER() { return getTokens(BramsprParser.IDENTIFIER); }
		public List<TerminalNode> COMMA() { return getTokens(BramsprParser.COMMA); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public PrimitiveTypeDenoterContext primitiveTypeDenoter() {
			return getRuleContext(PrimitiveTypeDenoterContext.class,0);
		}
		public TerminalNode BECOMES() { return getToken(BramsprParser.BECOMES, 0); }
		public TerminalNode COLON() { return getToken(BramsprParser.COLON, 0); }
		public TerminalNode COMMA(int i) {
			return getToken(BramsprParser.COMMA, i);
		}
		public VariabledeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variabledeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BramsprListener ) ((BramsprListener)listener).enterVariabledeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BramsprListener ) ((BramsprListener)listener).exitVariabledeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitVariabledeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariabledeclarationContext variabledeclaration() throws RecognitionException {
		VariabledeclarationContext _localctx = new VariabledeclarationContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_variabledeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(58); match(IDENTIFIER);
			setState(63);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(59); match(COMMA);
				setState(60); match(IDENTIFIER);
				}
				}
				setState(65);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(66); match(COLON);
			setState(67); primitiveTypeDenoter();
			setState(70);
			_la = _input.LA(1);
			if (_la==BECOMES) {
				{
				setState(68); match(BECOMES);
				setState(69); expression(0);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FinaldeclarationContext extends ParserRuleContext {
		public TerminalNode FINAL() { return getToken(BramsprParser.FINAL, 0); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(BramsprParser.IDENTIFIER, i);
		}
		public List<TerminalNode> IDENTIFIER() { return getTokens(BramsprParser.IDENTIFIER); }
		public List<TerminalNode> COMMA() { return getTokens(BramsprParser.COMMA); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public PrimitiveTypeDenoterContext primitiveTypeDenoter() {
			return getRuleContext(PrimitiveTypeDenoterContext.class,0);
		}
		public TerminalNode BECOMES() { return getToken(BramsprParser.BECOMES, 0); }
		public TerminalNode COLON() { return getToken(BramsprParser.COLON, 0); }
		public TerminalNode COMMA(int i) {
			return getToken(BramsprParser.COMMA, i);
		}
		public FinaldeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_finaldeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BramsprListener ) ((BramsprListener)listener).enterFinaldeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BramsprListener ) ((BramsprListener)listener).exitFinaldeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitFinaldeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FinaldeclarationContext finaldeclaration() throws RecognitionException {
		FinaldeclarationContext _localctx = new FinaldeclarationContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_finaldeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(72); match(IDENTIFIER);
			setState(77);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(73); match(COMMA);
				setState(74); match(IDENTIFIER);
				}
				}
				setState(79);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(80); match(COLON);
			setState(81); match(FINAL);
			setState(82); primitiveTypeDenoter();
			setState(83); match(BECOMES);
			setState(84); expression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypedeclarationContext extends ParserRuleContext {
		public TerminalNode RIGHT_BRACE() { return getToken(BramsprParser.RIGHT_BRACE, 0); }
		public TerminalNode IDENTIFIER() { return getToken(BramsprParser.IDENTIFIER, 0); }
		public List<TerminalNode> COMMA() { return getTokens(BramsprParser.COMMA); }
		public FielddeclarationContext fielddeclaration(int i) {
			return getRuleContext(FielddeclarationContext.class,i);
		}
		public TerminalNode LEFT_BRACE() { return getToken(BramsprParser.LEFT_BRACE, 0); }
		public List<FielddeclarationContext> fielddeclaration() {
			return getRuleContexts(FielddeclarationContext.class);
		}
		public TerminalNode COMMA(int i) {
			return getToken(BramsprParser.COMMA, i);
		}
		public TerminalNode TYPE() { return getToken(BramsprParser.TYPE, 0); }
		public TypedeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typedeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BramsprListener ) ((BramsprListener)listener).enterTypedeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BramsprListener ) ((BramsprListener)listener).exitTypedeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitTypedeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypedeclarationContext typedeclaration() throws RecognitionException {
		TypedeclarationContext _localctx = new TypedeclarationContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_typedeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86); match(TYPE);
			setState(87); match(IDENTIFIER);
			setState(88); match(LEFT_BRACE);
			setState(89); fielddeclaration();
			setState(94);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(90); match(COMMA);
				setState(91); fielddeclaration();
				}
				}
				setState(96);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(97); match(RIGHT_BRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FielddeclarationContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER(int i) {
			return getToken(BramsprParser.IDENTIFIER, i);
		}
		public List<TerminalNode> IDENTIFIER() { return getTokens(BramsprParser.IDENTIFIER); }
		public List<TerminalNode> COMMA() { return getTokens(BramsprParser.COMMA); }
		public PrimitiveTypeDenoterContext primitiveTypeDenoter() {
			return getRuleContext(PrimitiveTypeDenoterContext.class,0);
		}
		public TerminalNode COLON() { return getToken(BramsprParser.COLON, 0); }
		public TerminalNode COMMA(int i) {
			return getToken(BramsprParser.COMMA, i);
		}
		public FielddeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fielddeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BramsprListener ) ((BramsprListener)listener).enterFielddeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BramsprListener ) ((BramsprListener)listener).exitFielddeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitFielddeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FielddeclarationContext fielddeclaration() throws RecognitionException {
		FielddeclarationContext _localctx = new FielddeclarationContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_fielddeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99); match(IDENTIFIER);
			setState(104);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(100); match(COMMA);
				setState(101); match(IDENTIFIER);
				}
				}
				setState(106);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(107); match(COLON);
			setState(108); primitiveTypeDenoter();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrimitiveTypeDenoterContext extends ParserRuleContext {
		public List<TerminalNode> LEFT_BLOCKBRACE() { return getTokens(BramsprParser.LEFT_BLOCKBRACE); }
		public TerminalNode IDENTIFIER() { return getToken(BramsprParser.IDENTIFIER, 0); }
		public TerminalNode RIGHT_BLOCKBRACE(int i) {
			return getToken(BramsprParser.RIGHT_BLOCKBRACE, i);
		}
		public TerminalNode NUMBER(int i) {
			return getToken(BramsprParser.NUMBER, i);
		}
		public TerminalNode LEFT_BLOCKBRACE(int i) {
			return getToken(BramsprParser.LEFT_BLOCKBRACE, i);
		}
		public List<TerminalNode> NUMBER() { return getTokens(BramsprParser.NUMBER); }
		public List<TerminalNode> RIGHT_BLOCKBRACE() { return getTokens(BramsprParser.RIGHT_BLOCKBRACE); }
		public PrimitiveTypeDenoterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primitiveTypeDenoter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BramsprListener ) ((BramsprListener)listener).enterPrimitiveTypeDenoter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BramsprListener ) ((BramsprListener)listener).exitPrimitiveTypeDenoter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitPrimitiveTypeDenoter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimitiveTypeDenoterContext primitiveTypeDenoter() throws RecognitionException {
		PrimitiveTypeDenoterContext _localctx = new PrimitiveTypeDenoterContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_primitiveTypeDenoter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LEFT_BLOCKBRACE) {
				{
				{
				setState(110); match(LEFT_BLOCKBRACE);
				setState(111); match(NUMBER);
				setState(112); match(RIGHT_BLOCKBRACE);
				}
				}
				setState(117);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(118); match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctiondeclarationContext extends ParserRuleContext {
		public TerminalNode RIGHT_BRACE() { return getToken(BramsprParser.RIGHT_BRACE, 0); }
		public TerminalNode SEMICOLON() { return getToken(BramsprParser.SEMICOLON, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode COMMA(int i) {
			return getToken(BramsprParser.COMMA, i);
		}
		public VariabledeclarationContext variabledeclaration(int i) {
			return getRuleContext(VariabledeclarationContext.class,i);
		}
		public TerminalNode LEFT_PARENTHESIS() { return getToken(BramsprParser.LEFT_PARENTHESIS, 0); }
		public TerminalNode IDENTIFIER() { return getToken(BramsprParser.IDENTIFIER, 0); }
		public List<TerminalNode> COMMA() { return getTokens(BramsprParser.COMMA); }
		public TerminalNode FUNCTION() { return getToken(BramsprParser.FUNCTION, 0); }
		public TerminalNode RIGHT_PARENTHESIS() { return getToken(BramsprParser.RIGHT_PARENTHESIS, 0); }
		public TerminalNode RETURN() { return getToken(BramsprParser.RETURN, 0); }
		public PrimitiveTypeDenoterContext primitiveTypeDenoter() {
			return getRuleContext(PrimitiveTypeDenoterContext.class,0);
		}
		public TerminalNode LEFT_BRACE() { return getToken(BramsprParser.LEFT_BRACE, 0); }
		public List<VariabledeclarationContext> variabledeclaration() {
			return getRuleContexts(VariabledeclarationContext.class);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public FunctiondeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functiondeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BramsprListener ) ((BramsprListener)listener).enterFunctiondeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BramsprListener ) ((BramsprListener)listener).exitFunctiondeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitFunctiondeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctiondeclarationContext functiondeclaration() throws RecognitionException {
		FunctiondeclarationContext _localctx = new FunctiondeclarationContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_functiondeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120); match(FUNCTION);
			setState(121); primitiveTypeDenoter();
			setState(122); match(IDENTIFIER);
			setState(123); match(LEFT_PARENTHESIS);
			setState(132);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(124); variabledeclaration();
				setState(129);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(125); match(COMMA);
					setState(126); variabledeclaration();
					}
					}
					setState(131);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(134); match(RIGHT_PARENTHESIS);
			setState(135); match(LEFT_BRACE);
			setState(136); block();
			setState(141);
			_la = _input.LA(1);
			if (_la==RETURN) {
				{
				setState(137); match(RETURN);
				setState(138); expression(0);
				setState(139); match(SEMICOLON);
				}
			}

			setState(143); match(RIGHT_BRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EnumdeclarationContext extends ParserRuleContext {
		public TerminalNode RIGHT_BRACE() { return getToken(BramsprParser.RIGHT_BRACE, 0); }
		public TerminalNode ENUM() { return getToken(BramsprParser.ENUM, 0); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(BramsprParser.IDENTIFIER, i);
		}
		public List<TerminalNode> IDENTIFIER() { return getTokens(BramsprParser.IDENTIFIER); }
		public List<TerminalNode> COMMA() { return getTokens(BramsprParser.COMMA); }
		public TerminalNode LEFT_BRACE() { return getToken(BramsprParser.LEFT_BRACE, 0); }
		public TerminalNode COMMA(int i) {
			return getToken(BramsprParser.COMMA, i);
		}
		public EnumdeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumdeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BramsprListener ) ((BramsprListener)listener).enterEnumdeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BramsprListener ) ((BramsprListener)listener).exitEnumdeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitEnumdeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnumdeclarationContext enumdeclaration() throws RecognitionException {
		EnumdeclarationContext _localctx = new EnumdeclarationContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_enumdeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(145); match(ENUM);
			setState(146); match(IDENTIFIER);
			setState(147); match(LEFT_BRACE);
			setState(148); match(IDENTIFIER);
			setState(153);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(149); match(COMMA);
				setState(150); match(IDENTIFIER);
				}
				}
				setState(155);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(156); match(RIGHT_BRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctioncallContext extends ParserRuleContext {
		public FunctioncallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functioncall; }
	 
		public FunctioncallContext() { }
		public void copyFrom(FunctioncallContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class PutCharExpressionContext extends FunctioncallContext {
		public TerminalNode PUTCHAR() { return getToken(BramsprParser.PUTCHAR, 0); }
		public TerminalNode LEFT_PARENTHESIS() { return getToken(BramsprParser.LEFT_PARENTHESIS, 0); }
		public TerminalNode RIGHT_PARENTHESIS() { return getToken(BramsprParser.RIGHT_PARENTHESIS, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public PutCharExpressionContext(FunctioncallContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BramsprListener ) ((BramsprListener)listener).enterPutCharExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BramsprListener ) ((BramsprListener)listener).exitPutCharExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitPutCharExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class GetCharExpressionContext extends FunctioncallContext {
		public TerminalNode LEFT_PARENTHESIS() { return getToken(BramsprParser.LEFT_PARENTHESIS, 0); }
		public TerminalNode RIGHT_PARENTHESIS() { return getToken(BramsprParser.RIGHT_PARENTHESIS, 0); }
		public TerminalNode GETCHAR() { return getToken(BramsprParser.GETCHAR, 0); }
		public GetCharExpressionContext(FunctioncallContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BramsprListener ) ((BramsprListener)listener).enterGetCharExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BramsprListener ) ((BramsprListener)listener).exitGetCharExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitGetCharExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PutIntExpressionContext extends FunctioncallContext {
		public TerminalNode LEFT_PARENTHESIS() { return getToken(BramsprParser.LEFT_PARENTHESIS, 0); }
		public TerminalNode RIGHT_PARENTHESIS() { return getToken(BramsprParser.RIGHT_PARENTHESIS, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode PUTINT() { return getToken(BramsprParser.PUTINT, 0); }
		public PutIntExpressionContext(FunctioncallContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BramsprListener ) ((BramsprListener)listener).enterPutIntExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BramsprListener ) ((BramsprListener)listener).exitPutIntExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitPutIntExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class GetIntExpressionContext extends FunctioncallContext {
		public TerminalNode LEFT_PARENTHESIS() { return getToken(BramsprParser.LEFT_PARENTHESIS, 0); }
		public TerminalNode GETINT() { return getToken(BramsprParser.GETINT, 0); }
		public TerminalNode RIGHT_PARENTHESIS() { return getToken(BramsprParser.RIGHT_PARENTHESIS, 0); }
		public GetIntExpressionContext(FunctioncallContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BramsprListener ) ((BramsprListener)listener).enterGetIntExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BramsprListener ) ((BramsprListener)listener).exitGetIntExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitGetIntExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FunctionCallExpressionContext extends FunctioncallContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode LEFT_PARENTHESIS() { return getToken(BramsprParser.LEFT_PARENTHESIS, 0); }
		public TerminalNode IDENTIFIER() { return getToken(BramsprParser.IDENTIFIER, 0); }
		public List<TerminalNode> COMMA() { return getTokens(BramsprParser.COMMA); }
		public TerminalNode RIGHT_PARENTHESIS() { return getToken(BramsprParser.RIGHT_PARENTHESIS, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public TerminalNode COMMA(int i) {
			return getToken(BramsprParser.COMMA, i);
		}
		public FunctionCallExpressionContext(FunctioncallContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BramsprListener ) ((BramsprListener)listener).enterFunctionCallExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BramsprListener ) ((BramsprListener)listener).exitFunctionCallExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitFunctionCallExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PutBoolExpressionContext extends FunctioncallContext {
		public TerminalNode PUTBOOL() { return getToken(BramsprParser.PUTBOOL, 0); }
		public TerminalNode LEFT_PARENTHESIS() { return getToken(BramsprParser.LEFT_PARENTHESIS, 0); }
		public TerminalNode RIGHT_PARENTHESIS() { return getToken(BramsprParser.RIGHT_PARENTHESIS, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public PutBoolExpressionContext(FunctioncallContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BramsprListener ) ((BramsprListener)listener).enterPutBoolExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BramsprListener ) ((BramsprListener)listener).exitPutBoolExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitPutBoolExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class GetBoolExpressionContext extends FunctioncallContext {
		public TerminalNode LEFT_PARENTHESIS() { return getToken(BramsprParser.LEFT_PARENTHESIS, 0); }
		public TerminalNode RIGHT_PARENTHESIS() { return getToken(BramsprParser.RIGHT_PARENTHESIS, 0); }
		public TerminalNode GETBOOL() { return getToken(BramsprParser.GETBOOL, 0); }
		public GetBoolExpressionContext(FunctioncallContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BramsprListener ) ((BramsprListener)listener).enterGetBoolExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BramsprListener ) ((BramsprListener)listener).exitGetBoolExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitGetBoolExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctioncallContext functioncall() throws RecognitionException {
		FunctioncallContext _localctx = new FunctioncallContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_functioncall);
		int _la;
		try {
			setState(195);
			switch (_input.LA(1)) {
			case GETINT:
				_localctx = new GetIntExpressionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(158); match(GETINT);
				setState(159); match(LEFT_PARENTHESIS);
				setState(160); match(RIGHT_PARENTHESIS);
				}
				break;
			case GETCHAR:
				_localctx = new GetCharExpressionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(161); match(GETCHAR);
				setState(162); match(LEFT_PARENTHESIS);
				setState(163); match(RIGHT_PARENTHESIS);
				}
				break;
			case GETBOOL:
				_localctx = new GetBoolExpressionContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(164); match(GETBOOL);
				setState(165); match(LEFT_PARENTHESIS);
				setState(166); match(RIGHT_PARENTHESIS);
				}
				break;
			case PUTINT:
				_localctx = new PutIntExpressionContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(167); match(PUTINT);
				setState(168); match(LEFT_PARENTHESIS);
				setState(169); expression(0);
				setState(170); match(RIGHT_PARENTHESIS);
				}
				break;
			case PUTCHAR:
				_localctx = new PutCharExpressionContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(172); match(PUTCHAR);
				setState(173); match(LEFT_PARENTHESIS);
				setState(174); expression(0);
				setState(175); match(RIGHT_PARENTHESIS);
				}
				break;
			case PUTBOOL:
				_localctx = new PutBoolExpressionContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(177); match(PUTBOOL);
				setState(178); match(LEFT_PARENTHESIS);
				setState(179); expression(0);
				setState(180); match(RIGHT_PARENTHESIS);
				}
				break;
			case IDENTIFIER:
				_localctx = new FunctionCallExpressionContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(182); match(IDENTIFIER);
				setState(183); match(LEFT_PARENTHESIS);
				setState(192);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PLUS) | (1L << MINUS) | (1L << NOT) | (1L << GETINT) | (1L << GETCHAR) | (1L << GETBOOL) | (1L << PUTINT) | (1L << PUTCHAR) | (1L << PUTBOOL) | (1L << ENUM) | (1L << LEFT_PARENTHESIS) | (1L << LEFT_BRACE) | (1L << STRING) | (1L << CHARACTER) | (1L << IDENTIFIER) | (1L << NUMBER) | (1L << BOOL))) != 0)) {
					{
					setState(184); expression(0);
					setState(189);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(185); match(COMMA);
						setState(186); expression(0);
						}
						}
						setState(191);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(194); match(RIGHT_PARENTHESIS);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public TerminalNode SEMICOLON() { return getToken(BramsprParser.SEMICOLON, 0); }
		public SwapstatementContext swapstatement() {
			return getRuleContext(SwapstatementContext.class,0);
		}
		public IfstatementContext ifstatement() {
			return getRuleContext(IfstatementContext.class,0);
		}
		public WhilestatementContext whilestatement() {
			return getRuleContext(WhilestatementContext.class,0);
		}
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BramsprListener ) ((BramsprListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BramsprListener ) ((BramsprListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_statement);
		try {
			setState(208);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(197); ifstatement();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(198); whilestatement();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(199); assignment();
				setState(200); match(SEMICOLON);
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(202); swapstatement();
				setState(203); match(SEMICOLON);
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(205); expression(0);
				setState(206); match(SEMICOLON);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IfstatementContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(BramsprParser.IF, 0); }
		public List<TerminalNode> RIGHT_BRACE() { return getTokens(BramsprParser.RIGHT_BRACE); }
		public TerminalNode LEFT_BRACE(int i) {
			return getToken(BramsprParser.LEFT_BRACE, i);
		}
		public TerminalNode ELSE() { return getToken(BramsprParser.ELSE, 0); }
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public TerminalNode RIGHT_BRACE(int i) {
			return getToken(BramsprParser.RIGHT_BRACE, i);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<TerminalNode> LEFT_BRACE() { return getTokens(BramsprParser.LEFT_BRACE); }
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public IfstatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifstatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BramsprListener ) ((BramsprListener)listener).enterIfstatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BramsprListener ) ((BramsprListener)listener).exitIfstatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitIfstatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfstatementContext ifstatement() throws RecognitionException {
		IfstatementContext _localctx = new IfstatementContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_ifstatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(210); match(IF);
			setState(211); expression(0);
			setState(212); match(LEFT_BRACE);
			setState(213); block();
			setState(214); match(RIGHT_BRACE);
			setState(220);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(215); match(ELSE);
				setState(216); match(LEFT_BRACE);
				setState(217); block();
				setState(218); match(RIGHT_BRACE);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WhilestatementContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(BramsprParser.WHILE, 0); }
		public TerminalNode RIGHT_BRACE() { return getToken(BramsprParser.RIGHT_BRACE, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode LEFT_BRACE() { return getToken(BramsprParser.LEFT_BRACE, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public WhilestatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whilestatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BramsprListener ) ((BramsprListener)listener).enterWhilestatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BramsprListener ) ((BramsprListener)listener).exitWhilestatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitWhilestatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhilestatementContext whilestatement() throws RecognitionException {
		WhilestatementContext _localctx = new WhilestatementContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_whilestatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(222); match(WHILE);
			setState(223); expression(0);
			setState(224); match(LEFT_BRACE);
			setState(225); block();
			setState(226); match(RIGHT_BRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignmentContext extends ParserRuleContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public TerminalNode BECOMES(int i) {
			return getToken(BramsprParser.BECOMES, i);
		}
		public List<TerminalNode> BECOMES() { return getTokens(BramsprParser.BECOMES); }
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BramsprListener ) ((BramsprListener)listener).enterAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BramsprListener ) ((BramsprListener)listener).exitAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_assignment);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(231); 
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(228); expression(0);
					setState(229); match(BECOMES);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(233); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			} while ( _alt!=2 && _alt!=-1 );
			setState(235); expression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SwapstatementContext extends ParserRuleContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode SWAP() { return getToken(BramsprParser.SWAP, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public SwapstatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_swapstatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BramsprListener ) ((BramsprListener)listener).enterSwapstatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BramsprListener ) ((BramsprListener)listener).exitSwapstatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitSwapstatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SwapstatementContext swapstatement() throws RecognitionException {
		SwapstatementContext _localctx = new SwapstatementContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_swapstatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(237); expression(0);
			setState(238); match(SWAP);
			setState(239); expression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public int _p;
		public ExpressionContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public ExpressionContext(ParserRuleContext parent, int invokingState, int _p) {
			super(parent, invokingState);
			this._p = _p;
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
			this._p = ctx._p;
		}
	}
	public static class ParenthesisExpressionContext extends ExpressionContext {
		public TerminalNode LEFT_PARENTHESIS() { return getToken(BramsprParser.LEFT_PARENTHESIS, 0); }
		public TerminalNode RIGHT_PARENTHESIS() { return getToken(BramsprParser.RIGHT_PARENTHESIS, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ParenthesisExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BramsprListener ) ((BramsprListener)listener).enterParenthesisExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BramsprListener ) ((BramsprListener)listener).exitParenthesisExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitParenthesisExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class UnaryExpressionContext extends ExpressionContext {
		public TerminalNode MINUS() { return getToken(BramsprParser.MINUS, 0); }
		public TerminalNode NOT() { return getToken(BramsprParser.NOT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode PLUS() { return getToken(BramsprParser.PLUS, 0); }
		public UnaryExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BramsprListener ) ((BramsprListener)listener).enterUnaryExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BramsprListener ) ((BramsprListener)listener).exitUnaryExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitUnaryExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AdditionExpressionContext extends ExpressionContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode MINUS() { return getToken(BramsprParser.MINUS, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public TerminalNode PLUS() { return getToken(BramsprParser.PLUS, 0); }
		public AdditionExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BramsprListener ) ((BramsprListener)listener).enterAdditionExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BramsprListener ) ((BramsprListener)listener).exitAdditionExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitAdditionExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AssignExpressionContext extends ExpressionContext {
		public TerminalNode LEFT_PARENTHESIS() { return getToken(BramsprParser.LEFT_PARENTHESIS, 0); }
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public TerminalNode RIGHT_PARENTHESIS() { return getToken(BramsprParser.RIGHT_PARENTHESIS, 0); }
		public AssignExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BramsprListener ) ((BramsprListener)listener).enterAssignExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BramsprListener ) ((BramsprListener)listener).exitAssignExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitAssignExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OrExpressionContext extends ExpressionContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode OR() { return getToken(BramsprParser.OR, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public OrExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BramsprListener ) ((BramsprListener)listener).enterOrExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BramsprListener ) ((BramsprListener)listener).exitOrExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitOrExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PowerExpressionContext extends ExpressionContext {
		public TerminalNode POWER() { return getToken(BramsprParser.POWER, 0); }
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public PowerExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BramsprListener ) ((BramsprListener)listener).enterPowerExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BramsprListener ) ((BramsprListener)listener).exitPowerExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitPowerExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NotEqualsToExpressionContext extends ExpressionContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> NOT_EQUALS_TO() { return getTokens(BramsprParser.NOT_EQUALS_TO); }
		public TerminalNode NOT_EQUALS_TO(int i) {
			return getToken(BramsprParser.NOT_EQUALS_TO, i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public NotEqualsToExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BramsprListener ) ((BramsprListener)listener).enterNotEqualsToExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BramsprListener ) ((BramsprListener)listener).exitNotEqualsToExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitNotEqualsToExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AndExpressionContext extends ExpressionContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode AND() { return getToken(BramsprParser.AND, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public AndExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BramsprListener ) ((BramsprListener)listener).enterAndExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BramsprListener ) ((BramsprListener)listener).exitAndExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitAndExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EqualsToExpressionContext extends ExpressionContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> EQUALS_TO() { return getTokens(BramsprParser.EQUALS_TO); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public TerminalNode EQUALS_TO(int i) {
			return getToken(BramsprParser.EQUALS_TO, i);
		}
		public EqualsToExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BramsprListener ) ((BramsprListener)listener).enterEqualsToExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BramsprListener ) ((BramsprListener)listener).exitEqualsToExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitEqualsToExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArrayAccessExpressionContext extends ExpressionContext {
		public TerminalNode LEFT_BLOCKBRACE() { return getToken(BramsprParser.LEFT_BLOCKBRACE, 0); }
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public TerminalNode RIGHT_BLOCKBRACE() { return getToken(BramsprParser.RIGHT_BLOCKBRACE, 0); }
		public ArrayAccessExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BramsprListener ) ((BramsprListener)listener).enterArrayAccessExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BramsprListener ) ((BramsprListener)listener).exitArrayAccessExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitArrayAccessExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class GreaterThanExpressionContext extends ExpressionContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode GREATER_THAN(int i) {
			return getToken(BramsprParser.GREATER_THAN, i);
		}
		public List<TerminalNode> GREATER_THAN() { return getTokens(BramsprParser.GREATER_THAN); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public GreaterThanExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BramsprListener ) ((BramsprListener)listener).enterGreaterThanExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BramsprListener ) ((BramsprListener)listener).exitGreaterThanExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitGreaterThanExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EnumExpressionContext extends ExpressionContext {
		public TerminalNode ENUM() { return getToken(BramsprParser.ENUM, 0); }
		public List<TerminalNode> DOT() { return getTokens(BramsprParser.DOT); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(BramsprParser.IDENTIFIER, i);
		}
		public List<TerminalNode> IDENTIFIER() { return getTokens(BramsprParser.IDENTIFIER); }
		public TerminalNode DOT(int i) {
			return getToken(BramsprParser.DOT, i);
		}
		public EnumExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BramsprListener ) ((BramsprListener)listener).enterEnumExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BramsprListener ) ((BramsprListener)listener).exitEnumExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitEnumExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CharLiteralExpressionContext extends ExpressionContext {
		public TerminalNode CHARACTER() { return getToken(BramsprParser.CHARACTER, 0); }
		public CharLiteralExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BramsprListener ) ((BramsprListener)listener).enterCharLiteralExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BramsprListener ) ((BramsprListener)listener).exitCharLiteralExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitCharLiteralExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SmallerThanExpressionContext extends ExpressionContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> SMALLER_THAN() { return getTokens(BramsprParser.SMALLER_THAN); }
		public TerminalNode SMALLER_THAN(int i) {
			return getToken(BramsprParser.SMALLER_THAN, i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public SmallerThanExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BramsprListener ) ((BramsprListener)listener).enterSmallerThanExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BramsprListener ) ((BramsprListener)listener).exitSmallerThanExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitSmallerThanExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MultiplicationExpressionContext extends ExpressionContext {
		public TerminalNode MULTIPLICATION() { return getToken(BramsprParser.MULTIPLICATION, 0); }
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode DIVISION() { return getToken(BramsprParser.DIVISION, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public TerminalNode MODULUS() { return getToken(BramsprParser.MODULUS, 0); }
		public MultiplicationExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BramsprListener ) ((BramsprListener)listener).enterMultiplicationExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BramsprListener ) ((BramsprListener)listener).exitMultiplicationExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitMultiplicationExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PlusMinusExpressionContext extends ExpressionContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode EQUALS_TO() { return getToken(BramsprParser.EQUALS_TO, 0); }
		public TerminalNode PLUSMINUS() { return getToken(BramsprParser.PLUSMINUS, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public PlusMinusExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BramsprListener ) ((BramsprListener)listener).enterPlusMinusExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BramsprListener ) ((BramsprListener)listener).exitPlusMinusExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitPlusMinusExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StringLiteralExpressionContext extends ExpressionContext {
		public TerminalNode STRING() { return getToken(BramsprParser.STRING, 0); }
		public StringLiteralExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BramsprListener ) ((BramsprListener)listener).enterStringLiteralExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BramsprListener ) ((BramsprListener)listener).exitStringLiteralExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitStringLiteralExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VariableExpressionContext extends ExpressionContext {
		public TerminalNode IDENTIFIER() { return getToken(BramsprParser.IDENTIFIER, 0); }
		public VariableExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BramsprListener ) ((BramsprListener)listener).enterVariableExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BramsprListener ) ((BramsprListener)listener).exitVariableExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitVariableExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FunctionExpressionContext extends ExpressionContext {
		public FunctioncallContext functioncall() {
			return getRuleContext(FunctioncallContext.class,0);
		}
		public FunctionExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BramsprListener ) ((BramsprListener)listener).enterFunctionExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BramsprListener ) ((BramsprListener)listener).exitFunctionExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitFunctionExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class GreaterThanEqualsToExpressionContext extends ExpressionContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> GREATER_THAN_EQUALS_TO() { return getTokens(BramsprParser.GREATER_THAN_EQUALS_TO); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public TerminalNode GREATER_THAN_EQUALS_TO(int i) {
			return getToken(BramsprParser.GREATER_THAN_EQUALS_TO, i);
		}
		public GreaterThanEqualsToExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BramsprListener ) ((BramsprListener)listener).enterGreaterThanEqualsToExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BramsprListener ) ((BramsprListener)listener).exitGreaterThanEqualsToExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitGreaterThanEqualsToExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RecordAccessExpressionContext extends ExpressionContext {
		public TerminalNode DOT() { return getToken(BramsprParser.DOT, 0); }
		public TerminalNode IDENTIFIER() { return getToken(BramsprParser.IDENTIFIER, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public RecordAccessExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BramsprListener ) ((BramsprListener)listener).enterRecordAccessExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BramsprListener ) ((BramsprListener)listener).exitRecordAccessExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitRecordAccessExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntLiteralExpressionContext extends ExpressionContext {
		public TerminalNode NUMBER() { return getToken(BramsprParser.NUMBER, 0); }
		public IntLiteralExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BramsprListener ) ((BramsprListener)listener).enterIntLiteralExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BramsprListener ) ((BramsprListener)listener).exitIntLiteralExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitIntLiteralExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SmallerThanEqualsToExpressionContext extends ExpressionContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> SMALLER_THAN_EQUALS_TO() { return getTokens(BramsprParser.SMALLER_THAN_EQUALS_TO); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public TerminalNode SMALLER_THAN_EQUALS_TO(int i) {
			return getToken(BramsprParser.SMALLER_THAN_EQUALS_TO, i);
		}
		public SmallerThanEqualsToExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BramsprListener ) ((BramsprListener)listener).enterSmallerThanEqualsToExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BramsprListener ) ((BramsprListener)listener).exitSmallerThanEqualsToExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitSmallerThanEqualsToExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RecordLiteralExpressionContext extends ExpressionContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode RIGHT_BRACE() { return getToken(BramsprParser.RIGHT_BRACE, 0); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(BramsprParser.IDENTIFIER, i);
		}
		public List<TerminalNode> IDENTIFIER() { return getTokens(BramsprParser.IDENTIFIER); }
		public List<TerminalNode> COMMA() { return getTokens(BramsprParser.COMMA); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public TerminalNode LEFT_BRACE() { return getToken(BramsprParser.LEFT_BRACE, 0); }
		public TerminalNode BECOMES(int i) {
			return getToken(BramsprParser.BECOMES, i);
		}
		public List<TerminalNode> BECOMES() { return getTokens(BramsprParser.BECOMES); }
		public TerminalNode COMMA(int i) {
			return getToken(BramsprParser.COMMA, i);
		}
		public RecordLiteralExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BramsprListener ) ((BramsprListener)listener).enterRecordLiteralExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BramsprListener ) ((BramsprListener)listener).exitRecordLiteralExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitRecordLiteralExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArrayLiteralExpressionContext extends ExpressionContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode RIGHT_BRACE() { return getToken(BramsprParser.RIGHT_BRACE, 0); }
		public List<TerminalNode> COMMA() { return getTokens(BramsprParser.COMMA); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public TerminalNode LEFT_BRACE() { return getToken(BramsprParser.LEFT_BRACE, 0); }
		public TerminalNode COMMA(int i) {
			return getToken(BramsprParser.COMMA, i);
		}
		public ArrayLiteralExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BramsprListener ) ((BramsprListener)listener).enterArrayLiteralExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BramsprListener ) ((BramsprListener)listener).exitArrayLiteralExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitArrayLiteralExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FieldAccessExpressionContext extends ExpressionContext {
		public TerminalNode DOT() { return getToken(BramsprParser.DOT, 0); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(BramsprParser.IDENTIFIER, i);
		}
		public List<TerminalNode> IDENTIFIER() { return getTokens(BramsprParser.IDENTIFIER); }
		public FieldAccessExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BramsprListener ) ((BramsprListener)listener).enterFieldAccessExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BramsprListener ) ((BramsprListener)listener).exitFieldAccessExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitFieldAccessExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BoolLiteralExpressionContext extends ExpressionContext {
		public TerminalNode BOOL() { return getToken(BramsprParser.BOOL, 0); }
		public BoolLiteralExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BramsprListener ) ((BramsprListener)listener).enterBoolLiteralExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BramsprListener ) ((BramsprListener)listener).exitBoolLiteralExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitBoolLiteralExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState, _p);
		ExpressionContext _prevctx = _localctx;
		int _startState = 32;
		enterRecursionRule(_localctx, RULE_expression);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(297);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				{
				_localctx = new UnaryExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(242);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PLUS) | (1L << MINUS) | (1L << NOT))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(243); expression(26);
				}
				break;

			case 2:
				{
				_localctx = new ParenthesisExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(244); match(LEFT_PARENTHESIS);
				setState(245); expression(0);
				setState(246); match(RIGHT_PARENTHESIS);
				}
				break;

			case 3:
				{
				_localctx = new AssignExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(248); match(LEFT_PARENTHESIS);
				setState(249); assignment();
				setState(250); match(RIGHT_PARENTHESIS);
				}
				break;

			case 4:
				{
				_localctx = new FunctionExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(252); functioncall();
				}
				break;

			case 5:
				{
				_localctx = new EnumExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(253); match(ENUM);
				setState(254); match(DOT);
				setState(255); match(IDENTIFIER);
				setState(256); match(DOT);
				setState(257); match(IDENTIFIER);
				}
				break;

			case 6:
				{
				_localctx = new FieldAccessExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(258); match(IDENTIFIER);
				setState(259); match(DOT);
				setState(260); match(IDENTIFIER);
				}
				break;

			case 7:
				{
				_localctx = new VariableExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(261); match(IDENTIFIER);
				}
				break;

			case 8:
				{
				_localctx = new ArrayLiteralExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(262); match(LEFT_BRACE);
				setState(272);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PLUS) | (1L << MINUS) | (1L << NOT) | (1L << GETINT) | (1L << GETCHAR) | (1L << GETBOOL) | (1L << PUTINT) | (1L << PUTCHAR) | (1L << PUTBOOL) | (1L << ENUM) | (1L << LEFT_PARENTHESIS) | (1L << LEFT_BRACE) | (1L << STRING) | (1L << CHARACTER) | (1L << IDENTIFIER) | (1L << NUMBER) | (1L << BOOL))) != 0)) {
					{
					setState(268);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
					while ( _alt!=2 && _alt!=-1 ) {
						if ( _alt==1 ) {
							{
							{
							setState(263); expression(0);
							setState(264); match(COMMA);
							}
							} 
						}
						setState(270);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
					}
					{
					setState(271); expression(0);
					}
					}
				}

				setState(274); match(RIGHT_BRACE);
				}
				break;

			case 9:
				{
				_localctx = new RecordLiteralExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(275); match(LEFT_BRACE);
				setState(276); match(IDENTIFIER);
				setState(290);
				_la = _input.LA(1);
				if (_la==IDENTIFIER) {
					{
					setState(284);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
					while ( _alt!=2 && _alt!=-1 ) {
						if ( _alt==1 ) {
							{
							{
							setState(277); match(IDENTIFIER);
							setState(278); match(BECOMES);
							setState(279); expression(0);
							setState(280); match(COMMA);
							}
							} 
						}
						setState(286);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
					}
					setState(287); match(IDENTIFIER);
					setState(288); match(BECOMES);
					setState(289); expression(0);
					}
				}

				setState(292); match(RIGHT_BRACE);
				}
				break;

			case 10:
				{
				_localctx = new IntLiteralExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(293); match(NUMBER);
				}
				break;

			case 11:
				{
				_localctx = new BoolLiteralExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(294); match(BOOL);
				}
				break;

			case 12:
				{
				_localctx = new CharLiteralExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(295); match(CHARACTER);
				}
				break;

			case 13:
				{
				_localctx = new StringLiteralExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(296); match(STRING);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(372);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(370);
					switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
					case 1:
						{
						_localctx = new PowerExpressionContext(new ExpressionContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(299);
						if (!(25 >= _localctx._p)) throw new FailedPredicateException(this, "25 >= $_p");
						setState(300); match(POWER);
						setState(301); expression(25);
						}
						break;

					case 2:
						{
						_localctx = new MultiplicationExpressionContext(new ExpressionContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(302);
						if (!(24 >= _localctx._p)) throw new FailedPredicateException(this, "24 >= $_p");
						setState(303);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MULTIPLICATION) | (1L << DIVISION) | (1L << MODULUS))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(304); expression(25);
						}
						break;

					case 3:
						{
						_localctx = new AdditionExpressionContext(new ExpressionContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(305);
						if (!(23 >= _localctx._p)) throw new FailedPredicateException(this, "23 >= $_p");
						setState(306);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(307); expression(24);
						}
						break;

					case 4:
						{
						_localctx = new AndExpressionContext(new ExpressionContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(308);
						if (!(15 >= _localctx._p)) throw new FailedPredicateException(this, "15 >= $_p");
						setState(309); match(AND);
						setState(310); expression(16);
						}
						break;

					case 5:
						{
						_localctx = new OrExpressionContext(new ExpressionContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(311);
						if (!(14 >= _localctx._p)) throw new FailedPredicateException(this, "14 >= $_p");
						setState(312); match(OR);
						setState(313); expression(15);
						}
						break;

					case 6:
						{
						_localctx = new PlusMinusExpressionContext(new ExpressionContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(314);
						if (!(16 >= _localctx._p)) throw new FailedPredicateException(this, "16 >= $_p");
						setState(315); match(EQUALS_TO);
						setState(316); expression(0);
						setState(317); match(PLUSMINUS);
						setState(318); expression(17);
						}
						break;

					case 7:
						{
						_localctx = new SmallerThanExpressionContext(new ExpressionContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(320);
						if (!(22 >= _localctx._p)) throw new FailedPredicateException(this, "22 >= $_p");
						setState(323); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(321); match(SMALLER_THAN);
								setState(322); expression(0);
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(325); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
						} while ( _alt!=2 && _alt!=-1 );
						}
						break;

					case 8:
						{
						_localctx = new SmallerThanEqualsToExpressionContext(new ExpressionContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(327);
						if (!(21 >= _localctx._p)) throw new FailedPredicateException(this, "21 >= $_p");
						setState(330); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(328); match(SMALLER_THAN_EQUALS_TO);
								setState(329); expression(0);
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(332); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
						} while ( _alt!=2 && _alt!=-1 );
						}
						break;

					case 9:
						{
						_localctx = new GreaterThanExpressionContext(new ExpressionContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(334);
						if (!(20 >= _localctx._p)) throw new FailedPredicateException(this, "20 >= $_p");
						setState(337); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(335); match(GREATER_THAN);
								setState(336); expression(0);
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(339); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
						} while ( _alt!=2 && _alt!=-1 );
						}
						break;

					case 10:
						{
						_localctx = new GreaterThanEqualsToExpressionContext(new ExpressionContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(341);
						if (!(19 >= _localctx._p)) throw new FailedPredicateException(this, "19 >= $_p");
						setState(344); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(342); match(GREATER_THAN_EQUALS_TO);
								setState(343); expression(0);
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(346); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
						} while ( _alt!=2 && _alt!=-1 );
						}
						break;

					case 11:
						{
						_localctx = new EqualsToExpressionContext(new ExpressionContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(348);
						if (!(18 >= _localctx._p)) throw new FailedPredicateException(this, "18 >= $_p");
						setState(351); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(349); match(EQUALS_TO);
								setState(350); expression(0);
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(353); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
						} while ( _alt!=2 && _alt!=-1 );
						}
						break;

					case 12:
						{
						_localctx = new NotEqualsToExpressionContext(new ExpressionContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(355);
						if (!(17 >= _localctx._p)) throw new FailedPredicateException(this, "17 >= $_p");
						setState(358); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(356); match(NOT_EQUALS_TO);
								setState(357); expression(0);
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(360); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
						} while ( _alt!=2 && _alt!=-1 );
						}
						break;

					case 13:
						{
						_localctx = new ArrayAccessExpressionContext(new ExpressionContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(362);
						if (!(11 >= _localctx._p)) throw new FailedPredicateException(this, "11 >= $_p");
						{
						setState(363); match(LEFT_BLOCKBRACE);
						setState(364); expression(0);
						setState(365); match(RIGHT_BLOCKBRACE);
						}
						}
						break;

					case 14:
						{
						_localctx = new RecordAccessExpressionContext(new ExpressionContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(367);
						if (!(8 >= _localctx._p)) throw new FailedPredicateException(this, "8 >= $_p");
						setState(368); match(DOT);
						setState(369); match(IDENTIFIER);
						}
						break;
					}
					} 
				}
				setState(374);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 16: return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return 25 >= _localctx._p;

		case 1: return 24 >= _localctx._p;

		case 2: return 23 >= _localctx._p;

		case 3: return 15 >= _localctx._p;

		case 4: return 14 >= _localctx._p;

		case 5: return 16 >= _localctx._p;

		case 6: return 22 >= _localctx._p;

		case 7: return 21 >= _localctx._p;

		case 8: return 20 >= _localctx._p;

		case 9: return 19 >= _localctx._p;

		case 10: return 18 >= _localctx._p;

		case 11: return 17 >= _localctx._p;

		case 12: return 11 >= _localctx._p;

		case 13: return 8 >= _localctx._p;
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\3:\u017a\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\7\3-\n\3\f\3\16\3\60\13\3\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\5\4;\n\4\3\5\3\5\3\5\7\5@\n\5\f\5\16\5C\13\5"+
		"\3\5\3\5\3\5\3\5\5\5I\n\5\3\6\3\6\3\6\7\6N\n\6\f\6\16\6Q\13\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\7\7_\n\7\f\7\16\7b\13\7\3\7\3"+
		"\7\3\b\3\b\3\b\7\bi\n\b\f\b\16\bl\13\b\3\b\3\b\3\b\3\t\3\t\3\t\7\tt\n"+
		"\t\f\t\16\tw\13\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\7\n\u0082\n\n\f"+
		"\n\16\n\u0085\13\n\5\n\u0087\n\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u0090"+
		"\n\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\7\13\u009a\n\13\f\13\16\13"+
		"\u009d\13\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\7"+
		"\f\u00be\n\f\f\f\16\f\u00c1\13\f\5\f\u00c3\n\f\3\f\5\f\u00c6\n\f\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00d3\n\r\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u00df\n\16\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\20\3\20\3\20\6\20\u00ea\n\20\r\20\16\20\u00eb\3\20\3\20\3"+
		"\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3"+
		"\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3"+
		"\22\7\22\u010d\n\22\f\22\16\22\u0110\13\22\3\22\5\22\u0113\n\22\3\22\3"+
		"\22\3\22\3\22\3\22\3\22\3\22\3\22\7\22\u011d\n\22\f\22\16\22\u0120\13"+
		"\22\3\22\3\22\3\22\5\22\u0125\n\22\3\22\3\22\3\22\3\22\3\22\5\22\u012c"+
		"\n\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\6\22\u0146\n\22"+
		"\r\22\16\22\u0147\3\22\3\22\3\22\6\22\u014d\n\22\r\22\16\22\u014e\3\22"+
		"\3\22\3\22\6\22\u0154\n\22\r\22\16\22\u0155\3\22\3\22\3\22\6\22\u015b"+
		"\n\22\r\22\16\22\u015c\3\22\3\22\3\22\6\22\u0162\n\22\r\22\16\22\u0163"+
		"\3\22\3\22\3\22\6\22\u0169\n\22\r\22\16\22\u016a\3\22\3\22\3\22\3\22\3"+
		"\22\3\22\3\22\3\22\7\22\u0175\n\22\f\22\16\22\u0178\13\22\3\22\2\23\2"+
		"\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"\2\5\4\2\5\6\22\22\3\2\7\t\3\2"+
		"\5\6\u01ab\2$\3\2\2\2\4.\3\2\2\2\6:\3\2\2\2\b<\3\2\2\2\nJ\3\2\2\2\fX\3"+
		"\2\2\2\16e\3\2\2\2\20u\3\2\2\2\22z\3\2\2\2\24\u0093\3\2\2\2\26\u00c5\3"+
		"\2\2\2\30\u00d2\3\2\2\2\32\u00d4\3\2\2\2\34\u00e0\3\2\2\2\36\u00e9\3\2"+
		"\2\2 \u00ef\3\2\2\2\"\u012b\3\2\2\2$%\5\4\3\2%\3\3\2\2\2&-\5\6\4\2\'-"+
		"\5\30\r\2()\7+\2\2)*\5\4\3\2*+\7,\2\2+-\3\2\2\2,&\3\2\2\2,\'\3\2\2\2,"+
		"(\3\2\2\2-\60\3\2\2\2.,\3\2\2\2./\3\2\2\2/\5\3\2\2\2\60.\3\2\2\2\61\62"+
		"\5\b\5\2\62\63\7(\2\2\63;\3\2\2\2\64\65\5\n\6\2\65\66\7(\2\2\66;\3\2\2"+
		"\2\67;\5\22\n\28;\5\f\7\29;\5\24\13\2:\61\3\2\2\2:\64\3\2\2\2:\67\3\2"+
		"\2\2:8\3\2\2\2:9\3\2\2\2;\7\3\2\2\2<A\7\63\2\2=>\7/\2\2>@\7\63\2\2?=\3"+
		"\2\2\2@C\3\2\2\2A?\3\2\2\2AB\3\2\2\2BD\3\2\2\2CA\3\2\2\2DE\7\'\2\2EH\5"+
		"\20\t\2FG\7\3\2\2GI\5\"\22\2HF\3\2\2\2HI\3\2\2\2I\t\3\2\2\2JO\7\63\2\2"+
		"KL\7/\2\2LN\7\63\2\2MK\3\2\2\2NQ\3\2\2\2OM\3\2\2\2OP\3\2\2\2PR\3\2\2\2"+
		"QO\3\2\2\2RS\7\'\2\2ST\7&\2\2TU\5\20\t\2UV\7\3\2\2VW\5\"\22\2W\13\3\2"+
		"\2\2XY\7\34\2\2YZ\7\63\2\2Z[\7+\2\2[`\5\16\b\2\\]\7/\2\2]_\5\16\b\2^\\"+
		"\3\2\2\2_b\3\2\2\2`^\3\2\2\2`a\3\2\2\2ac\3\2\2\2b`\3\2\2\2cd\7,\2\2d\r"+
		"\3\2\2\2ej\7\63\2\2fg\7/\2\2gi\7\63\2\2hf\3\2\2\2il\3\2\2\2jh\3\2\2\2"+
		"jk\3\2\2\2km\3\2\2\2lj\3\2\2\2mn\7\'\2\2no\5\20\t\2o\17\3\2\2\2pq\7-\2"+
		"\2qr\7\64\2\2rt\7.\2\2sp\3\2\2\2tw\3\2\2\2us\3\2\2\2uv\3\2\2\2vx\3\2\2"+
		"\2wu\3\2\2\2xy\7\63\2\2y\21\3\2\2\2z{\7\33\2\2{|\5\20\t\2|}\7\63\2\2}"+
		"\u0086\7)\2\2~\u0083\5\b\5\2\177\u0080\7/\2\2\u0080\u0082\5\b\5\2\u0081"+
		"\177\3\2\2\2\u0082\u0085\3\2\2\2\u0083\u0081\3\2\2\2\u0083\u0084\3\2\2"+
		"\2\u0084\u0087\3\2\2\2\u0085\u0083\3\2\2\2\u0086~\3\2\2\2\u0086\u0087"+
		"\3\2\2\2\u0087\u0088\3\2\2\2\u0088\u0089\7*\2\2\u0089\u008a\7+\2\2\u008a"+
		"\u008f\5\4\3\2\u008b\u008c\7%\2\2\u008c\u008d\5\"\22\2\u008d\u008e\7("+
		"\2\2\u008e\u0090\3\2\2\2\u008f\u008b\3\2\2\2\u008f\u0090\3\2\2\2\u0090"+
		"\u0091\3\2\2\2\u0091\u0092\7,\2\2\u0092\23\3\2\2\2\u0093\u0094\7$\2\2"+
		"\u0094\u0095\7\63\2\2\u0095\u0096\7+\2\2\u0096\u009b\7\63\2\2\u0097\u0098"+
		"\7/\2\2\u0098\u009a\7\63\2\2\u0099\u0097\3\2\2\2\u009a\u009d\3\2\2\2\u009b"+
		"\u0099\3\2\2\2\u009b\u009c\3\2\2\2\u009c\u009e\3\2\2\2\u009d\u009b\3\2"+
		"\2\2\u009e\u009f\7,\2\2\u009f\25\3\2\2\2\u00a0\u00a1\7\36\2\2\u00a1\u00a2"+
		"\7)\2\2\u00a2\u00c6\7*\2\2\u00a3\u00a4\7\37\2\2\u00a4\u00a5\7)\2\2\u00a5"+
		"\u00c6\7*\2\2\u00a6\u00a7\7 \2\2\u00a7\u00a8\7)\2\2\u00a8\u00c6\7*\2\2"+
		"\u00a9\u00aa\7!\2\2\u00aa\u00ab\7)\2\2\u00ab\u00ac\5\"\22\2\u00ac\u00ad"+
		"\7*\2\2\u00ad\u00c6\3\2\2\2\u00ae\u00af\7\"\2\2\u00af\u00b0\7)\2\2\u00b0"+
		"\u00b1\5\"\22\2\u00b1\u00b2\7*\2\2\u00b2\u00c6\3\2\2\2\u00b3\u00b4\7#"+
		"\2\2\u00b4\u00b5\7)\2\2\u00b5\u00b6\5\"\22\2\u00b6\u00b7\7*\2\2\u00b7"+
		"\u00c6\3\2\2\2\u00b8\u00b9\7\63\2\2\u00b9\u00c2\7)\2\2\u00ba\u00bf\5\""+
		"\22\2\u00bb\u00bc\7/\2\2\u00bc\u00be\5\"\22\2\u00bd\u00bb\3\2\2\2\u00be"+
		"\u00c1\3\2\2\2\u00bf\u00bd\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0\u00c3\3\2"+
		"\2\2\u00c1\u00bf\3\2\2\2\u00c2\u00ba\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3"+
		"\u00c4\3\2\2\2\u00c4\u00c6\7*\2\2\u00c5\u00a0\3\2\2\2\u00c5\u00a3\3\2"+
		"\2\2\u00c5\u00a6\3\2\2\2\u00c5\u00a9\3\2\2\2\u00c5\u00ae\3\2\2\2\u00c5"+
		"\u00b3\3\2\2\2\u00c5\u00b8\3\2\2\2\u00c6\27\3\2\2\2\u00c7\u00d3\5\32\16"+
		"\2\u00c8\u00d3\5\34\17\2\u00c9\u00ca\5\36\20\2\u00ca\u00cb\7(\2\2\u00cb"+
		"\u00d3\3\2\2\2\u00cc\u00cd\5 \21\2\u00cd\u00ce\7(\2\2\u00ce\u00d3\3\2"+
		"\2\2\u00cf\u00d0\5\"\22\2\u00d0\u00d1\7(\2\2\u00d1\u00d3\3\2\2\2\u00d2"+
		"\u00c7\3\2\2\2\u00d2\u00c8\3\2\2\2\u00d2\u00c9\3\2\2\2\u00d2\u00cc\3\2"+
		"\2\2\u00d2\u00cf\3\2\2\2\u00d3\31\3\2\2\2\u00d4\u00d5\7\27\2\2\u00d5\u00d6"+
		"\5\"\22\2\u00d6\u00d7\7+\2\2\u00d7\u00d8\5\4\3\2\u00d8\u00de\7,\2\2\u00d9"+
		"\u00da\7\31\2\2\u00da\u00db\7+\2\2\u00db\u00dc\5\4\3\2\u00dc\u00dd\7,"+
		"\2\2\u00dd\u00df\3\2\2\2\u00de\u00d9\3\2\2\2\u00de\u00df\3\2\2\2\u00df"+
		"\33\3\2\2\2\u00e0\u00e1\7\32\2\2\u00e1\u00e2\5\"\22\2\u00e2\u00e3\7+\2"+
		"\2\u00e3\u00e4\5\4\3\2\u00e4\u00e5\7,\2\2\u00e5\35\3\2\2\2\u00e6\u00e7"+
		"\5\"\22\2\u00e7\u00e8\7\3\2\2\u00e8\u00ea\3\2\2\2\u00e9\u00e6\3\2\2\2"+
		"\u00ea\u00eb\3\2\2\2\u00eb\u00e9\3\2\2\2\u00eb\u00ec\3\2\2\2\u00ec\u00ed"+
		"\3\2\2\2\u00ed\u00ee\5\"\22\2\u00ee\37\3\2\2\2\u00ef\u00f0\5\"\22\2\u00f0"+
		"\u00f1\7\4\2\2\u00f1\u00f2\5\"\22\2\u00f2!\3\2\2\2\u00f3\u00f4\b\22\1"+
		"\2\u00f4\u00f5\t\2\2\2\u00f5\u012c\5\"\22\2\u00f6\u00f7\7)\2\2\u00f7\u00f8"+
		"\5\"\22\2\u00f8\u00f9\7*\2\2\u00f9\u012c\3\2\2\2\u00fa\u00fb\7)\2\2\u00fb"+
		"\u00fc\5\36\20\2\u00fc\u00fd\7*\2\2\u00fd\u012c\3\2\2\2\u00fe\u012c\5"+
		"\26\f\2\u00ff\u0100\7$\2\2\u0100\u0101\7\60\2\2\u0101\u0102\7\63\2\2\u0102"+
		"\u0103\7\60\2\2\u0103\u012c\7\63\2\2\u0104\u0105\7\63\2\2\u0105\u0106"+
		"\7\60\2\2\u0106\u012c\7\63\2\2\u0107\u012c\7\63\2\2\u0108\u0112\7+\2\2"+
		"\u0109\u010a\5\"\22\2\u010a\u010b\7/\2\2\u010b\u010d\3\2\2\2\u010c\u0109"+
		"\3\2\2\2\u010d\u0110\3\2\2\2\u010e\u010c\3\2\2\2\u010e\u010f\3\2\2\2\u010f"+
		"\u0111\3\2\2\2\u0110\u010e\3\2\2\2\u0111\u0113\5\"\22\2\u0112\u010e\3"+
		"\2\2\2\u0112\u0113\3\2\2\2\u0113\u0114\3\2\2\2\u0114\u012c\7,\2\2\u0115"+
		"\u0116\7+\2\2\u0116\u0124\7\63\2\2\u0117\u0118\7\63\2\2\u0118\u0119\7"+
		"\3\2\2\u0119\u011a\5\"\22\2\u011a\u011b\7/\2\2\u011b\u011d\3\2\2\2\u011c"+
		"\u0117\3\2\2\2\u011d\u0120\3\2\2\2\u011e\u011c\3\2\2\2\u011e\u011f\3\2"+
		"\2\2\u011f\u0121\3\2\2\2\u0120\u011e\3\2\2\2\u0121\u0122\7\63\2\2\u0122"+
		"\u0123\7\3\2\2\u0123\u0125\5\"\22\2\u0124\u011e\3\2\2\2\u0124\u0125\3"+
		"\2\2\2\u0125\u0126\3\2\2\2\u0126\u012c\7,\2\2\u0127\u012c\7\64\2\2\u0128"+
		"\u012c\7\67\2\2\u0129\u012c\7\62\2\2\u012a\u012c\7\61\2\2\u012b\u00f3"+
		"\3\2\2\2\u012b\u00f6\3\2\2\2\u012b\u00fa\3\2\2\2\u012b\u00fe\3\2\2\2\u012b"+
		"\u00ff\3\2\2\2\u012b\u0104\3\2\2\2\u012b\u0107\3\2\2\2\u012b\u0108\3\2"+
		"\2\2\u012b\u0115\3\2\2\2\u012b\u0127\3\2\2\2\u012b\u0128\3\2\2\2\u012b"+
		"\u0129\3\2\2\2\u012b\u012a\3\2\2\2\u012c\u0176\3\2\2\2\u012d\u012e\6\22"+
		"\2\3\u012e\u012f\7\21\2\2\u012f\u0175\5\"\22\2\u0130\u0131\6\22\3\3\u0131"+
		"\u0132\t\3\2\2\u0132\u0175\5\"\22\2\u0133\u0134\6\22\4\3\u0134\u0135\t"+
		"\4\2\2\u0135\u0175\5\"\22\2\u0136\u0137\6\22\5\3\u0137\u0138\7\23\2\2"+
		"\u0138\u0175\5\"\22\2\u0139\u013a\6\22\6\3\u013a\u013b\7\24\2\2\u013b"+
		"\u0175\5\"\22\2\u013c\u013d\6\22\7\3\u013d\u013e\7\16\2\2\u013e\u013f"+
		"\5\"\22\2\u013f\u0140\7\20\2\2\u0140\u0141\5\"\22\2\u0141\u0175\3\2\2"+
		"\2\u0142\u0145\6\22\b\3\u0143\u0144\7\n\2\2\u0144\u0146\5\"\22\2\u0145"+
		"\u0143\3\2\2\2\u0146\u0147\3\2\2\2\u0147\u0145\3\2\2\2\u0147\u0148\3\2"+
		"\2\2\u0148\u0175\3\2\2\2\u0149\u014c\6\22\t\3\u014a\u014b\7\13\2\2\u014b"+
		"\u014d\5\"\22\2\u014c\u014a\3\2\2\2\u014d\u014e\3\2\2\2\u014e\u014c\3"+
		"\2\2\2\u014e\u014f\3\2\2\2\u014f\u0175\3\2\2\2\u0150\u0153\6\22\n\3\u0151"+
		"\u0152\7\f\2\2\u0152\u0154\5\"\22\2\u0153\u0151\3\2\2\2\u0154\u0155\3"+
		"\2\2\2\u0155\u0153\3\2\2\2\u0155\u0156\3\2\2\2\u0156\u0175\3\2\2\2\u0157"+
		"\u015a\6\22\13\3\u0158\u0159\7\r\2\2\u0159\u015b\5\"\22\2\u015a\u0158"+
		"\3\2\2\2\u015b\u015c\3\2\2\2\u015c\u015a\3\2\2\2\u015c\u015d\3\2\2\2\u015d"+
		"\u0175\3\2\2\2\u015e\u0161\6\22\f\3\u015f\u0160\7\16\2\2\u0160\u0162\5"+
		"\"\22\2\u0161\u015f\3\2\2\2\u0162\u0163\3\2\2\2\u0163\u0161\3\2\2\2\u0163"+
		"\u0164\3\2\2\2\u0164\u0175\3\2\2\2\u0165\u0168\6\22\r\3\u0166\u0167\7"+
		"\17\2\2\u0167\u0169\5\"\22\2\u0168\u0166\3\2\2\2\u0169\u016a\3\2\2\2\u016a"+
		"\u0168\3\2\2\2\u016a\u016b\3\2\2\2\u016b\u0175\3\2\2\2\u016c\u016d\6\22"+
		"\16\3\u016d\u016e\7-\2\2\u016e\u016f\5\"\22\2\u016f\u0170\7.\2\2\u0170"+
		"\u0175\3\2\2\2\u0171\u0172\6\22\17\3\u0172\u0173\7\60\2\2\u0173\u0175"+
		"\7\63\2\2\u0174\u012d\3\2\2\2\u0174\u0130\3\2\2\2\u0174\u0133\3\2\2\2"+
		"\u0174\u0136\3\2\2\2\u0174\u0139\3\2\2\2\u0174\u013c\3\2\2\2\u0174\u0142"+
		"\3\2\2\2\u0174\u0149\3\2\2\2\u0174\u0150\3\2\2\2\u0174\u0157\3\2\2\2\u0174"+
		"\u015e\3\2\2\2\u0174\u0165\3\2\2\2\u0174\u016c\3\2\2\2\u0174\u0171\3\2"+
		"\2\2\u0175\u0178\3\2\2\2\u0176\u0174\3\2\2\2\u0176\u0177\3\2\2\2\u0177"+
		"#\3\2\2\2\u0178\u0176\3\2\2\2\",.:AHO`ju\u0083\u0086\u008f\u009b\u00bf"+
		"\u00c2\u00c5\u00d2\u00de\u00eb\u010e\u0112\u011e\u0124\u012b\u0147\u014e"+
		"\u0155\u015c\u0163\u016a\u0174\u0176";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}