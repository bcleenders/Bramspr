package bramspr.symboltable;

public class Entry {
	private int level = -1;
	
	private String type;
	
	/**
	 * 
	 * @param type het type van deze entry, e.g. "integer" of "enum days" of "chair" (=record)
	 */
	public Entry(String type) {
		this.type = type;
	}
	
	public String getType() {
		return this.type;
	}

	public int getLevel() {
		return this.level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
}
