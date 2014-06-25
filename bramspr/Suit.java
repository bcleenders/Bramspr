package bramspr;

import symboltable.ErrorType;
import symboltable.RecordSymbol;
import symboltable.TypeSymbol;

public class Suit {
	public static final Suit VOID = new Suit(new RecordSymbol("void", null, null), true);
	public static final Suit ERROR = new Suit(new ErrorType(), false);
	
	/**
	 * The String representation of this type.
	 * E.g. "int", "bool", "Stoel"...
	 */
	public TypeSymbol type;
	
	/**
	 * Whether or not this variable is a constant expression. 
	 * A constant expression is an expression with a return value that can be computed compile-time.
	 * For example:
	 * 	- 1+1 is constant
	 *  - 1 + getInt() is not constant, since the value of getInt() can only be determined at runtime
	 */
	public boolean isConstant;
	
	public Suit(TypeSymbol type, boolean isConstant) {
		this.type = type;
		this.isConstant = isConstant;
	}
}
