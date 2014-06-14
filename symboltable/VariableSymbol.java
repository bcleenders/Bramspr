package symboltable;

public class VariableSymbol extends ValueYieldingSymbol {
	boolean isFinal;
		
	public VariableSymbol(String identifier, TypeSymbol returnType, boolean isFinal) {
		super(identifier, returnType);
	}
	
	public String toString() {
		return this.identifier;
	}
	
	public boolean isFinal() {
		return this.isFinal;
	}
}
