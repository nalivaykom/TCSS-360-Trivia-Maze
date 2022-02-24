import java.util.*;


import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class Door {
	
	private boolean permLocked;
	private boolean locked;
	private Rectangle rectangle = new Rectangle(15,30);
	private Question_Answer qA;

	Door() {
		permLocked = false;
		locked = true;
		rectangle = setToDoor();
		qA = new Question_Answer();
	}
	
	/*
	 * we will only ever lock the door permanently
	 * once permLocked, it can never be opened.
	 */
	protected void setPermLocked() {
		permLocked = true;
		this.rectangle = setToLock();
	}
	
	protected void setLocked(boolean theLocked) {
		locked = theLocked;
	}
	
	protected boolean getLockStat() {
		return locked;
	}
	
	protected boolean getPermLockStat() {
		return permLocked;
	}
	
	protected Shape getShape() {
		return this.rectangle;
	}
	
	private Rectangle setToDoor() {
		Image img = new Image("door.jpg");
		this.rectangle.setFill(new ImagePattern(img));
		return this.rectangle;
	}
	
	private Rectangle setToLock() {
		Image img = new Image("Lock.jpg");
		this.rectangle.setFill(new ImagePattern(img));
		return this.rectangle;
	}
	protected Question_Answer getQuestion_Answer() {
		return this.qA;
	}
}