package dungeon;

import java.util.Random;

public abstract class Character {
	private String name;
	private int pdv;
	private int minimalDammage;
	private int maximalDammage;
	private int criticalHit;
	
	public Character(){}
	
	public Character(String name, int pdv, int minimalDammage, int MaximalDammage, int criticalHit){
		this.name = name;
		this.pdv = pdv;
		this.minimalDammage = minimalDammage;
		this.maximalDammage = maximalDammage;
		this.criticalHit = criticalHit;
	}
	
	public boolean isDead(){
		return pdv <= 0;
	}
	
	public void receiveDammage(int dammage){
		this.pdv -= dammage;
	}
	
	public void sendDammage(Character Character){}
}
