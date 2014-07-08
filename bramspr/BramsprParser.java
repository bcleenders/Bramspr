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
		SWAP=2, PLUSMINUS=14, ELSE=23, NUMBER=44, BECOMES=1, WHITESPACE=47, POWER=15, 
		SEMICOLON=31, NOT=16, MINUS=4, AND=17, CHARACTER=42, EQUALS_TO=12, RIGHT_BLOCKBRACE=37, 
		LEFT_BLOCKBRACE=36, TYPE=26, IF=21, COLON=30, BOOLEAN=40, THEN=22, RIGHT_PARENTHESIS=33, 
		SMALLER_THAN=8, COMMA=38, ENUMERATION=27, IDENTIFIER=43, LEFT_BRACE=34, 
		LEFT_PARENTHESIS=32, MODULUS=7, OR=18, RETURN=28, CONSTANT=29, DIVISION=6, 
		BLOCKCOMMENT=46, MULTIPLICATION=5, PLUS=3, NOT_EQUALS_TO=13, GREATER_THAN_EQUALS_TO=11, 
		COMMENT=45, DOT=39, STRING=41, SMALLER_THAN_EQUALS_TO=9;
	public static final String[] tokenNames = {
		"<INVALID>", "':='", "'<>'", "'+'", "'-'", "'*'", "'/'", "'%'", "'<'", 
		"'<='", "'>'", "'>='", "'='", "'=/='", "'+-'", "'^'", "'!'", "'&'", "'|'", 
		"'!&'", "LOGIC", "'if'", "'then'", "'else'", "'while'", "'function'", 
		"'type'", "'enumeration'", "'return'", "'constant'", "':'", "';'", "'('", 
		"')'", "'{'", "'}'", "'['", "']'", "','", "'.'", "BOOLEAN", "STRING", 
		"CHARACTER", "IDENTIFIER", "NUMBER", "COMMENT", "BLOCKCOMMENT", "WHITESPACE"
	};
	public static final int
		RULE_program = 0, RULE_structure = 1, RULE_blockStructure = 2, RULE_ifStructure = 3, 
		RULE_whileStructure = 4, RULE_statement = 5, RULE_command = 6, RULE_declaration = 7, 
		RULE_variableDeclaration = 8, RULE_enumerationDeclaration = 9, RULE_functionDeclaration = 10, 
		RULE_compositeDeclaration = 11, RULE_typeDenoter = 12, RULE_assignment = 13, 
		RULE_swap = 14, RULE_expression = 15, RULE_arithmetic = 16, RULE_molecule = 17, 
		RULE_atomic = 18, RULE_assignable = 19, RULE_access = 20, RULE_functionCall = 21, 
		RULE_literal = 22;
	public static final String[] ruleNames = {
		"program", "structure", "blockStructure", "ifStructure", "whileStructure", 
		"statement", "command", "declaration", "variableDeclaration", "enumerationDeclaration", 
		"functionDeclaration", "compositeDeclaration", "typeDenoter", "assignment", 
		"swap", "expression", "arithmetic", "molecule", "atomic", "assignable", 
		"access", "functionCall", "literal"
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
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << FUNCTION) | (1L << TYPE) | (1L << ENUMERATION) | (1L << CONSTANT) | (1L << LEFT_BRACE) | (1L << IDENTIFIER))) != 0)) {
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
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << FUNCTION) | (1L << TYPE) | (1L << ENUMERATION) | (1L << CONSTANT) | (1L << LEFT_BRACE) | (1L << IDENTIFIER))) != 0)) {
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
		public CommandContext command() {
			return getRuleContext(CommandContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(BramsprParser.SEMICOLON, 0); }
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public StructureContext structure() {
			return getRuleContext(StructureContext.class,0);
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
			setState(91);
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
				setState(85); command();
				setState(86); match(SEMICOLON);
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(88); functionCall();
				setState(89); match(SEMICOLON);
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

	public static class CommandContext extends ParserRuleContext {
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public SwapContext swap() {
			return getRuleContext(SwapContext.class,0);
		}
		public CommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_command; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitCommand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CommandContext command() throws RecognitionException {
		CommandContext _localctx = new CommandContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_command);
		try {
			setState(95);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(93); assignment();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(94); swap();
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
		public EnumerationDeclarationContext enumerationDeclaration() {
			return getRuleContext(EnumerationDeclarationContext.class,0);
		}
		public CompositeDeclarationContext compositeDeclaration() {
			return getRuleContext(CompositeDeclarationContext.class,0);
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
		enterRule(_localctx, 14, RULE_declaration);
		try {
			setState(101);
			switch (_input.LA(1)) {
			case TYPE:
				enterOuterAlt(_localctx, 1);
				{
				setState(97); compositeDeclaration();
				}
				break;
			case FUNCTION:
				enterOuterAlt(_localctx, 2);
				{
				setState(98); functionDeclaration();
				}
				break;
			case ENUMERATION:
				enterOuterAlt(_localctx, 3);
				{
				setState(99); enumerationDeclaration();
				}
				break;
			case CONSTANT:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 4);
				{
				setState(100); variableDeclaration();
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
		public VariableDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclaration; }
	 
		public VariableDeclarationContext() { }
		public void copyFrom(VariableDeclarationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class InstantiatingVariableDeclarationContext extends VariableDeclarationContext {
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
		public TerminalNode CONSTANT() { return getToken(BramsprParser.CONSTANT, 0); }
		public InstantiatingVariableDeclarationContext(VariableDeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitInstantiatingVariableDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PureVariableDeclarationContext extends VariableDeclarationContext {
		public TypeDenoterContext typeDenoter() {
			return getRuleContext(TypeDenoterContext.class,0);
		}
		public TerminalNode IDENTIFIER(int i) {
			return getToken(BramsprParser.IDENTIFIER, i);
		}
		public List<TerminalNode> IDENTIFIER() { return getTokens(BramsprParser.IDENTIFIER); }
		public List<TerminalNode> COMMA() { return getTokens(BramsprParser.COMMA); }
		public TerminalNode COLON() { return getToken(BramsprParser.COLON, 0); }
		public TerminalNode COMMA(int i) {
			return getToken(BramsprParser.COMMA, i);
		}
		public PureVariableDeclarationContext(VariableDeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitPureVariableDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableDeclarationContext variableDeclaration() throws RecognitionException {
		VariableDeclarationContext _localctx = new VariableDeclarationContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_variableDeclaration);
		int _la;
		try {
			setState(129);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				_localctx = new PureVariableDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(103); match(IDENTIFIER);
				setState(108);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(104); match(COMMA);
					setState(105); match(IDENTIFIER);
					}
					}
					setState(110);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(111); match(COLON);
				setState(112); typeDenoter();
				}
				break;

			case 2:
				_localctx = new InstantiatingVariableDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(114);
				_la = _input.LA(1);
				if (_la==CONSTANT) {
					{
					setState(113); match(CONSTANT);
					}
				}

				setState(116); match(IDENTIFIER);
				setState(121);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(117); match(COMMA);
					setState(118); match(IDENTIFIER);
					}
					}
					setState(123);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(124); match(COLON);
				setState(125); typeDenoter();
				setState(126); match(BECOMES);
				setState(127); expression(0);
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
		public TerminalNode IDENTIFIER(int i) {
			return getToken(BramsprParser.IDENTIFIER, i);
		}
		public List<TerminalNode> IDENTIFIER() { return getTokens(BramsprParser.IDENTIFIER); }
		public TerminalNode ENUMERATION() { return getToken(BramsprParser.ENUMERATION, 0); }
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
		enterRule(_localctx, 18, RULE_enumerationDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(131); match(ENUMERATION);
			setState(132); match(IDENTIFIER);
			setState(133); match(LEFT_BRACE);
			setState(142);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(134); match(IDENTIFIER);
				setState(139);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(135); match(COMMA);
					setState(136); match(IDENTIFIER);
					}
					}
					setState(141);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(144); match(RIGHT_BRACE);
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
		enterRule(_localctx, 20, RULE_functionDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146); match(FUNCTION);
			setState(147); match(IDENTIFIER);
			setState(148); match(LEFT_PARENTHESIS);
			setState(161);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(149); match(IDENTIFIER);
				setState(150); match(COLON);
				setState(151); typeDenoter();
				setState(158);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(152); match(COMMA);
					setState(153); match(IDENTIFIER);
					setState(154); match(COLON);
					setState(155); typeDenoter();
					}
					}
					setState(160);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(163); match(RIGHT_PARENTHESIS);
			setState(164); match(LEFT_BRACE);
			setState(168);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << FUNCTION) | (1L << TYPE) | (1L << ENUMERATION) | (1L << CONSTANT) | (1L << LEFT_BRACE) | (1L << IDENTIFIER))) != 0)) {
				{
				{
				setState(165); statement();
				}
				}
				setState(170);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(175);
			_la = _input.LA(1);
			if (_la==RETURN) {
				{
				setState(171); match(RETURN);
				setState(172); expression(0);
				setState(173); match(SEMICOLON);
				}
			}

			setState(177); match(RIGHT_BRACE);
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

	public static class CompositeDeclarationContext extends ParserRuleContext {
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
		public CompositeDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compositeDeclaration; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitCompositeDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompositeDeclarationContext compositeDeclaration() throws RecognitionException {
		CompositeDeclarationContext _localctx = new CompositeDeclarationContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_compositeDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(179); match(TYPE);
			setState(180); match(IDENTIFIER);
			setState(181); match(LEFT_BRACE);
			setState(182); match(IDENTIFIER);
			setState(183); match(COLON);
			setState(184); typeDenoter();
			setState(191);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(185); match(COMMA);
				setState(186); match(IDENTIFIER);
				setState(187); match(COLON);
				setState(188); typeDenoter();
				}
				}
				setState(193);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(194); match(RIGHT_BRACE);
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
	public static class EnumeratedTypeDenoterContext extends TypeDenoterContext {
		public TerminalNode DOT() { return getToken(BramsprParser.DOT, 0); }
		public TerminalNode IDENTIFIER() { return getToken(BramsprParser.IDENTIFIER, 0); }
		public TerminalNode ENUMERATION() { return getToken(BramsprParser.ENUMERATION, 0); }
		public EnumeratedTypeDenoterContext(TypeDenoterContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitEnumeratedTypeDenoter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeDenoterContext typeDenoter() throws RecognitionException {
		TypeDenoterContext _localctx = new TypeDenoterContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_typeDenoter);
		try {
			setState(204);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				_localctx = new BaseTypeDenoterContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(196); match(IDENTIFIER);
				}
				break;
			case LEFT_BLOCKBRACE:
				_localctx = new ArrayTypeDenoterContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(197); match(LEFT_BLOCKBRACE);
				setState(198); match(NUMBER);
				setState(199); match(RIGHT_BLOCKBRACE);
				setState(200); typeDenoter();
				}
				break;
			case ENUMERATION:
				_localctx = new EnumeratedTypeDenoterContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(201); match(ENUMERATION);
				setState(202); match(DOT);
				setState(203); match(IDENTIFIER);
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
		enterRule(_localctx, 26, RULE_assignment);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(209); 
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(206); assignable(0);
					setState(207); match(BECOMES);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(211); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			} while ( _alt!=2 && _alt!=-1 );
			setState(213); expression(0);
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
		enterRule(_localctx, 28, RULE_swap);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(215); assignable(0);
			setState(216); match(SWAP);
			setState(217); assignable(0);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitAndExpression(this);
			else return visitor.visitChildren(this);
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
		public List<TerminalNode> EQUALS_TO() { return getTokens(BramsprParser.EQUALS_TO); }
		public List<ArithmeticContext> arithmetic() {
			return getRuleContexts(ArithmeticContext.class);
		}
		public ArithmeticContext arithmetic(int i) {
			return getRuleContext(ArithmeticContext.class,i);
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
	public static class UniversalEqualsToExpressionContext extends ExpressionContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode EQUALS_TO() { return getToken(BramsprParser.EQUALS_TO, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public UniversalEqualsToExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitUniversalEqualsToExpression(this);
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
	public static class UniversalNotEqualsToExpressionContext extends ExpressionContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode NOT_EQUALS_TO() { return getToken(BramsprParser.NOT_EQUALS_TO, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public UniversalNotEqualsToExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitUniversalNotEqualsToExpression(this);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitOrExpression(this);
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
		public List<TerminalNode> NOT_EQUALS_TO() { return getTokens(BramsprParser.NOT_EQUALS_TO); }
		public TerminalNode NOT_EQUALS_TO(int i) {
			return getToken(BramsprParser.NOT_EQUALS_TO, i);
		}
		public List<ArithmeticContext> arithmetic() {
			return getRuleContexts(ArithmeticContext.class);
		}
		public ArithmeticContext arithmetic(int i) {
			return getRuleContext(ArithmeticContext.class,i);
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
		int _startState = 30;
		enterRecursionRule(_localctx, RULE_expression);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(271);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				{
				_localctx = new NotExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(220); match(NOT);
				setState(221); expression(13);
				}
				break;

			case 2:
				{
				_localctx = new ArithmeticExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(222); arithmetic(0);
				}
				break;

			case 3:
				{
				_localctx = new EqualsToExpressionContext(_localctx);
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
						setState(224); match(EQUALS_TO);
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

			case 4:
				{
				_localctx = new NotEqualsToExpressionContext(_localctx);
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
						setState(231); match(NOT_EQUALS_TO);
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

			case 5:
				{
				_localctx = new PlusMinusExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(237); arithmetic(0);
				setState(238); match(EQUALS_TO);
				setState(239); arithmetic(0);
				setState(240); match(PLUSMINUS);
				setState(241); arithmetic(0);
				}
				break;

			case 6:
				{
				_localctx = new GreaterThanExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(243); arithmetic(0);
				setState(246); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(244); match(GREATER_THAN);
						setState(245); arithmetic(0);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(248); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
				} while ( _alt!=2 && _alt!=-1 );
				}
				break;

			case 7:
				{
				_localctx = new GreaterThanEqualsToExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(250); arithmetic(0);
				setState(253); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(251); match(GREATER_THAN_EQUALS_TO);
						setState(252); arithmetic(0);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(255); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
				} while ( _alt!=2 && _alt!=-1 );
				}
				break;

			case 8:
				{
				_localctx = new SmallerThanExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(257); arithmetic(0);
				setState(260); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(258); match(SMALLER_THAN);
						setState(259); arithmetic(0);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(262); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
				} while ( _alt!=2 && _alt!=-1 );
				}
				break;

			case 9:
				{
				_localctx = new SmallerThanEqualsToExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(264); arithmetic(0);
				setState(267); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(265); match(SMALLER_THAN_EQUALS_TO);
						setState(266); arithmetic(0);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(269); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
				} while ( _alt!=2 && _alt!=-1 );
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(287);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(285);
					switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
					case 1:
						{
						_localctx = new UniversalEqualsToExpressionContext(new ExpressionContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(273);
						if (!(9 >= _localctx._p)) throw new FailedPredicateException(this, "9 >= $_p");
						setState(274); match(EQUALS_TO);
						setState(275); expression(10);
						}
						break;

					case 2:
						{
						_localctx = new UniversalNotEqualsToExpressionContext(new ExpressionContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(276);
						if (!(8 >= _localctx._p)) throw new FailedPredicateException(this, "8 >= $_p");
						setState(277); match(NOT_EQUALS_TO);
						setState(278); expression(9);
						}
						break;

					case 3:
						{
						_localctx = new AndExpressionContext(new ExpressionContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(279);
						if (!(2 >= _localctx._p)) throw new FailedPredicateException(this, "2 >= $_p");
						setState(280); match(AND);
						setState(281); expression(3);
						}
						break;

					case 4:
						{
						_localctx = new OrExpressionContext(new ExpressionContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(282);
						if (!(1 >= _localctx._p)) throw new FailedPredicateException(this, "1 >= $_p");
						setState(283); match(OR);
						setState(284); expression(2);
						}
						break;
					}
					} 
				}
				setState(289);
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
	public static class MoleculeExpressionContext extends ArithmeticContext {
		public MoleculeContext molecule() {
			return getRuleContext(MoleculeContext.class,0);
		}
		public MoleculeExpressionContext(ArithmeticContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitMoleculeExpression(this);
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
		int _startState = 32;
		enterRecursionRule(_localctx, RULE_arithmetic);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(294);
			switch (_input.LA(1)) {
			case PLUS:
			case MINUS:
				{
				_localctx = new SignExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(291);
				_la = _input.LA(1);
				if ( !(_la==PLUS || _la==MINUS) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(292); arithmetic(4);
				}
				break;
			case ENUMERATION:
			case LEFT_PARENTHESIS:
			case LEFT_BLOCKBRACE:
			case BOOLEAN:
			case STRING:
			case CHARACTER:
			case IDENTIFIER:
			case NUMBER:
				{
				_localctx = new MoleculeExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(293); molecule();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(307);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(305);
					switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
					case 1:
						{
						_localctx = new PowerExpressionContext(new ArithmeticContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_arithmetic);
						setState(296);
						if (!(3 >= _localctx._p)) throw new FailedPredicateException(this, "3 >= $_p");
						setState(297); match(POWER);
						setState(298); arithmetic(3);
						}
						break;

					case 2:
						{
						_localctx = new MultiplicationExpressionContext(new ArithmeticContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_arithmetic);
						setState(299);
						if (!(2 >= _localctx._p)) throw new FailedPredicateException(this, "2 >= $_p");
						setState(300);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MULTIPLICATION) | (1L << DIVISION) | (1L << MODULUS))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(301); arithmetic(3);
						}
						break;

					case 3:
						{
						_localctx = new AdditionExpressionContext(new ArithmeticContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_arithmetic);
						setState(302);
						if (!(1 >= _localctx._p)) throw new FailedPredicateException(this, "1 >= $_p");
						setState(303);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(304); arithmetic(2);
						}
						break;
					}
					} 
				}
				setState(309);
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

	public static class MoleculeContext extends ParserRuleContext {
		public MoleculeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_molecule; }
	 
		public MoleculeContext() { }
		public void copyFrom(MoleculeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AtomicExpressionContext extends MoleculeContext {
		public AtomicContext atomic() {
			return getRuleContext(AtomicContext.class,0);
		}
		public AtomicExpressionContext(MoleculeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitAtomicExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PotentialEnumerationLiteralContext extends MoleculeContext {
		public TerminalNode DOT() { return getToken(BramsprParser.DOT, 0); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(BramsprParser.IDENTIFIER, i);
		}
		public List<TerminalNode> IDENTIFIER() { return getTokens(BramsprParser.IDENTIFIER); }
		public PotentialEnumerationLiteralContext(MoleculeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitPotentialEnumerationLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MoleculeContext molecule() throws RecognitionException {
		MoleculeContext _localctx = new MoleculeContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_molecule);
		try {
			setState(314);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				_localctx = new PotentialEnumerationLiteralContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(310); match(IDENTIFIER);
				setState(311); match(DOT);
				setState(312); match(IDENTIFIER);
				}
				break;

			case 2:
				_localctx = new AtomicExpressionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(313); atomic(0);
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
	public static class AccessOnAtomicExpressionContext extends AtomicContext {
		public AtomicContext atomic() {
			return getRuleContext(AtomicContext.class,0);
		}
		public AccessContext access() {
			return getRuleContext(AccessContext.class,0);
		}
		public AccessOnAtomicExpressionContext(AtomicContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitAccessOnAtomicExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomicContext atomic(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		AtomicContext _localctx = new AtomicContext(_ctx, _parentState, _p);
		AtomicContext _prevctx = _localctx;
		int _startState = 36;
		enterRecursionRule(_localctx, RULE_atomic);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(328);
			switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
			case 1:
				{
				_localctx = new AssignmentExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(317); match(LEFT_PARENTHESIS);
				setState(318); assignment();
				setState(319); match(RIGHT_PARENTHESIS);
				}
				break;

			case 2:
				{
				_localctx = new ParenthesisExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(321); match(LEFT_PARENTHESIS);
				setState(322); expression(0);
				setState(323); match(RIGHT_PARENTHESIS);
				}
				break;

			case 3:
				{
				_localctx = new AssignableExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(325); assignable(0);
				}
				break;

			case 4:
				{
				_localctx = new FunctionCallExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(326); functionCall();
				}
				break;

			case 5:
				{
				_localctx = new LiteralExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(327); literal();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(334);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new AccessOnAtomicExpressionContext(new AtomicContext(_parentctx, _parentState, _p));
					pushNewRecursionContext(_localctx, _startState, RULE_atomic);
					setState(330);
					if (!(1 >= _localctx._p)) throw new FailedPredicateException(this, "1 >= $_p");
					setState(331); access();
					}
					} 
				}
				setState(336);
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
	public static class AccessOnAssignableContext extends AssignableContext {
		public AssignableContext assignable() {
			return getRuleContext(AssignableContext.class,0);
		}
		public AccessContext access() {
			return getRuleContext(AccessContext.class,0);
		}
		public AccessOnAssignableContext(AssignableContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitAccessOnAssignable(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BasicAssignableContext extends AssignableContext {
		public TerminalNode IDENTIFIER() { return getToken(BramsprParser.IDENTIFIER, 0); }
		public BasicAssignableContext(AssignableContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitBasicAssignable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignableContext assignable(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		AssignableContext _localctx = new AssignableContext(_ctx, _parentState, _p);
		AssignableContext _prevctx = _localctx;
		int _startState = 38;
		enterRecursionRule(_localctx, RULE_assignable);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new BasicAssignableContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(338); match(IDENTIFIER);
			}
			_ctx.stop = _input.LT(-1);
			setState(344);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new AccessOnAssignableContext(new AssignableContext(_parentctx, _parentState, _p));
					pushNewRecursionContext(_localctx, _startState, RULE_assignable);
					setState(340);
					if (!(2 >= _localctx._p)) throw new FailedPredicateException(this, "2 >= $_p");
					setState(341); access();
					}
					} 
				}
				setState(346);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
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

	public static class AccessContext extends ParserRuleContext {
		public AccessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_access; }
	 
		public AccessContext() { }
		public void copyFrom(AccessContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ArrayAccessContext extends AccessContext {
		public TerminalNode LEFT_BLOCKBRACE() { return getToken(BramsprParser.LEFT_BLOCKBRACE, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RIGHT_BLOCKBRACE() { return getToken(BramsprParser.RIGHT_BLOCKBRACE, 0); }
		public ArrayAccessContext(AccessContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitArrayAccess(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FieldAccessContext extends AccessContext {
		public TerminalNode DOT() { return getToken(BramsprParser.DOT, 0); }
		public TerminalNode IDENTIFIER() { return getToken(BramsprParser.IDENTIFIER, 0); }
		public FieldAccessContext(AccessContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitFieldAccess(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AccessContext access() throws RecognitionException {
		AccessContext _localctx = new AccessContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_access);
		try {
			setState(353);
			switch (_input.LA(1)) {
			case DOT:
				_localctx = new FieldAccessContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(347); match(DOT);
				setState(348); match(IDENTIFIER);
				}
				break;
			case LEFT_BLOCKBRACE:
				_localctx = new ArrayAccessContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(349); match(LEFT_BLOCKBRACE);
				setState(350); expression(0);
				setState(351); match(RIGHT_BLOCKBRACE);
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
		enterRule(_localctx, 42, RULE_functionCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(355); match(IDENTIFIER);
			setState(356); match(LEFT_PARENTHESIS);
			setState(365);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PLUS) | (1L << MINUS) | (1L << NOT) | (1L << ENUMERATION) | (1L << LEFT_PARENTHESIS) | (1L << LEFT_BLOCKBRACE) | (1L << BOOLEAN) | (1L << STRING) | (1L << CHARACTER) | (1L << IDENTIFIER) | (1L << NUMBER))) != 0)) {
				{
				setState(357); expression(0);
				setState(362);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(358); match(COMMA);
					setState(359); expression(0);
					}
					}
					setState(364);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(367); match(RIGHT_PARENTHESIS);
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
	public static class ExplicitEnumerationLiteralContext extends LiteralContext {
		public List<TerminalNode> DOT() { return getTokens(BramsprParser.DOT); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(BramsprParser.IDENTIFIER, i);
		}
		public List<TerminalNode> IDENTIFIER() { return getTokens(BramsprParser.IDENTIFIER); }
		public TerminalNode ENUMERATION() { return getToken(BramsprParser.ENUMERATION, 0); }
		public TerminalNode DOT(int i) {
			return getToken(BramsprParser.DOT, i);
		}
		public ExplicitEnumerationLiteralContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitExplicitEnumerationLiteral(this);
			else return visitor.visitChildren(this);
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
		public TerminalNode BOOLEAN() { return getToken(BramsprParser.BOOLEAN, 0); }
		public BooleanLiteralContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitBooleanLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CompositeLiteralContext extends LiteralContext {
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
		public CompositeLiteralContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitCompositeLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntegerLiteralContext extends LiteralContext {
		public TerminalNode NUMBER() { return getToken(BramsprParser.NUMBER, 0); }
		public IntegerLiteralContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitIntegerLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_literal);
		int _la;
		try {
			setState(406);
			switch (_input.LA(1)) {
			case NUMBER:
				_localctx = new IntegerLiteralContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(369); match(NUMBER);
				}
				break;
			case CHARACTER:
				_localctx = new CharacterLiteralContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(370); match(CHARACTER);
				}
				break;
			case STRING:
				_localctx = new StringLiteralContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(371); match(STRING);
				}
				break;
			case BOOLEAN:
				_localctx = new BooleanLiteralContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(372); match(BOOLEAN);
				}
				break;
			case LEFT_BLOCKBRACE:
				_localctx = new ArrayLiteralContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(373); match(LEFT_BLOCKBRACE);
				setState(382);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PLUS) | (1L << MINUS) | (1L << NOT) | (1L << ENUMERATION) | (1L << LEFT_PARENTHESIS) | (1L << LEFT_BLOCKBRACE) | (1L << BOOLEAN) | (1L << STRING) | (1L << CHARACTER) | (1L << IDENTIFIER) | (1L << NUMBER))) != 0)) {
					{
					setState(374); expression(0);
					setState(379);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(375); match(COMMA);
						setState(376); expression(0);
						}
						}
						setState(381);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(384); match(RIGHT_BLOCKBRACE);
				}
				break;
			case IDENTIFIER:
				_localctx = new CompositeLiteralContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(385); match(IDENTIFIER);
				setState(386); match(LEFT_BRACE);
				setState(387); match(IDENTIFIER);
				setState(388); match(BECOMES);
				setState(389); expression(0);
				setState(396);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(390); match(COMMA);
					setState(391); match(IDENTIFIER);
					setState(392); match(BECOMES);
					setState(393); expression(0);
					}
					}
					setState(398);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(399); match(RIGHT_BRACE);
				}
				break;
			case ENUMERATION:
				_localctx = new ExplicitEnumerationLiteralContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(401); match(ENUMERATION);
				setState(402); match(DOT);
				setState(403); match(IDENTIFIER);
				setState(404); match(DOT);
				setState(405); match(IDENTIFIER);
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
		case 15: return expression_sempred((ExpressionContext)_localctx, predIndex);

		case 16: return arithmetic_sempred((ArithmeticContext)_localctx, predIndex);

		case 18: return atomic_sempred((AtomicContext)_localctx, predIndex);

		case 19: return assignable_sempred((AssignableContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return 9 >= _localctx._p;

		case 1: return 8 >= _localctx._p;

		case 2: return 2 >= _localctx._p;

		case 3: return 1 >= _localctx._p;
		}
		return true;
	}
	private boolean assignable_sempred(AssignableContext _localctx, int predIndex) {
		switch (predIndex) {
		case 8: return 2 >= _localctx._p;
		}
		return true;
	}
	private boolean arithmetic_sempred(ArithmeticContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4: return 3 >= _localctx._p;

		case 5: return 2 >= _localctx._p;

		case 6: return 1 >= _localctx._p;
		}
		return true;
	}
	private boolean atomic_sempred(AtomicContext _localctx, int predIndex) {
		switch (predIndex) {
		case 7: return 1 >= _localctx._p;
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\3\61\u019b\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\3\2\7\2\62"+
		"\n\2\f\2\16\2\65\13\2\3\3\3\3\3\3\5\3:\n\3\3\4\3\4\7\4>\n\4\f\4\16\4A"+
		"\13\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5L\n\5\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7^\n\7\3\b\3\b\5\bb\n\b"+
		"\3\t\3\t\3\t\3\t\5\th\n\t\3\n\3\n\3\n\7\nm\n\n\f\n\16\np\13\n\3\n\3\n"+
		"\3\n\5\nu\n\n\3\n\3\n\3\n\7\nz\n\n\f\n\16\n}\13\n\3\n\3\n\3\n\3\n\3\n"+
		"\5\n\u0084\n\n\3\13\3\13\3\13\3\13\3\13\3\13\7\13\u008c\n\13\f\13\16\13"+
		"\u008f\13\13\5\13\u0091\n\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\7\f\u009f\n\f\f\f\16\f\u00a2\13\f\5\f\u00a4\n\f\3\f\3\f\3\f\7"+
		"\f\u00a9\n\f\f\f\16\f\u00ac\13\f\3\f\3\f\3\f\3\f\5\f\u00b2\n\f\3\f\3\f"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\7\r\u00c0\n\r\f\r\16\r\u00c3"+
		"\13\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u00cf\n\16"+
		"\3\17\3\17\3\17\6\17\u00d4\n\17\r\17\16\17\u00d5\3\17\3\17\3\20\3\20\3"+
		"\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\6\21\u00e5\n\21\r\21\16\21"+
		"\u00e6\3\21\3\21\3\21\6\21\u00ec\n\21\r\21\16\21\u00ed\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\6\21\u00f9\n\21\r\21\16\21\u00fa\3\21\3"+
		"\21\3\21\6\21\u0100\n\21\r\21\16\21\u0101\3\21\3\21\3\21\6\21\u0107\n"+
		"\21\r\21\16\21\u0108\3\21\3\21\3\21\6\21\u010e\n\21\r\21\16\21\u010f\5"+
		"\21\u0112\n\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\7\21\u0120\n\21\f\21\16\21\u0123\13\21\3\22\3\22\3\22\3\22\5\22"+
		"\u0129\n\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\7\22\u0134\n"+
		"\22\f\22\16\22\u0137\13\22\3\23\3\23\3\23\3\23\5\23\u013d\n\23\3\24\3"+
		"\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u014b\n\24"+
		"\3\24\3\24\7\24\u014f\n\24\f\24\16\24\u0152\13\24\3\25\3\25\3\25\3\25"+
		"\3\25\7\25\u0159\n\25\f\25\16\25\u015c\13\25\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\5\26\u0164\n\26\3\27\3\27\3\27\3\27\3\27\7\27\u016b\n\27\f\27\16"+
		"\27\u016e\13\27\5\27\u0170\n\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\7\30\u017c\n\30\f\30\16\30\u017f\13\30\5\30\u0181\n\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\7\30\u018d\n\30\f\30\16"+
		"\30\u0190\13\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\5\30\u0199\n\30\3\30"+
		"\2\31\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\2\4\3\2\5\6\3\2"+
		"\7\t\u01c6\2\63\3\2\2\2\49\3\2\2\2\6;\3\2\2\2\bD\3\2\2\2\nM\3\2\2\2\f"+
		"]\3\2\2\2\16a\3\2\2\2\20g\3\2\2\2\22\u0083\3\2\2\2\24\u0085\3\2\2\2\26"+
		"\u0094\3\2\2\2\30\u00b5\3\2\2\2\32\u00ce\3\2\2\2\34\u00d3\3\2\2\2\36\u00d9"+
		"\3\2\2\2 \u0111\3\2\2\2\"\u0128\3\2\2\2$\u013c\3\2\2\2&\u014a\3\2\2\2"+
		"(\u0153\3\2\2\2*\u0163\3\2\2\2,\u0165\3\2\2\2.\u0198\3\2\2\2\60\62\5\f"+
		"\7\2\61\60\3\2\2\2\62\65\3\2\2\2\63\61\3\2\2\2\63\64\3\2\2\2\64\3\3\2"+
		"\2\2\65\63\3\2\2\2\66:\5\6\4\2\67:\5\b\5\28:\5\n\6\29\66\3\2\2\29\67\3"+
		"\2\2\298\3\2\2\2:\5\3\2\2\2;?\7$\2\2<>\5\f\7\2=<\3\2\2\2>A\3\2\2\2?=\3"+
		"\2\2\2?@\3\2\2\2@B\3\2\2\2A?\3\2\2\2BC\7%\2\2C\7\3\2\2\2DE\7\27\2\2EF"+
		"\7\"\2\2FG\5 \21\2GH\7#\2\2HK\5\6\4\2IJ\7\31\2\2JL\5\6\4\2KI\3\2\2\2K"+
		"L\3\2\2\2L\t\3\2\2\2MN\7\32\2\2NO\7\"\2\2OP\5 \21\2PQ\7#\2\2QR\5\6\4\2"+
		"R\13\3\2\2\2S^\5\4\3\2TU\5\20\t\2UV\7!\2\2V^\3\2\2\2WX\5\16\b\2XY\7!\2"+
		"\2Y^\3\2\2\2Z[\5,\27\2[\\\7!\2\2\\^\3\2\2\2]S\3\2\2\2]T\3\2\2\2]W\3\2"+
		"\2\2]Z\3\2\2\2^\r\3\2\2\2_b\5\34\17\2`b\5\36\20\2a_\3\2\2\2a`\3\2\2\2"+
		"b\17\3\2\2\2ch\5\30\r\2dh\5\26\f\2eh\5\24\13\2fh\5\22\n\2gc\3\2\2\2gd"+
		"\3\2\2\2ge\3\2\2\2gf\3\2\2\2h\21\3\2\2\2in\7-\2\2jk\7(\2\2km\7-\2\2lj"+
		"\3\2\2\2mp\3\2\2\2nl\3\2\2\2no\3\2\2\2oq\3\2\2\2pn\3\2\2\2qr\7 \2\2r\u0084"+
		"\5\32\16\2su\7\37\2\2ts\3\2\2\2tu\3\2\2\2uv\3\2\2\2v{\7-\2\2wx\7(\2\2"+
		"xz\7-\2\2yw\3\2\2\2z}\3\2\2\2{y\3\2\2\2{|\3\2\2\2|~\3\2\2\2}{\3\2\2\2"+
		"~\177\7 \2\2\177\u0080\5\32\16\2\u0080\u0081\7\3\2\2\u0081\u0082\5 \21"+
		"\2\u0082\u0084\3\2\2\2\u0083i\3\2\2\2\u0083t\3\2\2\2\u0084\23\3\2\2\2"+
		"\u0085\u0086\7\35\2\2\u0086\u0087\7-\2\2\u0087\u0090\7$\2\2\u0088\u008d"+
		"\7-\2\2\u0089\u008a\7(\2\2\u008a\u008c\7-\2\2\u008b\u0089\3\2\2\2\u008c"+
		"\u008f\3\2\2\2\u008d\u008b\3\2\2\2\u008d\u008e\3\2\2\2\u008e\u0091\3\2"+
		"\2\2\u008f\u008d\3\2\2\2\u0090\u0088\3\2\2\2\u0090\u0091\3\2\2\2\u0091"+
		"\u0092\3\2\2\2\u0092\u0093\7%\2\2\u0093\25\3\2\2\2\u0094\u0095\7\33\2"+
		"\2\u0095\u0096\7-\2\2\u0096\u00a3\7\"\2\2\u0097\u0098\7-\2\2\u0098\u0099"+
		"\7 \2\2\u0099\u00a0\5\32\16\2\u009a\u009b\7(\2\2\u009b\u009c\7-\2\2\u009c"+
		"\u009d\7 \2\2\u009d\u009f\5\32\16\2\u009e\u009a\3\2\2\2\u009f\u00a2\3"+
		"\2\2\2\u00a0\u009e\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\u00a4\3\2\2\2\u00a2"+
		"\u00a0\3\2\2\2\u00a3\u0097\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00a5\3\2"+
		"\2\2\u00a5\u00a6\7#\2\2\u00a6\u00aa\7$\2\2\u00a7\u00a9\5\f\7\2\u00a8\u00a7"+
		"\3\2\2\2\u00a9\u00ac\3\2\2\2\u00aa\u00a8\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab"+
		"\u00b1\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ad\u00ae\7\36\2\2\u00ae\u00af\5"+
		" \21\2\u00af\u00b0\7!\2\2\u00b0\u00b2\3\2\2\2\u00b1\u00ad\3\2\2\2\u00b1"+
		"\u00b2\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3\u00b4\7%\2\2\u00b4\27\3\2\2\2"+
		"\u00b5\u00b6\7\34\2\2\u00b6\u00b7\7-\2\2\u00b7\u00b8\7$\2\2\u00b8\u00b9"+
		"\7-\2\2\u00b9\u00ba\7 \2\2\u00ba\u00c1\5\32\16\2\u00bb\u00bc\7(\2\2\u00bc"+
		"\u00bd\7-\2\2\u00bd\u00be\7 \2\2\u00be\u00c0\5\32\16\2\u00bf\u00bb\3\2"+
		"\2\2\u00c0\u00c3\3\2\2\2\u00c1\u00bf\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2"+
		"\u00c4\3\2\2\2\u00c3\u00c1\3\2\2\2\u00c4\u00c5\7%\2\2\u00c5\31\3\2\2\2"+
		"\u00c6\u00cf\7-\2\2\u00c7\u00c8\7&\2\2\u00c8\u00c9\7.\2\2\u00c9\u00ca"+
		"\7\'\2\2\u00ca\u00cf\5\32\16\2\u00cb\u00cc\7\35\2\2\u00cc\u00cd\7)\2\2"+
		"\u00cd\u00cf\7-\2\2\u00ce\u00c6\3\2\2\2\u00ce\u00c7\3\2\2\2\u00ce\u00cb"+
		"\3\2\2\2\u00cf\33\3\2\2\2\u00d0\u00d1\5(\25\2\u00d1\u00d2\7\3\2\2\u00d2"+
		"\u00d4\3\2\2\2\u00d3\u00d0\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d5\u00d3\3\2"+
		"\2\2\u00d5\u00d6\3\2\2\2\u00d6\u00d7\3\2\2\2\u00d7\u00d8\5 \21\2\u00d8"+
		"\35\3\2\2\2\u00d9\u00da\5(\25\2\u00da\u00db\7\4\2\2\u00db\u00dc\5(\25"+
		"\2\u00dc\37\3\2\2\2\u00dd\u00de\b\21\1\2\u00de\u00df\7\22\2\2\u00df\u0112"+
		"\5 \21\2\u00e0\u0112\5\"\22\2\u00e1\u00e4\5\"\22\2\u00e2\u00e3\7\16\2"+
		"\2\u00e3\u00e5\5\"\22\2\u00e4\u00e2\3\2\2\2\u00e5\u00e6\3\2\2\2\u00e6"+
		"\u00e4\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e7\u0112\3\2\2\2\u00e8\u00eb\5\""+
		"\22\2\u00e9\u00ea\7\17\2\2\u00ea\u00ec\5\"\22\2\u00eb\u00e9\3\2\2\2\u00ec"+
		"\u00ed\3\2\2\2\u00ed\u00eb\3\2\2\2\u00ed\u00ee\3\2\2\2\u00ee\u0112\3\2"+
		"\2\2\u00ef\u00f0\5\"\22\2\u00f0\u00f1\7\16\2\2\u00f1\u00f2\5\"\22\2\u00f2"+
		"\u00f3\7\20\2\2\u00f3\u00f4\5\"\22\2\u00f4\u0112\3\2\2\2\u00f5\u00f8\5"+
		"\"\22\2\u00f6\u00f7\7\f\2\2\u00f7\u00f9\5\"\22\2\u00f8\u00f6\3\2\2\2\u00f9"+
		"\u00fa\3\2\2\2\u00fa\u00f8\3\2\2\2\u00fa\u00fb\3\2\2\2\u00fb\u0112\3\2"+
		"\2\2\u00fc\u00ff\5\"\22\2\u00fd\u00fe\7\r\2\2\u00fe\u0100\5\"\22\2\u00ff"+
		"\u00fd\3\2\2\2\u0100\u0101\3\2\2\2\u0101\u00ff\3\2\2\2\u0101\u0102\3\2"+
		"\2\2\u0102\u0112\3\2\2\2\u0103\u0106\5\"\22\2\u0104\u0105\7\n\2\2\u0105"+
		"\u0107\5\"\22\2\u0106\u0104\3\2\2\2\u0107\u0108\3\2\2\2\u0108\u0106\3"+
		"\2\2\2\u0108\u0109\3\2\2\2\u0109\u0112\3\2\2\2\u010a\u010d\5\"\22\2\u010b"+
		"\u010c\7\13\2\2\u010c\u010e\5\"\22\2\u010d\u010b\3\2\2\2\u010e\u010f\3"+
		"\2\2\2\u010f\u010d\3\2\2\2\u010f\u0110\3\2\2\2\u0110\u0112\3\2\2\2\u0111"+
		"\u00dd\3\2\2\2\u0111\u00e0\3\2\2\2\u0111\u00e1\3\2\2\2\u0111\u00e8\3\2"+
		"\2\2\u0111\u00ef\3\2\2\2\u0111\u00f5\3\2\2\2\u0111\u00fc\3\2\2\2\u0111"+
		"\u0103\3\2\2\2\u0111\u010a\3\2\2\2\u0112\u0121\3\2\2\2\u0113\u0114\6\21"+
		"\2\3\u0114\u0115\7\16\2\2\u0115\u0120\5 \21\2\u0116\u0117\6\21\3\3\u0117"+
		"\u0118\7\17\2\2\u0118\u0120\5 \21\2\u0119\u011a\6\21\4\3\u011a\u011b\7"+
		"\23\2\2\u011b\u0120\5 \21\2\u011c\u011d\6\21\5\3\u011d\u011e\7\24\2\2"+
		"\u011e\u0120\5 \21\2\u011f\u0113\3\2\2\2\u011f\u0116\3\2\2\2\u011f\u0119"+
		"\3\2\2\2\u011f\u011c\3\2\2\2\u0120\u0123\3\2\2\2\u0121\u011f\3\2\2\2\u0121"+
		"\u0122\3\2\2\2\u0122!\3\2\2\2\u0123\u0121\3\2\2\2\u0124\u0125\b\22\1\2"+
		"\u0125\u0126\t\2\2\2\u0126\u0129\5\"\22\2\u0127\u0129\5$\23\2\u0128\u0124"+
		"\3\2\2\2\u0128\u0127\3\2\2\2\u0129\u0135\3\2\2\2\u012a\u012b\6\22\6\3"+
		"\u012b\u012c\7\21\2\2\u012c\u0134\5\"\22\2\u012d\u012e\6\22\7\3\u012e"+
		"\u012f\t\3\2\2\u012f\u0134\5\"\22\2\u0130\u0131\6\22\b\3\u0131\u0132\t"+
		"\2\2\2\u0132\u0134\5\"\22\2\u0133\u012a\3\2\2\2\u0133\u012d\3\2\2\2\u0133"+
		"\u0130\3\2\2\2\u0134\u0137\3\2\2\2\u0135\u0133\3\2\2\2\u0135\u0136\3\2"+
		"\2\2\u0136#\3\2\2\2\u0137\u0135\3\2\2\2\u0138\u0139\7-\2\2\u0139\u013a"+
		"\7)\2\2\u013a\u013d\7-\2\2\u013b\u013d\5&\24\2\u013c\u0138\3\2\2\2\u013c"+
		"\u013b\3\2\2\2\u013d%\3\2\2\2\u013e\u013f\b\24\1\2\u013f\u0140\7\"\2\2"+
		"\u0140\u0141\5\34\17\2\u0141\u0142\7#\2\2\u0142\u014b\3\2\2\2\u0143\u0144"+
		"\7\"\2\2\u0144\u0145\5 \21\2\u0145\u0146\7#\2\2\u0146\u014b\3\2\2\2\u0147"+
		"\u014b\5(\25\2\u0148\u014b\5,\27\2\u0149\u014b\5.\30\2\u014a\u013e\3\2"+
		"\2\2\u014a\u0143\3\2\2\2\u014a\u0147\3\2\2\2\u014a\u0148\3\2\2\2\u014a"+
		"\u0149\3\2\2\2\u014b\u0150\3\2\2\2\u014c\u014d\6\24\t\3\u014d\u014f\5"+
		"*\26\2\u014e\u014c\3\2\2\2\u014f\u0152\3\2\2\2\u0150\u014e\3\2\2\2\u0150"+
		"\u0151\3\2\2\2\u0151\'\3\2\2\2\u0152\u0150\3\2\2\2\u0153\u0154\b\25\1"+
		"\2\u0154\u0155\7-\2\2\u0155\u015a\3\2\2\2\u0156\u0157\6\25\n\3\u0157\u0159"+
		"\5*\26\2\u0158\u0156\3\2\2\2\u0159\u015c\3\2\2\2\u015a\u0158\3\2\2\2\u015a"+
		"\u015b\3\2\2\2\u015b)\3\2\2\2\u015c\u015a\3\2\2\2\u015d\u015e\7)\2\2\u015e"+
		"\u0164\7-\2\2\u015f\u0160\7&\2\2\u0160\u0161\5 \21\2\u0161\u0162\7\'\2"+
		"\2\u0162\u0164\3\2\2\2\u0163\u015d\3\2\2\2\u0163\u015f\3\2\2\2\u0164+"+
		"\3\2\2\2\u0165\u0166\7-\2\2\u0166\u016f\7\"\2\2\u0167\u016c\5 \21\2\u0168"+
		"\u0169\7(\2\2\u0169\u016b\5 \21\2\u016a\u0168\3\2\2\2\u016b\u016e\3\2"+
		"\2\2\u016c\u016a\3\2\2\2\u016c\u016d\3\2\2\2\u016d\u0170\3\2\2\2\u016e"+
		"\u016c\3\2\2\2\u016f\u0167\3\2\2\2\u016f\u0170\3\2\2\2\u0170\u0171\3\2"+
		"\2\2\u0171\u0172\7#\2\2\u0172-\3\2\2\2\u0173\u0199\7.\2\2\u0174\u0199"+
		"\7,\2\2\u0175\u0199\7+\2\2\u0176\u0199\7*\2\2\u0177\u0180\7&\2\2\u0178"+
		"\u017d\5 \21\2\u0179\u017a\7(\2\2\u017a\u017c\5 \21\2\u017b\u0179\3\2"+
		"\2\2\u017c\u017f\3\2\2\2\u017d\u017b\3\2\2\2\u017d\u017e\3\2\2\2\u017e"+
		"\u0181\3\2\2\2\u017f\u017d\3\2\2\2\u0180\u0178\3\2\2\2\u0180\u0181\3\2"+
		"\2\2\u0181\u0182\3\2\2\2\u0182\u0199\7\'\2\2\u0183\u0184\7-\2\2\u0184"+
		"\u0185\7$\2\2\u0185\u0186\7-\2\2\u0186\u0187\7\3\2\2\u0187\u018e\5 \21"+
		"\2\u0188\u0189\7(\2\2\u0189\u018a\7-\2\2\u018a\u018b\7\3\2\2\u018b\u018d"+
		"\5 \21\2\u018c\u0188\3\2\2\2\u018d\u0190\3\2\2\2\u018e\u018c\3\2\2\2\u018e"+
		"\u018f\3\2\2\2\u018f\u0191\3\2\2\2\u0190\u018e\3\2\2\2\u0191\u0192\7%"+
		"\2\2\u0192\u0199\3\2\2\2\u0193\u0194\7\35\2\2\u0194\u0195\7)\2\2\u0195"+
		"\u0196\7-\2\2\u0196\u0197\7)\2\2\u0197\u0199\7-\2\2\u0198\u0173\3\2\2"+
		"\2\u0198\u0174\3\2\2\2\u0198\u0175\3\2\2\2\u0198\u0176\3\2\2\2\u0198\u0177"+
		"\3\2\2\2\u0198\u0183\3\2\2\2\u0198\u0193\3\2\2\2\u0199/\3\2\2\2-\639?"+
		"K]agnt{\u0083\u008d\u0090\u00a0\u00a3\u00aa\u00b1\u00c1\u00ce\u00d5\u00e6"+
		"\u00ed\u00fa\u0101\u0108\u010f\u0111\u011f\u0121\u0128\u0133\u0135\u013c"+
		"\u014a\u0150\u015a\u0163\u016c\u016f\u017d\u0180\u018e\u0198";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}