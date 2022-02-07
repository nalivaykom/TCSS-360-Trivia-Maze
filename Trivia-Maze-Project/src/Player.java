public class Player {
	
	String name;
	int row;
	int column;
	
	Player(String theName, int theRow, int theColumn) {
		name = theName;
		this.row = theRow;
		this.column = theColumn;
	}
	
	protected void setName(String theName) {
		name = theName;
	}
	
	protected void setRow(int theRow) {
		row = theRow;
	}
	
	protected int getRow() {
		return this.row;
	}
	
	protected int getColumn() {
		return this.column;
	}
}
