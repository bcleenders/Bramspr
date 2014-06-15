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
		CHARACTER=51, IF=21, TYPE=26, PUTSTRING=34, FINAL=37, THEN=22, SMALLER_THAN=8, 
		RIGHT_PARENTHESIS=43, COMMA=48, IDENTIFIER=52, LEFT_PARENTHESIS=42, RETURN=36, 
		DIVISION=6, BLOCKCOMMENT=56, PLUS=3, GREATER_THAN_EQUALS_TO=11, COMMENT=55, 
		DOT=49, RIGHT_BRACE=45, XOR=19, GETBOOL=30, GREATER_THAN=10, GETCHAR=29, 
		SWAP=2, ELSE=23, PLUSMINUS=14, BOOL=54, NUMBER=53, BECOMES=1, WHITESPACE=57, 
		POWER=15, PUTBOOL=33, SEMICOLON=41, MINUS=4, TRUE=38, PRINT=27, EQUALS_TO=12, 
		GETINT=28, LEFT_BLOCKBRACE=46, RIGHT_BLOCKBRACE=47, COLON=40, ENUM=35, 
		MODULUS=7, LEFT_BRACE=44, OR=18, MULTIPLICATION=5, NOT_EQUALS_TO=13, FALSE=39, 
		STRING=50, SMALLER_THAN_EQUALS_TO=9;
	public static final String[] tokenNames = {
		"<INVALID>", "':='", "'<>'", "'+'", "'-'", "'*'", "'/'", "'%'", "'<'", 
		"'<='", "'>'", "'>='", "'='", "'=/='", "'+-'", "'^'", "'!'", "'&'", "'|'", 
		"'!&'", "LOGIC", "'if'", "'then'", "'else'", "'while'", "'function'", 
		"'type'", "'print'", "'getInt'", "'getChar'", "'getBool'", "'putInt'", 
		"'putChar'", "'putBool'", "'putString'", "'enum'", "'return'", "'final'", 
		"'true'", "'false'", "':'", "';'", "'('", "')'", "'{'", "'}'", "'['", 
		"']'", "','", "'.'", "STRING", "CHARACTER", "IDENTIFIER", "NUMBER", "BOOL", 
		"COMMENT", "BLOCKCOMMENT", "WHITESPACE"
	};
	public static final int
		RULE_program = 0, RULE_expression = 1, RULE_block = 2, RULE_declaration = 3, 
		RULE_variabledeclaration = 4, RULE_finaldeclaration = 5, RULE_typedeclaration = 6, 
		RULE_fielddeclaration = 7, RULE_primitiveTypeDenoter = 8, RULE_functiondeclaration = 9, 
		RULE_enumdeclaration = 10, RULE_functioncall = 11, RULE_statement = 12, 
		RULE_ifstatement = 13, RULE_whilestatement = 14, RULE_assignment = 15, 
		RULE_swapstatement = 16;
	public static final String[] ruleNames = {
		"program", "expression", "block", "declaration", "variabledeclaration", 
		"finaldeclaration", "typedeclaration", "fielddeclaration", "primitiveTypeDenoter", 
		"functiondeclaration", "enumdeclaration", "functioncall", "statement", 
		"ifstatement", "whilestatement", "assignment", "swapstatement"
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitUnaryExpression(this);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitAdditionExpression(this);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitPowerExpression(this);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitEnumExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CharLiteralExpressionContext extends ExpressionContext {
		public TerminalNode CHARACTER() { return getToken(BramsprParser.CHARACTER, 0); }
		public CharLiteralExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitPlusMinusExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StringLiteralExpressionContext extends ExpressionContext {
		public TerminalNode STRING() { return getToken(BramsprParser.STRING, 0); }
		public StringLiteralExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitRecordAccessExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntLiteralExpressionContext extends ExpressionContext {
		public TerminalNode NUMBER() { return getToken(BramsprParser.NUMBER, 0); }
		public IntLiteralExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
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
		public TerminalNode COLON() { return getToken(BramsprParser.COLON, 0); }
		public TerminalNode COMMA(int i) {
			return getToken(BramsprParser.COMMA, i);
		}
		public RecordLiteralExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitArrayLiteralExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BoolLiteralExpressionContext extends ExpressionContext {
		public TerminalNode BOOL() { return getToken(BramsprParser.BOOL, 0); }
		public BoolLiteralExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitBoolLiteralExpression(this);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitFieldAccessExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState, _p);
		ExpressionContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, RULE_expression);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				_localctx = new UnaryExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(37);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PLUS) | (1L << MINUS) | (1L << NOT))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(38); expression(26);
				}
				break;

			case 2:
				{
				_localctx = new ParenthesisExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(39); match(LEFT_PARENTHESIS);
				setState(40); expression(0);
				setState(41); match(RIGHT_PARENTHESIS);
				}
				break;

			case 3:
				{
				_localctx = new AssignExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(43); match(LEFT_PARENTHESIS);
				setState(44); assignment();
				setState(45); match(RIGHT_PARENTHESIS);
				}
				break;

			case 4:
				{
				_localctx = new FunctionExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(47); functioncall();
				}
				break;

			case 5:
				{
				_localctx = new EnumExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(48); match(ENUM);
				setState(49); match(DOT);
				setState(50); match(IDENTIFIER);
				setState(51); match(DOT);
				setState(52); match(IDENTIFIER);
				}
				break;

			case 6:
				{
				_localctx = new FieldAccessExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(53); match(IDENTIFIER);
				setState(54); match(DOT);
				setState(55); match(IDENTIFIER);
				}
				break;

			case 7:
				{
				_localctx = new ArrayLiteralExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(56); match(LEFT_BRACE);
				setState(66);
				switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
				case 1:
					{
					setState(62);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
					while ( _alt!=2 && _alt!=-1 ) {
						if ( _alt==1 ) {
							{
							{
							setState(57); expression(0);
							setState(58); match(COMMA);
							}
							} 
						}
						setState(64);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
					}
					{
					setState(65); expression(0);
					}
					}
					break;
				}
				setState(68); match(RIGHT_BRACE);
				}
				break;

			case 8:
				{
				_localctx = new RecordLiteralExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(69); match(IDENTIFIER);
				setState(70); match(COLON);
				setState(71); match(LEFT_BRACE);
				setState(72); match(IDENTIFIER);
				setState(86);
				switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
				case 1:
					{
					setState(80);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
					while ( _alt!=2 && _alt!=-1 ) {
						if ( _alt==1 ) {
							{
							{
							setState(73); match(IDENTIFIER);
							setState(74); match(BECOMES);
							setState(75); expression(0);
							setState(76); match(COMMA);
							}
							} 
						}
						setState(82);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
					}
					setState(83); match(IDENTIFIER);
					setState(84); match(BECOMES);
					setState(85); expression(0);
					}
					break;
				}
				setState(88); match(RIGHT_BRACE);
				}
				break;

			case 9:
				{
				_localctx = new VariableExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(89); match(IDENTIFIER);
				}
				break;

			case 10:
				{
				_localctx = new IntLiteralExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(90); match(NUMBER);
				}
				break;

			case 11:
				{
				_localctx = new BoolLiteralExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(91); match(BOOL);
				}
				break;

			case 12:
				{
				_localctx = new CharLiteralExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(92); match(CHARACTER);
				}
				break;

			case 13:
				{
				_localctx = new StringLiteralExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(93); match(STRING);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(169);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(167);
					switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
					case 1:
						{
						_localctx = new PowerExpressionContext(new ExpressionContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(96);
						if (!(25 >= _localctx._p)) throw new FailedPredicateException(this, "25 >= $_p");
						setState(97); match(POWER);
						setState(98); expression(25);
						}
						break;

					case 2:
						{
						_localctx = new MultiplicationExpressionContext(new ExpressionContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(99);
						if (!(24 >= _localctx._p)) throw new FailedPredicateException(this, "24 >= $_p");
						setState(100);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MULTIPLICATION) | (1L << DIVISION) | (1L << MODULUS))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(101); expression(25);
						}
						break;

					case 3:
						{
						_localctx = new AdditionExpressionContext(new ExpressionContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(102);
						if (!(23 >= _localctx._p)) throw new FailedPredicateException(this, "23 >= $_p");
						setState(103);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(104); expression(24);
						}
						break;

					case 4:
						{
						_localctx = new AndExpressionContext(new ExpressionContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(105);
						if (!(15 >= _localctx._p)) throw new FailedPredicateException(this, "15 >= $_p");
						setState(106); match(AND);
						setState(107); expression(16);
						}
						break;

					case 5:
						{
						_localctx = new OrExpressionContext(new ExpressionContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(108);
						if (!(14 >= _localctx._p)) throw new FailedPredicateException(this, "14 >= $_p");
						setState(109); match(OR);
						setState(110); expression(15);
						}
						break;

					case 6:
						{
						_localctx = new PlusMinusExpressionContext(new ExpressionContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(111);
						if (!(16 >= _localctx._p)) throw new FailedPredicateException(this, "16 >= $_p");
						setState(112); match(EQUALS_TO);
						setState(113); expression(0);
						setState(114); match(PLUSMINUS);
						setState(115); expression(17);
						}
						break;

					case 7:
						{
						_localctx = new SmallerThanExpressionContext(new ExpressionContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(117);
						if (!(22 >= _localctx._p)) throw new FailedPredicateException(this, "22 >= $_p");
						setState(120); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(118); match(SMALLER_THAN);
								setState(119); expression(0);
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(122); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
						} while ( _alt!=2 && _alt!=-1 );
						}
						break;

					case 8:
						{
						_localctx = new SmallerThanEqualsToExpressionContext(new ExpressionContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(124);
						if (!(21 >= _localctx._p)) throw new FailedPredicateException(this, "21 >= $_p");
						setState(127); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(125); match(SMALLER_THAN_EQUALS_TO);
								setState(126); expression(0);
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(129); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
						} while ( _alt!=2 && _alt!=-1 );
						}
						break;

					case 9:
						{
						_localctx = new GreaterThanExpressionContext(new ExpressionContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(131);
						if (!(20 >= _localctx._p)) throw new FailedPredicateException(this, "20 >= $_p");
						setState(134); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(132); match(GREATER_THAN);
								setState(133); expression(0);
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(136); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
						} while ( _alt!=2 && _alt!=-1 );
						}
						break;

					case 10:
						{
						_localctx = new GreaterThanEqualsToExpressionContext(new ExpressionContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(138);
						if (!(19 >= _localctx._p)) throw new FailedPredicateException(this, "19 >= $_p");
						setState(141); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(139); match(GREATER_THAN_EQUALS_TO);
								setState(140); expression(0);
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(143); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
						} while ( _alt!=2 && _alt!=-1 );
						}
						break;

					case 11:
						{
						_localctx = new EqualsToExpressionContext(new ExpressionContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(145);
						if (!(18 >= _localctx._p)) throw new FailedPredicateException(this, "18 >= $_p");
						setState(148); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(146); match(EQUALS_TO);
								setState(147); expression(0);
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(150); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
						} while ( _alt!=2 && _alt!=-1 );
						}
						break;

					case 12:
						{
						_localctx = new NotEqualsToExpressionContext(new ExpressionContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(152);
						if (!(17 >= _localctx._p)) throw new FailedPredicateException(this, "17 >= $_p");
						setState(155); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(153); match(NOT_EQUALS_TO);
								setState(154); expression(0);
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(157); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
						} while ( _alt!=2 && _alt!=-1 );
						}
						break;

					case 13:
						{
						_localctx = new ArrayAccessExpressionContext(new ExpressionContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(159);
						if (!(11 >= _localctx._p)) throw new FailedPredicateException(this, "11 >= $_p");
						{
						setState(160); match(LEFT_BLOCKBRACE);
						setState(161); expression(0);
						setState(162); match(RIGHT_BLOCKBRACE);
						}
						}
						break;

					case 14:
						{
						_localctx = new RecordAccessExpressionContext(new ExpressionContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(164);
						if (!(8 >= _localctx._p)) throw new FailedPredicateException(this, "8 >= $_p");
						setState(165); match(DOT);
						setState(166); match(IDENTIFIER);
						}
						break;
					}
					} 
				}
				setState(171);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_block);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(180);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					setState(178);
					switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
					case 1:
						{
						setState(172); declaration();
						}
						break;

					case 2:
						{
						setState(173); statement();
						}
						break;

					case 3:
						{
						setState(174); match(LEFT_BRACE);
						setState(175); block();
						setState(176); match(RIGHT_BRACE);
						}
						break;
					}
					} 
				}
				setState(182);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_declaration);
		try {
			setState(192);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(183); variabledeclaration();
				setState(184); match(SEMICOLON);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(186); finaldeclaration();
				setState(187); match(SEMICOLON);
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(189); functiondeclaration();
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(190); typedeclaration();
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(191); enumdeclaration();
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitVariabledeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariabledeclarationContext variabledeclaration() throws RecognitionException {
		VariabledeclarationContext _localctx = new VariabledeclarationContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_variabledeclaration);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(194); match(IDENTIFIER);
			setState(199);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(195); match(COMMA);
					setState(196); match(IDENTIFIER);
					}
					} 
				}
				setState(201);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			}
			setState(202); match(COLON);
			setState(203); primitiveTypeDenoter();
			setState(206);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				{
				setState(204); match(BECOMES);
				setState(205); expression(0);
				}
				break;
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitFinaldeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FinaldeclarationContext finaldeclaration() throws RecognitionException {
		FinaldeclarationContext _localctx = new FinaldeclarationContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_finaldeclaration);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(208); match(IDENTIFIER);
			setState(213);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(209); match(COMMA);
					setState(210); match(IDENTIFIER);
					}
					} 
				}
				setState(215);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			}
			setState(216); match(COLON);
			setState(217); match(FINAL);
			setState(218); primitiveTypeDenoter();
			setState(219); match(BECOMES);
			setState(220); expression(0);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitTypedeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypedeclarationContext typedeclaration() throws RecognitionException {
		TypedeclarationContext _localctx = new TypedeclarationContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_typedeclaration);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(222); match(TYPE);
			setState(223); match(IDENTIFIER);
			setState(224); match(LEFT_BRACE);
			setState(225); fielddeclaration();
			setState(230);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(226); match(COMMA);
					setState(227); fielddeclaration();
					}
					} 
				}
				setState(232);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			}
			setState(233); match(RIGHT_BRACE);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitFielddeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FielddeclarationContext fielddeclaration() throws RecognitionException {
		FielddeclarationContext _localctx = new FielddeclarationContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_fielddeclaration);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(235); match(IDENTIFIER);
			setState(240);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(236); match(COMMA);
					setState(237); match(IDENTIFIER);
					}
					} 
				}
				setState(242);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			}
			setState(243); match(COLON);
			setState(244); primitiveTypeDenoter();
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitPrimitiveTypeDenoter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimitiveTypeDenoterContext primitiveTypeDenoter() throws RecognitionException {
		PrimitiveTypeDenoterContext _localctx = new PrimitiveTypeDenoterContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_primitiveTypeDenoter);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(251);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(246); match(LEFT_BLOCKBRACE);
					setState(247); match(NUMBER);
					setState(248); match(RIGHT_BLOCKBRACE);
					}
					} 
				}
				setState(253);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			}
			setState(254); match(IDENTIFIER);
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
		public TerminalNode SEMICOLON() { return getToken(BramsprParser.SEMICOLON, 0); }
		public TerminalNode RIGHT_BRACE() { return getToken(BramsprParser.RIGHT_BRACE, 0); }
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitFunctiondeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctiondeclarationContext functiondeclaration() throws RecognitionException {
		FunctiondeclarationContext _localctx = new FunctiondeclarationContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_functiondeclaration);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(256); match(FUNCTION);
			setState(257); primitiveTypeDenoter();
			setState(258); match(IDENTIFIER);
			setState(259); match(LEFT_PARENTHESIS);
			setState(268);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				{
				setState(260); variabledeclaration();
				setState(265);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
				while ( _alt!=2 && _alt!=-1 ) {
					if ( _alt==1 ) {
						{
						{
						setState(261); match(COMMA);
						setState(262); variabledeclaration();
						}
						} 
					}
					setState(267);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
				}
				}
				break;
			}
			setState(270); match(RIGHT_PARENTHESIS);
			setState(271); match(LEFT_BRACE);
			setState(272); block();
			setState(277);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				{
				setState(273); match(RETURN);
				setState(274); expression(0);
				setState(275); match(SEMICOLON);
				}
				break;
			}
			setState(279); match(RIGHT_BRACE);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitEnumdeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnumdeclarationContext enumdeclaration() throws RecognitionException {
		EnumdeclarationContext _localctx = new EnumdeclarationContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_enumdeclaration);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(281); match(ENUM);
			setState(282); match(IDENTIFIER);
			setState(283); match(LEFT_BRACE);
			setState(284); match(IDENTIFIER);
			setState(289);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(285); match(COMMA);
					setState(286); match(IDENTIFIER);
					}
					} 
				}
				setState(291);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			}
			setState(292); match(RIGHT_BRACE);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitPutBoolExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PutStringExpressionContext extends FunctioncallContext {
		public TerminalNode LEFT_PARENTHESIS() { return getToken(BramsprParser.LEFT_PARENTHESIS, 0); }
		public TerminalNode RIGHT_PARENTHESIS() { return getToken(BramsprParser.RIGHT_PARENTHESIS, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode PUTSTRING() { return getToken(BramsprParser.PUTSTRING, 0); }
		public PutStringExpressionContext(FunctioncallContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitPutStringExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class GetBoolExpressionContext extends FunctioncallContext {
		public TerminalNode LEFT_PARENTHESIS() { return getToken(BramsprParser.LEFT_PARENTHESIS, 0); }
		public TerminalNode RIGHT_PARENTHESIS() { return getToken(BramsprParser.RIGHT_PARENTHESIS, 0); }
		public TerminalNode GETBOOL() { return getToken(BramsprParser.GETBOOL, 0); }
		public GetBoolExpressionContext(FunctioncallContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitGetBoolExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctioncallContext functioncall() throws RecognitionException {
		FunctioncallContext _localctx = new FunctioncallContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_functioncall);
		try {
			int _alt;
			setState(336);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				_localctx = new GetIntExpressionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(294); match(GETINT);
				setState(295); match(LEFT_PARENTHESIS);
				setState(296); match(RIGHT_PARENTHESIS);
				}
				break;

			case 2:
				_localctx = new GetCharExpressionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(297); match(GETCHAR);
				setState(298); match(LEFT_PARENTHESIS);
				setState(299); match(RIGHT_PARENTHESIS);
				}
				break;

			case 3:
				_localctx = new GetBoolExpressionContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(300); match(GETBOOL);
				setState(301); match(LEFT_PARENTHESIS);
				setState(302); match(RIGHT_PARENTHESIS);
				}
				break;

			case 4:
				_localctx = new PutIntExpressionContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(303); match(PUTINT);
				setState(304); match(LEFT_PARENTHESIS);
				setState(305); expression(0);
				setState(306); match(RIGHT_PARENTHESIS);
				}
				break;

			case 5:
				_localctx = new PutCharExpressionContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(308); match(PUTCHAR);
				setState(309); match(LEFT_PARENTHESIS);
				setState(310); expression(0);
				setState(311); match(RIGHT_PARENTHESIS);
				}
				break;

			case 6:
				_localctx = new PutBoolExpressionContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(313); match(PUTBOOL);
				setState(314); match(LEFT_PARENTHESIS);
				setState(315); expression(0);
				setState(316); match(RIGHT_PARENTHESIS);
				}
				break;

			case 7:
				_localctx = new PutStringExpressionContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(318); match(PUTSTRING);
				setState(319); match(LEFT_PARENTHESIS);
				setState(320); expression(0);
				setState(321); match(RIGHT_PARENTHESIS);
				}
				break;

			case 8:
				_localctx = new FunctionCallExpressionContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(323); match(IDENTIFIER);
				setState(324); match(LEFT_PARENTHESIS);
				setState(333);
				switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
				case 1:
					{
					setState(325); expression(0);
					setState(330);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
					while ( _alt!=2 && _alt!=-1 ) {
						if ( _alt==1 ) {
							{
							{
							setState(326); match(COMMA);
							setState(327); expression(0);
							}
							} 
						}
						setState(332);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
					}
					}
					break;
				}
				setState(335); match(RIGHT_PARENTHESIS);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_statement);
		try {
			setState(349);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(338); ifstatement();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(339); whilestatement();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(340); assignment();
				setState(341); match(SEMICOLON);
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(343); swapstatement();
				setState(344); match(SEMICOLON);
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(346); expression(0);
				setState(347); match(SEMICOLON);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitIfstatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfstatementContext ifstatement() throws RecognitionException {
		IfstatementContext _localctx = new IfstatementContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_ifstatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(351); match(IF);
			setState(352); expression(0);
			setState(353); match(LEFT_BRACE);
			setState(354); block();
			setState(355); match(RIGHT_BRACE);
			setState(361);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				{
				setState(356); match(ELSE);
				setState(357); match(LEFT_BRACE);
				setState(358); block();
				setState(359); match(RIGHT_BRACE);
				}
				break;
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitWhilestatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhilestatementContext whilestatement() throws RecognitionException {
		WhilestatementContext _localctx = new WhilestatementContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_whilestatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(363); match(WHILE);
			setState(364); expression(0);
			setState(365); match(LEFT_BRACE);
			setState(366); block();
			setState(367); match(RIGHT_BRACE);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_assignment);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(372); 
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(369); expression(0);
					setState(370); match(BECOMES);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(374); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			} while ( _alt!=2 && _alt!=-1 );
			setState(376); expression(0);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BramsprVisitor ) return ((BramsprVisitor<? extends T>)visitor).visitSwapstatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SwapstatementContext swapstatement() throws RecognitionException {
		SwapstatementContext _localctx = new SwapstatementContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_swapstatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(378); expression(0);
			setState(379); match(SWAP);
			setState(380); expression(0);
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
		case 1: return expression_sempred((ExpressionContext)_localctx, predIndex);
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
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\3;\u0181\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3?\n\3\f\3\16\3B\13\3\3\3\5\3E\n"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3Q\n\3\f\3\16\3T\13\3\3\3"+
		"\3\3\3\3\5\3Y\n\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3a\n\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\6\3{\n\3\r\3\16\3|\3\3\3\3\3\3\6\3\u0082\n\3\r\3\16\3\u0083\3\3"+
		"\3\3\3\3\6\3\u0089\n\3\r\3\16\3\u008a\3\3\3\3\3\3\6\3\u0090\n\3\r\3\16"+
		"\3\u0091\3\3\3\3\3\3\6\3\u0097\n\3\r\3\16\3\u0098\3\3\3\3\3\3\6\3\u009e"+
		"\n\3\r\3\16\3\u009f\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3\u00aa\n\3\f\3"+
		"\16\3\u00ad\13\3\3\4\3\4\3\4\3\4\3\4\3\4\7\4\u00b5\n\4\f\4\16\4\u00b8"+
		"\13\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5\u00c3\n\5\3\6\3\6\3\6\7"+
		"\6\u00c8\n\6\f\6\16\6\u00cb\13\6\3\6\3\6\3\6\3\6\5\6\u00d1\n\6\3\7\3\7"+
		"\3\7\7\7\u00d6\n\7\f\7\16\7\u00d9\13\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\7\b\u00e7\n\b\f\b\16\b\u00ea\13\b\3\b\3\b\3\t\3\t\3\t"+
		"\7\t\u00f1\n\t\f\t\16\t\u00f4\13\t\3\t\3\t\3\t\3\n\3\n\3\n\7\n\u00fc\n"+
		"\n\f\n\16\n\u00ff\13\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\7\13"+
		"\u010a\n\13\f\13\16\13\u010d\13\13\5\13\u010f\n\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\5\13\u0118\n\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\7\f"+
		"\u0122\n\f\f\f\16\f\u0125\13\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\7\r\u014b\n\r\f\r\16\r\u014e\13\r\5"+
		"\r\u0150\n\r\3\r\5\r\u0153\n\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\5\16\u0160\n\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\5\17\u016c\n\17\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21"+
		"\6\21\u0177\n\21\r\21\16\21\u0178\3\21\3\21\3\22\3\22\3\22\3\22\3\22\2"+
		"\23\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"\2\5\4\2\5\6\22\22\3\2\7"+
		"\t\3\2\5\6\u01b3\2$\3\2\2\2\4`\3\2\2\2\6\u00b6\3\2\2\2\b\u00c2\3\2\2\2"+
		"\n\u00c4\3\2\2\2\f\u00d2\3\2\2\2\16\u00e0\3\2\2\2\20\u00ed\3\2\2\2\22"+
		"\u00fd\3\2\2\2\24\u0102\3\2\2\2\26\u011b\3\2\2\2\30\u0152\3\2\2\2\32\u015f"+
		"\3\2\2\2\34\u0161\3\2\2\2\36\u016d\3\2\2\2 \u0176\3\2\2\2\"\u017c\3\2"+
		"\2\2$%\5\6\4\2%\3\3\2\2\2&\'\b\3\1\2\'(\t\2\2\2(a\5\4\3\2)*\7,\2\2*+\5"+
		"\4\3\2+,\7-\2\2,a\3\2\2\2-.\7,\2\2./\5 \21\2/\60\7-\2\2\60a\3\2\2\2\61"+
		"a\5\30\r\2\62\63\7%\2\2\63\64\7\63\2\2\64\65\7\66\2\2\65\66\7\63\2\2\66"+
		"a\7\66\2\2\678\7\66\2\289\7\63\2\29a\7\66\2\2:D\7.\2\2;<\5\4\3\2<=\7\62"+
		"\2\2=?\3\2\2\2>;\3\2\2\2?B\3\2\2\2@>\3\2\2\2@A\3\2\2\2AC\3\2\2\2B@\3\2"+
		"\2\2CE\5\4\3\2D@\3\2\2\2DE\3\2\2\2EF\3\2\2\2Fa\7/\2\2GH\7\66\2\2HI\7*"+
		"\2\2IJ\7.\2\2JX\7\66\2\2KL\7\66\2\2LM\7\3\2\2MN\5\4\3\2NO\7\62\2\2OQ\3"+
		"\2\2\2PK\3\2\2\2QT\3\2\2\2RP\3\2\2\2RS\3\2\2\2SU\3\2\2\2TR\3\2\2\2UV\7"+
		"\66\2\2VW\7\3\2\2WY\5\4\3\2XR\3\2\2\2XY\3\2\2\2YZ\3\2\2\2Za\7/\2\2[a\7"+
		"\66\2\2\\a\7\67\2\2]a\78\2\2^a\7\65\2\2_a\7\64\2\2`&\3\2\2\2`)\3\2\2\2"+
		"`-\3\2\2\2`\61\3\2\2\2`\62\3\2\2\2`\67\3\2\2\2`:\3\2\2\2`G\3\2\2\2`[\3"+
		"\2\2\2`\\\3\2\2\2`]\3\2\2\2`^\3\2\2\2`_\3\2\2\2a\u00ab\3\2\2\2bc\6\3\2"+
		"\3cd\7\21\2\2d\u00aa\5\4\3\2ef\6\3\3\3fg\t\3\2\2g\u00aa\5\4\3\2hi\6\3"+
		"\4\3ij\t\4\2\2j\u00aa\5\4\3\2kl\6\3\5\3lm\7\23\2\2m\u00aa\5\4\3\2no\6"+
		"\3\6\3op\7\24\2\2p\u00aa\5\4\3\2qr\6\3\7\3rs\7\16\2\2st\5\4\3\2tu\7\20"+
		"\2\2uv\5\4\3\2v\u00aa\3\2\2\2wz\6\3\b\3xy\7\n\2\2y{\5\4\3\2zx\3\2\2\2"+
		"{|\3\2\2\2|z\3\2\2\2|}\3\2\2\2}\u00aa\3\2\2\2~\u0081\6\3\t\3\177\u0080"+
		"\7\13\2\2\u0080\u0082\5\4\3\2\u0081\177\3\2\2\2\u0082\u0083\3\2\2\2\u0083"+
		"\u0081\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u00aa\3\2\2\2\u0085\u0088\6\3"+
		"\n\3\u0086\u0087\7\f\2\2\u0087\u0089\5\4\3\2\u0088\u0086\3\2\2\2\u0089"+
		"\u008a\3\2\2\2\u008a\u0088\3\2\2\2\u008a\u008b\3\2\2\2\u008b\u00aa\3\2"+
		"\2\2\u008c\u008f\6\3\13\3\u008d\u008e\7\r\2\2\u008e\u0090\5\4\3\2\u008f"+
		"\u008d\3\2\2\2\u0090\u0091\3\2\2\2\u0091\u008f\3\2\2\2\u0091\u0092\3\2"+
		"\2\2\u0092\u00aa\3\2\2\2\u0093\u0096\6\3\f\3\u0094\u0095\7\16\2\2\u0095"+
		"\u0097\5\4\3\2\u0096\u0094\3\2\2\2\u0097\u0098\3\2\2\2\u0098\u0096\3\2"+
		"\2\2\u0098\u0099\3\2\2\2\u0099\u00aa\3\2\2\2\u009a\u009d\6\3\r\3\u009b"+
		"\u009c\7\17\2\2\u009c\u009e\5\4\3\2\u009d\u009b\3\2\2\2\u009e\u009f\3"+
		"\2\2\2\u009f\u009d\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\u00aa\3\2\2\2\u00a1"+
		"\u00a2\6\3\16\3\u00a2\u00a3\7\60\2\2\u00a3\u00a4\5\4\3\2\u00a4\u00a5\7"+
		"\61\2\2\u00a5\u00aa\3\2\2\2\u00a6\u00a7\6\3\17\3\u00a7\u00a8\7\63\2\2"+
		"\u00a8\u00aa\7\66\2\2\u00a9b\3\2\2\2\u00a9e\3\2\2\2\u00a9h\3\2\2\2\u00a9"+
		"k\3\2\2\2\u00a9n\3\2\2\2\u00a9q\3\2\2\2\u00a9w\3\2\2\2\u00a9~\3\2\2\2"+
		"\u00a9\u0085\3\2\2\2\u00a9\u008c\3\2\2\2\u00a9\u0093\3\2\2\2\u00a9\u009a"+
		"\3\2\2\2\u00a9\u00a1\3\2\2\2\u00a9\u00a6\3\2\2\2\u00aa\u00ad\3\2\2\2\u00ab"+
		"\u00a9\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\5\3\2\2\2\u00ad\u00ab\3\2\2\2"+
		"\u00ae\u00b5\5\b\5\2\u00af\u00b5\5\32\16\2\u00b0\u00b1\7.\2\2\u00b1\u00b2"+
		"\5\6\4\2\u00b2\u00b3\7/\2\2\u00b3\u00b5\3\2\2\2\u00b4\u00ae\3\2\2\2\u00b4"+
		"\u00af\3\2\2\2\u00b4\u00b0\3\2\2\2\u00b5\u00b8\3\2\2\2\u00b6\u00b4\3\2"+
		"\2\2\u00b6\u00b7\3\2\2\2\u00b7\7\3\2\2\2\u00b8\u00b6\3\2\2\2\u00b9\u00ba"+
		"\5\n\6\2\u00ba\u00bb\7+\2\2\u00bb\u00c3\3\2\2\2\u00bc\u00bd\5\f\7\2\u00bd"+
		"\u00be\7+\2\2\u00be\u00c3\3\2\2\2\u00bf\u00c3\5\24\13\2\u00c0\u00c3\5"+
		"\16\b\2\u00c1\u00c3\5\26\f\2\u00c2\u00b9\3\2\2\2\u00c2\u00bc\3\2\2\2\u00c2"+
		"\u00bf\3\2\2\2\u00c2\u00c0\3\2\2\2\u00c2\u00c1\3\2\2\2\u00c3\t\3\2\2\2"+
		"\u00c4\u00c9\7\66\2\2\u00c5\u00c6\7\62\2\2\u00c6\u00c8\7\66\2\2\u00c7"+
		"\u00c5\3\2\2\2\u00c8\u00cb\3\2\2\2\u00c9\u00c7\3\2\2\2\u00c9\u00ca\3\2"+
		"\2\2\u00ca\u00cc\3\2\2\2\u00cb\u00c9\3\2\2\2\u00cc\u00cd\7*\2\2\u00cd"+
		"\u00d0\5\22\n\2\u00ce\u00cf\7\3\2\2\u00cf\u00d1\5\4\3\2\u00d0\u00ce\3"+
		"\2\2\2\u00d0\u00d1\3\2\2\2\u00d1\13\3\2\2\2\u00d2\u00d7\7\66\2\2\u00d3"+
		"\u00d4\7\62\2\2\u00d4\u00d6\7\66\2\2\u00d5\u00d3\3\2\2\2\u00d6\u00d9\3"+
		"\2\2\2\u00d7\u00d5\3\2\2\2\u00d7\u00d8\3\2\2\2\u00d8\u00da\3\2\2\2\u00d9"+
		"\u00d7\3\2\2\2\u00da\u00db\7*\2\2\u00db\u00dc\7\'\2\2\u00dc\u00dd\5\22"+
		"\n\2\u00dd\u00de\7\3\2\2\u00de\u00df\5\4\3\2\u00df\r\3\2\2\2\u00e0\u00e1"+
		"\7\34\2\2\u00e1\u00e2\7\66\2\2\u00e2\u00e3\7.\2\2\u00e3\u00e8\5\20\t\2"+
		"\u00e4\u00e5\7\62\2\2\u00e5\u00e7\5\20\t\2\u00e6\u00e4\3\2\2\2\u00e7\u00ea"+
		"\3\2\2\2\u00e8\u00e6\3\2\2\2\u00e8\u00e9\3\2\2\2\u00e9\u00eb\3\2\2\2\u00ea"+
		"\u00e8\3\2\2\2\u00eb\u00ec\7/\2\2\u00ec\17\3\2\2\2\u00ed\u00f2\7\66\2"+
		"\2\u00ee\u00ef\7\62\2\2\u00ef\u00f1\7\66\2\2\u00f0\u00ee\3\2\2\2\u00f1"+
		"\u00f4\3\2\2\2\u00f2\u00f0\3\2\2\2\u00f2\u00f3\3\2\2\2\u00f3\u00f5\3\2"+
		"\2\2\u00f4\u00f2\3\2\2\2\u00f5\u00f6\7*\2\2\u00f6\u00f7\5\22\n\2\u00f7"+
		"\21\3\2\2\2\u00f8\u00f9\7\60\2\2\u00f9\u00fa\7\67\2\2\u00fa\u00fc\7\61"+
		"\2\2\u00fb\u00f8\3\2\2\2\u00fc\u00ff\3\2\2\2\u00fd\u00fb\3\2\2\2\u00fd"+
		"\u00fe\3\2\2\2\u00fe\u0100\3\2\2\2\u00ff\u00fd\3\2\2\2\u0100\u0101\7\66"+
		"\2\2\u0101\23\3\2\2\2\u0102\u0103\7\33\2\2\u0103\u0104\5\22\n\2\u0104"+
		"\u0105\7\66\2\2\u0105\u010e\7,\2\2\u0106\u010b\5\n\6\2\u0107\u0108\7\62"+
		"\2\2\u0108\u010a\5\n\6\2\u0109\u0107\3\2\2\2\u010a\u010d\3\2\2\2\u010b"+
		"\u0109\3\2\2\2\u010b\u010c\3\2\2\2\u010c\u010f\3\2\2\2\u010d\u010b\3\2"+
		"\2\2\u010e\u0106\3\2\2\2\u010e\u010f\3\2\2\2\u010f\u0110\3\2\2\2\u0110"+
		"\u0111\7-\2\2\u0111\u0112\7.\2\2\u0112\u0117\5\6\4\2\u0113\u0114\7&\2"+
		"\2\u0114\u0115\5\4\3\2\u0115\u0116\7+\2\2\u0116\u0118\3\2\2\2\u0117\u0113"+
		"\3\2\2\2\u0117\u0118\3\2\2\2\u0118\u0119\3\2\2\2\u0119\u011a\7/\2\2\u011a"+
		"\25\3\2\2\2\u011b\u011c\7%\2\2\u011c\u011d\7\66\2\2\u011d\u011e\7.\2\2"+
		"\u011e\u0123\7\66\2\2\u011f\u0120\7\62\2\2\u0120\u0122\7\66\2\2\u0121"+
		"\u011f\3\2\2\2\u0122\u0125\3\2\2\2\u0123\u0121\3\2\2\2\u0123\u0124\3\2"+
		"\2\2\u0124\u0126\3\2\2\2\u0125\u0123\3\2\2\2\u0126\u0127\7/\2\2\u0127"+
		"\27\3\2\2\2\u0128\u0129\7\36\2\2\u0129\u012a\7,\2\2\u012a\u0153\7-\2\2"+
		"\u012b\u012c\7\37\2\2\u012c\u012d\7,\2\2\u012d\u0153\7-\2\2\u012e\u012f"+
		"\7 \2\2\u012f\u0130\7,\2\2\u0130\u0153\7-\2\2\u0131\u0132\7!\2\2\u0132"+
		"\u0133\7,\2\2\u0133\u0134\5\4\3\2\u0134\u0135\7-\2\2\u0135\u0153\3\2\2"+
		"\2\u0136\u0137\7\"\2\2\u0137\u0138\7,\2\2\u0138\u0139\5\4\3\2\u0139\u013a"+
		"\7-\2\2\u013a\u0153\3\2\2\2\u013b\u013c\7#\2\2\u013c\u013d\7,\2\2\u013d"+
		"\u013e\5\4\3\2\u013e\u013f\7-\2\2\u013f\u0153\3\2\2\2\u0140\u0141\7$\2"+
		"\2\u0141\u0142\7,\2\2\u0142\u0143\5\4\3\2\u0143\u0144\7-\2\2\u0144\u0153"+
		"\3\2\2\2\u0145\u0146\7\66\2\2\u0146\u014f\7,\2\2\u0147\u014c\5\4\3\2\u0148"+
		"\u0149\7\62\2\2\u0149\u014b\5\4\3\2\u014a\u0148\3\2\2\2\u014b\u014e\3"+
		"\2\2\2\u014c\u014a\3\2\2\2\u014c\u014d\3\2\2\2\u014d\u0150\3\2\2\2\u014e"+
		"\u014c\3\2\2\2\u014f\u0147\3\2\2\2\u014f\u0150\3\2\2\2\u0150\u0151\3\2"+
		"\2\2\u0151\u0153\7-\2\2\u0152\u0128\3\2\2\2\u0152\u012b\3\2\2\2\u0152"+
		"\u012e\3\2\2\2\u0152\u0131\3\2\2\2\u0152\u0136\3\2\2\2\u0152\u013b\3\2"+
		"\2\2\u0152\u0140\3\2\2\2\u0152\u0145\3\2\2\2\u0153\31\3\2\2\2\u0154\u0160"+
		"\5\34\17\2\u0155\u0160\5\36\20\2\u0156\u0157\5 \21\2\u0157\u0158\7+\2"+
		"\2\u0158\u0160\3\2\2\2\u0159\u015a\5\"\22\2\u015a\u015b\7+\2\2\u015b\u0160"+
		"\3\2\2\2\u015c\u015d\5\4\3\2\u015d\u015e\7+\2\2\u015e\u0160\3\2\2\2\u015f"+
		"\u0154\3\2\2\2\u015f\u0155\3\2\2\2\u015f\u0156\3\2\2\2\u015f\u0159\3\2"+
		"\2\2\u015f\u015c\3\2\2\2\u0160\33\3\2\2\2\u0161\u0162\7\27\2\2\u0162\u0163"+
		"\5\4\3\2\u0163\u0164\7.\2\2\u0164\u0165\5\6\4\2\u0165\u016b\7/\2\2\u0166"+
		"\u0167\7\31\2\2\u0167\u0168\7.\2\2\u0168\u0169\5\6\4\2\u0169\u016a\7/"+
		"\2\2\u016a\u016c\3\2\2\2\u016b\u0166\3\2\2\2\u016b\u016c\3\2\2\2\u016c"+
		"\35\3\2\2\2\u016d\u016e\7\32\2\2\u016e\u016f\5\4\3\2\u016f\u0170\7.\2"+
		"\2\u0170\u0171\5\6\4\2\u0171\u0172\7/\2\2\u0172\37\3\2\2\2\u0173\u0174"+
		"\5\4\3\2\u0174\u0175\7\3\2\2\u0175\u0177\3\2\2\2\u0176\u0173\3\2\2\2\u0177"+
		"\u0178\3\2\2\2\u0178\u0176\3\2\2\2\u0178\u0179\3\2\2\2\u0179\u017a\3\2"+
		"\2\2\u017a\u017b\5\4\3\2\u017b!\3\2\2\2\u017c\u017d\5\4\3\2\u017d\u017e"+
		"\7\4\2\2\u017e\u017f\5\4\3\2\u017f#\3\2\2\2\"@DRX`|\u0083\u008a\u0091"+
		"\u0098\u009f\u00a9\u00ab\u00b4\u00b6\u00c2\u00c9\u00d0\u00d7\u00e8\u00f2"+
		"\u00fd\u010b\u010e\u0117\u0123\u014c\u014f\u0152\u015f\u016b\u0178";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}