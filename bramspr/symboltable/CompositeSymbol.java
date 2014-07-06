package bramspr.symboltable;

import java.util.ArrayList;
import java.util.HashMap;

public class CompositeSymbol extends TypeSymbol {
	HashMap<String, TypeSymbol> fields = new HashMap<String, TypeSymbol>();
	ArrayList<String> fieldNames = new ArrayList<String>();

	public CompositeSymbol(String canonicalName, String[] fieldNames, TypeSymbol[] fieldTypes) {
		super(canonicalName, null);

		for (int i = 0; fieldNames != null && i < fieldNames.length; i++) {
			this.fields.put(fieldNames[i], fieldTypes[i]);
			this.fieldNames.add(fieldNames[i]);
		}
	}

	/**
	 * This one is used for the primitive types: they have special Java identifiers (e.g. "I" for integers)
	 * 
	 * @param internalIdentifier
	 * @param canonicalName
	 * @param fieldNames
	 * @param fieldTypes
	 */
	public CompositeSymbol(String internalIdentifier, String canonicalName, String[] fieldNames, TypeSymbol[] fieldTypes) {
		this(canonicalName, fieldNames, fieldTypes);
		super.internalIdentifier = internalIdentifier;
	}

	@Override
	public void setNumber(int number) {
		super.setNumber(number);

		if (super.internalIdentifier == null) {
			super.internalIdentifier = "C" + i2s(number);
		}
	}

	public boolean hasField(String fieldName) {
		return this.fields.containsKey(fieldName);
	}

	public TypeSymbol getFieldType(String fieldName) {
		return this.fields.get(fieldName);
	}

	public int getNumberOfFields() {
		return fields.size();
	}

	public String getInternalFieldName(String canonicalFieldName) {
		return this.i2s(this.fieldNames.indexOf(canonicalFieldName));
	}

	/**
	 * Converts numbers to Strings.
	 * 
	 * @requires number >= 0
	 * @ensures i2s(x) = i2s(y) iff x = y
	 */
	private String i2s(int number) {
		if (number < 0) {
			System.err.println("Invalid range: negative number");
			return null;
		}

		String output = "";

		boolean firstPass = true;
		while (firstPass || number > 0) { // a = 1 -> z=26
			int remainder = number % 26;
			number = (number - remainder) / 26;
			output = Character.toString((char) (remainder + 'A')) + output;

			firstPass = false;
		}

		return output;
	}
}
