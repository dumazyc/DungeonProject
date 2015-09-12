package dungeon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Dungeon {
	protected Room currentRoom;
	protected boolean gameIsFinished = false;
	protected final Scanner scanner = new Scanner(System.in);
	protected List<Room> roomList;

	public Dungeon() {

		this.roomList = new ArrayList<Room>();
		createDungeon();
		this.currentRoom = this.roomList.get(0);
	}

	private void createDungeon() {
		roomList.add(new Room("the entrance"));
		roomList.add(new Room("an empty room"));
		roomList.add(new Room("an empty room"));
		roomList.add(new Room("a trap"));
		roomList.add(new Room("a chest room"));
		roomList.add(new Room("a chest room"));
		roomList.add(new Room("a monster room"));
		roomList.add(new Room("a button room"));
		roomList.add(new Room("the exit"));
		roomList.get(0).setRooms(roomList.get(1), null, null, null);
		roomList.get(1).setRooms(roomList.get(6), roomList.get(0), null,
				roomList.get(5));
		roomList.get(2).setRooms(roomList.get(8), roomList.get(7), null,
				roomList.get(6));
		roomList.get(3).setRooms(null, roomList.get(4), null, null);
		roomList.get(4).setRooms(roomList.get(3), roomList.get(5),
				roomList.get(6), null);
		roomList.get(5).setRooms(roomList.get(4), null, roomList.get(1), null);
		roomList.get(6).setRooms(null, roomList.get(1), roomList.get(2),
				roomList.get(4));
		roomList.get(7).setRooms(roomList.get(2), null, null, null);
		roomList.get(8).setRooms(null, roomList.get(2), null, null);

	}

	public Room getCurrentRoom() {
		return currentRoom;
	}

	public String getCurrentRoomName() {
		return currentRoom.getName();
	}

	public void interpretCommand(String command) {
		switch (command) {
		case "inspect":
			currentRoom.inspect();
			break;
		case "go north":
			currentRoom = currentRoom.goToNorthRoom();
			break;
		case "go west":
			currentRoom = currentRoom.goToWestRoom();
			break;
		case "go south":
			currentRoom = currentRoom.goToSouthRoom();
			break;
		case "go east":
			currentRoom = currentRoom.goToEastRoom();
			break;
		default:
			System.out.println("I don't know what you mean");
		}
	}

	public static void main(String[] args) {
		Dungeon dungeon = new Dungeon();
		dungeon.start();
	}

	public void start() {
		do {
			System.out.println("You are in " + getCurrentRoomName());
			System.out.println("What do you want to do?");
			System.out.print("> ");
			// Read a command from the user (stdin)
			String line = scanner.nextLine();
			interpretCommand(line);
		} while (!gameIsFinished());
		System.out.println("You are in " + getCurrentRoom());
		if (gameIsWon()) {
			System.out.println("You win!");
		} else {
			System.out.println("You loose!");
		}
	}

	public boolean gameIsFinished() {
		return gameIsLost() || gameIsWon();
	}

	public boolean gameIsLost() {
		return currentRoom.equals("a trap");
	}

	public boolean gameIsWon() {
		return currentRoom.equals("the exit");
	}
}
