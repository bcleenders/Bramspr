package symboltable;

public class FunctionSymbol extends ValueYieldingSymbol {
	TypeSymbol[] arguments;
	
	/**
	 * Genereert het signature van een functie, gegeven de functienaam en argumenttypes.
	 * Het signature voldoet aan het pattern: naam (' ' + typeNaam)*
	 * @param identifier functienaam (e.g. "foo")
	 * @param arguments argumententypes van deze functie
	 * @return signature van de functie
	 */
	public static String generateSignature(String identifier, TypeSymbol[] arguments) {
		StringBuilder sb = new StringBuilder(identifier);

		for (int i = 0; arguments != null && i < arguments.length; i++) {
			sb.append(' ');
			sb.append(arguments[i].toString());
		}

		return sb.toString();
	}

	public FunctionSymbol(String identifier, TypeSymbol returnType, TypeSymbol[] arguments, boolean isConstant) {
		super(identifier, returnType, isConstant);
		this.arguments = arguments;
	}

	/**
	 * Genereert het signature (functienaam + argumenttypes) van deze functie.
	 * Voldoet aan het pattern zoals gespecificeerd door FunctionSymbol.generateSignature(...).
	 */
	public String toString() {
		return FunctionSymbol.generateSignature(this.identifier, this.arguments);
	}
}
