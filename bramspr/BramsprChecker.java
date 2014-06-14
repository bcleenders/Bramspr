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
import bramspr.BramsprParser.EnumExpressionContext;
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
import bramspr.symboltable.*;

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
public class BramsprChecker extends BramsprBaseVisitor<Suit> {
	// public class BramsprChecker implements
	// BramsprVisitor<String> {

	// record; identifier (van het record, e.g. "Stoel")
	// "primitief" type ("int", "bool"...)
	// array ("[10] [2] [4] poten")

	private SymbolTable symbolTable;

	private int errorCount = 0;

	/**
	 * Raporteert een error door deze op System.err te printen.
	 * 
	 * @param message
	 *            foutmelding (e.g. illegal argument)
	 * @param line
	 *            regelnummer van foutproducerende code
	 * @param expected
	 *            wat verwacht werd (optioneel)
	 * @param encountered
	 *            wat ontvangen is (optioneel)
	 */
	private void reportError(String message, int line, String expected,
			String encountered) {
		errorCount++;
		System.err.print("Error " + errorCount + ": " + message + " on line "
				+ line + ".");
		if (expected != null) {
			System.err.print("Expected " + expected);
			if (encountered != null) {
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
			symbolTable.declare(new Symbol("int", TypeClass.TYPE));
			symbolTable.declare(new Symbol("bool", TypeClass.TYPE));
			symbolTable.declare(new Symbol("char", TypeClass.TYPE));
			symbolTable.declare(new Symbol("string", TypeClass.TYPE));

			// Een aantal functies zijn op een lager niveau gedefinieerd; deze
			// mogen niet door de user gedefined worden.
			symbolTable.declare(new Symbol("getInt", TypeClass.FUNCTION));
			symbolTable.declare(new Symbol("getChar", TypeClass.FUNCTION));
			symbolTable.declare(new Symbol("getBool", TypeClass.FUNCTION));
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
	public Suit visit(ParseTree arg0) {
		return super.visit(arg0);
	}

	@Override
	/**
	 * Bezoekt een error node, maar geeft geen return type terug (want error nodes hebben geen type).
	 */
	public Suit visitErrorNode(ErrorNode arg0) {
		// Een error node heeft geen return type
		return null;
	}

	@Override
	public Suit visitTerminal(TerminalNode arg0) {
		// Volgens mij hoeven we hier niet echt iets mee...
		return null;
	}

	@Override
	/**
	 * Een enum moet een (voor enums) unieke naam hebben.
	 */
	public Suit visitEnumdeclaration(EnumdeclarationContext ctx) {
		String identifier = ctx.getChild(1).getText();
		System.out.println("Enum naam; " + identifier);
		
		Symbol symbol = new Symbol(identifier, TypeClass.ENUM); 
		try {
			this.symbolTable.declare(symbol);
		} catch(SymbolTableException e) {
			this.reportError(e.getMessage(), line, expected, encountered)
		}
		
		return null;
	}

	@Override
	public Suit visitParenthesisExpression(ParenthesisExpressionContext ctx) {
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
	public Suit visitUnaryExpression(UnaryExpressionContext ctx) {
		// Vraag het type op van de int/bool node
		Type argType = visit(ctx.getChild(1));

		if (ctx.getChild(0).getText().equals("!")) {
			if (argType == Type.BOOL) {
				return Type.BOOL; // De negatie van kind 2 is een boolean
			} else {
				reportError("Illegal argument", ctx.getStart().getLine(),
						"bool", null);
			}
		}

		if (ctx.getChild(1).getText().equals("-")
				|| ctx.getChild(1).getText().equals("+")) {
			if (argType == Type.INT) {
				return Type.INT; // Kind 2 (of de negatieve waarde daarvan) is
									// een int
			} else {
				reportError("Illegal argument", ctx.getStart().getLine(),
						"int", null);
			}
		}

		return Type.VOID;
	}

	@Override
	public Suit visitAdditionExpression(AdditionExpressionContext ctx) {
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
	public Suit visitGetIntExpression(GetIntExpressionContext ctx) {
		return Type.INT;
	}

	@Override
	public Suit visitFunctiondeclaration(FunctiondeclarationContext ctx) {
		// TODO Auto-generated method stub
		// functienaam mag niet overeenkomen met andere functienaam (wel met
		// variabele)
		return Type.VOID;
	}

	@Override
	public Suit visitAssignExpression(AssignExpressionContext ctx) {
		// TODO Auto-generated method stub
		// variabele moet al gedeclareerd zijn, en types moeten matchen
		return Type.VOID;
	}

	@Override
	public Suit visitTypedeclaration(TypedeclarationContext ctx) {
		// TODO Auto-generated method stub
		// Typenaam mag nog niet bezet zijn! (dus geen restricted keyword!)
		return Type.VOID;
	}

	@Override
	public Suit visitOrExpression(OrExpressionContext ctx) {
		// TODO Auto-generated method stub
		return Type.VOID;
	}

	@Override
	public Suit visitPowerExpression(PowerExpressionContext ctx) {
		// TODO Auto-generated method stub
		return Type.VOID;
	}

	@Override
	public Suit visitWhilestatement(WhilestatementContext ctx) {
		// TODO Auto-generated method stub
		return Type.VOID;
	}

	@Override
	public Suit visitNotEqualsToExpression(NotEqualsToExpressionContext ctx) {
		// TODO Auto-generated method stub
		return Type.VOID;
	}

	@Override
	public Suit visitGetBoolExpression(GetBoolExpressionContext ctx) {
		// TODO Auto-generated method stub
		return Type.VOID;
	}

	@Override
	public Suit visitAndExpression(AndExpressionContext ctx) {
		// TODO Auto-generated method stub
		return Type.VOID;
	}

	@Override
	public Suit visitEqualsToExpression(EqualsToExpressionContext ctx) {
		// TODO Auto-generated method stub
		return Type.VOID;
	}

	@Override
	public Suit visitGreaterThanExpression(GreaterThanExpressionContext ctx) {
		// TODO Auto-generated method stub
		return Type.VOID;
	}

	@Override
	public Suit visitCharLiteralExpression(CharLiteralExpressionContext ctx) {
		// TODO Auto-generated method stub
		return Type.VOID;
	}

	@Override
	public Suit visitSmallerThanExpression(SmallerThanExpressionContext ctx) {
		// TODO Auto-generated method stub
		return Type.VOID;
	}

	@Override
	public Suit visitIfstatement(IfstatementContext ctx) {
		// TODO Auto-generated method stub
		return Type.VOID;
	}

	@Override
	public Suit visitPrintstatement(PrintstatementContext ctx) {
		// TODO Auto-generated method stub
		return Type.VOID;
	}

	@Override
	public Suit visitMultiplicationExpression(
			MultiplicationExpressionContext ctx) {
		// TODO Auto-generated method stub
		return Type.VOID;
	}

	@Override
	public Suit visitPlusMinusExpression(PlusMinusExpressionContext ctx) {
		// TODO Auto-generated method stub
		return Type.VOID;
	}

	@Override
	public Suit visitStringLiteralExpression(
			StringLiteralExpressionContext ctx) {
		// TODO Auto-generated method stub
		return Type.VOID;
	}

	@Override
	public Suit visitGetCharExpression(GetCharExpressionContext ctx) {
		// TODO Auto-generated method stub
		return Type.VOID;
	}

	@Override
	public Suit visitVariableExpression(VariableExpressionContext ctx) {
		// TODO Auto-generated method stub
		return Type.VOID;
	}

	@Override
	public Suit visitGreaterThanEqualsToExpression(
			GreaterThanEqualsToExpressionContext ctx) {
		// TODO Auto-generated method stub
		return Type.VOID;
	}

	@Override
	public Suit visitFunctionExpression(FunctionExpressionContext ctx) {
		// TODO Auto-generated method stub
		return Type.VOID;
	}

	@Override
	public Suit visitDeclaration(DeclarationContext ctx) {
		// TODO Auto-generated method stub
		return Type.VOID;
	}

	@Override
	public Suit visitIntLiteralExpression(IntLiteralExpressionContext ctx) {
		// TODO Auto-generated method stub
		return Type.VOID;
	}

	@Override
	public Suit visitSmallerThanEqualsToExpression(
			SmallerThanEqualsToExpressionContext ctx) {
		// TODO Auto-generated method stub
		return Type.VOID;
	}

	@Override
	public Suit visitStatement(StatementContext ctx) {
		// TODO Auto-generated method stub
		return Type.VOID;
	}

	@Override
	public Suit visitVariabledeclaration(VariabledeclarationContext ctx) {
		// TODO Auto-generated method stub
		return Type.VOID;
	}

	@Override
	public Suit visitAssignment(AssignmentContext ctx) {
		// TODO Auto-generated method stub
		return Type.VOID;
	}

	@Override
	public Suit visitPrimitiveType(PrimitiveTypeContext ctx) {
		// TODO Auto-generated method stub
		return Type.VOID;
	}

	@Override
	public Suit visitProgram(ProgramContext ctx) {
		// TODO Auto-generated method stub
		return Type.VOID;
	}

	@Override
	public Suit visitFunctionCallExpression(FunctionCallExpressionContext ctx) {
		// TODO Auto-generated method stub
		return Type.VOID;
	}

	@Override
	public Suit visitBoolLiteralExpression(BoolLiteralExpressionContext ctx) {
		// TODO Auto-generated method stub
		return Type.VOID;
	}

	@Override
	public Suit visitChildren(RuleNode arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Suit visitArrayAccessExpression(ArrayAccessExpressionContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String visitEnumExpression(EnumExpressionContext ctx) {
		//
		
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
<<<<<<< HEAD
	public Suit visitFieldAccessExpression(FieldAccessExpressionContext ctx) {
=======
	public String visitFieldAccessExpression(FieldAccessExpressionContext ctx) {
		//
		
>>>>>>> 522e35e45f6e6e4587a5d56363d9d5ba311f4c0b
		// TODO Auto-generated method stub
		// Check of dit een enum of een record is!
		return null;
	}

}
