package bramspr;

import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import bramspr.BramsprParser.AdditionExpressionContext;
import bramspr.BramsprParser.AndExpressionContext;
import bramspr.BramsprParser.AssignExpressionContext;
import bramspr.BramsprParser.AssignmentContext;
import bramspr.BramsprParser.BoolLiteralExpressionContext;
import bramspr.BramsprParser.CharLiteralExpressionContext;
import bramspr.BramsprParser.DeclarationContext;
import bramspr.BramsprParser.EnumdeclarationContext;
import bramspr.BramsprParser.EqualsToExpressionContext;
import bramspr.BramsprParser.FunctionCallExpressionContext;
import bramspr.BramsprParser.FunctionExpressionContext;
import bramspr.BramsprParser.FunctiondeclarationContext;
import bramspr.BramsprParser.GetBoolExpressionContext;
import bramspr.BramsprParser.GetCharExpressionContext;
import bramspr.BramsprParser.GetIntExpressionContext;
import bramspr.BramsprParser.GreaterThanEqualsToExpressionContext;
import bramspr.BramsprParser.GreaterThanExpressionContext;
import bramspr.BramsprParser.IfstatementContext;
import bramspr.BramsprParser.IntLiteralExpressionContext;
import bramspr.BramsprParser.MultiplicationExpressionContext;
import bramspr.BramsprParser.NotEqualsToExpressionContext;
import bramspr.BramsprParser.OrExpressionContext;
import bramspr.BramsprParser.ParenthesisExpressionContext;
import bramspr.BramsprParser.PlusMinusExpressionContext;
import bramspr.BramsprParser.PowerExpressionContext;
import bramspr.BramsprParser.PrimitiveTypeContext;
import bramspr.BramsprParser.PrintstatementContext;
import bramspr.BramsprParser.ProgramContext;
import bramspr.BramsprParser.SmallerThanEqualsToExpressionContext;
import bramspr.BramsprParser.SmallerThanExpressionContext;
import bramspr.BramsprParser.StatementContext;
import bramspr.BramsprParser.StringLiteralExpressionContext;
import bramspr.BramsprParser.TypedeclarationContext;
import bramspr.BramsprParser.UnaryExpressionContext;
import bramspr.BramsprParser.VariableExpressionContext;
import bramspr.BramsprParser.VariabledeclarationContext;
import bramspr.BramsprParser.WhilestatementContext;

public class BramsprChecker implements BramsprVisitor<bramspr.BramsprChecker.Type> {
	
	public enum Type {
		INT,
		BOOL,
		CHAR,
		NONE
	}

	@Override
	public bramspr.BramsprChecker.Type visit(ParseTree arg0) {
		return Type.NONE;
	}

	@Override
	/**
	 * Bezoekt alle kinderen van de node arg0, en geeft het type van het laatste kind als resultaat terug.
	 * Geeft NONE terug als er geen kinderen zijn. 
	 * 
	 * @ensure visitChildren(arg0) == visit(arg0.getLastChild)
	 */
	public bramspr.BramsprChecker.Type visitChildren(RuleNode arg0) {
		Type t = Type.NONE;
		for(int i = 0; i < arg0.getChildCount(); i++) {
			t = visit(arg0.getChild(i));
		}
		return t;
	}

	@Override
	public bramspr.BramsprChecker.Type visitErrorNode(ErrorNode arg0) {
		// TODO Auto-generated method stub
		return Type.NONE;
	}

	@Override
	public bramspr.BramsprChecker.Type visitTerminal(TerminalNode arg0) {
		// TODO Auto-generated method stub
		return Type.NONE;
	}

	@Override
	public bramspr.BramsprChecker.Type visitEnumdeclaration(EnumdeclarationContext ctx) {
		// TODO Auto-generated method stub
		return Type.NONE;
	}

	@Override
	public bramspr.BramsprChecker.Type visitParenthesisExpression(ParenthesisExpressionContext ctx) {
		// Hier zijn geen eisen aan de inhoud van ctx die niet al door de parser zijn gecontroleerd.
		return visit(ctx.getChild(0));
	}

	@Override
	public bramspr.BramsprChecker.Type visitUnaryExpression(UnaryExpressionContext ctx) {
		Type argType = visit(ctx.getChild(1));
		
		if(ctx.getChild(0).getText().equals("!") && argType != Type.BOOL) {
			System.out.println("error on line; " + ctx.getStart().getLine() + ": bool expected.");
		}
		
		if(ctx.getChild(1).getText().equals("-") && argType != Type.INT) {
			System.out.println("error on line; " + ctx.getStart().getLine() + ": bool expected.");
		}
		
		if(ctx.getChild(1).getText().equals("+") && argType != Type.INT) {
			System.out.println("error on line; " + ctx.getStart().getLine() + ": int expected.");
		}
		
		return Type.NONE;
	}

	@Override
	public bramspr.BramsprChecker.Type visitAdditionExpression(AdditionExpressionContext ctx) {
		if(ctx.getChildCount() != 2) {
			System.out.println("error on line; " + ctx.getStart().getLine() + ": the " + ctx.getChild(1).getText() + " expects two arguments.");
		}
		
		if(Type.INT != visit(ctx.getChild(0))) {
			System.out.println("error on line; " + ctx.getStart().getLine() + ": int expected.");
		}
		
		if(Type.INT != visit(ctx.getChild(2))) {
			System.out.println("error on line; " + ctx.getStart().getLine() + ": int expected.");
		}
		
		return Type.NONE;
	}

	@Override
	public bramspr.BramsprChecker.Type visitGetIntExpression(GetIntExpressionContext ctx) {
		return Type.INT;
	}

	@Override
	public bramspr.BramsprChecker.Type visitFunctiondeclaration(FunctiondeclarationContext ctx) {
		// TODO Auto-generated method stub
		return Type.NONE;
	}

	@Override
	public bramspr.BramsprChecker.Type visitAssignExpression(AssignExpressionContext ctx) {
		// TODO Auto-generated method stub
		return Type.NONE;
	}

	@Override
	public bramspr.BramsprChecker.Type visitTypedeclaration(TypedeclarationContext ctx) {
		// TODO Auto-generated method stub
		return Type.NONE;
	}

	@Override
	public bramspr.BramsprChecker.Type visitOrExpression(OrExpressionContext ctx) {
		// TODO Auto-generated method stub
		return Type.NONE;
	}

	@Override
	public bramspr.BramsprChecker.Type visitPowerExpression(PowerExpressionContext ctx) {
		// TODO Auto-generated method stub
		return Type.NONE;
	}

	@Override
	public bramspr.BramsprChecker.Type visitWhilestatement(WhilestatementContext ctx) {
		// TODO Auto-generated method stub
		return Type.NONE;
	}

	@Override
	public bramspr.BramsprChecker.Type visitNotEqualsToExpression(NotEqualsToExpressionContext ctx) {
		// TODO Auto-generated method stub
		return Type.NONE;
	}

	@Override
	public bramspr.BramsprChecker.Type visitGetBoolExpression(GetBoolExpressionContext ctx) {
		// TODO Auto-generated method stub
		return Type.NONE;
	}

	@Override
	public bramspr.BramsprChecker.Type visitAndExpression(AndExpressionContext ctx) {
		// TODO Auto-generated method stub
		return Type.NONE;
	}

	@Override
	public bramspr.BramsprChecker.Type visitEqualsToExpression(EqualsToExpressionContext ctx) {
		// TODO Auto-generated method stub
		return Type.NONE;
	}

	@Override
	public bramspr.BramsprChecker.Type visitGreaterThanExpression(GreaterThanExpressionContext ctx) {
		// TODO Auto-generated method stub
		return Type.NONE;
	}

	@Override
	public bramspr.BramsprChecker.Type visitCharLiteralExpression(CharLiteralExpressionContext ctx) {
		// TODO Auto-generated method stub
		return Type.NONE;
	}

	@Override
	public bramspr.BramsprChecker.Type visitSmallerThanExpression(SmallerThanExpressionContext ctx) {
		// TODO Auto-generated method stub
		return Type.NONE;
	}

	@Override
	public bramspr.BramsprChecker.Type visitIfstatement(IfstatementContext ctx) {
		// TODO Auto-generated method stub
		return Type.NONE;
	}

	@Override
	public bramspr.BramsprChecker.Type visitPrintstatement(PrintstatementContext ctx) {
		// TODO Auto-generated method stub
		return Type.NONE;
	}

	@Override
	public bramspr.BramsprChecker.Type visitMultiplicationExpression(
			MultiplicationExpressionContext ctx) {
		// TODO Auto-generated method stub
		return Type.NONE;
	}

	@Override
	public bramspr.BramsprChecker.Type visitPlusMinusExpression(PlusMinusExpressionContext ctx) {
		// TODO Auto-generated method stub
		return Type.NONE;
	}

	@Override
	public bramspr.BramsprChecker.Type visitStringLiteralExpression(
			StringLiteralExpressionContext ctx) {
		// TODO Auto-generated method stub
		return Type.NONE;
	}

	@Override
	public bramspr.BramsprChecker.Type visitGetCharExpression(GetCharExpressionContext ctx) {
		// TODO Auto-generated method stub
		return Type.NONE;
	}

	@Override
	public bramspr.BramsprChecker.Type visitVariableExpression(VariableExpressionContext ctx) {
		// TODO Auto-generated method stub
		return Type.NONE;
	}

	@Override
	public bramspr.BramsprChecker.Type visitGreaterThanEqualsToExpression(
			GreaterThanEqualsToExpressionContext ctx) {
		// TODO Auto-generated method stub
		return Type.NONE;
	}

	@Override
	public bramspr.BramsprChecker.Type visitFunctionExpression(FunctionExpressionContext ctx) {
		// TODO Auto-generated method stub
		return Type.NONE;
	}

	@Override
	public bramspr.BramsprChecker.Type visitDeclaration(DeclarationContext ctx) {
		// TODO Auto-generated method stub
		return Type.NONE;
	}

	@Override
	public bramspr.BramsprChecker.Type visitIntLiteralExpression(IntLiteralExpressionContext ctx) {
		// TODO Auto-generated method stub
		return Type.NONE;
	}

	@Override
	public bramspr.BramsprChecker.Type visitSmallerThanEqualsToExpression(
			SmallerThanEqualsToExpressionContext ctx) {
		// TODO Auto-generated method stub
		return Type.NONE;
	}

	@Override
	public bramspr.BramsprChecker.Type visitStatement(StatementContext ctx) {
		// TODO Auto-generated method stub
		return Type.NONE;
	}

	@Override
	public bramspr.BramsprChecker.Type visitVariabledeclaration(VariabledeclarationContext ctx) {
		// TODO Auto-generated method stub
		return Type.NONE;
	}

	@Override
	public bramspr.BramsprChecker.Type visitAssignment(AssignmentContext ctx) {
		// TODO Auto-generated method stub
		return Type.NONE;
	}

	@Override
	public bramspr.BramsprChecker.Type visitPrimitiveType(PrimitiveTypeContext ctx) {
		// TODO Auto-generated method stub
		return Type.NONE;
	}

	@Override
	public bramspr.BramsprChecker.Type visitProgram(ProgramContext ctx) {
		// TODO Auto-generated method stub
		return Type.NONE;
	}

	@Override
	public bramspr.BramsprChecker.Type visitFunctionCallExpression(FunctionCallExpressionContext ctx) {
		// TODO Auto-generated method stub
		return Type.NONE;
	}

	@Override
	public bramspr.BramsprChecker.Type visitBoolLiteralExpression(BoolLiteralExpressionContext ctx) {
		// TODO Auto-generated method stub
		return Type.NONE;
	}

}
