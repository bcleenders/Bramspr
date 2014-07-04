package bramspr.symboltable;

import bramspr.BramsprParser.FunctionDeclarationContext;

/**
 * Objects of this class are symbol table entries associated with functions in a Bramspr-program.
 * 
 * On top of the information {@link ValueYielderSymbol} already specifies, a function has parameters, so this class defines that attribute as an array of
 * {@link TypeSymbol}-objects.
 * 
 * In addition, because of function overloading, functions are the only type of Bramspr-entities that are stored in a symbol table but can not be identified by merely their identifiers.
 * Therefore, in the symbol table we index a function by a signature string that is composed of its identifier and its parameter signature. This class contains
 * the utility function to generate that string (see {@link #generateSignature}.
 * 
 */
public class FunctionSymbol extends ValueYielderSymbol {
	/** (The types of) this function's parameters. */
	TypeSymbol[] parameters;
	
	/**
	 * The context of the declaration.
	 */
	public FunctionDeclarationContext declarationContext;

	/**
	 * Generates a function's signature string, for indexing its symbol in a symbol table with.
	 * 
	 * The signature follows the pattern {@code [function identifier] (' '[parameter type identifier])*}.
	 * 
	 * @param identifier
	 *            The function's identifier.
	 * @param parameters
	 *            The type symbols of the function's parameters.
	 * @return The function's signature string.
	 */
	public static String generateSignature(String identifier, TypeSymbol[] parameters) {
		StringBuilder sb = new StringBuilder(identifier);

		for (int i = 0; parameters != null && i < parameters.length; i++) {
			sb.append(' ');
			sb.append(parameters[i].toString());
		}

		return sb.toString();
	}

	public FunctionSymbol(String identifier, TypeSymbol returnType, TypeSymbol[] parameters, boolean isConstant, FunctionDeclarationContext ctx) {
		super(identifier, returnType, isConstant);
		this.parameters = parameters;
		this.declarationContext = ctx;
	}

	public String toString() {
		return FunctionSymbol.generateSignature(this.getIdentifier(), this.parameters);
	}
}
