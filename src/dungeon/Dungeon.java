package dungeon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Represents a dungeon
 * A dungeon has an entrance and many rooms
 */
public class Dungeon {
	
	/**
	 * The room in which the player is
	 */
	protected Room currentRoom;
	
	/**
	 * Says if the game is finished or not
	 */
	protected boolean gameIsFinished = false;
	
	/**
	 * Used to catch the player's commands
	 */
	protected final Scanner scanner = new Scanner(System.in);
	
	/**
	 * The list which contains the different rooms of the dungeon
	 */
	protected List<Room> roomList;

	/**
	 * The player
	 */
	protected Player player;
	
	/**
	 * Creates a new dungeon and defines the currentRoom
	 * The currentRoom is where the player begin
	 */
	public Dungeon() {

		this.roomList = new ArrayList<Room>();
		createDungeon();
		this.currentRoom = this.roomList.get(0);
		this.player = new Player();
	}
	
	/**
	 * Defines the different rooms and associates them
	 */
	private void createDungeon() {
		roomList.add(new Room("the entrance"));
		roomList.add(new Room("an empty room"));
		roomList.add(new Room("an empty room"));
		roomList.add(new TrapRoom("a trap"));
		roomList.add(new Room("a chest room"));
		roomList.add(new Room("a chest room"));
		roomList.add(new Room("a monster room"));
		roomList.add(new Room("a button room"));
		roomList.add(new ExitRoom("the exit"));
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
	
	/**
	 * Gets the current room
	 * @return this current room
	 */
	public Room getCurrentRoom() {
		return currentRoom;
	}

	/**
	 * Gets the current room's name
	 * @return this current room's name
	 */
	public String getCurrentRoomName() {
		return currentRoom.getName();
	}

	/**
	 * Interprets the command typed by the player
	 * @param command
	 */
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
	
	/**
	 * Begins the interaction with the player
	 * Gives current room's name and asks for a command
	 */
	public void start() {
		System.out.println("What is you name sir ?");
		player.setName(scanner.nextLine());
		System.out.println("Welcome, "+player.getName());
		
		do {
			System.out.println("You are in " + getCurrentRoomName());
			System.out.println("What do you want to do?");
			System.out.print("> ");
			// Read a command from the user (stdin)
			String line = scanner.nextLine();
			interpretCommand(line);
		} while (!gameIsFinished());
		System.out.println("You are in " + getCurrentRoomName());
		if (gameIsWon()) {
			System.out.println("You win!");
		} else {
			System.out.println("You loose!");
		}
	}

	/**
	 * Says if the game is finished or not
	 * @return true if the game is won/lost
	 */
	public boolean gameIsFinished() {
		return gameIsLost() || gameIsWon();
	}

	/**
	 * Asks to the current room if the game is lost when the player enters in
	 * @return {@link Room#gameIsLost()}
	 */
	public boolean gameIsLost() {
		return currentRoom.gameIsLost() || player.isDead();
	}

	/**
	 * Asks to the current room if the game is won when the player enters in
	 * @return {@link Room#gameIsWon()}
	 */
	public boolean gameIsWon() {
		return currentRoom.gameIsWon();
	}
	
	/**
	 * Main method
	 * @param args
	 */
	public static void main(String[] args) {
		Dungeon dungeon = new Dungeon();
		dungeon.start();
	}
}
