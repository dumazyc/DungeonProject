package dungeon;

public class Room {
	private Room northRoom;
	private Room southRoom;
	private Room eastRoom;
	private Room westRoom;
	private boolean gameIsWon;
	private String name;

	
	public Room(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	
	public void setRooms(Room northRoom, Room southRoom, Room eastRoom, Room westRoom){
		this.northRoom = northRoom;
		this.southRoom = southRoom;
		this.eastRoom = eastRoom;
		this.westRoom = westRoom;
	}

	public Room goToNorthRoom() {
		if (northRoom != null) {
			return northRoom;
		} else {
			System.out.println("No way !");
			return this;
		}
	}

	public Room goToSouthRoom() {
		if (southRoom != null) {
			return northRoom;
		} else {
			System.out.println("No way !");
			return this;
		}
	}

	public Room goToEastRoom() {
		if (eastRoom != null) {
			return northRoom;
		} else {
			System.out.println("No way !");
			return this;
		}
	}

	public Room goToWestRoom() {
		if (westRoom != null) {
			return northRoom;
		} else {
			System.out.println("No way !");
			return this;
		}
	}

	public boolean gameIsWon() {
		return gameIsWon;
	}

	@Override
	public String toString() {
		String response = name+" : ";
		if(northRoom!=null){
			response+=northRoom.getName()+" ";
		}else{
			response+="null ";
		}
		if(southRoom!=null){
			response+=southRoom.getName()+" ";
		}else{
			response+="null ";
		}
		if(eastRoom!=null){
			response+=eastRoom.getName()+" ";
		}else{
			response+="null ";
		}
		if(westRoom!=null){
			response+=westRoom.getName()+" ";
		}else{
			response+="null ";
		}
		return response;
	}
	

}
