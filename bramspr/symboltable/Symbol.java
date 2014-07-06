package bramspr.symboltable;

/**
 * Entries in the symbol tables are all subclasses of this abstract class.
 * 
 * Symbol-classes contain information associated with the declaration of an entity in a Bramspr-program, so that the information can be later referenced when
 * visiting an applied occurrence of such an entity.
 * 
 * The only property that all types of symbols share, is an identifier. Therefore, it is the only field of this abstract class.
 * 
 */
public abstract class Symbol {
	/** This symbol's identifier. */
	private String identifier;
	
	/** This symbol's id (size of the symboltable at the time of declaration) */
	protected int number;
	
	public Symbol(String identifier) {
		this.identifier = identifier;
	}
		
	/** Set the number of this symbol (should be done by SymbolTable only) */
	public void setNumber(int symNumber) {
		this.number = symNumber;
	}
	
	/** @return {@link #number} */
	public int getNumber() {
		return this.number;
	}
	
	/** @return {@link #identifier} */
	public String getIdentifier() {
		return this.identifier;
	}

	public String toString() {
		return getIdentifier();
	}
}
