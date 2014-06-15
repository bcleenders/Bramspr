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
	 * Enter a parse tree produced by {@link BramsprParser#unaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpression(@NotNull BramsprParser.UnaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BramsprParser#unaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpression(@NotNull BramsprParser.UnaryExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link BramsprParser#assignExpression}.
	 * @param ctx the parse tree
	 */
	void enterAssignExpression(@NotNull BramsprParser.AssignExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BramsprParser#assignExpression}.
	 * @param ctx the parse tree
	 */
	void exitAssignExpression(@NotNull BramsprParser.AssignExpressionContext ctx);

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
	 * Enter a parse tree produced by {@link BramsprParser#whilestatement}.
	 * @param ctx the parse tree
	 */
	void enterWhilestatement(@NotNull BramsprParser.WhilestatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link BramsprParser#whilestatement}.
	 * @param ctx the parse tree
	 */
	void exitWhilestatement(@NotNull BramsprParser.WhilestatementContext ctx);

	/**
	 * Enter a parse tree produced by {@link BramsprParser#getBoolExpression}.
	 * @param ctx the parse tree
	 */
	void enterGetBoolExpression(@NotNull BramsprParser.GetBoolExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BramsprParser#getBoolExpression}.
	 * @param ctx the parse tree
	 */
	void exitGetBoolExpression(@NotNull BramsprParser.GetBoolExpressionContext ctx);

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
	 * Enter a parse tree produced by {@link BramsprParser#putIntExpression}.
	 * @param ctx the parse tree
	 */
	void enterPutIntExpression(@NotNull BramsprParser.PutIntExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BramsprParser#putIntExpression}.
	 * @param ctx the parse tree
	 */
	void exitPutIntExpression(@NotNull BramsprParser.PutIntExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link BramsprParser#arrayAccessExpression}.
	 * @param ctx the parse tree
	 */
	void enterArrayAccessExpression(@NotNull BramsprParser.ArrayAccessExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BramsprParser#arrayAccessExpression}.
	 * @param ctx the parse tree
	 */
	void exitArrayAccessExpression(@NotNull BramsprParser.ArrayAccessExpressionContext ctx);

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
	 * Enter a parse tree produced by {@link BramsprParser#ifstatement}.
	 * @param ctx the parse tree
	 */
	void enterIfstatement(@NotNull BramsprParser.IfstatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link BramsprParser#ifstatement}.
	 * @param ctx the parse tree
	 */
	void exitIfstatement(@NotNull BramsprParser.IfstatementContext ctx);

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
	 * Enter a parse tree produced by {@link BramsprParser#getCharExpression}.
	 * @param ctx the parse tree
	 */
	void enterGetCharExpression(@NotNull BramsprParser.GetCharExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BramsprParser#getCharExpression}.
	 * @param ctx the parse tree
	 */
	void exitGetCharExpression(@NotNull BramsprParser.GetCharExpressionContext ctx);

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
	 * Enter a parse tree produced by {@link BramsprParser#recordAccessExpression}.
	 * @param ctx the parse tree
	 */
	void enterRecordAccessExpression(@NotNull BramsprParser.RecordAccessExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BramsprParser#recordAccessExpression}.
	 * @param ctx the parse tree
	 */
	void exitRecordAccessExpression(@NotNull BramsprParser.RecordAccessExpressionContext ctx);

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
	 * Enter a parse tree produced by {@link BramsprParser#fielddeclaration}.
	 * @param ctx the parse tree
	 */
	void enterFielddeclaration(@NotNull BramsprParser.FielddeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link BramsprParser#fielddeclaration}.
	 * @param ctx the parse tree
	 */
	void exitFielddeclaration(@NotNull BramsprParser.FielddeclarationContext ctx);

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
	 * Enter a parse tree produced by {@link BramsprParser#recordLiteralExpression}.
	 * @param ctx the parse tree
	 */
	void enterRecordLiteralExpression(@NotNull BramsprParser.RecordLiteralExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BramsprParser#recordLiteralExpression}.
	 * @param ctx the parse tree
	 */
	void exitRecordLiteralExpression(@NotNull BramsprParser.RecordLiteralExpressionContext ctx);

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
	 * Enter a parse tree produced by {@link BramsprParser#fieldAccessExpression}.
	 * @param ctx the parse tree
	 */
	void enterFieldAccessExpression(@NotNull BramsprParser.FieldAccessExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BramsprParser#fieldAccessExpression}.
	 * @param ctx the parse tree
	 */
	void exitFieldAccessExpression(@NotNull BramsprParser.FieldAccessExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link BramsprParser#boolLiteralExpression}.
	 * @param ctx the parse tree
	 */
	void enterBoolLiteralExpression(@NotNull BramsprParser.BoolLiteralExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BramsprParser#boolLiteralExpression}.
	 * @param ctx the parse tree
	 */
	void exitBoolLiteralExpression(@NotNull BramsprParser.BoolLiteralExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link BramsprParser#primitiveTypeDenoter}.
	 * @param ctx the parse tree
	 */
	void enterPrimitiveTypeDenoter(@NotNull BramsprParser.PrimitiveTypeDenoterContext ctx);
	/**
	 * Exit a parse tree produced by {@link BramsprParser#primitiveTypeDenoter}.
	 * @param ctx the parse tree
	 */
	void exitPrimitiveTypeDenoter(@NotNull BramsprParser.PrimitiveTypeDenoterContext ctx);

	/**
	 * Enter a parse tree produced by {@link BramsprParser#enumdeclaration}.
	 * @param ctx the parse tree
	 */
	void enterEnumdeclaration(@NotNull BramsprParser.EnumdeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link BramsprParser#enumdeclaration}.
	 * @param ctx the parse tree
	 */
	void exitEnumdeclaration(@NotNull BramsprParser.EnumdeclarationContext ctx);

	/**
	 * Enter a parse tree produced by {@link BramsprParser#functiondeclaration}.
	 * @param ctx the parse tree
	 */
	void enterFunctiondeclaration(@NotNull BramsprParser.FunctiondeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link BramsprParser#functiondeclaration}.
	 * @param ctx the parse tree
	 */
	void exitFunctiondeclaration(@NotNull BramsprParser.FunctiondeclarationContext ctx);

	/**
	 * Enter a parse tree produced by {@link BramsprParser#getIntExpression}.
	 * @param ctx the parse tree
	 */
	void enterGetIntExpression(@NotNull BramsprParser.GetIntExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BramsprParser#getIntExpression}.
	 * @param ctx the parse tree
	 */
	void exitGetIntExpression(@NotNull BramsprParser.GetIntExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link BramsprParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(@NotNull BramsprParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link BramsprParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(@NotNull BramsprParser.BlockContext ctx);

	/**
	 * Enter a parse tree produced by {@link BramsprParser#typedeclaration}.
	 * @param ctx the parse tree
	 */
	void enterTypedeclaration(@NotNull BramsprParser.TypedeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link BramsprParser#typedeclaration}.
	 * @param ctx the parse tree
	 */
	void exitTypedeclaration(@NotNull BramsprParser.TypedeclarationContext ctx);

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
	 * Enter a parse tree produced by {@link BramsprParser#putCharExpression}.
	 * @param ctx the parse tree
	 */
	void enterPutCharExpression(@NotNull BramsprParser.PutCharExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BramsprParser#putCharExpression}.
	 * @param ctx the parse tree
	 */
	void exitPutCharExpression(@NotNull BramsprParser.PutCharExpressionContext ctx);

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
	 * Enter a parse tree produced by {@link BramsprParser#enumExpression}.
	 * @param ctx the parse tree
	 */
	void enterEnumExpression(@NotNull BramsprParser.EnumExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BramsprParser#enumExpression}.
	 * @param ctx the parse tree
	 */
	void exitEnumExpression(@NotNull BramsprParser.EnumExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link BramsprParser#charLiteralExpression}.
	 * @param ctx the parse tree
	 */
	void enterCharLiteralExpression(@NotNull BramsprParser.CharLiteralExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BramsprParser#charLiteralExpression}.
	 * @param ctx the parse tree
	 */
	void exitCharLiteralExpression(@NotNull BramsprParser.CharLiteralExpressionContext ctx);

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
	 * Enter a parse tree produced by {@link BramsprParser#putBoolExpression}.
	 * @param ctx the parse tree
	 */
	void enterPutBoolExpression(@NotNull BramsprParser.PutBoolExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BramsprParser#putBoolExpression}.
	 * @param ctx the parse tree
	 */
	void exitPutBoolExpression(@NotNull BramsprParser.PutBoolExpressionContext ctx);

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
	 * Enter a parse tree produced by {@link BramsprParser#swapstatement}.
	 * @param ctx the parse tree
	 */
	void enterSwapstatement(@NotNull BramsprParser.SwapstatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link BramsprParser#swapstatement}.
	 * @param ctx the parse tree
	 */
	void exitSwapstatement(@NotNull BramsprParser.SwapstatementContext ctx);

	/**
	 * Enter a parse tree produced by {@link BramsprParser#stringLiteralExpression}.
	 * @param ctx the parse tree
	 */
	void enterStringLiteralExpression(@NotNull BramsprParser.StringLiteralExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BramsprParser#stringLiteralExpression}.
	 * @param ctx the parse tree
	 */
	void exitStringLiteralExpression(@NotNull BramsprParser.StringLiteralExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link BramsprParser#variableExpression}.
	 * @param ctx the parse tree
	 */
	void enterVariableExpression(@NotNull BramsprParser.VariableExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BramsprParser#variableExpression}.
	 * @param ctx the parse tree
	 */
	void exitVariableExpression(@NotNull BramsprParser.VariableExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link BramsprParser#functionExpression}.
	 * @param ctx the parse tree
	 */
	void enterFunctionExpression(@NotNull BramsprParser.FunctionExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BramsprParser#functionExpression}.
	 * @param ctx the parse tree
	 */
	void exitFunctionExpression(@NotNull BramsprParser.FunctionExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link BramsprParser#intLiteralExpression}.
	 * @param ctx the parse tree
	 */
	void enterIntLiteralExpression(@NotNull BramsprParser.IntLiteralExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BramsprParser#intLiteralExpression}.
	 * @param ctx the parse tree
	 */
	void exitIntLiteralExpression(@NotNull BramsprParser.IntLiteralExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link BramsprParser#variabledeclaration}.
	 * @param ctx the parse tree
	 */
	void enterVariabledeclaration(@NotNull BramsprParser.VariabledeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link BramsprParser#variabledeclaration}.
	 * @param ctx the parse tree
	 */
	void exitVariabledeclaration(@NotNull BramsprParser.VariabledeclarationContext ctx);

	/**
	 * Enter a parse tree produced by {@link BramsprParser#finaldeclaration}.
	 * @param ctx the parse tree
	 */
	void enterFinaldeclaration(@NotNull BramsprParser.FinaldeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link BramsprParser#finaldeclaration}.
	 * @param ctx the parse tree
	 */
	void exitFinaldeclaration(@NotNull BramsprParser.FinaldeclarationContext ctx);

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
	 * Enter a parse tree produced by {@link BramsprParser#arrayLiteralExpression}.
	 * @param ctx the parse tree
	 */
	void enterArrayLiteralExpression(@NotNull BramsprParser.ArrayLiteralExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BramsprParser#arrayLiteralExpression}.
	 * @param ctx the parse tree
	 */
	void exitArrayLiteralExpression(@NotNull BramsprParser.ArrayLiteralExpressionContext ctx);
}