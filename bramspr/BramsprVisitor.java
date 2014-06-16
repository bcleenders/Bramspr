// Generated from C:\Users\Jasper\eclipse_workspace\Bramspr\src\Bramspr.g4 by ANTLR 4.1
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
	 * Visit a parse tree produced by {@link BramsprParser#assignable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignable(@NotNull BramsprParser.AssignableContext ctx);

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
	 * Visit a parse tree produced by {@link BramsprParser#fieldAccess}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldAccess(@NotNull BramsprParser.FieldAccessContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParser#atomicExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomicExpression(@NotNull BramsprParser.AtomicExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParser#additionExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditionExpression(@NotNull BramsprParser.AdditionExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParser#notExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotExpression(@NotNull BramsprParser.NotExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParser#powerExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPowerExpression(@NotNull BramsprParser.PowerExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParser#notEqualsToExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotEqualsToExpression(@NotNull BramsprParser.NotEqualsToExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParser#whileStructure}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStructure(@NotNull BramsprParser.WhileStructureContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParser#atomic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomic(@NotNull BramsprParser.AtomicContext ctx);

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
	 * Visit a parse tree produced by {@link BramsprParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(@NotNull BramsprParser.AssignmentContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParser#arithmeticExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArithmeticExpression(@NotNull BramsprParser.ArithmeticExpressionContext ctx);

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
	 * Visit a parse tree produced by {@link BramsprParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(@NotNull BramsprParser.ProgramContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParser#greaterThanExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGreaterThanExpression(@NotNull BramsprParser.GreaterThanExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParser#smallerThanExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSmallerThanExpression(@NotNull BramsprParser.SmallerThanExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParser#ifStructure}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStructure(@NotNull BramsprParser.IfStructureContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParser#multiplicationExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicationExpression(@NotNull BramsprParser.MultiplicationExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParser#swap}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwap(@NotNull BramsprParser.SwapContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParser#plusMinusExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlusMinusExpression(@NotNull BramsprParser.PlusMinusExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParser#blockStructure}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockStructure(@NotNull BramsprParser.BlockStructureContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(@NotNull BramsprParser.LiteralContext ctx);
}