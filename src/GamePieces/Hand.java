package GamePieces;
import java.util.List;


public class Hand {

	private List<Card> cards;
	
	/**
	 * 
	 * @param cards An ArrayList of cards this hand holds
	 */
	public Hand(List<Card> cards){
		this.cards = cards;
	}
	
	/**
	 *  gets the cards within the hands
	 * @return A list of cards the hand holds
	 */
	public List<Card> getCards(){return cards;}
	
	/**
	 *  Removes a card from the hand
	 * @param c Card to be removed from the hand
	 * @return True if card was in hand, false if not
	 */
	public boolean removeCard(Card c){return cards.remove(c);}
	
	/**
	 * adds a card to the hand
	 * @param c Card to be added
	 * @return False if the card is already in the hand, true if the card is added
	 */
	public boolean addCard(Card c){
		if(cards.contains(c))
				return false;
		return cards.add(c);
	}
}
