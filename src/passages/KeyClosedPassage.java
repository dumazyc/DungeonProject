package passages;

import rooms.Room;

public class KeyClosedPassage extends ClosedPassage {

	public KeyClosedPassage(String name, Room nextRoom,Room previousRoom) {
		super(name, nextRoom, previousRoom);
	}

	@Override
	public void open() {
		this.isOpen = true;
	}

}
