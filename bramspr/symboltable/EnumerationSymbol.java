package bramspr.symboltable;

import java.util.ArrayList;

public class EnumerationSymbol extends TypeSymbol {
	ArrayList<String> values;
	
	public EnumerationSymbol(String identifier, String[] values) {
		super(identifier);

		this.values = new ArrayList<String>();
		
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
	
	/**
	 * Gives back a number for a field
	 * @param identifier String representation of the field
	 * @ensures getFieldId(s1) = getFieldId(s2) if and only if s1 = s2 
	 * @return an id of the field
	 */
	public int getFieldId(String identifier) {
		return values.indexOf(identifier);
	}
	
	/**
	 * Returns the descriptor. Since enums are stored as integers, that descriptor is "I"
	 */
	public String getDescriptor() {
		// Stored as integer values
		return "I";
	}
}
