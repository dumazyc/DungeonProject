package dungeon;

import java.util.Hashtable;
import java.util.Map;

public class Room {
	protected Room northRoom;
	protected Room southRoom;
	protected Room eastRoom;
	protected Room westRoom;
	protected Map<Room, State> doorStates;
	protected String name;

	protected enum State {
		OPENED, CLOSED, HIDDEN
	};

	public void enterTheRoom() {
		System.out.println("You are in " + name + ".");

	}

	public Room(String name) {
		this.name = name;
		this.doorStates = new Hashtable<Room, State>();
	}

	public State getDoorState(Room room) {
		return doorStates.get(room);
	}

	public String getName() {
		return name;
	}

	public void setDoorState(Room room, State state) {
		if (room != null) {
			doorStates.put(room, state);
			room.doorStates.put(this, state);
		}
	}

	public void setRooms(Room northRoom, Room southRoom, Room eastRoom,
			Room westRoom) {
		this.northRoom = northRoom;
		initializeRoom(this.northRoom);
		this.southRoom = southRoom;
		initializeRoom(this.southRoom);
		this.eastRoom = eastRoom;
		initializeRoom(this.eastRoom);
		this.westRoom = westRoom;
		initializeRoom(this.westRoom);
	}

	public void initializeRoom(Room room) {
		if (room != null) {
			this.doorStates.put(room, State.OPENED);
		}
	}

	protected Room goToThisRoom(Room room) {
		if (room != null && getDoorState(room) == State.OPENED) {
			if (room instanceof MonsterRoom)
				((MonsterRoom) room).setLastRoom(this);
			return room;
		} else {
			System.out.println("No way !");
			return this;
		}
	}

	public Room interpretCommand(String command) {
		switch (command) {
		case "go north":
			return goToThisRoom(this.northRoom);
		case "go west":
			return goToThisRoom(this.westRoom);
		case "go south":
			return goToThisRoom(this.southRoom);
		case "go east":
			return goToThisRoom(this.eastRoom);
		case "help":
			System.out
					.println("In a normal room, you can : \n - go north \n - go south \n - go east \n - go west \n - inspect ");
			return this;
		default:
			System.out.println("You can't do that !");
			return this;
		}
	}

	/*
	 * public Room goToNorthRoom() { if ((northRoom != null) &&
	 * (getDoorState(northRoom).equals(State.OPENED))) { return northRoom; }
	 * else { System.out.println("No way !"); return this; } }
	 * 
	 * public Room goToSouthRoom() { if (southRoom != null &&
	 * getDoorState(southRoom) == State.OPENED) { return southRoom; } else {
	 * System.out.println("No way !"); return this; } }
	 * 
	 * public Room goToEastRoom() { if (eastRoom != null &&
	 * getDoorState(eastRoom) == State.OPENED) { return eastRoom; } else {
	 * System.out.println("No way !"); return this; } }
	 * 
	 * public Room goToWestRoom() { if (westRoom != null &&
	 * getDoorState(westRoom) == State.OPENED) { return westRoom; } else {
	 * System.out.println("No way !"); return this; } }
	 */

	public boolean gameIsWon() {
		return false;
	}

	public boolean gameIsLost() {
		return false;
	}

	public void inspect() {
		String response = "You see :\n";

		if (northRoom != null) {
			response += "  - " + inspectDoor(northRoom) + " in front of you.\n";
		}
		if (southRoom != null) {
			response += "  - " + inspectDoor(southRoom) + " behind you.\n";
		}
		if (eastRoom != null) {
			response += "  - " + inspectDoor(eastRoom) + " on your right.\n";
		}
		if (westRoom != null) {
			response += "  - " + inspectDoor(westRoom) + " on your left.\n";
		}
		System.out.println(response);
	}

	public String inspectDoor(Room room) {
		if (room != null) {
			if (this.getDoorState(room) == State.OPENED) {
				return "An opened door";
			} else if (this.getDoorState(room) == State.CLOSED) {
				return "A closed door";
			} else if (this.getDoorState(room) == State.HIDDEN) {
				return "A painting";
			}
		}
		return null;
	}

}
