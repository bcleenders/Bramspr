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
	
	abstract public String getDescriptor();
}
