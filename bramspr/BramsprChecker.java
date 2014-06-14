package bramspr;

import java.util.ArrayList;

import org.antlr.v4.runtime.ParserRuleContext;
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
import bramspr.BramsprParser.BlockContext;
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
import bramspr.BramsprParser.PutBoolExpressionContext;
import bramspr.BramsprParser.PutCharExpressionContext;
import bramspr.BramsprParser.PutIntExpressionContext;
import bramspr.BramsprParser.SmallerThanEqualsToExpressionContext;
import bramspr.BramsprParser.SmallerThanExpressionContext;
import bramspr.BramsprParser.StatementContext;
import bramspr.BramsprParser.StringLiteralExpressionContext;
import bramspr.BramsprParser.SwapstatementContext;
import bramspr.BramsprParser.TypedeclarationContext;
import bramspr.BramsprParser.UnaryExpressionContext;
import bramspr.BramsprParser.VariableExpressionContext;
import bramspr.BramsprParser.VariabledeclarationContext;
import bramspr.BramsprParser.WhilestatementContext;
import bramspr.symboltable.*;

/**
 * BramsprChecker controleert of een gegeven ParseTree voldoet aan de contextuele eisen van Bramspr.
 * 
 * @author Bram&Jasper
 * 
 *         Deze klasse implementeert BramsprVisitor (impliciet) en extend BramsprBaseVisitor dus ook AbstractParseTreeVisitor. Iedere functie geeft het
 *         (primitieve) type terug dat de bijbehorende programmacode terug zou geven.
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
	private void reportError(String message, ParserRuleContext erroroursNode, String expected, String encountered) {
		errorCount++;

		StringBuilder sb = new StringBuilder();
		sb.append("Error ");
		sb.append(errorCount);
		sb.append(": ");
		sb.append(message);
		sb.append(" on line ");
		sb.append(erroroursNode.getStart().getLine());
		sb.append(':');
		sb.append(erroroursNode.getStart().getCharPositionInLine());
		sb.append('.');

		System.err.print(sb.toString());

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
			// niet door de user gedeclareerd worden.
			symbolTable.declare(new Symbol("int", TypeClass.TYPE, "void")); // declaraties hebben geen return value (-type); void
			symbolTable.declare(new Symbol("bool", TypeClass.TYPE, "void"));
			symbolTable.declare(new Symbol("char", TypeClass.TYPE, "void"));
			symbolTable.declare(new Symbol("string", TypeClass.TYPE, "void"));

			// Een aantal functies zijn op een lager niveau gedefinieerd; deze
			// mogen niet door de user gedefined worden.
			symbolTable.declare(new Symbol("getInt", TypeClass.FUNCTION, "int"));
			symbolTable.declare(new Symbol("getChar", TypeClass.FUNCTION, "char"));
			symbolTable.declare(new Symbol("getBool", TypeClass.FUNCTION, "bool"));
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
		return Suit.VOID;
	}

	@Override
	public Suit visitTerminal(TerminalNode arg0) {
		// Volgens mij hoeven we hier niet echt iets mee...
		return Suit.VOID;
	}

	@Override
	/*
	 * Een enum moet een (voor enums) unieke naam hebben.
	 */
	public Suit visitEnumdeclaration(EnumdeclarationContext ctx) {
		String identifier = ctx.getChild(1).getText();
		System.out.println("Enum naam; " + identifier);

		Symbol symbol = new Symbol(identifier, TypeClass.ENUM, "void");
		try {
			this.symbolTable.declare(symbol);
		} catch (SymbolTableException e) {
			this.reportError(e.getMessage(), ctx, null, null);
		}

		return Suit.VOID;
	}

	@Override
	/*
	 * Een parenthesisExpression heeft geen contextbeperkingen. Het type van de
	 * expression erbinnen kan worden doorgegeven.
	 */
	public Suit visitParenthesisExpression(ParenthesisExpressionContext ctx) {
		// Hier zijn geen eisen aan de inhoud van ctx die niet al door de parser
		// zijn gecontroleerd.
		return visit(ctx.getChild(0));
	}

	@Override
	/*
	 * Controleert de contextbeperkingen van een unaryExpression. Als het eerste
	 * kind een + of - is, moet het tweede kind een int zijn. De return type is
	 * dan ook een int. Als het eerste kind een ! is, moet het tweede kind een
	 * bool zijn. De return type is dan ook een bool.
	 */
	public Suit visitUnaryExpression(UnaryExpressionContext ctx) {
		// Vraag het type op van de int/bool node
		Suit argSuit = visit(ctx.getChild(1));

		if (ctx.getChild(0).getText().equals("!")) {
			if (!argSuit.type.equals("bool")) {
				reportError("illegal argument", ctx, "bool", null);
			}
			return new Suit("bool", false);
		}

		if (ctx.getChild(1).getText().equals("-") || ctx.getChild(1).getText().equals("+")) {
			if (!argSuit.type.equals("int")) {
				reportError("illegal argument", ctx, "int", null);
			}
			return new Suit("int", false);
		}

		return null;
	}

	@Override
	/*
	 * Een additionExpression telt twee int waardes bij elkaar op, en verwacht geen verdere argumenten.
	 */
	public Suit visitAdditionExpression(AdditionExpressionContext ctx) {
		Suit leftExpression = visit(ctx.getChild(0));
		Suit rightExpression = visit(ctx.getChild(2));

		if (!leftExpression.type.equals("int")) {
			this.reportError("addition/substraction only works for int values", ctx, "int", leftExpression.type);
		}

		if (!rightExpression.type.equals("int")) {
			this.reportError("addition/substraction only works for int values", ctx, "int", rightExpression.type);
		}

		return new Suit("int", false);
	}

	/*
	 * Een getint() function call heeft geen contextbeperkingen.
	 */
	@Override
	public Suit visitGetIntExpression(GetIntExpressionContext ctx) {
		return new Suit("int", false);
	}

	@Override
	/*
	 * Er zijn drie contextuele eisen aan een functie:
	 * 	1 Een functie signature moet uniek zijn binnen zijn scope.
	 * 		Het signature bestaat uit de naam van de functie plus de types van de argumenten.
	 * 		Bij foo(a:int, b:int) is "foo int int" het signature (zie ook Symbol)
	 * 	2 Een functie die void returnt, mag geen return statement hebben.
	 *  3 Een functie die niet void return moet een return statement hebben, waarbij de expressie hetzelfde type als de functie oplevert.
	 */
	public Suit visitFunctiondeclaration(FunctiondeclarationContext ctx) {
		// declaredReturnType is wat de functie zegt dat 'ie zal returnen; dit gaan we nog checken!
		String declaredReturnType = ctx.IDENTIFIER(0).getText();
		String functieNaam = ctx.IDENTIFIER(1).getText();

		// Even controleren of deze functie niet een void is die dingen probeert te returnen (context eis 2)
		boolean hasReturnStatement = ctx.RETURN() != null;
		if (declaredReturnType.equals("void") && hasReturnStatement) {
			this.reportError("function " + functieNaam + " has return value: voids methods cannot have return values.", ctx, "}", "return");
		}
		
		this.symbolTable.openScope();
		
		/*
		 * Nu moeten we kijken of de functie signature wel uniek is!
		 * (dit declareerd de parameter-variabelen ook direct)
		 */
		ArrayList<Suit> argumentTypes = new ArrayList<Suit>();
		
		for(VariabledeclarationContext argument : ctx.variabledeclaration()) {
			argumentTypes.add(visit(argument));
		}
		
		Symbol symbol = new Symbol(functieNaam, TypeClass.FUNCTION, declaredReturnType, (TypeClass[]) argumentTypes.toArray());

		try {
			this.symbolTable.declare(symbol);
		} catch (SymbolTableException e) {
			this.reportError("duplicate function signature; functions cannot have identical names and argument types.", ctx, null, null);
		}
		
		/*
		 * De functie declaratie is gecontroleerd; nu nog controleren of de inhoud ook valide code is.
		 */
		visit(ctx.block()); // Dit is de code die uitgevoerd wordt. Het return type is niet belangrijk.
		
		if(hasReturnStatement) {
			Suit returnExpressionType = visit(ctx.expression());
			
			if(declaredReturnType != returnExpressionType.type) {
				this.reportError("invalid function return type", ctx.expression(), declaredReturnType, returnExpressionType.type);
			}
		}
		this.symbolTable.closeScope();

		return new Suit(declaredReturnType, false);
	}

	@Override
	public Suit visitAssignExpression(AssignExpressionContext ctx) {
		// TODO Auto-generated method stub
		// variabele moet al gedeclareerd zijn, en types moeten matchen
		return null;
	}

	@Override
	public Suit visitTypedeclaration(TypedeclarationContext ctx) {
		// TODO Auto-generated method stub
		// Typenaam mag nog niet bezet zijn! (dus geen restricted keyword!)
		return null;
	}

	@Override
	public Suit visitOrExpression(OrExpressionContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Suit visitPowerExpression(PowerExpressionContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Suit visitWhilestatement(WhilestatementContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Suit visitNotEqualsToExpression(NotEqualsToExpressionContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Suit visitGetBoolExpression(GetBoolExpressionContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Suit visitAndExpression(AndExpressionContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Suit visitEqualsToExpression(EqualsToExpressionContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Suit visitGreaterThanExpression(GreaterThanExpressionContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Suit visitCharLiteralExpression(CharLiteralExpressionContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Suit visitSmallerThanExpression(SmallerThanExpressionContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Suit visitIfstatement(IfstatementContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Suit visitPrintstatement(PrintstatementContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Suit visitMultiplicationExpression(MultiplicationExpressionContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Suit visitPlusMinusExpression(PlusMinusExpressionContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Suit visitStringLiteralExpression(StringLiteralExpressionContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Suit visitGetCharExpression(GetCharExpressionContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Suit visitVariableExpression(VariableExpressionContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Suit visitGreaterThanEqualsToExpression(GreaterThanEqualsToExpressionContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Suit visitFunctionExpression(FunctionExpressionContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Suit visitDeclaration(DeclarationContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Suit visitIntLiteralExpression(IntLiteralExpressionContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Suit visitSmallerThanEqualsToExpression(SmallerThanEqualsToExpressionContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Suit visitStatement(StatementContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Suit visitVariabledeclaration(VariabledeclarationContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Suit visitAssignment(AssignmentContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Suit visitPrimitiveType(PrimitiveTypeContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Suit visitProgram(ProgramContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Suit visitFunctionCallExpression(FunctionCallExpressionContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Suit visitBoolLiteralExpression(BoolLiteralExpressionContext ctx) {
		// TODO Auto-generated method stub
		return null;
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
	public Suit visitEnumExpression(EnumExpressionContext ctx) {
		//

		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Suit visitFieldAccessExpression(FieldAccessExpressionContext ctx) {

		// TODO Auto-generated method stub
		// Check of dit een enum of een record is!
		return null;
	}

	@Override
	public Suit visitBlock(BlockContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Suit visitPutCharExpression(PutCharExpressionContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Suit visitPutIntExpression(PutIntExpressionContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Suit visitPutBoolExpression(PutBoolExpressionContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Suit visitSwapstatement(SwapstatementContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

}
