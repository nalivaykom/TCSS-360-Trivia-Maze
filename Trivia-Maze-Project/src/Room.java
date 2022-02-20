import java.util.*;

public class Room {
    
	Door topDoor;
	Door leftDoor;
    Door rightDoor;
    Door bottomDoor;
	
	protected Room() {
        topDoor = new Door();;
		leftDoor = new Door();
        rightDoor = new Door();
        bottomDoor = new Door();
	}
	
	protected void setTopDoorPermLocked() {
		topDoor.setPermLocked();
	}   
	protected void setLeftDoorPermLocked() {
		leftDoor.setPermLocked();
	}
	protected void setRightDoorPermLocked() {
		rightDoor.setPermLocked();
	}
	protected void setBottomDoorPermLocked() {
		bottomDoor.setPermLocked();
	}

}
