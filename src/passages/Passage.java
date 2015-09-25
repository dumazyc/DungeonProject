package passages;

import rooms.Room;

public class Passage {
	protected Room nextRoom;
	protected boolean isOpen;
	
	public boolean canPassThrough() {
		return isOpen;
	}

	public Room getNextRoom() {
		return nextRoom;
	}
}