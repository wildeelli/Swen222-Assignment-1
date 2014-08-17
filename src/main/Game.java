package main;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.util.ArrayList;
import java.util.List;

import sun.awt.image.ImageFormatException;
import GamePieces.Card;
import GamePieces.Person;

public class Game {
	
	List<Person> players;
	List<Card> cards;
	
	
	public Game(){
		players = new ArrayList<Person>();
		loadCards();
	}
	
	public void loadCards(){
		cards = new ArrayList<Card>();
		cards.add(new Card("Candlestick", "assets/weapons/Candlestick-1949.png", Card.Type.WEAPON));
		cards.add(new Card("Knife","assets/weapons/Knife-1949.png", Card.Type.WEAPON));
		cards.add(new Card("Lead Pipe","assets/weapons/Lead-Pipe-1949.png", Card.Type.WEAPON));
		cards.add(new Card("Revolver","assets/weapons/Revoler-1949.png", Card.Type.WEAPON));
		cards.add(new Card("Rope","assets/weapons/Rope-1949.png", Card.Type.WEAPON));
		cards.add(new Card("Wrench","assets/weapons/Wrench-1949.png", Card.Type.WEAPON));
	}
}
