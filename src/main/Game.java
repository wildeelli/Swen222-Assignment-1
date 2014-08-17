package main;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import GamePieces.Acusation;
import GamePieces.Card;
import GamePieces.Person;

public class Game {
	
	private List<Person> players;
	private List<Card> cards;
	private Acusation murder;
	
	
	
	public Game(){
		players = new ArrayList<Person>();
		loadCards();
	}
	
	public void loadCards(){
		//load weapons and select index for murder weapon
		ArrayList<Card> weapons = new ArrayList<Card>();
		weapons.add(new Card("Candlestick", "assets/weapons/Candlestick-1949.png", Card.Type.WEAPON));
		weapons.add(new Card("Knife","assets/weapons/Knife-1949.png", Card.Type.WEAPON));
		weapons.add(new Card("Lead Pipe","assets/weapons/Lead-Pipe-1949.png", Card.Type.WEAPON));
		weapons.add(new Card("Revolver","assets/weapons/Revoler-1949.png", Card.Type.WEAPON));
		weapons.add(new Card("Rope","assets/weapons/Rope-1949.png", Card.Type.WEAPON));
		weapons.add(new Card("Wrench","assets/weapons/Wrench-1949.png", Card.Type.WEAPON));
		int accWep = new Random().nextInt(weapons.size());
		
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
		int accRoom = new Random().nextInt(rooms.size());
		
		//load people and select an index for murderer
		ArrayList<Card> people = new ArrayList<Card>();
		people.add(new Card("Colonel Mustard","Colonel-Mustard.jpg",Card.Type.PERSON));
		people.add(new Card("Miss Scarlet","Miss-Scarlet.jpg",Card.Type.PERSON));
		people.add(new Card("Mr Green","Mr-Green.jpg",Card.Type.PERSON));
		people.add(new Card("Mrs Peacock","Mrs-Peacock.jpg",Card.Type.PERSON));
		people.add(new Card("Mrs White","Mrs-White.jpg",Card.Type.PERSON));
		people.add(new Card("Prof Plum","Prof-Plum.jpg",Card.Type.PERSON));
		int accPer = new Random().nextInt(rooms.size());
		
		//creates the correct acusation & removes those cards from the list
		murder = new Acusation(weapons.get(accWep), people.get(accPer), rooms.get(accRoom));
		weapons.remove(accWep);
		people.remove(accPer);
		rooms.remove(accWep);
		
		//finally merges the three lists to a single list
		cards.addAll(weapons);
		cards.addAll(rooms);
		cards.addAll(people);
	}
}
