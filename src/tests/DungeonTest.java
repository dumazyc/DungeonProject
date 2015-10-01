package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import characters.Player;
import game.Dungeon;
import game.Game;
import passages.Passage;
import rooms.*;

public class DungeonTest {
	protected Game game;
	protected Game particularGame;
	
	@Before
	public void createDungeon() {
		game = new Game();
	}
	
	public void createParticularDungeon(int choice) {
		particularGame = new Game();
		particularGame.setCurrentDungeon(new Dungeon());
		List<Room> roomList = particularGame.getCurrentDungeon().getRoomList();
		roomList.add(new Room("the entrance"));
		particularGame.getCurrentDungeon().setCurrentRoom(roomList.get(0));
		particularGame.getCurrentDungeon().getCurrentRoom().setPlayer(new Player());
		
		
		switch(choice) {
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
		}
	}

	@Test
	public void initialRoomIsEntrance() {
		assertEquals("the entrance", game.getCurrentDungeon().getCurrentRoom().getName());
	}

	@Test
	public void gameNotFinishedAtBeginning() {
		assertFalse(game.gameIsFinished());
	}
	 
	 @Test
	 public void playerLostHealthPointsWhenGoingToTrap() {
		 // Dungeon(1) represents a dungeon with just an entrance and a trap room
		 createParticularDungeon(1);
		 assertEquals(30, particularGame.getCurrentDungeon().getCurrentRoom().getPlayer().getHealthPoints());
		 particularGame.getCurrentDungeon().interpretCommand("go to 1");
		 assertEquals(25, particularGame.getCurrentDungeon().getCurrentRoom().getPlayer().getHealthPoints());
	 }
	
	 @Test
	 public void nothingHappensWhenGoingInNonExistingDirection() {
		 Room firstRoom = game.getCurrentDungeon().getCurrentRoom();
		 
		 // The player begins in the entrance which have only one passage, go to (> 1) shouldn't do anything 
		 game.getCurrentDungeon().interpretCommand("go to 2");
		 assertEquals(firstRoom, game.getCurrentDungeon().getCurrentRoom());
	 }
}