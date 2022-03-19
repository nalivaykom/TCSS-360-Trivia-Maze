public class Room {
    
    private Door myRightDoor;
    private Door myBottomDoor;
	
	Room() {
        myRightDoor = new Door();
        myBottomDoor = new Door();
	}

    Door getRightDoor() {
    	return myRightDoor;
    }
	void setRightDoorPermLocked(boolean theBool) {
		myRightDoor.setPermLocked(theBool);
	}
	Door getBottomDoor() {
    	return myBottomDoor;
    }
	void setBottomDoorPermLocked(boolean theBool) {
		myBottomDoor.setPermLocked(theBool);
	}
	
}
