package bramspr.symboltable;

import bramspr.Suit;

/**
 * Symbol table entries associated with entities in a Bramspr-program that yield a value, are all subclasses of this abstract class.
 * 
 * These entities are variables (see {@link VariableSymbol}) and functions (see {@link FunctionSymbol}). The attribute they share is a return suit, so this
 * abstract class defines that attribute. For quick access, it is also possible to request the return type and constancy directly, instead of via the suit.
 * 
 */
public abstract class ValueYielderSymbol extends Symbol {
	/** Indicates whether this value-yielder yields a constant value.*/
	private boolean isConstant;
	
	/** Indicates the type of value this value-yielder yields.*/
	private TypeSymbol returnType;

	public ValueYielderSymbol(String identifier, TypeSymbol returnType, boolean isConstant) {
		super(identifier);
		this.returnType = returnType;
		this.isConstant = isConstant;
	}

	/** @return {@link #returnType} */
	public TypeSymbol getReturnType() {
		return returnType;
	}

	/** @return {@link #isConstant} */
	public boolean isConstant() {
		return isConstant;
	}

	/** @return The suit of this value-yielder's value. */
	public Suit getSuit() {
		return new Suit(returnType, isConstant);
	}
}
