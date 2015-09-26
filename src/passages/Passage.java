package passages;

import rooms.Room;

public class Passage {
	protected String name;
	protected Room nextRoom;
	protected boolean isOpen;
	
	public Passage(String name, Room nextRoom) {
		this.name = name;
		this.nextRoom = nextRoom;
		this.isOpen = true;
	}

	public boolean canPassThrough() {
		return isOpen;
	}

	public Room getNextRoom() {
		return nextRoom;
	}

	public String inspect() {
		return name;
	}
}