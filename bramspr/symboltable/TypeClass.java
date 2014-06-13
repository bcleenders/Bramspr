package bramspr.symboltable;

public enum TypeClass {
	ENUM('e'),
	VARIABLE('v'),
	TYPE('t'),
	FUNCTION('f'),
	ARRAY('a');
	
	public char firstChar;
	
	TypeClass(char firstChar) {
		this.firstChar = firstChar;
	}
}