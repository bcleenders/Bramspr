package bramspr;

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
import bramspr.BramsprParser.LiteralContext;
import bramspr.BramsprParser.LiteralExpressionContext;
import bramspr.BramsprParser.MultiplicationExpressionContext;
import bramspr.BramsprParser.NotEqualsToExpressionContext;
import bramspr.BramsprParser.NotExpressionContext;
import bramspr.BramsprParser.ParenthesisExpressionContext;
import bramspr.BramsprParser.PlusMinusExpressionContext;
import bramspr.BramsprParser.PowerExpressionContext;
import bramspr.BramsprParser.ProgramContext;
import bramspr.BramsprParser.SignExpressionContext;
import bramspr.BramsprParser.SmallerThanEqualsToExpressionContext;
import bramspr.BramsprParser.SmallerThanExpressionContext;
import bramspr.BramsprParser.StatementContext;
import bramspr.BramsprParser.StructureContext;
import bramspr.BramsprParser.SwapContext;
import bramspr.BramsprParser.TypeDeclarationContext;
import bramspr.BramsprParser.VariableDeclarationContext;
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
			if(! firstElementSuit.type.equals(currElementSuit.type)) {
				this.reportError("attempted to enter different types in array literal: use records for that!", ctx.expression(i), firstElementSuit.type.getIdentifier(),
						currElementSuit.type.getIdentifier());
			}
			
			// Check if it is still a constant array
			allConstant = allConstant && currElementSuit.isConstantExpression;
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

		boolean isConstant = leftExpression.isConstantExpression && rightExpression.isConstantExpression;
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
			fieldNames[i] = ctx.IDENTIFIER(i+1).getText();
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
	public Suit visitVariableDeclaration(VariableDeclarationContext ctx) {
//		boolean isFinal = (ctx.FINAL() != null);
		// TODO deze functie afmaken!
		return null;
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
	public Suit visitLiteralExpression(LiteralExpressionContext ctx) {
		// TODO Auto-generated method stub
		return super.visitChildren(ctx);
	}

	@Override
	public Suit visitDeclaration(DeclarationContext ctx) {
		// TODO Auto-generated method stub
		return super.visitChildren(ctx);
	}

	@Override
	public Suit visitBaseTypeDenoter(BaseTypeDenoterContext ctx) {
		// TODO Auto-generated method stub
		return super.visitChildren(ctx);
	}

	@Override
	public Suit visitAssignmentExpression(AssignmentExpressionContext ctx) {
		// TODO Auto-generated method stub
		return super.visitChildren(ctx);
	}

	@Override
	public Suit visitIdentifierExpression(IdentifierExpressionContext ctx) {
		VariableSymbol variable = this.variableSymbolTable.resolve(ctx.IDENTIFIER().getText());
		
		if(variable == null) {
			this.reportError("reference to non-existing variable '" + ctx.IDENTIFIER().getText() + "'.", ctx);
			return Suit.ERROR;
		}
		
		return new Suit(variable.getReturnType(), variable.isFinal());
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
	public Suit visitArithmeticExpression(ArithmeticExpressionContext ctx) {
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
		// TODO Auto-generated method stub
		return super.visitChildren(ctx);
	}

	@Override
	public Suit visitFunctionCallExpression(FunctionCallExpressionContext ctx) {
		// TODO Auto-generated method stub
		return super.visitChildren(ctx);
	}

	@Override
	public Suit visitCompositeLiteral(CompositeLiteralContext ctx) {
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
			VariableSymbol parameter = new VariableSymbol(ctx.IDENTIFIER(i+1).getText(), argumentTypes[i], false);
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
		
		if(!rightType.equals(leftType)) {
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
	
	@Override
	public Suit visitLiteral(LiteralContext ctx) {
		// TODO Auto-generated method stub
		return super.visitChildren(ctx);
	}
	
	/*
	 * Vanaf hier alleen de nutteloze functies die door de super al worden afgehandeld (verwijderen voor testen)
	 */
}
