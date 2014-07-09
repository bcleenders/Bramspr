package bramspr.symboltable;

import java.util.HashMap;

public class CompositeSymbol extends TypeSymbol {
	public HashMap<String, TypeSymbol> fields = new HashMap<String, TypeSymbol>();
	boolean primitive = false;

	/**
	 * The name of the symbol after compiling. This is something like "CA", "CB", etc.
	 */
	public String descriptor;

	public CompositeSymbol(String internalName, String identifier, String[] fieldNames, TypeSymbol[] fieldTypes) {
		this(identifier, fieldNames, fieldTypes);
		this.descriptor = internalName;
		primitive = true;
	}

	public CompositeSymbol(String identifier, String[] fieldNames, TypeSymbol[] fieldTypes) {
		super(identifier);

		for (int i = 0; fieldNames != null && i < fieldNames.length; i++) {
			this.fields.put(fieldNames[i], fieldTypes[i]);
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

	/**
	 * Returns the name of the class as it is called in Java and the filesystem (excl. extension).
	 * 
	 * Examples: "composite$CA", or "I"
	 * 
	 * @param outerClassName
	 *            the name of the containing class
	 */
	public String getDescriptor() {
		return this.descriptor;
	}
	
	/**
	 * Returns the signature, e.g. "Ljava/lang/String;", "Lcomposite$CA;", "I" or "Z"
	 * @return signature as used by the JVM
	 */
	public String getSignature() {
		if(this.descriptor.contains("$")) {
			return "L" + this.getDescriptor() + ";";
		} else {
			// primitive types; int etc.
			return this.getDescriptor();
		}
	}

	/**
	 * Attempt to set the descriptor of the type in the style the compiler refers to it. This is of the format outerclass$C[A-Z]+. Only sets the value if no value was
	 * set yet.
	 * 
	 * @param number
	 *            the identifier of the type, must be unique for every type.
	 * @return the inner class name of this type
	 */
	public String setDescriptor(String outerClassName, int number) {
		if (this.descriptor == null) {
			this.descriptor = outerClassName + "$" + this.i2s(number);
			return this.i2s(number);
		}
		return null;
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
