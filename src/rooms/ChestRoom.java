package rooms;

import inventory.Item;

public class ChestRoom extends Room {
	Item itemInTheChest;

	public ChestRoom(String name) {
		super(name);

	}

	public void addTreasure(Item itemInTheChest) {
		this.itemInTheChest = itemInTheChest;
	}

	@Override
	public Room interpretCommand(String command) {
		if (command.equals("open the chest")) {
			if (this.itemInTheChest != null) {
				System.out.println("You open the chest and find a " + itemInTheChest.getName());
				player.getInventory().addItemToInventory(itemInTheChest);
				itemInTheChest = null;
			} else {
				System.out.println("You open the chest but it is empty");
			}
			return this;
		}

		return super.interpretCommand(command);
	}

	public String inspect() {
		String response = super.inspect();
		response += "- a chest\n";
		return response;
	}

	public String help() {
		String response = super.help();
		response += " - open the chest\n";
		return response;
	}
}
