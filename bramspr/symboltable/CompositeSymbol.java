package bramspr.symboltable;

import java.util.HashMap;

public class CompositeSymbol extends TypeSymbol {
	HashMap<String, TypeSymbol> fields = new HashMap<String, TypeSymbol>();
	
	public CompositeSymbol(String identifier, String[] fieldNames, TypeSymbol[] fieldTypes) {
		super(identifier);
		
		for (int i = 0; fieldNames != null && i < fieldNames.length; i++) {
			this.fields.put(fieldNames[i], fieldTypes[i]);
		}
	}
	
	public boolean hasField(String fieldName) {
		return this.fields.containsKey(fieldName);
	}
	
	public TypeSymbol getFieldType(String fieldName) {
		return this.fields.get(fieldName);
	}
	
	public int getNumberOfFields() {
		return fields.size();
	}
}
