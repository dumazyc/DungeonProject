package dungeon;

public class TrapRoom extends Room {

	public TrapRoom(String name) {
		super(name);
	}
	
	public boolean gameIsLost() {
		return true;
	}
}

