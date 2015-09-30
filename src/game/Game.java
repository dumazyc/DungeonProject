package game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import rooms.Room;

public class Game {
	protected List<Dungeon> dungeons;
	protected Dungeon currentDungeon;
	protected final Scanner scanner = new Scanner(System.in);

	public Game() {
		dungeons = new ArrayList<Dungeon>();
		currentDungeon = new Dungeon(0);
		dungeons.add(currentDungeon);
	}

	public Game(List<Dungeon> dungeons) {
		this.dungeons = dungeons;
	}
	
	public void setCurrentDungeon(Dungeon dungeon) {
		currentDungeon = dungeon;
	}
	
	public Dungeon getCurrentDungeon() {
		return currentDungeon;
	}

	public void start() {
		for (Dungeon dungeon : dungeons) {
			do {
				System.out.println("What do you want to do?");
				System.out.print("> ");
				dungeon.interpretCommand(scanner.nextLine().toLowerCase());

			} while (!gameIsFinished());
		}
		if (gameIsWon()) {
			System.out.println("You win!");
		} else {
			System.out.println("You loose!");
		}
	}

	/**
	 * Says if the game is finished or not
	 * 
	 * @return true if the game is won/lost
	 */
	public boolean gameIsFinished() {
		return gameIsLost() || gameIsWon();
	}

	/**
	 * Asks to the current room if the game is lost when the player enters in
	 * 
	 * @return {@link Room#gameIsLost()}
	 */
	public boolean gameIsLost() {
		return currentDungeon.gameIsLost();
	}

	/**
	 * Asks to the current room if the game is won when the player enters in
	 * 
	 * @return {@link Room#gameIsWon()}
	 */
	public boolean gameIsWon() {
		return currentDungeon.gameIsWon();
	}
	
	public void startCombat() {
		
	}

	public static void main(String[] args) {
		Game game = new Game();
		game.start();
	}
}
