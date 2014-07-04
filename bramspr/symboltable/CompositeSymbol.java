package bramspr.symboltable;

import java.util.HashMap;

public class CompositeSymbol extends TypeSymbol {
	HashMap<String, TypeSymbol> fields = new HashMap<String, TypeSymbol>();
	
	/**
	 * The name it is given in JBC. For an integer, that should be "I", for example.
	 * @see <a href="http://docs.oracle.com/javase/7/docs/technotes/guides/jni/spec/types.html#wp276">the JVM docs</a>
	 */
	private String javaName;
	
	public CompositeSymbol(String javaName, String identifier, String[] fieldNames, TypeSymbol[] fieldTypes) {
		this(identifier, fieldNames, fieldTypes);
		this.javaName = javaName;
	}
	
	public CompositeSymbol(String identifier, String[] fieldNames, TypeSymbol[] fieldTypes) {
		super(identifier);
		
		for (int i = 0; fieldNames != null && i < fieldNames.length; i++) {
			this.fields.put(fieldNames[i], fieldTypes[i]);
		}
	}
	
	public String getShortIdentifier() {
		return this.javaName;
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
