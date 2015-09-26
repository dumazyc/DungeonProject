package passages;

import rooms.Room;

public class ButtonClosedPassage extends ClosedPassage {

	public ButtonClosedPassage(String name, Room nextRoom) {
		super(name, nextRoom);
	}

	@Override
	public void open() {
		this.isOpen = true;
	}

}