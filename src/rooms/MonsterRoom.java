package rooms;

import characters.Monster;
import game.Dungeon;

public class MonsterRoom extends Room {
	protected Monster monster;
	protected Room lastRoom = null;

	public MonsterRoom(String name) {
		super(name);
		monster = new Monster("dragon");
	}

	public Monster getMonster() {
		return this.monster;
	}

	public void setLastRoom(Room room) {
		this.lastRoom = room;
	}

	public void enterTheRoom() {
		System.out.println("You are in " + name + ".");
		if (!this.monster.isDead()) {
			System.out
					.println("The monster is on your way. You can't pass through.");
		}
	}

	public Room interpretCommand(String command) {
		if (!this.monster.isDead()) {
			switch (command) {
			case "hit monster":
				Dungeon.player.sendDamage(this.monster);
				if (!this.monster.isDead()) {
					this.monster.sendDammage(Dungeon.player);
					System.out.println("Your HPs: "
							+ Dungeon.player.getHealthPoints());
					System.out.println("Monster's HPs: "
							+ this.monster.getHealthPoints());
				} else {
					openRooms();
					
					System.out
							.println("The monster is dead. Doors are now open.");
					System.out.println("Your HPs: "
							+ Dungeon.player.getHealthPoints());
				}
				return this;
			case "run away":
				System.out.println("You ran in the last room visited.");
				return this.lastRoom;
			case "help":
				System.out
						.println("In a monster room, you can : \n - hit monster \n - run away");
				return this;

			default:
				// System.out.println("The monster is on your way !\nYou can: \n\t- hit monster\n\t- run away");
				System.out.println("You can't do that !");
				return this;
			}
		}

		return super.interpretCommand(command);
	}
}
