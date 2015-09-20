package dungeon;

public class MonsterRoom extends Room {
	protected Monster monster;
	protected Room lastRoom = null;

	public MonsterRoom(String name) {
		super(name);
		monster = new Monster("dragon");
	}
	
	public boolean gameIsLost() {
		return Dungeon.player.isDead();
	}

	public Monster getMonster() {
		return this.monster;
	}
	
	public void setLastRoom(Room room) {
		this.lastRoom = room;
	}
	
	public Room interpretCommand(String command) {		
		if (!this.monster.isDead()) {
			switch (command) {
			case "hit monster":
				Dungeon.player.sendDamage(this.monster);
				if (!this.monster.isDead()) {
					this.monster.sendDammage(Dungeon.player);
					System.out.println("Your HPs: "+Dungeon.player.getHealthPoints());
					System.out.println("Monster's HPs: "+this.monster.getHealthPoints());
				} else {
					setDoorState(this.northRoom, State.OPENED);
					setDoorState(this.southRoom, State.OPENED);
					setDoorState(this.eastRoom, State.OPENED);
					setDoorState(this.westRoom, State.OPENED);
					System.out.println("Doors are now open");
					System.out.println("Your HPs: "+Dungeon.player.getHealthPoints());
				}
				return this;
			case "run away":
				System.out.println("You ran in the last room visited.");
				return this.lastRoom;
			default:
				System.out.println("The monster is on your way !\nYou can: \n\t- hit monster\n\t- run away");
				return this;
			}
		}
		
		return super.interpretCommand(command);
	}
}
