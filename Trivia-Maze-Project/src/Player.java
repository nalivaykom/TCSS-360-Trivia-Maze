public class Player {
	
	String name;
	int row;
	int column;
	
	Player(String theName, int theRow, int theColumn) {
		name = theName;
		this.row = theRow;
		this.column = theColumn;
	}
	
	public void setName(String theName) {
		name = theName;
	}
	
	public void setRow(int theRow) {
		row = theRow;
	}
	
	public int getRow() {
		return this.row;
	}
	
	public int getColumn() {
		return this.column;
	}
}
