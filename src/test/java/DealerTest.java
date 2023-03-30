import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


class DealerTest {
	
	// constructor test
	@Test
	void ConstructorTest() {
		Dealer theDealer = new Dealer();
		assertEquals(52, theDealer.getDeck().getDeckSize(), "Deck Size Incorrect");
	}
	
	// pulling from a full deck
	@Test
	void dealHandTest() {
		Dealer theDealer = new Dealer();
		theDealer.setHand(theDealer.dealHand());
		assertEquals(49, theDealer.getDeck().getDeckSize(), "Deck size not updated");
	}
	
	// pulling when not enough cards
	@Test
	void dealHandTest1() {
		Dealer theDealer = new Dealer();
		for(int i = 0; i < 30; i++) {
			theDealer.getDeck().pullTopCard();
		}
		assertEquals(22, theDealer.getDeck().getDeckSize(), "Deck size not updated");
		theDealer.setHand(theDealer.dealHand());
		theDealer.getHand();
		assertEquals(49, theDealer.getDeck().getDeckSize(), "Deck size not updated");
		theDealer.setHand(theDealer.dealHand());
		theDealer.getHand();
		assertEquals(46, theDealer.getDeck().getDeckSize(), "Deck size not updated");
	}
	
	
}