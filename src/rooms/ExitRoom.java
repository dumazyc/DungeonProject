package rooms;

public class ExitRoom extends Room {

	public ExitRoom(String name) {
		super(name);
	}

	public boolean gameIsWon() {
		return true;
	}
}
