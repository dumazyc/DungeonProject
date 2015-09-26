package passages;

import rooms.Room;

public abstract class ClosedPassage extends Passage {

	public ClosedPassage(String name, Room nextRoom) {
		super(name, nextRoom);
		this.isOpen = false;
	}
}
