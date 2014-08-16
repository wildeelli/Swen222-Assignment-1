package GamePieces;
import java.awt.Image;


public class Card {
	
	private String name;
	private Image image;
	private Type type;
	
	public enum Type{
		PERSON, ROOM, WEAPON
	}
	/**
	 * 
	 * @param name The name of the card
	 * @param image The image to represent the card on the board
	 * @param type The enum type for the card
	 */
	public Card(String name, Image image, Type type){
		this.name = name;
		this.image = image;
		this.type = type;
	}
	
	/**
	 * Get's the name of the card
	 * @return the name of the card
	 */
	public String getName(){return name;}
	
	/**
	 * Get's the image representing the card
	 * @return the image representing the card
	 */
	public Image getImage(){return image;}
	
	/**
	 * Get's the type of card
	 * @return the type of this card
	 */
	public Type getType(){return type;}
	
	public boolean equals(Card oc){
		return oc.name == this.name && oc.type == this.type;
	}
}
