// Generated from D:\studie\Compilerbouw\bramspr\bramspr\src\BramsprParser.g4 by ANTLR 4.1
package bramspr;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link BramsprParserParser}.
 */
public interface BramsprParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link BramsprParserParser#divisionExpression}.
	 * @param ctx the parse tree
	 */
	void enterDivisionExpression(@NotNull BramsprParserParser.DivisionExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BramsprParserParser#divisionExpression}.
	 * @param ctx the parse tree
	 */
	void exitDivisionExpression(@NotNull BramsprParserParser.DivisionExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link BramsprParserParser#enumdeclaration}.
	 * @param ctx the parse tree
	 */
	void enterEnumdeclaration(@NotNull BramsprParserParser.EnumdeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link BramsprParserParser#enumdeclaration}.
	 * @param ctx the parse tree
	 */
	void exitEnumdeclaration(@NotNull BramsprParserParser.EnumdeclarationContext ctx);

	/**
	 * Enter a parse tree produced by {@link BramsprParserParser#parenthesisExpression}.
	 * @param ctx the parse tree
	 */
	void enterParenthesisExpression(@NotNull BramsprParserParser.ParenthesisExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BramsprParserParser#parenthesisExpression}.
	 * @param ctx the parse tree
	 */
	void exitParenthesisExpression(@NotNull BramsprParserParser.ParenthesisExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link BramsprParserParser#modulusExpression}.
	 * @param ctx the parse tree
	 */
	void enterModulusExpression(@NotNull BramsprParserParser.ModulusExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BramsprParserParser#modulusExpression}.
	 * @param ctx the parse tree
	 */
	void exitModulusExpression(@NotNull BramsprParserParser.ModulusExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link BramsprParserParser#functiondeclaration}.
	 * @param ctx the parse tree
	 */
	void enterFunctiondeclaration(@NotNull BramsprParserParser.FunctiondeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link BramsprParserParser#functiondeclaration}.
	 * @param ctx the parse tree
	 */
	void exitFunctiondeclaration(@NotNull BramsprParserParser.FunctiondeclarationContext ctx);

	/**
	 * Enter a parse tree produced by {@link BramsprParserParser#positiveExpression}.
	 * @param ctx the parse tree
	 */
	void enterPositiveExpression(@NotNull BramsprParserParser.PositiveExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BramsprParserParser#positiveExpression}.
	 * @param ctx the parse tree
	 */
	void exitPositiveExpression(@NotNull BramsprParserParser.PositiveExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link BramsprParserParser#assignExpression}.
	 * @param ctx the parse tree
	 */
	void enterAssignExpression(@NotNull BramsprParserParser.AssignExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BramsprParserParser#assignExpression}.
	 * @param ctx the parse tree
	 */
	void exitAssignExpression(@NotNull BramsprParserParser.AssignExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link BramsprParserParser#typedeclaration}.
	 * @param ctx the parse tree
	 */
	void enterTypedeclaration(@NotNull BramsprParserParser.TypedeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link BramsprParserParser#typedeclaration}.
	 * @param ctx the parse tree
	 */
	void exitTypedeclaration(@NotNull BramsprParserParser.TypedeclarationContext ctx);

	/**
	 * Enter a parse tree produced by {@link BramsprParserParser#orExpression}.
	 * @param ctx the parse tree
	 */
	void enterOrExpression(@NotNull BramsprParserParser.OrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BramsprParserParser#orExpression}.
	 * @param ctx the parse tree
	 */
	void exitOrExpression(@NotNull BramsprParserParser.OrExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link BramsprParserParser#powerExpression}.
	 * @param ctx the parse tree
	 */
	void enterPowerExpression(@NotNull BramsprParserParser.PowerExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BramsprParserParser#powerExpression}.
	 * @param ctx the parse tree
	 */
	void exitPowerExpression(@NotNull BramsprParserParser.PowerExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link BramsprParserParser#whilestatement}.
	 * @param ctx the parse tree
	 */
	void enterWhilestatement(@NotNull BramsprParserParser.WhilestatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link BramsprParserParser#whilestatement}.
	 * @param ctx the parse tree
	 */
	void exitWhilestatement(@NotNull BramsprParserParser.WhilestatementContext ctx);

	/**
	 * Enter a parse tree produced by {@link BramsprParserParser#notEqualsToExpression}.
	 * @param ctx the parse tree
	 */
	void enterNotEqualsToExpression(@NotNull BramsprParserParser.NotEqualsToExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BramsprParserParser#notEqualsToExpression}.
	 * @param ctx the parse tree
	 */
	void exitNotEqualsToExpression(@NotNull BramsprParserParser.NotEqualsToExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link BramsprParserParser#andExpression}.
	 * @param ctx the parse tree
	 */
	void enterAndExpression(@NotNull BramsprParserParser.AndExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BramsprParserParser#andExpression}.
	 * @param ctx the parse tree
	 */
	void exitAndExpression(@NotNull BramsprParserParser.AndExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link BramsprParserParser#functioncall}.
	 * @param ctx the parse tree
	 */
	void enterFunctioncall(@NotNull BramsprParserParser.FunctioncallContext ctx);
	/**
	 * Exit a parse tree produced by {@link BramsprParserParser#functioncall}.
	 * @param ctx the parse tree
	 */
	void exitFunctioncall(@NotNull BramsprParserParser.FunctioncallContext ctx);

	/**
	 * Enter a parse tree produced by {@link BramsprParserParser#equalsToExpression}.
	 * @param ctx the parse tree
	 */
	void enterEqualsToExpression(@NotNull BramsprParserParser.EqualsToExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BramsprParserParser#equalsToExpression}.
	 * @param ctx the parse tree
	 */
	void exitEqualsToExpression(@NotNull BramsprParserParser.EqualsToExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link BramsprParserParser#greaterThanExpression}.
	 * @param ctx the parse tree
	 */
	void enterGreaterThanExpression(@NotNull BramsprParserParser.GreaterThanExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BramsprParserParser#greaterThanExpression}.
	 * @param ctx the parse tree
	 */
	void exitGreaterThanExpression(@NotNull BramsprParserParser.GreaterThanExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link BramsprParserParser#charLiteralExpression}.
	 * @param ctx the parse tree
	 */
	void enterCharLiteralExpression(@NotNull BramsprParserParser.CharLiteralExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BramsprParserParser#charLiteralExpression}.
	 * @param ctx the parse tree
	 */
	void exitCharLiteralExpression(@NotNull BramsprParserParser.CharLiteralExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link BramsprParserParser#smallerThanExpression}.
	 * @param ctx the parse tree
	 */
	void enterSmallerThanExpression(@NotNull BramsprParserParser.SmallerThanExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BramsprParserParser#smallerThanExpression}.
	 * @param ctx the parse tree
	 */
	void exitSmallerThanExpression(@NotNull BramsprParserParser.SmallerThanExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link BramsprParserParser#printstatement}.
	 * @param ctx the parse tree
	 */
	void enterPrintstatement(@NotNull BramsprParserParser.PrintstatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link BramsprParserParser#printstatement}.
	 * @param ctx the parse tree
	 */
	void exitPrintstatement(@NotNull BramsprParserParser.PrintstatementContext ctx);

	/**
	 * Enter a parse tree produced by {@link BramsprParserParser#ifstatement}.
	 * @param ctx the parse tree
	 */
	void enterIfstatement(@NotNull BramsprParserParser.IfstatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link BramsprParserParser#ifstatement}.
	 * @param ctx the parse tree
	 */
	void exitIfstatement(@NotNull BramsprParserParser.IfstatementContext ctx);

	/**
	 * Enter a parse tree produced by {@link BramsprParserParser#multiplicationExpression}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicationExpression(@NotNull BramsprParserParser.MultiplicationExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BramsprParserParser#multiplicationExpression}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicationExpression(@NotNull BramsprParserParser.MultiplicationExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link BramsprParserParser#plusMinusExpression}.
	 * @param ctx the parse tree
	 */
	void enterPlusMinusExpression(@NotNull BramsprParserParser.PlusMinusExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BramsprParserParser#plusMinusExpression}.
	 * @param ctx the parse tree
	 */
	void exitPlusMinusExpression(@NotNull BramsprParserParser.PlusMinusExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link BramsprParserParser#plusExpression}.
	 * @param ctx the parse tree
	 */
	void enterPlusExpression(@NotNull BramsprParserParser.PlusExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BramsprParserParser#plusExpression}.
	 * @param ctx the parse tree
	 */
	void exitPlusExpression(@NotNull BramsprParserParser.PlusExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link BramsprParserParser#stringLiteralExpression}.
	 * @param ctx the parse tree
	 */
	void enterStringLiteralExpression(@NotNull BramsprParserParser.StringLiteralExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BramsprParserParser#stringLiteralExpression}.
	 * @param ctx the parse tree
	 */
	void exitStringLiteralExpression(@NotNull BramsprParserParser.StringLiteralExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link BramsprParserParser#variableExpression}.
	 * @param ctx the parse tree
	 */
	void enterVariableExpression(@NotNull BramsprParserParser.VariableExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BramsprParserParser#variableExpression}.
	 * @param ctx the parse tree
	 */
	void exitVariableExpression(@NotNull BramsprParserParser.VariableExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link BramsprParserParser#greaterThanEqualsToExpression}.
	 * @param ctx the parse tree
	 */
	void enterGreaterThanEqualsToExpression(@NotNull BramsprParserParser.GreaterThanEqualsToExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BramsprParserParser#greaterThanEqualsToExpression}.
	 * @param ctx the parse tree
	 */
	void exitGreaterThanEqualsToExpression(@NotNull BramsprParserParser.GreaterThanEqualsToExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link BramsprParserParser#functionExpression}.
	 * @param ctx the parse tree
	 */
	void enterFunctionExpression(@NotNull BramsprParserParser.FunctionExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BramsprParserParser#functionExpression}.
	 * @param ctx the parse tree
	 */
	void exitFunctionExpression(@NotNull BramsprParserParser.FunctionExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link BramsprParserParser#minusExpression}.
	 * @param ctx the parse tree
	 */
	void enterMinusExpression(@NotNull BramsprParserParser.MinusExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BramsprParserParser#minusExpression}.
	 * @param ctx the parse tree
	 */
	void exitMinusExpression(@NotNull BramsprParserParser.MinusExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link BramsprParserParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(@NotNull BramsprParserParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link BramsprParserParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(@NotNull BramsprParserParser.DeclarationContext ctx);

	/**
	 * Enter a parse tree produced by {@link BramsprParserParser#notExpression}.
	 * @param ctx the parse tree
	 */
	void enterNotExpression(@NotNull BramsprParserParser.NotExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BramsprParserParser#notExpression}.
	 * @param ctx the parse tree
	 */
	void exitNotExpression(@NotNull BramsprParserParser.NotExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link BramsprParserParser#intLiteralExpression}.
	 * @param ctx the parse tree
	 */
	void enterIntLiteralExpression(@NotNull BramsprParserParser.IntLiteralExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BramsprParserParser#intLiteralExpression}.
	 * @param ctx the parse tree
	 */
	void exitIntLiteralExpression(@NotNull BramsprParserParser.IntLiteralExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link BramsprParserParser#smallerThanEqualsToExpression}.
	 * @param ctx the parse tree
	 */
	void enterSmallerThanEqualsToExpression(@NotNull BramsprParserParser.SmallerThanEqualsToExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BramsprParserParser#smallerThanEqualsToExpression}.
	 * @param ctx the parse tree
	 */
	void exitSmallerThanEqualsToExpression(@NotNull BramsprParserParser.SmallerThanEqualsToExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link BramsprParserParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(@NotNull BramsprParserParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link BramsprParserParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(@NotNull BramsprParserParser.StatementContext ctx);

	/**
	 * Enter a parse tree produced by {@link BramsprParserParser#variabledeclaration}.
	 * @param ctx the parse tree
	 */
	void enterVariabledeclaration(@NotNull BramsprParserParser.VariabledeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link BramsprParserParser#variabledeclaration}.
	 * @param ctx the parse tree
	 */
	void exitVariabledeclaration(@NotNull BramsprParserParser.VariabledeclarationContext ctx);

	/**
	 * Enter a parse tree produced by {@link BramsprParserParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(@NotNull BramsprParserParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link BramsprParserParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(@NotNull BramsprParserParser.AssignmentContext ctx);

	/**
	 * Enter a parse tree produced by {@link BramsprParserParser#negativeExpression}.
	 * @param ctx the parse tree
	 */
	void enterNegativeExpression(@NotNull BramsprParserParser.NegativeExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BramsprParserParser#negativeExpression}.
	 * @param ctx the parse tree
	 */
	void exitNegativeExpression(@NotNull BramsprParserParser.NegativeExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link BramsprParserParser#primitiveType}.
	 * @param ctx the parse tree
	 */
	void enterPrimitiveType(@NotNull BramsprParserParser.PrimitiveTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link BramsprParserParser#primitiveType}.
	 * @param ctx the parse tree
	 */
	void exitPrimitiveType(@NotNull BramsprParserParser.PrimitiveTypeContext ctx);

	/**
	 * Enter a parse tree produced by {@link BramsprParserParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(@NotNull BramsprParserParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link BramsprParserParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(@NotNull BramsprParserParser.ProgramContext ctx);
}