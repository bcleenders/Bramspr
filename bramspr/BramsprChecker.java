package bramspr;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import symboltable.ArraySymbol;
import symboltable.EnumSymbol;
import symboltable.FunctionSymbol;
import symboltable.RecordSymbol;
import symboltable.TypeSymbol;
import symboltable.VariableSymbol;
import bramspr.BramsprParser.AdditionExpressionContext;
import bramspr.BramsprParser.AndExpressionContext;
import bramspr.BramsprParser.ArrayAccessExpressionContext;
import bramspr.BramsprParser.ArrayLiteralExpressionContext;
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
import bramspr.BramsprParser.FielddeclarationContext;
import bramspr.BramsprParser.FinaldeclarationContext;
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
import bramspr.BramsprParser.PrimitiveTypeDenoterContext;
import bramspr.BramsprParser.ProgramContext;
import bramspr.BramsprParser.PutBoolExpressionContext;
import bramspr.BramsprParser.PutCharExpressionContext;
import bramspr.BramsprParser.PutIntExpressionContext;
import bramspr.BramsprParser.RecordAccessExpressionContext;
import bramspr.BramsprParser.RecordLiteralExpressionContext;
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
//	 public class BramsprChecker implements BramsprVisitor<Suit> {

	// record; identifier (van het record, e.g. "Stoel")
	// "primitief" type ("int", "bool"...)
	// array ("[10] [2] [4] poten")

	private SymbolTable<FunctionSymbol> functionSymbolTable = new SymbolTable<FunctionSymbol>(); // functienamen (e.g. foo)
	private SymbolTable<VariableSymbol> variableSymbolTable = new SymbolTable<VariableSymbol>(); // variabelenamen (e.g. x)
	private SymbolTable<RecordSymbol> typeSymbolTable = new SymbolTable<RecordSymbol>(); // typenamen (e.g. Stoel)
	private SymbolTable<EnumSymbol> enumSymbolTable = new SymbolTable<EnumSymbol>(); // enumnamen (e.g. DAYS)

	private void openScope() {
		functionSymbolTable.openScope();
		variableSymbolTable.openScope();
		typeSymbolTable.openScope();
		enumSymbolTable.openScope();
	}

	private void closeScope() {
		functionSymbolTable.closeScope();
		variableSymbolTable.closeScope();
		typeSymbolTable.closeScope();
		enumSymbolTable.closeScope();
	}

	private ParseTreeProperty<ParseTree> declarationPointers;

	private int errorCount = 0;

	/**
	 * Raporteert een error door deze op System.err te printen.
	 * 
	 * @param message
	 *            foutmelding (e.g. illegal argument)
	 * @param ctx
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

	/*
	 * Handige reportError-wrapper zonder 'expected, encountered'.
	 */
	private void reportError(String message, ParserRuleContext erroroursNode) {
		reportError(message, erroroursNode, null, null);
	}

	public static final RecordSymbol INT = new RecordSymbol("int", null, null);
	public static final RecordSymbol VOID = new RecordSymbol("void", null, null);
	public static final RecordSymbol CHAR = new RecordSymbol("bool", null, null);
	public static final RecordSymbol BOOL = new RecordSymbol("char", null, null);
	public static final RecordSymbol STRING = new RecordSymbol("string", null, null);

	public BramsprChecker() {
		try {
			typeSymbolTable.declare(INT);
			typeSymbolTable.declare(VOID);
			typeSymbolTable.declare(CHAR);
			typeSymbolTable.declare(BOOL);
			typeSymbolTable.declare(STRING);

			functionSymbolTable.declare(new FunctionSymbol("getInt", INT, null));
			functionSymbolTable.declare(new FunctionSymbol("getChar", BOOL, null));
			functionSymbolTable.declare(new FunctionSymbol("getBool", CHAR, null));

		} catch (SymbolTableException se) {
			// Dit zou onmogelijk moeten zijn... Maar Java weet dat niet, dus de catch is verplicht.
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
		List<TerminalNode> identifiers = ctx.IDENTIFIER();

		String enumName = identifiers.remove(0).getText();
		String[] constants = new String[identifiers.size()];

		for (int i = 0; i < identifiers.size(); i++) {
			constants[i] = identifiers.get(i).getText();
		}

		EnumSymbol symbol = new EnumSymbol(enumName, constants);
		try {
			this.enumSymbolTable.declare(symbol);
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
			if (!argSuit.type.equals(BOOL)) {
				reportError("illegal argument", ctx, BOOL.toString(), null);
			}
			return new Suit(INT, false);
		}

		if (ctx.getChild(1).getText().equals("-") || ctx.getChild(1).getText().equals("+")) {
			if (!argSuit.type.equals(INT)) {
				reportError("illegal argument", ctx, INT.toString(), null);
			}
			return new Suit(INT, false);
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

		if (!leftExpression.type.equals(INT)) {
			this.reportError("addition/substraction only works for int values", ctx, INT.toString(), leftExpression.type.toString());
			return Suit.ERROR;
		}

		if (!rightExpression.type.equals(INT)) {
			this.reportError("addition/substraction only works for int values", ctx, INT.toString(), rightExpression.type.toString());
			return Suit.ERROR;
		}

		return new Suit(INT, false);
	}

	/*
	 * Een getint() function call heeft geen contextbeperkingen.
	 */
	@Override
	public Suit visitGetIntExpression(GetIntExpressionContext ctx) {
		return new Suit(INT, false);
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
		TypeSymbol declaredReturnType = visit(ctx.primitiveTypeDenoter()).type;
		String functieNaam = ctx.IDENTIFIER().getText();

		// Even controleren of deze functie niet een void is die dingen probeert te returnen (context eis 2)
		boolean hasReturnStatement = ctx.RETURN() != null;
		if (declaredReturnType == VOID && hasReturnStatement) {
			this.reportError("function " + functieNaam + " has return value: voids methods cannot have return values.", ctx, "}", "return");
		}

		this.openScope();

		/*
		 * Nu moeten we kijken of de functie signature wel uniek is!
		 * (dit declareerd de parameter-variabelen ook direct)
		 */
		TypeSymbol[] argumentTypes = new TypeSymbol[ctx.variabledeclaration().size()];

		for (int i = 0; i < ctx.variabledeclaration().size(); i++) {
			argumentTypes[i] = visit(ctx.variabledeclaration(i)).type;
		}

		FunctionSymbol symbol = new FunctionSymbol(functieNaam, declaredReturnType, argumentTypes);

		try {
			this.functionSymbolTable.declare(symbol);
		} catch (SymbolTableException e) {
			this.reportError("duplicate function signature; functions cannot have identical names and argument types.", ctx, null, null);
		}

		/*
		 * De functie declaratie is gecontroleerd; nu nog controleren of de inhoud ook valide code is.
		 */
		visit(ctx.block()); // Dit is de code die uitgevoerd wordt. Het return type is niet belangrijk.

		if (hasReturnStatement) {
			Suit returnExpressionType = visit(ctx.expression());

			if (declaredReturnType != returnExpressionType.type) {
				this.reportError("invalid function return type", ctx.expression(), declaredReturnType.toString(), returnExpressionType.type.toString());
			}
		}

		this.closeScope();

		return new Suit(declaredReturnType, false);
	}

	@Override
	/*
	 * Een assignmentExpression wordt gecontroleerd door de functie visitAssignment().
	 */
	public Suit visitAssignExpression(AssignExpressionContext ctx) {
		return visit(ctx);
	}

	@Override
	/*
	 * Een typedeclaratie moet aan vier contextuele eisen voldoen:
	 *  1 Een type moet een unieke naam hebben.
	 *  2 Alle velden in het type moeten een unieke naam hebben.
	 *  3 Alle velden in het type moeten een geldig type hebben.
	 *  4 Een record mag een veld met zijn eigen type hebben; volgt uit eis 3 (want het type is nog niet gedeclareerd). Dit zou een oneindige loop opleveren.
	 */
	public Suit visitTypedeclaration(TypedeclarationContext ctx) {
		String typeNaam = ctx.IDENTIFIER().getText();

		// We weten nu hoe 't beestje heet, maar welke velden heeft 'ie?
		ArrayList<String> fieldNames = new ArrayList<String>(); // we weten nog niet hoeveel
		ArrayList<TypeSymbol> fieldTypes = new ArrayList<TypeSymbol>();

		// We gaan de fielddeclarations stuk voor stuk doorlopen.
		for (int i = 0; i < ctx.fielddeclaration().size(); i++) {
			FielddeclarationContext fielddeclctx = ctx.fielddeclaration(i);

			// Bij x,y: int is typeOfFields int
			TypeSymbol typeOfFields = visit(fielddeclctx).type;
			
			for (int j = 0; j < fielddeclctx.IDENTIFIER().size(); j++) {
				fieldNames.add(fielddeclctx.IDENTIFIER(j).getText());
				fieldTypes.add(typeOfFields);
			}
		}

		// Check of er geen dubbele namen zijn.
		for (int i = 0; i < fieldNames.size(); i++) {
			for (int j = i + 1; j < fieldNames.size(); j++) {
				if (fieldNames.get(i).equals(fieldNames.get(j))) {
					this.reportError("record has non-unique fieldnames", ctx, fieldNames.get(j), null);
				}
			}
		}

		RecordSymbol symbol = new RecordSymbol(typeNaam, (String[]) fieldNames.toArray(), (TypeSymbol[]) fieldTypes.toArray());

		try {
			this.typeSymbolTable.declare(symbol);
		} catch (SymbolTableException e) {
			this.reportError("could not declare type; duplicate name", ctx, typeNaam, null);
		}

		return Suit.VOID;
	}

	/**
	 * Geeft het type van de fields die gedeclareerd worden in deze fielddeclaration. E.g. x,y,z: INT zou INT opleveren.
	 */
	public Suit visitFielddeclaration(FielddeclarationContext ctx) {
		return visit(ctx.primitiveTypeDenoter());
	}

	/*
	 * Een orExpression moet twee boolean waardes als argumenten krijgen.
	 */
	public Suit visitOrExpression(OrExpressionContext ctx) {
		Suit leftExpression = visit(ctx.getChild(0));
		Suit rightExpression = visit(ctx.getChild(2));

		if (!leftExpression.type.equals(BOOL)) {
			this.reportError("boolean operation OR only works for bool values", ctx, BOOL.toString(), leftExpression.type.toString());
			return Suit.ERROR;
		}

		if (!rightExpression.type.equals(BOOL)) {
			this.reportError("boolean operation OR only works for bool values", ctx, BOOL.toString(), rightExpression.type.toString());
			return Suit.ERROR;
		}

		return new Suit(BOOL, false);
	}

	/*
	 * Een powerExpression moet twee int 
	 */
	public Suit visitPowerExpression(PowerExpressionContext ctx) {
		Suit leftExpression = visit(ctx.expression(0));
		Suit rightExpression = visit(ctx.expression(1));

		if (!leftExpression.type.equals(INT)) {
			this.reportError("exponentiation requires an int base", ctx.expression(0), INT.toString(), leftExpression.type.toString());
			return Suit.ERROR;
		}

		if (!rightExpression.type.equals(INT)) {
			this.reportError("exponentiation requires an int power", ctx.expression(1), INT.toString(), rightExpression.type.toString());
			return Suit.ERROR;
		}

		return new Suit(INT, false);
	}

	@Override
	/*
	 * Een while (E) { C } statement moet aan een contextuele eis voldoen:
	 * 	1 De expressie E moet een bool waarde opleveren
	 */
	public Suit visitWhilestatement(WhilestatementContext ctx) {
		TypeSymbol expressionType = visit(ctx.expression()).type;
		
		if(! expressionType.equals(BOOL)) {
			this.reportError("control expression in while statement should produce a bool", ctx.expression(), BOOL.toString(), expressionType.toString());
		}
		
		// Doorloop nog even de code in de while loop, om die ook te checken.
		visit(ctx.block());
			
		return Suit.VOID;
	}

	@Override
	/*
	 * Alle argumenten van een notEqualsExpression moeten hetzelfde "primitieve" type hebben.
	 * Dit mag dus INT, BOOL, CHAR of <enum> zijn.
	 */
	public Suit visitNotEqualsToExpression(NotEqualsToExpressionContext ctx) {
		TypeSymbol firstType = visit(ctx.expression(0)).type;
		
		if(!firstType.equals(INT) && !firstType.equals(BOOL) && !firstType.equals(CHAR) && !(firstType instanceof EnumSymbol)) {
			this.reportError("non-primitive types cannot be compared with == ", ctx, "int/bool/char/enum", firstType.toString());
		}
		
		for (int i = 0; i < ctx.expression().size(); i++) {
			TypeSymbol currType = visit(ctx.expression(i)).type;
			
			if(! firstType.equals(currType)) {
				this.reportError("only equal types can be compared with ==", ctx, firstType.toString(), currType.toString());
			}
		}
		
		return new Suit(BOOL, false);
	}

	/*
	 * Een getBoolExpression heeft geen contextuele eisen, en levert een bool op.
	 */
	public Suit visitGetBoolExpression(GetBoolExpressionContext ctx) {
		return new Suit(BOOL, false);
	}

	@Override
	/*
	 * Een andExpression vergelijkt twee bool waardes, en levert een bool op.
	 */
	public Suit visitAndExpression(AndExpressionContext ctx) {
		Suit leftExpression = visit(ctx.getChild(0));
		Suit rightExpression = visit(ctx.getChild(2));

		if (!leftExpression.type.equals(BOOL)) {
			this.reportError("logical operator AND only works for bool values", ctx, BOOL.toString(), leftExpression.type.toString());
		}

		if (!rightExpression.type.equals(BOOL)) {
			this.reportError("logical operator AND only works for bool values", ctx, BOOL.toString(), rightExpression.type.toString());
		}

		return new Suit(BOOL, false);
	}

	@Override
	/*
	 * Een equalsExpression vergelijkt twee gelijk getypeerde waardes, beide primitieve waardes, en levert een bool op.
	 */
	public Suit visitEqualsToExpression(EqualsToExpressionContext ctx) {
		TypeSymbol firstType = visit(ctx.expression(0)).type;
		
		if(!firstType.equals(INT) && !firstType.equals(BOOL) && !firstType.equals(CHAR) && !(firstType instanceof EnumSymbol)) {
			this.reportError("non-primitive types cannot be compared", ctx, "int/bool/char/enum", firstType.toString());
		}
		
		for (int i = 0; i < ctx.expression().size(); i++) {
			TypeSymbol currType = visit(ctx.expression(i)).type;
			
			if(! firstType.equals(currType)) {
				this.reportError("only equal types can be compared", ctx, firstType.toString(), currType.toString());
			}
		}
		
		return new Suit(BOOL, false);
	}

	@Override
	/*
	 * Een greaterThanExpression vergelijkt int waardes, en levert een bool op.
	 */
	public Suit visitGreaterThanExpression(GreaterThanExpressionContext ctx) {
		for (int i = 0; i < ctx.expression().size(); i++) {
			TypeSymbol currType = visit(ctx.expression(i)).type;
			
			if(! currType.equals(INT)) {
				this.reportError("only int types are comparable with < and >", ctx, INT.toString(), currType.toString());
			}
		}
		
		return new Suit(BOOL, false);
	}

	@Override
	/*
	 * Een charLiteralExpression heeft geen contextbeperkingen, en levert een char op.
	 */
	public Suit visitCharLiteralExpression(CharLiteralExpressionContext ctx) {
		return new Suit(CHAR, false);
	}

	@Override
	/*
	 * Een smallerThanExpression vergelijkt int waardes, en levert een bool op.
	 */
	public Suit visitSmallerThanExpression(SmallerThanExpressionContext ctx) {
		for (int i = 0; i < ctx.expression().size(); i++) {
			TypeSymbol currType = visit(ctx.expression(i)).type;
			
			if(! currType.equals(INT)) {
				this.reportError("only int types are comparable with < and >", ctx, INT.toString(), currType.toString());
				return Suit.ERROR;
			}
		}
		
		return new Suit(BOOL, false);
	}

	@Override
	/*
	 * Een if statement if (E) { C1 } else { C2 } heeft de volgende context beperkingen:
	 * 	1 E moet een boolean opleveren
	 */
	public Suit visitIfstatement(IfstatementContext ctx) {
		TypeSymbol expressionType = visit(ctx.expression()).type;
		
		if(!expressionType.equals(BOOL)) {
			this.reportError("if control expression should return bool value", ctx.expression(), BOOL.toString(), expressionType.toString());
		}
		
		for (int i = 0; i < ctx.block().size(); i++) {
			visit(ctx.block(i));
		}
		
		return Suit.VOID;
	}

	@Override
	/*
	 * Een multiplicationExpression (*, /, %) heeft twee int argumenten, en levert een int op. 
	 */
	public Suit visitMultiplicationExpression(MultiplicationExpressionContext ctx) {
		Suit leftExpression = visit(ctx.expression(0));
		Suit rightExpression = visit(ctx.expression(1));

		if (!leftExpression.type.equals(INT)) {
			this.reportError("multiplication/division/modulo only works for int values", ctx, INT.toString(), leftExpression.type.toString());
		}

		if (!rightExpression.type.equals(INT)) {
			this.reportError("multiplication/division/modulo only works for int values", ctx, INT.toString(), rightExpression.type.toString());
		}

		return new Suit(INT, false);
	}

	@Override
	/*
	 * 9 = 10 +- 2
	 * ! (7 = 10 +- 2)
	 * Een plusMinusExpression heeft drie int argumenten, en levert een bool op.
	 */
	public Suit visitPlusMinusExpression(PlusMinusExpressionContext ctx) {
		Suit leftExpression = visit(ctx.expression(0));
		Suit rightExpression = visit(ctx.expression(1));
		Suit middleExpression = visit(ctx.expression(1));

		if (!leftExpression.type.equals(INT)) {
			this.reportError("a plus or minus expression (9 = 10 +- 2) takes three int values", ctx.expression(0), INT.toString(), leftExpression.type.toString());
		}
		
		if (!middleExpression.type.equals(INT)) {
			this.reportError("a plus or minus expression (9 = 10 +- 2) takes three int values", ctx.expression(1), INT.toString(), middleExpression.type.toString());
		}

		if (!rightExpression.type.equals(INT)) {
			this.reportError("a plus or minus expression (9 = 10 +- 2) takes three int values", ctx.expression(2), INT.toString(), rightExpression.type.toString());
		}

		return new Suit(BOOL, false);
	}

	@Override
	/*
	 * Een stringLiteral heeft geen contextbeperkingen, en geeft een string terug.
	 */
	public Suit visitStringLiteralExpression(StringLiteralExpressionContext ctx) {
		return new Suit(STRING, false);
	}

	@Override
	/*
	 * Een getCharExpression heeft geen contextbeperkingen, en geeft een char terug.
	 */
	public Suit visitGetCharExpression(GetCharExpressionContext ctx) {
		return new Suit(CHAR, false);
	}

	@Override
	/*
	 * Een variableExpression moet refereren naar een bestaande variabele, en het return type is gelijk aan het type van de variabele.
	 * Een variabele is mutable!
	 */
	public Suit visitVariableExpression(VariableExpressionContext ctx) {
		String variableName = ctx.IDENTIFIER().getText();
		VariableSymbol variableSymbol = this.variableSymbolTable.resolve(variableName);
		TypeSymbol variableType = variableSymbol.getReturnType();
		
		return new Suit(variableType, true);
	}

	@Override
	/*
	 * Een greaterThanEqualsExpression heeft int waardes als input, en geeft een bool waarde terug.
	 */
	public Suit visitGreaterThanEqualsToExpression(GreaterThanEqualsToExpressionContext ctx) {
		for (int i = 0; i < ctx.expression().size(); i++) {
			TypeSymbol currType = visit(ctx.expression(i)).type;
			
			if(! currType.equals(INT)) {
				this.reportError("only int types are comparable with <= and >=", ctx, INT.toString(), currType.toString());
				return Suit.ERROR;
			}
		}
		
		return new Suit(BOOL, false);
	}

	@Override
	/*
	 * Een intLiteralExpression heeft geen contextbeperkingen, en geeft een int terug.
	 */
	public Suit visitIntLiteralExpression(IntLiteralExpressionContext ctx) {
		return new Suit(INT, false);
	}

	@Override
	/*
	 * Een smallerThanEqualsToExpression heeft twee int argumenten, en geeft een bool terug.
	 */
	public Suit visitSmallerThanEqualsToExpression(SmallerThanEqualsToExpressionContext ctx) {
		for (int i = 0; i < ctx.expression().size(); i++) {
			TypeSymbol currType = visit(ctx.expression(i)).type;
			
			if(! currType.equals(INT)) {
				this.reportError("only int types are comparable with <= and >=", ctx, INT.toString(), currType.toString());
				return Suit.ERROR;
			}
		}
		
		return new Suit(BOOL, false);
	}

	@Override
	public Suit visitAssignment(AssignmentContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Suit visitPrimitiveTypeDenoter(PrimitiveTypeDenoterContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Suit visitProgram(ProgramContext ctx) {
		return visit(ctx.block());
	}

	@Override
	/*
	 * Een functionExpression heeft de volgende contextbeperkingen:
	 * 	1 De functie moet gedefinieerd zijn
	 * 	2 De gegeven argumenttypes moeten overeenkomen met de gedefinieerde argumenttypes (incl. volgorde)
	 * Deze twee eisen worden afgevangen door te eisen dat een functiesignature (bestaande uit naam + argumenttypes) matcht in de SymbolTable.
	 * Het return type van een functionExpression is gelijk aan de returntype zoals gedefinieerd bij de declaratie van de functie. Merk op dat dit VOID kan zijn.
	 */
	public Suit visitFunctionCallExpression(FunctionCallExpressionContext ctx) {
		String functieNaam = ctx.IDENTIFIER().getText();
		
		TypeSymbol[] argumentTypes = new TypeSymbol[ctx.expression().size()];
		
		for (int i = 0; i < ctx.expression().size(); i++) {
			argumentTypes[i] = visit(ctx.expression(i)).type;
		}
		
		// Als de functionsignature klopt, zijn de argumenttypes ook goed. Deze bepalen namelijk de signature!
		String functionSignature = FunctionSymbol.generateSignature(functieNaam, argumentTypes);
		
		FunctionSymbol functionSymbol = this.functionSymbolTable.resolve(functionSignature);
		
		if(functionSymbol == null) {
			this.reportError("unknown function signature ('" + functionSignature + "'); check your function name/arguments", ctx);
			return Suit.ERROR;
		}
		
		return new Suit(functionSymbol.getReturnType(), false);
	}

	@Override
	public Suit visitBoolLiteralExpression(BoolLiteralExpressionContext ctx) {
		return new Suit(BOOL, false);
	}

	@Override
	public Suit visitArrayAccessExpression(ArrayAccessExpressionContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Suit visitEnumExpression(EnumExpressionContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Suit visitRecordAccessExpression(RecordAccessExpressionContext ctx) {
		Suit expressionSuit = visit(ctx.expression());
		
		Suit returnValue = Suit.VOID;
		
		// Eerst kijken of de expression een enum-identifier of een record is.
		if (expressionSuit.type instanceof EnumSymbol){
			
			// Blijkbaar is het een enum. Dan: controleren of het wel een geldige waarde van deze enum is.
			String fieldName = ctx.IDENTIFIER().getText();
			
			if (!((EnumSymbol) expressionSuit.type).hasValue(fieldName)){
				reportError("Enum " + expressionSuit.type.getIdentifier() + " does not have value " + fieldName + ".", ctx);
			}
		 
			
		} else if (expressionSuit.type instanceof RecordSymbol){
			// Blijkbaar is het een record. Dan controleren of het wel een 
			
		} else if (expressionSuit.type instanceof ArraySymbol){
			// TODO: weghalen voor het inleveren
			System.out.println("SHIT GAAT ECHT ENORM FOUT! Check visitFieldAccesExpression in de context checker.");
			System.exit(666);
		}
		return null;
	}
	
	@Override
	public Suit visitFieldAccessExpression(FieldAccessExpressionContext ctx) {
		// Identifiers opvragen
		String leftHandIdentifier = ctx.IDENTIFIER(0).getText();
		String fieldNameIdentifier = ctx.IDENTIFIER(1).getText();
		
		// Dummy-returnwaarde aanmaken
		Suit returnValue = Suit.VOID;
		
		// Records hebben prioriteit over enumerations. Eerst dus kijken of deze identifier aan een record gelinkt is.
		RecordSymbol recordDeclaration = typeSymbolTable.resolve(leftHandIdentifier);
		
		if (recordDeclaration != null){
			// We weten nu dat het om een record gaat. Controleren of record wel dit veld heeft.
			
//			if (RecordDeclaration.)
			
			
		}
			
		return null;
	}

	/*
	 * Hier hoeven geen contextbeperkingen geverifieerd te worden, maar er moeten wel eventueel scopes geopend en gesloten worden.
	 */
	@Override
	public Suit visitBlock(BlockContext ctx) {
		// Aantal parse tree nodes in dit blok opvragen.
		int amountOfChildren = ctx.getChildCount();

		// Itereren over al deze nodes.
		for (int i = 0; i < amountOfChildren; i++) {
			ParseTree currentNode = ctx.getChild(i);

			/*
			 * In een block kunnen drie verschillende dingen zitten: declarations, statements en {block}'s. 
			 * Bij { moet er een scope geöpend worden, bij } moet er een scope gesloten worden, en de declarations, 
			 * statements en blocks moeten simpelweg gevisit worden. 
			 */

			if (currentNode instanceof TerminalNode) {
				if (currentNode.getText().equals("{")) {
					openScope();
				} else {
					closeScope();
				}
			} else {
				visit(currentNode);

			}
		}

		return Suit.VOID;
	}

	/*
	 * Er moet hier geverifieerd worden of de expressie inderdaad een character
	 * is.
	 */
	@Override
	public Suit visitPutCharExpression(PutCharExpressionContext ctx) {
		/*
		 * De expressie opvragen.
		 */

		Suit expressionSuit = visit(ctx.expression());

		/*
		 * Controleren of de expressie een character is.
		 */
		if (!expressionSuit.type.equals("char")) {
			reportError("The argument of putbool must be of character type.", ctx, "char", expressionSuit.type.toString());
		}

		return Suit.VOID;
	}

	/*
	 * Er moet hier geverifieerd worden of de expressie inderdaad een integer
	 * is.
	 */
	@Override
	public Suit visitPutIntExpression(PutIntExpressionContext ctx) {
		/*
		* De expressie opvragen.
		*/
		Suit expressionSuit = visit(ctx.expression());

		/*
		 * Controleren of de expressie een integer is.
		 */
		if (!expressionSuit.type.equals(INT)) {
			reportError("The argument of putint must be of integer type.", ctx, INT.toString(), expressionSuit.type.toString());
		}

		return Suit.VOID;
	}

	@Override
	/*
	 * Er moet hier geverifieerd worden of de expressie inderdaad een boolean
	 * is.
	 */
	public Suit visitPutBoolExpression(PutBoolExpressionContext ctx) {
		/*
		 * De expressie opvragen.
		 */
		Suit expressionSuit = visit(ctx.expression());

		/*
		 * Controleren of de expressie een boolean is.
		 */
		if (!expressionSuit.type.equals(BOOL)) {
			reportError("The argument of putbool must be of boolean type.", ctx, BOOL.toString(), expressionSuit.type.toString());
		}

		return Suit.VOID;
	}

	/*
	 * Er moeten hier twee zaken geverifieerd worden: 
	 * - beide kinderen zijn mutable
	 * - beide kinderen zijn van hetzelfde type
	 * 
	 * Deze node levert niets op, dus VOID returnen.
	 */
	@Override
	public Suit visitSwapstatement(SwapstatementContext ctx) {
		Suit leftExpressionSuit = visit(ctx.expression(0));
		Suit rightExpressionSuit = visit(ctx.expression(1));

		/*
		 * Controleren of de linker- en rechterexpressies mutable zijn.
		 */
		if (!leftExpressionSuit.isMutable) {
			reportError(ctx.expression(0).getText() + " is not mutable. You can't assign it a value.", ctx, null, null);
		}

		if (!rightExpressionSuit.isMutable) {
			reportError(ctx.expression(1).getText() + " is not mutable. You can't assign it a value.", ctx, null, null);
		}

		/*
		 * Controleren of beide expressies van hetzelfde type zijn.
		 */
		if (!rightExpressionSuit.type.equals(leftExpressionSuit.type)) {
			reportError("Both sides of this swap-statement must be of the same value.", ctx, leftExpressionSuit.type + " and " + leftExpressionSuit.type
					+ ", or " + rightExpressionSuit.type + " and " + rightExpressionSuit.type, leftExpressionSuit.type + " and " + rightExpressionSuit.type);
		}

		return Suit.VOID;
	}

	@Override
	public Suit visitRecordLiteralExpression(RecordLiteralExpressionContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Suit visitArrayLiteralExpression(ArrayLiteralExpressionContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Suit visitVariabledeclaration(VariabledeclarationContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Suit visitFinaldeclaration(FinaldeclarationContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

}
