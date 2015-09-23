package dungeon;

public class ButtonRoom extends Room {
	protected Room roomToOpen;
	
	public ButtonRoom(String name, Room roomToOpen) {
		super(name);
		this.roomToOpen = roomToOpen;
	}
	
	public Room interpretCommand(String command) {
		if (command.equals("hit button")) {
			System.out.println("A closed door is now open");
			roomToOpen.openRooms();
			return this;
		}
		
		return super.interpretCommand(command);
	}
}
