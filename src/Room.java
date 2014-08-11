
public class Room implements Tile {
	
	private final String name;
	
	public Room(String roomName){
		this.name = roomName;
	}

	@Override
	public boolean moveable() {
		return true;
	}

	@Override
	public char tile() {
		return '.';
	}

	@Override
	public boolean isRoom() {
		return true;
	}

	@Override
	public boolean isPool() {
		return false;
	}

	@Override
	public String roomName() {
		return this.name;
	}

	@Override
	public String description() {
		// TODO Auto-generated method stub
		return "This is the " + this.name + " room.";
	}

}
