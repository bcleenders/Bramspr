package symboltable;

import java.util.HashSet;

public class EnumSymbol extends TypeSymbol {
	HashSet<String> constants;
	
	public EnumSymbol(String identifier, String[] constants) {
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
	public boolean getConstantId(String identifier) {
		return constants.contains(identifier);
	}
}
