package dungeon;

public class MonsterRoom extends Room {

	public MonsterRoom(String name) {
		super(name);
	}
	
	public boolean gameIsLost() {
		return true;
	}
}
