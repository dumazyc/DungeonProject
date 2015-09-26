package passages;

import rooms.Room;

public class KeyClosedPassage extends ClosedPassage {

	public KeyClosedPassage(String name, Room nextRoom) {
		super(name, nextRoom);
	}

	@Override
	public void open() {
		this.isOpen = true;
	}

}
