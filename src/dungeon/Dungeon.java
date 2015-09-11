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
		roomList.add(new Room("entrance"));
		roomList.add(new Room("empty"));
		roomList.add(new Room("trap"));
		roomList.add(new Room("exit"));
	}

	public Room getCurrentRoom() {
		return currentRoom;
	}

	public String getCurrentRoomName() {
		return currentRoom.getName();
	}

	public void interpretCommand(String command) {
		switch (command) {
		case "go north":
			currentRoom = currentRoom.goToNorthRoom();
			break;
		case "go west":
			currentRoom = currentRoom.goToWestRoom();
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
		return currentRoom.equals("trap");
	}

	public boolean gameIsWon() {
		return currentRoom.equals("exit");
	}
}
