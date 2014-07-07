package bramspr.symboltable;

import org.objectweb.asm.Label;

/**
 * Objects of this class are symbol table entries associated with variables in a Bramspr-program.
 * 
 * Since all information we want to keep about variables is already specified in {@link ValueYielderSymbol}, this class is nothing more than a concrete subclass
 * of that abstract class.
 * 
 */
public class VariableSymbol extends ValueYielderSymbol {

	public VariableSymbol(String identifier, TypeSymbol returnType, boolean isConstant) {
		super(identifier, returnType, isConstant);
	}

	public String toString() {
		return this.getIdentifier();
	}
	
	/** This symbol's memory address (set on declaration, in Compiler) */
	private int memAddr;
	
	/** Set the memory location of this symbol */
	public void setMemAddr(int memAddr) {
		this.memAddr = memAddr;
	}
	
	/** Get the memory location of this symbol */
	public int getMemAddr() {
		return this.memAddr;
	}
	
	/**
	 * A label marking the start of this variable's scope.
	 * This label is unique; if a variable is declared halfway a scope, the variable's scope is only half the surrounding scope.
	 */
	public Label openingLabel;
	/**
	 * A label marking the end of this variable's scope.
	 * This label can be shared with other variables, if they are declared in the same scope.
	 */
	public Label closingLabel;

	/** 
	 * De opening en closing label worden gebruikt om in assembly aan te geven wat de scope van deze variabele is.
	 * @param openingLabel
	 * @param closingLabel
	 */
	public void setOpenCloseLabels(Label openingLabel, Label closingLabel) {
		this.openingLabel = openingLabel;
		this.closingLabel = closingLabel;
	}
}
