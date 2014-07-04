package bramspr.symboltable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class SymbolTable<S extends Symbol> {
	private HashMap<String, Stack<S>> symbols;
	private Stack<HashSet<String>> symbolsInLevel;
	private int currentLevel;
	
	/**
	 * Number of elements contained in the scope.
	 */
	private int size = 0;

	/**
	 * @ensures this.currentLevel() == -1
	 */
	public SymbolTable() {
		this.symbols = new HashMap<String, Stack<S>>();
		this.symbolsInLevel = new Stack<HashSet<String>>();
		this.currentLevel = -1;
	}

	/**
	 * Opens a new scope.
	 * 
	 * @ensures this.currentLevel() == old.currentLevel()+1;
	 */
	public void openScope() {
		this.currentLevel++;
		
		// Initialize a new hashmap to store vars in the current scope.
		this.symbolsInLevel.add(new HashSet<String>());
	}

	/**
	 * Closes the current scope. All identifiers in the current scope will be
	 * removed from the SymbolTable.
	 * 
	 * @requires old.currentLevel() > -1;
	 * @ensures this.currentLevel() == old.currentLevel()-1;
	 */
	public void closeScope() {
		HashSet<String> currentlyPopped = this.symbolsInLevel.pop();
		
		for(String currentElement : currentlyPopped) {
			this.symbols.get(currentElement).pop();
			
			// Een element verwijderd; size wordt kleiner
			this.size--;
		}

		this.currentLevel--;
	}

	/** Returns the current scope level. */
	public int currentLevel() {
		return this.currentLevel;
	}
	
	public int getSize() {
		return this.size;
	}

	/**
	 * Enters an id together with an entry into this SymbolTable using the
	 * current scope level. The entry's level is set to currentLevel().
	 * 
	 * @requires id != null && id.length() > 0 && entry != null;
	 * @ensures this.retrieve(id).getLevel() == currentLevel();
	 * @ensures this.getSize() = old.getSize() + 1;
	 * @throws SymbolTableException
	 *             when there is no valid current scope level, or when the id is
	 *             already declared on the current level.
	 */
	public void declare(S symbol) throws SymbolTableException {
		if (symbol == null) {
			throw new SymbolTableException("Null symbols not allowed");
		}

		if (this.currentLevel() < 0) {
			throw new SymbolTableException("Bad scope: no scope opened");
		}
		
		String signature = symbol.toString();

		if(this.symbolsInLevel.get(this.currentLevel).contains(symbol.toString())) {
			throw new SymbolTableException("Identifier '" + signature + "' is already declared in current scope.");
		}
		
		// Add the string to the set of identifiers in this level.
		this.symbolsInLevel.get(this.currentLevel).add(signature);
		
		// Add the entry to the hashmap
		if(this.symbols.get(signature) == null) {
			this.symbols.put(signature, new Stack<S>());
		}
		this.symbols.get(signature).add(symbol);
		
		// Nummertjes bijhouden! Dit is het "id" van ieder symbol op een moment.
		symbol.setNumber(this.getSize());
		this.size++;
	}

	/**
	 * Get the Entry corresponding with id whose level is the highest; in other
	 * words, that is defined last.
	 * 
	 * @return Entry of this id on the highest level null if this SymbolTable
	 *         does not contain id
	 * @throws SymbolTableException 
	 */
	public S resolve(String id) {
		Stack<S> entries = this.symbols.get(id);

		if(entries == null || entries.isEmpty()) {
			return null;
		}
		
		return entries.lastElement();
	}
}