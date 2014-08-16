package Tiles;

public class Corridor implements Tile {

	@Override
	public boolean moveable() {
		return true;
	}

	@Override
	public char tile() {
		return ',';
	}

	@Override
	public boolean isRoom() {
		return false;
	}

	@Override
	public boolean isPool() {
		return false;
	}

	@Override
	public String roomName() {
		return "Corridor";
	}

	@Override
	public String description() {
		// TODO Auto-generated method stub
		return "This is a Corridor, You use it to move between rooms";
	}

}
