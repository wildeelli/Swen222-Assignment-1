package Tiles;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Room implements Tile {
	
	private final String name;
	private final List<Doorway> doorways;
	
	public Room(String roomName){
		this.name = roomName;
		this.doorways = new ArrayList<>();
	}
	
	public List<Doorway> doorways(){
		return Collections.unmodifiableList(doorways);
	}
	
	public boolean addDoorway(Doorway d){
		return doorways.add(d);
	}

	@Override
	public boolean moveable() {
		return false;
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
	public String roomName() {
		return this.name;
	}

	@Override
	public String description() {
		// TODO Auto-generated method stub
		return "This is the " + this.name + " room.";
	}

}
