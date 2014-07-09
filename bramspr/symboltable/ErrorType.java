package bramspr.symboltable;

import bramspr.Suit;

/**
 * This is the type of {@link Suit#ERROR}.
 * 
 * When compared to another type symbol, this type will always return {@code true}. This way, context errors don't start a chain of error reports.
 */
public class ErrorType extends TypeSymbol {

	public ErrorType() {
		super("<error type>");
	}

	/**
	 * 
	 * @param comparable
	 *            The symbol to compare this error type to.
	 * @return Whether this error type equal to the compared symbol. This is always the case if the compared symbol is a type symbol.
	 */
	public boolean equals(Object s) {
		return s instanceof TypeSymbol;
	}

	/**
	 * 
	 * @return The JVM-descriptor of this array-type.
	 */
	public String getDescriptor() {
		return "ERROR";
	}
}
