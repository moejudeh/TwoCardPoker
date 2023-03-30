import java.util.ArrayList;
import java.util.Collections;


public class Deck extends ArrayList<Card> {

	private static final long serialVersionUID = 1L;
	
	private ArrayList<Card> deck;
	private int numOfCards;
	
	// Deck()
	// creates a deck of 52 cards
	Deck() {
		deck = new ArrayList<Card>();
		char suit[] = {'C', 'D', 'S', 'H'};
		
		for(int i = 0; i < suit.length; i++) {
			for(int j = 2; j <= 14; j++) {
				this.deck.add(new Card(suit[i], j));
			}
		}
		
		Collections.shuffle(this.deck); // shuffles the deck
		this.numOfCards = 52;
	}
	
	// newDeck()
	// creates a new deck of 52 cards
	public void newDeck() {
		this.deck = null;
		
		deck = new ArrayList<Card>();
		char suit[] = {'C', 'D', 'S', 'H'};
		
		for(int i = 0; i < suit.length; i++) {
			for(int j = 2; j <= 14; j++) {
				this.deck.add(new Card(suit[i], j));
			}
		}
		
		Collections.shuffle(this.deck); // shuffles the deck
		this.numOfCards = 52;
	}
	
	// getDeckSize()
	// returns the deck size
	public int getDeckSize() {
		return numOfCards;
	}
	
	// getCard(i)
	// returns the card at index i
	// if deck is empty returns null;
	public Card getCard(int i) {
		if(i >= numOfCards || i < 0) {
			return null;
		}
		return this.deck.get(i);
	}
	
	// pullTopCard()
	// returns the top of the deck and removes the card
	// if deck is empty return null;
	public Card pullTopCard() {
		if(numOfCards == 0) {
			return null;
		}
		Card topCard = this.deck.get(0);
		this.deck.remove(0);
		this.numOfCards--;
		return topCard;
	}
			
}