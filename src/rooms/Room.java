package rooms;

import java.util.ArrayList;
import java.util.List;

import characters.Player;
import passages.Passage;

public class Room {
	// A room can open some passages
	protected List<Passage> passagesWhichCanBeOpen;
	protected List<Passage> passages;
	protected String name;
	protected Player player;

	public void enterTheRoom() {
		System.out.println("You are in " + name + ".");
	}

	public Room(String name) {
		this.name = name;
		this.passages = new ArrayList<Passage>();
		this.passagesWhichCanBeOpen = new ArrayList<Passage>();
	}

	public void addPassagesWhichCanBeOpenByThisRoom(Passage passage) {
		passagesWhichCanBeOpen.add(passage);
	}

	protected void openRooms() {
		for (Passage passage : passagesWhichCanBeOpen) {
			passage.open();
		}
	}

	public String getName() {
		return name;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public void setPassages(List<Passage> passages) {
		this.passages = passages;
	}

	public void addPassage(Passage passage) {
		this.passages.add(passage);
	}

	public Passage getPassage(Room room) {
		for (Passage passage : passages) {
			if (passage.getNextRoom().equals(room)) {
				return passage;
			}
		}
		return null;

	}

	public void movePlayer(Room room) {
		room.setPlayer(this.getPlayer());
		setPlayer(null);
	}

	public Room interpretCommand(String command) {
		// the main command "go to "+(an integer) is treated here
		if (command.length() > 6 && command.substring(0, 5).equals("go to")) {
			int whatRoom = -1;

			// the argument of the command "go to" HAVE to be an integer
			try {
				whatRoom = Integer.parseInt(command.substring(6, 7)) - 1;
			} catch (NumberFormatException e) {
				System.out.println("You can't do that (type help to see what are your possibilities)");
				return this;
			}

			// iff the passage number is in the choices and the passage is open,
			// we move the player to the next room
			if (whatRoom < passages.size() && passages.get(whatRoom) != null
					&& passages.get(whatRoom).canPassThrough()) {
				Room nextRoom = passages.get(whatRoom).getNextRoom();
				movePlayer(nextRoom);
				return nextRoom;
			} else {
				System.out.println("You can't do that (type help to see what are your possibilities)");
				return this;
			}
		} else if (command.length() > 8 && command.substring(0, 7).equals("inspect")) {
			for (Passage passage : passagesWhichCanBeOpen) {
				if (passage.getName().equals(command.substring(8))) {
					passage.open();
				}
			}
		} else if (command.equals("find a secret button")) {
			System.out.println("There is no secret button here.");

		} else if (command.equals("see inventory")) {

			if (player.getInventory().getItemList().isEmpty()) {
				System.out.println("Your inventory is empty.");
			} else {
				System.out.println("Your inventory contains :");
				for (int i = 0; i < player.getInventory().getItemList().size(); i++) {
					System.out.println("- " + (i + 1) + ". " + player.getInventory().getItemList().get(i).getName());
				}
			}
			// the main command "use item "+(an integer) is treated here
		} else if (command.length() > 9 && command.substring(0, 8).equals("use item")) {
			int whatItem = -1;
			try {
				whatItem = Integer.parseInt(command.substring(9, 10)) - 1;
			} catch (NumberFormatException e) {
				System.out.println("You can't do that (type help to see what are your possibilities)");
				return this;
			}

			if (whatItem < player.getInventory().getItemList().size()) {
				boolean used = player.getInventory().getItemList().get(whatItem).use(this);
				if (used) {
					player.getInventory().removeItemFromInventory(player.getInventory().getItemList().get(whatItem));
				}
				return this;
			} else {
				System.out.println("You can't do that (type help to see what are your possibilities)");
				return this;
			}
		} else {
			System.out.println("You can't do that (type help to see what are your possibilities)");
		}

		return this;
	}

	public boolean gameIsWon() {
		return false;
	}

	public boolean gameIsLost() {
		if (player != null)
			return player.isDead();
		return false;
	}

	public String inspect() {
		String response = "You see :\n";
		for (int i = 0; i < passages.size(); i++) {
			response += ((i + 1) + " - " + passages.get(i).inspect() + "\n");
		}
		return response;
	}

	public String help() {
		String response = "You can :\n";
		for (int i = 0; i < passages.size(); i++) {
			if (passages.get(i).canPassThrough())
				response += " - go to " + (i + 1) + "\n";
			if (passages.get(i).isHidden())
				response += " - inspect " + passages.get(i).getName() + "\n";
		}
		response += " - see inventory\n";
		for (int i = 0; i < player.getInventory().getItemList().size(); i++) {
			response += " - use item " + (i + 1) + "\n";
		}
		response += " - find a secret button\n";

		return response;
	}
}
