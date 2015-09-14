package dungeon;

public class MonsterRoom extends Room {
	private Monster monster;

	public MonsterRoom(String name) {
		super(name);
		monster = new Monster("dragon");
	}
	
	public boolean gameIsLost() {
		return true;
	}

	public Monster getMonster(){
		return this.monster;
	}
}
