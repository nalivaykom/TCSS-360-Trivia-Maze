import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

public class Player {
	
	String myName;
	int myRow;
	int myColumn;
	
	final Circle myCircle = new Circle(0,0,10);
	final Text myText = new Text ();
	static StackPane myPlayerShape;
	
	Player (String theName, int theRow, int theColumn) {
		myPlayerShape = new StackPane();
		
		myName = theName;
		myRow = theRow;
		myColumn = theColumn;
		
		myCircle.setFill(Color.TAN);
		myText.setText(theName);
		myPlayerShape.getChildren().addAll(myCircle, myText);
		myPlayerShape.setVisible(true);
	}
	
	void setName(String theName) {
		myName = theName;
		myText.setText(myName);
		myPlayerShape = new StackPane();
		myPlayerShape.getChildren().addAll(myCircle, myText);
		myPlayerShape.setVisible(true);
	}
	
	void setRow(int theRow) {
		myRow = theRow;
	}
	
	void setColumn(int theColumn) {
		myColumn = theColumn;
	}
	
	int getRow() {
		return myRow;
	}
	
	int getColumn() {
		return myColumn;
	}
	
	StackPane getShape() {
		return myPlayerShape;
	}
	
	String getName() {
		return myName;
	}
}
