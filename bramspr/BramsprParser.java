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
		FUNCTION=25, LOGIC=20, WHILE=24, NOT=16, AND=17, CHARACTER=42, IF=21, 
		TYPE=26, THEN=22, SMALLER_THAN=8, RIGHT_PARENTHESIS=35, COMMA=40, LEFT_PARENTHESIS=34, 
		IDENTIFIER=43, DIVISION=6, BLOCKCOMMENT=49, PLUS=3, GREATER_THAN_EQUALS_TO=11, 
		COMMENT=48, RIGHT_BRACE=37, XOR=19, GETBOOL=30, GREATER_THAN=10, GETCHAR=29, 
		SWAP=2, ELSE=23, PLUSMINUS=14, NUMBER=44, BOOL=47, BECOMES=1, WHITESPACE=50, 
		POWER=15, SEMICOLON=33, MINUS=4, TRUE=45, PRINT=27, EQUALS_TO=12, GETINT=28, 
		LEFT_BLOCKBRACE=38, RIGHT_BLOCKBRACE=39, COLON=32, ENUM=31, MODULUS=7, 
		LEFT_BRACE=36, OR=18, MULTIPLICATION=5, NOT_EQUALS_TO=13, FALSE=46, SMALLER_THAN_EQUALS_TO=9, 
		STRING=41;
	public static final String[] tokenNames = {
		"<INVALID>", "':='", "'<>'", "'+'", "'-'", "'*'", "'/'", "'%'", "SMALLER_THAN", 
		"'<='", "GREATER_THAN", "'>='", "'='", "'=/='", "'+-'", "'^'", "'!'", 
		"'&'", "'|'", "'!&'", "LOGIC", "'if'", "'then'", "'else'", "'while'", 
		"'function'", "'type'", "'print'", "'getint'", "'getchar'", "'getbool'", 
		"'enum'", "':'", "';'", "'('", "')'", "'{'", "'}'", "'['", "']'", "','", 
		"STRING", "CHARACTER", "IDENTIFIER", "NUMBER", "'true'", "'false'", "BOOL", 
		"COMMENT", "BLOCKCOMMENT", "WHITESPACE"
	};
	public static final int
		RULE_program = 0, RULE_declaration = 1, RULE_variabledeclaration = 2, 
		RULE_typedeclaration = 3, RULE_primitiveType = 4, RULE_functiondeclaration = 5, 
		RULE_enumdeclaration = 6, RULE_functioncall = 7, RULE_statement = 8, RULE_ifstatement = 9, 
		RULE_whilestatement = 10, RULE_printstatement = 11, RULE_assignment = 12, 
		RULE_expression = 13;
	public static final String[] ruleNames = {
		"program", "declaration", "variabledeclaration", "typedeclaration", "primitiveType", 
		"functiondeclaration", "enumdeclaration", "functioncall", "statement", 
		"ifstatement", "whilestatement", "printstatement", "assignment", "expression"
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
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(32);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PLUS) | (1L << MINUS) | (1L << NOT) | (1L << IF) | (1L << WHILE) | (1L << FUNCTION) | (1L << TYPE) | (1L << PRINT) | (1L << GETINT) | (1L << GETCHAR) | (1L << GETBOOL) | (1L << ENUM) | (1L << LEFT_PARENTHESIS) | (1L << STRING) | (1L << CHARACTER) | (1L << IDENTIFIER) | (1L << NUMBER) | (1L << BOOL))) != 0)) {
				{
				setState(30);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(28); declaration();
					}
					break;

				case 2:
					{
					setState(29); statement();
					}
					break;
				}
				}
				setState(34);
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
		enterRule(_localctx, 2, RULE_declaration);
		try {
			setState(41);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(35); variabledeclaration();
				setState(36); match(SEMICOLON);
				}
				break;
			case FUNCTION:
				enterOuterAlt(_localctx, 2);
				{
				setState(38); functiondeclaration();
				}
				break;
			case TYPE:
				enterOuterAlt(_localctx, 3);
				{
				setState(39); typedeclaration();
				}
				break;
			case ENUM:
				enterOuterAlt(_localctx, 4);
				{
				setState(40); enumdeclaration();
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

	public static class VariabledeclarationContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER(int i) {
			return getToken(BramsprParser.IDENTIFIER, i);
		}
		public List<TerminalNode> IDENTIFIER() { return getTokens(BramsprParser.IDENTIFIER); }
		public List<TerminalNode> COMMA() { return getTokens(BramsprParser.COMMA); }
		public PrimitiveTypeContext primitiveType() {
			return getRuleContext(PrimitiveTypeContext.class,0);
		}
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
		enterRule(_localctx, 4, RULE_variabledeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(43); match(IDENTIFIER);
			setState(48);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(44); match(COMMA);
				setState(45); match(IDENTIFIER);
				}
				}
				setState(50);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(51); match(COLON);
			setState(52); primitiveType();
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
		public VariabledeclarationContext variabledeclaration(int i) {
			return getRuleContext(VariabledeclarationContext.class,i);
		}
		public TerminalNode IDENTIFIER() { return getToken(BramsprParser.IDENTIFIER, 0); }
		public List<TerminalNode> COMMA() { return getTokens(BramsprParser.COMMA); }
		public List<VariabledeclarationContext> variabledeclaration() {
			return getRuleContexts(VariabledeclarationContext.class);
		}
		public TerminalNode LEFT_BRACE() { return getToken(BramsprParser.LEFT_BRACE, 0); }
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
		enterRule(_localctx, 6, RULE_typedeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(54); match(TYPE);
			setState(55); match(IDENTIFIER);
			setState(56); match(LEFT_BRACE);
			setState(57); variabledeclaration();
			setState(62);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(58); match(COMMA);
				setState(59); variabledeclaration();
				}
				}
				setState(64);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(65); match(RIGHT_BRACE);
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

	public static class PrimitiveTypeContext extends ParserRuleContext {
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
		public PrimitiveTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primitiveType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BramsprListener ) ((BramsprListener)listener).enterPrimitiveType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BramsprListener ) ((BramsprListener)listener).exitPrimitiveType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitPrimitiveType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimitiveTypeContext primitiveType() throws RecognitionException {
		PrimitiveTypeContext _localctx = new PrimitiveTypeContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_primitiveType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(72);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LEFT_BLOCKBRACE) {
				{
				{
				setState(67); match(LEFT_BLOCKBRACE);
				setState(68); match(NUMBER);
				setState(69); match(RIGHT_BLOCKBRACE);
				}
				}
				setState(74);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(75); match(IDENTIFIER);
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
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public VariabledeclarationContext variabledeclaration(int i) {
			return getRuleContext(VariabledeclarationContext.class,i);
		}
		public TerminalNode RIGHT_BRACE() { return getToken(BramsprParser.RIGHT_BRACE, 0); }
		public TerminalNode LEFT_PARENTHESIS() { return getToken(BramsprParser.LEFT_PARENTHESIS, 0); }
		public TerminalNode IDENTIFIER() { return getToken(BramsprParser.IDENTIFIER, 0); }
		public List<TerminalNode> COMMA() { return getTokens(BramsprParser.COMMA); }
		public TerminalNode RIGHT_PARENTHESIS() { return getToken(BramsprParser.RIGHT_PARENTHESIS, 0); }
		public TerminalNode FUNCTION() { return getToken(BramsprParser.FUNCTION, 0); }
		public List<VariabledeclarationContext> variabledeclaration() {
			return getRuleContexts(VariabledeclarationContext.class);
		}
		public TerminalNode LEFT_BRACE() { return getToken(BramsprParser.LEFT_BRACE, 0); }
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode COMMA(int i) {
			return getToken(BramsprParser.COMMA, i);
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
		enterRule(_localctx, 10, RULE_functiondeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77); match(FUNCTION);
			setState(78); match(IDENTIFIER);
			setState(79); match(LEFT_PARENTHESIS);
			setState(88);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(80); variabledeclaration();
				setState(85);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(81); match(COMMA);
					setState(82); variabledeclaration();
					}
					}
					setState(87);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(90); match(RIGHT_PARENTHESIS);
			setState(91); match(LEFT_BRACE);
			setState(96);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PLUS) | (1L << MINUS) | (1L << NOT) | (1L << IF) | (1L << WHILE) | (1L << PRINT) | (1L << GETINT) | (1L << GETCHAR) | (1L << GETBOOL) | (1L << LEFT_PARENTHESIS) | (1L << STRING) | (1L << CHARACTER) | (1L << IDENTIFIER) | (1L << NUMBER) | (1L << BOOL))) != 0)) {
				{
				setState(94);
				switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
				case 1:
					{
					setState(92); variabledeclaration();
					}
					break;

				case 2:
					{
					setState(93); statement();
					}
					break;
				}
				}
				setState(98);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(99); match(RIGHT_BRACE);
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
		enterRule(_localctx, 12, RULE_enumdeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(101); match(ENUM);
			setState(102); match(IDENTIFIER);
			setState(103); match(LEFT_BRACE);
			setState(104); match(IDENTIFIER);
			setState(109);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(105); match(COMMA);
				setState(106); match(IDENTIFIER);
				}
				}
				setState(111);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(112); match(RIGHT_BRACE);
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
		enterRule(_localctx, 14, RULE_functioncall);
		int _la;
		try {
			setState(136);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				_localctx = new FunctionCallExpressionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(114); match(IDENTIFIER);
				setState(115); match(LEFT_PARENTHESIS);
				setState(124);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PLUS) | (1L << MINUS) | (1L << NOT) | (1L << GETINT) | (1L << GETCHAR) | (1L << GETBOOL) | (1L << LEFT_PARENTHESIS) | (1L << STRING) | (1L << CHARACTER) | (1L << IDENTIFIER) | (1L << NUMBER) | (1L << BOOL))) != 0)) {
					{
					setState(116); expression(0);
					setState(121);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(117); match(COMMA);
						setState(118); expression(0);
						}
						}
						setState(123);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(126); match(RIGHT_PARENTHESIS);
				}
				break;
			case GETINT:
				_localctx = new GetIntExpressionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(127); match(GETINT);
				setState(128); match(LEFT_PARENTHESIS);
				setState(129); match(RIGHT_PARENTHESIS);
				}
				break;
			case GETCHAR:
				_localctx = new GetCharExpressionContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(130); match(GETCHAR);
				setState(131); match(LEFT_PARENTHESIS);
				setState(132); match(RIGHT_PARENTHESIS);
				}
				break;
			case GETBOOL:
				_localctx = new GetBoolExpressionContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(133); match(GETBOOL);
				setState(134); match(LEFT_PARENTHESIS);
				setState(135); match(RIGHT_PARENTHESIS);
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
		public IfstatementContext ifstatement() {
			return getRuleContext(IfstatementContext.class,0);
		}
		public WhilestatementContext whilestatement() {
			return getRuleContext(WhilestatementContext.class,0);
		}
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public PrintstatementContext printstatement() {
			return getRuleContext(PrintstatementContext.class,0);
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
		enterRule(_localctx, 16, RULE_statement);
		try {
			setState(149);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(138); ifstatement();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(139); whilestatement();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(140); assignment();
				setState(141); match(SEMICOLON);
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(143); expression(0);
				setState(144); match(SEMICOLON);
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(146); printstatement();
				setState(147); match(SEMICOLON);
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
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public TerminalNode IF() { return getToken(BramsprParser.IF, 0); }
		public List<TerminalNode> RIGHT_BRACE() { return getTokens(BramsprParser.RIGHT_BRACE); }
		public TerminalNode LEFT_BRACE(int i) {
			return getToken(BramsprParser.LEFT_BRACE, i);
		}
		public TerminalNode ELSE() { return getToken(BramsprParser.ELSE, 0); }
		public TerminalNode RIGHT_BRACE(int i) {
			return getToken(BramsprParser.RIGHT_BRACE, i);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<TerminalNode> LEFT_BRACE() { return getTokens(BramsprParser.LEFT_BRACE); }
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
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
		enterRule(_localctx, 18, RULE_ifstatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(151); match(IF);
			setState(152); expression(0);
			setState(153); match(LEFT_BRACE);
			setState(157);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PLUS) | (1L << MINUS) | (1L << NOT) | (1L << IF) | (1L << WHILE) | (1L << PRINT) | (1L << GETINT) | (1L << GETCHAR) | (1L << GETBOOL) | (1L << LEFT_PARENTHESIS) | (1L << STRING) | (1L << CHARACTER) | (1L << IDENTIFIER) | (1L << NUMBER) | (1L << BOOL))) != 0)) {
				{
				{
				setState(154); statement();
				}
				}
				setState(159);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(160); match(RIGHT_BRACE);
			setState(170);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(161); match(ELSE);
				setState(162); match(LEFT_BRACE);
				setState(166);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PLUS) | (1L << MINUS) | (1L << NOT) | (1L << IF) | (1L << WHILE) | (1L << PRINT) | (1L << GETINT) | (1L << GETCHAR) | (1L << GETBOOL) | (1L << LEFT_PARENTHESIS) | (1L << STRING) | (1L << CHARACTER) | (1L << IDENTIFIER) | (1L << NUMBER) | (1L << BOOL))) != 0)) {
					{
					{
					setState(163); statement();
					}
					}
					setState(168);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(169); match(RIGHT_BRACE);
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
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public TerminalNode WHILE() { return getToken(BramsprParser.WHILE, 0); }
		public TerminalNode RIGHT_BRACE() { return getToken(BramsprParser.RIGHT_BRACE, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode LEFT_BRACE() { return getToken(BramsprParser.LEFT_BRACE, 0); }
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
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
		enterRule(_localctx, 20, RULE_whilestatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(172); match(WHILE);
			setState(173); expression(0);
			setState(174); match(LEFT_BRACE);
			setState(178);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PLUS) | (1L << MINUS) | (1L << NOT) | (1L << IF) | (1L << WHILE) | (1L << PRINT) | (1L << GETINT) | (1L << GETCHAR) | (1L << GETBOOL) | (1L << LEFT_PARENTHESIS) | (1L << STRING) | (1L << CHARACTER) | (1L << IDENTIFIER) | (1L << NUMBER) | (1L << BOOL))) != 0)) {
				{
				{
				setState(175); statement();
				}
				}
				setState(180);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(181); match(RIGHT_BRACE);
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

	public static class PrintstatementContext extends ParserRuleContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode PRINT() { return getToken(BramsprParser.PRINT, 0); }
		public TerminalNode LEFT_PARENTHESIS() { return getToken(BramsprParser.LEFT_PARENTHESIS, 0); }
		public List<TerminalNode> COMMA() { return getTokens(BramsprParser.COMMA); }
		public TerminalNode RIGHT_PARENTHESIS() { return getToken(BramsprParser.RIGHT_PARENTHESIS, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public TerminalNode COMMA(int i) {
			return getToken(BramsprParser.COMMA, i);
		}
		public PrintstatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_printstatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BramsprListener ) ((BramsprListener)listener).enterPrintstatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BramsprListener ) ((BramsprListener)listener).exitPrintstatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitPrintstatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrintstatementContext printstatement() throws RecognitionException {
		PrintstatementContext _localctx = new PrintstatementContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_printstatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(183); match(PRINT);
			setState(184); match(LEFT_PARENTHESIS);
			setState(185); expression(0);
			setState(190);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(186); match(COMMA);
				setState(187); expression(0);
				}
				}
				setState(192);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(193); match(RIGHT_PARENTHESIS);
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
		public TerminalNode IDENTIFIER(int i) {
			return getToken(BramsprParser.IDENTIFIER, i);
		}
		public List<TerminalNode> IDENTIFIER() { return getTokens(BramsprParser.IDENTIFIER); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
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
		enterRule(_localctx, 24, RULE_assignment);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(197); 
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(195); match(IDENTIFIER);
					setState(196); match(BECOMES);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(199); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			} while ( _alt!=2 && _alt!=-1 );
			setState(201); expression(0);
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
	public static class AssignExpressionContext extends ExpressionContext {
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
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
		int _startState = 26;
		enterRecursionRule(_localctx, RULE_expression);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(217);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				{
				_localctx = new UnaryExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(204);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PLUS) | (1L << MINUS) | (1L << NOT))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(205); expression(20);
				}
				break;

			case 2:
				{
				_localctx = new ParenthesisExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(206); match(LEFT_PARENTHESIS);
				setState(207); expression(0);
				setState(208); match(RIGHT_PARENTHESIS);
				}
				break;

			case 3:
				{
				_localctx = new AssignExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(210); assignment();
				}
				break;

			case 4:
				{
				_localctx = new FunctionExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(211); functioncall();
				}
				break;

			case 5:
				{
				_localctx = new VariableExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(212); match(IDENTIFIER);
				}
				break;

			case 6:
				{
				_localctx = new IntLiteralExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(213); match(NUMBER);
				}
				break;

			case 7:
				{
				_localctx = new BoolLiteralExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(214); match(BOOL);
				}
				break;

			case 8:
				{
				_localctx = new CharLiteralExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(215); match(CHARACTER);
				}
				break;

			case 9:
				{
				_localctx = new StringLiteralExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(216); match(STRING);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(284);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(282);
					switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
					case 1:
						{
						_localctx = new PowerExpressionContext(new ExpressionContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(219);
						if (!(19 >= _localctx._p)) throw new FailedPredicateException(this, "19 >= $_p");
						setState(220); match(POWER);
						setState(221); expression(19);
						}
						break;

					case 2:
						{
						_localctx = new MultiplicationExpressionContext(new ExpressionContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(222);
						if (!(18 >= _localctx._p)) throw new FailedPredicateException(this, "18 >= $_p");
						setState(223);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MULTIPLICATION) | (1L << DIVISION) | (1L << MODULUS))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(224); expression(19);
						}
						break;

					case 3:
						{
						_localctx = new AdditionExpressionContext(new ExpressionContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(225);
						if (!(17 >= _localctx._p)) throw new FailedPredicateException(this, "17 >= $_p");
						setState(226);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(227); expression(18);
						}
						break;

					case 4:
						{
						_localctx = new AndExpressionContext(new ExpressionContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(228);
						if (!(9 >= _localctx._p)) throw new FailedPredicateException(this, "9 >= $_p");
						setState(229); match(AND);
						setState(230); expression(10);
						}
						break;

					case 5:
						{
						_localctx = new OrExpressionContext(new ExpressionContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(231);
						if (!(8 >= _localctx._p)) throw new FailedPredicateException(this, "8 >= $_p");
						setState(232); match(OR);
						setState(233); expression(9);
						}
						break;

					case 6:
						{
						_localctx = new PlusMinusExpressionContext(new ExpressionContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(234);
						if (!(10 >= _localctx._p)) throw new FailedPredicateException(this, "10 >= $_p");
						setState(235); match(EQUALS_TO);
						setState(236); expression(0);
						setState(237); match(PLUSMINUS);
						setState(238); expression(11);
						}
						break;

					case 7:
						{
						_localctx = new SmallerThanExpressionContext(new ExpressionContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(240);
						if (!(16 >= _localctx._p)) throw new FailedPredicateException(this, "16 >= $_p");
						setState(243); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(241); match(SMALLER_THAN);
								setState(242); expression(0);
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(245); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
						} while ( _alt!=2 && _alt!=-1 );
						}
						break;

					case 8:
						{
						_localctx = new SmallerThanEqualsToExpressionContext(new ExpressionContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(247);
						if (!(15 >= _localctx._p)) throw new FailedPredicateException(this, "15 >= $_p");
						setState(250); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(248); match(SMALLER_THAN_EQUALS_TO);
								setState(249); expression(0);
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(252); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
						} while ( _alt!=2 && _alt!=-1 );
						}
						break;

					case 9:
						{
						_localctx = new GreaterThanExpressionContext(new ExpressionContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(254);
						if (!(14 >= _localctx._p)) throw new FailedPredicateException(this, "14 >= $_p");
						setState(257); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(255); match(GREATER_THAN);
								setState(256); expression(0);
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(259); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
						} while ( _alt!=2 && _alt!=-1 );
						}
						break;

					case 10:
						{
						_localctx = new GreaterThanEqualsToExpressionContext(new ExpressionContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(261);
						if (!(13 >= _localctx._p)) throw new FailedPredicateException(this, "13 >= $_p");
						setState(264); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(262); match(GREATER_THAN_EQUALS_TO);
								setState(263); expression(0);
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(266); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
						} while ( _alt!=2 && _alt!=-1 );
						}
						break;

					case 11:
						{
						_localctx = new EqualsToExpressionContext(new ExpressionContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(268);
						if (!(12 >= _localctx._p)) throw new FailedPredicateException(this, "12 >= $_p");
						setState(271); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(269); match(EQUALS_TO);
								setState(270); expression(0);
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(273); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
						} while ( _alt!=2 && _alt!=-1 );
						}
						break;

					case 12:
						{
						_localctx = new NotEqualsToExpressionContext(new ExpressionContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(275);
						if (!(11 >= _localctx._p)) throw new FailedPredicateException(this, "11 >= $_p");
						setState(278); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(276); match(NOT_EQUALS_TO);
								setState(277); expression(0);
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(280); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
						} while ( _alt!=2 && _alt!=-1 );
						}
						break;
					}
					} 
				}
				setState(286);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
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
		case 13: return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return 19 >= _localctx._p;

		case 1: return 18 >= _localctx._p;

		case 2: return 17 >= _localctx._p;

		case 3: return 9 >= _localctx._p;

		case 4: return 8 >= _localctx._p;

		case 5: return 10 >= _localctx._p;

		case 6: return 16 >= _localctx._p;

		case 7: return 15 >= _localctx._p;

		case 8: return 14 >= _localctx._p;

		case 9: return 13 >= _localctx._p;

		case 10: return 12 >= _localctx._p;

		case 11: return 11 >= _localctx._p;
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\3\64\u0122\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\3\2\7\2!\n\2\f\2\16\2$\13"+
		"\2\3\3\3\3\3\3\3\3\3\3\3\3\5\3,\n\3\3\4\3\4\3\4\7\4\61\n\4\f\4\16\4\64"+
		"\13\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\7\5?\n\5\f\5\16\5B\13\5\3\5"+
		"\3\5\3\6\3\6\3\6\7\6I\n\6\f\6\16\6L\13\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\7\7V\n\7\f\7\16\7Y\13\7\5\7[\n\7\3\7\3\7\3\7\3\7\7\7a\n\7\f\7\16\7"+
		"d\13\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\7\bn\n\b\f\b\16\bq\13\b\3\b\3\b"+
		"\3\t\3\t\3\t\3\t\3\t\7\tz\n\t\f\t\16\t}\13\t\5\t\177\n\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u008b\n\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\5\n\u0098\n\n\3\13\3\13\3\13\3\13\7\13\u009e\n\13\f\13"+
		"\16\13\u00a1\13\13\3\13\3\13\3\13\3\13\7\13\u00a7\n\13\f\13\16\13\u00aa"+
		"\13\13\3\13\5\13\u00ad\n\13\3\f\3\f\3\f\3\f\7\f\u00b3\n\f\f\f\16\f\u00b6"+
		"\13\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\7\r\u00bf\n\r\f\r\16\r\u00c2\13\r\3"+
		"\r\3\r\3\16\3\16\6\16\u00c8\n\16\r\16\16\16\u00c9\3\16\3\16\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u00dc"+
		"\n\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\6\17\u00f6\n\17"+
		"\r\17\16\17\u00f7\3\17\3\17\3\17\6\17\u00fd\n\17\r\17\16\17\u00fe\3\17"+
		"\3\17\3\17\6\17\u0104\n\17\r\17\16\17\u0105\3\17\3\17\3\17\6\17\u010b"+
		"\n\17\r\17\16\17\u010c\3\17\3\17\3\17\6\17\u0112\n\17\r\17\16\17\u0113"+
		"\3\17\3\17\3\17\6\17\u0119\n\17\r\17\16\17\u011a\7\17\u011d\n\17\f\17"+
		"\16\17\u0120\13\17\3\17\2\20\2\4\6\b\n\f\16\20\22\24\26\30\32\34\2\5\4"+
		"\2\5\6\22\22\3\2\7\t\3\2\5\6\u0149\2\"\3\2\2\2\4+\3\2\2\2\6-\3\2\2\2\b"+
		"8\3\2\2\2\nJ\3\2\2\2\fO\3\2\2\2\16g\3\2\2\2\20\u008a\3\2\2\2\22\u0097"+
		"\3\2\2\2\24\u0099\3\2\2\2\26\u00ae\3\2\2\2\30\u00b9\3\2\2\2\32\u00c7\3"+
		"\2\2\2\34\u00db\3\2\2\2\36!\5\4\3\2\37!\5\22\n\2 \36\3\2\2\2 \37\3\2\2"+
		"\2!$\3\2\2\2\" \3\2\2\2\"#\3\2\2\2#\3\3\2\2\2$\"\3\2\2\2%&\5\6\4\2&\'"+
		"\7#\2\2\',\3\2\2\2(,\5\f\7\2),\5\b\5\2*,\5\16\b\2+%\3\2\2\2+(\3\2\2\2"+
		"+)\3\2\2\2+*\3\2\2\2,\5\3\2\2\2-\62\7-\2\2./\7*\2\2/\61\7-\2\2\60.\3\2"+
		"\2\2\61\64\3\2\2\2\62\60\3\2\2\2\62\63\3\2\2\2\63\65\3\2\2\2\64\62\3\2"+
		"\2\2\65\66\7\"\2\2\66\67\5\n\6\2\67\7\3\2\2\289\7\34\2\29:\7-\2\2:;\7"+
		"&\2\2;@\5\6\4\2<=\7*\2\2=?\5\6\4\2><\3\2\2\2?B\3\2\2\2@>\3\2\2\2@A\3\2"+
		"\2\2AC\3\2\2\2B@\3\2\2\2CD\7\'\2\2D\t\3\2\2\2EF\7(\2\2FG\7.\2\2GI\7)\2"+
		"\2HE\3\2\2\2IL\3\2\2\2JH\3\2\2\2JK\3\2\2\2KM\3\2\2\2LJ\3\2\2\2MN\7-\2"+
		"\2N\13\3\2\2\2OP\7\33\2\2PQ\7-\2\2QZ\7$\2\2RW\5\6\4\2ST\7*\2\2TV\5\6\4"+
		"\2US\3\2\2\2VY\3\2\2\2WU\3\2\2\2WX\3\2\2\2X[\3\2\2\2YW\3\2\2\2ZR\3\2\2"+
		"\2Z[\3\2\2\2[\\\3\2\2\2\\]\7%\2\2]b\7&\2\2^a\5\6\4\2_a\5\22\n\2`^\3\2"+
		"\2\2`_\3\2\2\2ad\3\2\2\2b`\3\2\2\2bc\3\2\2\2ce\3\2\2\2db\3\2\2\2ef\7\'"+
		"\2\2f\r\3\2\2\2gh\7!\2\2hi\7-\2\2ij\7&\2\2jo\7-\2\2kl\7*\2\2ln\7-\2\2"+
		"mk\3\2\2\2nq\3\2\2\2om\3\2\2\2op\3\2\2\2pr\3\2\2\2qo\3\2\2\2rs\7\'\2\2"+
		"s\17\3\2\2\2tu\7-\2\2u~\7$\2\2v{\5\34\17\2wx\7*\2\2xz\5\34\17\2yw\3\2"+
		"\2\2z}\3\2\2\2{y\3\2\2\2{|\3\2\2\2|\177\3\2\2\2}{\3\2\2\2~v\3\2\2\2~\177"+
		"\3\2\2\2\177\u0080\3\2\2\2\u0080\u008b\7%\2\2\u0081\u0082\7\36\2\2\u0082"+
		"\u0083\7$\2\2\u0083\u008b\7%\2\2\u0084\u0085\7\37\2\2\u0085\u0086\7$\2"+
		"\2\u0086\u008b\7%\2\2\u0087\u0088\7 \2\2\u0088\u0089\7$\2\2\u0089\u008b"+
		"\7%\2\2\u008at\3\2\2\2\u008a\u0081\3\2\2\2\u008a\u0084\3\2\2\2\u008a\u0087"+
		"\3\2\2\2\u008b\21\3\2\2\2\u008c\u0098\5\24\13\2\u008d\u0098\5\26\f\2\u008e"+
		"\u008f\5\32\16\2\u008f\u0090\7#\2\2\u0090\u0098\3\2\2\2\u0091\u0092\5"+
		"\34\17\2\u0092\u0093\7#\2\2\u0093\u0098\3\2\2\2\u0094\u0095\5\30\r\2\u0095"+
		"\u0096\7#\2\2\u0096\u0098\3\2\2\2\u0097\u008c\3\2\2\2\u0097\u008d\3\2"+
		"\2\2\u0097\u008e\3\2\2\2\u0097\u0091\3\2\2\2\u0097\u0094\3\2\2\2\u0098"+
		"\23\3\2\2\2\u0099\u009a\7\27\2\2\u009a\u009b\5\34\17\2\u009b\u009f\7&"+
		"\2\2\u009c\u009e\5\22\n\2\u009d\u009c\3\2\2\2\u009e\u00a1\3\2\2\2\u009f"+
		"\u009d\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\u00a2\3\2\2\2\u00a1\u009f\3\2"+
		"\2\2\u00a2\u00ac\7\'\2\2\u00a3\u00a4\7\31\2\2\u00a4\u00a8\7&\2\2\u00a5"+
		"\u00a7\5\22\n\2\u00a6\u00a5\3\2\2\2\u00a7\u00aa\3\2\2\2\u00a8\u00a6\3"+
		"\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\u00ab\3\2\2\2\u00aa\u00a8\3\2\2\2\u00ab"+
		"\u00ad\7\'\2\2\u00ac\u00a3\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\25\3\2\2"+
		"\2\u00ae\u00af\7\32\2\2\u00af\u00b0\5\34\17\2\u00b0\u00b4\7&\2\2\u00b1"+
		"\u00b3\5\22\n\2\u00b2\u00b1\3\2\2\2\u00b3\u00b6\3\2\2\2\u00b4\u00b2\3"+
		"\2\2\2\u00b4\u00b5\3\2\2\2\u00b5\u00b7\3\2\2\2\u00b6\u00b4\3\2\2\2\u00b7"+
		"\u00b8\7\'\2\2\u00b8\27\3\2\2\2\u00b9\u00ba\7\35\2\2\u00ba\u00bb\7$\2"+
		"\2\u00bb\u00c0\5\34\17\2\u00bc\u00bd\7*\2\2\u00bd\u00bf\5\34\17\2\u00be"+
		"\u00bc\3\2\2\2\u00bf\u00c2\3\2\2\2\u00c0\u00be\3\2\2\2\u00c0\u00c1\3\2"+
		"\2\2\u00c1\u00c3\3\2\2\2\u00c2\u00c0\3\2\2\2\u00c3\u00c4\7%\2\2\u00c4"+
		"\31\3\2\2\2\u00c5\u00c6\7-\2\2\u00c6\u00c8\7\3\2\2\u00c7\u00c5\3\2\2\2"+
		"\u00c8\u00c9\3\2\2\2\u00c9\u00c7\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca\u00cb"+
		"\3\2\2\2\u00cb\u00cc\5\34\17\2\u00cc\33\3\2\2\2\u00cd\u00ce\b\17\1\2\u00ce"+
		"\u00cf\t\2\2\2\u00cf\u00dc\5\34\17\2\u00d0\u00d1\7$\2\2\u00d1\u00d2\5"+
		"\34\17\2\u00d2\u00d3\7%\2\2\u00d3\u00dc\3\2\2\2\u00d4\u00dc\5\32\16\2"+
		"\u00d5\u00dc\5\20\t\2\u00d6\u00dc\7-\2\2\u00d7\u00dc\7.\2\2\u00d8\u00dc"+
		"\7\61\2\2\u00d9\u00dc\7,\2\2\u00da\u00dc\7+\2\2\u00db\u00cd\3\2\2\2\u00db"+
		"\u00d0\3\2\2\2\u00db\u00d4\3\2\2\2\u00db\u00d5\3\2\2\2\u00db\u00d6\3\2"+
		"\2\2\u00db\u00d7\3\2\2\2\u00db\u00d8\3\2\2\2\u00db\u00d9\3\2\2\2\u00db"+
		"\u00da\3\2\2\2\u00dc\u011e\3\2\2\2\u00dd\u00de\6\17\2\3\u00de\u00df\7"+
		"\21\2\2\u00df\u011d\5\34\17\2\u00e0\u00e1\6\17\3\3\u00e1\u00e2\t\3\2\2"+
		"\u00e2\u011d\5\34\17\2\u00e3\u00e4\6\17\4\3\u00e4\u00e5\t\4\2\2\u00e5"+
		"\u011d\5\34\17\2\u00e6\u00e7\6\17\5\3\u00e7\u00e8\7\23\2\2\u00e8\u011d"+
		"\5\34\17\2\u00e9\u00ea\6\17\6\3\u00ea\u00eb\7\24\2\2\u00eb\u011d\5\34"+
		"\17\2\u00ec\u00ed\6\17\7\3\u00ed\u00ee\7\16\2\2\u00ee\u00ef\5\34\17\2"+
		"\u00ef\u00f0\7\20\2\2\u00f0\u00f1\5\34\17\2\u00f1\u011d\3\2\2\2\u00f2"+
		"\u00f5\6\17\b\3\u00f3\u00f4\7\n\2\2\u00f4\u00f6\5\34\17\2\u00f5\u00f3"+
		"\3\2\2\2\u00f6\u00f7\3\2\2\2\u00f7\u00f5\3\2\2\2\u00f7\u00f8\3\2\2\2\u00f8"+
		"\u011d\3\2\2\2\u00f9\u00fc\6\17\t\3\u00fa\u00fb\7\13\2\2\u00fb\u00fd\5"+
		"\34\17\2\u00fc\u00fa\3\2\2\2\u00fd\u00fe\3\2\2\2\u00fe\u00fc\3\2\2\2\u00fe"+
		"\u00ff\3\2\2\2\u00ff\u011d\3\2\2\2\u0100\u0103\6\17\n\3\u0101\u0102\7"+
		"\f\2\2\u0102\u0104\5\34\17\2\u0103\u0101\3\2\2\2\u0104\u0105\3\2\2\2\u0105"+
		"\u0103\3\2\2\2\u0105\u0106\3\2\2\2\u0106\u011d\3\2\2\2\u0107\u010a\6\17"+
		"\13\3\u0108\u0109\7\r\2\2\u0109\u010b\5\34\17\2\u010a\u0108\3\2\2\2\u010b"+
		"\u010c\3\2\2\2\u010c\u010a\3\2\2\2\u010c\u010d\3\2\2\2\u010d\u011d\3\2"+
		"\2\2\u010e\u0111\6\17\f\3\u010f\u0110\7\16\2\2\u0110\u0112\5\34\17\2\u0111"+
		"\u010f\3\2\2\2\u0112\u0113\3\2\2\2\u0113\u0111\3\2\2\2\u0113\u0114\3\2"+
		"\2\2\u0114\u011d\3\2\2\2\u0115\u0118\6\17\r\3\u0116\u0117\7\17\2\2\u0117"+
		"\u0119\5\34\17\2\u0118\u0116\3\2\2\2\u0119\u011a\3\2\2\2\u011a\u0118\3"+
		"\2\2\2\u011a\u011b\3\2\2\2\u011b\u011d\3\2\2\2\u011c\u00dd\3\2\2\2\u011c"+
		"\u00e0\3\2\2\2\u011c\u00e3\3\2\2\2\u011c\u00e6\3\2\2\2\u011c\u00e9\3\2"+
		"\2\2\u011c\u00ec\3\2\2\2\u011c\u00f2\3\2\2\2\u011c\u00f9\3\2\2\2\u011c"+
		"\u0100\3\2\2\2\u011c\u0107\3\2\2\2\u011c\u010e\3\2\2\2\u011c\u0115\3\2"+
		"\2\2\u011d\u0120\3\2\2\2\u011e\u011c\3\2\2\2\u011e\u011f\3\2\2\2\u011f"+
		"\35\3\2\2\2\u0120\u011e\3\2\2\2  \"+\62@JWZ`bo{~\u008a\u0097\u009f\u00a8"+
		"\u00ac\u00b4\u00c0\u00c9\u00db\u00f7\u00fe\u0105\u010c\u0113\u011a\u011c"+
		"\u011e";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}