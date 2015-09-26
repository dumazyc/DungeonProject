package game;

import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

import characters.*;
import passages.*;
import rooms.*;

public class Dungeon {

	protected Room currentRoom;
	protected List<Room> roomList;
	protected Player player;

	public Dungeon() {
		roomList = new ArrayList<Room>();
		createDungeon();
		currentRoom = this.roomList.get(0);
		player = new Player();
	}

	/**
	 * Defines the different rooms and associates them
	 */
	private void createDungeon() {
		roomList.add(new Room("the entrance"));
		roomList.add(new Room("a room"));
		roomList.add(new Room("a room"));
		roomList.add(new TrapRoom("a trap"));
		roomList.add(new ChestRoom("a room"));
		roomList.add(new ChestRoom("a room"));
		roomList.add(new MonsterRoom("a monster room"));
		roomList.add(new ButtonRoom("a room", roomList.get(5), roomList.get(4)));
		roomList.add(new ExitRoom("the exit"));
		
		roomList.get(0).addPassage(new Passage("normal passage", roomList.get(1)));
		
		roomList.get(1).addPassage(new Passage("normal passage", roomList.get(5)));
		roomList.get(1).addPassage(new Passage("normal passage", roomList.get(6)));
		
		roomList.get(2).addPassage(new PaintingPassage("painting", roomList.get(7)));
		roomList.get(2).addPassage(new KeyClosedPassage("key closed passage", roomList.get(8)));
		roomList.get(2).addPassage(new BlockedByMonsterPassage("monster passage", roomList.get(6)));
		
		roomList.get(3).addPassage(new Passage("normal passage",roomList.get(4)));
		
		roomList.get(4).addPassage(new Passage("normal passage", roomList.get(3)));
		roomList.get(4).addPassage(new ButtonClosedPassage("button closed passage", roomList.get(5)));
		roomList.get(4).addPassage(new BlockedByMonsterPassage("monster passage", roomList.get(6)));
		
		roomList.get(5).addPassage(new Passage("normal passage", roomList.get(1)));
		roomList.get(5).addPassage(new ButtonClosedPassage("button closed passage", roomList.get(4)));
		
		roomList.get(6).addPassage(new BlockedByMonsterPassage("monster passage", roomList.get(4)));
		roomList.get(6).addPassage(new BlockedByMonsterPassage("monster passage", roomList.get(2)));
		roomList.get(6).addPassage(new Passage("normal passage", roomList.get(1)));
		
		roomList.get(7).addPassage(new PaintingPassage("painting", roomList.get(2)));
		
		roomList.get(8).addPassage(new KeyClosedPassage("key closed passage", roomList.get(2)));		
	}

	/**
	 * Gets the current room
	 * 
	 * @return this current room
	 */
	public Room getCurrentRoom() {
		return currentRoom;
	}

	/**
	 * Gets the current room's name
	 * 
	 * @return this current room's name
	 */
	public String getCurrentRoomName() {
		return currentRoom.getName();
	}

	/**
	 * Interprets the command typed by the player
	 * 
	 * @param command
	 */
	public void interpretCommand(String command) {
		switch (command) {
		case "inspect":
			System.out.println(currentRoom.inspect());
			break;
		case "help":
			System.out.println(currentRoom.help());
			break;
		default:
			currentRoom = currentRoom.interpretCommand(command);
		}
	}

	public boolean gameIsWon() {
		return currentRoom.gameIsWon();
	}

	public boolean gameIsLost() {
		return currentRoom.gameIsLost();
	}
}
