package bramspr.symboltable;

/**
 * Objects of this class are symbol table entries associated with variables in a Bramspr-program.
 * 
 * Since all information we want to keep about variables is already specified in {@link ValueYielderSymbol}, this class is nothing more than a concrete subclass
 * of that abstract class.
 * 
 */
public class VariableSymbol extends ValueYielderSymbol {

	public VariableSymbol(String identifier, TypeSymbol returnType, boolean isConstant) {
		super(identifier, returnType, isConstant);
	}

	public String toString() {
		return this.getIdentifier();
	}

}
