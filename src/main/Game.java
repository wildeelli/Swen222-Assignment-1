package main;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import GamePieces.Acusation;
import GamePieces.Card;
import GamePieces.Person;

public class Game {
	
	private List<Person> players;
	private List<Card> cards;
	private Acusation murder;
	
	
	
	public Game(){
		players = new ArrayList<Person>();//TODO: get the players from somewhere
		loadCards();
		
		//Shuffles the cards, and hands them out to players
		distributCards();
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
		weapons.add(new Card("Revolver","assets/weapons/Revoler-1949.png", Card.Type.WEAPON));
		weapons.add(new Card("Rope","assets/weapons/Rope-1949.png", Card.Type.WEAPON));
		weapons.add(new Card("Wrench","assets/weapons/Wrench-1949.png", Card.Type.WEAPON));
		Collections.shuffle(weapons);
		
		//load rooms and select an index for murder location
		ArrayList<Card> rooms = new ArrayList<Card>();
		rooms.add(new Card("Ballroom","Ballroom.jpg",Card.Type.ROOM));
		rooms.add(new Card("Billiard Room","Billiard-room.jpg",Card.Type.ROOM));
		rooms.add(new Card("Conservatory","Conservatory.jpg",Card.Type.ROOM));
		rooms.add(new Card("Dining Room","Dining-room.jpg",Card.Type.ROOM));
		rooms.add(new Card("Hall","Hall.jpg",Card.Type.ROOM));
		rooms.add(new Card("Kitchen","Kitchen.jpg",Card.Type.ROOM));
		rooms.add(new Card("Library","Library.jpg",Card.Type.ROOM));
		rooms.add(new Card("Lounge","Lounge.jpg",Card.Type.ROOM));
		rooms.add(new Card("Study","Study.jpg",Card.Type.ROOM));
		Collections.shuffle(rooms);
		
		//load people and select an index for murderer
		ArrayList<Card> people = new ArrayList<Card>();
		people.add(new Card("Colonel Mustard","Colonel-Mustard.jpg",Card.Type.PERSON));
		people.add(new Card("Miss Scarlet","Miss-Scarlet.jpg",Card.Type.PERSON));
		people.add(new Card("Mr Green","Mr-Green.jpg",Card.Type.PERSON));
		people.add(new Card("Mrs Peacock","Mrs-Peacock.jpg",Card.Type.PERSON));
		people.add(new Card("Mrs White","Mrs-White.jpg",Card.Type.PERSON));
		people.add(new Card("Prof Plum","Prof-Plum.jpg",Card.Type.PERSON));
		Collections.shuffle(people);
		
		//creates the correct acusation & removes those cards from the list
		murder = new Acusation(weapons.get(0), people.get(0), rooms.get(0));
		weapons.remove(0);
		people.remove(0);
		rooms.remove(0);
		
		//finally merges the three lists to a single list
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
			for(int i = 0; i <= numCards; i++){
				hand.add(cards.get(0));
				cards.remove(0);
			}
			if(spareCards >= 1){
				hand.add(cards.get(0));
				cards.remove(0);
			}
			player.giveCards(hand);
		}
	}
}
