package bramspr.symboltable;


public class ArraySymbol extends TypeSymbol {
	int amount;
	/**
	 * The type of the entries (all equal)
	 */
	public TypeSymbol type;
	
	/**
	 * @param amount het aantal elementen in deze array
	 * @param type het type van de elementen in deze array
	 */
	public ArraySymbol(int amount, TypeSymbol type) {
		super("[" + amount + "]" + type.toString(), "["+type.getInternalIdentifier());
		this.type = type;
	}
	
	/**
	 * Returns true if the objects are equal. Two array types are equal if the following conditions are all true:
	 * 1. both objects are arrays
	 * 2. both arrays have equal length
	 * 3. the types of the elements are equal
	 */
	public boolean equals(Object comparable) {
		if(! (comparable instanceof ArraySymbol)) {
			return false;
		}
		
		ArraySymbol comp = (ArraySymbol) comparable;
		
		return (comp.amount == this.amount) && (this.type.equals(comp.type));
	}
}
