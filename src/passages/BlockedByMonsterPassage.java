package passages;

import rooms.Room;

public class BlockedByMonsterPassage extends ClosedPassage {

	
	public BlockedByMonsterPassage(String name, Room nextRoom) {
		super(name, nextRoom);
	}

	@Override
	public void open() {
		this.isOpen = true;
	}

}
