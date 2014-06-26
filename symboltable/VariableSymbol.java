package symboltable;

public class VariableSymbol extends ValueYieldingSymbol {
		
	public VariableSymbol(String identifier, TypeSymbol returnType, boolean isConstant) {
		super(identifier, returnType, isConstant);
	}
	
	public String toString() {
		return this.identifier;
	}

}
