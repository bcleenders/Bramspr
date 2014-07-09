// Generated from D:\studie\Compilerbouw\bramspr\bramspr\src\Bramspr.g4 by ANTLR 4.1
package bramspr;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link BramsprParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface BramsprVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link BramsprParser#parenthesisExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthesisExpression(@NotNull BramsprParser.ParenthesisExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParser#arrayLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayLiteral(@NotNull BramsprParser.ArrayLiteralContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParser#fieldAccess}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldAccess(@NotNull BramsprParser.FieldAccessContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParser#additionExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditionExpression(@NotNull BramsprParser.AdditionExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParser#stringLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringLiteral(@NotNull BramsprParser.StringLiteralContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParser#notEqualsToExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotEqualsToExpression(@NotNull BramsprParser.NotEqualsToExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParser#functionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCall(@NotNull BramsprParser.FunctionCallContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParser#greaterThanExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGreaterThanExpression(@NotNull BramsprParser.GreaterThanExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParser#multiplicationExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicationExpression(@NotNull BramsprParser.MultiplicationExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParser#greaterThanEqualsToExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGreaterThanEqualsToExpression(@NotNull BramsprParser.GreaterThanEqualsToExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParser#structure}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructure(@NotNull BramsprParser.StructureContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(@NotNull BramsprParser.DeclarationContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParser#moleculeExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMoleculeExpression(@NotNull BramsprParser.MoleculeExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParser#baseTypeDenoter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBaseTypeDenoter(@NotNull BramsprParser.BaseTypeDenoterContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParser#assignmentExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentExpression(@NotNull BramsprParser.AssignmentExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParser#notExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotExpression(@NotNull BramsprParser.NotExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParser#smallerThanEqualsToExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSmallerThanEqualsToExpression(@NotNull BramsprParser.SmallerThanEqualsToExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(@NotNull BramsprParser.StatementContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParser#accessOnAssignable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAccessOnAssignable(@NotNull BramsprParser.AccessOnAssignableContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParser#arrayAccess}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayAccess(@NotNull BramsprParser.ArrayAccessContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(@NotNull BramsprParser.ProgramContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParser#ifStructure}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStructure(@NotNull BramsprParser.IfStructureContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParser#universalNotEqualsToExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUniversalNotEqualsToExpression(@NotNull BramsprParser.UniversalNotEqualsToExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParser#functionCallExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCallExpression(@NotNull BramsprParser.FunctionCallExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParser#compositeLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompositeLiteral(@NotNull BramsprParser.CompositeLiteralContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParser#universalEqualsToExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUniversalEqualsToExpression(@NotNull BramsprParser.UniversalEqualsToExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParser#orExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrExpression(@NotNull BramsprParser.OrExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParser#powerExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPowerExpression(@NotNull BramsprParser.PowerExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParser#pureVariableDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPureVariableDeclaration(@NotNull BramsprParser.PureVariableDeclarationContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParser#integerLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntegerLiteral(@NotNull BramsprParser.IntegerLiteralContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParser#whileStructure}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStructure(@NotNull BramsprParser.WhileStructureContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParser#andExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndExpression(@NotNull BramsprParser.AndExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParser#signExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSignExpression(@NotNull BramsprParser.SignExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParser#equalsToExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualsToExpression(@NotNull BramsprParser.EqualsToExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParser#basicAssignable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBasicAssignable(@NotNull BramsprParser.BasicAssignableContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParser#smallerThanExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSmallerThanExpression(@NotNull BramsprParser.SmallerThanExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParser#command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommand(@NotNull BramsprParser.CommandContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParser#enumerationDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumerationDeclaration(@NotNull BramsprParser.EnumerationDeclarationContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParser#plusMinusExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlusMinusExpression(@NotNull BramsprParser.PlusMinusExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParser#potentialEnumerationLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPotentialEnumerationLiteral(@NotNull BramsprParser.PotentialEnumerationLiteralContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParser#explicitEnumerationLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExplicitEnumerationLiteral(@NotNull BramsprParser.ExplicitEnumerationLiteralContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParser#literalExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteralExpression(@NotNull BramsprParser.LiteralExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParser#atomicExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomicExpression(@NotNull BramsprParser.AtomicExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParser#instantiatingVariableDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstantiatingVariableDeclaration(@NotNull BramsprParser.InstantiatingVariableDeclarationContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParser#enumeratedTypeDenoter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumeratedTypeDenoter(@NotNull BramsprParser.EnumeratedTypeDenoterContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParser#booleanLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanLiteral(@NotNull BramsprParser.BooleanLiteralContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParser#arithmeticExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArithmeticExpression(@NotNull BramsprParser.ArithmeticExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(@NotNull BramsprParser.AssignmentContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParser#compositeDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompositeDeclaration(@NotNull BramsprParser.CompositeDeclarationContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParser#assignableExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignableExpression(@NotNull BramsprParser.AssignableExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParser#characterLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharacterLiteral(@NotNull BramsprParser.CharacterLiteralContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParser#arrayTypeDenoter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayTypeDenoter(@NotNull BramsprParser.ArrayTypeDenoterContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParser#accessOnAtomicExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAccessOnAtomicExpression(@NotNull BramsprParser.AccessOnAtomicExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParser#swap}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwap(@NotNull BramsprParser.SwapContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParser#functionDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDeclaration(@NotNull BramsprParser.FunctionDeclarationContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParser#blockStructure}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockStructure(@NotNull BramsprParser.BlockStructureContext ctx);
}