package dungeon;

import java.util.Random;

public class Player extends Character{
	
	public Player() {
		super("Player", 30, 2, 6, 1000);
	}
	
	public Player(String name) {
		super(name, 30, 2, 6, 1000);
	}
	
	public void sendDamage(Monster monster) {
		
		Random rand = new Random();
		//2% luck to make a critical hit
		if(rand.nextInt(21) == 20){
			monster.receiveDammage(this.criticalHit);
			System.out.println("Critical hit !");
		}
			monster.receiveDammage(rand.nextInt(maximalDammage - minimalDammage + 1) + minimalDammage);	
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
}
