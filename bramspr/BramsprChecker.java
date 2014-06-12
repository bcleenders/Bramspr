package bramspr;

import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
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

/**
 * BramsprChecker controleert of een gegeven ParseTree voldoet aan de contextuele eisen van Bramspr.
 * 
 * @author Bram&Jasper
 *
 * Deze klasse implementeert BramsprVisitor (impliciet) en extend BramsprBaseVisitor dus ook AbstractParseTreeVisitor.
 * Iedere functie geeft het (primitieve) type terug dat de bijbehorende programmacode terug zou geven.
 */
public class BramsprChecker extends
		BramsprBaseVisitor<bramspr.BramsprChecker.Type> {
	
	/**
	 * Type bevat de vier soorten primitieve waardes.
	 */
	public enum Type {
		INT, BOOL, CHAR, VOID
	}

	@Override
	/**
	 * Bezoekt een node, overgeërfd van AbstractParseTreeListener
	 */
	public bramspr.BramsprChecker.Type visit(ParseTree arg0) {
		return super.visit(arg0);
	}

	@Override
	/**
	 * Bezoekt een error node, maar geeft geen return type terug (want error nodes hebben geen type).
	 */
	public bramspr.BramsprChecker.Type visitErrorNode(ErrorNode arg0) {
		super.visit(arg0);
		
		// Een error node heeft geen return type
		return Type.VOID;
	}

	@Override
	public bramspr.BramsprChecker.Type visitTerminal(TerminalNode arg0) {
		// TODO Auto-generated method stub
		return Type.VOID;
	}

	@Override
	public bramspr.BramsprChecker.Type visitEnumdeclaration(
			EnumdeclarationContext ctx) {
		// TODO Auto-generated method stub
		return Type.VOID;
	}

	@Override
	public bramspr.BramsprChecker.Type visitParenthesisExpression(
			ParenthesisExpressionContext ctx) {
		// Hier zijn geen eisen aan de inhoud van ctx die niet al door de parser
		// zijn gecontroleerd.
		return visit(ctx.getChild(0));
	}

	@Override
	/**
	 * Controleert de contextbeperkingen van een unaryExpression.
	 * Als het eerste kind een + of - is, moet het tweede kind een int zijn. De return type is dan ook een int.
	 * Als het eerste kind een ! is, moet het tweede kind een bool zijn. De return type is dan ook een bool.
	 */
	public bramspr.BramsprChecker.Type visitUnaryExpression(UnaryExpressionContext ctx) {
		// Vraag het type op van de int/bool node
		Type argType = visit(ctx.getChild(1));
		
		if(ctx.getChild(0).getText().equals("!")) {
			if(argType == Type.BOOL) {
				return Type.BOOL; // De negatie van kind 2 is een boolean
			} 
			else {
				System.out.println("error on line; " + ctx.getStart().getLine() + ": bool expected.");
			}
		}
		
		if(ctx.getChild(1).getText().equals("-") ||
		   ctx.getChild(1).getText().equals("+") ) {
			if(argType == Type.INT) {
				return Type.INT; // Kind 2 (of de negatieve waarde daarvan) is een int
			}
			else {
				System.out.println("error on line; " + ctx.getStart().getLine() + ": int expected.");
			}
		}
		
		return Type.VOID;
	}

	@Override
	public bramspr.BramsprChecker.Type visitAdditionExpression(
			AdditionExpressionContext ctx) {
		if (ctx.getChildCount() != 2) {
			System.out.println("error on line; " + ctx.getStart().getLine()
					+ ": the " + ctx.getChild(1).getText()
					+ " expects two arguments.");
		}

		if (Type.INT != visit(ctx.getChild(0))) {
			System.out.println("error on line; " + ctx.getStart().getLine()
					+ ": int expected.");
		}

		if (Type.INT != visit(ctx.getChild(2))) {
			System.out.println("error on line; " + ctx.getStart().getLine()
					+ ": int expected.");
		}

		return Type.VOID;
	}

	@Override
	public bramspr.BramsprChecker.Type visitGetIntExpression(
			GetIntExpressionContext ctx) {
		return Type.INT;
	}

	@Override
	public bramspr.BramsprChecker.Type visitFunctiondeclaration(
			FunctiondeclarationContext ctx) {
		// TODO Auto-generated method stub
		return Type.VOID;
	}

	@Override
	public bramspr.BramsprChecker.Type visitAssignExpression(
			AssignExpressionContext ctx) {
		// TODO Auto-generated method stub
		return Type.VOID;
	}

	@Override
	public bramspr.BramsprChecker.Type visitTypedeclaration(
			TypedeclarationContext ctx) {
		// TODO Auto-generated method stub
		return Type.VOID;
	}

	@Override
	public bramspr.BramsprChecker.Type visitOrExpression(OrExpressionContext ctx) {
		// TODO Auto-generated method stub
		return Type.VOID;
	}

	@Override
	public bramspr.BramsprChecker.Type visitPowerExpression(
			PowerExpressionContext ctx) {
		// TODO Auto-generated method stub
		return Type.VOID;
	}

	@Override
	public bramspr.BramsprChecker.Type visitWhilestatement(
			WhilestatementContext ctx) {
		// TODO Auto-generated method stub
		return Type.VOID;
	}

	@Override
	public bramspr.BramsprChecker.Type visitNotEqualsToExpression(
			NotEqualsToExpressionContext ctx) {
		// TODO Auto-generated method stub
		return Type.VOID;
	}

	@Override
	public bramspr.BramsprChecker.Type visitGetBoolExpression(
			GetBoolExpressionContext ctx) {
		// TODO Auto-generated method stub
		return Type.VOID;
	}

	@Override
	public bramspr.BramsprChecker.Type visitAndExpression(
			AndExpressionContext ctx) {
		// TODO Auto-generated method stub
		return Type.VOID;
	}

	@Override
	public bramspr.BramsprChecker.Type visitEqualsToExpression(
			EqualsToExpressionContext ctx) {
		// TODO Auto-generated method stub
		return Type.VOID;
	}

	@Override
	public bramspr.BramsprChecker.Type visitGreaterThanExpression(
			GreaterThanExpressionContext ctx) {
		// TODO Auto-generated method stub
		return Type.VOID;
	}

	@Override
	public bramspr.BramsprChecker.Type visitCharLiteralExpression(
			CharLiteralExpressionContext ctx) {
		// TODO Auto-generated method stub
		return Type.VOID;
	}

	@Override
	public bramspr.BramsprChecker.Type visitSmallerThanExpression(
			SmallerThanExpressionContext ctx) {
		// TODO Auto-generated method stub
		return Type.VOID;
	}

	@Override
	public bramspr.BramsprChecker.Type visitIfstatement(IfstatementContext ctx) {
		// TODO Auto-generated method stub
		return Type.VOID;
	}

	@Override
	public bramspr.BramsprChecker.Type visitPrintstatement(
			PrintstatementContext ctx) {
		// TODO Auto-generated method stub
		return Type.VOID;
	}

	@Override
	public bramspr.BramsprChecker.Type visitMultiplicationExpression(
			MultiplicationExpressionContext ctx) {
		// TODO Auto-generated method stub
		return Type.VOID;
	}

	@Override
	public bramspr.BramsprChecker.Type visitPlusMinusExpression(
			PlusMinusExpressionContext ctx) {
		// TODO Auto-generated method stub
		return Type.VOID;
	}

	@Override
	public bramspr.BramsprChecker.Type visitStringLiteralExpression(
			StringLiteralExpressionContext ctx) {
		// TODO Auto-generated method stub
		return Type.VOID;
	}

	@Override
	public bramspr.BramsprChecker.Type visitGetCharExpression(
			GetCharExpressionContext ctx) {
		// TODO Auto-generated method stub
		return Type.VOID;
	}

	@Override
	public bramspr.BramsprChecker.Type visitVariableExpression(
			VariableExpressionContext ctx) {
		// TODO Auto-generated method stub
		return Type.VOID;
	}

	@Override
	public bramspr.BramsprChecker.Type visitGreaterThanEqualsToExpression(
			GreaterThanEqualsToExpressionContext ctx) {
		// TODO Auto-generated method stub
		return Type.VOID;
	}

	@Override
	public bramspr.BramsprChecker.Type visitFunctionExpression(
			FunctionExpressionContext ctx) {
		// TODO Auto-generated method stub
		return Type.VOID;
	}

	@Override
	public bramspr.BramsprChecker.Type visitDeclaration(DeclarationContext ctx) {
		// TODO Auto-generated method stub
		return Type.VOID;
	}

	@Override
	public bramspr.BramsprChecker.Type visitIntLiteralExpression(
			IntLiteralExpressionContext ctx) {
		// TODO Auto-generated method stub
		return Type.VOID;
	}

	@Override
	public bramspr.BramsprChecker.Type visitSmallerThanEqualsToExpression(
			SmallerThanEqualsToExpressionContext ctx) {
		// TODO Auto-generated method stub
		return Type.VOID;
	}

	@Override
	public bramspr.BramsprChecker.Type visitStatement(StatementContext ctx) {
		// TODO Auto-generated method stub
		return Type.VOID;
	}

	@Override
	public bramspr.BramsprChecker.Type visitVariabledeclaration(
			VariabledeclarationContext ctx) {
		// TODO Auto-generated method stub
		return Type.VOID;
	}

	@Override
	public bramspr.BramsprChecker.Type visitAssignment(AssignmentContext ctx) {
		// TODO Auto-generated method stub
		return Type.VOID;
	}

	@Override
	public bramspr.BramsprChecker.Type visitPrimitiveType(
			PrimitiveTypeContext ctx) {
		// TODO Auto-generated method stub
		return Type.VOID;
	}

	@Override
	public bramspr.BramsprChecker.Type visitProgram(ProgramContext ctx) {
		// TODO Auto-generated method stub
		return Type.VOID;
	}

	@Override
	public bramspr.BramsprChecker.Type visitFunctionCallExpression(
			FunctionCallExpressionContext ctx) {
		// TODO Auto-generated method stub
		return Type.VOID;
	}

	@Override
	public bramspr.BramsprChecker.Type visitBoolLiteralExpression(
			BoolLiteralExpressionContext ctx) {
		// TODO Auto-generated method stub
		return Type.VOID;
	}

}
