package rooms;

import inventory.Item;

public class ChestRoom extends Room {
	Item itemInTheChest;
	public ChestRoom(String name) {
		super(name);
		
	}
	public void addTreasure(Item itemInTheChest){
		this.itemInTheChest = itemInTheChest;
	}
	@Override
	public Room interpretCommand(String command) {
		if (command.equals("open the chest")) {
			
			System.out.println("You open the chest and find a "+itemInTheChest.getName());
			player.getInventory().addItemTonventory(itemInTheChest);
			openRooms();
			return this;
		}

		return super.interpretCommand(command);
	}
}
