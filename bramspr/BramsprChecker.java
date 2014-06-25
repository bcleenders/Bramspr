package bramspr;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import javax.lang.model.type.ArrayType;

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
import bramspr.BramsprParser.ArithmeticExpressionContext;
import bramspr.BramsprParser.ArrayLiteralContext;
import bramspr.BramsprParser.ArrayTypeDenoterContext;
import bramspr.BramsprParser.AssignableExpressionContext;
import bramspr.BramsprParser.AssignableFieldAccessExpressionContext;
import bramspr.BramsprParser.AssignmentContext;
import bramspr.BramsprParser.AssignmentExpressionContext;
import bramspr.BramsprParser.AtomicExpressionContext;
import bramspr.BramsprParser.BaseTypeDenoterContext;
import bramspr.BramsprParser.BlockStructureContext;
import bramspr.BramsprParser.BooleanLiteralContext;
import bramspr.BramsprParser.CharacterLiteralContext;
import bramspr.BramsprParser.CompositeLiteralContext;
import bramspr.BramsprParser.DeclarationContext;
import bramspr.BramsprParser.EnumerationDeclarationContext;
import bramspr.BramsprParser.EqualsToExpressionContext;
import bramspr.BramsprParser.ExplicitEnumExpressionContext;
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
import bramspr.BramsprParser.LiteralContext;
import bramspr.BramsprParser.LiteralExpressionContext;
import bramspr.BramsprParser.MultiplicationExpressionContext;
import bramspr.BramsprParser.NotEqualsToExpressionContext;
import bramspr.BramsprParser.NotExpressionContext;
import bramspr.BramsprParser.NumberLiteralContext;
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
import bramspr.BramsprParser.TypeDeclarationContext;
import bramspr.BramsprParser.WhileStructureContext;
import bramspr.symboltable.SymbolTable;
import bramspr.symboltable.SymbolTableException;

//public class BramsprChecker implements BramsprVisitor<Suit> {
public class BramsprChecker extends BramsprBaseVisitor<Suit> {

	public static final RecordSymbol INT = new RecordSymbol("int", null, null);
	public static final RecordSymbol VOID = new RecordSymbol("void", null, null);
	public static final RecordSymbol CHAR = new RecordSymbol("char", null, null);
	public static final RecordSymbol BOOL = new RecordSymbol("bool", null, null);
	public static final RecordSymbol STRING = new RecordSymbol("string", null, null);

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
	private void reportError(String message, ParserRuleContext erroneousNode, String expected, String encountered) {
		errorCount++;

		StringBuilder sb = new StringBuilder();
		sb.append("Error ");
		sb.append(errorCount);
		sb.append(": ");
		sb.append(message);
		sb.append(" on line ");
		sb.append(erroneousNode.getStart().getLine());
		sb.append(':');
		sb.append(erroneousNode.getStart().getCharPositionInLine());
		sb.append('.');

		System.err.println(sb.toString());

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

	public BramsprChecker() {

	}

	public Suit visitProgram(ProgramContext ctx) {
		this.openScope();
		try {
			typeSymbolTable.declare(INT);
			typeSymbolTable.declare(VOID);
			typeSymbolTable.declare(CHAR);
			typeSymbolTable.declare(BOOL);
			typeSymbolTable.declare(STRING);

			functionSymbolTable.declare(new FunctionSymbol("getInt", INT, null));
			functionSymbolTable.declare(new FunctionSymbol("getChar", BOOL, null));
			functionSymbolTable.declare(new FunctionSymbol("getBool", CHAR, null));
			functionSymbolTable.declare(new FunctionSymbol("putInt", INT, new TypeSymbol[] { INT }));
			functionSymbolTable.declare(new FunctionSymbol("putChar", BOOL, new TypeSymbol[] { CHAR }));
			functionSymbolTable.declare(new FunctionSymbol("putBool", CHAR, new TypeSymbol[] { BOOL }));
			functionSymbolTable.declare(new FunctionSymbol("putString", STRING, new TypeSymbol[] { STRING }));

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
	public Suit visitFieldAccess(FieldAccessContext ctx) {
		// TODO Auto-generated method stub
		return super.visitChildren(ctx);
	}

	@Override
	public Suit visitAdditionExpression(AdditionExpressionContext ctx) {
		Suit leftExpression = visit(ctx.arithmetic(0));
		Suit rightExpression = visit(ctx.arithmetic(1));

		if (!leftExpression.type.equals(INT)) {
			this.reportError("addition/substraction only works for int values", ctx, INT.toString(), leftExpression.type.toString());
			return Suit.ERROR;
		}

		if (!rightExpression.type.equals(INT)) {
			this.reportError("addition/substraction only works for int values", ctx, INT.toString(), rightExpression.type.toString());
			return Suit.ERROR;
		}

		boolean isConstant = leftExpression.isConstant && rightExpression.isConstant;
		return new Suit(INT, isConstant);
	}

	@Override
	public Suit visitPowerExpression(PowerExpressionContext ctx) {
		// TODO Auto-generated method stub
		return super.visitChildren(ctx);
	}

	/*
	 * Een typedeclaratie moet aan vier contextuele eisen voldoen:
	 *  1 Een type moet een unieke naam hebben.
	 *  2 Alle velden in het type moeten een unieke naam hebben.
	 *  3 Alle velden in het type moeten een geldig type hebben.
	 *  4 Een record mag een veld met zijn eigen type hebben; volgt uit eis 3 (want het type is nog niet gedeclareerd). Dit zou een oneindige loop opleveren.
	 */
	public Suit visitTypeDeclaration(TypeDeclarationContext ctx) {
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

		RecordSymbol symbol = new RecordSymbol(typeNaam, fieldNames, fieldTypes);

		try {
			this.typeSymbolTable.declare(symbol);
		} catch (SymbolTableException e) {
			this.reportError("could not declare type; duplicate name", ctx, typeNaam, null);
		}

		return Suit.VOID;
	}

	@Override
	public Suit visitWhileStructure(WhileStructureContext ctx) {
		// TODO Auto-generated method stub
		return super.visitChildren(ctx);
	}

	@Override
	public Suit visitNotEqualsToExpression(NotEqualsToExpressionContext ctx) {
		// TODO Auto-generated method stub
		return super.visitChildren(ctx);
	}

	@Override
	public Suit visitFunctionCall(FunctionCallContext ctx) {
		// TODO Auto-generated method stub
		return super.visitChildren(ctx);
	}

	@Override
	public Suit visitSignExpression(SignExpressionContext ctx) {
		// TODO Auto-generated method stub
		return super.visitChildren(ctx);
	}

	@Override
	public Suit visitExplicitEnumExpression(ExplicitEnumExpressionContext ctx) {
		// TODO Auto-generated method stub
		return super.visitChildren(ctx);
	}

	@Override
	public Suit visitEqualsToExpression(EqualsToExpressionContext ctx) {
		// TODO Auto-generated method stub
		return super.visitChildren(ctx);
	}

	@Override
	public Suit visitGreaterThanExpression(GreaterThanExpressionContext ctx) {
		// TODO Auto-generated method stub
		return super.visitChildren(ctx);
	}

	@Override
	public Suit visitSmallerThanExpression(SmallerThanExpressionContext ctx) {
		// TODO Auto-generated method stub
		return super.visitChildren(ctx);
	}

	@Override
	public Suit visitMultiplicationExpression(MultiplicationExpressionContext ctx) {
		// TODO Auto-generated method stub
		return super.visitChildren(ctx);
	}

	@Override
	public Suit visitEnumerationDeclaration(EnumerationDeclarationContext ctx) {
		// TODO Auto-generated method stub
		return super.visitChildren(ctx);
	}

	@Override
	public Suit visitPlusMinusExpression(PlusMinusExpressionContext ctx) {
		// TODO Auto-generated method stub
		return super.visitChildren(ctx);
	}

	@Override
	public Suit visitStructure(StructureContext ctx) {
		// TODO Auto-generated method stub
		return super.visitChildren(ctx);
	}

	@Override
	public Suit visitGreaterThanEqualsToExpression(GreaterThanEqualsToExpressionContext ctx) {
		// TODO Auto-generated method stub
		return super.visitChildren(ctx);
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

	@Override
	public Suit visitAssignmentExpression(AssignmentExpressionContext ctx) {
		// TODO Auto-generated method stub
		return super.visitChildren(ctx);
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
	public Suit visitNotExpression(NotExpressionContext ctx) {
		// TODO Auto-generated method stub
		return super.visitChildren(ctx);
	}

	@Override
	public Suit visitAssignableFieldAccessExpression(AssignableFieldAccessExpressionContext ctx) {
		// TODO Auto-generated method stub
		return super.visitChildren(ctx);
	}

	@Override
	public Suit visitSmallerThanEqualsToExpression(SmallerThanEqualsToExpressionContext ctx) {
		// TODO Auto-generated method stub
		return super.visitChildren(ctx);
	}

	@Override
	public Suit visitStatement(StatementContext ctx) {
		// TODO Auto-generated method stub
		return super.visitChildren(ctx);
	}

	@Override
	public Suit visitAssignment(AssignmentContext ctx) {
		// TODO Auto-generated method stub
		return super.visitChildren(ctx);
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
		RecordSymbol compositeType = typeSymbolTable.resolve(compositeTypeIdentifier);

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

		FunctionSymbol symbol = new FunctionSymbol(functieNaam, returnSuit.type, argumentTypes);

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
		return new Suit(INT, true);
	}

	/*
	 * Een boolean-literal heeft geen contextbeperkingen en levert een
	 * constant boolean op.
	 */
	@Override
	public Suit visitBooleanLiteral(BooleanLiteralContext ctx) {
		return new Suit(BOOL, true);
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
				System.out.println("declaration of " + variableName + " successful");
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
		return new Suit(CHAR, true);
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
		if (! targetType.equals(expressionSuit.type)) {
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
				System.out.println("declaration of " + variableName + " successful (dirty)");
			} catch (SymbolTableException e) {
				reportError(e.getMessage(), ctx);
			}
		}

		return Suit.VOID;
	}

	/*
	 * Vanaf hier alleen de nutteloze functies die door de super al worden afgehandeld (verwijderen voor testen)
	 */
}
