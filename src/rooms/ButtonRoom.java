package rooms;

public class ButtonRoom extends Room {
	protected Room roomToOpen;
	protected Room roomToOpen2;

	public ButtonRoom(String name, Room roomToOpen, Room roomToOpen2) {
		super(name);
		this.roomToOpen = roomToOpen;
		this.roomToOpen2 = roomToOpen2;
	}

	@Override
	public Room interpretCommand(String command) {
		if (command.equals("hit button")) {
			System.out.println("A closed door is now open");
			return this;
		}

		return super.interpretCommand(command);
	}
}
