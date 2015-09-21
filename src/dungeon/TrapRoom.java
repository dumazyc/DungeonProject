package dungeon;

public class TrapRoom extends Room {

	public TrapRoom(String name) {
		super(name);
	}

	public boolean gameIsLost() {
		return false;
	}

	public void enterTheRoom() {
		System.out.println("You are in " + name + ".");
		Dungeon.player.receiveDammage(5);
		System.out.println("The trap make you lost 5 HP.");
		System.out.println("Your HPs: " + Dungeon.player.getHealthPoints());
	}
}
