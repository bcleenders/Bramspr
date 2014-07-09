package bramspr.symboltable;

import java.util.HashMap;

/**
 * Objects of this class are symbol table entries associated with composite types in a Bramspr-program.
 * 
 * On top of the information {@link TypeSymbol} already specifies, a composite type has fields, so this class specifies the properties and methods for this
 * feature.
 * 
 * As built-in types are implemented as composite types, this class also defines the property {@link #primitive}, indicating whether the object in question is
 * the symbol of such a built-in type.
 * 
 * In addition, this class contains some functionality for fixing JVM naming issues.
 * 
 */
public class CompositeSymbol extends TypeSymbol {
	public HashMap<String, TypeSymbol> fields = new HashMap<String, TypeSymbol>();
	
	/** Whether this is a built-in type. */
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

	/**
	 * 
	 * @param fieldName
	 *            The field's identifier.
	 * @return A boolean indicating if this composite type contains a field with this name.
	 */
	public boolean hasField(String fieldName) {
		return this.fields.containsKey(fieldName);
	}

	/**
	 * 
	 * @param fieldName
	 *            The field's identifier.
	 * @return This field's type.
	 */
	public TypeSymbol getFieldType(String fieldName) {
		return this.fields.get(fieldName);
	}

	/**
	 * 
	 * @return The number of fields this composite type contains.
	 */
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
	 * 
	 * @return signature as used by the JVM
	 */
	public String getSignature() {
		if (this.descriptor.contains("$")) {
			return "L" + this.getDescriptor() + ";";
		} else {
			// primitive types; int etc.
			return this.getDescriptor();
		}
	}

	/**
	 * Attempt to set the descriptor of the type in the style the compiler refers to it. This is of the format outerclass$C[A-Z]+. Only sets the value if no
	 * value was set yet.
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
