package bramspr.symboltable;

/**
 * Entries in the symbol tables are all subclasses of this class.
 * 
 * Symbol-classes contain information associated with the declaration of an entity in a Bramspr-program, so that the information can be later referenced when
 * visiting an applied occurrence of such an entity.
 * 
 * The only property that all types of symbols share, is an identifier. Therefore, it is the only field of this class.
 * 
 */
public abstract class Symbol {
	/** This symbol's identifier. */
	private String identifier;

	public Symbol(String identifier) {
		this.identifier = identifier;
	}

	/** @return {@link #identifier} */
	public String getIdentifier() {
		return this.identifier;
	}

	public String toString() {
		return getIdentifier();
	}
}
