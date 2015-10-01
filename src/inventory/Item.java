package inventory;

import rooms.Room;

public abstract class Item {
	String name;

	public abstract void use(Room currentRoom);
}
