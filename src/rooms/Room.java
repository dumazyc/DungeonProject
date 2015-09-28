package rooms;

import java.util.ArrayList;
import java.util.List;

import characters.Player;
import passages.Passage;

public class Room {

	protected List<Passage> passages;
	protected String name;
	protected Player player;

	public void enterTheRoom() {
		System.out.println("You are in " + name + ".");

	}

	public Room(String name) {
		this.name = name;
		this.passages = new ArrayList<Passage>();
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
	
	public Passage getPassage(Room room){
		for (Passage passage : passages) {
			if(passage.getNextRoom().equals(room)){
				return passage;
			}
		}
		return null;
		
	}
	
	protected Room goToThisRoom(Passage passage) {
		if (passage != null && passage.canPassThrough()) {
			return passage.getNextRoom();
		} else {
			System.out.println("No way !");
			return this;
		}
	}

	public void movePlayer(Room room) {
		room.setPlayer(this.getPlayer());
		setPlayer(null);
	}
	
	public Room interpretCommand(String command) {
		if (command.length() > 6 && command.substring(0, 5).equals("go to")) {
			int whatRoom = Integer.parseInt(command.substring(6, 7)) - 1;
			if (whatRoom < passages.size() && passages.get(whatRoom) != null && passages.get(whatRoom).canPassThrough()) {
				Room nextRoom = passages.get(whatRoom).getNextRoom();
				movePlayer(nextRoom);
				return nextRoom;
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
			response += ((i+1) + " - " + passages.get(i).inspect() + "\n");
		}
		return response;
	}

	public String help() {
		String response = "You can :\n";
		for (int i = 0; i < passages.size(); i++) {
			if (passages.get(i).canPassThrough())
				response += " - go to "+(i+1)+"\n";
			if (passages.get(i).isHidden())
				response += " - inspect "+passages.get(i).getName()+"\n";
		}
		return response;
	}

	public boolean hasCombat() {
		return false;
	}
}
