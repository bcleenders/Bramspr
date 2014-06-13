package symboltable;

/*
 * Excerpted from "Language Implementation Patterns", published by The Pragmatic Bookshelf.
 */
import java.util.LinkedHashMap;
import java.util.Map;

public abstract class BaseScope implements Scope {
	Scope enclosingScope; // null if global (outermost) scope
	Map<String, Symbol> symbols = new LinkedHashMap<String, Symbol>();

	public BaseScope(Scope enclosingScope) {
		this.enclosingScope = enclosingScope;
	}

	public Symbol resolve(String signature) {
		Symbol s = symbols.get(signature);
		if (s != null)
			return s;
		// if not here, check any enclosing scope
		if (enclosingScope != null)
			return enclosingScope.resolve(signature);
		return null; // not found
	}

	/**
	 * Controleert of deze variabele in deze scope al gedeclareerd is.
	 * 
	 * @param signature de unieke signature van een variabele/functie/...
	 * @return true als de variabele in dit stuk gedeclareerd is.
	 */
	public boolean contains(String signature) {
		return symbols.containsKey(signature);
	}


	public void define(Symbol sym) {
		symbols.put(sym.toString(), sym);
		sym.scope = this; // track the scope in each symbol
	}

	public Scope getEnclosingScope() {
		return enclosingScope;
	}

	public String toString() {
		return symbols.keySet().toString();
	}
}
