package Tiles;

public interface Tile {
	boolean moveable();
	char tile();
	boolean isRoom();
	String roomName();
	String description();
}
