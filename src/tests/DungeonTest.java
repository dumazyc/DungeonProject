package tests;

import org.junit.Before;
import org.junit.Test;

import dungeon.Dungeon;
import dungeon.Room;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DungeonTest {
	protected Dungeon dungeon;

	@Before
	public void createDungeon() {
		Room exit = new Room("exit", true);
		Room trap = new Room("trap", true);
		Room intersec = new Room("intersection", false, exit, null, trap, null);
		Room entrance = new Room("entrance", false, intersec, null, null, null);
		
		dungeon = new Dungeon(entrance);
	}

	@Test
	public void initialRoomIsEntrance() {
		assertEquals("entrance", dungeon.getCurrentRoom());
	}

	@Test
	public void gameNotFinishedAtBeginning() {
		assertFalse(dungeon.gameIsFinished());
	}

	@Test
	public void gameWonWhenGoingNorth() {
		dungeon.interpretCommand("go north");
		assertEquals("intersection", dungeon.getCurrentRoom());
		assertFalse(dungeon.gameIsWon());
		dungeon.interpretCommand("go north");
		assertEquals("exit", dungeon.getCurrentRoom());
		assertTrue(dungeon.gameIsWon());
	}

	@Test
	public void gameLostWhenGoingToTrap() {
		dungeon.interpretCommand("go north");
		assertFalse(dungeon.gameIsLost());
		dungeon.interpretCommand("go west");
		assertEquals("trap", dungeon.getCurrentRoom());
		assertTrue(dungeon.gameIsLost());
	}

	@Test
	public void nothingHappensWhenGoingInNonExistingDirection() {
		dungeon.interpretCommand("go west");
		assertEquals("entrance", dungeon.getCurrentRoom());
		assertFalse(dungeon.gameIsFinished());
	}
}