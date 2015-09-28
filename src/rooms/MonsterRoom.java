package rooms;

import characters.Monster;
import passages.Passage;

public class MonsterRoom extends Room {
	protected Monster monster;

	public MonsterRoom(String name) {
		super(name);
		monster = new Monster("dragon");
	}

	public Monster getMonster() {
		return this.monster;
	}
	
	@Override
	public void enterTheRoom() {
		System.out.println("You are in " + name + ".");
		if (!this.monster.isDead()) {
			System.out.println("The monster is on your way. You can't pass through.");
		}
	}

	@Override
	public Room interpretCommand(String command) {
		if (!this.monster.isDead()) {
			switch (command) {
			case "hit monster":
				player.sendDamage(this.monster);
				if (!this.monster.isDead()) {
					this.monster.sendDammage(player);
					System.out.println("Your HPs: " + player.getHealthPoints());
					System.out.println("Monster's HPs: " + this.monster.getHealthPoints());
				} else {
					openRooms();

					System.out.println("The monster is dead. Doors are now open.");
					System.out.println("Your HPs: " + player.getHealthPoints());
				}
				return this;
			case "run away":
				System.out.println("You ran in the last room visited.");
				for (Passage passage : passages)
					if (passage.canPassThrough()) {
						Room lastRoom = passage.getNextRoom();
						movePlayer(lastRoom);
						return lastRoom;
					}
					
			default:
				System.out.println("You can't do that !");
				return this;
			}
		}

		return super.interpretCommand(command);
	}

	private void openRooms() {
		for (Passage passage : passages) {
			passage.open();
			//TODO Ouvrir les passages inverse
		}
	}
	
	public String help() {
		String response = "You can :\n";
		if (!monster.isDead()) {
			response += " - hit monster\n - run away\n";
			return response;			
		} else {
			return super.help();
		}
	}
}
