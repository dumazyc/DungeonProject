package game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
		for (int i = 0; i < dungeons.size(); i++) {
			currentDungeon = dungeons.get(i);
			System.out.println("Welcome to the dungeon n°" + (i + 1));
			do {
				System.out.println("What do you want to do?");
				System.out.print("> ");
				currentDungeon.interpretCommand(scanner.nextLine().toLowerCase());

			} while (!gameIsFinished());
			if (gameIsWon()) {
				System.out.println("You win the dungeon n°" + (i + 1) + " !");
				if (i == dungeons.size()-1) {
					System.out.println("Congratulation, you've completed all the dungeons !");
				}
			} else {
				System.out.println("You loose!");
				break;
			}
		}

	}

	public boolean gameIsFinished() {
		return gameIsLost() || gameIsWon();
	}

	public boolean gameIsLost() {
		return currentDungeon.gameIsLost();
	}

	public boolean gameIsWon() {
		return currentDungeon.gameIsWon();
	}

	public static void main(String[] args) {
		List<Dungeon> dungeons = new ArrayList<Dungeon>();
		dungeons.add(new Dungeon(2));
		dungeons.add(new Dungeon(2));
		dungeons.add(new Dungeon(2));
		Game game = new Game(dungeons);
		game.start();
	}
}
