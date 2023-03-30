import java.util.Comparator;

public class Card {
	
	private char suit;
	private int value;

	// Card(suit, value)
	// creates a card with a suit and value
	Card(char suit, int value) {
		this.suit = suit;
		this.value = value;
	}
	
	// getSuit()
	// returns the suit of the card
	public char getSuit() {
		return suit;
	}
	
	// getValue()
	// returns the value of the card
	public int getValue() {
		return value;
	}
	
	// equals(card2)
	// testing if two cards are equal to eachother
	public boolean equals(Card c1) {
		if (c1 == null) {
			return false;
		}
		if (c1 == this) {
			return true;
		}
		return this.getSuit() == c1.getSuit() && this.getValue() == c1.getValue();
	}
	
	// toString()
	// returns a string of a card in "'Value' of 'Suit'"
	@Override
	public String toString() {
		return this.getValue() + "of" + this.getSuit();
	}
}

// used to sort the cards by value from least to greatest
class CardComparator implements Comparator<Card> {
    public int compare(Card card1, Card card2) {
        return card1.getValue() - card2.getValue();
    }
}