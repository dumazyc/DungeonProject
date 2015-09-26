package rooms;

public class ExitRoom extends Room {

	public ExitRoom(String name) {
		super(name);
	}

	@Override
	public boolean gameIsWon() {
		return true;
	}
}
