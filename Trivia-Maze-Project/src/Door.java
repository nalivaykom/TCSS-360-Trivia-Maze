import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class Door {
	
	private boolean myPermLocked;
	private Rectangle myRectangle = new Rectangle(15,30);
	private Question_Answer myQA;

	Door() {
		myPermLocked = false;
		myRectangle = setToDoor();
		myQA = new Question_Answer();
	}
	
	void setPermLocked(boolean theBool) {
		myPermLocked = theBool;
		if (theBool) {
			myRectangle = setToLock();
		}
		if (!theBool) {
			myRectangle = setToDoor();
		}
	}
	
	boolean getPermLockStat() {
		return myPermLocked;
	}
	
	Shape getShape() {
		return myRectangle;
	}
	
	Question_Answer getQuestion_Answer() {
		return myQA;
	}
	
	private Rectangle setToDoor() {
		Image img = new Image("door.jpg");
		myRectangle.setFill(new ImagePattern(img));
		return myRectangle;
	}
	
	private Rectangle setToLock() {
		Image img = new Image("Lock.jpg");
		myRectangle.setFill(new ImagePattern(img));
		return myRectangle;
	}
}