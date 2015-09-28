package passages;

import rooms.Room;

public class BlockedByMonsterPassage extends ClosedPassage {

	
	public BlockedByMonsterPassage(String name, Room nextRoom,Room previousRoom) {
		super(name, nextRoom, previousRoom);
	}

	@Override
	public void open() {
		this.isOpen = true;
	}

}
