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
	 * Visit a parse tree produced by {@link BramsprParser#unaryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExpression(@NotNull BramsprParser.UnaryExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParser#assignExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignExpression(@NotNull BramsprParser.AssignExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParser#additionExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditionExpression(@NotNull BramsprParser.AdditionExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParser#whilestatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhilestatement(@NotNull BramsprParser.WhilestatementContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParser#getBoolExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGetBoolExpression(@NotNull BramsprParser.GetBoolExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParser#notEqualsToExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotEqualsToExpression(@NotNull BramsprParser.NotEqualsToExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParser#variableDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclaration(@NotNull BramsprParser.VariableDeclarationContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParser#putIntExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPutIntExpression(@NotNull BramsprParser.PutIntExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParser#arrayAccessExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayAccessExpression(@NotNull BramsprParser.ArrayAccessExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParser#greaterThanExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGreaterThanExpression(@NotNull BramsprParser.GreaterThanExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParser#ifstatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfstatement(@NotNull BramsprParser.IfstatementContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParser#multiplicationExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicationExpression(@NotNull BramsprParser.MultiplicationExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParser#getCharExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGetCharExpression(@NotNull BramsprParser.GetCharExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParser#greaterThanEqualsToExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGreaterThanEqualsToExpression(@NotNull BramsprParser.GreaterThanEqualsToExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(@NotNull BramsprParser.DeclarationContext ctx);

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
	 * Visit a parse tree produced by {@link BramsprParser#fielddeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFielddeclaration(@NotNull BramsprParser.FielddeclarationContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(@NotNull BramsprParser.ProgramContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParser#recordLiteralExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRecordLiteralExpression(@NotNull BramsprParser.RecordLiteralExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParser#functionCallExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCallExpression(@NotNull BramsprParser.FunctionCallExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParser#boolLiteralExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolLiteralExpression(@NotNull BramsprParser.BoolLiteralExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParser#fieldAccessExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldAccessExpression(@NotNull BramsprParser.FieldAccessExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParser#primitiveTypeDenoter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimitiveTypeDenoter(@NotNull BramsprParser.PrimitiveTypeDenoterContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParser#enumdeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumdeclaration(@NotNull BramsprParser.EnumdeclarationContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParser#finalDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFinalDeclaration(@NotNull BramsprParser.FinalDeclarationContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParser#functiondeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctiondeclaration(@NotNull BramsprParser.FunctiondeclarationContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParser#getIntExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGetIntExpression(@NotNull BramsprParser.GetIntExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(@NotNull BramsprParser.BlockContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParser#typedeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypedeclaration(@NotNull BramsprParser.TypedeclarationContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParser#powerExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPowerExpression(@NotNull BramsprParser.PowerExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParser#orExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrExpression(@NotNull BramsprParser.OrExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParser#putCharExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPutCharExpression(@NotNull BramsprParser.PutCharExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParser#andExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndExpression(@NotNull BramsprParser.AndExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParser#equalsToExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualsToExpression(@NotNull BramsprParser.EqualsToExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParser#enumExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumExpression(@NotNull BramsprParser.EnumExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParser#charLiteralExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharLiteralExpression(@NotNull BramsprParser.CharLiteralExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParser#smallerThanExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSmallerThanExpression(@NotNull BramsprParser.SmallerThanExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParser#printstatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintstatement(@NotNull BramsprParser.PrintstatementContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParser#putBoolExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPutBoolExpression(@NotNull BramsprParser.PutBoolExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParser#plusMinusExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlusMinusExpression(@NotNull BramsprParser.PlusMinusExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParser#swapstatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwapstatement(@NotNull BramsprParser.SwapstatementContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParser#stringLiteralExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringLiteralExpression(@NotNull BramsprParser.StringLiteralExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParser#variableExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableExpression(@NotNull BramsprParser.VariableExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParser#functionExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionExpression(@NotNull BramsprParser.FunctionExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParser#intLiteralExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntLiteralExpression(@NotNull BramsprParser.IntLiteralExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(@NotNull BramsprParser.AssignmentContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParser#arrayLiteralExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayLiteralExpression(@NotNull BramsprParser.ArrayLiteralExpressionContext ctx);
}