package spaceandpens.Modeles;


public class LockedDoor extends Door {

	private boolean isLocked;

	public LockedDoor(Map dest){
		this.destination = dest;
		this.isLocked = true;
	}

	public boolean isLocked(){
		return this.isLocked;
	}

	//public void unlock() { this.isLocked = false; }

}