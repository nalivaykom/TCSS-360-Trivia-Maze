import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

public class Player {
	
	String name;
	int row;
	int column;
	
	final Circle circle = new Circle(0,0,10);
	final Text text = new Text ();
	final static StackPane myPlayerShape = new StackPane();
	
	
	Player(String theName, int theRow, int theColumn) {
		name = theName;
		this.row = theRow;
		this.column = theColumn;
		
		circle.setFill(Color.BLUE);
		text.setText(theName);
		myPlayerShape.getChildren().addAll(circle, text);
		myPlayerShape.setVisible(true);
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
	
	protected static StackPane getShape() {
		return myPlayerShape;
		
	}
}
