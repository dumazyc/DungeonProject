package dungeon;

public class Room {
	protected Room northRoom;
	protected Room southRoom;
	protected Room eastRoom;
	protected Room westRoom;
	protected String name;

	public Room(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setRooms(Room northRoom, Room southRoom, Room eastRoom,
			Room westRoom) {
		this.northRoom = northRoom;
		this.southRoom = southRoom;
		this.eastRoom = eastRoom;
		this.westRoom = westRoom;
	}

	public Room goToNorthRoom() {
		if (northRoom != null) {
			return northRoom;
		} else {
			System.out.println("No way !");
			return this;
		}
	}

	public Room goToSouthRoom() {
		if (southRoom != null) {
			return southRoom;
		} else {
			System.out.println("No way !");
			return this;
		}
	}

	public Room goToEastRoom() {
		if (eastRoom != null) {
			return eastRoom;
		} else {
			System.out.println("No way !");
			return this;
		}
	}

	public Room goToWestRoom() {
		if (westRoom != null) {
			return westRoom;
		} else {
			System.out.println("No way !");
			return this;
		}
	}

	public boolean gameIsWon() {
		return false;
	}

	public boolean gameIsLost() {
		return false;
	}

	@Override
	public String toString() {
		String response = name + " : ";
		if (northRoom != null) {
			response += northRoom.getName() + " ";
		} else {
			response += "null ";
		}
		if (southRoom != null) {
			response += southRoom.getName() + " ";
		} else {
			response += "null ";
		}
		if (eastRoom != null) {
			response += eastRoom.getName() + " ";
		} else {
			response += "null ";
		}
		if (westRoom != null) {
			response += westRoom.getName() + " ";
		} else {
			response += "null ";
		}
		return response;
	}

	public void inspect() {
		String response = "You see :\n";
		if (northRoom != null) {
			response += "  - An opened door in front of you.\n";
		}
		if (southRoom != null) {
			response += "  - An opened door behind you.\n";
		}
		if (eastRoom != null) {
			response += "  - An opened door on your right.\n";
		}
		if (westRoom != null) {
			response += "  - An opened door on your left.\n";
		}
		System.out.println(response);
	}

}
