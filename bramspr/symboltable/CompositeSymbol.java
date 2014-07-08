package bramspr.symboltable;

import java.util.HashMap;

public class CompositeSymbol extends TypeSymbol {
	HashMap<String, TypeSymbol> fields = new HashMap<String, TypeSymbol>();

	/**
	 * The name of the symbol after compiling. This is something like "CA", "CB", etc.
	 */
	public String internalName;

	public CompositeSymbol(String internalName, String identifier, String[] fieldNames, TypeSymbol[] fieldTypes) {
		this(identifier, fieldNames, fieldTypes);
		this.internalName = internalName;
	}

	public CompositeSymbol(String identifier, String[] fieldNames, TypeSymbol[] fieldTypes) {
		super(identifier);

		for (int i = 0; fieldNames != null && i < fieldNames.length; i++) {
			this.fields.put(fieldNames[i], fieldTypes[i]);
		}
	}

	public String getShortIdentifier() {
		return this.internalName;
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

	/**
	 * Returns the name of the class as it is called in the filesystem (excl. extension)
	 * 
	 * @param outerClassName
	 *            the name of the containing class
	 * @return outerClassname + "$" + this.compiledName
	 */
	public String getClassName(String outerClassName) {
		return outerClassName + "$" + this.internalName;
	}

	/**
	 * Attempt to set and get the name of the type in the style the compiler refers to it. This is of the format "C[A-Z]+". Only sets the value if no value was set yet.
	 * 
	 * @param number
	 *            the identifier of the type, must be unique for every type.
	 * @return the name of this type
	 */
	public String getInteralName(int number) {
		if (this.internalName == null) {
			this.internalName = this.i2s(number);
		}
		return this.internalName;
	}

	/**
	 * Converts numbers to Strings. The format is "CA", "CB" ... "CZ", "CAA", "CAB", etc.
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

		output = "C" + output;

		return output;
	}
}
