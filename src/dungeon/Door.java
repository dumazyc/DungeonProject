package dungeon;

public class Door {
	protected Room room1;
	protected Room room2;
	protected State state;

	protected enum State {
		OPENED, CLOSED, HIDDEN
	};

	public Door(Room room1, Room room2, State state) {
		this.room1 = room1;
		this.room2 = room2;
		this.state = state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Room goThroughDoor(Room currentRoom) {
		if (this.state.equals(State.OPENED)) {
			if (currentRoom.equals(room1)) {
				return room2;
			} else {
				return room1;
			}
		} else {
			System.out.println("This door is closed");
			return currentRoom;
		}
	}

	public State getState() {
		return this.state;
	}
}