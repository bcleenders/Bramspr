package bramspr;

public class Suit {
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
}
