package bramspr;

import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import symboltable.Symbol;

import bramspr.BramsprParser.AdditionExpressionContext;
import bramspr.BramsprParser.AndExpressionContext;
import bramspr.BramsprParser.ArrayAccessExpressionContext;
import bramspr.BramsprParser.AssignExpressionContext;
import bramspr.BramsprParser.AssignmentContext;
import bramspr.BramsprParser.BoolLiteralExpressionContext;
import bramspr.BramsprParser.CharLiteralExpressionContext;
import bramspr.BramsprParser.DeclarationContext;
import bramspr.BramsprParser.EnumdeclarationContext;
import bramspr.BramsprParser.EqualsToExpressionContext;
import bramspr.BramsprParser.FieldAccessExpressionContext;
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
import bramspr.symboltable.Entry;
import bramspr.symboltable.SymbolTable;
import bramspr.symboltable.SymbolTableException;

/**
 * BramsprChecker controleert of een gegeven ParseTree voldoet aan de
 * contextuele eisen van Bramspr.
 * 
 * @author Bram&Jasper
 * 
 *         Deze klasse implementeert BramsprVisitor (impliciet) en extend
 *         BramsprBaseVisitor dus ook AbstractParseTreeVisitor. Iedere functie
 *         geeft het (primitieve) type terug dat de bijbehorende programmacode
 *         terug zou geven.
 */
public class BramsprChecker extends BramsprBaseVisitor<String> {
//public class BramsprChecker implements
//	 BramsprVisitor<String> {

	private SymbolTable symbolTable;
	
	private int errorCount = 0;
	/**
	 * Raporteert een error door deze op System.err te printen.
	 * @param message foutmelding (e.g. illegal argument)
	 * @param line regelnummer van foutproducerende code
	 * @param expected wat verwacht werd (optioneel)
	 * @param encountered wat ontvangen is (optioneel)
	 */
	private void reportError(String message, int line, String expected, String encountered) {
		errorCount++;
		System.err.print("Error " + errorCount + ": " + message + " on line " + line + ".");
		if(expected != null) {
			System.err.print("Expected " + expected);
			if(encountered != null) {
				System.err.print(", but found " + encountered);
			}
			System.err.println(".");
		}
	}

	public BramsprChecker() {
		symbolTable = new SymbolTable();

		try {
			// Een aantal types (primitieve types) zijn gereserveerd; deze mogen
			// niet door de user gedefined worden.
			Entry reservedType = new Entry("Reserved type");
			this.typeSymtab.enter("int", reservedType);
			this.typeSymtab.enter("bool", reservedType);
			this.typeSymtab.enter("char", reservedType);
			this.typeSymtab.enter("string", reservedType);

			// Een aantal functies zijn op een lager niveau gedefinieerd; deze
			// mogen niet door de user gedefined worden.
			Entry getint = new Entry("int");
			Entry getchar = new Entry("char");
			Entry getbool = new Entry("bool");
			this.functionSymtab.enter("getint", getint);
			this.functionSymtab.enter("getchar", getchar);
			this.functionSymtab.enter("getbool", getbool);
		} catch (SymbolTableException se) {
			// Dit zou onmogelijk moeten zijn... Maar Java weet dat niet, dus de
			// catch is verplicht.
			System.err.println("New SymbolTable contains reserved name.");
			System.exit(1); // Als het zo erg misgaat, laat dan maar zitten...
		}
	}

	@Override
	/**
	 * Bezoekt een node, overgeërfd van AbstractParseTreeListener
	 */
	public String visit(ParseTree arg0) {
		return super.visit(arg0);
	}

	@Override
	/**
	 * Bezoekt een error node, maar geeft geen return type terug (want error nodes hebben geen type).
	 */
	public String visitErrorNode(ErrorNode arg0) {
		// Een error node heeft geen return type
		return Type.VOID;
	}

	@Override
	public String visitTerminal(TerminalNode arg0) {
		// Volgens mij hoeven we hier niet echt iets mee...
		return Type.VOID;
	}

	@Override
	public String visitEnumdeclaration(
			EnumdeclarationContext ctx) {
		for(int i = 0; i < ctx.getChildCount(); i++) {
			System.out.println("enum decl; " + i + " " + ctx.getChild(i).getText());
		}
		return Type.VOID;
	}

	@Override
	public String visitParenthesisExpression(
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
	public String visitUnaryExpression(
			UnaryExpressionContext ctx) {
		// Vraag het type op van de int/bool node
		Type argType = visit(ctx.getChild(1));

		if (ctx.getChild(0).getText().equals("!")) {
			if (argType == Type.BOOL) {
				return Type.BOOL; // De negatie van kind 2 is een boolean
			} else {
				reportError("Illegal argument", ctx.getStart().getLine(), "bool", null);
			}
		}

		if (ctx.getChild(1).getText().equals("-")
				|| ctx.getChild(1).getText().equals("+")) {
			if (argType == Type.INT) {
				return Type.INT; // Kind 2 (of de negatieve waarde daarvan) is
									// een int
			} else {
				reportError("Illegal argument", ctx.getStart().getLine(), "int", null);
			}
		}

		return Type.VOID;
	}

	@Override
	public String visitAdditionExpression(
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

		return Type.INT;
	}

	@Override
	public String visitGetIntExpression(
			GetIntExpressionContext ctx) {
		return Type.INT;
	}

	@Override
	public String visitFunctiondeclaration(
			FunctiondeclarationContext ctx) {
		// TODO Auto-generated method stub
		// functienaam mag niet overeenkomen met andere functienaam (wel met
		// variabele)
		return Type.VOID;
	}

	@Override
	public String visitAssignExpression(
			AssignExpressionContext ctx) {
		// TODO Auto-generated method stub
		// variabele moet al gedeclareerd zijn, en types moeten matchen
		return Type.VOID;
	}

	@Override
	public String visitTypedeclaration(
			TypedeclarationContext ctx) {
		// TODO Auto-generated method stub
		// Typenaam mag nog niet bezet zijn! (dus geen restricted keyword!)
		return Type.VOID;
	}

	@Override
	public String visitOrExpression(OrExpressionContext ctx) {
		// TODO Auto-generated method stub
		return Type.VOID;
	}

	@Override
	public String visitPowerExpression(
			PowerExpressionContext ctx) {
		// TODO Auto-generated method stub
		return Type.VOID;
	}

	@Override
	public String visitWhilestatement(
			WhilestatementContext ctx) {
		// TODO Auto-generated method stub
		return Type.VOID;
	}

	@Override
	public String visitNotEqualsToExpression(
			NotEqualsToExpressionContext ctx) {
		// TODO Auto-generated method stub
		return Type.VOID;
	}

	@Override
	public String visitGetBoolExpression(
			GetBoolExpressionContext ctx) {
		// TODO Auto-generated method stub
		return Type.VOID;
	}

	@Override
	public String visitAndExpression(
			AndExpressionContext ctx) {
		// TODO Auto-generated method stub
		return Type.VOID;
	}

	@Override
	public String visitEqualsToExpression(
			EqualsToExpressionContext ctx) {
		// TODO Auto-generated method stub
		return Type.VOID;
	}

	@Override
	public String visitGreaterThanExpression(
			GreaterThanExpressionContext ctx) {
		// TODO Auto-generated method stub
		return Type.VOID;
	}

	@Override
	public String visitCharLiteralExpression(
			CharLiteralExpressionContext ctx) {
		// TODO Auto-generated method stub
		return Type.VOID;
	}

	@Override
	public String visitSmallerThanExpression(
			SmallerThanExpressionContext ctx) {
		// TODO Auto-generated method stub
		return Type.VOID;
	}

	@Override
	public String visitIfstatement(IfstatementContext ctx) {
		// TODO Auto-generated method stub
		return Type.VOID;
	}

	@Override
	public String visitPrintstatement(
			PrintstatementContext ctx) {
		// TODO Auto-generated method stub
		return Type.VOID;
	}

	@Override
	public String visitMultiplicationExpression(
			MultiplicationExpressionContext ctx) {
		// TODO Auto-generated method stub
		return Type.VOID;
	}

	@Override
	public String visitPlusMinusExpression(
			PlusMinusExpressionContext ctx) {
		// TODO Auto-generated method stub
		return Type.VOID;
	}

	@Override
	public String visitStringLiteralExpression(
			StringLiteralExpressionContext ctx) {
		// TODO Auto-generated method stub
		return Type.VOID;
	}

	@Override
	public String visitGetCharExpression(
			GetCharExpressionContext ctx) {
		// TODO Auto-generated method stub
		return Type.VOID;
	}

	@Override
	public String visitVariableExpression(
			VariableExpressionContext ctx) {
		// TODO Auto-generated method stub
		return Type.VOID;
	}

	@Override
	public String visitGreaterThanEqualsToExpression(
			GreaterThanEqualsToExpressionContext ctx) {
		// TODO Auto-generated method stub
		return Type.VOID;
	}

	@Override
	public String visitFunctionExpression(
			FunctionExpressionContext ctx) {
		// TODO Auto-generated method stub
		return Type.VOID;
	}

	@Override
	public String visitDeclaration(DeclarationContext ctx) {
		// TODO Auto-generated method stub
		return Type.VOID;
	}

	@Override
	public String visitIntLiteralExpression(
			IntLiteralExpressionContext ctx) {
		// TODO Auto-generated method stub
		return Type.VOID;
	}

	@Override
	public String visitSmallerThanEqualsToExpression(
			SmallerThanEqualsToExpressionContext ctx) {
		// TODO Auto-generated method stub
		return Type.VOID;
	}

	@Override
	public String visitStatement(StatementContext ctx) {
		// TODO Auto-generated method stub
		return Type.VOID;
	}

	@Override
	public String visitVariabledeclaration(
			VariabledeclarationContext ctx) {
		// TODO Auto-generated method stub
		return Type.VOID;
	}

	@Override
	public String visitAssignment(AssignmentContext ctx) {
		// TODO Auto-generated method stub
		return Type.VOID;
	}

	@Override
	public String visitPrimitiveType(
			PrimitiveTypeContext ctx) {
		// TODO Auto-generated method stub
		return Type.VOID;
	}

	@Override
	public String visitProgram(ProgramContext ctx) {
		// TODO Auto-generated method stub
		return Type.VOID;
	}

	@Override
	public String visitFunctionCallExpression(
			FunctionCallExpressionContext ctx) {
		// TODO Auto-generated method stub
		return Type.VOID;
	}

	@Override
	public String visitBoolLiteralExpression(
			BoolLiteralExpressionContext ctx) {
		// TODO Auto-generated method stub
		return Type.VOID;
	}

	@Override
	public String visitChildren(RuleNode arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitArrayAccessExpression(ArrayAccessExpressionContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitFieldAccessExpression(FieldAccessExpressionContext ctx) {
		// TODO Auto-generated method stub
		// Check of dit een enum of een record is!
		return null;
	}

}
