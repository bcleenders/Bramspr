// Generated from C:\Users\Jasper\eclipse_workspace\Bramspr\src\Bramspr.g4 by ANTLR 4.1
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
		RIGHT_BRACE=35, FUNCTION=25, XOR=19, LOGIC=20, GREATER_THAN=10, WHILE=24, 
		SWAP=2, PLUSMINUS=14, ELSE=23, NUMBER=44, BOOL=40, BECOMES=1, WHITESPACE=47, 
		POWER=15, SEMICOLON=31, NOT=16, MINUS=4, AND=17, CHARACTER=42, EQUALS_TO=12, 
		RIGHT_BLOCKBRACE=37, LEFT_BLOCKBRACE=36, TYPE=26, IF=21, COLON=30, FINAL=29, 
		ENUM=27, THEN=22, RIGHT_PARENTHESIS=33, SMALLER_THAN=8, COMMA=38, IDENTIFIER=43, 
		LEFT_BRACE=34, LEFT_PARENTHESIS=32, MODULUS=7, OR=18, RETURN=28, DIVISION=6, 
		BLOCKCOMMENT=46, MULTIPLICATION=5, PLUS=3, NOT_EQUALS_TO=13, GREATER_THAN_EQUALS_TO=11, 
		COMMENT=45, DOT=39, STRING=41, SMALLER_THAN_EQUALS_TO=9;
	public static final String[] tokenNames = {
		"<INVALID>", "':='", "'<>'", "'+'", "'-'", "'*'", "'/'", "'%'", "'<'", 
		"'<='", "'>'", "'>='", "'='", "'=/='", "'+-'", "'^'", "'!'", "'&'", "'|'", 
		"'!&'", "LOGIC", "'if'", "'then'", "'else'", "'while'", "'function'", 
		"'type'", "'enum'", "'return'", "'final'", "':'", "';'", "'('", "')'", 
		"'{'", "'}'", "'['", "']'", "','", "'.'", "BOOL", "STRING", "CHARACTER", 
		"IDENTIFIER", "NUMBER", "COMMENT", "BLOCKCOMMENT", "WHITESPACE"
	};
	public static final int
		RULE_program = 0, RULE_structure = 1, RULE_blockStructure = 2, RULE_ifStructure = 3, 
		RULE_whileStructure = 4, RULE_statement = 5, RULE_declaration = 6, RULE_variableDeclaration = 7, 
		RULE_enumerationDeclaration = 8, RULE_functionDeclaration = 9, RULE_typeDeclaration = 10, 
		RULE_typeDenoter = 11, RULE_assignment = 12, RULE_swap = 13, RULE_expression = 14, 
		RULE_arithmetic = 15, RULE_assignable = 16, RULE_atomic = 17, RULE_functionCall = 18, 
		RULE_fieldAccess = 19, RULE_literal = 20;
	public static final String[] ruleNames = {
		"program", "structure", "blockStructure", "ifStructure", "whileStructure", 
		"statement", "declaration", "variableDeclaration", "enumerationDeclaration", 
		"functionDeclaration", "typeDeclaration", "typeDenoter", "assignment", 
		"swap", "expression", "arithmetic", "assignable", "atomic", "functionCall", 
		"fieldAccess", "literal"
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
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
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
			setState(45);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << FUNCTION) | (1L << TYPE) | (1L << ENUM) | (1L << FINAL) | (1L << LEFT_BRACE) | (1L << IDENTIFIER))) != 0)) {
				{
				{
				setState(42); statement();
				}
				}
				setState(47);
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

	public static class StructureContext extends ParserRuleContext {
		public IfStructureContext ifStructure() {
			return getRuleContext(IfStructureContext.class,0);
		}
		public BlockStructureContext blockStructure() {
			return getRuleContext(BlockStructureContext.class,0);
		}
		public WhileStructureContext whileStructure() {
			return getRuleContext(WhileStructureContext.class,0);
		}
		public StructureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structure; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitStructure(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StructureContext structure() throws RecognitionException {
		StructureContext _localctx = new StructureContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_structure);
		try {
			setState(51);
			switch (_input.LA(1)) {
			case LEFT_BRACE:
				enterOuterAlt(_localctx, 1);
				{
				setState(48); blockStructure();
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 2);
				{
				setState(49); ifStructure();
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 3);
				{
				setState(50); whileStructure();
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

	public static class BlockStructureContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public TerminalNode RIGHT_BRACE() { return getToken(BramsprParser.RIGHT_BRACE, 0); }
		public TerminalNode LEFT_BRACE() { return getToken(BramsprParser.LEFT_BRACE, 0); }
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BlockStructureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockStructure; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitBlockStructure(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockStructureContext blockStructure() throws RecognitionException {
		BlockStructureContext _localctx = new BlockStructureContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_blockStructure);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53); match(LEFT_BRACE);
			setState(57);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << FUNCTION) | (1L << TYPE) | (1L << ENUM) | (1L << FINAL) | (1L << LEFT_BRACE) | (1L << IDENTIFIER))) != 0)) {
				{
				{
				setState(54); statement();
				}
				}
				setState(59);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(60); match(RIGHT_BRACE);
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

	public static class IfStructureContext extends ParserRuleContext {
		public BlockStructureContext blockStructure(int i) {
			return getRuleContext(BlockStructureContext.class,i);
		}
		public TerminalNode IF() { return getToken(BramsprParser.IF, 0); }
		public TerminalNode LEFT_PARENTHESIS() { return getToken(BramsprParser.LEFT_PARENTHESIS, 0); }
		public List<BlockStructureContext> blockStructure() {
			return getRuleContexts(BlockStructureContext.class);
		}
		public TerminalNode ELSE() { return getToken(BramsprParser.ELSE, 0); }
		public TerminalNode RIGHT_PARENTHESIS() { return getToken(BramsprParser.RIGHT_PARENTHESIS, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public IfStructureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStructure; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitIfStructure(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStructureContext ifStructure() throws RecognitionException {
		IfStructureContext _localctx = new IfStructureContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_ifStructure);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62); match(IF);
			setState(63); match(LEFT_PARENTHESIS);
			setState(64); expression(0);
			setState(65); match(RIGHT_PARENTHESIS);
			setState(66); blockStructure();
			setState(69);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(67); match(ELSE);
				setState(68); blockStructure();
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

	public static class WhileStructureContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(BramsprParser.WHILE, 0); }
		public TerminalNode LEFT_PARENTHESIS() { return getToken(BramsprParser.LEFT_PARENTHESIS, 0); }
		public BlockStructureContext blockStructure() {
			return getRuleContext(BlockStructureContext.class,0);
		}
		public TerminalNode RIGHT_PARENTHESIS() { return getToken(BramsprParser.RIGHT_PARENTHESIS, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public WhileStructureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStructure; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitWhileStructure(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileStructureContext whileStructure() throws RecognitionException {
		WhileStructureContext _localctx = new WhileStructureContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_whileStructure);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71); match(WHILE);
			setState(72); match(LEFT_PARENTHESIS);
			setState(73); expression(0);
			setState(74); match(RIGHT_PARENTHESIS);
			setState(75); blockStructure();
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
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public StructureContext structure() {
			return getRuleContext(StructureContext.class,0);
		}
		public SwapContext swap() {
			return getRuleContext(SwapContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_statement);
		try {
			setState(90);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(77); structure();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(78); declaration();
				setState(79); match(SEMICOLON);
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(81); assignment();
				setState(82); match(SEMICOLON);
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(84); swap();
				setState(85); match(SEMICOLON);
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(87); functionCall();
				setState(88); match(SEMICOLON);
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

	public static class DeclarationContext extends ParserRuleContext {
		public FunctionDeclarationContext functionDeclaration() {
			return getRuleContext(FunctionDeclarationContext.class,0);
		}
		public TypeDeclarationContext typeDeclaration() {
			return getRuleContext(TypeDeclarationContext.class,0);
		}
		public EnumerationDeclarationContext enumerationDeclaration() {
			return getRuleContext(EnumerationDeclarationContext.class,0);
		}
		public VariableDeclarationContext variableDeclaration() {
			return getRuleContext(VariableDeclarationContext.class,0);
		}
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_declaration);
		try {
			setState(96);
			switch (_input.LA(1)) {
			case TYPE:
				enterOuterAlt(_localctx, 1);
				{
				setState(92); typeDeclaration();
				}
				break;
			case FUNCTION:
				enterOuterAlt(_localctx, 2);
				{
				setState(93); functionDeclaration();
				}
				break;
			case ENUM:
				enterOuterAlt(_localctx, 3);
				{
				setState(94); enumerationDeclaration();
				}
				break;
			case FINAL:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 4);
				{
				setState(95); variableDeclaration();
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

	public static class VariableDeclarationContext extends ParserRuleContext {
		public TerminalNode FINAL() { return getToken(BramsprParser.FINAL, 0); }
		public TypeDenoterContext typeDenoter() {
			return getRuleContext(TypeDenoterContext.class,0);
		}
		public TerminalNode IDENTIFIER(int i) {
			return getToken(BramsprParser.IDENTIFIER, i);
		}
		public List<TerminalNode> IDENTIFIER() { return getTokens(BramsprParser.IDENTIFIER); }
		public List<TerminalNode> COMMA() { return getTokens(BramsprParser.COMMA); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode BECOMES() { return getToken(BramsprParser.BECOMES, 0); }
		public TerminalNode COLON() { return getToken(BramsprParser.COLON, 0); }
		public TerminalNode COMMA(int i) {
			return getToken(BramsprParser.COMMA, i);
		}
		public VariableDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclaration; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitVariableDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableDeclarationContext variableDeclaration() throws RecognitionException {
		VariableDeclarationContext _localctx = new VariableDeclarationContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_variableDeclaration);
		int _la;
		try {
			setState(124);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(98); match(IDENTIFIER);
				setState(103);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(99); match(COMMA);
					setState(100); match(IDENTIFIER);
					}
					}
					setState(105);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(106); match(COLON);
				setState(107); typeDenoter();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(109);
				_la = _input.LA(1);
				if (_la==FINAL) {
					{
					setState(108); match(FINAL);
					}
				}

				setState(111); match(IDENTIFIER);
				setState(116);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(112); match(COMMA);
					setState(113); match(IDENTIFIER);
					}
					}
					setState(118);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(119); match(COLON);
				setState(120); typeDenoter();
				setState(121); match(BECOMES);
				setState(122); expression(0);
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

	public static class EnumerationDeclarationContext extends ParserRuleContext {
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
		public EnumerationDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumerationDeclaration; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitEnumerationDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnumerationDeclarationContext enumerationDeclaration() throws RecognitionException {
		EnumerationDeclarationContext _localctx = new EnumerationDeclarationContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_enumerationDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126); match(ENUM);
			setState(127); match(IDENTIFIER);
			setState(128); match(LEFT_BRACE);
			setState(137);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(129); match(IDENTIFIER);
				setState(134);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(130); match(COMMA);
					setState(131); match(IDENTIFIER);
					}
					}
					setState(136);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(139); match(RIGHT_BRACE);
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

	public static class FunctionDeclarationContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public TerminalNode SEMICOLON() { return getToken(BramsprParser.SEMICOLON, 0); }
		public TerminalNode RIGHT_BRACE() { return getToken(BramsprParser.RIGHT_BRACE, 0); }
		public TypeDenoterContext typeDenoter(int i) {
			return getRuleContext(TypeDenoterContext.class,i);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode COMMA(int i) {
			return getToken(BramsprParser.COMMA, i);
		}
		public TerminalNode LEFT_PARENTHESIS() { return getToken(BramsprParser.LEFT_PARENTHESIS, 0); }
		public List<TerminalNode> IDENTIFIER() { return getTokens(BramsprParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(BramsprParser.IDENTIFIER, i);
		}
		public List<TypeDenoterContext> typeDenoter() {
			return getRuleContexts(TypeDenoterContext.class);
		}
		public List<TerminalNode> COMMA() { return getTokens(BramsprParser.COMMA); }
		public TerminalNode FUNCTION() { return getToken(BramsprParser.FUNCTION, 0); }
		public TerminalNode RIGHT_PARENTHESIS() { return getToken(BramsprParser.RIGHT_PARENTHESIS, 0); }
		public TerminalNode RETURN() { return getToken(BramsprParser.RETURN, 0); }
		public TerminalNode COLON(int i) {
			return getToken(BramsprParser.COLON, i);
		}
		public TerminalNode LEFT_BRACE() { return getToken(BramsprParser.LEFT_BRACE, 0); }
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<TerminalNode> COLON() { return getTokens(BramsprParser.COLON); }
		public FunctionDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDeclaration; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitFunctionDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionDeclarationContext functionDeclaration() throws RecognitionException {
		FunctionDeclarationContext _localctx = new FunctionDeclarationContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_functionDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141); match(FUNCTION);
			setState(142); match(IDENTIFIER);
			setState(143); match(LEFT_PARENTHESIS);
			setState(156);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(144); match(IDENTIFIER);
				setState(145); match(COLON);
				setState(146); typeDenoter();
				setState(153);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(147); match(COMMA);
					setState(148); match(IDENTIFIER);
					setState(149); match(COLON);
					setState(150); typeDenoter();
					}
					}
					setState(155);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(158); match(RIGHT_PARENTHESIS);
			setState(159); match(LEFT_BRACE);
			setState(163);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << FUNCTION) | (1L << TYPE) | (1L << ENUM) | (1L << FINAL) | (1L << LEFT_BRACE) | (1L << IDENTIFIER))) != 0)) {
				{
				{
				setState(160); statement();
				}
				}
				setState(165);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(170);
			_la = _input.LA(1);
			if (_la==RETURN) {
				{
				setState(166); match(RETURN);
				setState(167); expression(0);
				setState(168); match(SEMICOLON);
				}
			}

			setState(172); match(RIGHT_BRACE);
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

	public static class TypeDeclarationContext extends ParserRuleContext {
		public TerminalNode RIGHT_BRACE() { return getToken(BramsprParser.RIGHT_BRACE, 0); }
		public TypeDenoterContext typeDenoter(int i) {
			return getRuleContext(TypeDenoterContext.class,i);
		}
		public List<TypeDenoterContext> typeDenoter() {
			return getRuleContexts(TypeDenoterContext.class);
		}
		public TerminalNode IDENTIFIER(int i) {
			return getToken(BramsprParser.IDENTIFIER, i);
		}
		public List<TerminalNode> IDENTIFIER() { return getTokens(BramsprParser.IDENTIFIER); }
		public List<TerminalNode> COMMA() { return getTokens(BramsprParser.COMMA); }
		public TerminalNode COLON(int i) {
			return getToken(BramsprParser.COLON, i);
		}
		public TerminalNode LEFT_BRACE() { return getToken(BramsprParser.LEFT_BRACE, 0); }
		public List<TerminalNode> COLON() { return getTokens(BramsprParser.COLON); }
		public TerminalNode COMMA(int i) {
			return getToken(BramsprParser.COMMA, i);
		}
		public TerminalNode TYPE() { return getToken(BramsprParser.TYPE, 0); }
		public TypeDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeDeclaration; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitTypeDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeDeclarationContext typeDeclaration() throws RecognitionException {
		TypeDeclarationContext _localctx = new TypeDeclarationContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_typeDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(174); match(TYPE);
			setState(175); match(IDENTIFIER);
			setState(176); match(LEFT_BRACE);
			setState(189);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(177); match(IDENTIFIER);
				setState(178); match(COLON);
				setState(179); typeDenoter();
				setState(186);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(180); match(COMMA);
					setState(181); match(IDENTIFIER);
					setState(182); match(COLON);
					setState(183); typeDenoter();
					}
					}
					setState(188);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(191); match(RIGHT_BRACE);
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

	public static class TypeDenoterContext extends ParserRuleContext {
		public TypeDenoterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeDenoter; }
	 
		public TypeDenoterContext() { }
		public void copyFrom(TypeDenoterContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class BaseTypeDenoterContext extends TypeDenoterContext {
		public TerminalNode IDENTIFIER() { return getToken(BramsprParser.IDENTIFIER, 0); }
		public BaseTypeDenoterContext(TypeDenoterContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitBaseTypeDenoter(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArrayTypeDenoterContext extends TypeDenoterContext {
		public TerminalNode LEFT_BLOCKBRACE() { return getToken(BramsprParser.LEFT_BLOCKBRACE, 0); }
		public TypeDenoterContext typeDenoter() {
			return getRuleContext(TypeDenoterContext.class,0);
		}
		public TerminalNode NUMBER() { return getToken(BramsprParser.NUMBER, 0); }
		public TerminalNode RIGHT_BLOCKBRACE() { return getToken(BramsprParser.RIGHT_BLOCKBRACE, 0); }
		public ArrayTypeDenoterContext(TypeDenoterContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitArrayTypeDenoter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeDenoterContext typeDenoter() throws RecognitionException {
		TypeDenoterContext _localctx = new TypeDenoterContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_typeDenoter);
		try {
			setState(198);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				_localctx = new BaseTypeDenoterContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(193); match(IDENTIFIER);
				}
				break;
			case LEFT_BLOCKBRACE:
				_localctx = new ArrayTypeDenoterContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(194); match(LEFT_BLOCKBRACE);
				setState(195); match(NUMBER);
				setState(196); match(RIGHT_BLOCKBRACE);
				setState(197); typeDenoter();
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

	public static class AssignmentContext extends ParserRuleContext {
		public AssignableContext assignable(int i) {
			return getRuleContext(AssignableContext.class,i);
		}
		public List<AssignableContext> assignable() {
			return getRuleContexts(AssignableContext.class);
		}
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
			setState(203); 
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(200); assignable(0);
					setState(201); match(BECOMES);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(205); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			} while ( _alt!=2 && _alt!=-1 );
			setState(207); expression(0);
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

	public static class SwapContext extends ParserRuleContext {
		public AssignableContext assignable(int i) {
			return getRuleContext(AssignableContext.class,i);
		}
		public TerminalNode SWAP() { return getToken(BramsprParser.SWAP, 0); }
		public List<AssignableContext> assignable() {
			return getRuleContexts(AssignableContext.class);
		}
		public SwapContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_swap; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitSwap(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SwapContext swap() throws RecognitionException {
		SwapContext _localctx = new SwapContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_swap);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(209); assignable(0);
			setState(210); match(SWAP);
			setState(211); assignable(0);
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
	public static class ArithmeticExpressionContext extends ExpressionContext {
		public ArithmeticContext arithmetic() {
			return getRuleContext(ArithmeticContext.class,0);
		}
		public ArithmeticExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitArithmeticExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class GreaterThanEqualsToExpressionContext extends ExpressionContext {
		public List<TerminalNode> GREATER_THAN_EQUALS_TO() { return getTokens(BramsprParser.GREATER_THAN_EQUALS_TO); }
		public List<ArithmeticContext> arithmetic() {
			return getRuleContexts(ArithmeticContext.class);
		}
		public ArithmeticContext arithmetic(int i) {
			return getRuleContext(ArithmeticContext.class,i);
		}
		public TerminalNode GREATER_THAN_EQUALS_TO(int i) {
			return getToken(BramsprParser.GREATER_THAN_EQUALS_TO, i);
		}
		public GreaterThanEqualsToExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitGreaterThanEqualsToExpression(this);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitEqualsToExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class GreaterThanExpressionContext extends ExpressionContext {
		public TerminalNode GREATER_THAN(int i) {
			return getToken(BramsprParser.GREATER_THAN, i);
		}
		public List<ArithmeticContext> arithmetic() {
			return getRuleContexts(ArithmeticContext.class);
		}
		public ArithmeticContext arithmetic(int i) {
			return getRuleContext(ArithmeticContext.class,i);
		}
		public List<TerminalNode> GREATER_THAN() { return getTokens(BramsprParser.GREATER_THAN); }
		public GreaterThanExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitGreaterThanExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SmallerThanExpressionContext extends ExpressionContext {
		public List<TerminalNode> SMALLER_THAN() { return getTokens(BramsprParser.SMALLER_THAN); }
		public TerminalNode SMALLER_THAN(int i) {
			return getToken(BramsprParser.SMALLER_THAN, i);
		}
		public List<ArithmeticContext> arithmetic() {
			return getRuleContexts(ArithmeticContext.class);
		}
		public ArithmeticContext arithmetic(int i) {
			return getRuleContext(ArithmeticContext.class,i);
		}
		public SmallerThanExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitSmallerThanExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NotExpressionContext extends ExpressionContext {
		public TerminalNode NOT() { return getToken(BramsprParser.NOT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public NotExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitNotExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PlusMinusExpressionContext extends ExpressionContext {
		public TerminalNode EQUALS_TO() { return getToken(BramsprParser.EQUALS_TO, 0); }
		public TerminalNode PLUSMINUS() { return getToken(BramsprParser.PLUSMINUS, 0); }
		public List<ArithmeticContext> arithmetic() {
			return getRuleContexts(ArithmeticContext.class);
		}
		public ArithmeticContext arithmetic(int i) {
			return getRuleContext(ArithmeticContext.class,i);
		}
		public PlusMinusExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitPlusMinusExpression(this);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitNotEqualsToExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SmallerThanEqualsToExpressionContext extends ExpressionContext {
		public List<TerminalNode> SMALLER_THAN_EQUALS_TO() { return getTokens(BramsprParser.SMALLER_THAN_EQUALS_TO); }
		public List<ArithmeticContext> arithmetic() {
			return getRuleContexts(ArithmeticContext.class);
		}
		public ArithmeticContext arithmetic(int i) {
			return getRuleContext(ArithmeticContext.class,i);
		}
		public TerminalNode SMALLER_THAN_EQUALS_TO(int i) {
			return getToken(BramsprParser.SMALLER_THAN_EQUALS_TO, i);
		}
		public SmallerThanEqualsToExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitSmallerThanEqualsToExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState, _p);
		ExpressionContext _prevctx = _localctx;
		int _startState = 28;
		enterRecursionRule(_localctx, RULE_expression);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(251);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				{
				_localctx = new NotExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(214); match(NOT);
				setState(215); expression(9);
				}
				break;

			case 2:
				{
				_localctx = new ArithmeticExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(216); arithmetic(0);
				}
				break;

			case 3:
				{
				_localctx = new PlusMinusExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(217); arithmetic(0);
				setState(218); match(EQUALS_TO);
				setState(219); arithmetic(0);
				setState(220); match(PLUSMINUS);
				setState(221); arithmetic(0);
				}
				break;

			case 4:
				{
				_localctx = new GreaterThanExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(223); arithmetic(0);
				setState(226); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(224); match(GREATER_THAN);
						setState(225); arithmetic(0);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(228); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
				} while ( _alt!=2 && _alt!=-1 );
				}
				break;

			case 5:
				{
				_localctx = new GreaterThanEqualsToExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(230); arithmetic(0);
				setState(233); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(231); match(GREATER_THAN_EQUALS_TO);
						setState(232); arithmetic(0);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(235); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
				} while ( _alt!=2 && _alt!=-1 );
				}
				break;

			case 6:
				{
				_localctx = new SmallerThanExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(237); arithmetic(0);
				setState(240); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(238); match(SMALLER_THAN);
						setState(239); arithmetic(0);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(242); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
				} while ( _alt!=2 && _alt!=-1 );
				}
				break;

			case 7:
				{
				_localctx = new SmallerThanEqualsToExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(244); arithmetic(0);
				setState(247); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(245); match(SMALLER_THAN_EQUALS_TO);
						setState(246); arithmetic(0);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(249); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
				} while ( _alt!=2 && _alt!=-1 );
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(269);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(267);
					switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
					case 1:
						{
						_localctx = new EqualsToExpressionContext(new ExpressionContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(253);
						if (!(7 >= _localctx._p)) throw new FailedPredicateException(this, "7 >= $_p");
						setState(256); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(254); match(EQUALS_TO);
								setState(255); expression(0);
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(258); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
						} while ( _alt!=2 && _alt!=-1 );
						}
						break;

					case 2:
						{
						_localctx = new NotEqualsToExpressionContext(new ExpressionContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(260);
						if (!(6 >= _localctx._p)) throw new FailedPredicateException(this, "6 >= $_p");
						setState(263); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(261); match(NOT_EQUALS_TO);
								setState(262); expression(0);
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(265); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
						} while ( _alt!=2 && _alt!=-1 );
						}
						break;
					}
					} 
				}
				setState(271);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
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

	public static class ArithmeticContext extends ParserRuleContext {
		public int _p;
		public ArithmeticContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public ArithmeticContext(ParserRuleContext parent, int invokingState, int _p) {
			super(parent, invokingState);
			this._p = _p;
		}
		@Override public int getRuleIndex() { return RULE_arithmetic; }
	 
		public ArithmeticContext() { }
		public void copyFrom(ArithmeticContext ctx) {
			super.copyFrom(ctx);
			this._p = ctx._p;
		}
	}
	public static class SignExpressionContext extends ArithmeticContext {
		public ArithmeticContext arithmetic() {
			return getRuleContext(ArithmeticContext.class,0);
		}
		public TerminalNode MINUS() { return getToken(BramsprParser.MINUS, 0); }
		public TerminalNode PLUS() { return getToken(BramsprParser.PLUS, 0); }
		public SignExpressionContext(ArithmeticContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitSignExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AtomicExpressionContext extends ArithmeticContext {
		public AtomicContext atomic() {
			return getRuleContext(AtomicContext.class,0);
		}
		public AtomicExpressionContext(ArithmeticContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitAtomicExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AdditionExpressionContext extends ArithmeticContext {
		public List<ArithmeticContext> arithmetic() {
			return getRuleContexts(ArithmeticContext.class);
		}
		public TerminalNode MINUS() { return getToken(BramsprParser.MINUS, 0); }
		public ArithmeticContext arithmetic(int i) {
			return getRuleContext(ArithmeticContext.class,i);
		}
		public TerminalNode PLUS() { return getToken(BramsprParser.PLUS, 0); }
		public AdditionExpressionContext(ArithmeticContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitAdditionExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PowerExpressionContext extends ArithmeticContext {
		public TerminalNode POWER() { return getToken(BramsprParser.POWER, 0); }
		public List<ArithmeticContext> arithmetic() {
			return getRuleContexts(ArithmeticContext.class);
		}
		public ArithmeticContext arithmetic(int i) {
			return getRuleContext(ArithmeticContext.class,i);
		}
		public PowerExpressionContext(ArithmeticContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitPowerExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MultiplicationExpressionContext extends ArithmeticContext {
		public TerminalNode MULTIPLICATION() { return getToken(BramsprParser.MULTIPLICATION, 0); }
		public TerminalNode DIVISION() { return getToken(BramsprParser.DIVISION, 0); }
		public List<ArithmeticContext> arithmetic() {
			return getRuleContexts(ArithmeticContext.class);
		}
		public ArithmeticContext arithmetic(int i) {
			return getRuleContext(ArithmeticContext.class,i);
		}
		public TerminalNode MODULUS() { return getToken(BramsprParser.MODULUS, 0); }
		public MultiplicationExpressionContext(ArithmeticContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitMultiplicationExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArithmeticContext arithmetic(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ArithmeticContext _localctx = new ArithmeticContext(_ctx, _parentState, _p);
		ArithmeticContext _prevctx = _localctx;
		int _startState = 30;
		enterRecursionRule(_localctx, RULE_arithmetic);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(276);
			switch (_input.LA(1)) {
			case PLUS:
			case MINUS:
				{
				_localctx = new SignExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(273);
				_la = _input.LA(1);
				if ( !(_la==PLUS || _la==MINUS) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(274); arithmetic(4);
				}
				break;
			case ENUM:
			case LEFT_PARENTHESIS:
			case LEFT_BLOCKBRACE:
			case BOOL:
			case STRING:
			case CHARACTER:
			case IDENTIFIER:
			case NUMBER:
				{
				_localctx = new AtomicExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(275); atomic(0);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(289);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(287);
					switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
					case 1:
						{
						_localctx = new PowerExpressionContext(new ArithmeticContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_arithmetic);
						setState(278);
						if (!(3 >= _localctx._p)) throw new FailedPredicateException(this, "3 >= $_p");
						setState(279); match(POWER);
						setState(280); arithmetic(3);
						}
						break;

					case 2:
						{
						_localctx = new MultiplicationExpressionContext(new ArithmeticContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_arithmetic);
						setState(281);
						if (!(2 >= _localctx._p)) throw new FailedPredicateException(this, "2 >= $_p");
						setState(282);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MULTIPLICATION) | (1L << DIVISION) | (1L << MODULUS))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(283); arithmetic(3);
						}
						break;

					case 3:
						{
						_localctx = new AdditionExpressionContext(new ArithmeticContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_arithmetic);
						setState(284);
						if (!(1 >= _localctx._p)) throw new FailedPredicateException(this, "1 >= $_p");
						setState(285);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(286); arithmetic(2);
						}
						break;
					}
					} 
				}
				setState(291);
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

	public static class AssignableContext extends ParserRuleContext {
		public int _p;
		public AssignableContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public AssignableContext(ParserRuleContext parent, int invokingState, int _p) {
			super(parent, invokingState);
			this._p = _p;
		}
		@Override public int getRuleIndex() { return RULE_assignable; }
	 
		public AssignableContext() { }
		public void copyFrom(AssignableContext ctx) {
			super.copyFrom(ctx);
			this._p = ctx._p;
		}
	}
	public static class IdentifierExpressionContext extends AssignableContext {
		public TerminalNode IDENTIFIER() { return getToken(BramsprParser.IDENTIFIER, 0); }
		public IdentifierExpressionContext(AssignableContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitIdentifierExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AssignableFieldAccessExpressionContext extends AssignableContext {
		public FieldAccessContext fieldAccess() {
			return getRuleContext(FieldAccessContext.class,0);
		}
		public AssignableContext assignable() {
			return getRuleContext(AssignableContext.class,0);
		}
		public AssignableFieldAccessExpressionContext(AssignableContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitAssignableFieldAccessExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignableContext assignable(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		AssignableContext _localctx = new AssignableContext(_ctx, _parentState, _p);
		AssignableContext _prevctx = _localctx;
		int _startState = 32;
		enterRecursionRule(_localctx, RULE_assignable);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new IdentifierExpressionContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(293); match(IDENTIFIER);
			}
			_ctx.stop = _input.LT(-1);
			setState(299);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new AssignableFieldAccessExpressionContext(new AssignableContext(_parentctx, _parentState, _p));
					pushNewRecursionContext(_localctx, _startState, RULE_assignable);
					setState(295);
					if (!(2 >= _localctx._p)) throw new FailedPredicateException(this, "2 >= $_p");
					setState(296); fieldAccess();
					}
					} 
				}
				setState(301);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
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

	public static class AtomicContext extends ParserRuleContext {
		public int _p;
		public AtomicContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public AtomicContext(ParserRuleContext parent, int invokingState, int _p) {
			super(parent, invokingState);
			this._p = _p;
		}
		@Override public int getRuleIndex() { return RULE_atomic; }
	 
		public AtomicContext() { }
		public void copyFrom(AtomicContext ctx) {
			super.copyFrom(ctx);
			this._p = ctx._p;
		}
	}
	public static class ParenthesisExpressionContext extends AtomicContext {
		public TerminalNode LEFT_PARENTHESIS() { return getToken(BramsprParser.LEFT_PARENTHESIS, 0); }
		public TerminalNode RIGHT_PARENTHESIS() { return getToken(BramsprParser.RIGHT_PARENTHESIS, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ParenthesisExpressionContext(AtomicContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitParenthesisExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AssignableExpressionContext extends AtomicContext {
		public AssignableContext assignable() {
			return getRuleContext(AssignableContext.class,0);
		}
		public AssignableExpressionContext(AtomicContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitAssignableExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LiteralExpressionContext extends AtomicContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public LiteralExpressionContext(AtomicContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitLiteralExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AssignmentExpressionContext extends AtomicContext {
		public TerminalNode LEFT_PARENTHESIS() { return getToken(BramsprParser.LEFT_PARENTHESIS, 0); }
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public TerminalNode RIGHT_PARENTHESIS() { return getToken(BramsprParser.RIGHT_PARENTHESIS, 0); }
		public AssignmentExpressionContext(AtomicContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitAssignmentExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExplicitEnumExpressionContext extends AtomicContext {
		public TerminalNode ENUM() { return getToken(BramsprParser.ENUM, 0); }
		public List<TerminalNode> DOT() { return getTokens(BramsprParser.DOT); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(BramsprParser.IDENTIFIER, i);
		}
		public List<TerminalNode> IDENTIFIER() { return getTokens(BramsprParser.IDENTIFIER); }
		public TerminalNode DOT(int i) {
			return getToken(BramsprParser.DOT, i);
		}
		public ExplicitEnumExpressionContext(AtomicContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitExplicitEnumExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FunctionCallExpressionContext extends AtomicContext {
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public FunctionCallExpressionContext(AtomicContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitFunctionCallExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FieldAccessExpressionContext extends AtomicContext {
		public AtomicContext atomic() {
			return getRuleContext(AtomicContext.class,0);
		}
		public FieldAccessContext fieldAccess() {
			return getRuleContext(FieldAccessContext.class,0);
		}
		public FieldAccessExpressionContext(AtomicContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitFieldAccessExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomicContext atomic(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		AtomicContext _localctx = new AtomicContext(_ctx, _parentState, _p);
		AtomicContext _prevctx = _localctx;
		int _startState = 34;
		enterRecursionRule(_localctx, RULE_atomic);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(319);
			switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
			case 1:
				{
				_localctx = new AssignmentExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(303); match(LEFT_PARENTHESIS);
				setState(304); assignment();
				setState(305); match(RIGHT_PARENTHESIS);
				}
				break;

			case 2:
				{
				_localctx = new ParenthesisExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(307); match(LEFT_PARENTHESIS);
				setState(308); expression(0);
				setState(309); match(RIGHT_PARENTHESIS);
				}
				break;

			case 3:
				{
				_localctx = new ExplicitEnumExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(311); match(ENUM);
				setState(312); match(DOT);
				setState(313); match(IDENTIFIER);
				setState(314); match(DOT);
				setState(315); match(IDENTIFIER);
				}
				break;

			case 4:
				{
				_localctx = new AssignableExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(316); assignable(0);
				}
				break;

			case 5:
				{
				_localctx = new FunctionCallExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(317); functionCall();
				}
				break;

			case 6:
				{
				_localctx = new LiteralExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(318); literal();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(325);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new FieldAccessExpressionContext(new AtomicContext(_parentctx, _parentState, _p));
					pushNewRecursionContext(_localctx, _startState, RULE_atomic);
					setState(321);
					if (!(1 >= _localctx._p)) throw new FailedPredicateException(this, "1 >= $_p");
					setState(322); fieldAccess();
					}
					} 
				}
				setState(327);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
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

	public static class FunctionCallContext extends ParserRuleContext {
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
		public FunctionCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionCall; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitFunctionCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionCallContext functionCall() throws RecognitionException {
		FunctionCallContext _localctx = new FunctionCallContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_functionCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(328); match(IDENTIFIER);
			setState(329); match(LEFT_PARENTHESIS);
			setState(338);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PLUS) | (1L << MINUS) | (1L << NOT) | (1L << ENUM) | (1L << LEFT_PARENTHESIS) | (1L << LEFT_BLOCKBRACE) | (1L << BOOL) | (1L << STRING) | (1L << CHARACTER) | (1L << IDENTIFIER) | (1L << NUMBER))) != 0)) {
				{
				setState(330); expression(0);
				setState(335);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(331); match(COMMA);
					setState(332); expression(0);
					}
					}
					setState(337);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(340); match(RIGHT_PARENTHESIS);
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

	public static class FieldAccessContext extends ParserRuleContext {
		public TerminalNode LEFT_BLOCKBRACE() { return getToken(BramsprParser.LEFT_BLOCKBRACE, 0); }
		public TerminalNode DOT() { return getToken(BramsprParser.DOT, 0); }
		public TerminalNode IDENTIFIER() { return getToken(BramsprParser.IDENTIFIER, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RIGHT_BLOCKBRACE() { return getToken(BramsprParser.RIGHT_BLOCKBRACE, 0); }
		public FieldAccessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldAccess; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitFieldAccess(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldAccessContext fieldAccess() throws RecognitionException {
		FieldAccessContext _localctx = new FieldAccessContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_fieldAccess);
		try {
			setState(348);
			switch (_input.LA(1)) {
			case DOT:
				enterOuterAlt(_localctx, 1);
				{
				setState(342); match(DOT);
				setState(343); match(IDENTIFIER);
				}
				break;
			case LEFT_BLOCKBRACE:
				enterOuterAlt(_localctx, 2);
				{
				setState(344); match(LEFT_BLOCKBRACE);
				setState(345); expression(0);
				setState(346); match(RIGHT_BLOCKBRACE);
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

	public static class LiteralContext extends ParserRuleContext {
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
	 
		public LiteralContext() { }
		public void copyFrom(LiteralContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ArrayLiteralContext extends LiteralContext {
		public TerminalNode LEFT_BLOCKBRACE() { return getToken(BramsprParser.LEFT_BLOCKBRACE, 0); }
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(BramsprParser.COMMA); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public TerminalNode COMMA(int i) {
			return getToken(BramsprParser.COMMA, i);
		}
		public TerminalNode RIGHT_BLOCKBRACE() { return getToken(BramsprParser.RIGHT_BLOCKBRACE, 0); }
		public ArrayLiteralContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitArrayLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CharacterLiteralContext extends LiteralContext {
		public TerminalNode CHARACTER() { return getToken(BramsprParser.CHARACTER, 0); }
		public CharacterLiteralContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitCharacterLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StringLiteralContext extends LiteralContext {
		public TerminalNode STRING() { return getToken(BramsprParser.STRING, 0); }
		public StringLiteralContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitStringLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BooleanLiteralContext extends LiteralContext {
		public TerminalNode BOOL() { return getToken(BramsprParser.BOOL, 0); }
		public BooleanLiteralContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitBooleanLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CompositeLiteralContext extends LiteralContext {
		public AssignmentContext assignment(int i) {
			return getRuleContext(AssignmentContext.class,i);
		}
		public TerminalNode RIGHT_BRACE() { return getToken(BramsprParser.RIGHT_BRACE, 0); }
		public List<AssignmentContext> assignment() {
			return getRuleContexts(AssignmentContext.class);
		}
		public TerminalNode IDENTIFIER() { return getToken(BramsprParser.IDENTIFIER, 0); }
		public List<TerminalNode> COMMA() { return getTokens(BramsprParser.COMMA); }
		public TerminalNode LEFT_BRACE() { return getToken(BramsprParser.LEFT_BRACE, 0); }
		public TerminalNode COMMA(int i) {
			return getToken(BramsprParser.COMMA, i);
		}
		public CompositeLiteralContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitCompositeLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NumberLiteralContext extends LiteralContext {
		public TerminalNode NUMBER() { return getToken(BramsprParser.NUMBER, 0); }
		public NumberLiteralContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitNumberLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_literal);
		int _la;
		try {
			setState(379);
			switch (_input.LA(1)) {
			case NUMBER:
				_localctx = new NumberLiteralContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(350); match(NUMBER);
				}
				break;
			case CHARACTER:
				_localctx = new CharacterLiteralContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(351); match(CHARACTER);
				}
				break;
			case STRING:
				_localctx = new StringLiteralContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(352); match(STRING);
				}
				break;
			case BOOL:
				_localctx = new BooleanLiteralContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(353); match(BOOL);
				}
				break;
			case LEFT_BLOCKBRACE:
				_localctx = new ArrayLiteralContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(354); match(LEFT_BLOCKBRACE);
				setState(363);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PLUS) | (1L << MINUS) | (1L << NOT) | (1L << ENUM) | (1L << LEFT_PARENTHESIS) | (1L << LEFT_BLOCKBRACE) | (1L << BOOL) | (1L << STRING) | (1L << CHARACTER) | (1L << IDENTIFIER) | (1L << NUMBER))) != 0)) {
					{
					setState(355); expression(0);
					setState(360);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(356); match(COMMA);
						setState(357); expression(0);
						}
						}
						setState(362);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(365); match(RIGHT_BLOCKBRACE);
				}
				break;
			case IDENTIFIER:
				_localctx = new CompositeLiteralContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(366); match(IDENTIFIER);
				setState(367); match(LEFT_BRACE);
				setState(376);
				_la = _input.LA(1);
				if (_la==IDENTIFIER) {
					{
					setState(368); assignment();
					setState(373);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(369); match(COMMA);
						setState(370); assignment();
						}
						}
						setState(375);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(378); match(RIGHT_BRACE);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 14: return expression_sempred((ExpressionContext)_localctx, predIndex);

		case 15: return arithmetic_sempred((ArithmeticContext)_localctx, predIndex);

		case 16: return assignable_sempred((AssignableContext)_localctx, predIndex);

		case 17: return atomic_sempred((AtomicContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return 7 >= _localctx._p;

		case 1: return 6 >= _localctx._p;
		}
		return true;
	}
	private boolean assignable_sempred(AssignableContext _localctx, int predIndex) {
		switch (predIndex) {
		case 5: return 2 >= _localctx._p;
		}
		return true;
	}
	private boolean arithmetic_sempred(ArithmeticContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2: return 3 >= _localctx._p;

		case 3: return 2 >= _localctx._p;

		case 4: return 1 >= _localctx._p;
		}
		return true;
	}
	private boolean atomic_sempred(AtomicContext _localctx, int predIndex) {
		switch (predIndex) {
		case 6: return 1 >= _localctx._p;
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\3\61\u0180\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\3\2\7\2.\n\2\f\2\16\2\61\13\2"+
		"\3\3\3\3\3\3\5\3\66\n\3\3\4\3\4\7\4:\n\4\f\4\16\4=\13\4\3\4\3\4\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\5\5H\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7]\n\7\3\b\3\b\3\b\3\b\5\bc\n"+
		"\b\3\t\3\t\3\t\7\th\n\t\f\t\16\tk\13\t\3\t\3\t\3\t\5\tp\n\t\3\t\3\t\3"+
		"\t\7\tu\n\t\f\t\16\tx\13\t\3\t\3\t\3\t\3\t\3\t\5\t\177\n\t\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\7\n\u0087\n\n\f\n\16\n\u008a\13\n\5\n\u008c\n\n\3\n\3\n\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\7\13\u009a\n\13\f\13"+
		"\16\13\u009d\13\13\5\13\u009f\n\13\3\13\3\13\3\13\7\13\u00a4\n\13\f\13"+
		"\16\13\u00a7\13\13\3\13\3\13\3\13\3\13\5\13\u00ad\n\13\3\13\3\13\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\7\f\u00bb\n\f\f\f\16\f\u00be\13\f\5"+
		"\f\u00c0\n\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\5\r\u00c9\n\r\3\16\3\16\3\16"+
		"\6\16\u00ce\n\16\r\16\16\16\u00cf\3\16\3\16\3\17\3\17\3\17\3\17\3\20\3"+
		"\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\6\20\u00e5"+
		"\n\20\r\20\16\20\u00e6\3\20\3\20\3\20\6\20\u00ec\n\20\r\20\16\20\u00ed"+
		"\3\20\3\20\3\20\6\20\u00f3\n\20\r\20\16\20\u00f4\3\20\3\20\3\20\6\20\u00fa"+
		"\n\20\r\20\16\20\u00fb\5\20\u00fe\n\20\3\20\3\20\3\20\6\20\u0103\n\20"+
		"\r\20\16\20\u0104\3\20\3\20\3\20\6\20\u010a\n\20\r\20\16\20\u010b\7\20"+
		"\u010e\n\20\f\20\16\20\u0111\13\20\3\21\3\21\3\21\3\21\5\21\u0117\n\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\7\21\u0122\n\21\f\21\16"+
		"\21\u0125\13\21\3\22\3\22\3\22\3\22\3\22\7\22\u012c\n\22\f\22\16\22\u012f"+
		"\13\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\5\23\u0142\n\23\3\23\3\23\7\23\u0146\n\23\f\23\16"+
		"\23\u0149\13\23\3\24\3\24\3\24\3\24\3\24\7\24\u0150\n\24\f\24\16\24\u0153"+
		"\13\24\5\24\u0155\n\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u015f"+
		"\n\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\7\26\u0169\n\26\f\26\16"+
		"\26\u016c\13\26\5\26\u016e\n\26\3\26\3\26\3\26\3\26\3\26\3\26\7\26\u0176"+
		"\n\26\f\26\16\26\u0179\13\26\5\26\u017b\n\26\3\26\5\26\u017e\n\26\3\26"+
		"\2\27\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*\2\4\3\2\5\6\3\2\7"+
		"\t\u01a9\2/\3\2\2\2\4\65\3\2\2\2\6\67\3\2\2\2\b@\3\2\2\2\nI\3\2\2\2\f"+
		"\\\3\2\2\2\16b\3\2\2\2\20~\3\2\2\2\22\u0080\3\2\2\2\24\u008f\3\2\2\2\26"+
		"\u00b0\3\2\2\2\30\u00c8\3\2\2\2\32\u00cd\3\2\2\2\34\u00d3\3\2\2\2\36\u00fd"+
		"\3\2\2\2 \u0116\3\2\2\2\"\u0126\3\2\2\2$\u0141\3\2\2\2&\u014a\3\2\2\2"+
		"(\u015e\3\2\2\2*\u017d\3\2\2\2,.\5\f\7\2-,\3\2\2\2.\61\3\2\2\2/-\3\2\2"+
		"\2/\60\3\2\2\2\60\3\3\2\2\2\61/\3\2\2\2\62\66\5\6\4\2\63\66\5\b\5\2\64"+
		"\66\5\n\6\2\65\62\3\2\2\2\65\63\3\2\2\2\65\64\3\2\2\2\66\5\3\2\2\2\67"+
		";\7$\2\28:\5\f\7\298\3\2\2\2:=\3\2\2\2;9\3\2\2\2;<\3\2\2\2<>\3\2\2\2="+
		";\3\2\2\2>?\7%\2\2?\7\3\2\2\2@A\7\27\2\2AB\7\"\2\2BC\5\36\20\2CD\7#\2"+
		"\2DG\5\6\4\2EF\7\31\2\2FH\5\6\4\2GE\3\2\2\2GH\3\2\2\2H\t\3\2\2\2IJ\7\32"+
		"\2\2JK\7\"\2\2KL\5\36\20\2LM\7#\2\2MN\5\6\4\2N\13\3\2\2\2O]\5\4\3\2PQ"+
		"\5\16\b\2QR\7!\2\2R]\3\2\2\2ST\5\32\16\2TU\7!\2\2U]\3\2\2\2VW\5\34\17"+
		"\2WX\7!\2\2X]\3\2\2\2YZ\5&\24\2Z[\7!\2\2[]\3\2\2\2\\O\3\2\2\2\\P\3\2\2"+
		"\2\\S\3\2\2\2\\V\3\2\2\2\\Y\3\2\2\2]\r\3\2\2\2^c\5\26\f\2_c\5\24\13\2"+
		"`c\5\22\n\2ac\5\20\t\2b^\3\2\2\2b_\3\2\2\2b`\3\2\2\2ba\3\2\2\2c\17\3\2"+
		"\2\2di\7-\2\2ef\7(\2\2fh\7-\2\2ge\3\2\2\2hk\3\2\2\2ig\3\2\2\2ij\3\2\2"+
		"\2jl\3\2\2\2ki\3\2\2\2lm\7 \2\2m\177\5\30\r\2np\7\37\2\2on\3\2\2\2op\3"+
		"\2\2\2pq\3\2\2\2qv\7-\2\2rs\7(\2\2su\7-\2\2tr\3\2\2\2ux\3\2\2\2vt\3\2"+
		"\2\2vw\3\2\2\2wy\3\2\2\2xv\3\2\2\2yz\7 \2\2z{\5\30\r\2{|\7\3\2\2|}\5\36"+
		"\20\2}\177\3\2\2\2~d\3\2\2\2~o\3\2\2\2\177\21\3\2\2\2\u0080\u0081\7\35"+
		"\2\2\u0081\u0082\7-\2\2\u0082\u008b\7$\2\2\u0083\u0088\7-\2\2\u0084\u0085"+
		"\7(\2\2\u0085\u0087\7-\2\2\u0086\u0084\3\2\2\2\u0087\u008a\3\2\2\2\u0088"+
		"\u0086\3\2\2\2\u0088\u0089\3\2\2\2\u0089\u008c\3\2\2\2\u008a\u0088\3\2"+
		"\2\2\u008b\u0083\3\2\2\2\u008b\u008c\3\2\2\2\u008c\u008d\3\2\2\2\u008d"+
		"\u008e\7%\2\2\u008e\23\3\2\2\2\u008f\u0090\7\33\2\2\u0090\u0091\7-\2\2"+
		"\u0091\u009e\7\"\2\2\u0092\u0093\7-\2\2\u0093\u0094\7 \2\2\u0094\u009b"+
		"\5\30\r\2\u0095\u0096\7(\2\2\u0096\u0097\7-\2\2\u0097\u0098\7 \2\2\u0098"+
		"\u009a\5\30\r\2\u0099\u0095\3\2\2\2\u009a\u009d\3\2\2\2\u009b\u0099\3"+
		"\2\2\2\u009b\u009c\3\2\2\2\u009c\u009f\3\2\2\2\u009d\u009b\3\2\2\2\u009e"+
		"\u0092\3\2\2\2\u009e\u009f\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\u00a1\7#"+
		"\2\2\u00a1\u00a5\7$\2\2\u00a2\u00a4\5\f\7\2\u00a3\u00a2\3\2\2\2\u00a4"+
		"\u00a7\3\2\2\2\u00a5\u00a3\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\u00ac\3\2"+
		"\2\2\u00a7\u00a5\3\2\2\2\u00a8\u00a9\7\36\2\2\u00a9\u00aa\5\36\20\2\u00aa"+
		"\u00ab\7!\2\2\u00ab\u00ad\3\2\2\2\u00ac\u00a8\3\2\2\2\u00ac\u00ad\3\2"+
		"\2\2\u00ad\u00ae\3\2\2\2\u00ae\u00af\7%\2\2\u00af\25\3\2\2\2\u00b0\u00b1"+
		"\7\34\2\2\u00b1\u00b2\7-\2\2\u00b2\u00bf\7$\2\2\u00b3\u00b4\7-\2\2\u00b4"+
		"\u00b5\7 \2\2\u00b5\u00bc\5\30\r\2\u00b6\u00b7\7(\2\2\u00b7\u00b8\7-\2"+
		"\2\u00b8\u00b9\7 \2\2\u00b9\u00bb\5\30\r\2\u00ba\u00b6\3\2\2\2\u00bb\u00be"+
		"\3\2\2\2\u00bc\u00ba\3\2\2\2\u00bc\u00bd\3\2\2\2\u00bd\u00c0\3\2\2\2\u00be"+
		"\u00bc\3\2\2\2\u00bf\u00b3\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0\u00c1\3\2"+
		"\2\2\u00c1\u00c2\7%\2\2\u00c2\27\3\2\2\2\u00c3\u00c9\7-\2\2\u00c4\u00c5"+
		"\7&\2\2\u00c5\u00c6\7.\2\2\u00c6\u00c7\7\'\2\2\u00c7\u00c9\5\30\r\2\u00c8"+
		"\u00c3\3\2\2\2\u00c8\u00c4\3\2\2\2\u00c9\31\3\2\2\2\u00ca\u00cb\5\"\22"+
		"\2\u00cb\u00cc\7\3\2\2\u00cc\u00ce\3\2\2\2\u00cd\u00ca\3\2\2\2\u00ce\u00cf"+
		"\3\2\2\2\u00cf\u00cd\3\2\2\2\u00cf\u00d0\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1"+
		"\u00d2\5\36\20\2\u00d2\33\3\2\2\2\u00d3\u00d4\5\"\22\2\u00d4\u00d5\7\4"+
		"\2\2\u00d5\u00d6\5\"\22\2\u00d6\35\3\2\2\2\u00d7\u00d8\b\20\1\2\u00d8"+
		"\u00d9\7\22\2\2\u00d9\u00fe\5\36\20\2\u00da\u00fe\5 \21\2\u00db\u00dc"+
		"\5 \21\2\u00dc\u00dd\7\16\2\2\u00dd\u00de\5 \21\2\u00de\u00df\7\20\2\2"+
		"\u00df\u00e0\5 \21\2\u00e0\u00fe\3\2\2\2\u00e1\u00e4\5 \21\2\u00e2\u00e3"+
		"\7\f\2\2\u00e3\u00e5\5 \21\2\u00e4\u00e2\3\2\2\2\u00e5\u00e6\3\2\2\2\u00e6"+
		"\u00e4\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e7\u00fe\3\2\2\2\u00e8\u00eb\5 "+
		"\21\2\u00e9\u00ea\7\r\2\2\u00ea\u00ec\5 \21\2\u00eb\u00e9\3\2\2\2\u00ec"+
		"\u00ed\3\2\2\2\u00ed\u00eb\3\2\2\2\u00ed\u00ee\3\2\2\2\u00ee\u00fe\3\2"+
		"\2\2\u00ef\u00f2\5 \21\2\u00f0\u00f1\7\n\2\2\u00f1\u00f3\5 \21\2\u00f2"+
		"\u00f0\3\2\2\2\u00f3\u00f4\3\2\2\2\u00f4\u00f2\3\2\2\2\u00f4\u00f5\3\2"+
		"\2\2\u00f5\u00fe\3\2\2\2\u00f6\u00f9\5 \21\2\u00f7\u00f8\7\13\2\2\u00f8"+
		"\u00fa\5 \21\2\u00f9\u00f7\3\2\2\2\u00fa\u00fb\3\2\2\2\u00fb\u00f9\3\2"+
		"\2\2\u00fb\u00fc\3\2\2\2\u00fc\u00fe\3\2\2\2\u00fd\u00d7\3\2\2\2\u00fd"+
		"\u00da\3\2\2\2\u00fd\u00db\3\2\2\2\u00fd\u00e1\3\2\2\2\u00fd\u00e8\3\2"+
		"\2\2\u00fd\u00ef\3\2\2\2\u00fd\u00f6\3\2\2\2\u00fe\u010f\3\2\2\2\u00ff"+
		"\u0102\6\20\2\3\u0100\u0101\7\16\2\2\u0101\u0103\5\36\20\2\u0102\u0100"+
		"\3\2\2\2\u0103\u0104\3\2\2\2\u0104\u0102\3\2\2\2\u0104\u0105\3\2\2\2\u0105"+
		"\u010e\3\2\2\2\u0106\u0109\6\20\3\3\u0107\u0108\7\17\2\2\u0108\u010a\5"+
		"\36\20\2\u0109\u0107\3\2\2\2\u010a\u010b\3\2\2\2\u010b\u0109\3\2\2\2\u010b"+
		"\u010c\3\2\2\2\u010c\u010e\3\2\2\2\u010d\u00ff\3\2\2\2\u010d\u0106\3\2"+
		"\2\2\u010e\u0111\3\2\2\2\u010f\u010d\3\2\2\2\u010f\u0110\3\2\2\2\u0110"+
		"\37\3\2\2\2\u0111\u010f\3\2\2\2\u0112\u0113\b\21\1\2\u0113\u0114\t\2\2"+
		"\2\u0114\u0117\5 \21\2\u0115\u0117\5$\23\2\u0116\u0112\3\2\2\2\u0116\u0115"+
		"\3\2\2\2\u0117\u0123\3\2\2\2\u0118\u0119\6\21\4\3\u0119\u011a\7\21\2\2"+
		"\u011a\u0122\5 \21\2\u011b\u011c\6\21\5\3\u011c\u011d\t\3\2\2\u011d\u0122"+
		"\5 \21\2\u011e\u011f\6\21\6\3\u011f\u0120\t\2\2\2\u0120\u0122\5 \21\2"+
		"\u0121\u0118\3\2\2\2\u0121\u011b\3\2\2\2\u0121\u011e\3\2\2\2\u0122\u0125"+
		"\3\2\2\2\u0123\u0121\3\2\2\2\u0123\u0124\3\2\2\2\u0124!\3\2\2\2\u0125"+
		"\u0123\3\2\2\2\u0126\u0127\b\22\1\2\u0127\u0128\7-\2\2\u0128\u012d\3\2"+
		"\2\2\u0129\u012a\6\22\7\3\u012a\u012c\5(\25\2\u012b\u0129\3\2\2\2\u012c"+
		"\u012f\3\2\2\2\u012d\u012b\3\2\2\2\u012d\u012e\3\2\2\2\u012e#\3\2\2\2"+
		"\u012f\u012d\3\2\2\2\u0130\u0131\b\23\1\2\u0131\u0132\7\"\2\2\u0132\u0133"+
		"\5\32\16\2\u0133\u0134\7#\2\2\u0134\u0142\3\2\2\2\u0135\u0136\7\"\2\2"+
		"\u0136\u0137\5\36\20\2\u0137\u0138\7#\2\2\u0138\u0142\3\2\2\2\u0139\u013a"+
		"\7\35\2\2\u013a\u013b\7)\2\2\u013b\u013c\7-\2\2\u013c\u013d\7)\2\2\u013d"+
		"\u0142\7-\2\2\u013e\u0142\5\"\22\2\u013f\u0142\5&\24\2\u0140\u0142\5*"+
		"\26\2\u0141\u0130\3\2\2\2\u0141\u0135\3\2\2\2\u0141\u0139\3\2\2\2\u0141"+
		"\u013e\3\2\2\2\u0141\u013f\3\2\2\2\u0141\u0140\3\2\2\2\u0142\u0147\3\2"+
		"\2\2\u0143\u0144\6\23\b\3\u0144\u0146\5(\25\2\u0145\u0143\3\2\2\2\u0146"+
		"\u0149\3\2\2\2\u0147\u0145\3\2\2\2\u0147\u0148\3\2\2\2\u0148%\3\2\2\2"+
		"\u0149\u0147\3\2\2\2\u014a\u014b\7-\2\2\u014b\u0154\7\"\2\2\u014c\u0151"+
		"\5\36\20\2\u014d\u014e\7(\2\2\u014e\u0150\5\36\20\2\u014f\u014d\3\2\2"+
		"\2\u0150\u0153\3\2\2\2\u0151\u014f\3\2\2\2\u0151\u0152\3\2\2\2\u0152\u0155"+
		"\3\2\2\2\u0153\u0151\3\2\2\2\u0154\u014c\3\2\2\2\u0154\u0155\3\2\2\2\u0155"+
		"\u0156\3\2\2\2\u0156\u0157\7#\2\2\u0157\'\3\2\2\2\u0158\u0159\7)\2\2\u0159"+
		"\u015f\7-\2\2\u015a\u015b\7&\2\2\u015b\u015c\5\36\20\2\u015c\u015d\7\'"+
		"\2\2\u015d\u015f\3\2\2\2\u015e\u0158\3\2\2\2\u015e\u015a\3\2\2\2\u015f"+
		")\3\2\2\2\u0160\u017e\7.\2\2\u0161\u017e\7,\2\2\u0162\u017e\7+\2\2\u0163"+
		"\u017e\7*\2\2\u0164\u016d\7&\2\2\u0165\u016a\5\36\20\2\u0166\u0167\7("+
		"\2\2\u0167\u0169\5\36\20\2\u0168\u0166\3\2\2\2\u0169\u016c\3\2\2\2\u016a"+
		"\u0168\3\2\2\2\u016a\u016b\3\2\2\2\u016b\u016e\3\2\2\2\u016c\u016a\3\2"+
		"\2\2\u016d\u0165\3\2\2\2\u016d\u016e\3\2\2\2\u016e\u016f\3\2\2\2\u016f"+
		"\u017e\7\'\2\2\u0170\u0171\7-\2\2\u0171\u017a\7$\2\2\u0172\u0177\5\32"+
		"\16\2\u0173\u0174\7(\2\2\u0174\u0176\5\32\16\2\u0175\u0173\3\2\2\2\u0176"+
		"\u0179\3\2\2\2\u0177\u0175\3\2\2\2\u0177\u0178\3\2\2\2\u0178\u017b\3\2"+
		"\2\2\u0179\u0177\3\2\2\2\u017a\u0172\3\2\2\2\u017a\u017b\3\2\2\2\u017b"+
		"\u017c\3\2\2\2\u017c\u017e\7%\2\2\u017d\u0160\3\2\2\2\u017d\u0161\3\2"+
		"\2\2\u017d\u0162\3\2\2\2\u017d\u0163\3\2\2\2\u017d\u0164\3\2\2\2\u017d"+
		"\u0170\3\2\2\2\u017e+\3\2\2\2-/\65;G\\biov~\u0088\u008b\u009b\u009e\u00a5"+
		"\u00ac\u00bc\u00bf\u00c8\u00cf\u00e6\u00ed\u00f4\u00fb\u00fd\u0104\u010b"+
		"\u010d\u010f\u0116\u0121\u0123\u012d\u0141\u0147\u0151\u0154\u015e\u016a"+
		"\u016d\u0177\u017a\u017d";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}