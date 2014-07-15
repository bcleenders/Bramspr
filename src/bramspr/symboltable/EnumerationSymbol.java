package bramspr.symboltable;

import java.util.ArrayList;

/**
 * Objects of this class are symbol table entries associated with enumerated types in a Bramspr-program.
 * 
 * On top of the information {@link TypeSymbol} already specifies, an enumerated type has values, so this class specifies the properties and methods for this
 * feature.
 * 
 * In addition, this class contains some functionality for fixing JVM naming issues.
 * 
 */
public class EnumerationSymbol extends TypeSymbol {
	/** This enumerated type's values. */
	ArrayList<String> values;

	/**
	 * 
	 * @param identifier
	 *            This enumerated type's identifier.
	 * @param values
	 *            An array with the identifiers of this enumerated type's values.
	 */
	public EnumerationSymbol(String identifier, String[] values) {
		super(identifier);

		this.values = new ArrayList<String>();

		for (String string : values) {
			this.values.add(string);
		}
	}

	/**
	 * Checks whether this enumerated type contains a certain value.
	 * 
	 * @param identifier
	 *            The identifier of the value to be checked.
	 * @return A boolean indicating whether this enumerated type contains the value in question.
	 */
	public boolean hasValue(String identifier) {
		return values.contains(identifier);
	}

	/**
	 * 
	 * 
	 * @param identifier
	 *            The field's identifier.
	 * @return The internal representation for this enumeration value.
	 */
	public int getFieldId(String identifier) {
		return values.indexOf(identifier);
	}

	/**
	 * @return The descriptor. Since enumerated types are stored as integers, that descriptor is "I".
	 */
	public String getDescriptor() {
		// Stored as integer values
		return "I";
	}
}
