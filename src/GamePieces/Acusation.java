package GamePieces;

public class Acusation {
	
	private final Card weapon;
	private final Card person;
	private final Card room;
	
	public Acusation(Card wep, Card per, Card room){
		this.weapon = wep;
		this.person = per;
		this.room = room;
	}
	
	public boolean checkAcusation(Card wep, Card per, Card room){
		if(wep.equals(this.weapon) && per.equals(this.person) && room.equals(this.room)){
			return true;
		}
		return false;
	}

}
