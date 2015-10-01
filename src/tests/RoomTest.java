package tests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import characters.Player;
import game.Dungeon;
import game.Game;
import inventory.Potion;
import passages.ClosedPassage;
import passages.PaintingPassage;
import passages.Passage;
import rooms.ButtonRoom;
import rooms.ChestRoom;
import rooms.ExitRoom;
import rooms.MonsterRoom;
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

			roomList.get(0).addPassage(new Passage("a north passage", roomList.get(0), roomList.get(1)));
			roomList.get(1).addPassage(new Passage("a south passage", roomList.get(1), roomList.get(0)));
			break;
		case 3:
			roomList.add(new ChestRoom("a room"));

			roomList.get(0).addPassage(new Passage("a north passage", roomList.get(0), roomList.get(1)));
			roomList.get(1).addPassage(new Passage("a south passage", roomList.get(1), roomList.get(0)));
			((ChestRoom) roomList.get(1)).addTreasure(new Potion("Red Potion", 5));
			break;
		case 4:
			roomList.add(new Room("a room"));

			roomList.get(0).addPassage(new PaintingPassage("painting", roomList.get(0), roomList.get(1)));
			roomList.get(1).addPassage(new Passage("a south passage", roomList.get(1), roomList.get(0)));
			break;
		case 5:

			roomList.add(new ButtonRoom("a room"));
			roomList.add(new ExitRoom("the exit"));
			roomList.get(0).addPassage(new Passage("a north passage", roomList.get(0), roomList.get(1)));
			roomList.get(1).addPassage(new Passage("a south passage", roomList.get(1), roomList.get(0)));
			roomList.get(1).addPassage(new ClosedPassage("a north passage", roomList.get(1), roomList.get(2)));
			roomList.get(1).addPassagesWhichCanBeOpenByThisRoom(roomList.get(1).getPassage(roomList.get(2)));
			break;
		case 6:

			roomList.add(new MonsterRoom("a monster room"));
			roomList.add(new ExitRoom("the exit"));
			roomList.get(0).addPassage(new Passage("a north passage", roomList.get(0), roomList.get(1)));
			roomList.get(1).addPassage(new Passage("a south passage", roomList.get(1), roomList.get(0)));
			roomList.get(1).addPassage(new Passage("a north passage", roomList.get(1), roomList.get(2)));
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
	public void goThroughAMonsterRoom() {
		createParticularDungeon(6);
		game.getCurrentDungeon().interpretCommand("go to 1");
		for(int i =0;i<30;i++){
		game.getCurrentDungeon().interpretCommand("hit monster");
		}
		game.getCurrentDungeon().interpretCommand("go to 2");
		assertTrue(game.getCurrentDungeon().gameIsWon());
		assertFalse(game.getCurrentDungeon().gameIsLost());
		
	}
	
	@Test
	public void goThroughAButtonRoom() {
		createParticularDungeon(5);
		game.getCurrentDungeon().interpretCommand("go to 1");
		game.getCurrentDungeon().interpretCommand("find a secret button");
		game.getCurrentDungeon().interpretCommand("go to 2");
		assertTrue(game.getCurrentDungeon().gameIsWon());
		assertFalse(game.getCurrentDungeon().gameIsLost());
		
	}
	@Test
	public void runAwayFromMonster() {
		createParticularDungeon(6);
		Room room = game.getCurrentDungeon().getCurrentRoom();
		game.getCurrentDungeon().interpretCommand("go to 1");
		
		game.getCurrentDungeon().interpretCommand("run away");
		assertTrue(room.equals(game.getCurrentDungeon().getCurrentRoom()));
		
	}
	@Test
	public void testFirstFloor() {
		game = new Game();
		game.setCurrentDungeon(new Dungeon(1));
		
		game.getCurrentDungeon().interpretCommand("go to 1");
		game.getCurrentDungeon().interpretCommand("go to 2");
		game.getCurrentDungeon().interpretCommand("hit monster");
		game.getCurrentDungeon().interpretCommand("go to 1");
		game.getCurrentDungeon().interpretCommand("open the chest");
		game.getCurrentDungeon().interpretCommand("go to 3");
		game.getCurrentDungeon().interpretCommand("go to 2");
		game.getCurrentDungeon().interpretCommand("use item 1");
		game.getCurrentDungeon().interpretCommand("go to 2");
		assertTrue(game.getCurrentDungeon().gameIsWon());
		
	}
}
