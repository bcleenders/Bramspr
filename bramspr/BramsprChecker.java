package bramspr;

import java.util.HashSet;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.TerminalNode;

import bramspr.BramsprParser.AccessOnAssignableExpressionContext;
import bramspr.BramsprParser.AccessOnAtomicExpressionContext;
import bramspr.BramsprParser.AdditionExpressionContext;
import bramspr.BramsprParser.AndExpressionContext;
import bramspr.BramsprParser.ArrayAccessExpressionContext;
import bramspr.BramsprParser.ArrayLiteralContext;
import bramspr.BramsprParser.ArrayTypeDenoterContext;
import bramspr.BramsprParser.AssignableContext;
import bramspr.BramsprParser.AssignmentContext;
import bramspr.BramsprParser.AssignmentExpressionContext;
import bramspr.BramsprParser.BaseTypeDenoterContext;
import bramspr.BramsprParser.BlockStructureContext;
import bramspr.BramsprParser.BooleanLiteralContext;
import bramspr.BramsprParser.CharacterLiteralContext;
import bramspr.BramsprParser.CompositeDeclarationContext;
import bramspr.BramsprParser.CompositeLiteralContext;
import bramspr.BramsprParser.EnumerationDeclarationContext;
import bramspr.BramsprParser.EnumerationTypeDenoterContext;
import bramspr.BramsprParser.EqualsToExpressionContext;
import bramspr.BramsprParser.ExplicitEnumerationExpressionContext;
import bramspr.BramsprParser.FieldAccessExpressionContext;
import bramspr.BramsprParser.FunctionCallContext;
import bramspr.BramsprParser.FunctionDeclarationContext;
import bramspr.BramsprParser.GreaterThanEqualsToExpressionContext;
import bramspr.BramsprParser.GreaterThanExpressionContext;
import bramspr.BramsprParser.BasicAssignableContext;
import bramspr.BramsprParser.IfStructureContext;
import bramspr.BramsprParser.InstantiatingDeclarationContext;
import bramspr.BramsprParser.MultiplicationExpressionContext;
import bramspr.BramsprParser.NotEqualsToExpressionContext;
import bramspr.BramsprParser.NotExpressionContext;
import bramspr.BramsprParser.NumberLiteralContext;
import bramspr.BramsprParser.OrExpressionContext;
import bramspr.BramsprParser.ParenthesisExpressionContext;
import bramspr.BramsprParser.PlusMinusExpressionContext;
import bramspr.BramsprParser.PossibleEnumerationExpressionContext;
import bramspr.BramsprParser.PowerExpressionContext;
import bramspr.BramsprParser.ProgramContext;
import bramspr.BramsprParser.PureDeclarationContext;
import bramspr.BramsprParser.SignExpressionContext;
import bramspr.BramsprParser.SmallerThanEqualsToExpressionContext;
import bramspr.BramsprParser.SmallerThanExpressionContext;
import bramspr.BramsprParser.StringLiteralContext;
import bramspr.BramsprParser.SwapContext;
import bramspr.BramsprParser.UniversalEqualsToExpressionContext;
import bramspr.BramsprParser.UniversalNotEqualsToExpressionContext;
import bramspr.BramsprParser.WhileStructureContext;
import bramspr.symboltable.ArraySymbol;
import bramspr.symboltable.CompositeSymbol;
import bramspr.symboltable.EnumerationSymbol;
import bramspr.symboltable.FunctionSymbol;
import bramspr.symboltable.SymbolTable;
import bramspr.symboltable.SymbolTableException;
import bramspr.symboltable.TypeSymbol;
import bramspr.symboltable.VariableSymbol;

//public class BramsprChecker implements BramsprVisitor<Suit> {
public class BramsprChecker extends BramsprBaseVisitor<Suit> {

	/** The void symbol. */
	public static final CompositeSymbol VOID = new CompositeSymbol("void", null, null);

	/** The symbol for the built-in type <i>integer</i>. */
	public static final CompositeSymbol INTEGER = new CompositeSymbol("integer", null, null);

	/** The symbol for the built-in type <i>character</i>. */
	public static final CompositeSymbol CHARACTER = new CompositeSymbol("character", null, null);

	/** The symbol for the built-in type <i>boolean</i>. */
	public static final CompositeSymbol BOOLEAN = new CompositeSymbol("boolean", null, null);

	/** The symbol for the built-in type <i>string</i>. */
	public static final CompositeSymbol STRING = new CompositeSymbol("string", null, null);

	/** The symbol table in which declared and built-in functions are administered. */
	private SymbolTable<FunctionSymbol> functionSymbolTable = new SymbolTable<FunctionSymbol>();

	/** The symbol table in which declared variables are administered. */
	private SymbolTable<VariableSymbol> variableSymbolTable = new SymbolTable<VariableSymbol>();

	/** The symbol table in which declared and built-in types, excluding enumerations, are administered. */
	private SymbolTable<CompositeSymbol> typeSymbolTable = new SymbolTable<CompositeSymbol>();

	/** The symbol table in which declared enumerations are administered. */
	private SymbolTable<EnumerationSymbol> enumerationSymbolTable = new SymbolTable<EnumerationSymbol>(); // enumnamen (e.g. DAYS)

	/** TODO: Dit moet JavaDoc krijgen. */
	// TODO: moeten we hier nog wat mee doen? Wel hè?
	private ParseTreeProperty<ParseTree> declarationPointers;

	/** The current amount of encountered context errors in the program. */
	private int errorCount = 0;

	public BramsprChecker() {

	}

	/** Opens a new scope in all symbol tables. */
	private void openScope() {
		functionSymbolTable.openScope();
		variableSymbolTable.openScope();
		typeSymbolTable.openScope();
		enumerationSymbolTable.openScope();
	}

	/** Closes the current scope in all symbol tables. */
	private void closeScope() {
		functionSymbolTable.closeScope();
		variableSymbolTable.closeScope();
		typeSymbolTable.closeScope();
		enumerationSymbolTable.closeScope();
	}

	/** @return {@link #errorCount} */
	public int getErrorCount() {
		return errorCount;
	}

	/**
	 * Reports a context error.
	 * 
	 * Increases {@link #errorCount} and prints a message to {@link System#err}. If you don't want to specify {@code expected} and {@code encountered}, use
	 * {@link #reportError(String, ParserRuleContext)} instead.
	 * 
	 * @see #reportError(String, ParserRuleContext)
	 * 
	 * @param message
	 *            The error message to be printed.
	 * @param ctx
	 *            The context-object containing the erroneous code. Is used to include the line and column number in the error message.
	 * @param expected
	 *            A description of what was expected.
	 * @param encountered
	 *            A description of what was encountered.
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

	/**
	 * Reports a context error.
	 * 
	 * Works like {@link #reportError(String, ParserRuleContext, String, String)}, without an {@code expected} and {@code encountered}.
	 * 
	 * @see #reportError(String, ParserRuleContext, String, String)
	 */
	private void reportError(String message, ParserRuleContext erroneousNode) {
		reportError(message, erroneousNode, null, null);
	}

	@Override
	public Suit visitAccessOnAssignableExpression(AccessOnAssignableExpressionContext ctx) {
		return visit(ctx.accessExpression());
	}

	@Override
	public Suit visitAccessOnAtomicExpression(AccessOnAtomicExpressionContext ctx) {
		return visit(ctx.accessExpression());
	}

	/**
	 * Handles the context checking of an addition-expression.
	 * 
	 * An addition-expression is confined to the following context rules:
	 * 
	 * <br>
	 * <br>
	 * <ol>
	 * <li>both operands have to be of type <i>integer</i>;
	 * <li>the expression yields a value of type <i>integer</i>;
	 * <li>the expression yields a constant value if both operands are constant.
	 * </ol>
	 * 
	 * @param ctx
	 *            The context object associated with the parse tree node of this addition-expression.
	 * @return The suit of the addition-expression or {@link Suit#ERROR} in case of a context error.
	 */
	@Override
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

	/**
	 * Handles the context checking of an and-expression.
	 * 
	 * An and-expression is confined to the following context rules:
	 * 
	 * <br>
	 * <br>
	 * <ol>
	 * <li>both operands have to be of type <i>boolean</i>;
	 * <li>the expression yields a value of type <i>boolean</i>;
	 * <li>the expression yields a constant value if both operands are constant.
	 * </ol>
	 * 
	 * @param ctx
	 *            The context object associated with the parse tree node of this and-expression.
	 * @return The suit of the and-expression or {@link Suit#ERROR} in case of a context error.
	 */
	@Override
	public Suit visitAndExpression(AndExpressionContext ctx) {
		Suit leftExpression = visit(ctx.expression(0));
		Suit rightExpression = visit(ctx.expression(1));

		if (!leftExpression.type.equals(BOOLEAN)) {
			this.reportError("logical operator AND only works for bool values", ctx, BOOLEAN.toString(), leftExpression.type.toString());
			return Suit.ERROR;
		}

		if (!rightExpression.type.equals(BOOLEAN)) {
			this.reportError("logical operator AND only works for int values", ctx, BOOLEAN.toString(), rightExpression.type.toString());
			return Suit.ERROR;
		}

		boolean isConstant = leftExpression.isConstant && rightExpression.isConstant;
		return new Suit(BOOLEAN, isConstant);
	}

	/**
	 * Handles the context checking of an array-access-expression.
	 * 
	 * An array-access-expression is confined to the following context rules:
	 * 
	 * <br>
	 * <br>
	 * <ol>
	 * <li>the array-expression must yield an array-typed value;
	 * <li>the index-expression must yield a value of type <i>integer</i>;
	 * <li>the yielded value is of the type of the array elements;
	 * <li>the yielded value is constant if both the accessed array and the index are constant.
	 * </ol>
	 * 
	 * @param ctx
	 *            The context object associated with the parse tree node of this array-access-expression.
	 * @return The suit of the array-access-expression or {@link Suit#ERROR} in case of a context error.
	 */
	@Override
	public Suit visitArrayAccessExpression(ArrayAccessExpressionContext ctx) {
		// Pak het meest linker kind van de parent, en kijk wat voor suit het heeft.
		Suit expressionSuit = visit(ctx.parent.getChild(0));
		Suit indexSuit = visit(ctx.expression());

		// Levert de linkerexpressie een arraywaarde op?
		if (expressionSuit.type instanceof ArraySymbol) {

			// Ja, het levert een arraywaarde op! We kunnen deze cast nu maken.
			ArraySymbol arrayType = (ArraySymbol) expressionSuit.type;

			// Nu kijken of de meegegeven index wel een integer is.
			if (indexSuit.type.equals(INTEGER)) {

				// Alles klopt. Gaan met die banaan.
				return new Suit(arrayType.type, expressionSuit.isConstant && indexSuit.isConstant);

			} else {

				// Oh oh. De meegegeven index is geen integer...
				String errorMessage = "The expression '" + ctx.expression().getText() + "' yields no integer value. Array indexes must be of integer type.";
				reportError(errorMessage, ctx);
				return Suit.ERROR;
			}

		} else {

			// Oh oh. De linkerexpressie levert geen arraywaarde op...
			String errorMessage = "The expression '" + ctx.getParent().getChild(0).getText() + "' does not yield an array.";
			reportError(errorMessage, ctx);
			return Suit.ERROR;
		}
	}

	/**
	 * Handles the context checking of an array-literal.
	 * 
	 * An array-literal is confined to the following context rules:
	 * 
	 * <br>
	 * <br>
	 * <ol>
	 * <li>all elements must have an existing type;
	 * <li>all elements must have the same type;
	 * <li>the array-literal is constant if all of its elements are constant;
	 * <li>the array-literal is of type <i>[n]type</i>, where <i>n</i> is the amount of elements and <i>type</i> is the type of the elements, or void when there
	 * are no elements.
	 * </ol>
	 * <br>
	 * 
	 * This method only implements the last three. Rule 1 is already governed by the visit-methods for the individual elements, which get called by this method.
	 * 
	 * @param ctx
	 *            The context object associated with the parse tree node of this array-literal.
	 * @return The suit of the array-literal or {@link Suit#ERROR} in case of a context error.
	 */
	public Suit visitArrayLiteral(ArrayLiteralContext ctx) {
		int aantalElementen = ctx.expression().size();

		if (aantalElementen == 0) {
			// CR4: return void in case of no elements.
			return new Suit(new ArraySymbol(0, VOID), true);
		}

		// Wat voor types zou hij bevatten?
		Suit firstElementSuit = visit(ctx.expression(0));

		boolean allConstant = true;
		for (int i = 1; i < aantalElementen; i++) {
			// Type van het huidige element.
			Suit currElementSuit = visit(ctx.expression(i));

			// CR2: see if types match.
			if (!firstElementSuit.type.equals(currElementSuit.type)) {
				this.reportError("attempted to enter different types in array literal: use records for that!", ctx.expression(i),
						firstElementSuit.type.getIdentifier(), currElementSuit.type.getIdentifier());
			}

			// CR3: check if it is still a constant array.
			allConstant = allConstant && currElementSuit.isConstant;
		}

		ArraySymbol arrayType = new ArraySymbol(aantalElementen, firstElementSuit.type);

		return new Suit(arrayType, allConstant);
	}

	@Override
	public Suit visitArrayTypeDenoter(ArrayTypeDenoterContext ctx) {
		int size = Integer.parseInt(ctx.NUMBER().getText());

		TypeSymbol elementType = visit(ctx.typeDenoter()).type;

		ArraySymbol arrayType = new ArraySymbol(size, elementType);

		return new Suit(arrayType, false);
	}

	/**
	 * Handles the context checking of an assignment.
	 * 
	 * An assignment is confined to the following context rules:
	 * 
	 * <br>
	 * <br>
	 * <ol>
	 * <li>the assignable(s) must exist (the identifier(s) must be declared as variable(s) / the reffered field(s) must exist);
	 * <li>the assignable(s) must not be constant;
	 * <li>the assignable(s) and the expression should be of the same type.
	 * </ol>
	 * <br>
	 * 
	 * Rule 1 is checked in the visit-method(s) of the individual assignable(s), which get called by this method. This method therefore only checks the last two
	 * rules.
	 * 
	 * @param ctx
	 *            The context object associated with the parse tree node of this assignment.
	 * @return The suit of the expression, or {@link Suit#ERROR} in case of a context error.
	 */
	@Override
	public Suit visitAssignment(AssignmentContext ctx) {
		// Alle assignables opvragen.
		List<AssignableContext> assignables = ctx.assignable();

		// Type van de expressie opvragen.
		Suit expressionSuit = visit(ctx.expression());
		TypeSymbol expressionType = expressionSuit.type;

		for (AssignableContext assignable : assignables) {
			// Suit van de assignable opvragen.
			Suit assignableSuit = visit(assignable);

			if (assignableSuit.isConstant) {
				// Oh oh, deze assignable is constant. Dat mag niet. Error reporten en error-suit teruggeven.
				String errorMessage = "The variable '" + assignable.getText()
						+ "' is constant. After initialisation, constant variables can not be assigned new values.";
				reportError(errorMessage, assignable);
				return Suit.ERROR;
			}

			if (!assignableSuit.type.equals(expressionType)) {
				// Onjuist type. Error reporten en error-suit teruggeven.
				String errorMessage = "Expression '" + ctx.expression().getText() + "' yields the wrong type of value for variable '" + assignable.getText()
						+ "'.";
				reportError(errorMessage, assignable, assignableSuit.type.toString(), expressionType.toString());
				return Suit.ERROR;
			}
		}

		// Alles klopt! Nu als suit de suit van de expressie teruggeven.
		return expressionSuit;
	}

	/**
	 * Handles the context checking of an assignment-expression.
	 * 
	 * Visits the enclosed assignment and passes on its suit.
	 * 
	 * @param ctx
	 *            The context object associated with the parse tree node of this assignment-expression.
	 * @return The suit of the enclosed assignment.
	 */
	@Override
	public Suit visitAssignmentExpression(AssignmentExpressionContext ctx) {
		return visit(ctx.assignment());
	}

	/**
	 * Handles the context checking of a base-type-denoter.
	 * 
	 * First tries to resolve type denoter's identifier in {@link #typeSymbolTable}. If that gives no result, tries again in {@link #enumerationSymbolTable}.
	 * 
	 * @param ctx
	 *            The context object associated with the parse tree node of this base-type-denoter.
	 * @return A suit with the denoted type as type, or {@link Suit#ERROR} if no declaration was found.
	 */
	@Override
	public Suit visitBaseTypeDenoter(BaseTypeDenoterContext ctx) {
		String typeName = ctx.IDENTIFIER().getText();
		TypeSymbol type = this.typeSymbolTable.resolve(typeName);

		if (type != null) {
			return new Suit(type, false);
		}

		// Het is dus niet een normaal type. Misschien een enumeration dan?
		type = this.enumerationSymbolTable.resolve(typeName);
		if (type != null) {
			return new Suit(type, false);
		}

		this.reportError("reference to non-existing type/enumeration '" + typeName + "'.", ctx);
		return Suit.ERROR;
	}

	/*
	 * Een basicAssignable moet voldoen aan de volgende contextuele eisen:
	 * 	1. Er moet of een variabele of een enumeration met de naam bestaan.
	 * 	2. Indien het een variabele is, is het return type gelijk aan het return type van de variabele zoals eerder gedeclareerd in de huidige scope.
	 * 	3. Indien het een enumeration is, wordt een enumeration type teruggegeven.
	 */
	public Suit visitBasicAssignable(BasicAssignableContext ctx) {
		VariableSymbol variable = this.variableSymbolTable.resolve(ctx.IDENTIFIER().getText());

		if (variable != null) {
			return new Suit(variable.getReturnType(), variable.isConstant());
		}

		EnumerationSymbol enumSymbol = this.enumerationSymbolTable.resolve(ctx.IDENTIFIER().getText());
		if (enumSymbol != null) {
			return new Suit(enumSymbol, true);
		}

		this.reportError("reference to non-existing variable/enumeration type '" + ctx.IDENTIFIER().getText() + "'.", ctx);
		return Suit.ERROR;
	}

	/**
	 * Handles the context checking of a block-structure.
	 * 
	 * Just visits the enclosed statements.
	 * 
	 * @param ctx
	 *            The context object associated with the parse tree node of this block-structure.
	 * @return A block-structure has no return suit, so returns a meaningless {@link Suit#VOID}.
	 */
	@Override
	public Suit visitBlockStructure(BlockStructureContext ctx) {
		for (int i = 0; i < ctx.statement().size(); i++) {
			visit(ctx.statement(i));
		}

		return Suit.VOID;
	}

	/**
	 * Handles the context checking of a boolean-literal by returning a constant <i>boolean</i>-suit.
	 * 
	 * @param ctx
	 *            The context object associated with the parse tree node of this boolean-literal.
	 * @return A constant <i>boolean</i>-suit.
	 */
	@Override
	public Suit visitBooleanLiteral(BooleanLiteralContext ctx) {
		return new Suit(BOOLEAN, true);
	}

	/**
	 * Handles the context checking of a character-literal by returning a constant <i>character</i>-suit.
	 * 
	 * @param ctx
	 *            The context object associated with the parse tree node of this character-literal.
	 * @return A constant <i>character</i>-suit.
	 */
	@Override
	public Suit visitCharacterLiteral(CharacterLiteralContext ctx) {
		return new Suit(CHARACTER, true);
	}

	/**
	 * Handles the context checking of a composite-declaration.
	 * 
	 * A composite-declaration is confined to the following context rules:
	 * 
	 * <br>
	 * <br>
	 * <ol>
	 * <li>a composite type with the same identifier must not already be declared in this scope;
	 * <li>all fields must have a unique identifier;
	 * <li>the types of all fields must have been declared.
	 * </ol>
	 * <br>
	 * 
	 * Rule 3 is already checked by the visit-method(s) of the type-denoter(s), which this method calls. This method checks thus checks the other rules and then
	 * declares the composite type to {@link #typeSymbolTable}.
	 * 
	 * @param ctx
	 *            The context object associated with the parse tree node of this composite-declaration.
	 * @return A composite-declaration has no return suit, so returns a meaningless {@link Suit#VOID}.
	 */	
	@Override
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

	/**
	 * Handles the context checking of an enumeration-declaration.
	 * 
	 * An enumeration-declaration is confined to the following context rules:
	 * 
	 * <br>
	 * <br>
	 * <ol>
	 * <li>an enumeration with the same identifier must not already be declared in this scope;
	 * <li>the value-identifiers have to be unique.
	 * </ol>
	 * <br>
	 * 
	 * After checking these rules, this method declares the enumeration {@link #enumerationSymbolTable}.
	 * 
	 * @param ctx
	 *            The context object associated with the parse tree node of this enumeration-declaration.
	 * @return An enumeration-declaration has no return suit, so returns a meaningless {@link Suit#VOID}.
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
	public Suit visitEnumerationTypeDenoter(EnumerationTypeDenoterContext ctx) {
		String typeName = ctx.IDENTIFIER().getText();
		TypeSymbol type = this.enumerationSymbolTable.resolve(typeName);
		if (type != null) {
			return new Suit(type, false);
		}

		this.reportError("reference to non-existing type/enumeration '" + typeName + "'.", ctx);
		return Suit.ERROR;
	}

	/**
	 * Handles the context checking of an equals-to-expression.
	 * 
	 * An equals-to-expression is confined to the following context rules:
	 * 
	 * <br>
	 * <br>
	 * <ol>
	 * <li>all operands have to be of type <i>integer</i>;
	 * <li>the expression yields a value of type <i>boolean</i>;
	 * <li>the expression yields a constant value if all operands are constant.
	 * </ol>
	 * 
	 * @param ctx
	 *            The context object associated with the parse tree node of this equals-to-expression.
	 * @return The suit of the equals-to-expression or {@link Suit#ERROR} in case of a context error.
	 */
	@Override
	public Suit visitEqualsToExpression(EqualsToExpressionContext ctx) {
		boolean allConstant = true;

		for (int i = 0; i < ctx.arithmetic().size(); i++) {
			Suit currentSuit = visit(ctx.arithmetic(i));

			if (!currentSuit.equals(INTEGER)) {
				this.reportError("multiple = can only compare int values", ctx, INTEGER.toString(), currentSuit.type.toString());
				return Suit.ERROR;
			}

			allConstant = allConstant && currentSuit.isConstant;
		}

		return new Suit(BOOLEAN, allConstant);
	}

	/**
	 * When a syntactically erroneous program is parsed, the parse tree will contain error nodes. This method handles their context checking.
	 * 
	 * @param node
	 *            The node that is to be visited.
	 * @return An error node is erroneous by definition, so {@link Suit#ERROR}.
	 */
	@Override
	public Suit visitErrorNode(ErrorNode node) {
		return Suit.ERROR;
	}

	@Override
	/*
	 * Een explicitEnumerationExpression moet aan de volgende contexteisen voldoen:
	 * 	1 Het enumeration type moet bestaan
	 * 	2 Het enumeration type moet een veld met de gereferencete naam hebben
	 * Het return type is een enumSymbol
	 */
	public Suit visitExplicitEnumerationExpression(ExplicitEnumerationExpressionContext ctx) {
		String enumName = ctx.IDENTIFIER(0).getText();
		String fieldName = ctx.IDENTIFIER(1).getText();

		EnumerationSymbol enumSymbol = this.enumerationSymbolTable.resolve(enumName);

		if (enumSymbol == null) { // Test #1

			this.reportError("reference to non-existing enumeration type '" + enumName + "'.", ctx);
			return Suit.ERROR;
		}

		if (!enumSymbol.hasValue(fieldName)) { // Test #2
			this.reportError("reference to non-existing field '" + fieldName + "' in enumeration type '" + enumName + "'.", ctx);
			return Suit.ERROR;
		}

		return new Suit(enumSymbol, true);
	}

	@Override
	/*
	 * Een fieldAccessExpression moet aan de volgende contextuele eisen voldoen:
	 * Als de assignable een record oplevert (type is een CompositeSymbol), dan gelden de volgende eisen:
	 * 	1.1 Het type moet over een veld met de gerefereerde naam hebben.
	 * 	1.2 Het return type is gelijk aan het type van dat veld.
	 * 	1.3	De return waarde is constant als en slechts als het record constant is.
	 */
	public Suit visitFieldAccessExpression(FieldAccessExpressionContext ctx) {
		// Pak het meest linker kind van de parent, en kijk wat voor type/Suit het heeft.
		Suit expressionSuit = visit(ctx.parent.getChild(0));
		String fieldName = ctx.IDENTIFIER().getText();

		// Kijken of dit een record is.
		if (expressionSuit.type instanceof CompositeSymbol) {
			CompositeSymbol compositeType = (CompositeSymbol) expressionSuit.type;

			// Test eis #1.1
			if (!compositeType.hasField(fieldName)) {
				reportError("Type " + expressionSuit.type.getIdentifier() + " does not contain field " + fieldName + ".", ctx);
				return Suit.ERROR;

			} else {
				// Dit veld bestaat! Return suit aanpassen aan type (#1.2), en de mutability volgens de 'chain of mutability' doen (#1.3).
				return new Suit(compositeType.getFieldType(fieldName), expressionSuit.isConstant);
			}

		}

		this.reportError("Unexpected field access on non-composite value: no suggestions available", ctx);
		return Suit.ERROR;
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

	/**
	 * Handles the context checking of a greater-than-equals-to-expression.
	 * 
	 * A greater-than-equals-to-expression is confined to the following context rules:
	 * 
	 * <br>
	 * <br>
	 * <ol>
	 * <li>all operands have to be of type <i>integer</i>;
	 * <li>the expression yields a value of type <i>boolean</i>;
	 * <li>the expression yields a constant value if all operands are constant.
	 * </ol>
	 * 
	 * @param ctx
	 *            The context object associated with the parse tree node of this greater-than-equals-to-expression.
	 * @return The suit of the greater-than-equals-to-expression or {@link Suit#ERROR} in case of a context error.
	 */
	@Override
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

	/**
	 * Handles the context checking of a greater-than-expression.
	 * 
	 * A greater-than-expression is confined to the following context rules:
	 * 
	 * <br>
	 * <br>
	 * <ol>
	 * <li>all operands have to be of type <i>integer</i>;
	 * <li>the expression yields a value of type <i>boolean</i>;
	 * <li>the expression yields a constant value if all operands are constant.
	 * </ol>
	 * 
	 * @param ctx
	 *            The context object associated with the parse tree node of this greater-than-expression.
	 * @return The suit of the greater-than-expression or {@link Suit#ERROR} in case of a context error.
	 */
	@Override
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

	/**
	 * Handles the context checking of an if-structure.
	 * 
	 * Checks if the condition-expression yields a <i>boolean</i> value and then calls the visit-method(s) of the block-structure(s).
	 * 
	 * @param ctx
	 *            The context object associated with the parse tree node of this if-structure.
	 * @return A if-structure has no return suit, so returns a meaningless {@link Suit#VOID}.
	 */
	@Override
	public Suit visitIfStructure(IfStructureContext ctx) {
		Suit conditionSuit = visit(ctx.expression());

		if (!conditionSuit.type.equals(BOOLEAN)) {
			// Helaas, hij levert geen boolean waarde op. Error reporten.
			String errorMessage = "The condition for if-structures should yield a boolean value, which the expression '" + ctx.expression().getText()
					+ "' does not.";
			reportError(errorMessage, ctx.expression(), BOOLEAN.toString(), conditionSuit.type.toString());
		}

		// Het if-block visiten.
		visit(ctx.blockStructure(0));

		// Er is misschien een else-deel. Dit block dan ook visiten.
		if (ctx.blockStructure(1) != null) {
			visit(ctx.blockStructure(1));
		}

		return Suit.VOID;
	}

	/**
	 * Handles the context checking of an instantiating-declaration.
	 * 
	 * An instantiating-declaration is confined to the following context rules:
	 * 
	 * <br>
	 * <br>
	 * <ol>
	 * <li>the identifier(s) must not be already declared in this scope;
	 * <li>the denoted type must be declared;
	 * <li>the expression should yield the same type as the denoted type;
	 * <li>if the variable(s) is/are declared as constant, the expression should be constant.
	 * </ol>
	 * <br>
	 * 
	 * Rule 2 is already checked by the visit-method of the type-denoter, which this method calls. This method checks thus checks the other rules and then
	 * declares the variable(s) to {@link #variableSymbolTable}.
	 * 
	 * @param ctx
	 *            The context object associated with the parse tree node of this instantiating-declaration.
	 * @return An instantiating-declaration has no return suit, so returns a meaningless {@link Suit#VOID}.
	 */
	@Override
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

	/**
	 * Handles the context checking of a multiplication-expression.
	 * 
	 * A multiplication-expression is confined to the following context rules:
	 * 
	 * <br>
	 * <br>
	 * <ol>
	 * <li>both operands have to be of type <i>integer</i>;
	 * <li>the expression yields a value of type <i>integer</i>;
	 * <li>the expression yields a constant value if both operands are constant.
	 * </ol>
	 * 
	 * @param ctx
	 *            The context object associated with the parse tree node of this multiplication-expression.
	 * @return The suit of the multiplication-expression or {@link Suit#ERROR} in case of a context error.
	 */
	@Override
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

	/**
	 * Handles the context checking of a not-equals-to-expression.
	 * 
	 * A not-equals-to-to-expression is confined to the following context rules:
	 * 
	 * <br>
	 * <br>
	 * <ol>
	 * <li>all operands have to be of type <i>integer</i>;
	 * <li>the expression yields a value of type <i>boolean</i>;
	 * <li>the expression yields a constant value if all operands are constant.
	 * </ol>
	 * 
	 * @param ctx
	 *            The context object associated with the parse tree node of this not-equals-to-expression.
	 * @return The suit of the not-equals-to-expression or {@link Suit#ERROR} in case of a context error.
	 */
	@Override
	public Suit visitNotEqualsToExpression(NotEqualsToExpressionContext ctx) {
		boolean allConstant = true;

		for (int i = 0; i < ctx.arithmetic().size(); i++) {
			Suit currentSuit = visit(ctx.arithmetic(i));

			if (!currentSuit.type.equals(INTEGER)) {
				System.out.println("Types komen niet overeen.");
				System.out.println(INTEGER);
				System.out.println(currentSuit.type);

				this.reportError("multiple =/= can only compare int values", ctx.arithmetic(i), INTEGER.toString(), currentSuit.type.toString());
				return Suit.ERROR;
			}

			allConstant = allConstant && currentSuit.isConstant;
		}

		return new Suit(BOOLEAN, allConstant);
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

	/**
	 * Handles the context checking of a number-literal by returning a constant <i>integer</i>-suit.
	 * 
	 * @param ctx
	 *            The context object associated with the parse tree node of this number-literal.
	 * @return A constant <i>integer</i>-suit.
	 */
	@Override
	public Suit visitNumberLiteral(NumberLiteralContext ctx) {
		return new Suit(INTEGER, true);
	}

	/**
	 * Handles the context checking of an or-expression.
	 * 
	 * An or-expression is confined to the following context rules:
	 * 
	 * <br>
	 * <br>
	 * <ol>
	 * <li>both operands have to be of type <i>boolean</i>;
	 * <li>the expression yields a value of type <i>boolean</i>;
	 * <li>the expression yields a constant value if both operands are constant.
	 * </ol>
	 * 
	 * @param ctx
	 *            The context object associated with the parse tree node of this or-expression.
	 * @return The suit of the or-expression or {@link Suit#ERROR} in case of a context error.
	 */
	@Override
	public Suit visitOrExpression(OrExpressionContext ctx) {
		Suit leftExpression = visit(ctx.expression(0));
		Suit rightExpression = visit(ctx.expression(1));

		if (!leftExpression.type.equals(BOOLEAN)) {
			this.reportError("logical operator OR only works for bool values", ctx, BOOLEAN.toString(), leftExpression.type.toString());
			return Suit.ERROR;
		}

		if (!rightExpression.type.equals(BOOLEAN)) {
			this.reportError("logical operator OR only works for int values", ctx, BOOLEAN.toString(), rightExpression.type.toString());
			return Suit.ERROR;
		}

		boolean isConstant = leftExpression.isConstant && rightExpression.isConstant;
		return new Suit(BOOLEAN, isConstant);
	}

	/**
	 * Handles the context checking of a parenthesis-expression.
	 * 
	 * Visits the enclosed expression and passes on its suit.
	 * 
	 * @param ctx
	 *            The context object associated with the parse tree node of this parenthesis-expression.
	 * @return The suit of the enclosed expression.
	 */
	@Override
	public Suit visitParenthesisExpression(ParenthesisExpressionContext ctx) {
		return visit(ctx.expression());
	}

	/**
	 * Handles the context checking of a plus-minus-expression.
	 * 
	 * A plus-minus-expression is confined to the following context rules:
	 * 
	 * <br>
	 * <br>
	 * <ol>
	 * <li>all three operands have to be of type <i>integer</i>;
	 * <li>the expression yields a value of type <i>boolean</i>;
	 * <li>the expression yields a constant value if all three operands are constant.
	 * </ol>
	 * 
	 * @param ctx
	 *            The context object associated with the parse tree node of this plus-minus-expression.
	 * @return The suit of the plus-minus-expression or {@link Suit#ERROR} in case of a context error.
	 */
	@Override
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
	/*Een possibleEnumerationExpression moet aan de volgende contextuele eisen voldoen:
	 * Als er een variabele bestaat met de naam, dan gelden de volgende eisen:
	 * 	1.1 De variabele moet een record (composite) bevatten.
	 * 	1.2 Het type van deze composite moet over een veld met de gerefereerde naam hebben.
	 * 	1.3 Het return type is gelijk aan het type van dat veld.
	 * 	1.4	De return waarde is constant als en slechts als het record constant is.
	 * Als de assignable geen record oplevert maar wél een enumeration (impliciete referentie naar enumeration), dan gelden de volgende eisen:
	 * 	2.1 Het enumeration type moet een veld met de gerefereerde naam hebben.
	 * 	2.2 Het return type is een EnumerationSymbol
	 *  2.3 Het return type is constant
	 * Als een assignable geen record en geen enumeration, dan is het geen geldige expressie.
	 */
	public Suit visitPossibleEnumerationExpression(PossibleEnumerationExpressionContext ctx) {
		// Return suite van de expression opvragen.
		String prefixName = ctx.IDENTIFIER(0).getText();
		String fieldName = ctx.IDENTIFIER(1).getText();

		// Deze variabele bevat een record indien deze gedefinieerd is.
		VariableSymbol prefix = this.variableSymbolTable.resolve(prefixName);
		EnumerationSymbol prefixEnum = this.enumerationSymbolTable.resolve(prefixName);

		// Kijken of dit een record is.
		if (prefix != null) {
			if (!(prefix.getReturnType() instanceof CompositeSymbol)) {
				// De variabele bestaat wel, maar heeft geen velden.
				String errorMessage = "Type " + prefix.getReturnType().getIdentifier() + " does not have fields.";

				// Checken of er wel een enumeration is die het zou kunnen zijn:
				EnumerationSymbol enumSymbol = this.enumerationSymbolTable.resolve(prefixName);
				if (enumSymbol != null && enumSymbol.hasValue(fieldName)) {
					// Er is inderdaad een gelijknamige enumeration met dit veld. Error message uitbreiden met hint.
					errorMessage = errorMessage + "Warning: please be aware that enumeration " + prefixName + " is currently being hidden by variable "
							+ prefixName + ". To explicitly denote the enumeration, use 'enumeration." + prefixName + "." + fieldName + "'.";
				}

				this.reportError(errorMessage, ctx);
				return Suit.ERROR;
			}

			CompositeSymbol compositeType = (CompositeSymbol) prefix.getReturnType();

			// Test eis #1.1
			if (!compositeType.hasField(fieldName)) {
				/*
				 * De programmeur heeft een fout gemaakt: dit recordtype heeft dit veld niet. Het kan echter zijn dat de programmeur
				 * een gelijknamige enumeration bedoelde, en was vergeten dat de record dan de enumeration hidet. Om een zinvolle
				 * errormessage te geven, gaan we daarom ook even kijken of er niet toevallig een enumeration met dezelfde naam
				 * bestaat dat wèl deze veldnaam bezit.
				 */
				String errorMessage = "Type " + compositeType.getIdentifier() + " does not contain field " + fieldName + ".";
				EnumerationSymbol enumSymbol = this.enumerationSymbolTable.resolve(prefixName);
				if (enumSymbol != null && enumSymbol.hasValue(fieldName)) {
					// Er is inderdaad een gelijknamige enumeration met dit veld. Error message uitbreiden met hint.

					errorMessage = errorMessage + "Warning: please be aware that enumeration " + prefixName + " is currently being hidden by type "
							+ prefixName + ". To explicitly denote the enumeration, use 'enumeration." + prefixName + "." + fieldName + "'.";
				}

				reportError(errorMessage, ctx);
				return Suit.ERROR;

			} else {
				// Dit veld bestaat! Return suit aanpassen aan type (#1.2), en de mutability volgens de 'chain of mutability' doen (#1.3).
				return new Suit(compositeType.getFieldType(fieldName), prefix.isConstant());
			}

		} else if (prefixEnum != null) { // Er bestaat een enumeration met deze naam!
			// Eis #1.1
			if (!prefixEnum.hasValue(fieldName)) {
				String errorMessage = "enumeration " + prefixName + " does not contain constant " + fieldName + ".";
				reportError(errorMessage, ctx);
				return Suit.ERROR;
			} else {
				return new Suit(prefixEnum, true);
			}
		}

		this.reportError("no variable or enumeration with this name ('" + prefixName + "') declared", ctx);
		return Suit.ERROR;
	} // Vanaf hier alleen de nutteloze functies die door de super al worden afgehandeld (verwijderen voor testen)

	/**
	 * Handles the context checking of a power-expression.
	 * 
	 * A power-expression is confined to the following context rules:
	 * 
	 * <br>
	 * <br>
	 * <ol>
	 * <li>both operands have to be of type <i>integer</i>;
	 * <li>the expression yields a value of type <i>integer</i>;
	 * <li>the expression yields a constant value if both operands are constant.
	 * </ol>
	 * 
	 * @param ctx
	 *            The context object associated with the parse tree node of this power-expression.
	 * @return The suit of the power-expression or {@link Suit#ERROR} in case of a context error.
	 */
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

	/**
	 * Handles the context checking of a Bramspr program.
	 * 
	 * Opens the root scope, declares all built-in types and functions, recursively context-checks the program and finally closes the root scope.
	 * 
	 * @param ctx
	 *            The context object associated with the top node of the program's parse tree.
	 * @return A program has no return suit, so returns a meaningless {@link Suit#VOID}.
	 */
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

	/**
	 * Handles the context checking of a pure-declaration.
	 * 
	 * A pure-declaration is confined to the following context rules:
	 * 
	 * <br>
	 * <br>
	 * <ol>
	 * <li>the identifier(s) must not be already declared in this scope;
	 * <li>the denoted type must be declared;
	 * </ol>
	 * <br>
	 * 
	 * Rule 2 is already checked by the visit-method of the type-denoter, which this method calls. This method checks thus checks the first rule and then
	 * declares the variable(s) to {@link #variableSymbolTable}.
	 * 
	 * @param ctx
	 *            The context object associated with the parse tree node of this pure-declaration.
	 * @return A pure-declaration has no return suit, so returns a meaningless {@link Suit#VOID}.
	 */
	@Override
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

	/**
	 * Handles the context checking of a sign-expression.
	 * 
	 * A sign-expression is confined to the following context rules:
	 * 
	 * <br>
	 * <br>
	 * <ol>
	 * <li>the operand must be of type <i>integer</i>;
	 * <li>the expression yields a value of type <i>boolean</i>;
	 * <li>the expression yields a constant value if the operand is constant.
	 * </ol>
	 * 
	 * @param ctx
	 *            The context object associated with the parse tree node of this sign-expression.
	 * @return The suit of the sign-expression or {@link Suit#ERROR} in case of a context error.
	 */
	public Suit visitSignExpression(SignExpressionContext ctx) {
		Suit expressionSuit = visit(ctx.arithmetic());

		if (!INTEGER.equals(expressionSuit.type)) {
			this.reportError("cannot use +/- on non-int values", ctx.arithmetic(), INTEGER.getIdentifier(), expressionSuit.type.getIdentifier());
			return Suit.ERROR;
		}

		return expressionSuit;
	}

	/**
	 * Handles the context checking of a smaller-than-equals-to-expression.
	 * 
	 * A smaller-than-equals-to-expression is confined to the following context rules:
	 * 
	 * <br>
	 * <br>
	 * <ol>
	 * <li>all operands have to be of type <i>integer</i>;
	 * <li>the expression yields a value of type <i>boolean</i>;
	 * <li>the expression yields a constant value if all operands are constant.
	 * </ol>
	 * 
	 * @param ctx
	 *            The context object associated with the parse tree node of this smaller-than-equals-to-expression.
	 * @return The suit of the smaller-than-equals-to-expression or {@link Suit#ERROR} in case of a context error.
	 */
	@Override
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

	/**
	 * Handles the context checking of a smaller-than-expression.
	 * 
	 * A smaller-than-expression is confined to the following context rules:
	 * 
	 * <br>
	 * <br>
	 * <ol>
	 * <li>all operands have to be of type <i>integer</i>;
	 * <li>the expression yields a value of type <i>boolean</i>;
	 * <li>the expression yields a constant value if all operands are constant.
	 * </ol>
	 * 
	 * @param ctx
	 *            The context object associated with the parse tree node of this smaller-than-expression.
	 * @return The suit of the smaller-than-expression or {@link Suit#ERROR} in case of a context error.
	 */
	@Override
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

	/**
	 * Handles the context checking of a string-literal by returning a constant <i>string</i>-suit.
	 * 
	 * @param ctx
	 *            The context object associated with the parse tree node of this string-literal.
	 * @return A constant <i>string</i>-suit.
	 */
	@Override
	public Suit visitStringLiteral(StringLiteralContext ctx) {
		return new Suit(STRING, true);
	}

	/**
	 * Handles the context checking of a swap.
	 * 
	 * A swap is confined to the following context rules:
	 * 
	 * <br>
	 * <br>
	 * <ol>
	 * <li>the assignables must exist (the identifier(s) must be declared as variable(s) / the reffered field(s) must exist);
	 * <li>the assignables must not be constant;
	 * <li>the assignables must be of the same type.
	 * </ol>
	 * <br>
	 * 
	 * Rule 1 is checked in the visit-methods of the individual assignables, which get called by this method. This method therefore only checks the last two
	 * rules.
	 * 
	 * @param ctx
	 *            The context object associated with the parse tree node of this swap.
	 * @return A swap has no return suit, so returns a meaningless {@link Suit#VOID}.
	 */
	@Override	public Suit visitSwap(SwapContext ctx) {
		//TODO: checken of hier geen constanten geswapt worden
		TypeSymbol rightType = visit(ctx.assignable(0)).type;
		TypeSymbol leftType = visit(ctx.assignable(1)).type;

		if (!rightType.equals(leftType)) {
			this.reportError("swap cannot swap variables with different types", ctx.assignable(1), leftType.getIdentifier(), rightType.getIdentifier());
			return Suit.ERROR;
		}

		return Suit.VOID;
	}

	/**
	 * Handles the context checking of a universal-equals-to-expression.
	 * 
	 * A universal-equals-to-expression is confined to the following context rules:
	 * 
	 * <br>
	 * <br>
	 * <ol>
	 * <li>both operands must be of the same type;
	 * <li>the expression yields a value of type <i>boolean</i>;
	 * <li>the expression yields a constant value if both operands are constant.
	 * </ol>
	 * 
	 * @param ctx
	 *            The context object associated with the parse tree node of this universal-equals-to-expression.
	 * @return The suit of the universal-equals-to-expression or {@link Suit#ERROR} in case of a context error.
	 */
	public Suit visitUniversalEqualsToExpression(UniversalEqualsToExpressionContext ctx) {

		Suit leftSuit = visit(ctx.expression(0));
		Suit rightSuit = visit(ctx.expression(1));

		if (!leftSuit.type.equals(rightSuit.type)) {
			this.reportError("a=b only works if a and b are the same type", ctx.expression(0), rightSuit.type.toString(), leftSuit.type.toString());
			return Suit.ERROR;
		}

		boolean bothConstant = leftSuit.isConstant && rightSuit.isConstant;
		return new Suit(BOOLEAN, bothConstant);
	}

	/**
	 * Handles the context checking of a universal-not-equals-to-expression.
	 * 
	 * A universal-not-equals-to-expression is confined to the following context rules:
	 * 
	 * <br>
	 * <br>
	 * <ol>
	 * <li>both operands must be of the same type;
	 * <li>the expression yields a value of type <i>boolean</i>;
	 * <li>the expression yields a constant value if both operands are constant.
	 * </ol>
	 * 
	 * @param ctx
	 *            The context object associated with the parse tree node of this universal-not-equals-to-expression.
	 * @return The suit of the universal-not-equals-to-expression or {@link Suit#ERROR} in case of a context error.
	 */
	@Override
	public Suit visitUniversalNotEqualsToExpression(UniversalNotEqualsToExpressionContext ctx) {

		Suit leftSuit = visit(ctx.expression(0));
		Suit rightSuit = visit(ctx.expression(1));

		if (!leftSuit.type.equals(rightSuit.type)) {
			this.reportError("a=/=b only works if a and b are the same type", ctx.expression(0), rightSuit.type.toString(), leftSuit.type.toString());
			return Suit.ERROR;
		}

		boolean bothConstant = leftSuit.isConstant && rightSuit.isConstant;
		return new Suit(BOOLEAN, bothConstant);
	}

	/**
	 * Handles the context checking of a while-structure.
	 * 
	 * Checks if the condition-expression yields a <i>boolean</i> value and then calls the visit-method of the block-structure.
	 * 
	 * @param ctx
	 *            The context object associated with the parse tree node of this while-structure.
	 * @return A while-structure has no return suit, so returns a meaningless {@link Suit#VOID}.
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
}
