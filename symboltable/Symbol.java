package symboltable;

import bramspr.symboltable.TypeClass;

public class Symbol { // A generic programming language symbol
	String identifier; // All symbols at least have a name
	TypeClass type;
	TypeClass[] arguments;
	
	/**
	 * Genereert een signature van een functie, enum of ander "object".
	 * @param identifier de naam van het object (e.g. foo, Days)
	 * @param type het type van het object (e.g. TypeClass.ENUM)
	 * @param arguments argumenten van het object (null bij niet-functies)
	 * @return een kenmerkend signature
	 */
	public static String generateSignature(String identifier, TypeClass type, TypeClass[] arguments) {
		StringBuilder sb = new StringBuilder(type.firstChar);
		sb.append(' ');
		sb.append(identifier);
		
		for (int i = 0; arguments != null && i < arguments.length; i++) {
			sb.append(' ');
			sb.append(arguments[i]);
		}
		
		return sb.toString();
	}

	/**
	 * Genereert een Symbol
	 * @param identifier
	 * @param type
	 * @param arguments
	 * @ensures Symbol.generateSignature(identifier, type, arguments) == this.toString()
	 */
	public Symbol(String identifier, TypeClass type, TypeClass[] arguments) {
		this.identifier = identifier;
		this.type = type;
		this.arguments = arguments;
	}

	public Symbol(String identifier, TypeClass type) {
		this(identifier, type, null);
	}

	public String getIdentifier() {
		return this.identifier;
	}
	
	public TypeClass getType() {
		return this.type;
	}

	/**
	 * Deze moet uniek zijn voor twee verschillende functies/variables/enums/...
	 */
	public String toString() {
		return Symbol.generateSignature(this.identifier, this.type, this.arguments);
	}
}
