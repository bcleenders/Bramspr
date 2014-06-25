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
		FUNCTION=25, LOGIC=20, WHILE=24, PUTINT=31, NOT=16, AND=17, PUTCHAR=32, 
		CHARACTER=50, IF=21, TYPE=26, PUTSTRING=34, FINAL=37, THEN=22, SMALLER_THAN=8, 
		RIGHT_PARENTHESIS=41, COMMA=46, IDENTIFIER=51, LEFT_PARENTHESIS=40, RETURN=36, 
		DIVISION=6, BLOCKCOMMENT=54, PLUS=3, GREATER_THAN_EQUALS_TO=11, COMMENT=53, 
		DOT=47, RIGHT_BRACE=43, XOR=19, GETBOOL=30, GREATER_THAN=10, GETCHAR=29, 
		SWAP=2, ELSE=23, PLUSMINUS=14, NUMBER=52, BOOL=48, BECOMES=1, WHITESPACE=55, 
		POWER=15, PUTBOOL=33, SEMICOLON=39, MINUS=4, PRINT=27, EQUALS_TO=12, GETINT=28, 
		LEFT_BLOCKBRACE=44, RIGHT_BLOCKBRACE=45, COLON=38, ENUM=35, MODULUS=7, 
		LEFT_BRACE=42, OR=18, MULTIPLICATION=5, NOT_EQUALS_TO=13, SMALLER_THAN_EQUALS_TO=9, 
		STRING=49;
	public static final String[] tokenNames = {
		"<INVALID>", "':='", "'<>'", "'+'", "'-'", "'*'", "'/'", "'%'", "'<'", 
		"'<='", "'>'", "'>='", "'='", "'=/='", "'+-'", "'^'", "'!'", "'&'", "'|'", 
		"'!&'", "LOGIC", "'if'", "'then'", "'else'", "'while'", "'function'", 
		"'type'", "'print'", "'getInt'", "'getChar'", "'getBool'", "'putInt'", 
		"'putChar'", "'putBool'", "'putString'", "'enum'", "'return'", "'final'", 
		"':'", "';'", "'('", "')'", "'{'", "'}'", "'['", "']'", "','", "'.'", 
		"BOOL", "STRING", "CHARACTER", "IDENTIFIER", "NUMBER", "COMMENT", "BLOCKCOMMENT", 
		"WHITESPACE"
	};
	public static final int
		RULE_program = 0, RULE_structure = 1, RULE_blockStructure = 2, RULE_ifStructure = 3, 
		RULE_whileStructure = 4, RULE_statement = 5, RULE_declaration = 6, RULE_variableDeclaration = 7, 
		RULE_enumerationDeclaration = 8, RULE_functionDeclaration = 9, RULE_typeDeclaration = 10, 
		RULE_typeDenoter = 11, RULE_assignment = 12, RULE_swap = 13, RULE_expression = 14, 
		RULE_arithmetic = 15, RULE_assignable = 16, RULE_atomic = 17, RULE_functionCall = 18, 
		RULE_fieldAccess = 19, RULE_literal = 20, RULE_arrayLiteral = 21, RULE_compositeLiteral = 22;
	public static final String[] ruleNames = {
		"program", "structure", "blockStructure", "ifStructure", "whileStructure", 
		"statement", "declaration", "variableDeclaration", "enumerationDeclaration", 
		"functionDeclaration", "typeDeclaration", "typeDenoter", "assignment", 
		"swap", "expression", "arithmetic", "assignable", "atomic", "functionCall", 
		"fieldAccess", "literal", "arrayLiteral", "compositeLiteral"
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
			setState(49);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << FUNCTION) | (1L << TYPE) | (1L << ENUM) | (1L << FINAL) | (1L << LEFT_BRACE) | (1L << IDENTIFIER))) != 0)) {
				{
				{
				setState(46); statement();
				}
				}
				setState(51);
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
			setState(55);
			switch (_input.LA(1)) {
			case LEFT_BRACE:
				enterOuterAlt(_localctx, 1);
				{
				setState(52); blockStructure();
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 2);
				{
				setState(53); ifStructure();
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 3);
				{
				setState(54); whileStructure();
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
			setState(57); match(LEFT_BRACE);
			setState(61);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << FUNCTION) | (1L << TYPE) | (1L << ENUM) | (1L << FINAL) | (1L << LEFT_BRACE) | (1L << IDENTIFIER))) != 0)) {
				{
				{
				setState(58); statement();
				}
				}
				setState(63);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(64); match(RIGHT_BRACE);
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
			setState(66); match(IF);
			setState(67); match(LEFT_PARENTHESIS);
			setState(68); expression(0);
			setState(69); match(RIGHT_PARENTHESIS);
			setState(70); blockStructure();
			setState(73);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(71); match(ELSE);
				setState(72); blockStructure();
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
			setState(75); match(WHILE);
			setState(76); match(LEFT_PARENTHESIS);
			setState(77); expression(0);
			setState(78); match(RIGHT_PARENTHESIS);
			setState(79); blockStructure();
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
			setState(94);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(81); structure();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(82); declaration();
				setState(83); match(SEMICOLON);
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(85); assignment();
				setState(86); match(SEMICOLON);
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(88); swap();
				setState(89); match(SEMICOLON);
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(91); functionCall();
				setState(92); match(SEMICOLON);
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
			setState(100);
			switch (_input.LA(1)) {
			case TYPE:
				enterOuterAlt(_localctx, 1);
				{
				setState(96); typeDeclaration();
				}
				break;
			case FUNCTION:
				enterOuterAlt(_localctx, 2);
				{
				setState(97); functionDeclaration();
				}
				break;
			case ENUM:
				enterOuterAlt(_localctx, 3);
				{
				setState(98); enumerationDeclaration();
				}
				break;
			case FINAL:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 4);
				{
				setState(99); variableDeclaration();
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
			setState(128);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(102); match(IDENTIFIER);
				setState(107);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(103); match(COMMA);
					setState(104); match(IDENTIFIER);
					}
					}
					setState(109);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(110); match(COLON);
				setState(111); typeDenoter();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(113);
				_la = _input.LA(1);
				if (_la==FINAL) {
					{
					setState(112); match(FINAL);
					}
				}

				setState(115); match(IDENTIFIER);
				setState(120);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(116); match(COMMA);
					setState(117); match(IDENTIFIER);
					}
					}
					setState(122);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(123); match(COLON);
				setState(124); typeDenoter();
				setState(125); match(BECOMES);
				setState(126); expression(0);
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
			setState(130); match(ENUM);
			setState(131); match(IDENTIFIER);
			setState(132); match(LEFT_BRACE);
			setState(141);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(133); match(IDENTIFIER);
				setState(138);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(134); match(COMMA);
					setState(135); match(IDENTIFIER);
					}
					}
					setState(140);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
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
			setState(145); match(FUNCTION);
			setState(146); match(IDENTIFIER);
			setState(147); match(LEFT_PARENTHESIS);
			setState(160);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(148); match(IDENTIFIER);
				setState(149); match(COLON);
				setState(150); typeDenoter();
				setState(157);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(151); match(COMMA);
					setState(152); match(IDENTIFIER);
					setState(153); match(COLON);
					setState(154); typeDenoter();
					}
					}
					setState(159);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(162); match(RIGHT_PARENTHESIS);
			setState(163); match(LEFT_BRACE);
			setState(167);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << FUNCTION) | (1L << TYPE) | (1L << ENUM) | (1L << FINAL) | (1L << LEFT_BRACE) | (1L << IDENTIFIER))) != 0)) {
				{
				{
				setState(164); statement();
				}
				}
				setState(169);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(174);
			_la = _input.LA(1);
			if (_la==RETURN) {
				{
				setState(170); match(RETURN);
				setState(171); expression(0);
				setState(172); match(SEMICOLON);
				}
			}

			setState(176); match(RIGHT_BRACE);
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
			setState(178); match(TYPE);
			setState(179); match(IDENTIFIER);
			setState(180); match(LEFT_BRACE);
			setState(193);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(181); match(IDENTIFIER);
				setState(182); match(COLON);
				setState(183); typeDenoter();
				setState(190);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(184); match(COMMA);
					setState(185); match(IDENTIFIER);
					setState(186); match(COLON);
					setState(187); typeDenoter();
					}
					}
					setState(192);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(195); match(RIGHT_BRACE);
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
			setState(202);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				_localctx = new BaseTypeDenoterContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(197); match(IDENTIFIER);
				}
				break;
			case LEFT_BLOCKBRACE:
				_localctx = new ArrayTypeDenoterContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(198); match(LEFT_BLOCKBRACE);
				setState(199); match(NUMBER);
				setState(200); match(RIGHT_BLOCKBRACE);
				setState(201); typeDenoter();
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
			setState(207); 
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(204); assignable(0);
					setState(205); match(BECOMES);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(209); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			} while ( _alt!=2 && _alt!=-1 );
			setState(211); expression(0);
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
			setState(213); assignable(0);
			setState(214); match(SWAP);
			setState(215); assignable(0);
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
			setState(255);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				{
				_localctx = new NotExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(218); match(NOT);
				setState(219); expression(9);
				}
				break;

			case 2:
				{
				_localctx = new ArithmeticExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(220); arithmetic(0);
				}
				break;

			case 3:
				{
				_localctx = new PlusMinusExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(221); arithmetic(0);
				setState(222); match(EQUALS_TO);
				setState(223); arithmetic(0);
				setState(224); match(PLUSMINUS);
				setState(225); arithmetic(0);
				}
				break;

			case 4:
				{
				_localctx = new GreaterThanExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(227); arithmetic(0);
				setState(230); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(228); match(GREATER_THAN);
						setState(229); arithmetic(0);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(232); 
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
				setState(234); arithmetic(0);
				setState(237); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(235); match(GREATER_THAN_EQUALS_TO);
						setState(236); arithmetic(0);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(239); 
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
				setState(241); arithmetic(0);
				setState(244); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(242); match(SMALLER_THAN);
						setState(243); arithmetic(0);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(246); 
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
				setState(248); arithmetic(0);
				setState(251); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(249); match(SMALLER_THAN_EQUALS_TO);
						setState(250); arithmetic(0);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(253); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
				} while ( _alt!=2 && _alt!=-1 );
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(273);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(271);
					switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
					case 1:
						{
						_localctx = new EqualsToExpressionContext(new ExpressionContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(257);
						if (!(7 >= _localctx._p)) throw new FailedPredicateException(this, "7 >= $_p");
						setState(260); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(258); match(EQUALS_TO);
								setState(259); expression(0);
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(262); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
						} while ( _alt!=2 && _alt!=-1 );
						}
						break;

					case 2:
						{
						_localctx = new NotEqualsToExpressionContext(new ExpressionContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(264);
						if (!(6 >= _localctx._p)) throw new FailedPredicateException(this, "6 >= $_p");
						setState(267); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(265); match(NOT_EQUALS_TO);
								setState(266); expression(0);
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(269); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
						} while ( _alt!=2 && _alt!=-1 );
						}
						break;
					}
					} 
				}
				setState(275);
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
			setState(280);
			switch (_input.LA(1)) {
			case PLUS:
			case MINUS:
				{
				_localctx = new SignExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(277);
				_la = _input.LA(1);
				if ( !(_la==PLUS || _la==MINUS) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(278); arithmetic(4);
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
				setState(279); atomic(0);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(293);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(291);
					switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
					case 1:
						{
						_localctx = new PowerExpressionContext(new ArithmeticContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_arithmetic);
						setState(282);
						if (!(3 >= _localctx._p)) throw new FailedPredicateException(this, "3 >= $_p");
						setState(283); match(POWER);
						setState(284); arithmetic(3);
						}
						break;

					case 2:
						{
						_localctx = new MultiplicationExpressionContext(new ArithmeticContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_arithmetic);
						setState(285);
						if (!(2 >= _localctx._p)) throw new FailedPredicateException(this, "2 >= $_p");
						setState(286);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MULTIPLICATION) | (1L << DIVISION) | (1L << MODULUS))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(287); arithmetic(3);
						}
						break;

					case 3:
						{
						_localctx = new AdditionExpressionContext(new ArithmeticContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_arithmetic);
						setState(288);
						if (!(1 >= _localctx._p)) throw new FailedPredicateException(this, "1 >= $_p");
						setState(289);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(290); arithmetic(2);
						}
						break;
					}
					} 
				}
				setState(295);
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

			setState(297); match(IDENTIFIER);
			}
			_ctx.stop = _input.LT(-1);
			setState(303);
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
					setState(299);
					if (!(2 >= _localctx._p)) throw new FailedPredicateException(this, "2 >= $_p");
					setState(300); fieldAccess();
					}
					} 
				}
				setState(305);
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
			setState(323);
			switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
			case 1:
				{
				_localctx = new AssignmentExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(307); match(LEFT_PARENTHESIS);
				setState(308); assignment();
				setState(309); match(RIGHT_PARENTHESIS);
				}
				break;

			case 2:
				{
				_localctx = new ParenthesisExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(311); match(LEFT_PARENTHESIS);
				setState(312); expression(0);
				setState(313); match(RIGHT_PARENTHESIS);
				}
				break;

			case 3:
				{
				_localctx = new ExplicitEnumExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(315); match(ENUM);
				setState(316); match(DOT);
				setState(317); match(IDENTIFIER);
				setState(318); match(DOT);
				setState(319); match(IDENTIFIER);
				}
				break;

			case 4:
				{
				_localctx = new AssignableExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(320); assignable(0);
				}
				break;

			case 5:
				{
				_localctx = new FunctionCallExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(321); functionCall();
				}
				break;

			case 6:
				{
				_localctx = new LiteralExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(322); literal();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(329);
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
					setState(325);
					if (!(1 >= _localctx._p)) throw new FailedPredicateException(this, "1 >= $_p");
					setState(326); fieldAccess();
					}
					} 
				}
				setState(331);
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
			setState(332); match(IDENTIFIER);
			setState(333); match(LEFT_PARENTHESIS);
			setState(342);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PLUS) | (1L << MINUS) | (1L << NOT) | (1L << ENUM) | (1L << LEFT_PARENTHESIS) | (1L << LEFT_BLOCKBRACE) | (1L << BOOL) | (1L << STRING) | (1L << CHARACTER) | (1L << IDENTIFIER) | (1L << NUMBER))) != 0)) {
				{
				setState(334); expression(0);
				setState(339);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(335); match(COMMA);
					setState(336); expression(0);
					}
					}
					setState(341);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(344); match(RIGHT_PARENTHESIS);
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
			setState(352);
			switch (_input.LA(1)) {
			case DOT:
				enterOuterAlt(_localctx, 1);
				{
				setState(346); match(DOT);
				setState(347); match(IDENTIFIER);
				}
				break;
			case LEFT_BLOCKBRACE:
				enterOuterAlt(_localctx, 2);
				{
				setState(348); match(LEFT_BLOCKBRACE);
				setState(349); expression(0);
				setState(350); match(RIGHT_BLOCKBRACE);
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
		public TerminalNode BOOL() { return getToken(BramsprParser.BOOL, 0); }
		public CompositeLiteralContext compositeLiteral() {
			return getRuleContext(CompositeLiteralContext.class,0);
		}
		public ArrayLiteralContext arrayLiteral() {
			return getRuleContext(ArrayLiteralContext.class,0);
		}
		public TerminalNode CHARACTER() { return getToken(BramsprParser.CHARACTER, 0); }
		public TerminalNode NUMBER() { return getToken(BramsprParser.NUMBER, 0); }
		public TerminalNode STRING() { return getToken(BramsprParser.STRING, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_literal);
		try {
			setState(360);
			switch (_input.LA(1)) {
			case NUMBER:
				enterOuterAlt(_localctx, 1);
				{
				setState(354); match(NUMBER);
				}
				break;
			case CHARACTER:
				enterOuterAlt(_localctx, 2);
				{
				setState(355); match(CHARACTER);
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 3);
				{
				setState(356); match(STRING);
				}
				break;
			case BOOL:
				enterOuterAlt(_localctx, 4);
				{
				setState(357); match(BOOL);
				}
				break;
			case LEFT_BLOCKBRACE:
				enterOuterAlt(_localctx, 5);
				{
				setState(358); arrayLiteral();
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 6);
				{
				setState(359); compositeLiteral();
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

	public static class ArrayLiteralContext extends ParserRuleContext {
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
		public ArrayLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayLiteral; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitArrayLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayLiteralContext arrayLiteral() throws RecognitionException {
		ArrayLiteralContext _localctx = new ArrayLiteralContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_arrayLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(362); match(LEFT_BLOCKBRACE);
			setState(371);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PLUS) | (1L << MINUS) | (1L << NOT) | (1L << ENUM) | (1L << LEFT_PARENTHESIS) | (1L << LEFT_BLOCKBRACE) | (1L << BOOL) | (1L << STRING) | (1L << CHARACTER) | (1L << IDENTIFIER) | (1L << NUMBER))) != 0)) {
				{
				setState(363); expression(0);
				setState(368);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(364); match(COMMA);
					setState(365); expression(0);
					}
					}
					setState(370);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(373); match(RIGHT_BLOCKBRACE);
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

	public static class CompositeLiteralContext extends ParserRuleContext {
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
		public CompositeLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compositeLiteral; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitCompositeLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompositeLiteralContext compositeLiteral() throws RecognitionException {
		CompositeLiteralContext _localctx = new CompositeLiteralContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_compositeLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(375); match(IDENTIFIER);
			setState(376); match(LEFT_BRACE);
			setState(385);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(377); assignment();
				setState(382);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(378); match(COMMA);
					setState(379); assignment();
					}
					}
					setState(384);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(387); match(RIGHT_BRACE);
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
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\39\u0188\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\3\2\7\2\62"+
		"\n\2\f\2\16\2\65\13\2\3\3\3\3\3\3\5\3:\n\3\3\4\3\4\7\4>\n\4\f\4\16\4A"+
		"\13\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5L\n\5\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7a\n\7\3\b"+
		"\3\b\3\b\3\b\5\bg\n\b\3\t\3\t\3\t\7\tl\n\t\f\t\16\to\13\t\3\t\3\t\3\t"+
		"\5\tt\n\t\3\t\3\t\3\t\7\ty\n\t\f\t\16\t|\13\t\3\t\3\t\3\t\3\t\3\t\5\t"+
		"\u0083\n\t\3\n\3\n\3\n\3\n\3\n\3\n\7\n\u008b\n\n\f\n\16\n\u008e\13\n\5"+
		"\n\u0090\n\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\7\13\u009e\n\13\f\13\16\13\u00a1\13\13\5\13\u00a3\n\13\3\13\3\13\3\13"+
		"\7\13\u00a8\n\13\f\13\16\13\u00ab\13\13\3\13\3\13\3\13\3\13\5\13\u00b1"+
		"\n\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\7\f\u00bf\n\f"+
		"\f\f\16\f\u00c2\13\f\5\f\u00c4\n\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\5\r\u00cd"+
		"\n\r\3\16\3\16\3\16\6\16\u00d2\n\16\r\16\16\16\u00d3\3\16\3\16\3\17\3"+
		"\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3"+
		"\20\3\20\6\20\u00e9\n\20\r\20\16\20\u00ea\3\20\3\20\3\20\6\20\u00f0\n"+
		"\20\r\20\16\20\u00f1\3\20\3\20\3\20\6\20\u00f7\n\20\r\20\16\20\u00f8\3"+
		"\20\3\20\3\20\6\20\u00fe\n\20\r\20\16\20\u00ff\5\20\u0102\n\20\3\20\3"+
		"\20\3\20\6\20\u0107\n\20\r\20\16\20\u0108\3\20\3\20\3\20\6\20\u010e\n"+
		"\20\r\20\16\20\u010f\7\20\u0112\n\20\f\20\16\20\u0115\13\20\3\21\3\21"+
		"\3\21\3\21\5\21\u011b\n\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\7\21\u0126\n\21\f\21\16\21\u0129\13\21\3\22\3\22\3\22\3\22\3\22\7\22"+
		"\u0130\n\22\f\22\16\22\u0133\13\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u0146\n\23\3\23"+
		"\3\23\7\23\u014a\n\23\f\23\16\23\u014d\13\23\3\24\3\24\3\24\3\24\3\24"+
		"\7\24\u0154\n\24\f\24\16\24\u0157\13\24\5\24\u0159\n\24\3\24\3\24\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\5\25\u0163\n\25\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\5\26\u016b\n\26\3\27\3\27\3\27\3\27\7\27\u0171\n\27\f\27\16\27\u0174"+
		"\13\27\5\27\u0176\n\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\7\30\u017f\n"+
		"\30\f\30\16\30\u0182\13\30\5\30\u0184\n\30\3\30\3\30\3\30\2\31\2\4\6\b"+
		"\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\2\4\3\2\5\6\3\2\7\t\u01af\2\63"+
		"\3\2\2\2\49\3\2\2\2\6;\3\2\2\2\bD\3\2\2\2\nM\3\2\2\2\f`\3\2\2\2\16f\3"+
		"\2\2\2\20\u0082\3\2\2\2\22\u0084\3\2\2\2\24\u0093\3\2\2\2\26\u00b4\3\2"+
		"\2\2\30\u00cc\3\2\2\2\32\u00d1\3\2\2\2\34\u00d7\3\2\2\2\36\u0101\3\2\2"+
		"\2 \u011a\3\2\2\2\"\u012a\3\2\2\2$\u0145\3\2\2\2&\u014e\3\2\2\2(\u0162"+
		"\3\2\2\2*\u016a\3\2\2\2,\u016c\3\2\2\2.\u0179\3\2\2\2\60\62\5\f\7\2\61"+
		"\60\3\2\2\2\62\65\3\2\2\2\63\61\3\2\2\2\63\64\3\2\2\2\64\3\3\2\2\2\65"+
		"\63\3\2\2\2\66:\5\6\4\2\67:\5\b\5\28:\5\n\6\29\66\3\2\2\29\67\3\2\2\2"+
		"98\3\2\2\2:\5\3\2\2\2;?\7,\2\2<>\5\f\7\2=<\3\2\2\2>A\3\2\2\2?=\3\2\2\2"+
		"?@\3\2\2\2@B\3\2\2\2A?\3\2\2\2BC\7-\2\2C\7\3\2\2\2DE\7\27\2\2EF\7*\2\2"+
		"FG\5\36\20\2GH\7+\2\2HK\5\6\4\2IJ\7\31\2\2JL\5\6\4\2KI\3\2\2\2KL\3\2\2"+
		"\2L\t\3\2\2\2MN\7\32\2\2NO\7*\2\2OP\5\36\20\2PQ\7+\2\2QR\5\6\4\2R\13\3"+
		"\2\2\2Sa\5\4\3\2TU\5\16\b\2UV\7)\2\2Va\3\2\2\2WX\5\32\16\2XY\7)\2\2Ya"+
		"\3\2\2\2Z[\5\34\17\2[\\\7)\2\2\\a\3\2\2\2]^\5&\24\2^_\7)\2\2_a\3\2\2\2"+
		"`S\3\2\2\2`T\3\2\2\2`W\3\2\2\2`Z\3\2\2\2`]\3\2\2\2a\r\3\2\2\2bg\5\26\f"+
		"\2cg\5\24\13\2dg\5\22\n\2eg\5\20\t\2fb\3\2\2\2fc\3\2\2\2fd\3\2\2\2fe\3"+
		"\2\2\2g\17\3\2\2\2hm\7\65\2\2ij\7\60\2\2jl\7\65\2\2ki\3\2\2\2lo\3\2\2"+
		"\2mk\3\2\2\2mn\3\2\2\2np\3\2\2\2om\3\2\2\2pq\7(\2\2q\u0083\5\30\r\2rt"+
		"\7\'\2\2sr\3\2\2\2st\3\2\2\2tu\3\2\2\2uz\7\65\2\2vw\7\60\2\2wy\7\65\2"+
		"\2xv\3\2\2\2y|\3\2\2\2zx\3\2\2\2z{\3\2\2\2{}\3\2\2\2|z\3\2\2\2}~\7(\2"+
		"\2~\177\5\30\r\2\177\u0080\7\3\2\2\u0080\u0081\5\36\20\2\u0081\u0083\3"+
		"\2\2\2\u0082h\3\2\2\2\u0082s\3\2\2\2\u0083\21\3\2\2\2\u0084\u0085\7%\2"+
		"\2\u0085\u0086\7\65\2\2\u0086\u008f\7,\2\2\u0087\u008c\7\65\2\2\u0088"+
		"\u0089\7\60\2\2\u0089\u008b\7\65\2\2\u008a\u0088\3\2\2\2\u008b\u008e\3"+
		"\2\2\2\u008c\u008a\3\2\2\2\u008c\u008d\3\2\2\2\u008d\u0090\3\2\2\2\u008e"+
		"\u008c\3\2\2\2\u008f\u0087\3\2\2\2\u008f\u0090\3\2\2\2\u0090\u0091\3\2"+
		"\2\2\u0091\u0092\7-\2\2\u0092\23\3\2\2\2\u0093\u0094\7\33\2\2\u0094\u0095"+
		"\7\65\2\2\u0095\u00a2\7*\2\2\u0096\u0097\7\65\2\2\u0097\u0098\7(\2\2\u0098"+
		"\u009f\5\30\r\2\u0099\u009a\7\60\2\2\u009a\u009b\7\65\2\2\u009b\u009c"+
		"\7(\2\2\u009c\u009e\5\30\r\2\u009d\u0099\3\2\2\2\u009e\u00a1\3\2\2\2\u009f"+
		"\u009d\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\u00a3\3\2\2\2\u00a1\u009f\3\2"+
		"\2\2\u00a2\u0096\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4"+
		"\u00a5\7+\2\2\u00a5\u00a9\7,\2\2\u00a6\u00a8\5\f\7\2\u00a7\u00a6\3\2\2"+
		"\2\u00a8\u00ab\3\2\2\2\u00a9\u00a7\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa\u00b0"+
		"\3\2\2\2\u00ab\u00a9\3\2\2\2\u00ac\u00ad\7&\2\2\u00ad\u00ae\5\36\20\2"+
		"\u00ae\u00af\7)\2\2\u00af\u00b1\3\2\2\2\u00b0\u00ac\3\2\2\2\u00b0\u00b1"+
		"\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2\u00b3\7-\2\2\u00b3\25\3\2\2\2\u00b4"+
		"\u00b5\7\34\2\2\u00b5\u00b6\7\65\2\2\u00b6\u00c3\7,\2\2\u00b7\u00b8\7"+
		"\65\2\2\u00b8\u00b9\7(\2\2\u00b9\u00c0\5\30\r\2\u00ba\u00bb\7\60\2\2\u00bb"+
		"\u00bc\7\65\2\2\u00bc\u00bd\7(\2\2\u00bd\u00bf\5\30\r\2\u00be\u00ba\3"+
		"\2\2\2\u00bf\u00c2\3\2\2\2\u00c0\u00be\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c1"+
		"\u00c4\3\2\2\2\u00c2\u00c0\3\2\2\2\u00c3\u00b7\3\2\2\2\u00c3\u00c4\3\2"+
		"\2\2\u00c4\u00c5\3\2\2\2\u00c5\u00c6\7-\2\2\u00c6\27\3\2\2\2\u00c7\u00cd"+
		"\7\65\2\2\u00c8\u00c9\7.\2\2\u00c9\u00ca\7\66\2\2\u00ca\u00cb\7/\2\2\u00cb"+
		"\u00cd\5\30\r\2\u00cc\u00c7\3\2\2\2\u00cc\u00c8\3\2\2\2\u00cd\31\3\2\2"+
		"\2\u00ce\u00cf\5\"\22\2\u00cf\u00d0\7\3\2\2\u00d0\u00d2\3\2\2\2\u00d1"+
		"\u00ce\3\2\2\2\u00d2\u00d3\3\2\2\2\u00d3\u00d1\3\2\2\2\u00d3\u00d4\3\2"+
		"\2\2\u00d4\u00d5\3\2\2\2\u00d5\u00d6\5\36\20\2\u00d6\33\3\2\2\2\u00d7"+
		"\u00d8\5\"\22\2\u00d8\u00d9\7\4\2\2\u00d9\u00da\5\"\22\2\u00da\35\3\2"+
		"\2\2\u00db\u00dc\b\20\1\2\u00dc\u00dd\7\22\2\2\u00dd\u0102\5\36\20\2\u00de"+
		"\u0102\5 \21\2\u00df\u00e0\5 \21\2\u00e0\u00e1\7\16\2\2\u00e1\u00e2\5"+
		" \21\2\u00e2\u00e3\7\20\2\2\u00e3\u00e4\5 \21\2\u00e4\u0102\3\2\2\2\u00e5"+
		"\u00e8\5 \21\2\u00e6\u00e7\7\f\2\2\u00e7\u00e9\5 \21\2\u00e8\u00e6\3\2"+
		"\2\2\u00e9\u00ea\3\2\2\2\u00ea\u00e8\3\2\2\2\u00ea\u00eb\3\2\2\2\u00eb"+
		"\u0102\3\2\2\2\u00ec\u00ef\5 \21\2\u00ed\u00ee\7\r\2\2\u00ee\u00f0\5 "+
		"\21\2\u00ef\u00ed\3\2\2\2\u00f0\u00f1\3\2\2\2\u00f1\u00ef\3\2\2\2\u00f1"+
		"\u00f2\3\2\2\2\u00f2\u0102\3\2\2\2\u00f3\u00f6\5 \21\2\u00f4\u00f5\7\n"+
		"\2\2\u00f5\u00f7\5 \21\2\u00f6\u00f4\3\2\2\2\u00f7\u00f8\3\2\2\2\u00f8"+
		"\u00f6\3\2\2\2\u00f8\u00f9\3\2\2\2\u00f9\u0102\3\2\2\2\u00fa\u00fd\5 "+
		"\21\2\u00fb\u00fc\7\13\2\2\u00fc\u00fe\5 \21\2\u00fd\u00fb\3\2\2\2\u00fe"+
		"\u00ff\3\2\2\2\u00ff\u00fd\3\2\2\2\u00ff\u0100\3\2\2\2\u0100\u0102\3\2"+
		"\2\2\u0101\u00db\3\2\2\2\u0101\u00de\3\2\2\2\u0101\u00df\3\2\2\2\u0101"+
		"\u00e5\3\2\2\2\u0101\u00ec\3\2\2\2\u0101\u00f3\3\2\2\2\u0101\u00fa\3\2"+
		"\2\2\u0102\u0113\3\2\2\2\u0103\u0106\6\20\2\3\u0104\u0105\7\16\2\2\u0105"+
		"\u0107\5\36\20\2\u0106\u0104\3\2\2\2\u0107\u0108\3\2\2\2\u0108\u0106\3"+
		"\2\2\2\u0108\u0109\3\2\2\2\u0109\u0112\3\2\2\2\u010a\u010d\6\20\3\3\u010b"+
		"\u010c\7\17\2\2\u010c\u010e\5\36\20\2\u010d\u010b\3\2\2\2\u010e\u010f"+
		"\3\2\2\2\u010f\u010d\3\2\2\2\u010f\u0110\3\2\2\2\u0110\u0112\3\2\2\2\u0111"+
		"\u0103\3\2\2\2\u0111\u010a\3\2\2\2\u0112\u0115\3\2\2\2\u0113\u0111\3\2"+
		"\2\2\u0113\u0114\3\2\2\2\u0114\37\3\2\2\2\u0115\u0113\3\2\2\2\u0116\u0117"+
		"\b\21\1\2\u0117\u0118\t\2\2\2\u0118\u011b\5 \21\2\u0119\u011b\5$\23\2"+
		"\u011a\u0116\3\2\2\2\u011a\u0119\3\2\2\2\u011b\u0127\3\2\2\2\u011c\u011d"+
		"\6\21\4\3\u011d\u011e\7\21\2\2\u011e\u0126\5 \21\2\u011f\u0120\6\21\5"+
		"\3\u0120\u0121\t\3\2\2\u0121\u0126\5 \21\2\u0122\u0123\6\21\6\3\u0123"+
		"\u0124\t\2\2\2\u0124\u0126\5 \21\2\u0125\u011c\3\2\2\2\u0125\u011f\3\2"+
		"\2\2\u0125\u0122\3\2\2\2\u0126\u0129\3\2\2\2\u0127\u0125\3\2\2\2\u0127"+
		"\u0128\3\2\2\2\u0128!\3\2\2\2\u0129\u0127\3\2\2\2\u012a\u012b\b\22\1\2"+
		"\u012b\u012c\7\65\2\2\u012c\u0131\3\2\2\2\u012d\u012e\6\22\7\3\u012e\u0130"+
		"\5(\25\2\u012f\u012d\3\2\2\2\u0130\u0133\3\2\2\2\u0131\u012f\3\2\2\2\u0131"+
		"\u0132\3\2\2\2\u0132#\3\2\2\2\u0133\u0131\3\2\2\2\u0134\u0135\b\23\1\2"+
		"\u0135\u0136\7*\2\2\u0136\u0137\5\32\16\2\u0137\u0138\7+\2\2\u0138\u0146"+
		"\3\2\2\2\u0139\u013a\7*\2\2\u013a\u013b\5\36\20\2\u013b\u013c\7+\2\2\u013c"+
		"\u0146\3\2\2\2\u013d\u013e\7%\2\2\u013e\u013f\7\61\2\2\u013f\u0140\7\65"+
		"\2\2\u0140\u0141\7\61\2\2\u0141\u0146\7\65\2\2\u0142\u0146\5\"\22\2\u0143"+
		"\u0146\5&\24\2\u0144\u0146\5*\26\2\u0145\u0134\3\2\2\2\u0145\u0139\3\2"+
		"\2\2\u0145\u013d\3\2\2\2\u0145\u0142\3\2\2\2\u0145\u0143\3\2\2\2\u0145"+
		"\u0144\3\2\2\2\u0146\u014b\3\2\2\2\u0147\u0148\6\23\b\3\u0148\u014a\5"+
		"(\25\2\u0149\u0147\3\2\2\2\u014a\u014d\3\2\2\2\u014b\u0149\3\2\2\2\u014b"+
		"\u014c\3\2\2\2\u014c%\3\2\2\2\u014d\u014b\3\2\2\2\u014e\u014f\7\65\2\2"+
		"\u014f\u0158\7*\2\2\u0150\u0155\5\36\20\2\u0151\u0152\7\60\2\2\u0152\u0154"+
		"\5\36\20\2\u0153\u0151\3\2\2\2\u0154\u0157\3\2\2\2\u0155\u0153\3\2\2\2"+
		"\u0155\u0156\3\2\2\2\u0156\u0159\3\2\2\2\u0157\u0155\3\2\2\2\u0158\u0150"+
		"\3\2\2\2\u0158\u0159\3\2\2\2\u0159\u015a\3\2\2\2\u015a\u015b\7+\2\2\u015b"+
		"\'\3\2\2\2\u015c\u015d\7\61\2\2\u015d\u0163\7\65\2\2\u015e\u015f\7.\2"+
		"\2\u015f\u0160\5\36\20\2\u0160\u0161\7/\2\2\u0161\u0163\3\2\2\2\u0162"+
		"\u015c\3\2\2\2\u0162\u015e\3\2\2\2\u0163)\3\2\2\2\u0164\u016b\7\66\2\2"+
		"\u0165\u016b\7\64\2\2\u0166\u016b\7\63\2\2\u0167\u016b\7\62\2\2\u0168"+
		"\u016b\5,\27\2\u0169\u016b\5.\30\2\u016a\u0164\3\2\2\2\u016a\u0165\3\2"+
		"\2\2\u016a\u0166\3\2\2\2\u016a\u0167\3\2\2\2\u016a\u0168\3\2\2\2\u016a"+
		"\u0169\3\2\2\2\u016b+\3\2\2\2\u016c\u0175\7.\2\2\u016d\u0172\5\36\20\2"+
		"\u016e\u016f\7\60\2\2\u016f\u0171\5\36\20\2\u0170\u016e\3\2\2\2\u0171"+
		"\u0174\3\2\2\2\u0172\u0170\3\2\2\2\u0172\u0173\3\2\2\2\u0173\u0176\3\2"+
		"\2\2\u0174\u0172\3\2\2\2\u0175\u016d\3\2\2\2\u0175\u0176\3\2\2\2\u0176"+
		"\u0177\3\2\2\2\u0177\u0178\7/\2\2\u0178-\3\2\2\2\u0179\u017a\7\65\2\2"+
		"\u017a\u0183\7,\2\2\u017b\u0180\5\32\16\2\u017c\u017d\7\60\2\2\u017d\u017f"+
		"\5\32\16\2\u017e\u017c\3\2\2\2\u017f\u0182\3\2\2\2\u0180\u017e\3\2\2\2"+
		"\u0180\u0181\3\2\2\2\u0181\u0184\3\2\2\2\u0182\u0180\3\2\2\2\u0183\u017b"+
		"\3\2\2\2\u0183\u0184\3\2\2\2\u0184\u0185\3\2\2\2\u0185\u0186\7-\2\2\u0186"+
		"/\3\2\2\2-\639?K`fmsz\u0082\u008c\u008f\u009f\u00a2\u00a9\u00b0\u00c0"+
		"\u00c3\u00cc\u00d3\u00ea\u00f1\u00f8\u00ff\u0101\u0108\u010f\u0111\u0113"+
		"\u011a\u0125\u0127\u0131\u0145\u014b\u0155\u0158\u0162\u016a\u0172\u0175"+
		"\u0180\u0183";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}