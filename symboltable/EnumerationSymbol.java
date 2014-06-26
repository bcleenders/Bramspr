package symboltable;

import java.util.HashSet;

public class EnumerationSymbol extends TypeSymbol {
	HashSet<String> constants;
	
	public EnumerationSymbol(String identifier, String[] constants) {
		super(identifier);

		for (String string : constants) {
			this.constants.add(string);
		}
	}
	
	/**
	 * Checks whether this enum contains a constant.
	 * @param identifier the name of the constant to be checked
	 * @return true iff the enum contains this constant
	 */
	public boolean hasValue(String identifier) {
		return constants.contains(identifier);
	}
}
