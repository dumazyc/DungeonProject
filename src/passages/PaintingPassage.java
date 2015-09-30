package passages;

import rooms.Room;

public class PaintingPassage extends ClosedPassage {

	public PaintingPassage(String name, Room nextRoom, Room previousRoom) {
		super(name, nextRoom, previousRoom);
		this.isHidden = true;
	}

	@Override
	public void open() {
		System.out.println("Behind the painting, there is a door !");
		this.isOpen = true;
		this.isHidden=false;
	}

}
