package GamePieces;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Tiles.*;


public class Person {
	private Tile loc;
	private String name;
	private String col;
	private List<Card> hand;
	private Random diceOne;
	private Random diceTwo;
	private int movesLeft;
	
	/**
	 * 
	 * @param col Colour of the person
	 * @param loc Tile in which the person starts from
	 * @param h The person's hand
	 */
	public Person(String name, String col, Tile loc){
		this.name = name;
		this.col = col;
		this.loc = loc;
		this.hand = new ArrayList<Card>();
		this.diceOne = new Random();
		this.diceTwo = new Random();
	}
	
	public void giveCards(List<Card> cards){
		hand.addAll(cards);
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
	 * Get's the player of the piece's name
	 * @return The players name
	 */
	public String getName(){return name;}

	/**
	 * Rolls the dice and updates how many moves the player has. 
	 * Should only be called at the start of the players turn.
	 * @return The number of moves the player has for this turn
	 */
	public int rollDice(){
		movesLeft = (diceOne.nextInt(6)+1) + (diceTwo.nextInt(6)+1);
		return movesLeft;
	}
	
	/**
	 * moves the piece to said tile
	 * @param newT the tile the piece is moving too
	 * @return True if the player moves. False if the player does not have enough on dice to move
	 */
	public boolean move(Tile newT){
		//TODO: route finding to get from tile to newT
		return false;
	}
	
	/**
	 * Makes an accusation
	 * @return True if the accusation is correct. False if it is wrong
	 */
	public boolean makeAcusation(){
		//TODO: finish this
		return false;
	}

}
