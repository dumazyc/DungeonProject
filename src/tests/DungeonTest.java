package tests;

import org.junit.Before;
import org.junit.Test;

import characters.Monster;
import characters.Player;
import game.Dungeon;
import rooms.Room;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DungeonTest {
	protected Dungeon dungeon;
	Monster monster;
	Player player;
	
	@Before
	public void createDungeon() {
		Room exit = new Room("exit");
		Room trap = new Room("trap");
		Room intersec = new Room("intersection");
		Room entrance = new Room("entrance");
		monster = new Monster("dragon");
		player = new Player("Julien");
		
		dungeon = new Dungeon();
	}

	@Test
	public void initialRoomIsEntrance() {
		assertEquals("entrance", dungeon.getCurrentRoom());
	}

	@Test
	public void gameNotFinishedAtBeginning() {
		assertFalse(dungeon.gameIsFinished());
	}

//	@Test
//	public void gameWonWhenGoingNorth() {
//		dungeon.interpretCommand("go north");
//		assertEquals("intersection", dungeon.getCurrentRoom());
//		assertFalse(dungeon.gameIsWon());
//		dungeon.interpretCommand("go north");
//		assertEquals("exit", dungeon.getCurrentRoom());
//		assertTrue(dungeon.gameIsWon());
//	}
//
//	@Test
//	public void gameLostWhenGoingToTrap() {
//		dungeon.interpretCommand("go north");
//		assertFalse(dungeon.gameIsLost());
//		dungeon.interpretCommand("go west");
//		assertEquals("trap", dungeon.getCurrentRoom());
//		assertTrue(dungeon.gameIsLost());
//	}

	@Test
	public void nothingHappensWhenGoingInNonExistingDirection() {
		dungeon.interpretCommand("go west");
		assertEquals("entrance", dungeon.getCurrentRoom());
		assertFalse(dungeon.gameIsFinished());
	}
	
	@Test
	public void hurtAferBeingHit(){
		final int initialHealthPoint = player.getHealthPoints();
		monster.sendDammage(player);
		final int healthAferBeingHit = player.getHealthPoints();
		assertFalse(initialHealthPoint == healthAferBeingHit);
		while(player.getHealthPoints()>0){
			assertEquals(false, player.isDead());
			player.receiveDammage(5);
		}
		assertEquals(true, player.isDead());
	}
}