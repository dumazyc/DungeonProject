package rooms;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import passages.Passage;

public class Room {
//	protected Room northRoom;
//	protected Room southRoom;
//	protected Room eastRoom;
//	protected Room westRoom;

	protected List<Passage> passages;
	protected String name;

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

	

	public void setRooms(List<Passage> passages) {
		this.passages = passages;
	}


	protected Room goToThisRoom(Passage passage) {
		if (passage != null && passage.canPassThrough()) {

			return room;
		} else {
			System.out.println("No way !");
			return this;
		}
	}
	
	public void openRooms() {
		setDoorState(this.northRoom, State.OPENED);
		setDoorState(this.southRoom, State.OPENED);
		setDoorState(this.eastRoom, State.OPENED);
		setDoorState(this.westRoom, State.OPENED);
	}

	public Room interpretCommand(String command) {
		if (command.substring(0,2).equals("go")) {
			int whatRoom = Integer.parseInt(command.substring(2));
			if(whatRoom<passages.size() && passages.get(whatRoom)!= null && passages.get(whatRoom).canPassThrough()){
				return passages.get(whatRoom).getNextRoom();
			}else{
				return this;
			}
		}else if(command.equals("help")){
			return null;
		}
	}

	public boolean gameIsWon() {
		return false;
	}

	public boolean gameIsLost() {
		return false;
	}

	public void inspect() {
		String response = "You see :\n";

		if (northRoom != null) {
			response += "  - " + inspectDoor(northRoom) + " in front of you.\n";
		}
		if (southRoom != null) {
			response += "  - " + inspectDoor(southRoom) + " behind you.\n";
		}
		if (eastRoom != null) {
			response += "  - " + inspectDoor(eastRoom) + " on your right.\n";
		}
		if (westRoom != null) {
			response += "  - " + inspectDoor(westRoom) + " on your left.\n";
		}
		System.out.println(response);
	}

	public String inspectDoor(Room room) {
		if (room != null) {
			if (this.getDoorState(room) == State.OPENED) {
				return "An opened door";
			} else if (this.getDoorState(room) == State.CLOSED) {
				return "A closed door";
			} else if (this.getDoorState(room) == State.HIDDEN) {
				return "A painting";
			}
		}
		return null;
	}

}
