package inventory;

import rooms.Room;

public class Potion extends Item {
	
	protected int hPRestoreNumber;

	public Potion(String name, int hPRestoreNumber) {
		super(name);
		this.hPRestoreNumber = hPRestoreNumber;
	}

	@Override
	public void use(Room room) {
		room.getPlayer().heal(hPRestoreNumber);
	}
}
