package characters;

import java.util.Random;

public class Monster extends Character {

	public Monster(String name) {
		super(name, 2, 1, 5, 20);
	}

	@Override
	public void sendDammage(Character player) {
		Random rand = new Random();
		// 2% luck to make a critical hit
		if (rand.nextInt(51) == 50) {
			player.receiveDamage(this.criticalHit);
		}
		player.receiveDamage(rand.nextInt(this.maximalDammage - this.minimalDammage + 1) + this.minimalDammage);
	}
}
