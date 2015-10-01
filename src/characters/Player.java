package characters;

import java.util.Random;

import inventory.Inventory;

public class Player extends Character {
	protected Inventory inventory;
	public Player() {
		super("Player", 30, 2, 6, 1000);
		inventory = new Inventory();
	}

	public Player(String name) {
		super(name, 30, 2, 6, 1000);
		inventory = new Inventory();
	}

	public void sendDamage(Monster monster) {

		Random rand = new Random();
		// 2% luck to make a critical hit
		if (rand.nextInt(21) == 20) {
			monster.receiveDamage(this.criticalHit);
			System.out.println("Critical hit !");
		}
		monster.receiveDamage(rand.nextInt(maximalDammage - minimalDammage + 1) + minimalDammage);
	}

	public void setName(String name) {
		this.name = name;
	}
	public Inventory getInventory(){
		return inventory;
	}
	public String getName() {
		return this.name;
	}

	public void heal(int hPRestoreNumber) {
this.healthPoints+=hPRestoreNumber;		
	}
}
