package symboltable;

public class FunctionSymbol extends ValueYieldingSymbol {
	TypeSymbol[] arguments;

	public FunctionSymbol(String identifier, TypeSymbol returnType, TypeSymbol[] arguments) {
		super(identifier, returnType);
		this.arguments = arguments;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder(identifier);

		for (int i = 0; arguments != null && i < arguments.length; i++) {
			sb.append(' ');
			sb.append(arguments[i].toString());
		}

		return sb.toString();
	}
}
