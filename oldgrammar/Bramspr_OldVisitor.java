// Generated from C:\Users\Jasper\eclipse_workspace\Bramspr\src\Bramspr_Old.g4 by ANTLR 4.1
package oldgrammar;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link Bramspr_OldParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface Bramspr_OldVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link Bramspr_OldParser#parenthesisExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthesisExpression(@NotNull Bramspr_OldParser.ParenthesisExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link Bramspr_OldParser#arrayLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayLiteral(@NotNull Bramspr_OldParser.ArrayLiteralContext ctx);

	/**
	 * Visit a parse tree produced by {@link Bramspr_OldParser#additionExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditionExpression(@NotNull Bramspr_OldParser.AdditionExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link Bramspr_OldParser#pureDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPureDeclaration(@NotNull Bramspr_OldParser.PureDeclarationContext ctx);

	/**
	 * Visit a parse tree produced by {@link Bramspr_OldParser#stringLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringLiteral(@NotNull Bramspr_OldParser.StringLiteralContext ctx);

	/**
	 * Visit a parse tree produced by {@link Bramspr_OldParser#powerExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPowerExpression(@NotNull Bramspr_OldParser.PowerExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link Bramspr_OldParser#orExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrExpression(@NotNull Bramspr_OldParser.OrExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link Bramspr_OldParser#whileStructure}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStructure(@NotNull Bramspr_OldParser.WhileStructureContext ctx);

	/**
	 * Visit a parse tree produced by {@link Bramspr_OldParser#notEqualsToExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotEqualsToExpression(@NotNull Bramspr_OldParser.NotEqualsToExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link Bramspr_OldParser#numberLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberLiteral(@NotNull Bramspr_OldParser.NumberLiteralContext ctx);

	/**
	 * Visit a parse tree produced by {@link Bramspr_OldParser#andExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndExpression(@NotNull Bramspr_OldParser.AndExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link Bramspr_OldParser#functionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCall(@NotNull Bramspr_OldParser.FunctionCallContext ctx);

	/**
	 * Visit a parse tree produced by {@link Bramspr_OldParser#signExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSignExpression(@NotNull Bramspr_OldParser.SignExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link Bramspr_OldParser#basicAssignable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBasicAssignable(@NotNull Bramspr_OldParser.BasicAssignableContext ctx);

	/**
	 * Visit a parse tree produced by {@link Bramspr_OldParser#equalsToExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualsToExpression(@NotNull Bramspr_OldParser.EqualsToExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link Bramspr_OldParser#greaterThanExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGreaterThanExpression(@NotNull Bramspr_OldParser.GreaterThanExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link Bramspr_OldParser#smallerThanExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSmallerThanExpression(@NotNull Bramspr_OldParser.SmallerThanExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link Bramspr_OldParser#arrayAccessOnAssignable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayAccessOnAssignable(@NotNull Bramspr_OldParser.ArrayAccessOnAssignableContext ctx);

	/**
	 * Visit a parse tree produced by {@link Bramspr_OldParser#multiplicationExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicationExpression(@NotNull Bramspr_OldParser.MultiplicationExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link Bramspr_OldParser#enumerationDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumerationDeclaration(@NotNull Bramspr_OldParser.EnumerationDeclarationContext ctx);

	/**
	 * Visit a parse tree produced by {@link Bramspr_OldParser#plusMinusExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlusMinusExpression(@NotNull Bramspr_OldParser.PlusMinusExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link Bramspr_OldParser#structure}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructure(@NotNull Bramspr_OldParser.StructureContext ctx);

	/**
	 * Visit a parse tree produced by {@link Bramspr_OldParser#greaterThanEqualsToExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGreaterThanEqualsToExpression(@NotNull Bramspr_OldParser.GreaterThanEqualsToExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link Bramspr_OldParser#literalExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteralExpression(@NotNull Bramspr_OldParser.LiteralExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link Bramspr_OldParser#fieldAccessOnAssignable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldAccessOnAssignable(@NotNull Bramspr_OldParser.FieldAccessOnAssignableContext ctx);

	/**
	 * Visit a parse tree produced by {@link Bramspr_OldParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(@NotNull Bramspr_OldParser.DeclarationContext ctx);

	/**
	 * Visit a parse tree produced by {@link Bramspr_OldParser#baseTypeDenoter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBaseTypeDenoter(@NotNull Bramspr_OldParser.BaseTypeDenoterContext ctx);

	/**
	 * Visit a parse tree produced by {@link Bramspr_OldParser#assignmentExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentExpression(@NotNull Bramspr_OldParser.AssignmentExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link Bramspr_OldParser#atomicExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomicExpression(@NotNull Bramspr_OldParser.AtomicExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link Bramspr_OldParser#notExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotExpression(@NotNull Bramspr_OldParser.NotExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link Bramspr_OldParser#booleanLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanLiteral(@NotNull Bramspr_OldParser.BooleanLiteralContext ctx);

	/**
	 * Visit a parse tree produced by {@link Bramspr_OldParser#smallerThanEqualsToExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSmallerThanEqualsToExpression(@NotNull Bramspr_OldParser.SmallerThanEqualsToExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link Bramspr_OldParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(@NotNull Bramspr_OldParser.StatementContext ctx);

	/**
	 * Visit a parse tree produced by {@link Bramspr_OldParser#explicitEnumerationExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExplicitEnumerationExpression(@NotNull Bramspr_OldParser.ExplicitEnumerationExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link Bramspr_OldParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(@NotNull Bramspr_OldParser.AssignmentContext ctx);

	/**
	 * Visit a parse tree produced by {@link Bramspr_OldParser#arithmeticExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArithmeticExpression(@NotNull Bramspr_OldParser.ArithmeticExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link Bramspr_OldParser#assignableExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignableExpression(@NotNull Bramspr_OldParser.AssignableExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link Bramspr_OldParser#compositeDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompositeDeclaration(@NotNull Bramspr_OldParser.CompositeDeclarationContext ctx);

	/**
	 * Visit a parse tree produced by {@link Bramspr_OldParser#characterLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharacterLiteral(@NotNull Bramspr_OldParser.CharacterLiteralContext ctx);

	/**
	 * Visit a parse tree produced by {@link Bramspr_OldParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(@NotNull Bramspr_OldParser.ProgramContext ctx);

	/**
	 * Visit a parse tree produced by {@link Bramspr_OldParser#ifStructure}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStructure(@NotNull Bramspr_OldParser.IfStructureContext ctx);

	/**
	 * Visit a parse tree produced by {@link Bramspr_OldParser#instantiatingDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstantiatingDeclaration(@NotNull Bramspr_OldParser.InstantiatingDeclarationContext ctx);

	/**
	 * Visit a parse tree produced by {@link Bramspr_OldParser#arrayTypeDenoter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayTypeDenoter(@NotNull Bramspr_OldParser.ArrayTypeDenoterContext ctx);

	/**
	 * Visit a parse tree produced by {@link Bramspr_OldParser#functionCallExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCallExpression(@NotNull Bramspr_OldParser.FunctionCallExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link Bramspr_OldParser#compositeLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompositeLiteral(@NotNull Bramspr_OldParser.CompositeLiteralContext ctx);

	/**
	 * Visit a parse tree produced by {@link Bramspr_OldParser#functionDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDeclaration(@NotNull Bramspr_OldParser.FunctionDeclarationContext ctx);

	/**
	 * Visit a parse tree produced by {@link Bramspr_OldParser#swap}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwap(@NotNull Bramspr_OldParser.SwapContext ctx);

	/**
	 * Visit a parse tree produced by {@link Bramspr_OldParser#blockStructure}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockStructure(@NotNull Bramspr_OldParser.BlockStructureContext ctx);
}