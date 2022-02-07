public class Door {
	
	private boolean permLocked;
	private boolean locked;

	public Door() {
		permLocked = false;
		locked = true;
	}
	
	public void setPermLocked(boolean thePermLocked) {
		permLocked = thePermLocked;
	}
	
	public void setLocked(boolean theLocked) {
		locked = theLocked;
	}
	
	public boolean getLockStat() {
		return locked;
	}
	
	public boolean getPermLockStat() {
		return permLocked;
	}
	
}