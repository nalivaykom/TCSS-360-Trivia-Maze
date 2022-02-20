import java.util.*;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class Door {
	
	private boolean permLocked;
	private boolean locked;

	Door() {
		permLocked = false;
		locked = true;
	}
	
	/*
	 * we will only ever lock the door permanently
	 * once permLocked, it can never be opened.
	 */
	protected void setPermLocked() {
		permLocked = true;
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
	
	
	public Shape setToDoor() {
		Rectangle rectangle = null;
		Image img = new Image("door.jpg");
		rectangle.setFill(new ImagePattern(img));
		return rectangle;
	}
	
}