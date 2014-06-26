package bramspr;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.TerminalNode;

import symboltable.ArraySymbol;
import symboltable.CompositeSymbol;
import symboltable.EnumerationSymbol;
import symboltable.FunctionSymbol;
import symboltable.TypeSymbol;
import symboltable.VariableSymbol;
import bramspr.BramsprParser.AdditionExpressionContext;
import bramspr.BramsprParser.AndExpressionContext;
import bramspr.BramsprParser.ArrayLiteralContext;
import bramspr.BramsprParser.ArrayTypeDenoterContext;
import bramspr.BramsprParser.AssignableContext;
import bramspr.BramsprParser.AssignableExpressionContext;
import bramspr.BramsprParser.AssignableFieldAccessExpressionContext;
import bramspr.BramsprParser.AssignmentContext;
import bramspr.BramsprParser.AssignmentExpressionContext;
import bramspr.BramsprParser.BaseTypeDenoterContext;
import bramspr.BramsprParser.BlockStructureContext;
import bramspr.BramsprParser.BooleanLiteralContext;
import bramspr.BramsprParser.CharacterLiteralContext;
import bramspr.BramsprParser.CompositeDeclarationContext;
import bramspr.BramsprParser.CompositeLiteralContext;
import bramspr.BramsprParser.EnumerationDeclarationContext;
import bramspr.BramsprParser.EqualsToExpressionContext;
import bramspr.BramsprParser.ExplicitEnumerationExpressionContext;
import bramspr.BramsprParser.FieldAccessContext;
import bramspr.BramsprParser.FieldAccessExpressionContext;
import bramspr.BramsprParser.FunctionCallContext;
import bramspr.BramsprParser.FunctionCallExpressionContext;
import bramspr.BramsprParser.FunctionDeclarationContext;
import bramspr.BramsprParser.GreaterThanEqualsToExpressionContext;
import bramspr.BramsprParser.GreaterThanExpressionContext;
import bramspr.BramsprParser.IdentifierExpressionContext;
import bramspr.BramsprParser.IfStructureContext;
import bramspr.BramsprParser.InstantiatingDeclarationContext;
import bramspr.BramsprParser.MultiplicationExpressionContext;
import bramspr.BramsprParser.NotEqualsToExpressionContext;
import bramspr.BramsprParser.NotExpressionContext;
import bramspr.BramsprParser.NumberLiteralContext;
import bramspr.BramsprParser.OrExpressionContext;
import bramspr.BramsprParser.ParenthesisExpressionContext;
import bramspr.BramsprParser.PlusMinusExpressionContext;
import bramspr.BramsprParser.PowerExpressionContext;
import bramspr.BramsprParser.ProgramContext;
import bramspr.BramsprParser.PureDeclarationContext;
import bramspr.BramsprParser.SignExpressionContext;
import bramspr.BramsprParser.SmallerThanEqualsToExpressionContext;
import bramspr.BramsprParser.SmallerThanExpressionContext;
import bramspr.BramsprParser.StatementContext;
import bramspr.BramsprParser.StringLiteralContext;
import bramspr.BramsprParser.StructureContext;
import bramspr.BramsprParser.SwapContext;
import bramspr.BramsprParser.WhileStructureContext;
import bramspr.symboltable.SymbolTable;
import bramspr.symboltable.SymbolTableException;

//public class BramsprChecker implements BramsprVisitor<Suit> {
public class BramsprChecker extends BramsprBaseVisitor<Suit> {

	public static final CompositeSymbol INTEGER = new CompositeSymbol("integer", null, null);
	public static final CompositeSymbol VOID = new CompositeSymbol("void", null, null);
	public static final CompositeSymbol CHARACTER = new CompositeSymbol("character", null, null);
	public static final CompositeSymbol BOOLEAN = new CompositeSymbol("boolean", null, null);
	public static final CompositeSymbol STRING = new CompositeSymbol("string", null, null);

	private SymbolTable<FunctionSymbol> functionSymbolTable = new SymbolTable<FunctionSymbol>(); // functienamen (e.g. foo)
	private SymbolTable<VariableSymbol> variableSymbolTable = new SymbolTable<VariableSymbol>(); // variabelenamen (e.g. x)
	private SymbolTable<CompositeSymbol> typeSymbolTable = new SymbolTable<CompositeSymbol>(); // typenamen (e.g. Stoel)
	private SymbolTable<EnumerationSymbol> enumerationSymbolTable = new SymbolTable<EnumerationSymbol>(); // enumnamen (e.g. DAYS)

	private void openScope() {
		functionSymbolTable.openScope();
		variableSymbolTable.openScope();
		typeSymbolTable.openScope();
		enumerationSymbolTable.openScope();
	}

	private void closeScope() {
		functionSymbolTable.closeScope();
		variableSymbolTable.closeScope();
		typeSymbolTable.closeScope();
		enumerationSymbolTable.closeScope();
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
	private void reportError(String message, ParserRuleContext erroneousNode, String expected, String encountered) {
		errorCount++;

		StringBuilder sb = new StringBuilder();
		sb.append("Error ");
		sb.append(errorCount);
		sb.append(" (line ");
		sb.append(erroneousNode.getStart().getLine());
		sb.append(':');
		sb.append(erroneousNode.getStart().getCharPositionInLine());
		sb.append("): ");
		sb.append(message);

		System.err.println(sb.toString());

		if (expected != null) {
			System.err.print("                    Expected " + expected);
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

	public BramsprChecker() {

	}

	public Suit visitProgram(ProgramContext ctx) {
		this.openScope();
		try {
			typeSymbolTable.declare(INTEGER);
			typeSymbolTable.declare(VOID);
			typeSymbolTable.declare(CHARACTER);
			typeSymbolTable.declare(BOOLEAN);
			typeSymbolTable.declare(STRING);

			functionSymbolTable.declare(new FunctionSymbol("getInt", INTEGER, null, false));
			functionSymbolTable.declare(new FunctionSymbol("getChar", BOOLEAN, null, false));
			functionSymbolTable.declare(new FunctionSymbol("getBool", CHARACTER, null, false));
			functionSymbolTable.declare(new FunctionSymbol("putInt", INTEGER, new TypeSymbol[] { INTEGER }, false));
			functionSymbolTable.declare(new FunctionSymbol("putChar", BOOLEAN, new TypeSymbol[] { CHARACTER }, false));
			functionSymbolTable.declare(new FunctionSymbol("putBool", CHARACTER, new TypeSymbol[] { BOOLEAN }, false));
			functionSymbolTable.declare(new FunctionSymbol("putString", STRING, new TypeSymbol[] { STRING }, false));

		} catch (SymbolTableException se) {
			// Dit zou onmogelijk moeten zijn... Maar Java weet dat niet, dus de catch is verplicht.
			System.err.println(se.getMessage());
			se.printStackTrace();
			System.exit(1); // Als het zo erg misgaat, laat dan maar zitten...
		}

		super.visitProgram(ctx);

		this.closeScope();
		return Suit.VOID;
	}

	@Override
	public Suit visitErrorNode(ErrorNode arg0) {
		return Suit.ERROR;
	}

	@Override
	public Suit visitParenthesisExpression(ParenthesisExpressionContext ctx) {
		return visit(ctx.expression());
	}

	/*
	 * Een arrayLiteralExpression moet aan de volgende contexteisen voldoen:
	 * 	1 Alle elementen moeten hetzelfde type hebben
	 * 	2 Het type van het element moet bestaan
	 * De tweede eis wordt reeds gegarandeerd door de contextuele eis dat een waarde in zijn algemeenheid nooit een onbestaand type 
	 * kan hebben; door een element te assignen weten we dus al dat het type bestaat.
	 */
	public Suit visitArrayLiteral(ArrayLiteralContext ctx) {
		int aantalElementen = ctx.expression().size();

		if (aantalElementen == 0) {
			// Als er toch 0 elementen zijn, maak ze dan maar direct voids...
			return new Suit(new ArraySymbol(0, VOID), true);
		}

		// Wat voor types zou hij bevatten?
		Suit firstElementSuit = visit(ctx.expression(0));

		boolean allConstant = true;
		for (int i = 1; i < aantalElementen; i++) {
			// Type van het huidige element
			Suit currElementSuit = visit(ctx.expression(i));

			// Check if types match
			if (!firstElementSuit.type.equals(currElementSuit.type)) {
				this.reportError("attempted to enter different types in array literal: use records for that!", ctx.expression(i),
						firstElementSuit.type.getIdentifier(), currElementSuit.type.getIdentifier());
			}

			// Check if it is still a constant array
			allConstant = allConstant && currElementSuit.isConstant;
		}

		ArraySymbol arrayType = new ArraySymbol(aantalElementen, firstElementSuit.type);

		return new Suit(arrayType, allConstant);
	}

	@Override
	/*
	 * Een additionExpression (+,-) heeft twee int argumenten, en levert een int op. 
	 * De return value is constant als en slechts als beide input values constant zijn.
	 */
	public Suit visitAdditionExpression(AdditionExpressionContext ctx) {
		Suit leftExpression = visit(ctx.arithmetic(0));
		Suit rightExpression = visit(ctx.arithmetic(1));

		if (!leftExpression.type.equals(INTEGER)) {
			this.reportError("addition/substraction only works for int values", ctx, INTEGER.toString(), leftExpression.type.toString());
			return Suit.ERROR;
		}

		if (!rightExpression.type.equals(INTEGER)) {
			this.reportError("addition/substraction only works for int values", ctx, INTEGER.toString(), rightExpression.type.toString());
			return Suit.ERROR;
		}

		boolean isConstant = leftExpression.isConstant && rightExpression.isConstant;
		return new Suit(INTEGER, isConstant);
	}

	@Override
	public Suit visitPowerExpression(PowerExpressionContext ctx) {
		Suit baseSuit = visit(ctx.arithmetic(0));
		Suit exponentSuit = visit(ctx.arithmetic(1));

		if (!baseSuit.type.equals(INTEGER)) {
			this.reportError("exponentiation requires an int base", ctx.arithmetic(0), INTEGER.toString(), baseSuit.type.toString());
			return Suit.ERROR;
		}

		if (!exponentSuit.type.equals(INTEGER)) {
			this.reportError("exponentiation requires an int power", ctx.arithmetic(1), INTEGER.toString(), exponentSuit.type.toString());
			return Suit.ERROR;
		}

		boolean bothConstant = baseSuit.isConstant && exponentSuit.isConstant;

		return new Suit(INTEGER, bothConstant);
	}

	/*
	 * Een typedeclaratie moet aan vier contextuele eisen voldoen:
	 *  1 Een type moet een unieke naam hebben.
	 *  2 Alle velden in het type moeten een unieke naam hebben.
	 *  3 Alle velden in het type moeten een geldig type hebben.
	 *  4 Een record mag een veld met zijn eigen type hebben; volgt uit eis 3 (want het type is nog niet gedeclareerd). Dit zou een oneindige loop opleveren.
	 */
	public Suit visitCompositeDeclaration(CompositeDeclarationContext ctx) {
		String typeNaam = ctx.IDENTIFIER(0).getText();

		// We weten nu hoe 't beestje heet, maar welke velden heeft 'ie?
		String[] fieldNames = new String[ctx.typeDenoter().size()];
		TypeSymbol[] fieldTypes = new TypeSymbol[ctx.typeDenoter().size()];

		// We gaan de fielddeclarations stuk voor stuk doorlopen.
		for (int i = 0; i < ctx.typeDenoter().size(); i++) {
			fieldNames[i] = ctx.IDENTIFIER(i + 1).getText();
			fieldTypes[i] = visit(ctx.typeDenoter(i)).type;
		}

		// Check of er geen dubbele namen zijn.
		for (int i = 0; i < fieldNames.length; i++) {
			for (int j = i + 1; j < fieldNames.length; j++) {
				if (fieldNames[i].equals(fieldNames[j])) {
					this.reportError("record has non-unique fieldnames", ctx, fieldNames[j], null);
				}
			}
		}

		CompositeSymbol symbol = new CompositeSymbol(typeNaam, fieldNames, fieldTypes);

		try {
			this.typeSymbolTable.declare(symbol);
		} catch (SymbolTableException e) {
			this.reportError("could not declare type; duplicate name", ctx, typeNaam, null);
		}

		return Suit.VOID;
	}

	/*
	 * De conditie-expressie van een while-structure moet een boolean waarde opleveren.
	 * De structure zelf levert niets op, dus deze methode geeft de void-suit terug.
	 */
	@Override
	public Suit visitWhileStructure(WhileStructureContext ctx) {
		Suit conditionSuit = visit(ctx.expression());

		if (!conditionSuit.type.equals(BOOLEAN)) {
			// Helaas, hij levert geen boolean waarde op. Error reporten.
			String errorMessage = "The condition for while-structures should yield a boolean value, which the expression '" + ctx.expression().getText()
					+ "' does not.";
			reportError(errorMessage, ctx, BOOLEAN.toString(), conditionSuit.type.toString());
		}

		visit(ctx.blockStructure());
		return Suit.VOID;
	}

	@Override
	/*
	 * Een notEqualsToExpression heeft twee of meer int input waardes, en geeft een bool terug.
	 * De return waarde is constant als en slechts als alle input waardes constant zijn.
	 */
	public Suit visitNotEqualsToExpression(NotEqualsToExpressionContext ctx) {
		boolean allConstant = true;

		for (int i = 0; i < ctx.arithmetic().size(); i++) {
			Suit currentSuit = visit(ctx.arithmetic(i));

			if (!currentSuit.equals(INTEGER)) {
				this.reportError("=/= can only compare int values", ctx, INTEGER.toString(), currentSuit.type.toString());
				return Suit.ERROR;
			}

			allConstant = allConstant && currentSuit.isConstant;
		}

		return new Suit(INTEGER, allConstant);
	}

	/*
	 * Een function call heeft de volgende contextbeperkingen:
	 * - de functie moet gedeclareerd zijn;
	 * - de types van de gegeven argumenten moeten overeenkomen met de typen van de parameters;
	 * - (de argumenten moeten op dezelfde volgorde staan als de parameters stonden bij de declaratie.)
	 * 
	 * De return suit van de functie komt, als alles klopt, overeen met die van de gedeclareerde 
	 * functie (merk op dat dit de void-suit kan zijn). Zijn er echter fouten, dan wordt de
	 * error-suit teruggegeven.
	 */
	@Override
	public Suit visitFunctionCall(FunctionCallContext ctx) {
		/*
		 * We maken van de identifier + de argumenttypes de function signature, 
		 * en doorzoeken hiermee de symbol table. Het mooie is dat als er een match
		 * is, we ook gelijk de argumenttypes en -volgorde gecontroleerd hebben. 
		 * Deze bepalen immers de signature.
		 */

		String functionIdentifier = ctx.IDENTIFIER().getText();

		// De types van de argumenten opvragen en in een lijst bijhouden.
		TypeSymbol[] argumentTypes = new TypeSymbol[ctx.expression().size()];

		for (int i = 0; i < ctx.expression().size(); i++) {
			argumentTypes[i] = visit(ctx.expression(i)).type;
		}

		// Identifier + argumenttypes combineren tot function signature.
		String functionSignature = FunctionSymbol.generateSignature(functionIdentifier, argumentTypes);

		FunctionSymbol functionSymbol = this.functionSymbolTable.resolve(functionSignature);

		if (functionSymbol == null) {

			// Helaas, een dergelijke functie is niet gedeclareerd. Error reporten en error-suit teruggeven.
			StringBuilder errorMessage = new StringBuilder();
			errorMessage.append("A function called '" + functionIdentifier + "' and having ");

			if (argumentTypes.length == 0) {
				errorMessage.append("no parameters ");
			} else if (argumentTypes.length == 1) {
				errorMessage.append("one " + argumentTypes[0].toString() + "-typed parameter ");
			} else if (argumentTypes.length == 2) {
				errorMessage.append("parameters of type " + argumentTypes[0].toString() + " ");
				errorMessage.append("and " + argumentTypes[1].toString() + ", ");
				errorMessage.append("in this order, ");
			} else {
				errorMessage.append("parameters of type ");

				for (int i = 0; i < argumentTypes.length - 2; i++) {
					errorMessage.append(argumentTypes[i].toString() + ", ");
				}

				errorMessage.append(argumentTypes[argumentTypes.length - 2] + " and " + argumentTypes[argumentTypes.length - 1].toString() + ", ");
				errorMessage.append("in this order, ");

			}

			errorMessage.append("has not (yet) been declared.");
			this.reportError(errorMessage.toString(), ctx);
			return Suit.ERROR;
		}

		// De functie bestaat. Corresponderende return suit teruggeven.
		return new Suit(functionSymbol.getReturnType(), functionSymbol.isConstant());
	}

	@Override
	/*
	 * Een signexpression heeft één int argument, en geeft een type int terug.
	 * De return value is constant als en slechts als de input value constant is.
	 */
	public Suit visitSignExpression(SignExpressionContext ctx) {
		Suit expressionSuit = visit(ctx.arithmetic());

		if (!INTEGER.equals(expressionSuit.type)) {
			this.reportError("cannot use +/- on non-int values", ctx.arithmetic(), INTEGER.getIdentifier(), expressionSuit.type.getIdentifier());
			return Suit.ERROR;
		}

		return expressionSuit;
	}

	@Override
	public Suit visitExplicitEnumerationExpression(ExplicitEnumerationExpressionContext ctx) {
		// TODO Auto-generated method stub
		return super.visitChildren(ctx);
	}

	@Override
	/*
	 * Een notEqualsToExpression heeft twee of meer int input waardes, en geeft een bool terug.
	 * De return waarde is constant als en slechts als alle input waardes constant zijn.
	 */
	public Suit visitEqualsToExpression(EqualsToExpressionContext ctx) {
		boolean allConstant = true;

		for (int i = 0; i < ctx.arithmetic().size(); i++) {
			Suit currentSuit = visit(ctx.arithmetic(i));

			if (!currentSuit.equals(INTEGER)) { // TODO Hier gaat het mis; merkt niet dat INT en INT overeenkomt. (ook bij notequals)
				this.reportError("= can only compare int values", ctx, INTEGER.toString(), currentSuit.type.toString());
				return Suit.ERROR;
			}

			allConstant = allConstant && currentSuit.isConstant;
		}

		return new Suit(INTEGER, allConstant);
	}

	@Override
	/*
	 * Een greaterThanExpression heeft twee of meer int input waardes, en geeft een bool terug.
	 * De return waarde is constant als en slechts als alle input waardes constant zijn.
	 */
	public Suit visitGreaterThanExpression(GreaterThanExpressionContext ctx) {
		boolean allConstant = true;

		for (int i = 0; i < ctx.arithmetic().size(); i++) {
			Suit currentSuit = visit(ctx.arithmetic(i));

			if (!currentSuit.equals(INTEGER)) {
				this.reportError("only int types are comparable with >", ctx, INTEGER.toString(), currentSuit.type.toString());
				return Suit.ERROR;
			}

			allConstant = allConstant && currentSuit.isConstant;
		}

		return new Suit(INTEGER, allConstant);
	}

	@Override
	/*
	 * Een greaterThanExpression heeft twee of meer int input waardes, en geeft een bool terug.
	 * De return waarde is constant als en slechts als alle input waardes constant zijn.
	 */
	public Suit visitSmallerThanExpression(SmallerThanExpressionContext ctx) {
		boolean allConstant = true;

		for (int i = 0; i < ctx.arithmetic().size(); i++) {
			Suit currentSuit = visit(ctx.arithmetic(i));

			if (!currentSuit.equals(INTEGER)) {
				this.reportError("only int types are comparable with <", ctx, INTEGER.toString(), currentSuit.type.toString());
				return Suit.ERROR;
			}

			allConstant = allConstant && currentSuit.isConstant;
		}

		return new Suit(INTEGER, allConstant);
	}

	@Override
	/*
	 * Een multiplicationExpression (*, /, %) heeft twee int argumenten, en levert een int op. 
	 * De return value is constant als en slechts als beide input values constant zijn.
	 */
	public Suit visitMultiplicationExpression(MultiplicationExpressionContext ctx) {
		Suit leftExpression = visit(ctx.arithmetic(0));
		Suit rightExpression = visit(ctx.arithmetic(1));

		if (!leftExpression.type.equals(INTEGER)) {
			this.reportError("multiplication/division/modulo only works for int values", ctx, INTEGER.toString(), leftExpression.type.toString());
		}

		if (!rightExpression.type.equals(INTEGER)) {
			this.reportError("multiplication/division/modulo only works for int values", ctx, INTEGER.toString(), rightExpression.type.toString());
		}

		boolean bothConstant = leftExpression.isConstant && rightExpression.isConstant;

		return new Suit(INTEGER, bothConstant);
	}

	/*
	 * De contextbeperkingen voor een enumeration declaration: 
	 * - de naam moet uniek zijn (voor enumerations);
	 * - er mogen geen dubbele waarden voorkomen.
	 *  
	 * Verder wordt er uiteraard een enumeration aangemaakt met 
	 * de opgegeven waarden.
	 */
	@Override
	public Suit visitEnumerationDeclaration(EnumerationDeclarationContext ctx) {
		List<TerminalNode> identifiers = ctx.IDENTIFIER();

		String enumerationIdentifier = identifiers.remove(0).getText();
		HashSet<String> enumerationValues = new HashSet<String>();

		for (int i = 0; i < identifiers.size(); i++) {
			String value = identifiers.get(i).getText();
			
			// Methode add(value) geeft 'false' terug als 'value' al in de set zat.
			boolean newValue = enumerationValues.add(value);

			if (!newValue) {
				// Deze waarde komt dubbel voor. Error reporten.
				String errorMessage = "Value '" + value + "' appears more than once in the declaration of enumeration '" + enumerationIdentifier
						+ "'. This is not allowed.";
				reportError(errorMessage, ctx);
			}
		}
		
		// We moeten geen HashSet, maar een array meegeven als argument, dus we zetten de set om in een array.
		String[] arrayWithEnumerationValues = new String[enumerationValues.size()];
		enumerationValues.toArray(arrayWithEnumerationValues);

		// We maken een symbol aan voor in de symbol table.
		EnumerationSymbol symbol = new EnumerationSymbol(enumerationIdentifier, arrayWithEnumerationValues);

		try {
			this.enumerationSymbolTable.declare(symbol);
		} catch (SymbolTableException e) {
			this.reportError(e.getMessage(), ctx);
		}

		return Suit.VOID;
	}

	@Override
	/*
	 * Een plusMinuxExpression heeft drie int argumenten, en geeft een bool waarde terug.
	 * De output value is constant als en slechts als alle drie de input argumenten constant zijn.
	 */
	public Suit visitPlusMinusExpression(PlusMinusExpressionContext ctx) {
		Suit leftExpression = visit(ctx.arithmetic(0));
		Suit middleExpression = visit(ctx.arithmetic(1));
		Suit rightExpression = visit(ctx.arithmetic(2));

		if (!leftExpression.type.equals(INTEGER)) {
			this.reportError("a plus or minus expression (9 = 10 +- 2) takes three int values", ctx.arithmetic(0), INTEGER.toString(),
					leftExpression.type.toString());
		}

		if (!middleExpression.type.equals(INTEGER)) {
			this.reportError("a plus or minus expression (9 = 10 +- 2) takes three int values", ctx.arithmetic(1), INTEGER.toString(),
					middleExpression.type.toString());
		}

		if (!rightExpression.type.equals(INTEGER)) {
			this.reportError("a plus or minus expression (9 = 10 +- 2) takes three int values", ctx.arithmetic(2), INTEGER.toString(),
					rightExpression.type.toString());
		}

		boolean allConstant = leftExpression.isConstant && middleExpression.isConstant && rightExpression.isConstant;

		return new Suit(BOOLEAN, allConstant);
	}

	@Override
	/*
	 * Een greaterThanEqualsToExpression heeft twee of meer int input waardes, en geeft een bool terug.
	 * De return waarde is constant als en slechts als alle input waardes constant zijn.
	 */
	public Suit visitGreaterThanEqualsToExpression(GreaterThanEqualsToExpressionContext ctx) {
		boolean allConstant = true;

		for (int i = 0; i < ctx.arithmetic().size(); i++) {
			Suit currentSuit = visit(ctx.arithmetic(i));

			if (!currentSuit.equals(INTEGER)) {
				this.reportError("only int types are comparable with >=", ctx, INTEGER.toString(), currentSuit.type.toString());
				return Suit.ERROR;
			}

			allConstant = allConstant && currentSuit.isConstant;
		}

		return new Suit(INTEGER, allConstant);
	}

	@Override
	public Suit visitBaseTypeDenoter(BaseTypeDenoterContext ctx) {
		String typeName = ctx.IDENTIFIER().getText();
		TypeSymbol type = this.typeSymbolTable.resolve(typeName);

		if (type == null) {
			this.reportError("reference to non-existing type '" + typeName + "'.", ctx);
			return Suit.ERROR;
		}
		return new Suit(type, false);
	}

	
	/*
	 * Een assignment-expression bestaat uit niets meer dan een assignment
	 * tussen haakjes, en geeft dan ook de suit van de assignment terug.
	 */
	@Override
	public Suit visitAssignmentExpression(AssignmentExpressionContext ctx) {
		return visit(ctx.assignment());
	}

	@Override
	public Suit visitIdentifierExpression(IdentifierExpressionContext ctx) {
		VariableSymbol variable = this.variableSymbolTable.resolve(ctx.IDENTIFIER().getText());

		if (variable == null) {
			this.reportError("reference to non-existing variable '" + ctx.IDENTIFIER().getText() + "'.", ctx);
			return Suit.ERROR;
		}

		return new Suit(variable.getReturnType(), variable.isConstant());
	}

	@Override
	/*
	 * Een notExpression heeft één bool argument, en geeft een bool terug.
	 * De return value is constant als en slechts als het argument constant is.
	 */
	public Suit visitNotExpression(NotExpressionContext ctx) {
		Suit argSuit = visit(ctx.expression());

		if (!argSuit.type.equals(BOOLEAN)) {
			reportError("illegal argument", ctx, BOOLEAN.toString(), null);
		}
		return argSuit;
	}

	@Override
	public Suit visitAssignableFieldAccessExpression(AssignableFieldAccessExpressionContext ctx) {
		// TODO Auto-generated method stub
		return super.visitChildren(ctx);
	}

	/*
	 * Een smallerThanExpression heeft twee of meer int input waardes, en geeft een bool terug.
	 * De return waarde is constant als en slechts als alle input waardes constant zijn.
	 */
	public Suit visitSmallerThanEqualsToExpression(SmallerThanEqualsToExpressionContext ctx) {
		boolean allConstant = true;

		for (int i = 0; i < ctx.arithmetic().size(); i++) {
			Suit currentSuit = visit(ctx.arithmetic(i));

			if (!currentSuit.equals(INTEGER)) {
				this.reportError("only int types are comparable with <=", ctx, INTEGER.toString(), currentSuit.type.toString());
				return Suit.ERROR;
			}

			allConstant = allConstant && currentSuit.isConstant;
		}

		return new Suit(INTEGER, allConstant);
	}

	@Override
	public Suit visitStatement(StatementContext ctx) {
		// TODO Auto-generated method stub
		return super.visitChildren(ctx);
	}

	/*
	 * Een assignment moet aan de volgende eisen voldoen:
	 *  - de assignable(s) moet bestaan, dat wil zeggen: de variabele moet gedeclareerd zijn / het veld moet bestaan;
	 *  - de assignable(s) mogen niet constant zijn;
	 * 	- het type van de assignable(s) en de expressie moeten overeenkomen.
	 * 
	 * De eerste eis wordt in de visit-methode van de assignable(s) al gecontroleerd.
	 * 
	 * Het return suit van de assignment is de suit van de expressie.
	 */
	@Override
	public Suit visitAssignment(AssignmentContext ctx) {
		// Alle assignables opvragen.
		List<AssignableContext> assignables = ctx.assignable();
		
		// Type van de expressie opvragen.
		Suit expressionSuit = visit(ctx.expression());
		TypeSymbol expressionType = expressionSuit.type;
				
		for (AssignableContext assignable : assignables){
			// Suit van de assignable opvragen.
			Suit assignableSuit = visit(assignable);
			
			if (assignableSuit.isConstant){
				// Oh oh, deze assignable is constant. Dat mag niet. Error reporten en error-suit teruggeven.
				String errorMessage = "The variable '" + assignable.getText() + "' is constant. After initialisation, constant variables can not be assigned new values.";
				reportError(errorMessage, assignable);
				return Suit.ERROR;
			}
			
			if (!assignableSuit.type.equals(expressionType)){
				// Onjuist type. Error reporten en error-suit teruggeven.
				String errorMessage = "Expression '" + ctx.expression().getText() + "' yields the wrong type of value for variable '" + assignable.getText() + "'.";
				reportError(errorMessage, assignable, assignableSuit.type.toString(), expressionType.toString());
				return Suit.ERROR;
			}
		}
		
		// Alles klopt! Nu als suit de suit van de expressie teruggeven.
		return expressionSuit;	
	}

	@Override
	public Suit visitAssignableExpression(AssignableExpressionContext ctx) {
		// TODO Auto-generated method stub
		return super.visitChildren(ctx);
	}

	@Override
	public Suit visitIfStructure(IfStructureContext ctx) {
		// TODO Auto-generated method stub
		return super.visitChildren(ctx);
	}

	@Override
	public Suit visitArrayTypeDenoter(ArrayTypeDenoterContext ctx) {
		int size = Integer.parseInt(ctx.NUMBER().getText());

		TypeSymbol elementType = visit(ctx.typeDenoter()).type;

		ArraySymbol arrayType = new ArraySymbol(size, elementType);

		return new Suit(arrayType, false);
	}

	@Override
	public Suit visitFunctionCallExpression(FunctionCallExpressionContext ctx) {
		// TODO Auto-generated method stub
		return super.visitChildren(ctx);
	}

	/*
	 * Een composite-literal moet aan de volgende contexteisen voldoen:
	 * 	- het composite-type moet gedeclareerd zijn;
	 * 	- velden die een waarde toegewezen krijgen moeten bestaan in het composite-type;
	 * 	- alle velden van het composite-type moeten een waarde toegewezen krijgen;
	 * 	- elke waarde moet qua type overeenkomen met het veld waaraan het toegewezen wordt;
	 *  - een veld mag niet tweemaal een waarde toegewezen krijgen.
	 *  
	 *  Verder is de composite-literal impliciet constant als alle toegewezen waarden constant 
	 *  zijn. Deze methode moet dit daarom bijhouden en de teruggegeven suit zich hieraan laten
	 *  conformeren.
	 */
	@Override
	public Suit visitCompositeLiteral(CompositeLiteralContext ctx) {
		// Eerst kijken van welk composite-type deze literal is.
		String compositeTypeIdentifier = ctx.IDENTIFIER(0).getText();
		CompositeSymbol compositeType = typeSymbolTable.resolve(compositeTypeIdentifier);

		// Composite-type opvragen in symbol table en kijken of deze wel bestaat.
		if (compositeType == null) {
			// Hij bestaat niet. Error reporten en error-suit teruggeven.
			String errorMessage = "Composite type " + compositeTypeIdentifier + " has not (yet) been declared.";
			reportError(errorMessage, ctx);
			return Suit.ERROR;
		}

		/*
		 * Het composite-type bestaat! Dan nu de field-assignments aflopen.
		 * We willen bijhouden of ze allemaal constant zijn, dus daarvoor een 
		 * boolean aanmaken, en we willen de assignments vergelijken met de 
		 * velden van het composite-type, dus die gaan we bijhouden in een set.
		 */
		boolean isConstant = true;
		HashSet<String> assignedFields = new HashSet<String>();

		// Beginnen op 1; de eerste identifier was die van het composite type.
		for (int i = 1; i < ctx.IDENTIFIER().size(); i++) {
			String fieldName = ctx.IDENTIFIER(i).getText();

			// Kijken of dit veld niet al een waarde toegewezen heeft gekregen in deze literal.
			if (assignedFields.contains(fieldName)) {
				// Het veld is al eerder behandeld. Error reporten en error-suit teruggeven.
				String errorMessage = "Field '" + fieldName + "' has already been assigned a value earlier on in this literal.";
				this.reportError(errorMessage, ctx.expression(i - 1));
				return Suit.ERROR;
			}

			// Het veld is nog niet eerder genoemd. Nu kijken of het bestaat in het composite-type, en wat zijn type is.
			TypeSymbol fieldType = compositeType.getFieldType(fieldName);

			if (fieldType == null) {
				// Het veld bestaat niet. Error reporten en error-suit teruggeven.
				String errorMessage = "Field '" + fieldName + "' is not a member of composite type '" + compositeTypeIdentifier + "'.";
				reportError(errorMessage, ctx);
				return Suit.ERROR;
			}

			/*
			 * Het veld bestaat. Type opvragen en kijken of de toegewezen waarde hiermee matcht.
			 * De expression-indices lopen steeds één achter op de identifier-indices; de eerste 
			 * identifier was immers die van het composite type.
			 */
			Suit expressionSuit = visit(ctx.expression(i - 1));

			if (!expressionSuit.type.equals(fieldType)) {
				// De expressie is niet van hetzelfde type. Error reporten en error-suit teruggeven.
				String errorMessage = "The type of expression '" + ctx.expression(i - 1).getText() + "' does not match with the type of field '" + fieldName
						+ "'.";
				reportError(errorMessage, ctx, fieldType.toString(), expressionSuit.type.toString());
				return Suit.ERROR;
			}

			// De toewijzing klopt. Nu kijken of de toewijzing constant is, en de isConstant-boolean updaten.
			isConstant = (isConstant && expressionSuit.isConstant);

			// Nu rest ons alleen nog de toewijzing toevoegen aan de lijst.
			assignedFields.add(fieldName);
		}

		/*
		 *  Controleren of alle velden wel een waarde toegewezen hebben gekregen. Omdat we al gecontroleerd
		 *  hebben dat alle velden waaraan is toegewezen, bestaan, en dat geen veld meermaals genoemd is,
		 *  is het voldoende om het aantal toegewezen velden te vergelijken met het aantal velen van het
		 *  composite-type.
		 */
		int amountOfMissingFieldAssignments = compositeType.getNumberOfFields() - assignedFields.size();
		if (!(amountOfMissingFieldAssignments == 0)) {
			// Er missen er inderdaad een paar. Error reporten en error-suit teruggeven.
			String errorMessage = "Not all fields of composite type " + compositeTypeIdentifier + " have been assigned a value. "
					+ amountOfMissingFieldAssignments + " of " + compositeType.getNumberOfFields() + " are missing.";
			this.reportError(errorMessage, ctx);
			return Suit.ERROR;
		}

		// Alles klopt. Nu de juiste suit teruggeven.
		return new Suit(compositeType, isConstant);
	}

	@Override
	public Suit visitFunctionDeclaration(FunctionDeclarationContext ctx) {
		// declaredReturnType is wat de functie zegt dat 'ie zal returnen; dit gaan we nog checken!
		String functieNaam = ctx.IDENTIFIER(0).getText();

		this.openScope();

		/*
		 * Nu moeten we kijken of de functie signature wel uniek is!
		 * (dit declareerd de parameter-variabelen ook direct)
		 */
		TypeSymbol[] argumentTypes = new TypeSymbol[ctx.typeDenoter().size()];

		for (int i = 0; i < ctx.typeDenoter().size(); i++) {
			argumentTypes[i] = visit(ctx.typeDenoter(i)).type;
		}

		// De functie declaratie is gecontroleerd; nu nog controleren of de inhoud ook valide code is.
		for (int i = 0; i < ctx.statement().size(); i++) {
			visit(ctx.statement(i));
		}

		// Controleren of de (impliciete) declaratie van de variabelen wel goed gaat
		// (ze moeten in de symboltable staan, anders kunnen we de code in de functie niet valideren)
		for (int i = 0; i < ctx.statement().size(); i++) {
			VariableSymbol parameter = new VariableSymbol(ctx.IDENTIFIER(i + 1).getText(), argumentTypes[i], false);
			try {
				this.variableSymbolTable.declare(parameter);
			} catch (SymbolTableException e) {
				this.reportError(e.getMessage(), ctx);
			}
		}

		// Controleren of de code binnen deze functie wel geldig is:
		for (int i = 0; i < ctx.statement().size(); i++) {
			visit(ctx.statement(i));
		}

		// Kijken wat deze functie teruggeeft.
		boolean hasReturnStatement = (ctx.RETURN() != null);
		Suit returnSuit;
		if (hasReturnStatement) {
			returnSuit = visit(ctx.expression());
		} else {
			returnSuit = new Suit(VOID, true);
		}

		this.closeScope();

		FunctionSymbol symbol = new FunctionSymbol(functieNaam, returnSuit.type, argumentTypes, returnSuit.isConstant);

		try {
			this.functionSymbolTable.declare(symbol);
		} catch (SymbolTableException e) {
			this.reportError("duplicate function signature; functions cannot have identical names and argument types.", ctx);
		}

		return returnSuit;
	}

	@Override
	public Suit visitSwap(SwapContext ctx) {
		TypeSymbol rightType = visit(ctx.assignable(0)).type;
		TypeSymbol leftType = visit(ctx.assignable(1)).type;

		if (!rightType.equals(leftType)) {
			this.reportError("swap cannot swap variables with different types", ctx.assignable(1), leftType.getIdentifier(), rightType.getIdentifier());
			return Suit.ERROR;
		}

		return Suit.VOID;
	}

	@Override
	public Suit visitBlockStructure(BlockStructureContext ctx) {
		for (int i = 0; i < ctx.statement().size(); i++) {
			visit(ctx.statement(i));
		}

		return Suit.VOID;
	}

	@Override
	public Suit visitFieldAccessExpression(FieldAccessExpressionContext ctx) {
		// TODO Auto-generated method stub
		return super.visitChildren(ctx);
	}

	/*
	 * Een character-literal heeft geen contextbeperkingen en levert een
	 * constant string op.
	 */
	@Override
	public Suit visitStringLiteral(StringLiteralContext ctx) {
		return new Suit(STRING, true);
	}

	/*
	 * Een number-literal heeft geen contextbeperkingen en levert een
	 * constant intenger op.
	 */public Suit visitNumberLiteral(NumberLiteralContext ctx) {
		return new Suit(INTEGER, true);
	}

	/*
	 * Een boolean-literal heeft geen contextbeperkingen en levert een
	 * constant boolean op.
	 */
	@Override
	public Suit visitBooleanLiteral(BooleanLiteralContext ctx) {
		return new Suit(BOOLEAN, true);
	}

	/*
	 * De contextuele eisen voor de declaratie van een variabele zijn:
	 * 	1 de naam moet binnen de scope niet eerder gedefinieerd zijn
	 * 	2 het type moet reeds gedeclareerd zijn
	 */
	public Suit visitPureDeclaration(PureDeclarationContext ctx) {
		// Alle identifiers opvragen.
		List<TerminalNode> identifiers = ctx.IDENTIFIER();

		// Kijken wat het bedoelde type is.
		TypeSymbol targetType = visit(ctx.typeDenoter()).type;

		for (int i = 0; i < identifiers.size(); i++) {
			String variableName = identifiers.get(i).getText();

			try {
				variableSymbolTable.declare(new VariableSymbol(variableName, targetType, false));
			} catch (SymbolTableException e) {
				reportError(e.getMessage(), ctx);
			}
		}

		return Suit.VOID;
	}

	/*
	 * Een character-literal heeft geen contextbeperkingen en levert een
	 * constant character op.
	 */
	@Override
	public Suit visitCharacterLiteral(CharacterLiteralContext ctx) {
		return new Suit(CHARACTER, true);
	}

	/*
	 * De contextuele eisen voor de declaratie van een variabele zijn:
	 * 	1 de naam moet binnen de scope niet eerder gedefinieerd zijn
	 * 	2 het type moet reeds gedeclareerd zijn
	 *  3 het gedeclareerde type en het type van de expression moeten overeenkomen
	 *  4 als een constante gedeclareerd wordt, dan moet de expression ook constant zijn
	 */
	public Suit visitInstantiatingDeclaration(InstantiatingDeclarationContext ctx) {
		boolean isConstant = (ctx.CONSTANT() != null);

		// Even kijken wat wordt teruggegeven door de expression
		Suit expressionSuit = visit(ctx.expression());

		// Eis #2 wordt in de visit al getest
		TypeSymbol targetType = visit(ctx.typeDenoter()).type;

		// Eis #3 testen
		if (!targetType.equals(expressionSuit.type)) {
			this.reportError("declared type and actual type do not match", ctx.expression(), targetType.getIdentifier(), expressionSuit.type.getIdentifier());
		}

		// Eis #4 testen
		if (isConstant) {
			if (!expressionSuit.isConstant) {
				this.reportError("assigning non-constant value to constant", ctx.expression());
			}
		}

		// Alle identifiers opvragen.
		List<TerminalNode> identifiers = ctx.IDENTIFIER();

		// Variabelen declareren in symboltable (eis #1)
		for (int i = 0; i < identifiers.size(); i++) {
			String variableName = identifiers.get(i).getText();

			try {
				variableSymbolTable.declare(new VariableSymbol(variableName, targetType, isConstant));
			} catch (SymbolTableException e) {
				reportError(e.getMessage(), ctx);
			}
		}

		return Suit.VOID;
	}

	@Override
	public Suit visitOrExpression(OrExpressionContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Suit visitAndExpression(AndExpressionContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	// Vanaf hier alleen de nutteloze functies die door de super al worden afgehandeld (verwijderen voor testen)

}
