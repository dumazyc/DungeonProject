package passages;

import rooms.Room;

public class Passage {
	protected String name;
	protected Room nextRoom;
	protected boolean isOpen;
	protected boolean isHidden;
	
	public Passage(String name, Room nextRoom) {
		this.name = name;
		this.nextRoom = nextRoom;
		this.isOpen = true;
		this.isHidden = false;
	}

	public boolean canPassThrough() {
		return isOpen;
	}

	public Room getNextRoom() {
		return nextRoom;
	}

	public String inspect() {
		return name+" to "+nextRoom.getName();
	}
	
	public void open() {}

	public boolean isHidden() {
		return isHidden;
	}

	public String getName() {
		return name;
	}
}