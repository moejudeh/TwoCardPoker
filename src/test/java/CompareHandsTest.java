import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CompareHandsTest {
	// Player Hands
	static ArrayList<Card> playerHC;
	static ArrayList<Card> playerPair;
	static ArrayList<Card> playerFlush;
	static ArrayList<Card> playerStraight;
	static ArrayList<Card> playerThree;
	static ArrayList<Card> playerStraightFlush;
	
	// Dealer Hands
	// - Queen Low
	static ArrayList<Card> dealerQueenLower;
	// - High Card
	static ArrayList<Card> dealerHCLose;
	static ArrayList<Card> dealerHCWin;
	static ArrayList<Card> dealerHC;
	// - Pair
	static ArrayList<Card> dealerPairLosePair;
	static ArrayList<Card> dealerPairWinPair;
	static ArrayList<Card> dealerPairLoseHC;
	static ArrayList<Card> dealerPairWinHC;
	static ArrayList<Card> dealerPair;
	// - Flush
	static ArrayList<Card> dealerFlushLose;
	static ArrayList<Card> dealerFlushWin;
	static ArrayList<Card> dealerFlush;
	// - Straight
	static ArrayList<Card> dealerStraightLose;
	static ArrayList<Card> dealerStraightWin;
	static ArrayList<Card> dealerStraight;
	// - Three of a Kind
	static ArrayList<Card> dealerThreeLose;
	static ArrayList<Card> dealerThreeWin;
	// - Straight Flush
	static ArrayList<Card> dealerStraightFlushLose;
	static ArrayList<Card> dealerStraightFlushWin;
	static ArrayList<Card> dealerStraightFlush;
	
	static int compare;
	
	@BeforeAll
	static void playerSetup() {
		playerHC = new ArrayList<Card>();
		playerHC.add(new Card('C', 13));
		playerHC.add(new Card('D', 9));
		playerHC.add(new Card('H', 5));

		
		playerPair = new ArrayList<Card>();
		playerPair.add(new Card('D', 4));
		playerPair.add(new Card('C', 7));
		playerPair.add(new Card('H', 7));
		
		
		playerFlush = new ArrayList<Card>();
		playerFlush.add(new Card('D', 2));
		playerFlush.add(new Card('D', 9));
		playerFlush.add(new Card('D', 3));
		
		playerStraight = new ArrayList<Card>();
		playerStraight.add(new Card('D', 6));
		playerStraight.add(new Card('H', 7));
		playerStraight.add(new Card('C', 8));
		
		playerThree = new ArrayList<Card>();
		playerThree.add(new Card('D', 6));
		playerThree.add(new Card('C', 6));
		playerThree.add(new Card('H', 6));
		
		playerStraightFlush = new ArrayList<Card>();
		playerStraightFlush.add(new Card('D', 6));
		playerStraightFlush.add(new Card('D', 7));
		playerStraightFlush.add(new Card('D', 8));
	}
	
	@BeforeAll
	static void dealerSetup() {
		dealerQueenLower = new ArrayList<Card>();
		dealerQueenLower.add(new Card('D', 4));
		dealerQueenLower.add(new Card('S', 2));
		dealerQueenLower.add(new Card('H', 9));
		
		dealerHCLose = new ArrayList<Card>();
		dealerHCLose.add(new Card('D', 9));
		dealerHCLose.add(new Card('S', 2));
		dealerHCLose.add(new Card('H', 12));
		
		dealerHCWin = new ArrayList<Card>();
		dealerHCWin.add(new Card('D', 9));
		dealerHCWin.add(new Card('S', 14));
		dealerHCWin.add(new Card('H', 2));
		
		dealerHC = new ArrayList<Card>();
		dealerHC.add(new Card('C', 9));
		dealerHC.add(new Card('D', 13));
		dealerHC.add(new Card('H', 5));
		
		dealerPairLosePair = new ArrayList<Card>();
		dealerPairLosePair.add(new Card('S', 4));
		dealerPairLosePair.add(new Card('C', 4));
		dealerPairLosePair.add(new Card('D', 7));
		
		dealerPairWinPair = new ArrayList<Card>();
		dealerPairWinPair.add(new Card('S', 9));
		dealerPairWinPair.add(new Card('C', 9));
		dealerPairWinPair.add(new Card('D', 7));
		
		dealerPairWinHC = new ArrayList<Card>();
		dealerPairWinHC.add(new Card('S', 7));
		dealerPairWinHC.add(new Card('D', 7));
		dealerPairWinHC.add(new Card('C', 9));
		
		dealerPairLoseHC = new ArrayList<Card>();
		dealerPairLoseHC.add(new Card('S', 7));
		dealerPairLoseHC.add(new Card('D', 7));
		dealerPairLoseHC.add(new Card('C', 2));
		
		dealerPair = new ArrayList<Card>();
		dealerPair.add(new Card('S', 7));
		dealerPair.add(new Card('D', 7));
		dealerPair.add(new Card('C', 4));
		
		dealerFlushLose = new ArrayList<Card>();
		dealerFlushLose.add(new Card('H', 3));
		dealerFlushLose.add(new Card('H', 5));
		dealerFlushLose.add(new Card('H', 7));
		
		dealerFlushWin = new ArrayList<Card>();
		dealerFlushWin.add(new Card('H', 13));
		dealerFlushWin.add(new Card('H', 3));
		dealerFlushWin.add(new Card('H', 5));
		
		dealerFlush = new ArrayList<Card>();
		dealerFlush.add(new Card('H', 2));
		dealerFlush.add(new Card('H', 9));
		dealerFlush.add(new Card('H', 3));
		
		dealerStraightLose = new ArrayList<Card>();
		dealerStraightLose.add(new Card('H', 3));
		dealerStraightLose.add(new Card('D', 4));
		dealerStraightLose.add(new Card('S', 5));
		
		dealerStraightWin = new ArrayList<Card>();
		dealerStraightWin.add(new Card('H', 8));
		dealerStraightWin.add(new Card('D', 9));
		dealerStraightWin.add(new Card('S', 10));
		
		dealerStraight = new ArrayList<Card>();
		dealerStraight.add(new Card('H', 6));
		dealerStraight.add(new Card('D', 7));
		dealerStraight.add(new Card('H', 8));
		
		dealerThreeLose = new ArrayList<Card>();
		dealerThreeLose.add(new Card('H', 3));
		dealerThreeLose.add(new Card('D', 3));
		dealerThreeLose.add(new Card('C', 3));
		
		dealerThreeWin = new ArrayList<Card>();
		dealerThreeWin.add(new Card('H', 10));
		dealerThreeWin.add(new Card('D', 10));
		dealerThreeWin.add(new Card('S', 10));
		
		dealerStraightFlushLose = new ArrayList<Card>();
		dealerStraightFlushLose.add(new Card('H', 3));
		dealerStraightFlushLose.add(new Card('H', 4));
		dealerStraightFlushLose.add(new Card('H', 5));
		
		dealerStraightFlushWin = new ArrayList<Card>();
		dealerStraightFlushWin.add(new Card('H', 9));
		dealerStraightFlushWin.add(new Card('H', 10));
		dealerStraightFlushWin.add(new Card('H', 11));
		
		dealerStraightFlush = new ArrayList<Card>();
		dealerStraightFlush.add(new Card('H', 6));
		dealerStraightFlush.add(new Card('H', 7));
		dealerStraightFlush.add(new Card('H', 8));
	}
	
	
	
	
	
	// PLAYER = HighCard | DEALER = QueenLower
	@Test
	void playerHCDealerQL() {
		compare = ThreeCardLogic.compareHands(dealerQueenLower, playerHC);
		assertEquals(0, compare, "Plyaer High Card Dealer High Card Queen Lower Failed");
	}
	
	// PLAYER = HighCard | DEALER = HighCardLose
	@Test
	void playerHCDealerHCL() {
		compare = ThreeCardLogic.compareHands(dealerHCLose, playerHC);
		assertEquals(2, compare, "Player High Card Dealer High Card Lose Fail");
	}
	
	// PLAYER = HighCard | DEALER = HighCardWin
	@Test
	void playerHCDealerHCW() {
		compare = ThreeCardLogic.compareHands(dealerHCWin, playerHC);
		assertEquals(1, compare, "Player High Card Dealer High Card Win Fail");
	}
	
	// PLYAER = HighCard | DEALER = HighCardTie
	@Test
	void playerHCDealerHC() {
		compare = ThreeCardLogic.compareHands(dealerHC, playerHC);
		assertEquals(0, compare, "Player High Card Dealer High Card Tie Failed");
	}
	
	// PLAYER = HighCard | DEALER = Pair
	@Test
	void playerHCDealerPair() {
		compare = ThreeCardLogic.compareHands(dealerPair, playerHC);
		assertEquals(1, compare, "Player High Card Dealer Pair Failed");
	}
	
	// PLAYER = HighCard | DEALER = Flush
	@Test
	void playerHCDealerFlush() {
		compare = ThreeCardLogic.compareHands(dealerFlush, playerHC);
		assertEquals(1, compare, "Player High Card Dealer Flush Failed");
	}
	
	// PLAYER = HighCard | DEALER = Straight
	@Test
	void playerHCDealerStraight() {
		compare = ThreeCardLogic.compareHands(dealerStraight, playerHC);
		assertEquals(1, compare, "Player High Card Dealer Straight Failed");
	}

	// PLAYER = HighCard | DEALER = Three
	@Test
	void playerHCDealerThree() {
		compare = ThreeCardLogic.compareHands(dealerThreeWin, playerHC);
		assertEquals(1, compare, "Player High Card Dealer Three Failed");
	}

	// PLAYER = HighCard | DEALER = StraightFlush
	@Test
	void playerHCDealerStraightFlush() {
		compare = ThreeCardLogic.compareHands(dealerStraightFlush, playerHC);
		assertEquals(1, compare, "Player High Card Dealer Straight Flush Failed");
	}
	
	
	
	
	
	// PLAYER = Pair | DEALER = Queen Low
	@Test
	void playerPairDealerQL() {
		compare = ThreeCardLogic.compareHands(dealerQueenLower, playerPair);
		assertEquals(0, compare, "Player Pair Dealer Queen Low Failed");
	}
	
	// PLAYER = PAIR | DEALER = HighCard
	@Test
	void playerPairDealerHC() {
		compare = ThreeCardLogic.compareHands(dealerHC, playerPair);
		assertEquals(2, compare, "Player Pair Dealer High Card Failed");
	}
	
	// PLAYER = Pair | DEALER = PairLose - pair
	@Test
	void playerPairDealerPairLose() {
		compare = ThreeCardLogic.compareHands(dealerPairLosePair, playerPair);
		assertEquals(2, compare, "Player Pair Dealer Pair Lose Failed");
	}
	
	// PLAYER = Pair | DEALER = PairWin - pair
	@Test
	void playerPairDealerPairWin() {
		compare = ThreeCardLogic.compareHands(dealerPairWinPair, playerPair);
		assertEquals(1, compare, "Player Pair Dealer Pair Win Failed");
	}
	
	// PLAYER = Pair | DEALER = PairLose - HC
	@Test
	void playerPairDealerPairLoseHC() {
		compare = ThreeCardLogic.compareHands(dealerPairLoseHC, playerPair);
		assertEquals(2, compare, "Player Pair Dealer Pair Lose HC Failed");
	}
	
	// PLAYER = Pair | DEALER = PairWin - HC
	@Test
	void playerPairDealerPairWinHC() {
		compare = ThreeCardLogic.compareHands(dealerPairWinHC, playerPair);
		assertEquals(1, compare, "Player Pair Dealer Pair Win HC Failed");
	}
	
	// PLAYER = Pair | DEALER = PairTie
	@Test
	void playerPairDealerPairTie() {
		compare = ThreeCardLogic.compareHands(dealerPair, playerPair);
		assertEquals(0, compare, "Player Pair Dealer Pair Tie Failed");
	}
	
	// PLAYER = Pair | DEALER = Flush
	@Test
	void playerPairDealerFlush() {
		compare = ThreeCardLogic.compareHands(dealerFlush, playerPair);
		assertEquals(1, compare, "Player Pair Dealer Flush Failed");
	}
	
	// PLAYER = Pair | DEALER = Straight
	@Test
	void playerPairDealerStraight() {
		compare = ThreeCardLogic.compareHands(dealerStraight, playerPair);
		assertEquals(1, compare, "Player Pair Dealer Straight Failed");
	}
	
	// PLAYER = Pair | DEALER = Three
	@Test
	void playerPairDealerThree() {
		compare = ThreeCardLogic.compareHands(dealerThreeWin, playerPair);
		assertEquals(1, compare, "Player Pair Dealer Three Failed");
	}
	
	// PLAYER = Pair | DEALER = Straight FLush
	@Test
	void playerPairDealerStraighFlush() {
		compare = ThreeCardLogic.compareHands(dealerStraightFlush, playerPair);
		assertEquals(1, compare, "Player Pair Dealer Straight Flush Failed");
	}
	
	
	
	
	// PLAYER = Flush | DEALER = Queen Low
	@Test
	void playerFlushDealerQL() {
		compare = ThreeCardLogic.compareHands(dealerQueenLower, playerFlush);
		assertEquals(0, compare, "Player Flush Dealer Queen Low Failed");
	}
	
	// PLAYER = Flush | DEALER = High Card
	@Test
	void playerFlushDealerHC() {
		compare = ThreeCardLogic.compareHands(dealerHC, playerFlush);
		assertEquals(2, compare, "Player Flush Dealer High Card Failed");
	}
	
	// PLAYER = Flush | DEALER = Pair
	@Test
	void playerFlushDealerPair() {
		compare = ThreeCardLogic.compareHands(dealerPair, playerFlush);
		assertEquals(2, compare, "Player Flush Dealer Pair Failed");
	}
	
	// PLAYER = Flush | DEALER = FlushLose
	@Test
	void playerFlushDealerFlushLose() {
		compare = ThreeCardLogic.compareHands(dealerFlushLose, playerFlush);
		assertEquals(2, compare, "Player Flush Dealer Flush Lose Failed");
	}
	
	// PLAYER = Flush | DEALER = FlushWin
	@Test
	void playerFlushDealerFlushWin() {
		compare = ThreeCardLogic.compareHands(dealerFlushWin, playerFlush);
		assertEquals(1, compare, "Player Flush Dealer Flush Win Failed");
	}
	
	// PLAYER = Flush | DEALER = FlushTie
	@Test
	void playerFlushDealerFlushTie() {
		compare = ThreeCardLogic.compareHands(dealerFlush, playerFlush);
		assertEquals(0, compare, "Player Flush Dealer Flush Tie Failed");
	}
	
	// PLAYER = Flush | DEALER = Straight
	@Test
	void playerFlushDealerStraight() {
		compare = ThreeCardLogic.compareHands(dealerStraight, playerFlush);
		assertEquals(1, compare, "Player Flush Dealer Straight Failed");
	}
	
	// PLAYER = Flush | DEALER = Three 
	@Test
	void playerFlushDealerThree() {
		compare = ThreeCardLogic.compareHands(dealerThreeWin, playerFlush);
		assertEquals(1, compare, "Player Flush Dealer Three Failed");
	}
	
	// PLAYER = Flush | DEALER = Straight Flush
	@Test
	void playerFlushDealerStraightFlush() {
		compare = ThreeCardLogic.compareHands(dealerStraightFlush, playerFlush);
		assertEquals(1, compare, "Player Flush Dealer Straight Flush Failed");
	}
	
	
	
	
	// PLAYER = Straight | DEALER = Queen Low
	@Test
	void playerStraightDealerQL() {
		compare = ThreeCardLogic.compareHands(dealerQueenLower, playerStraight);
		assertEquals(0, compare, "Player Straight Dealer Queen Low Failed");
	}
	
	// PLAYER = Straight | DEALER = High Card
	@Test
	void playerStraightDealerHC() {
		compare = ThreeCardLogic.compareHands(dealerHC, playerStraight);
		assertEquals(2, compare, "Player Straight Dealer High Card Failed");
	}
	
	// PLAYER = Straight | DEALER = Pair
	@Test
	void playerStraightDealerPair() {
		compare = ThreeCardLogic.compareHands(dealerPair, playerStraight);
		assertEquals(2, compare, "Player Straight Dealer Pair Failed");
	}
	
	// PLAYER = Straight | DEALER = Flush
	@Test
	void playerStraightDealerFlush() {
		compare = ThreeCardLogic.compareHands(dealerFlush, playerStraight);
		assertEquals(2, compare, "Player Straight Dealer Flush Failed");
	}
	
	// PLAYER = Straight | DEALER = StraightLose
	@Test
	void playerStraightDealerStraightLose() {
		compare = ThreeCardLogic.compareHands(dealerStraightLose, playerStraight);
		assertEquals(2, compare, "Player Straight Dealer Straight Lose Failed");
	}
	
	// PLAYER = Straight | DEALER = StraightWin
	@Test
	void playerStraightDealerStraightWin() {
		compare = ThreeCardLogic.compareHands(dealerStraightWin, playerStraight);
		assertEquals(1, compare, "Player Straight Dealer Straight Win Failed");
	}
	
	// PLAYER = Straight | DEALER = StraightTie
	@Test
	void playerStraightDealerStraightTie() {
		compare = ThreeCardLogic.compareHands(dealerStraight, playerStraight);
		assertEquals(0, compare, "Player Straight Dealer Straight Tie Failed");
	}
	
	// PLAYER = Straight | DEALER = Three
	@Test
	void playerStraightDealerThree() {
		compare = ThreeCardLogic.compareHands(dealerThreeWin, playerStraight);
		assertEquals(1, compare, "Player Straight Dealer Three Failed");
	}
	
	// PLAYER = Straight | DEALER = Straight Flush
	@Test
	void playerStraightDealerStraightFlush() {
		compare = ThreeCardLogic.compareHands(dealerStraightFlush, playerStraight);
		assertEquals(1, compare, "Player Straight Dealer Straight Flush Failed");
	}
	
	
	
	
	// PLAYER = Three | DEALER = Queen Low
	@Test
	void playerThreeDealerQL() {
		compare = ThreeCardLogic.compareHands(dealerQueenLower, playerThree);
		assertEquals(0, compare, "Player Three Dealer Queen Low Failed");
	}
	
	// PLAYER = Three | DEALER = High Card
	@Test
	void playerThreeDealerHC() {
		compare = ThreeCardLogic.compareHands(dealerHC, playerThree);
		assertEquals(2, compare, "Player Three Dealer High Card Failed");
	}
	
	// PLAYER = Three | DEALER = Pair
	@Test
	void playerThreeDealerPair() {
		compare = ThreeCardLogic.compareHands(dealerPair, playerThree);
		assertEquals(2, compare, "Player Three Dealer Pair Failed");
	}
	
	// PLAYER = Three | DEALER = Flush
	@Test
	void playerThreeDealerFlush() {
		compare = ThreeCardLogic.compareHands(dealerFlush, playerThree);
		assertEquals(2, compare, "Player Three Dealer Flush Failed");
	}
	
	// PLAYER = Three | DEALER = Straight
	@Test
	void playerThreeDealerStraight() {
		compare = ThreeCardLogic.compareHands(dealerStraight, playerThree);
		assertEquals(2, compare, "Player Three Dealer Straight Failed");
	}
	
	// PLAYER = Three | DEALER = ThreeLose
	@Test
	void playerThreeDealerThreeLose() {
		compare = ThreeCardLogic.compareHands(dealerThreeLose, playerThree);
		assertEquals(2, compare, "Player Three Dealer Three Lose Failed");
	}
	
	// PLAYER = Three | DEALER = ThreeWin
	@Test
	void playerThreeDealerThreeWin() {
		compare = ThreeCardLogic.compareHands(dealerThreeWin, playerThree);
		assertEquals(1, compare, "Player Three Dealer Three Win Failed");
	}
	
	// PLAYER = Three | DEALER = StraightFlush
	@Test
	void playerThreeDealerStraightFlush() {
		compare = ThreeCardLogic.compareHands(dealerStraightFlush, playerThree);
		assertEquals(1, compare, "Player Three Dealer Straight Flush Failed");
	}
	
	
	
	
	// PLAYER = Straight Flush | DEALER = Queen Low
	@Test
	void playerStraightFlushDealerQL() {
		compare = ThreeCardLogic.compareHands(dealerQueenLower, playerStraightFlush);
		assertEquals(0, compare, "Player Straight Flush Dealer Queen Lower Failed");
	}
	
	// PLAYER = Straight Flush | DEALER = High Card
	@Test
	void playerStraightFlushDealerHC() {
		compare = ThreeCardLogic.compareHands(dealerHC, playerStraightFlush);
		assertEquals(2, compare, "Player Straight Flush Dealer High Card Failed");
	}
	
	// PLAYER = Straight Flush | DEALER = Pair
	@Test
	void playerStraightFlushDealerPair() {
		compare = ThreeCardLogic.compareHands(dealerPair, playerStraightFlush);
		assertEquals(2, compare, "Player Straight Flush Dealer Pair Failed");
	}
	
	// PLAYER = Straight Flush | DEALER = Flush
	@Test
	void playerStraightFlushDealerFlush() {
		compare = ThreeCardLogic.compareHands(dealerFlush, playerStraightFlush);
		assertEquals(2, compare, "Player Straight Flush Dealer Flush Failed");
	}
	
	// PLAYER = Straight Flush | DEALER = Straight
	@Test
	void playerStraightFlushDealerStraight() {
		compare = ThreeCardLogic.compareHands(dealerStraight, playerStraightFlush);
		assertEquals(2, compare, "Player Straight Flush Dealer Straight Failed");
	}
	
	// PLAYER = Straight Flush | DEALER = Three
	@Test
	void playerStraightFlushDealerThree() {
		compare = ThreeCardLogic.compareHands(dealerThreeWin, playerStraightFlush);
		assertEquals(2, compare, "Player Straight Flush Dealer Three Failed");
	}
	
	// PLAYER = Straight Flush | DEALER = StraightFLushLose
	@Test
	void playerStraightFlushDealerStraightFlushLose() {
		compare = ThreeCardLogic.compareHands(dealerStraightFlushLose, playerStraightFlush);
		assertEquals(2, compare, "Player Straight Flush Dealer Straight Flush Lose Failed");
	}
	
	// PLAYER = Straight FLush | DEALER = StraightFLushWin
	@Test
	void playerStraightFlushDealerStraightFlushWin() {
		compare = ThreeCardLogic.compareHands(dealerStraightFlushWin, playerStraightFlush);
		assertEquals(1, compare, "Player Straight Flush Dealer Straight Flush Win Failed");
	}
	
	// PLAYER = Straight Flush | DEALER = StraightFlushTie
	@Test
	void playerStraightFlushDealerStraightFlushTie() {
		compare = ThreeCardLogic.compareHands(dealerStraightFlush, playerStraightFlush);
		assertEquals(0, compare, "Player Straight Flush Dealer Straight Flush Tie Failed");
	}
	
}