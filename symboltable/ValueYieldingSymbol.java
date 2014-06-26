package symboltable;

public abstract class ValueYieldingSymbol extends Symbol {
	private boolean isConstant;
	TypeSymbol returnType;
	
	public ValueYieldingSymbol(String identifier, TypeSymbol returnType, boolean isConstant) {
		super(identifier);
		this.returnType = returnType;
		this.isConstant = isConstant;
	}

	public TypeSymbol getReturnType() {
		return this.returnType;
	}
	
	
	public boolean isConstant() {
		return this.isConstant;
	}
}
