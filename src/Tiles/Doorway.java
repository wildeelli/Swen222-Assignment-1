package Tiles;

public class Doorway implements Tile {
	
	private final Room room;
	public final int x, y;
	
	public Doorway(Room r, int x, int y){
		this.room=r;
		this.x=x;
		this.y=y;
		this.room.addDoorway(this);
	}
	
	public Room room(){
		return room;
	}

	@Override
	public boolean moveable() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public char tile() {
		// TODO Auto-generated method stub
		return Character.toUpperCase(room.tile());
	}

	@Override
	public boolean isRoom() {
		return true;
	}

	@Override
	public String roomName() {
		return room.roomName();
	}

	@Override
	public String description() {
		return "This is an entrance to " + roomName();
	}

}
