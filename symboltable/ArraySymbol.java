package symboltable;

public class ArraySymbol extends TypeSymbol {
	int amount;
	/**
	 * The type of the entries (all equal)
	 */
	TypeSymbol type;
	
	/**
	 * @param amount het aantal elementen in deze array
	 * @param type het type van de elementen in deze array
	 */
	public ArraySymbol(int amount, TypeSymbol type) {
		super("[" + amount + "]" + type.toString());
		this.type = type;
	}
}
