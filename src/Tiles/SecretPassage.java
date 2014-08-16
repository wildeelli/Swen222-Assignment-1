package Tiles;

public class SecretPassage implements Tile {
	
	private final SecretPassage linkedRoom;
	@SuppressWarnings("unused")
	private final String description;
	private final Room room;
	
	
	
	public SecretPassage(String roomOne, String roomTwo, Room room, Room other){
		this.description = roomOne + " connects to " + roomTwo;
		this.room = room;
		this.linkedRoom = new SecretPassage(roomTwo, roomOne, other, this);
	}
	
	private SecretPassage(String roomOne, String roomTwo, Room room, SecretPassage linked){
		this.description = roomOne + " connects to " + roomTwo;
		this.room = room;
		this.linkedRoom = linked;
	}
	
	/*
	 * This should be called after SecretPassage() to get the other entry/exit to the secret passage
	 */
	public SecretPassage getLinked(){
		return linkedRoom;
	}

	@Override
	public boolean moveable() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public char tile() {
		// TODO Auto-generated method stub
		return '/';
	}

	@Override
	public boolean isRoom() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isPool() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String roomName() {
		// TODO Auto-generated method stub
		return this.room.toString();
	}

	@Override
	public String description() {
		// TODO Auto-generated method stub
		return null;
	}

}
