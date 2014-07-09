package bramspr.symboltable;

/**
 * This class implements a symbol table. It is used to keep track of declared variables, enumerated types, composite types and functions.
 */
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class SymbolTable<S extends Symbol> {
	/** A collection containing all declared symbols. */
	private HashMap<String, Stack<S>> symbols;

	/** A collection containing all symbols in a certain level, for closing scopes efficiently. */
	private Stack<HashSet<String>> symbolsInLevel;

	/** The level of the current scope we are in. */
	private int currentLevel;

	public SymbolTable() {
		this.symbols = new HashMap<String, Stack<S>>();
		this.symbolsInLevel = new Stack<HashSet<String>>();
		this.currentLevel = -1;
	}

	/** Opens a new scope. */
	public void openScope() {
		this.currentLevel++;

		// Initialize a new hashmap to store vars in the current scope.
		this.symbolsInLevel.add(new HashSet<String>());
	}

	/**
	 * Closes the current scope. All symbols in the current scope will be removed from the symbol table.
	 */
	public void closeScope() {
		HashSet<String> currentlyPopped = this.symbolsInLevel.pop();

		for (String currentElement : currentlyPopped) {
			this.symbols.get(currentElement).pop();
		}

		this.currentLevel--;
	}

	/**
	 * Enters a symbol together with an entry into this symbol table using the current scope level. The entry's level is set to {@link #currentLevel}.
	 * 
	 * @throws SymbolTableException
	 *             When there is no valid current scope level, or when this symbol is already declared on the current level.
	 */
	public void declare(S symbol) throws SymbolTableException {
		if (symbol == null) {
			throw new SymbolTableException("Null symbols not allowed");
		}

		if (this.currentLevel < 0) {
			throw new SymbolTableException("Bad scope: no scope opened");
		}

		String signature = symbol.toString();

		if (this.symbolsInLevel.get(this.currentLevel).contains(symbol.toString())) {
			throw new SymbolTableException("Identifier '" + signature + "' is already declared in current scope.");
		}

		// Add the string to the set of identifiers in this level.
		this.symbolsInLevel.get(this.currentLevel).add(signature);

		// Add the entry to the hashmap
		if (this.symbols.get(signature) == null) {
			this.symbols.put(signature, new Stack<S>());
		}
		this.symbols.get(signature).add(symbol);
	}

	/**
	 * Get the {@link Symbol}-object matching a certain identifier / function signature whose level is the highest; in other words, that is declared most
	 * recently.
	 * 
	 * @return The latest symbol matching this identifier / function signature. {@code null} if the symbol table does not contain this symbol.
	 * @param id
	 *            The identifier / function signature to be resolved.
	 * @throws SymbolTableException
	 */
	public S resolve(String id) {
		Stack<S> entries = this.symbols.get(id);

		if (entries == null || entries.isEmpty()) {
			return null;
		}

		return entries.lastElement();
	}
}