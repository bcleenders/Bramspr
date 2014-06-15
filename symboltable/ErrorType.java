package symboltable;

/**
 * Error type
 * @author bram
 * Bij een foutieve expressie waarbij het type niet achterhaald kan worden, kan dit object terug worden gegeven.
 * Dit object lijkt gelijk aan alle andere TypeSymbol's, dus een volgende functie die dit object binnenkrijgt zal dit als geldig argument zien.
 * 
 * Doordat het ErrorType een soort generiek TypeSymbol is, zal het nooit zo zijn dat één foutieve expression een kettingreactie veroorzaakt.
 */
public class ErrorType extends TypeSymbol {
	
	public ErrorType() {
		super("<error type>");
	}
	
	/**
	 * @param s het object waarmee vergeleken wordt.
	 * @ensure this.equals(s) is true als s een TypeSymbol (i.e. RecordSymbol, ArraySymbol of EnumSymbol) is.
	 */
	public boolean equals(Object s) {
		return s instanceof TypeSymbol;
	}
}
