// Generated from D:\studie\Compilerbouw\bramspr\bramspr\src\Bramspr.g4 by ANTLR 4.1
package bramspr;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link BramsprParser}.
 */
public interface BramsprListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link BramsprParser#parenthesisExpression}.
	 * @param ctx the parse tree
	 */
	void enterParenthesisExpression(@NotNull BramsprParser.ParenthesisExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BramsprParser#parenthesisExpression}.
	 * @param ctx the parse tree
	 */
	void exitParenthesisExpression(@NotNull BramsprParser.ParenthesisExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link BramsprParser#arrayLiteral}.
	 * @param ctx the parse tree
	 */
	void enterArrayLiteral(@NotNull BramsprParser.ArrayLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link BramsprParser#arrayLiteral}.
	 * @param ctx the parse tree
	 */
	void exitArrayLiteral(@NotNull BramsprParser.ArrayLiteralContext ctx);

	/**
	 * Enter a parse tree produced by {@link BramsprParser#pureDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterPureDeclaration(@NotNull BramsprParser.PureVariableDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link BramsprParser#pureDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitPureDeclaration(@NotNull BramsprParser.PureVariableDeclarationContext ctx);

	/**
	 * Enter a parse tree produced by {@link BramsprParser#additionExpression}.
	 * @param ctx the parse tree
	 */
	void enterAdditionExpression(@NotNull BramsprParser.AdditionExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BramsprParser#additionExpression}.
	 * @param ctx the parse tree
	 */
	void exitAdditionExpression(@NotNull BramsprParser.AdditionExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link BramsprParser#stringLiteral}.
	 * @param ctx the parse tree
	 */
	void enterStringLiteral(@NotNull BramsprParser.StringLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link BramsprParser#stringLiteral}.
	 * @param ctx the parse tree
	 */
	void exitStringLiteral(@NotNull BramsprParser.StringLiteralContext ctx);

	/**
	 * Enter a parse tree produced by {@link BramsprParser#notEqualsToExpression}.
	 * @param ctx the parse tree
	 */
	void enterNotEqualsToExpression(@NotNull BramsprParser.NotEqualsToExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BramsprParser#notEqualsToExpression}.
	 * @param ctx the parse tree
	 */
	void exitNotEqualsToExpression(@NotNull BramsprParser.NotEqualsToExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link BramsprParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCall(@NotNull BramsprParser.FunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link BramsprParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCall(@NotNull BramsprParser.FunctionCallContext ctx);

	/**
	 * Enter a parse tree produced by {@link BramsprParser#arrayAccessExpression}.
	 * @param ctx the parse tree
	 */
	void enterArrayAccessExpression(@NotNull BramsprParser.ArrayAccessContext ctx);
	/**
	 * Exit a parse tree produced by {@link BramsprParser#arrayAccessExpression}.
	 * @param ctx the parse tree
	 */
	void exitArrayAccessExpression(@NotNull BramsprParser.ArrayAccessContext ctx);

	/**
	 * Enter a parse tree produced by {@link BramsprParser#greaterThanExpression}.
	 * @param ctx the parse tree
	 */
	void enterGreaterThanExpression(@NotNull BramsprParser.GreaterThanExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BramsprParser#greaterThanExpression}.
	 * @param ctx the parse tree
	 */
	void exitGreaterThanExpression(@NotNull BramsprParser.GreaterThanExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link BramsprParser#multiplicationExpression}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicationExpression(@NotNull BramsprParser.MultiplicationExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BramsprParser#multiplicationExpression}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicationExpression(@NotNull BramsprParser.MultiplicationExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link BramsprParser#greaterThanEqualsToExpression}.
	 * @param ctx the parse tree
	 */
	void enterGreaterThanEqualsToExpression(@NotNull BramsprParser.GreaterThanEqualsToExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BramsprParser#greaterThanEqualsToExpression}.
	 * @param ctx the parse tree
	 */
	void exitGreaterThanEqualsToExpression(@NotNull BramsprParser.GreaterThanEqualsToExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link BramsprParser#structure}.
	 * @param ctx the parse tree
	 */
	void enterStructure(@NotNull BramsprParser.StructureContext ctx);
	/**
	 * Exit a parse tree produced by {@link BramsprParser#structure}.
	 * @param ctx the parse tree
	 */
	void exitStructure(@NotNull BramsprParser.StructureContext ctx);

	/**
	 * Enter a parse tree produced by {@link BramsprParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(@NotNull BramsprParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link BramsprParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(@NotNull BramsprParser.DeclarationContext ctx);

	/**
	 * Enter a parse tree produced by {@link BramsprParser#moleculeExpression}.
	 * @param ctx the parse tree
	 */
	void enterMoleculeExpression(@NotNull BramsprParser.MoleculeExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BramsprParser#moleculeExpression}.
	 * @param ctx the parse tree
	 */
	void exitMoleculeExpression(@NotNull BramsprParser.MoleculeExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link BramsprParser#baseTypeDenoter}.
	 * @param ctx the parse tree
	 */
	void enterBaseTypeDenoter(@NotNull BramsprParser.BaseTypeDenoterContext ctx);
	/**
	 * Exit a parse tree produced by {@link BramsprParser#baseTypeDenoter}.
	 * @param ctx the parse tree
	 */
	void exitBaseTypeDenoter(@NotNull BramsprParser.BaseTypeDenoterContext ctx);

	/**
	 * Enter a parse tree produced by {@link BramsprParser#assignmentExpression}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentExpression(@NotNull BramsprParser.AssignmentExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BramsprParser#assignmentExpression}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentExpression(@NotNull BramsprParser.AssignmentExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link BramsprParser#notExpression}.
	 * @param ctx the parse tree
	 */
	void enterNotExpression(@NotNull BramsprParser.NotExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BramsprParser#notExpression}.
	 * @param ctx the parse tree
	 */
	void exitNotExpression(@NotNull BramsprParser.NotExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link BramsprParser#smallerThanEqualsToExpression}.
	 * @param ctx the parse tree
	 */
	void enterSmallerThanEqualsToExpression(@NotNull BramsprParser.SmallerThanEqualsToExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BramsprParser#smallerThanEqualsToExpression}.
	 * @param ctx the parse tree
	 */
	void exitSmallerThanEqualsToExpression(@NotNull BramsprParser.SmallerThanEqualsToExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link BramsprParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(@NotNull BramsprParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link BramsprParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(@NotNull BramsprParser.StatementContext ctx);

	/**
	 * Enter a parse tree produced by {@link BramsprParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(@NotNull BramsprParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link BramsprParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(@NotNull BramsprParser.ProgramContext ctx);

	/**
	 * Enter a parse tree produced by {@link BramsprParser#ifStructure}.
	 * @param ctx the parse tree
	 */
	void enterIfStructure(@NotNull BramsprParser.IfStructureContext ctx);
	/**
	 * Exit a parse tree produced by {@link BramsprParser#ifStructure}.
	 * @param ctx the parse tree
	 */
	void exitIfStructure(@NotNull BramsprParser.IfStructureContext ctx);

	/**
	 * Enter a parse tree produced by {@link BramsprParser#instantiatingDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterInstantiatingDeclaration(@NotNull BramsprParser.InstantiatingVariableDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link BramsprParser#instantiatingDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitInstantiatingDeclaration(@NotNull BramsprParser.InstantiatingVariableDeclarationContext ctx);

	/**
	 * Enter a parse tree produced by {@link BramsprParser#universalNotEqualsToExpression}.
	 * @param ctx the parse tree
	 */
	void enterUniversalNotEqualsToExpression(@NotNull BramsprParser.UniversalNotEqualsToExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BramsprParser#universalNotEqualsToExpression}.
	 * @param ctx the parse tree
	 */
	void exitUniversalNotEqualsToExpression(@NotNull BramsprParser.UniversalNotEqualsToExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link BramsprParser#functionCallExpression}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCallExpression(@NotNull BramsprParser.FunctionCallExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BramsprParser#functionCallExpression}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCallExpression(@NotNull BramsprParser.FunctionCallExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link BramsprParser#accessOnAssignableExpression}.
	 * @param ctx the parse tree
	 */
	void enterAccessOnAssignableExpression(@NotNull BramsprParser.AccessOnAssignableContext ctx);
	/**
	 * Exit a parse tree produced by {@link BramsprParser#accessOnAssignableExpression}.
	 * @param ctx the parse tree
	 */
	void exitAccessOnAssignableExpression(@NotNull BramsprParser.AccessOnAssignableContext ctx);

	/**
	 * Enter a parse tree produced by {@link BramsprParser#compositeLiteral}.
	 * @param ctx the parse tree
	 */
	void enterCompositeLiteral(@NotNull BramsprParser.CompositeLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link BramsprParser#compositeLiteral}.
	 * @param ctx the parse tree
	 */
	void exitCompositeLiteral(@NotNull BramsprParser.CompositeLiteralContext ctx);

	/**
	 * Enter a parse tree produced by {@link BramsprParser#fieldAccessExpression}.
	 * @param ctx the parse tree
	 */
	void enterFieldAccessExpression(@NotNull BramsprParser.FieldAccessContext ctx);
	/**
	 * Exit a parse tree produced by {@link BramsprParser#fieldAccessExpression}.
	 * @param ctx the parse tree
	 */
	void exitFieldAccessExpression(@NotNull BramsprParser.FieldAccessContext ctx);

	/**
	 * Enter a parse tree produced by {@link BramsprParser#universalEqualsToExpression}.
	 * @param ctx the parse tree
	 */
	void enterUniversalEqualsToExpression(@NotNull BramsprParser.UniversalEqualsToExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BramsprParser#universalEqualsToExpression}.
	 * @param ctx the parse tree
	 */
	void exitUniversalEqualsToExpression(@NotNull BramsprParser.UniversalEqualsToExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link BramsprParser#orExpression}.
	 * @param ctx the parse tree
	 */
	void enterOrExpression(@NotNull BramsprParser.OrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BramsprParser#orExpression}.
	 * @param ctx the parse tree
	 */
	void exitOrExpression(@NotNull BramsprParser.OrExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link BramsprParser#powerExpression}.
	 * @param ctx the parse tree
	 */
	void enterPowerExpression(@NotNull BramsprParser.PowerExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BramsprParser#powerExpression}.
	 * @param ctx the parse tree
	 */
	void exitPowerExpression(@NotNull BramsprParser.PowerExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link BramsprParser#whileStructure}.
	 * @param ctx the parse tree
	 */
	void enterWhileStructure(@NotNull BramsprParser.WhileStructureContext ctx);
	/**
	 * Exit a parse tree produced by {@link BramsprParser#whileStructure}.
	 * @param ctx the parse tree
	 */
	void exitWhileStructure(@NotNull BramsprParser.WhileStructureContext ctx);

	/**
	 * Enter a parse tree produced by {@link BramsprParser#numberLiteral}.
	 * @param ctx the parse tree
	 */
	void enterNumberLiteral(@NotNull BramsprParser.IntegerLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link BramsprParser#numberLiteral}.
	 * @param ctx the parse tree
	 */
	void exitNumberLiteral(@NotNull BramsprParser.IntegerLiteralContext ctx);

	/**
	 * Enter a parse tree produced by {@link BramsprParser#andExpression}.
	 * @param ctx the parse tree
	 */
	void enterAndExpression(@NotNull BramsprParser.AndExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BramsprParser#andExpression}.
	 * @param ctx the parse tree
	 */
	void exitAndExpression(@NotNull BramsprParser.AndExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link BramsprParser#signExpression}.
	 * @param ctx the parse tree
	 */
	void enterSignExpression(@NotNull BramsprParser.SignExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BramsprParser#signExpression}.
	 * @param ctx the parse tree
	 */
	void exitSignExpression(@NotNull BramsprParser.SignExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link BramsprParser#equalsToExpression}.
	 * @param ctx the parse tree
	 */
	void enterEqualsToExpression(@NotNull BramsprParser.EqualsToExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BramsprParser#equalsToExpression}.
	 * @param ctx the parse tree
	 */
	void exitEqualsToExpression(@NotNull BramsprParser.EqualsToExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link BramsprParser#basicAssignable}.
	 * @param ctx the parse tree
	 */
	void enterBasicAssignable(@NotNull BramsprParser.BasicAssignableContext ctx);
	/**
	 * Exit a parse tree produced by {@link BramsprParser#basicAssignable}.
	 * @param ctx the parse tree
	 */
	void exitBasicAssignable(@NotNull BramsprParser.BasicAssignableContext ctx);

	/**
	 * Enter a parse tree produced by {@link BramsprParser#smallerThanExpression}.
	 * @param ctx the parse tree
	 */
	void enterSmallerThanExpression(@NotNull BramsprParser.SmallerThanExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BramsprParser#smallerThanExpression}.
	 * @param ctx the parse tree
	 */
	void exitSmallerThanExpression(@NotNull BramsprParser.SmallerThanExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link BramsprParser#enumerationDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterEnumerationDeclaration(@NotNull BramsprParser.EnumerationDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link BramsprParser#enumerationDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitEnumerationDeclaration(@NotNull BramsprParser.EnumerationDeclarationContext ctx);

	/**
	 * Enter a parse tree produced by {@link BramsprParser#plusMinusExpression}.
	 * @param ctx the parse tree
	 */
	void enterPlusMinusExpression(@NotNull BramsprParser.PlusMinusExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BramsprParser#plusMinusExpression}.
	 * @param ctx the parse tree
	 */
	void exitPlusMinusExpression(@NotNull BramsprParser.PlusMinusExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link BramsprParser#potentialEnumerationLiteral}.
	 * @param ctx the parse tree
	 */
	void enterPotentialEnumerationLiteral(@NotNull BramsprParser.PotentialEnumerationLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link BramsprParser#potentialEnumerationLiteral}.
	 * @param ctx the parse tree
	 */
	void exitPotentialEnumerationLiteral(@NotNull BramsprParser.PotentialEnumerationLiteralContext ctx);

	/**
	 * Enter a parse tree produced by {@link BramsprParser#explicitEnumerationLiteral}.
	 * @param ctx the parse tree
	 */
	void enterExplicitEnumerationLiteral(@NotNull BramsprParser.ExplicitEnumerationLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link BramsprParser#explicitEnumerationLiteral}.
	 * @param ctx the parse tree
	 */
	void exitExplicitEnumerationLiteral(@NotNull BramsprParser.ExplicitEnumerationLiteralContext ctx);

	/**
	 * Enter a parse tree produced by {@link BramsprParser#literalExpression}.
	 * @param ctx the parse tree
	 */
	void enterLiteralExpression(@NotNull BramsprParser.LiteralExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BramsprParser#literalExpression}.
	 * @param ctx the parse tree
	 */
	void exitLiteralExpression(@NotNull BramsprParser.LiteralExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link BramsprParser#atomicExpression}.
	 * @param ctx the parse tree
	 */
	void enterAtomicExpression(@NotNull BramsprParser.AtomicExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BramsprParser#atomicExpression}.
	 * @param ctx the parse tree
	 */
	void exitAtomicExpression(@NotNull BramsprParser.AtomicExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link BramsprParser#enumeratedTypeDenoter}.
	 * @param ctx the parse tree
	 */
	void enterEnumeratedTypeDenoter(@NotNull BramsprParser.EnumeratedTypeDenoterContext ctx);
	/**
	 * Exit a parse tree produced by {@link BramsprParser#enumeratedTypeDenoter}.
	 * @param ctx the parse tree
	 */
	void exitEnumeratedTypeDenoter(@NotNull BramsprParser.EnumeratedTypeDenoterContext ctx);

	/**
	 * Enter a parse tree produced by {@link BramsprParser#booleanLiteral}.
	 * @param ctx the parse tree
	 */
	void enterBooleanLiteral(@NotNull BramsprParser.BooleanLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link BramsprParser#booleanLiteral}.
	 * @param ctx the parse tree
	 */
	void exitBooleanLiteral(@NotNull BramsprParser.BooleanLiteralContext ctx);

	/**
	 * Enter a parse tree produced by {@link BramsprParser#arithmeticExpression}.
	 * @param ctx the parse tree
	 */
	void enterArithmeticExpression(@NotNull BramsprParser.ArithmeticExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BramsprParser#arithmeticExpression}.
	 * @param ctx the parse tree
	 */
	void exitArithmeticExpression(@NotNull BramsprParser.ArithmeticExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link BramsprParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(@NotNull BramsprParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link BramsprParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(@NotNull BramsprParser.AssignmentContext ctx);

	/**
	 * Enter a parse tree produced by {@link BramsprParser#compositeDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterCompositeDeclaration(@NotNull BramsprParser.CompositeDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link BramsprParser#compositeDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitCompositeDeclaration(@NotNull BramsprParser.CompositeDeclarationContext ctx);

	/**
	 * Enter a parse tree produced by {@link BramsprParser#assignableExpression}.
	 * @param ctx the parse tree
	 */
	void enterAssignableExpression(@NotNull BramsprParser.AssignableExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BramsprParser#assignableExpression}.
	 * @param ctx the parse tree
	 */
	void exitAssignableExpression(@NotNull BramsprParser.AssignableExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link BramsprParser#characterLiteral}.
	 * @param ctx the parse tree
	 */
	void enterCharacterLiteral(@NotNull BramsprParser.CharacterLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link BramsprParser#characterLiteral}.
	 * @param ctx the parse tree
	 */
	void exitCharacterLiteral(@NotNull BramsprParser.CharacterLiteralContext ctx);

	/**
	 * Enter a parse tree produced by {@link BramsprParser#arrayTypeDenoter}.
	 * @param ctx the parse tree
	 */
	void enterArrayTypeDenoter(@NotNull BramsprParser.ArrayTypeDenoterContext ctx);
	/**
	 * Exit a parse tree produced by {@link BramsprParser#arrayTypeDenoter}.
	 * @param ctx the parse tree
	 */
	void exitArrayTypeDenoter(@NotNull BramsprParser.ArrayTypeDenoterContext ctx);

	/**
	 * Enter a parse tree produced by {@link BramsprParser#accessOnAtomicExpression}.
	 * @param ctx the parse tree
	 */
	void enterAccessOnAtomicExpression(@NotNull BramsprParser.AccessOnAtomicExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BramsprParser#accessOnAtomicExpression}.
	 * @param ctx the parse tree
	 */
	void exitAccessOnAtomicExpression(@NotNull BramsprParser.AccessOnAtomicExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link BramsprParser#swap}.
	 * @param ctx the parse tree
	 */
	void enterSwap(@NotNull BramsprParser.SwapContext ctx);
	/**
	 * Exit a parse tree produced by {@link BramsprParser#swap}.
	 * @param ctx the parse tree
	 */
	void exitSwap(@NotNull BramsprParser.SwapContext ctx);

	/**
	 * Enter a parse tree produced by {@link BramsprParser#functionDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDeclaration(@NotNull BramsprParser.FunctionDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link BramsprParser#functionDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDeclaration(@NotNull BramsprParser.FunctionDeclarationContext ctx);

	/**
	 * Enter a parse tree produced by {@link BramsprParser#blockStructure}.
	 * @param ctx the parse tree
	 */
	void enterBlockStructure(@NotNull BramsprParser.BlockStructureContext ctx);
	/**
	 * Exit a parse tree produced by {@link BramsprParser#blockStructure}.
	 * @param ctx the parse tree
	 */
	void exitBlockStructure(@NotNull BramsprParser.BlockStructureContext ctx);
}