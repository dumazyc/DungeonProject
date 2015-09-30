package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

import game.*;
import rooms.*;

public class DungeonTest {
	protected Game game;
	
	@Before
	public void createDungeon() {
		game = new Game();
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
		 game.setCurrentDungeon(new Dungeon(1));
		 assertEquals(30, game.getCurrentDungeon().getCurrentRoom().getPlayer().getHealthPoints());
		 game.getCurrentDungeon().interpretCommand("go to 1");
		 assertEquals(25, game.getCurrentDungeon().getCurrentRoom().getPlayer().getHealthPoints());
	 }
	
	 @Test
	 public void nothingHappensWhenGoingInNonExistingDirection() {
		 Room firstRoom = game.getCurrentDungeon().getCurrentRoom();
		 
		 // The player begins in the entrance which have only one passage, go to (> 1) shouldn't do anything 
		 game.getCurrentDungeon().interpretCommand("go to 2");
		 assertEquals(firstRoom, game.getCurrentDungeon().getCurrentRoom());
	 }
	
	 @Test
	 public void hurtAferBeingHit() {
		 
	 }
}