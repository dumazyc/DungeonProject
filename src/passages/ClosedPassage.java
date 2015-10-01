package passages;

import rooms.Room;

public  class ClosedPassage extends Passage {

	public ClosedPassage(String name, Room nextRoom,Room previousRoom) {
		super(name, nextRoom,previousRoom);
		this.isOpen = false;
	}
}
