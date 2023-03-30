import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;


class ThreeCardLogicTest {
	
	// testing evalHand method - high card
	@Test
	void evalHandHighCardTest() {
		ArrayList<Card> highCard = new ArrayList<Card>();
		highCard.add(new Card('D', 4));
		highCard.add(new Card('H', 3));
		highCard.add(new Card('S', 9));
		assertEquals(3, highCard.size(), "wrong size");
		
		int eval = ThreeCardLogic.evalHand(highCard);
		assertEquals(0, eval, "Not High Card");
	}
	
	// testing evalHand method - pair
	@Test
	void evalHandPairTest() {
		ArrayList<Card> pair = new ArrayList<Card>();
		pair.add(new Card('D', 4));
		pair.add(new Card('S', 4));
		pair.add(new Card('H', 9));
		
		int eval = ThreeCardLogic.evalHand(pair);
		assertEquals(5, eval, "Not a Pair");
	}
	
	// testing evalHand method - pair - different order
	@Test
	void evalHandPairTest1() {
		ArrayList<Card> pair = new ArrayList<Card>();
		pair.add(new Card('D', 4));
		pair.add(new Card('D', 3));
		pair.add(new Card('H', 4));
		
		int eval = ThreeCardLogic.evalHand(pair);
		assertEquals(5, eval, "Not a Pair");
	}
	
	
	// testing evalHand method - flush
	@Test
	void evalHandFlushTest() {
		ArrayList<Card> flush = new ArrayList<Card>();
		flush.add(new Card('D', 4));
		flush.add(new Card('D', 3));
		flush.add(new Card('D', 8));
		
		int eval = ThreeCardLogic.evalHand(flush);
		assertEquals(4, eval, "Not a Flush");
	}
	
	
	// testing evalHand method - straight - inorder
	@Test
	void evalHandStraightTest() {
			ArrayList<Card> straight = new ArrayList<Card>();
			straight.add(new Card('D', 3));
			straight.add(new Card('D', 4));
			straight.add(new Card('H', 5));	
			
			int eval = ThreeCardLogic.evalHand(straight);
			assertEquals(3, eval, "Not a Straight");
	}
	
	// testing evalHand method - straight - reverse
	@Test
	void evalHandStraightTest1() {
			ArrayList<Card> straight = new ArrayList<Card>();
			straight.add(new Card('D', 7));
			straight.add(new Card('D', 6));
			straight.add(new Card('H', 5));	
			
			int eval = ThreeCardLogic.evalHand(straight);
			assertEquals(3, eval, "Not a Straight");
	}
	
	// testing evalHand method - straight - out of order
	@Test
	void evalHandStraightTest2() {
			ArrayList<Card> straight = new ArrayList<Card>();
			straight.add(new Card('D', 6));
			straight.add(new Card('C', 7));
			straight.add(new Card('H', 5));	
			
			int eval = ThreeCardLogic.evalHand(straight);
			assertEquals(3, eval, "Not a Straight");
	}
	
	// testing evalHand method - straight - Q K Ace
	@Test
	void evalHandStraightTest3() {
		ArrayList<Card> straight = new ArrayList<Card>();
		straight.add(new Card('D', 12));
		straight.add(new Card('C', 13));
		straight.add(new Card('H', 14));
		
		int eval = ThreeCardLogic.evalHand(straight);
		assertEquals(3, eval, "Not a straight");
	}
	
	// testing evalHand method - three of a kind
	@Test
	void evalHandThreeTest() {
		ArrayList<Card> three = new ArrayList<Card>();
		three.add(new Card('D', 8));
		three.add(new Card('C', 8));
		three.add(new Card('H', 8));
		
		int eval = ThreeCardLogic.evalHand(three);
		assertEquals(2, eval, "Not Three of a Kind");
	}
	
	
	// testing evalHand method - straightFlush - inorder
	@Test
	void evalHandStraightFlushTest() {
			ArrayList<Card> straightFlush = new ArrayList<Card>();
			straightFlush.add(new Card('D', 3));
			straightFlush.add(new Card('D', 4));
			straightFlush.add(new Card('D', 5));	
			
			int eval = ThreeCardLogic.evalHand(straightFlush);
			assertEquals(1, eval, "Not a Straight Flush");
	}
	
	// testing evalHand method - straightFlush - reverse
	@Test
	void evalHandStraightFlushTest1() {
			ArrayList<Card> straightFlush = new ArrayList<Card>();
			straightFlush.add(new Card('H', 7));
			straightFlush.add(new Card('H', 6));
			straightFlush.add(new Card('H', 5));	
			
			int eval = ThreeCardLogic.evalHand(straightFlush);
			assertEquals(1, eval, "Not a Straight Flush");
	}
	
	// testing evalHand method - straight - out of order
	@Test
	void evalHandStraightFlushTest2() {
			ArrayList<Card> straightFlush = new ArrayList<Card>();
			straightFlush.add(new Card('C', 6));
			straightFlush.add(new Card('C', 7));
			straightFlush.add(new Card('C', 5));	
			
			int eval = ThreeCardLogic.evalHand(straightFlush);
			assertEquals(1, eval, "Not a Straight Flush");
	}
	
	
	// testing evalPPWinnings method - high card
	@Test
	void evalPPWinningsHighCardTest() {
		ArrayList<Card> highCard = new ArrayList<Card>();
		highCard.add(new Card('D', 4));
		highCard.add(new Card('H', 3));
		highCard.add(new Card('S', 9));
		assertEquals(3, highCard.size(), "wrong size");
		
		int winnings = ThreeCardLogic.evalPPWinnings(highCard, 20);
		assertEquals(0, winnings, "Wrong Winnings Amount");
	}
	
	// testing evalPPWinnings method - Pair
	@Test
	void evalPPWinningsPairTest() {
		ArrayList<Card> pair = new ArrayList<Card>();
		pair.add(new Card('D', 4));
		pair.add(new Card('H', 3));
		pair.add(new Card('S', 4));
		assertEquals(3, pair.size(), "wrong size");
		
		int winnings = ThreeCardLogic.evalPPWinnings(pair, 15);
		assertEquals(30, winnings, "Wrong Winnings Amount");
	}
	
	// testing evalPPWinnings method - Flush
	@Test
	void evalPPWinningsFlushTest() {
		ArrayList<Card> flush = new ArrayList<Card>();
		flush.add(new Card('D', 4));
		flush.add(new Card('D', 3));
		flush.add(new Card('D', 10));
		assertEquals(3, flush.size(), "wrong size");
		
		int winnings = ThreeCardLogic.evalPPWinnings(flush, 10);
		assertEquals(40, winnings, "Wrong Winnings Amount");
	}
	
	// testing evalPPWinnings method - straight
	@Test
	void evalPPWinningsStraightTest() {
		ArrayList<Card> straight = new ArrayList<Card>();
		straight.add(new Card('D', 7));
		straight.add(new Card('D', 6));
		straight.add(new Card('H', 5));
		assertEquals(3, straight.size(), "Wrong hand size");
		
		int winnings = ThreeCardLogic.evalPPWinnings(straight, 12);
		assertEquals(84, winnings, "Wrong Winnings Amount");
	}
	
	// testing evalPPWinnings method - Three of a Kind
	@Test
	void evalPPWinningsThreeTest() {
		ArrayList<Card> three = new ArrayList<Card>();
		three.add(new Card('D', 8));
		three.add(new Card('C', 8));
		three.add(new Card('H', 8));
		assertEquals(3, three.size(), "Wrong Hand Size");
		
		int winnings = ThreeCardLogic.evalPPWinnings(three, 9);
		assertEquals(279, winnings, "Wrong Winnings Amount");
	}
	
	// testing evalPPWinnings method - Straight Flush
	@Test
	void evalPPWinningsStraightFlushTest() {
		ArrayList<Card> straightFlush = new ArrayList<Card>();
		straightFlush.add(new Card('H', 7));
		straightFlush.add(new Card('H', 6));
		straightFlush.add(new Card('H', 5));
		assertEquals(3, straightFlush.size(), "Wrong Hand Size");
		
		int winnings = ThreeCardLogic.evalPPWinnings(straightFlush, 5);
		assertEquals(205, winnings, "Wrong Winnings Amount");
	}
}