package passages;

import rooms.Room;

public class PaintingPassage extends ClosedPassage {

	public PaintingPassage(String name, Room nextRoom) {
		super(name, nextRoom);
	}

	@Override
	public void open() {
		System.out.println("Behind the painting, there is a door !");
		this.isOpen = true;
	}

}
