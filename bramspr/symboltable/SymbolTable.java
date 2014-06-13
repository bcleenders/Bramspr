package bramspr.symboltable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;


public class SymbolTable {
	private HashMap<String, Stack<Symbol>> symbols;
	private Stack<HashSet<String>> symbolsInLevel;
	private int currentLevel;

	/**
	 * @ensures this.currentLevel() == -1
	 */
	public SymbolTable() {
		this.symbols = new HashMap<String, Stack<E>>();
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
		}

		this.currentLevel--;
	}

	/** Returns the current scope level. */
	public int currentLevel() {
		return this.currentLevel;
	}

	/**
	 * Enters an id together with an entry into this SymbolTable using the
	 * current scope level. The entry's level is set to currentLevel().
	 * 
	 * @requires id != null && id.length() > 0 && entry != null;
	 * @ensures this.retrieve(id).getLevel() == currentLevel();
	 * @throws SymbolTableException
	 *             when there is no valid current scope level, or when the id is
	 *             already declared on the current level.
	 */
	public void declare(String id, Symbol entry) throws SymbolTableException {
		if (id == null) {
			throw new SymbolTableException("Null identifiers not allowed");
		}

		if (this.currentLevel() < 0) {
			throw new SymbolTableException("Bad scope: no scope opened");
		}

		if(this.symbolsInLevel.get(this.currentLevel).contains(id)) {
			throw new SymbolTableException("Identifier already '" + id + "' contained in current scope.");
		}
		
		entry.setLevel(this.currentLevel);
		
		// Add the string to the set of identifiers in this level.
		this.symbolsInLevel.get(this.currentLevel).add(id);
		
		// Add the entry to the hashmap
		if(this.symbols.get(id) == null) {
			this.symbols.put(id, new Stack<E>());
		}
		this.symbols.get(id).add(entry);
	}

	/**
	 * Get the Entry corresponding with id whose level is the highest; in other
	 * words, that is defined last.
	 * 
	 * @return Entry of this id on the highest level null if this SymbolTable
	 *         does not contain id
	 * @throws SymbolTableException 
	 */
	public E resolve(String id) {
		Stack<E> entries = this.symbols.get(id);

		if(entries == null || entries.isEmpty()) {
			return null;
		}
		
		return entries.lastElement();
	}
}