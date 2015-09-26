package characters;

public abstract class Character {
	protected String name;
	protected int healthPoints;
	protected int minimalDammage;
	protected int maximalDammage;
	protected int criticalHit;

	public Character() {
	}

	public Character(String name, int healthPoints, int minimalDammage, int maximalDammage, int criticalHit) {
		this.name = name;
		this.healthPoints = healthPoints;
		this.minimalDammage = minimalDammage;
		this.maximalDammage = maximalDammage;
		this.criticalHit = criticalHit;
	}

	public boolean isDead() {
		return healthPoints <= 0;
	}

	public void receiveDammage(int dammage) {
		this.healthPoints -= dammage;
	}

	public int getHealthPoints() {

		return this.healthPoints >= 0 ? this.healthPoints : 0;
	}

	public void sendDammage(Character Character) {
	}
}
