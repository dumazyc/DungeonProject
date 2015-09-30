package game;

import java.util.ArrayList;
import java.util.List;

import characters.Player;
import passages.*;
import rooms.*;

public class Dungeon {

	protected Room currentRoom;
	protected Room lastRoom = null;
	protected List<Room> roomList;

	public Dungeon(int choice) {
		roomList = new ArrayList<Room>();
		createDungeon(choice);
		currentRoom = this.roomList.get(0);
		currentRoom.setPlayer(new Player());
	}

	private void createDungeon(int choice) {
		if (choice == 1) {
			roomList.add(new Room("the entrance"));
			roomList.add(new TrapRoom("a trap"));
			
			roomList.get(0).addPassage(new Passage("a north passage", roomList.get(0), roomList.get(1)));
			roomList.get(1).addPassage(new Passage("a south passage", roomList.get(1), roomList.get(0)));
		} else {
			roomList.add(new Room("the entrance"));
			roomList.add(new Room("a room"));
			roomList.add(new Room("a room"));
			roomList.add(new TrapRoom("a trap"));
			roomList.add(new ChestRoom("a room"));
			roomList.add(new ChestRoom("a room"));
			roomList.add(new MonsterRoom("a monster room"));
			roomList.add(new ButtonRoom("a room", roomList.get(5), roomList.get(4)));
			roomList.add(new ExitRoom("the exit"));
			
			
			roomList.get(0).addPassage(new Passage("a north passage", roomList.get(0),roomList.get(1)));
			
			roomList.get(1).addPassage(new Passage("a west passage", roomList.get(1),roomList.get(5)));
			roomList.get(1).addPassage(new Passage("a north passage", roomList.get(1),roomList.get(6)));
			
			roomList.get(2).addPassage(new PaintingPassage("painting", roomList.get(2),roomList.get(7)));
			roomList.get(2).addPassage(new KeyClosedPassage("a north passage", roomList.get(2),roomList.get(8)));
			roomList.get(2).addPassage(new BlockedByMonsterPassage("a west passage", roomList.get(2),roomList.get(6)));
			
			roomList.get(3).addPassage(new Passage("a south passage",roomList.get(3),roomList.get(4)));
			
			roomList.get(4).addPassage(new Passage("a north passage", roomList.get(4),roomList.get(3)));
			roomList.get(4).addPassage(new ButtonClosedPassage("a south passage", roomList.get(4),roomList.get(5)));
			roomList.get(4).addPassage(new BlockedByMonsterPassage("a east passage", roomList.get(4),roomList.get(6)));
			
			roomList.get(5).addPassage(new Passage("a east passage", roomList.get(5),roomList.get(1)));
			roomList.get(5).addPassage(new ButtonClosedPassage("a north passage", roomList.get(5),roomList.get(4)));
			
			roomList.get(6).addPassage(new BlockedByMonsterPassage("a west passage", roomList.get(6),roomList.get(4)));
			roomList.get(6).addPassage(new BlockedByMonsterPassage("a east passage", roomList.get(6),roomList.get(2)));
			roomList.get(6).addPassage(new Passage("a south passage", roomList.get(6),roomList.get(1)));
			
			roomList.get(7).addPassage(new PaintingPassage("painting", roomList.get(7),roomList.get(2)));
			
			roomList.get(8).addPassage(new KeyClosedPassage("a south passage", roomList.get(8),roomList.get(2)));	
		}
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
			System.out.println(currentRoom.inspect());
			break;
		case "help":
			System.out.println(currentRoom.help());
			break;
		default:
			lastRoom = currentRoom;
			currentRoom = currentRoom.interpretCommand(command);
			currentRoom.enterTheRoom();
		}
	}
	

	public boolean gameIsWon() {
		return currentRoom.gameIsWon();
	}

	public boolean gameIsLost() {
		return currentRoom.gameIsLost();
	}
}
