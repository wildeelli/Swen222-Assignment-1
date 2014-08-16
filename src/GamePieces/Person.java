package GamePieces;
import Tiles.*;


public class Person {
	private Tile loc;
	private String col;
	private Hand hand;
	
	/**
	 * 
	 * @param col Colour of the person
	 * @param loc Tile in which the person starts from
	 * @param h The person's hand
	 */
	public Person(String col, Tile loc, Hand h){
		this.col = col;
		this.loc = loc;
		this.hand = h;
	}
	
	/**
	 * Get's the tile the person is on
	 * @return the tile the piece is currently on
	 */
	public Tile getLoc(){return loc;}
	
	/**
	 * Get's the pieces colour
	 * @return The colour of the piece
	 */
	public String getCol(){return col;}
	
	/**
	 * moves the piece to said tile
	 * @param newT the tile the piece is moving too
	 * @param diceCount the number currently shown on the dice
	 * @return True if the player moves. False if the player does not have enough on dice to move
	 */
	public boolean move(Tile newT, int diceCount){
		//TODO: route finding to get from tile to newT
		return false;
	}
	
	/**
	 * Makes an accusation
	 * @return True if the acusation is correct. False if it is wrong
	 */
	public boolean makeAcusation(){
		//TODO: finish this
		return false;
	}

}
