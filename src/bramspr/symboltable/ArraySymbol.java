package bramspr.symboltable;

/**
 * Objects of this class are symbol table entries associated with array-types in a Bramspr-program.
 * 
 * On top of the information {@link TypeSymbol} already specifies, an array-type has a number of elements and the type of these elements, so this class
 * specifies the properties and methods for these features.
 * 
 * As built-in types are implemented as composite types, this class also defines the property {@link #primitive}, indicating whether the object in question is
 * the symbol of such a built-in type.
 * 
 * In addition, this class contains some functionality for fixing JVM naming issues.
 * 
 */
public class ArraySymbol extends TypeSymbol {
	/** The amount of this array-type's elements. */
	int amount;
	
	/** The type of this array-type's elements. */
	public TypeSymbol type;

	/**
	 * @param amount
	 *            The amount of this array-type's elements.
	 * @param type
	 *            The type of this array-type's elements.
	 */
	public ArraySymbol(int amount, TypeSymbol type) {
		super("[" + amount + "]" + type.toString());
		this.type = type;
	}

	/**
	 * 
	 * @param comparable
	 *            The symbol to compare this array-type symbol to.
	 * @return Whether this array-type is equal to the compared symbol. This is the case if it is also an array-type symbol and it contains the same type and amount
	 *         of elements.
	 */
	public boolean equals(Object comparable) {
		if (!(comparable instanceof ArraySymbol)) {
			return false;
		}

		ArraySymbol comp = (ArraySymbol) comparable;

		return (comp.amount == this.amount) && (this.type.equals(comp.type));
	}

	/**
	 * 
	 * @return The JVM-descriptor of this array-type.
	 */
	public String getDescriptor() {
		return "[" + type.getDescriptor();
	}
}
