package tests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import characters.Player;
import game.Dungeon;
import game.Game;
import inventory.Potion;
import passages.PaintingPassage;
import passages.Passage;
import rooms.ChestRoom;
import rooms.ExitRoom;
import rooms.Room;
import rooms.TrapRoom;

public class RoomTest {

	protected Game game;

	public void createParticularDungeon(int choice) {
		game = new Game();
		game.setCurrentDungeon(new Dungeon());
		List<Room> roomList = game.getCurrentDungeon().getRoomList();
		roomList.add(new Room("the entrance"));
		game.getCurrentDungeon().setCurrentRoom(roomList.get(0));
		game.getCurrentDungeon().getCurrentRoom().setPlayer(new Player());

		switch (choice) {
		case 1:
			roomList.add(new TrapRoom("a trap"));

			roomList.get(0).addPassage(new Passage("a north passage", roomList.get(0), roomList.get(1)));
			roomList.get(1).addPassage(new Passage("a south passage", roomList.get(1), roomList.get(0)));
			break;
		case 2:
			roomList.add(new ExitRoom("the exit"));

			roomList.get(0).addPassage(new Passage("a north passage", roomList.get(0),roomList.get(1)));
			roomList.get(1).addPassage(new Passage("a south passage", roomList.get(1), roomList.get(0)));
			break;
		case 3:
			roomList.add(new ChestRoom("a room"));

			roomList.get(0).addPassage(new Passage("a north passage", roomList.get(0), roomList.get(1)));
			roomList.get(1).addPassage(new Passage("a south passage", roomList.get(1), roomList.get(0)));
			((ChestRoom) roomList.get(1)).addTreasure(new Potion("Red Potion",5));
			break;
		case 4:
			roomList.add(new Room("a room"));

			roomList.get(0).addPassage(new PaintingPassage("painting", roomList.get(0),roomList.get(1)));
			roomList.get(1).addPassage(new Passage("a south passage", roomList.get(1), roomList.get(0)));
			break;
		case 5:
			
			roomList.add(new TrapRoom("a trap"));

			roomList.get(0).addPassage(new Passage("a north passage", roomList.get(0), roomList.get(1)));
			roomList.get(1).addPassage(new Passage("a south passage", roomList.get(1), roomList.get(0)));
			break;
		}
		
	}

	@Test
	public void inspectionIsNotEmpty() {
		createParticularDungeon(1);
		assertFalse(game.getCurrentDungeon().getCurrentRoom().inspect().equals(""));
		game.getCurrentDungeon().getCurrentRoom().interpretCommand("go to 1");
		assertFalse(game.getCurrentDungeon().getCurrentRoom().inspect().equals(""));
	}

	@Test
	public void helpIsNotEmpty() {

		createParticularDungeon(1);
		assertFalse(game.getCurrentDungeon().getCurrentRoom().help().equals(""));
	}

	@Test
	public void cantTypeGoToPlusString() {

		createParticularDungeon(1);
		assertTrue(game.getCurrentDungeon().getCurrentRoom().interpretCommand("go to random_string")
				.equals(game.getCurrentDungeon().getCurrentRoom()));

	}
	@Test
	public void inventoryNotEmptyAfterOpenAChest() {
		System.out.println("Test 4 : \n");
		createParticularDungeon(3);
		game.getCurrentDungeon().getCurrentRoom().interpretCommand("inspect");
		game.getCurrentDungeon().getCurrentRoom().interpretCommand("go to 1");
		
		game.getCurrentDungeon().getCurrentRoom().interpretCommand("open the chest");
		System.out.println(game.getCurrentDungeon().getCurrentRoom().getPlayer());
		System.out.println(game.getCurrentDungeon().getCurrentRoom().getPlayer().getInventory());
		game.getCurrentDungeon().getCurrentRoom().getPlayer().getInventory().getItemList();
		assertFalse(game.getCurrentDungeon().getCurrentRoom().getPlayer().getInventory().getItemList().isEmpty());
			
		System.out.println("\n Fin Test 4 ");
	}
	@Test
	public void openAHiddenDoor() {
		
		createParticularDungeon(4);
		Room currentRoom=game.getCurrentDungeon().getCurrentRoom();
		game.getCurrentDungeon().getCurrentRoom().interpretCommand("inspect painting");
		game.getCurrentDungeon().getCurrentRoom().interpretCommand("go to 1");
		assertFalse(currentRoom.equals(game.getCurrentDungeon().getCurrentRoom()));
			
		
	}
	@Test
	public void secretButton() {
		
		createParticularDungeon(5);
		game.getCurrentDungeon().getCurrentRoom().interpretCommand("find a secret button");
		
		assertFalse(game.getCurrentDungeon().getCurrentRoom().interpretCommand("go to 1").equals(game.getCurrentDungeon().getCurrentRoom()));
			
		
	}
}
