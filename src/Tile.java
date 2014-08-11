
public interface Tile {
	boolean moveable();
	char tile();
	boolean isRoom();
	boolean isPool();
	String roomName();
	String description();
}
