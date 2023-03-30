import java.util.ArrayList;

public class Player {
	
	private ArrayList<Card> hand;
	private int anteBet;
	private int playBet;
	private int pairPlusBet;
	private int totalWinnings;
	private boolean folded;
	
	Player() {
		anteBet = 0;
		playBet = 0;
		pairPlusBet = 0;
		totalWinnings = 0;
		folded = false;
		
		hand = null;
	}
	
	// setAnteBet(bet)
	// sets the players ante bet
	public void setAnteBet(int bet) {
		this.anteBet = bet;
	}
	
	// getAnteBet()
	// returns players ante bet
	public int getAnteBet() {
		return this.anteBet;
	}
	
	// setPlayBet(bet)
	// sets play bet to bet
	public void setPlayBet(int bet) {
		this.playBet = bet;
	}
	
	// getPlayBet()
	// returns players play bet
	public int getPlayBet() {
		return this.playBet;
	}
	
	// setPairPlusBet(bet)
	// sets pair plus bet to bet
	public void setPairPlusBet(int bet) {
		this.pairPlusBet = bet;
	}
	
	// getPairPlusBet()
	// returns the pair plus bet 
	public int getPairPlusBet() {
		return this.pairPlusBet;
	}
	
	// getTotalWinnings()
	// returns the total winnings
	public int getTotalWinnings() {
		return this.totalWinnings;
	}
	
	// setTotalWinnings(winnings)
	// sets players total winnings to winnings
	public void setTotalWinnings(int winnings) {
		this.totalWinnings = winnings;
	}
	
	// getHand()
	// returns the players current hand
	public ArrayList<Card> getHand() {
		return this.hand;
	}
	
	// setHand(newHand)
	// sets the players hand to newHand
	public void setHand(ArrayList<Card> newHand) {
		this.hand = newHand;
	}
	
	// setFolded(fold)
	// sets the players folded status
	public void setFolded(boolean fold) {
		this.folded = fold;
	}
	
	// getFolded()
	// gets the players folded Status
	public boolean getFolded() {
			return this.folded;
	}
	
	public void newRound() {
		this.hand = null;
		this.anteBet = 0;
		this.playBet = 0;
		this.pairPlusBet = 0;
		this.folded = false;
	}
	
	
	public void newGame() {
		this.hand = null;
		this.anteBet = 0;
		this.playBet = 0;
		this.pairPlusBet = 0;
		this.totalWinnings = 0;
		this.folded = false;
	}
	
	public String PlayBet(ArrayList<Card> dealerHand, boolean queenHigh) {
		int dVp = ThreeCardLogic.compareHands(dealerHand, this.hand);
		int playerBet = this.getAnteBet() + this.getPlayBet();
		if(dVp == 0 && queenHigh && !this.folded) {
			return "Tied With Dealer";
		} else if (dVp == 1 || this.folded) {
			this.setTotalWinnings(this.getTotalWinnings() - playerBet);
			return "Lost to Dealer";
		} else if (dVp == 2) {
			this.setTotalWinnings(this.getTotalWinnings() + playerBet);
			return "Beats Dealer";
		} else {
			return "";
		}
	}
	
	public String pairPlusBet() {
		if(this.pairPlusBet == 0) {
			return "Did Not Have A Pair Plus Bet";
		} else {
			int pairPlusWinnings = ThreeCardLogic.evalPPWinnings(this.getHand(), this.getPairPlusBet());
			this.setTotalWinnings(this.getTotalWinnings() - this.getPairPlusBet());
			if(pairPlusWinnings == 0 || this.folded) {
				return "Lost Pair Plus Bet";
			} else {
				this.setTotalWinnings(this.getTotalWinnings() + pairPlusWinnings);
				return "Won Pair Plus Bet";
			}
		}
	}
			
}