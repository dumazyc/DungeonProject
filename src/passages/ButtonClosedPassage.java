package passages;

import rooms.Room;

public class ButtonClosedPassage extends ClosedPassage {

	public ButtonClosedPassage(String name, Room nextRoom,Room previousRoom) {
		super(name, nextRoom, previousRoom);
	}

	@Override
	public void open() {
		this.isOpen = true;
	}

}
