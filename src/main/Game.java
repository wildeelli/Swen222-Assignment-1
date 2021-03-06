package main;


import game.newPlayerWindow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JOptionPane;

import board.Board;
import GamePieces.Acusation;
import GamePieces.Card;
import GamePieces.Person;

public class Game {
	
	private List<Person> players;
	private List<Card> cards;
	private Acusation murder;
	private int currentPlayer;
	private int playerCount;
	
	
	
	public Game(int pcount){
		playerCount=pcount;
		players = new ArrayList<Person>(playerCount);//TODO: get the players from somewhere
		
		Person[] persons = newPlayerWindow.playerWindow(playerCount);
		for (Person p: persons) players.add(p);
		loadCards();
		
		//Shuffles the cards, and hands them out to players
		distributCards();
		currentPlayer = 0;
		main.ProgMain.main.drawNewHand(getCurPlayer());
	}
	
	/**
	 * loads the cards into the cards array, and sets up a new murderer.
	 * The cards for the murderer, his weapon, and his location are not added
	 */
	private void loadCards(){
		//load weapons and select index for murder weapon
		ArrayList<Card> weapons = new ArrayList<Card>();
		weapons.add(new Card("Candlestick", "assets/weapons/Candlestick-1949.png", Card.Type.WEAPON));
		weapons.add(new Card("Knife","assets/weapons/Knife-1949.png", Card.Type.WEAPON));
		weapons.add(new Card("Lead Pipe","assets/weapons/Lead-Pipe-1949.png", Card.Type.WEAPON));
		weapons.add(new Card("Revolver","assets/weapons/Revolver-1949.png", Card.Type.WEAPON));
		weapons.add(new Card("Rope","assets/weapons/Rope-1949.png", Card.Type.WEAPON));
		weapons.add(new Card("Wrench","assets/weapons/Wrench-1949.png", Card.Type.WEAPON));
		Collections.shuffle(weapons);
		
		//load rooms and select an index for murder location
		ArrayList<Card> rooms = new ArrayList<Card>();
		rooms.add(new Card("Ballroom","assets/rooms/Ballroom.jpg",Card.Type.ROOM));
		rooms.add(new Card("Billiards Room","assets/rooms/Billiards-room.jpg",Card.Type.ROOM));
		rooms.add(new Card("Conservatory","assets/rooms/Conservatory.jpg",Card.Type.ROOM));
		rooms.add(new Card("Dining Room","assets/rooms/Dining-Room.jpg",Card.Type.ROOM));
		rooms.add(new Card("Hall","assets/rooms/Hall.jpg",Card.Type.ROOM));
		rooms.add(new Card("Kitchen","assets/rooms/Kitchen.jpg",Card.Type.ROOM));
		rooms.add(new Card("Library","assets/rooms/Library.jpg",Card.Type.ROOM));
		rooms.add(new Card("Lounge","assets/rooms/Lounge.jpg",Card.Type.ROOM));
		rooms.add(new Card("Study","assets/rooms/Study.jpg",Card.Type.ROOM));
		Collections.shuffle(rooms);
		
		//load people and select an index for murderer
		ArrayList<Card> people = new ArrayList<Card>();
		people.add(new Card("Colonel Mustard","assets/people/Colonel-Mustard.jpg",Card.Type.PERSON));
		people.add(new Card("Miss Scarlet","assets/people/Miss-Scarlet.jpg",Card.Type.PERSON));
		people.add(new Card("Mr Green","assets/people/Mr-Green.jpg",Card.Type.PERSON));
		people.add(new Card("Mrs Peacock","assets/people/Mrs-Peacock.jpg",Card.Type.PERSON));
		people.add(new Card("Mrs White","assets/people/Mrs-White.jpg",Card.Type.PERSON));
		people.add(new Card("Prof Plum","assets/people/Prof-Plum.jpg",Card.Type.PERSON));
		Collections.shuffle(people);
		
		//creates the correct accusation & removes those cards from the list
		murder = new Acusation(weapons.remove(0), people.remove(0), rooms.remove(0));
		
		//finally merges the three lists to a single list
		cards = new ArrayList<>();
		cards.addAll(weapons);
		cards.addAll(rooms);
		cards.addAll(people);
	}
	
	/**
	 * takes the cards array, and empties it into player hands
	 */
	private void distributCards(){
		Collections.shuffle(cards);
		int numCards = (cards.size()+1)/(players.size()+1);
		int spareCards = (cards.size()+1)/(players.size()+1);
		//loops through the players giving them hands
		for(Person player: players){
			ArrayList<Card> hand = new ArrayList<Card>();
			for(int i = 0; i < numCards; i++){
				hand.add(cards.remove(0));
			}
			if(spareCards >= 1){
				hand.add(cards.remove(0));
			}
			player.giveCards(hand);
		}
	}
	
	/**
	 * get the players of the game
	 * @return The players in the game
	 */
	public List<Person> getPlayers(){ return players;}
	
	/**
	 * gets the current player
	 * @return the current player or null if no players
	 */
	public Person getCurPlayer(){
		if(players.isEmpty())
			return null;
		return players.get(currentPlayer);
	}
	
	/**
	 * Make a suggestion that can be disproved by other players
	 * @param weapon weapon used
	 * @param room room it was in
	 * @param person person you suspect
	 * @return true if no one can object, otherwise false. Currently doesn't work
	 */
	public boolean makeSuggestion(Card weapon, Card room, Card person){
		
		return false;
	}
	
	/**
	 * makes an accusation either winning the game, or removing the player
	 * @return true if the game is won. False if the player is removed from play
	 */
	public boolean MakeAcusation(Card weapon, Card room, Card person){
		if(murder.checkAcusation(weapon, person, room)){
			JOptionPane.showMessageDialog(null, "Conragulations you have won the game");
			return true;
		}
		else{
			players.remove(currentPlayer);
			if(players.isEmpty()){
				JOptionPane.showMessageDialog(null,"BAD LACK \n Game Over");
			}
			return false;
		}
	}
	/**
	 * moves the player to the inputed tile
	 * @param tile The tile to move to
	 * @return true if the player can move, false otherwise
	 */
	public boolean Move(int x, int y, Board board){
		if(players.isEmpty())
			return false;
		return players.get(currentPlayer).move(x,y,board);
	}
	
	/**
	 * makes the current player roll the dice
	 */
	public void rollDice(){
		players.get(currentPlayer).rollDice();
	}
	
	/**
	 * ends the turn of the current player
	 */
	public void endTurn(){
		if(players.isEmpty())
			return;
		currentPlayer++;
		if (currentPlayer >= players.size())
			currentPlayer=0;
		System.out.println(main.ProgMain.main==null);
		main.ProgMain.main.drawNewHand(getCurPlayer());
	}
}
