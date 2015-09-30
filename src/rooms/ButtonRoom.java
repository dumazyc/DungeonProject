package rooms;

public class ButtonRoom extends Room {

	public ButtonRoom(String name) {
		super(name);
	}

	@Override
	public Room interpretCommand(String command) {
		if (command.equals("find a secret button")) {
			System.out.println("You find a secret button on the wall and hit it.");
			System.out.println("Far away, a closed door is now open.");
			openRooms();
			return this;
		}

		return super.interpretCommand(command);
	}
}
