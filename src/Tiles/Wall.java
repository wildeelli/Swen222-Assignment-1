package Tiles;

public class Wall implements Tile {

	@Override
	public boolean moveable() {
		return false;
	}

	@Override
	public char tile() {
		return '#';
	}

	@Override
	public boolean isRoom() {
		return false;
	}

	@Override
	public String roomName() {
		return "Wall";
	}

	@Override
	public String description() {
		// TODO Auto-generated method stub
		return "This is a wall, you can't walk through it, Yet.";
	}

}
