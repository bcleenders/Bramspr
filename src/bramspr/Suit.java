package bramspr;

import bramspr.symboltable.ErrorType;
import bramspr.symboltable.TypeSymbol;

/**
 * Instances of this class indicate the suit for entities in a Bramspr-program, such as variables, function return values, expressions, type-denoters, et
 * cetera.
 * 
 * Suits are a concept like types: they are a property of an entity in a program. They can be returned, denoted and compared. Practically, they bundle a type
 * and a constancy.
 * 
 * {@link BramsprChecker} makes extensive use of this class, using it as the return type for its visit-methods.
 * 
 */
public class Suit {

	/** The void suit. */
	public static final Suit VOID = new Suit(BramsprChecker.VOID, true);

	/**
	 * The error suit.
	 * 
	 * Matches anything, so that one error in the program doesn't trigger a chain of dependent errors, confusing the programmer.
	 */
	public static final Suit ERROR = new Suit(new ErrorType(), false);

	/** This symbol's type. */
	public TypeSymbol type;

	/** This symbol's constancy. */
	public boolean isConstant;

	public Suit(TypeSymbol type, boolean isConstant) {
		this.type = type;
		this.isConstant = isConstant;
	}
}
