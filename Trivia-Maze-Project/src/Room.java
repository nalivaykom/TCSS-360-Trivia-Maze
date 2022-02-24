import java.util.*;

public class Room {
    
    Door rightDoor;
    Door bottomDoor;
	
	protected Room() {
        rightDoor = new Door();
        bottomDoor = new Door();
	}

    protected Door getRightDoor() {
    	return this.rightDoor;
    }
	protected void setRightDoorPermLocked() {
		rightDoor.setPermLocked();
	}
	protected Door getBottomDoor() {
    	return this.bottomDoor;
    }
	protected void setBottomDoorPermLocked() {
		bottomDoor.setPermLocked();
	}
	
}
