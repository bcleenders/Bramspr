package symboltable;

public abstract class Symbol { // A generic programm symbol
	String identifier; // All symbols at least have a name

	public Symbol(String identifier) {
		this.identifier = identifier;
	}
	
	public String getIdentifier() {
		return this.identifier;
	}
	
	public String toString(){
		return getIdentifier();
	}
}
