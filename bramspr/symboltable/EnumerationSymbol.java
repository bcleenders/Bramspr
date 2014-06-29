package bramspr.symboltable;

import java.util.HashSet;

public class EnumerationSymbol extends TypeSymbol {
	HashSet<String> values;
	
	public EnumerationSymbol(String identifier, String[] values) {
		super(identifier);

		this.values = new HashSet<String>();
		
		for (String string : values) {
			this.values.add(string);
		}
	}
	
	/**
	 * Checks whether this enum contains a constant.
	 * @param identifier the name of the constant to be checked
	 * @return true iff the enum contains this constant
	 */
	public boolean hasValue(String identifier) {
		return values.contains(identifier);
	}
}
