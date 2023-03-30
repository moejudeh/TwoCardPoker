import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class DeckTest {
	
	// Testing thre deck constructor
	@Test
	void constructorTest() {
		Deck theDeck = new Deck();
		assertEquals(52, theDeck.getDeckSize(), "Deck not right length");
	}
	
	// testing the out of bounds of the getCard(index) method
	@Test
	void getCardTest() {
		Deck theDeck = new Deck();
		assertEquals(52, theDeck.getDeckSize(), "Deck not right length");
		assertEquals(null, theDeck.getCard(52), "out of bounds");
		assertEquals(null, theDeck.getCard(-1), "out of bounds");
	}
	
	// testing the getDeckSize method to see if it updates
	@Test
	void getDeckSizeTest() {
		Deck theDeck = new Deck();
		assertEquals(52, theDeck.getDeckSize(), "Deck not right length");
		theDeck.pullTopCard();
		assertEquals(51, theDeck.getDeckSize(), "Deck not right length");
		for(int i = 0; i < 5; i++) {
			theDeck.pullTopCard();
		}
		assertEquals(46, theDeck.getDeckSize(), "Deck not right length");
	}
	
	
	
	// testing the newDeck() method on a full deck
	@Test
	void newDeckTest() {
		Deck theDeck = new Deck();
		assertEquals(52, theDeck.getDeckSize(), "Deck not right length");
		Card topCard = theDeck.getCard(0);
		theDeck.newDeck();
		assertEquals(52, theDeck.getDeckSize(), "Deck not right length");
		assertEquals(false, theDeck.getCard(0).equals(topCard));
	}
	
	
	// testing the newDeck() method to see if it adds all cards back
	@Test
	void newDeckTest1() {
		Deck theDeck = new Deck();
		for(int i = 0; i < 10; i++) {
			theDeck.pullTopCard();
		}
		assertEquals(42, theDeck.getDeckSize(), "Deck not right length");
		theDeck.newDeck();
		assertEquals(52, theDeck.getDeckSize(), "Deck not right length");
	}
	
	// emptying a deck and then testing new deck
	@Test
	void newDeckTest2() {
		Deck theDeck = new Deck();
		for (int i = 0; i < 52; i++) {
			theDeck.pullTopCard();
		}
		assertEquals(0, theDeck.getDeckSize(), "Deck not right length");
		theDeck.newDeck();
		assertEquals(52, theDeck.getDeckSize(), "Deck not right length");
	}
	
	
	// testing topCard() method
	@Test
	void topCardTest() {
		Deck theDeck = new Deck();
		assertEquals(52, theDeck.getDeckSize(), "Deck not right length");
		Card c1 = theDeck.getCard(0);
		Card c2 = theDeck.pullTopCard();
		assertEquals(51, theDeck.getDeckSize(), "Deck not right length");
		assertEquals(true, c1.equals(c2), "Pulled wrong card");
	}
} 