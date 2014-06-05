// Generated from D:\studie\Compilerbouw\bramspr\bramspr\src\BramsprParser.g4 by ANTLR 4.1
package bramspr;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link BramsprParserParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface BramsprParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link BramsprParserParser#divisionExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDivisionExpression(@NotNull BramsprParserParser.DivisionExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParserParser#enumdeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumdeclaration(@NotNull BramsprParserParser.EnumdeclarationContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParserParser#parenthesisExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthesisExpression(@NotNull BramsprParserParser.ParenthesisExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParserParser#modulusExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModulusExpression(@NotNull BramsprParserParser.ModulusExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParserParser#functiondeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctiondeclaration(@NotNull BramsprParserParser.FunctiondeclarationContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParserParser#positiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPositiveExpression(@NotNull BramsprParserParser.PositiveExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParserParser#assignExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignExpression(@NotNull BramsprParserParser.AssignExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParserParser#typedeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypedeclaration(@NotNull BramsprParserParser.TypedeclarationContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParserParser#orExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrExpression(@NotNull BramsprParserParser.OrExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParserParser#powerExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPowerExpression(@NotNull BramsprParserParser.PowerExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParserParser#whilestatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhilestatement(@NotNull BramsprParserParser.WhilestatementContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParserParser#notEqualsToExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotEqualsToExpression(@NotNull BramsprParserParser.NotEqualsToExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParserParser#andExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndExpression(@NotNull BramsprParserParser.AndExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParserParser#functioncall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctioncall(@NotNull BramsprParserParser.FunctioncallContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParserParser#equalsToExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualsToExpression(@NotNull BramsprParserParser.EqualsToExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParserParser#greaterThanExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGreaterThanExpression(@NotNull BramsprParserParser.GreaterThanExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParserParser#charLiteralExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharLiteralExpression(@NotNull BramsprParserParser.CharLiteralExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParserParser#smallerThanExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSmallerThanExpression(@NotNull BramsprParserParser.SmallerThanExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParserParser#printstatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintstatement(@NotNull BramsprParserParser.PrintstatementContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParserParser#ifstatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfstatement(@NotNull BramsprParserParser.IfstatementContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParserParser#multiplicationExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicationExpression(@NotNull BramsprParserParser.MultiplicationExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParserParser#plusMinusExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlusMinusExpression(@NotNull BramsprParserParser.PlusMinusExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParserParser#plusExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlusExpression(@NotNull BramsprParserParser.PlusExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParserParser#stringLiteralExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringLiteralExpression(@NotNull BramsprParserParser.StringLiteralExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParserParser#variableExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableExpression(@NotNull BramsprParserParser.VariableExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParserParser#greaterThanEqualsToExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGreaterThanEqualsToExpression(@NotNull BramsprParserParser.GreaterThanEqualsToExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParserParser#functionExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionExpression(@NotNull BramsprParserParser.FunctionExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParserParser#minusExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMinusExpression(@NotNull BramsprParserParser.MinusExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParserParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(@NotNull BramsprParserParser.DeclarationContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParserParser#notExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotExpression(@NotNull BramsprParserParser.NotExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParserParser#intLiteralExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntLiteralExpression(@NotNull BramsprParserParser.IntLiteralExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParserParser#smallerThanEqualsToExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSmallerThanEqualsToExpression(@NotNull BramsprParserParser.SmallerThanEqualsToExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParserParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(@NotNull BramsprParserParser.StatementContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParserParser#variabledeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariabledeclaration(@NotNull BramsprParserParser.VariabledeclarationContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParserParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(@NotNull BramsprParserParser.AssignmentContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParserParser#negativeExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegativeExpression(@NotNull BramsprParserParser.NegativeExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParserParser#primitiveType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimitiveType(@NotNull BramsprParserParser.PrimitiveTypeContext ctx);

	/**
	 * Visit a parse tree produced by {@link BramsprParserParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(@NotNull BramsprParserParser.ProgramContext ctx);
}