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
	
	/**
	 * The name it is given in JBC. For an integer, that should be "I", for example.
	 * @see <a href="http://docs.oracle.com/javase/7/docs/technotes/guides/jni/spec/types.html#wp276">the JVM docs</a>
	 */
	public String internalIdentifier;

	public TypeSymbol(String identifier, String internalIdentifier) {
		super(identifier);
		this.internalIdentifier = internalIdentifier;
	}
	
	public String getInternalIdentifier() {
		return this.internalIdentifier;
	}
}
