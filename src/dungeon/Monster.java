package dungeon;

import java.util.Random;

public class Monster extends Character{
	
	public Monster(String name){
		super(name, 20, 0, 5, 20);
	}
	
	public void sendDammage(Player player){
		Random rand = new Random();
		//2% luck to make a critical hit
		if(rand.nextInt(51) == 50){
			player.receiveDammage(this.criticalHit);
		}
			player.receiveDammage(rand.nextInt(this.maximalDammage - this.minimalDammage + 1) + this.minimalDammage);		
	}
}
