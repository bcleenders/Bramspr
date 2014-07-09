package bramspr.symboltable;

/**
 * Symbol table entries associated with types in a Bramspr-program are all subclasses of this abstract class.
 * 
 * These entities are array types (see {@link ArraySymbol}), composite types (see {@link CompositeSymbol}) and enumerated types (see {@link EnumerationSymbol}).
 * 
 * They don't share certain information apart from what is already specified in {@link Symbol}, this class is nothing more than an empty subclass of that class.
 * 
 */
public abstract class TypeSymbol extends Symbol {

	public TypeSymbol(String identifier) {
		super(identifier);
	}
	
	/**
	 * Returns the descriptor of this type. Is often the same as the signature, but for JVM Objects the signature starts with L and ends with ;. The descriptor does not.
	 * @return String representation of descriptor.
	 */
	abstract public String getDescriptor();
	
	/**
	 * Returns the signature of a type. E.g. "Z" (boolean), "[I" (integer array), "Ljava/lang/String;" (string) or "Bramspr$CA" (user defined type)
	 * @return String representation of the type.
	 */
	public String getSignature() {
		return getDescriptor();
	}
}
