package rooms;

public class TrapRoom extends Room {

	public TrapRoom(String name) {
		super(name);
	}

	@Override
	public boolean gameIsLost() {
		return player.isDead();
	}

	@Override
	public void enterTheRoom() {
		System.out.println("You are in " + name + ".");
		player.receiveDammage(5);
		System.out.println("The trap make you lost 5 HP.");
		System.out.println("Your HPs: " + player.getHealthPoints());
	}
}
