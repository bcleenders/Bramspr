package bramspr;

import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.TerminalNode;

import symboltable.ArraySymbol;
import symboltable.EnumSymbol;
import symboltable.FunctionSymbol;
import symboltable.RecordSymbol;
import symboltable.TypeSymbol;
import symboltable.VariableSymbol;
import bramspr.BramsprParser.AdditionExpressionContext;
import bramspr.BramsprParser.AndExpressionContext;
import bramspr.BramsprParser.ArrayLiteralContext;
import bramspr.BramsprParser.ArrayTypeDenoterContext;
import bramspr.BramsprParser.AssignableExpressionContext;
import bramspr.BramsprParser.AssignableFieldAccessExpressionContext;
import bramspr.BramsprParser.AssignmentContext;
import bramspr.BramsprParser.AssignmentExpressionContext;
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
import bramspr.BramsprParser.LiteralExpressionContext;
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
	/*
	 * Een additionExpression (+,-) heeft twee int argumenten, en levert een int op. 
	 * De return value is constant als en slechts als beide input values constant zijn.
	 */
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
		Suit baseSuit = visit(ctx.arithmetic(0));
		Suit exponentSuit = visit(ctx.arithmetic(1));

		if (!baseSuit.type.equals(INT)) {
			this.reportError("exponentiation requires an int base", ctx.arithmetic(0), INT.toString(), baseSuit.type.toString());
			return Suit.ERROR;
		}

		if (!exponentSuit.type.equals(INT)) {
			this.reportError("exponentiation requires an int power", ctx.arithmetic(1), INT.toString(), exponentSuit.type.toString());
			return Suit.ERROR;
		}

		boolean bothConstant = baseSuit.isConstant && exponentSuit.isConstant;

		return new Suit(INT, bothConstant);
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
	/*
	 * Een notEqualsToExpression heeft twee of meer int input waardes, en geeft een bool terug.
	 * De return waarde is constant als en slechts als alle input waardes constant zijn.
	 */
	public Suit visitNotEqualsToExpression(NotEqualsToExpressionContext ctx) {
		boolean allConstant = true;

		for (int i = 0; i < ctx.arithmetic().size(); i++) {
			Suit currentSuit = visit(ctx.arithmetic(i));

			if (!currentSuit.equals(INT)) {
				this.reportError("=/= can only compare int values", ctx, INT.toString(), currentSuit.type.toString());
				return Suit.ERROR;
			}

			allConstant = allConstant && currentSuit.isConstant;
		}

		return new Suit(INT, allConstant);
	}

	@Override
	public Suit visitFunctionCall(FunctionCallContext ctx) {
		// TODO Auto-generated method stub
		return super.visitChildren(ctx);
	}

	@Override
	/*
	 * Een signexpression heeft ��n int argument, en geeft een type int terug.
	 * De return value is constant als en slechts als de input value constant is.
	 */
	public Suit visitSignExpression(SignExpressionContext ctx) {
		Suit expressionSuit = visit(ctx.arithmetic());

		if (!INT.equals(expressionSuit.type)) {
			this.reportError("cannot use +/- on non-int values", ctx.arithmetic(), INT.getIdentifier(), expressionSuit.type.getIdentifier());
			return Suit.ERROR;
		}

		return expressionSuit;
	}

	@Override
	public Suit visitExplicitEnumExpression(ExplicitEnumExpressionContext ctx) {
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

			if (!currentSuit.equals(INT)) { //TODO Hier gaat het mis; merkt niet dat INT en INT overeenkomt. (ook bij notequals)
				this.reportError("= can only compare int values", ctx, INT.toString(), currentSuit.type.toString());
				return Suit.ERROR;
			}

			allConstant = allConstant && currentSuit.isConstant;
		}

		return new Suit(INT, allConstant);
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

			if (!currentSuit.equals(INT)) {
				this.reportError("only int types are comparable with >", ctx, INT.toString(), currentSuit.type.toString());
				return Suit.ERROR;
			}

			allConstant = allConstant && currentSuit.isConstant;
		}

		return new Suit(INT, allConstant);
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

			if (!currentSuit.equals(INT)) {
				this.reportError("only int types are comparable with <", ctx, INT.toString(), currentSuit.type.toString());
				return Suit.ERROR;
			}

			allConstant = allConstant && currentSuit.isConstant;
		}

		return new Suit(INT, allConstant);
	}

	@Override
	/*
	 * Een multiplicationExpression (*, /, %) heeft twee int argumenten, en levert een int op. 
	 * De return value is constant als en slechts als beide input values constant zijn.
	 */
	public Suit visitMultiplicationExpression(MultiplicationExpressionContext ctx) {
		Suit leftExpression = visit(ctx.arithmetic(0));
		Suit rightExpression = visit(ctx.arithmetic(1));

		if (!leftExpression.type.equals(INT)) {
			this.reportError("multiplication/division/modulo only works for int values", ctx, INT.toString(), leftExpression.type.toString());
		}

		if (!rightExpression.type.equals(INT)) {
			this.reportError("multiplication/division/modulo only works for int values", ctx, INT.toString(), rightExpression.type.toString());
		}

		boolean bothConstant = leftExpression.isConstant && rightExpression.isConstant;

		return new Suit(INT, bothConstant);
	}

	@Override
	public Suit visitEnumerationDeclaration(EnumerationDeclarationContext ctx) {
		// TODO Auto-generated method stub
		return super.visitChildren(ctx);
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

		if (!leftExpression.type.equals(INT)) {
			this.reportError("a plus or minus expression (9 = 10 +- 2) takes three int values", ctx.arithmetic(0), INT.toString(),
					leftExpression.type.toString());
		}

		if (!middleExpression.type.equals(INT)) {
			this.reportError("a plus or minus expression (9 = 10 +- 2) takes three int values", ctx.arithmetic(1), INT.toString(),
					middleExpression.type.toString());
		}

		if (!rightExpression.type.equals(INT)) {
			this.reportError("a plus or minus expression (9 = 10 +- 2) takes three int values", ctx.arithmetic(2), INT.toString(),
					rightExpression.type.toString());
		}

		boolean allConstant = leftExpression.isConstant && middleExpression.isConstant && rightExpression.isConstant;

		return new Suit(BOOL, allConstant);
	}

	@Override
	public Suit visitStructure(StructureContext ctx) {
		// TODO Auto-generated method stub
		return super.visitChildren(ctx);
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

			if (!currentSuit.equals(INT)) {
				this.reportError("only int types are comparable with >=", ctx, INT.toString(), currentSuit.type.toString());
				return Suit.ERROR;
			}

			allConstant = allConstant && currentSuit.isConstant;
		}

		return new Suit(INT, allConstant);
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
	/*
	 * Een notExpression heeft ��n bool argument, en geeft een bool terug.
	 * De return value is constant als en slechts als het argument constant is.
	 */
	public Suit visitNotExpression(NotExpressionContext ctx) {
		Suit argSuit = visit(ctx.expression());

		if (!argSuit.type.equals(BOOL)) {
			reportError("illegal argument", ctx, BOOL.toString(), null);
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

			if (!currentSuit.equals(INT)) {
				this.reportError("only int types are comparable with <=", ctx, INT.toString(), currentSuit.type.toString());
				return Suit.ERROR;
			}

			allConstant = allConstant && currentSuit.isConstant;
		}

		return new Suit(INT, allConstant);
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
		// TypeSymbol type = typeSymbolTable.resolve((ctx.IDENTIFIER().getText()));

		// TODO Auto-generated method stub
		return super.visitChildren(ctx);
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
