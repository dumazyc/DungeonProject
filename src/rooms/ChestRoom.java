package rooms;

public class ChestRoom extends Room {
	
	public ChestRoom(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	public void addTreasure(Object objectToAdd){
		//TODO à réfléchir
	}
	@Override
	public Room interpretCommand(String command) {
		if (command.equals("open the chest")) {
			System.out.println("You find a secret button on the wall and hit it.");
			System.out.println("Far away, a closed door is now open.");
			openRooms();
			return this;
		}

		return super.interpretCommand(command);
	}
}
