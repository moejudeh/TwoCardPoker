import java.util.ArrayList;

public class Dealer {
	
	private Deck theDeck;
	private ArrayList<Card> dealersHand;
	
	// Dealer()
	// creates a deck of 52 cards and sets up dealer hand
	Dealer() {
		theDeck = new Deck();
		dealersHand = null;
	}
	
	
	// dealHand()
	// the dealer checks to see if there is more than 34 cards in deck
	// if not the dealer reshuffles the deck with all the cards
	// the dealer then sends out cards to a plyer
	public ArrayList<Card> dealHand() {
		ArrayList<Card> hand = new ArrayList<Card>();
		if(this.theDeck.getDeckSize() <= 34) {
			this.theDeck.newDeck();
		}
		for(int i = 0; i < 3; i++) {
			hand.add(theDeck.pullTopCard());
		}
		return hand;
	}
	
	
	// getDeck()
	// returns the deck that the dealer has
	public Deck getDeck() {
		return this.theDeck;
	}
	
	
	// setDeck(d)
	// sets theDeck to d
	public void setDeck(Deck d) {
		this.theDeck = d;
	}
	
	// getHand()
	// returns the hand of the dealer
	public ArrayList<Card> getHand() {
		return this.dealersHand;
	}
	
	// setHand(hand)
	// sets the dealers hand to hand
	public void setHand(ArrayList<Card> hand) {
		this.dealersHand = null;
		this.dealersHand = hand;
	}
	
	public void newRound() {
		this.dealersHand = null;
	}
	
	public void newGame() {
		theDeck.newDeck();
		this.dealersHand = null;
	}
}