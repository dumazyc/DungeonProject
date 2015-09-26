package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

import characters.Monster;
import characters.Player;
import game.Dungeon;
import game.Game;

public class DungeonTest {
	protected Game game;
	@Before
	public void createDungeon() {
		game = new Game();
	}

	@Test
	public void initialRoomIsEntrance() {
		assertEquals("entrance", game.currentDungeon.getCurrentRoom());
	}

	@Test
	public void gameNotFinishedAtBeginning() {
		assertFalse(game.gameIsFinished());
	}

	// @Test
	// public void gameWonWhenGoingNorth() {
	// dungeon.interpretCommand("go north");
	// assertEquals("intersection", dungeon.getCurrentRoom());
	// assertFalse(dungeon.gameIsWon());
	// dungeon.interpretCommand("go north");
	// assertEquals("exit", dungeon.getCurrentRoom());
	// assertTrue(dungeon.gameIsWon());
	// }
	//
	// @Test
	// public void gameLostWhenGoingToTrap() {
	// dungeon.interpretCommand("go north");
	// assertFalse(dungeon.gameIsLost());
	// dungeon.interpretCommand("go west");
	// assertEquals("trap", dungeon.getCurrentRoom());
	// assertTrue(dungeon.gameIsLost());
	// }

	@Test
	public void nothingHappensWhenGoingInNonExistingDirection() {
		dungeon.interpretCommand("go west");
		assertEquals("entrance", dungeon.getCurrentRoom());
		assertFalse(dungeon.gameIsFinished());
	}

	@Test
	public void hurtAferBeingHit() {
		final int initialHealthPoint = player.getHealthPoints();
		monster.sendDammage(player);
		final int healthAferBeingHit = player.getHealthPoints();
		assertFalse(initialHealthPoint == healthAferBeingHit);
		while (player.getHealthPoints() > 0) {
			assertEquals(false, player.isDead());
			player.receiveDammage(5);
		}
		assertEquals(true, player.isDead());
	}
}