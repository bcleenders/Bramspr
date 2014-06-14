package bramspr;

public class Suit {
	public static final Suit VOID = new Suit("void", false);
	
	/**
	 * The String representation of this type.
	 * E.g. "int", "bool", "Stoel"...
	 */
	public String type;
	
	/**
	 * Whether or not this variable is mutable.
	 * For example:
	 * 	- s.aantalPoten is mutable (s is an instance of record Stoel)
	 * 	- foo() is not mutable.
	 */
	public Boolean isMutable;
	
	public Suit(String type, Boolean isMutable) {
		this.type = type;
		this.isMutable = isMutable;
	}
}
