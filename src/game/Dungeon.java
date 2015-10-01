package game;

import java.util.ArrayList;
import java.util.List;

import characters.Player;
import inventory.Key;
import inventory.Potion;
import passages.*;
import rooms.*;

public class Dungeon {

	protected Room currentRoom;
	protected Room lastRoom = null;
	protected List<Room> roomList;

	public Dungeon(int choice) {
		roomList = new ArrayList<Room>();
		roomList.add(new Room("the entrance"));
		createDungeon(choice);
		currentRoom = this.roomList.get(0);
		currentRoom.setPlayer(new Player());
	}
	
	public Dungeon() {
		roomList = new ArrayList<Room>();
	}
	
	public List<Room> getRoomList() {
		return this.roomList;
	}
	
	public void setCurrentRoom(Room room) {
		currentRoom = room;
	}

	private void createDungeon(int choice) {
		Key key = new Key("key");
		
		switch (choice) {
		case 1:
			roomList.add(new Room("a room"));
			roomList.add(new Room("a room"));
			roomList.add(new TrapRoom("a trap"));
			roomList.add(new ChestRoom("a room"));
			roomList.add(new ChestRoom("a room"));
			roomList.add(new MonsterRoom("a monster room"));
			roomList.add(new ButtonRoom("a room"));
			roomList.add(new ExitRoom("the exit"));
			
			
			roomList.get(0).addPassage(new Passage("a north passage", roomList.get(0),roomList.get(1)));
			
			roomList.get(1).addPassage(new Passage("a west passage", roomList.get(1),roomList.get(5)));
			roomList.get(1).addPassage(new Passage("a north passage", roomList.get(1),roomList.get(6)));
			
			roomList.get(2).addPassage(new PaintingPassage("painting", roomList.get(2),roomList.get(7)));
			roomList.get(2).addPassage(new ClosedPassage("a north passage", roomList.get(2),roomList.get(8)));
			roomList.get(2).addPassage(new ClosedPassage("a west passage", roomList.get(2),roomList.get(6)));
			
			roomList.get(3).addPassage(new Passage("a south passage",roomList.get(3),roomList.get(4)));
			
			roomList.get(4).addPassage(new Passage("a north passage", roomList.get(4),roomList.get(3)));
			roomList.get(4).addPassage(new ClosedPassage("a south passage", roomList.get(4),roomList.get(5)));
			roomList.get(4).addPassage(new ClosedPassage("a east passage", roomList.get(4),roomList.get(6)));
			
			roomList.get(5).addPassage(new Passage("a east passage", roomList.get(5),roomList.get(1)));
			roomList.get(5).addPassage(new ClosedPassage("a north passage", roomList.get(5),roomList.get(4)));
			
			roomList.get(6).addPassage(new ClosedPassage("a west passage", roomList.get(6),roomList.get(4)));
			roomList.get(6).addPassage(new ClosedPassage("a east passage", roomList.get(6),roomList.get(2)));
			roomList.get(6).addPassage(new Passage("a south passage", roomList.get(6),roomList.get(1)));
			
			roomList.get(7).addPassage(new Passage("a north passage", roomList.get(7),roomList.get(2)));
			
			roomList.get(8).addPassage(new Passage("a south passage", roomList.get(8),roomList.get(2)));	
			
			
			roomList.get(6).addPassagesWhichCanBeOpenByThisRoom(roomList.get(2).getPassage(roomList.get(6)));
			roomList.get(6).addPassagesWhichCanBeOpenByThisRoom(roomList.get(6).getPassage(roomList.get(2)));
			roomList.get(6).addPassagesWhichCanBeOpenByThisRoom(roomList.get(4).getPassage(roomList.get(6)));
			roomList.get(6).addPassagesWhichCanBeOpenByThisRoom(roomList.get(6).getPassage(roomList.get(4)));
			roomList.get(7).addPassagesWhichCanBeOpenByThisRoom(roomList.get(4).getPassage(roomList.get(5)));
			roomList.get(7).addPassagesWhichCanBeOpenByThisRoom(roomList.get(5).getPassage(roomList.get(4)));
			roomList.get(2).addPassagesWhichCanBeOpenByThisRoom(roomList.get(2).getPassage(roomList.get(7)));
			roomList.get(2).addPassagesWhichCanBeOpenByThisRoom(roomList.get(7).getPassage(roomList.get(2)));
			
			key.addPassageWhichCanBeOpenWithThisKey(roomList.get(2).getPassage(roomList.get(8)));
			key.addPassageWhichCanBeOpenWithThisKey(roomList.get(8).getPassage(roomList.get(2)));
			((ChestRoom) roomList.get(4)).addTreasure(key);
			((ChestRoom) roomList.get(5)).addTreasure(new Potion("Red Potion",5));
			break;
		case 2:
			roomList.add(new ButtonRoom("a room"));
			roomList.add(new Room("a room"));
			roomList.add(new MonsterRoom("a monster room"));
			roomList.add(new ChestRoom("a room"));
			roomList.add(new TrapRoom("a trap"));
			roomList.add(new ChestRoom("a room"));
			roomList.add(new Room("a room"));
			roomList.add(new ExitRoom("the exit"));
			
			
			roomList.get(0).addPassage(new Passage("a north passage", roomList.get(0),roomList.get(1)));
			
			roomList.get(1).addPassage(new ClosedPassage("a east passage", roomList.get(1),roomList.get(2)));
			roomList.get(1).addPassage(new Passage("a south passage", roomList.get(1),roomList.get(0)));
			
			roomList.get(2).addPassage(new ClosedPassage("a west  passage", roomList.get(2),roomList.get(1)));
			roomList.get(2).addPassage(new Passage("a north passage", roomList.get(2),roomList.get(3)));
			
			roomList.get(3).addPassage(new Passage("a south passage",roomList.get(3),roomList.get(2)));
			roomList.get(3).addPassage(new ClosedPassage("a north passage",roomList.get(3),roomList.get(6)));
			roomList.get(3).addPassage(new ClosedPassage("a east passage",roomList.get(3),roomList.get(4)));
			
			roomList.get(4).addPassage(new ClosedPassage("a west passage", roomList.get(4),roomList.get(3)));
			roomList.get(4).addPassage(new Passage("a north passage", roomList.get(4),roomList.get(5)));
			
			roomList.get(5).addPassage(new Passage("a west passage", roomList.get(5),roomList.get(6)));
			roomList.get(5).addPassage(new Passage("a south passage", roomList.get(5),roomList.get(4)));
			
			roomList.get(6).addPassage(new ClosedPassage("a south passage", roomList.get(6),roomList.get(3)));
			roomList.get(6).addPassage(new Passage("a east passage", roomList.get(6),roomList.get(5)));
			roomList.get(6).addPassage(new Passage("a west passage", roomList.get(6),roomList.get(7)));
			
			roomList.get(7).addPassage(new ClosedPassage("a north passage", roomList.get(7),roomList.get(8)));
			roomList.get(7).addPassage(new Passage("a east passage", roomList.get(7),roomList.get(6)));
			
			roomList.get(8).addPassage(new Passage("a south passage", roomList.get(8),roomList.get(7)));	
			
			
			roomList.get(1).addPassagesWhichCanBeOpenByThisRoom(roomList.get(1).getPassage(roomList.get(2)));
			roomList.get(1).addPassagesWhichCanBeOpenByThisRoom(roomList.get(2).getPassage(roomList.get(1)));
			
			roomList.get(3).addPassagesWhichCanBeOpenByThisRoom(roomList.get(3).getPassage(roomList.get(4)));
			roomList.get(3).addPassagesWhichCanBeOpenByThisRoom(roomList.get(4).getPassage(roomList.get(3)));
			roomList.get(3).addPassagesWhichCanBeOpenByThisRoom(roomList.get(3).getPassage(roomList.get(6)));
			roomList.get(3).addPassagesWhichCanBeOpenByThisRoom(roomList.get(6).getPassage(roomList.get(3)));
			
			key.addPassageWhichCanBeOpenWithThisKey(roomList.get(7).getPassage(roomList.get(8)));
			key.addPassageWhichCanBeOpenWithThisKey(roomList.get(8).getPassage(roomList.get(7)));
			((ChestRoom) roomList.get(4)).addTreasure(key);
			((ChestRoom) roomList.get(6)).addTreasure(new Potion("Red Potion",3));
			break;
		case 3:
			roomList.add(new Room("a room"));
			roomList.add(new Room("a room"));
			roomList.add(new TrapRoom("a trap"));
			roomList.add(new ChestRoom("a room"));
			roomList.add(new MonsterRoom("a monster room"));
			roomList.add(new ChestRoom("a room"));
			roomList.add(new MonsterRoom("a monster room"));
			roomList.add(new ExitRoom("the exit"));
			
			
			roomList.get(0).addPassage(new Passage("a north passage", roomList.get(0),roomList.get(1)));
			
			roomList.get(1).addPassage(new PaintingPassage("a painting", roomList.get(1),roomList.get(2)));
			roomList.get(1).addPassage(new Passage("a south passage", roomList.get(1),roomList.get(0)));
			
			roomList.get(2).addPassage(new PaintingPassage("a painting", roomList.get(2),roomList.get(3)));
			roomList.get(2).addPassage(new PaintingPassage("a south passage", roomList.get(2),roomList.get(1)));
			roomList.get(2).addPassage(new ClosedPassage("a east passage", roomList.get(2),roomList.get(5)));
			
			roomList.get(3).addPassage(new PaintingPassage("a south passage",roomList.get(3),roomList.get(2)));
			roomList.get(3).addPassage(new Passage("a north passage",roomList.get(3),roomList.get(4)));
			
			roomList.get(4).addPassage(new Passage("a south passage", roomList.get(4),roomList.get(3)));
			
			roomList.get(5).addPassage(new ClosedPassage("a west passage", roomList.get(5),roomList.get(2)));
			roomList.get(5).addPassage(new ClosedPassage("a east passage", roomList.get(5),roomList.get(6)));
			
			roomList.get(6).addPassage(new ClosedPassage("a west passage", roomList.get(6),roomList.get(5)));
			roomList.get(6).addPassage(new Passage("a east passage", roomList.get(6),roomList.get(7)));
			
			roomList.get(7).addPassage(new ClosedPassage("a north passage", roomList.get(7),roomList.get(8)));
			roomList.get(7).addPassage(new Passage("a west passage", roomList.get(7),roomList.get(6)));
			
			roomList.get(8).addPassage(new ClosedPassage("a south passage", roomList.get(8),roomList.get(7)));	
			
			
			roomList.get(1).addPassagesWhichCanBeOpenByThisRoom(roomList.get(1).getPassage(roomList.get(2)));
			roomList.get(1).addPassagesWhichCanBeOpenByThisRoom(roomList.get(2).getPassage(roomList.get(1)));
			
			roomList.get(2).addPassagesWhichCanBeOpenByThisRoom(roomList.get(3).getPassage(roomList.get(2)));
			roomList.get(2).addPassagesWhichCanBeOpenByThisRoom(roomList.get(2).getPassage(roomList.get(3)));
		
			roomList.get(5).addPassagesWhichCanBeOpenByThisRoom(roomList.get(5).getPassage(roomList.get(6)));
			roomList.get(5).addPassagesWhichCanBeOpenByThisRoom(roomList.get(6).getPassage(roomList.get(5)));
			
			roomList.get(7).addPassagesWhichCanBeOpenByThisRoom(roomList.get(7).getPassage(roomList.get(8)));
			roomList.get(7).addPassagesWhichCanBeOpenByThisRoom(roomList.get(8).getPassage(roomList.get(7)));
			
			key.addPassageWhichCanBeOpenWithThisKey(roomList.get(2).getPassage(roomList.get(5)));
			key.addPassageWhichCanBeOpenWithThisKey(roomList.get(5).getPassage(roomList.get(2)));
			((ChestRoom) roomList.get(4)).addTreasure(key);
			((ChestRoom) roomList.get(6)).addTreasure(new Potion("Red Potion",7));
			break;
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
