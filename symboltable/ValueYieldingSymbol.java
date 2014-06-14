package symboltable;

public abstract class ValueYieldingSymbol extends Symbol {
	TypeSymbol returnType;
	
	public ValueYieldingSymbol(String identifier, TypeSymbol returnType) {
		super(identifier);
		this.returnType = returnType;
	}

	public TypeSymbol getReturnType() {
		return this.returnType;
	}
}
