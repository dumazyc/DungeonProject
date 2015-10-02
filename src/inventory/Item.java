package inventory;

import rooms.Room;

public abstract class Item {
	protected String name;

	public Item(String name) {
		this.name = name;
	}

	public abstract boolean use(Room currentRoom);

	public String getName() {
		return name;
	}
}
