package dungeon;

import java.util.Random;

public class Monster extends Character{
	private String name;
	private int pdv;
	private int minimalDammage;
	private int maximalDammage;
	private int criticalHit;
	
	public Monster(){
		super("dragon", 20, 0, 5, 20);
	}
	
	public void sendDammage(Character player){
		Random rand = new Random();
		//2% luck to make a critical hit
		if(rand.nextInt(51) == 50){
			player.receiveDammage(this.criticalHit);
		}
			player.receiveDammage(rand.nextInt(maximalDammage - minimalDammage + 1) + minimalDammage);		
	}
}
