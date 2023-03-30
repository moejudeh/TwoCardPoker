import java.util.ArrayList;
import java.util.Collections;

public class ThreeCardLogic {
	
	// sortHand(hand)
	// sorts a players hand by card values
	private static ArrayList<Card> sortHand(ArrayList<Card> hand) {
		ArrayList<Card> sorted = new ArrayList<Card>();
		sorted.addAll(hand);
		Collections.sort(sorted, new CardComparator());
		return sorted;
	}
	
	// straightTest(hand)
	// returns true if the hand is a straight
	// returns false otherwise
	private static boolean straightTest(ArrayList<Card> hand) {
		int card1 = hand.get(0).getValue();
		int card2 = hand.get(1).getValue();
		int card3 = hand.get(2).getValue();
		
		if(card1+1 == card2 && card2+1 == card3) {
			return true;
//		} else if (card1+1 == card2 && card2+11 == card3) {
//			return true;
		} else {
			return false;
		}
	}
	
	// flushTest(hand)
	// returns true if the hand is a flush
	// retuns false otherwise
	private static boolean flushTest(ArrayList<Card> hand) {
		return hand.get(0).getSuit() == hand.get(1).getSuit() && hand.get(1).getSuit() == hand.get(2).getSuit();
	}
	
	// threeTest(hand)
	// returns true if the hand is three of a kind
	// returns false otherwise
	private static boolean threeTest(ArrayList<Card> hand) {
		return hand.get(0).getValue() == hand.get(1).getValue() && hand.get(1).getValue() == hand.get(2).getValue();
	}
	
	// pairTest(hand)
	// returns true if the hand has a pair
	// returns false otherwise
	private static boolean pairTest(ArrayList<Card> hand) {
		return hand.get(0).getValue() == hand.get(1).getValue() || hand.get(1).getValue() == hand.get(2).getValue();
	}
	
	// evalHand(hand)
	// evaluates the players hand and returns a number
	// based on the hands strength
	// 0 if the hand just has a high card
	// 1 for a straight flush
	// 2 for three of a kind
	// 3 for a straight
	// 4 for a flush
	// 5 for a pair
	public static int evalHand(ArrayList<Card> hand) { 
		ArrayList<Card> sortedHand = sortHand(hand);
		if (straightTest(sortedHand) && flushTest(sortedHand)) {
			return 1;
		}
		if (threeTest(sortedHand)) {
			return 2;
		}
		if (straightTest(sortedHand)) {
			return 3;
		}
		if (flushTest(sortedHand)) {
			return 4;
		}
		if (pairTest(sortedHand)) {
			return 5;
		}
		return 0;
	}
	
	// evalPPWinnings(hand, bet)
	// evaluates the players hand and then returns the pair plus amount
	// depending on the strength of the players card
	// 0 if the hand just has a high card
	// 40:1 for a straight flush
	// 30:1 for three of a kind
	// 6:1  for a straight
	// 3:1  for a flush
	// 1:1  for a pair
	public static int evalPPWinnings(ArrayList<Card> hand, int bet) {
		int eval = evalHand(hand);
		if (eval == 1) {
			return 41 * bet;		// Straight Flush
		} else if (eval == 2) {
			return 31 * bet;		// Three of a Kind
		} else if (eval == 3) {		
			return 7 * bet;			// Straight
		} else if (eval == 4) {
			return 4 * bet;			// Flush
		} else if (eval == 5) {
			return bet * 2;			// Pair
		} else {
			return 0;				// High Card
		}
	}
	
	
	// testQueenHigh (hand)
	// checks to see if hand has a queen high
	// returns true if it does
	// returns false if not
	public static boolean testQueenHigh(ArrayList<Card> hand) {
		return hand.get(0).getValue() >= 12
				|| hand.get(1).getValue() >= 12
				|| hand.get(2).getValue() >= 12;
	}
	
	
	// findPair(hand) 
	// if the pair is the first two cards it returns 0
	// if the pair is the last two cards returns 2;
	private static int findPair(ArrayList<Card> hand) {
		if(hand.get(0).getValue() == hand.get(1).getValue()) {
			return 0;
		} else {
			return 2;
		}
	}
	
	
	// testWinnerTie (dealerHand, playerHand, evalHand)
	// if both cards evalute to same number test the card
	// values for high cards and returns a number based on who won
	// returns 0 if no one won
	// returns 1 if dealer won
	// retuns 2 if player won
	private static int testWinnerTie(ArrayList<Card> dealerHand, ArrayList<Card> playerHand , int handEval) {
		
		// Sorting both dealer and player hand
		ArrayList<Card> dealer = new ArrayList<Card>();
		ArrayList<Card> player = new ArrayList<Card>();
		dealer.addAll(dealerHand);
		player.addAll(playerHand);
		Collections.sort(dealer, new CardComparator());
		Collections.sort(player, new CardComparator());
		
		// all cases besides pair where player and dealer tie
		if(handEval != 5) {
			for(int i = 2; i >= 0; i--) {
				if(dealer.get(i).getValue() > player.get(i).getValue()) {
					return 1;
				} else if (dealer.get(i).getValue() < player.get(i).getValue()) {
					return 2;
				}
			}

		} else if (handEval == 5) {
			int dealerPair = findPair(dealer);
			int playerPair = findPair(player);
			
			// checks if the dealers pair is higher than the players pair
			if(dealer.get(dealerPair).getValue() > player.get(playerPair).getValue()) {
				return 1;
			}
			
			// checks if the dealers pair is lower than the players pair
			else if (dealer.get(dealerPair).getValue() < player.get(playerPair).getValue()) {
				return 2;
			}
			
			// if pairs are equal checks the last card for high card
			else if (dealer.get(2 - dealerPair).getValue() > player.get(2 - playerPair).getValue()){
				return 1;
			} else if (dealer.get(2 - dealerPair).getValue() < player.get(2 - playerPair).getValue()){
				return 2;
			}
			
		}
		return 0;
	}
	
	
	// compareHands(dealer, player)
	// Compares the dealers hand with the players hand
	// returns 0 if no one won or if dealer doesnt have queen high
	// returns 1 if dealer won
	// retuns 2 if player won
	// returns -1 if either dealer or player doesnt have the right amount of cards
	public static int compareHands(ArrayList<Card> dealer, ArrayList<Card> player) {
		if(dealer.size() != 3 || player.size() != 3) {
			return -1;
		}
		
		int dealerEval = evalHand(dealer);
		int playerEval = evalHand(player);
				
		if(dealerEval == 0) {
			if(!testQueenHigh(dealer)) {
				return 0;
			} else {
				dealerEval += 6; 	// add 6 to dealerEval if Queen High
			}
		}
		if(playerEval == 0) {
			playerEval += 6;		// add 6 to playerEval if high card
		}
		
		if (dealerEval < playerEval) {
			return 1;
		} else if (playerEval < dealerEval) {
			return 2;
		} else if(dealerEval == playerEval) {
			return testWinnerTie(dealer, player, dealerEval);
		}
		
		return 0;
	}
}