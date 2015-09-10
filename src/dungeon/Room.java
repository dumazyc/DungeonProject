package dungeon;

public class Room {
	private Room northRoom;
	private Room southRoom;
	private Room eastRoom;
	private Room westRoom;
	private boolean gameIsWon;
	private String name;

	public Room(String name, boolean gameIsWon) {
		this.gameIsWon = gameIsWon;
	}

	public String getName() {
		return name;
	}

	public void setNorthRoom(Room northRoom) {
		this.northRoom = northRoom;
	}

	public void setSouthRoom(Room southRoom) {
		this.southRoom = southRoom;
	}

	public void setEastRoom(Room eastRoom) {
		this.eastRoom = eastRoom;
	}

	public void setWestRoom(Room westRoom) {
		this.westRoom = westRoom;
	}

	public Room goToNorthRoom() {
		if (northRoom != null) {
			return northRoom;
		} else {
			return this;
		}
	}

	public Room goToSouthRoom() {
		if (southRoom != null) {
			return northRoom;
		} else {
			return this;
		}
	}

	public Room goToEastRoom() {
		if (eastRoom != null) {
			return northRoom;
		} else {
			return this;
		}
	}

	public Room goToWestRoom() {
		if (westRoom != null) {
			return northRoom;
		} else {
			return this;
		}
	}

	public boolean gameIsWon() {
		return gameIsWon;
	}

}
