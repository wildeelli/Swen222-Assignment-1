
public class Person {
	private Tile loc;
	private String col;
	private Hand hand;
	
	public Person(String col, Tile loc, Hand h){
		this.col = col;
		this.loc = loc;
		this.hand = h;
	}
	
	public Tile getLoc(){return loc;}
	
	public String getCol(){return col;}
	
	public boolean makeAcusation(){
		//TODO: finish this
		return false;
	}

}
