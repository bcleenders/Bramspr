package symboltable;

enum typeClass {
	ENUM('e'),
	VARIABLE('v'),
	TYPE('t'),
	FUNCTION('f');
	
	char firstChar;
	
	typeClass(char firstChar) {
		this.firstChar = firstChar;
	}
}

public class Symbol { // A generic programming language symbol
	String identifier; // All symbols at least have a name
	typeClass type;
	typeClass[] arguments;
	
	Scope scope; // All symbols know what scope contains them.
	
	
	public static String generateSignature(String identifier, typeClass type, typeClass[] arguments) {
		StringBuilder sb = new StringBuilder(type.firstChar);
		sb.append(' ');
		sb.append(identifier);
		
		for (int i = 0; arguments != null && i < arguments.length; i++) {
			sb.append(' ');
			sb.append(arguments[i]);
		}
		
		return sb.toString();
	}

	public Symbol(String identifier, typeClass type, typeClass[] arguments) {
		this.identifier = identifier;
		this.type = type;
		this.arguments = arguments;
	}

	public Symbol(String identifier, typeClass type) {
		this(identifier, type, null);
	}

	public String getIdentifier() {
		return this.identifier;
	}
	
	public typeClass getType() {
		return this.type;
	}

	/**
	 * Deze moet uniek zijn voor twee verschillende functies/variables/enums/...
	 */
	public String toString() {
		return Symbol.generateSignature(this.identifier, this.type, this.arguments);
	}
}
