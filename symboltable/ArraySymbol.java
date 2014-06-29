package symboltable;

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
		super("[" + amount + "]" + type.toString());
		this.type = type;
	}
	
	public boolean equals(Object comparable) {
		if(! (comparable instanceof ArraySymbol)) {
			return false;
		}
		
		ArraySymbol comp = (ArraySymbol) comparable;
		
		return (comp.amount == this.amount) && (this.type.equals(comp.type));
	}
}
