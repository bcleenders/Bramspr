package symboltable;

import bramspr.symboltable.TypeClass;

public class Symbol { // A generic programming language symbol
	String identifier; // All symbols at least have a name
	TypeClass type;
	TypeClass[] arguments;
	String returnType = "void";

	/**
	 * Genereert een signature van een functie, enum of ander "object".
	 * 
	 * @param identifier
	 *            de naam van het object (e.g. foo, Days)
	 * @param type
	 *            het type van het object (e.g. TypeClass.ENUM)
	 * @param arguments
	 *            argumenten van het object (null bij niet-functies)
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
	 * 
	 * @param identifier
	 *            Naam van het symbol
	 * @param type
	 *            de typeklasse van dit symbool; is het een variabele, functie, type...
	 * @param returnType
	 *            type van datgene dat dit symbool representeert; voor een variabele is het het type in de variabele, voor een functie het
	 *            type van de returnvalue.
	 * @param arguments de types van de argumenten (alleen toepasbaar bij functies)
	 * @ensures Symbol.generateSignature(identifier, type, arguments) == this.toString()
	 */
	public Symbol(String identifier, TypeClass type, String returnType, TypeClass[] arguments) {
		this.identifier = identifier;
		this.type = type;
		this.returnType = returnType;
		this.arguments = arguments;
	}

	public Symbol(String identifier, TypeClass type, String returnType) {
		this(identifier, type, returnType, null);
	}

	public String getIdentifier() {
		return this.identifier;
	}

	public TypeClass getType() {
		return this.type;
	}

	/**
	 * Deze moet uniek zijn voor twee verschillende functies/variables/enums/...
	 * @ensure (new Symbol(a,b,c,d)).toString() == generateSignature(a,b,c,d)
	 */
	public String toString() {
		return Symbol.generateSignature(this.identifier, this.type, this.arguments);
	}
}
