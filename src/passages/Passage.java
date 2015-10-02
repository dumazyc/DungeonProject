package passages;

import rooms.Room;

public class Passage {
	protected String name;
	protected Room previousRoom;
	protected Room nextRoom;
	protected boolean isOpen;
	protected boolean isHidden;

	public Passage(String name, Room previousRoom, Room nextRoom) {
		this.name = name;
		this.previousRoom = previousRoom;
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
		return name;
	}

	public void open() {
		isOpen = true;

	}

	public boolean isHidden() {
		return isHidden;
	}

	public String getName() {
		return name;
	}
}