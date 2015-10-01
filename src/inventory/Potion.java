package inventory;

import rooms.Room;

public class Potion extends Item {
	
	protected int hPRestoreNumber;

	public Potion(String name, int hPRestoreNumber) {
		super(name);
		this.hPRestoreNumber = hPRestoreNumber;
	}

	@Override
	public boolean use(Room room) {
		System.out.println("You have won "+hPRestoreNumber+" HPs !");
		room.getPlayer().heal(hPRestoreNumber);
		return true;
	}
}
