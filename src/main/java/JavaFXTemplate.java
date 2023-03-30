import java.util.ArrayList;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class JavaFXTemplate extends Application  {

	// game states
	private int turn = 0;
	private boolean startGame = false;
	
	// Players and Dealers
	private Player player1 = new Player();
	private Player player2 = new Player();
	private Dealer dealer = new Dealer();
	
	// holding image for no cards
	private Image grey = new Image("grey.png");
	private Image backOfCard = new Image("backOfCard.png");
	
	// CARDS
	// Player 1 Cards
	private ImageView p1Card1 = new ImageView("grey.png");
	private ImageView p1Card2 = new ImageView("grey.png");
	private ImageView p1Card3 = new ImageView("grey.png");
	
	// Player 2 Cards
	private ImageView p2Card1 = new ImageView("grey.png");
	private ImageView p2Card2 = new ImageView("grey.png");	
	private ImageView p2Card3 = new ImageView("grey.png");

	// Dealer Cards
	private ImageView dealerCard1 = new ImageView("grey.png");
	private ImageView dealerCard2 = new ImageView("grey.png");
	private ImageView dealerCard3 = new ImageView("grey.png");	
	
	// TEXT FIELDS
	// Player 1 Text Field	
	private TextField p1AnteBetField = new TextField("Enter Ante Bet $5-$25");
	private TextField p1PairBetField = new TextField("Enter Pair Plus Bet");
	private TextField p1PlayBetField = new TextField();
	
	// Player 2 Text Field
	private TextField p2AnteBetField = new TextField("Enter Ante Bet $5-$25");
	private TextField p2PairBetField = new TextField("Enter Pair Plus Bet");
	private TextField p2PlayBetField = new TextField();
	
	// Dealer
	private Text dealerTxt = new Text("DEALER");
	
	// Game Info
	private Text gameInfoText = new Text("Players Enter Bets Then Press Deal");
	private Text roundInfo = new Text();
	
	// Control Buttons
	private Button startBtn = new Button("Deal");
	private Button betBtn = new Button("Play");
	private Button foldBtn = new Button("Fold");
	
	// NAMETAG AND MONEY
	private Text p1NameTxt = new Text("PLAYER 1");
	private Text p1Winnings =new Text("Winnings = $");
	private Text p1MoneyTxt = new Text(String.valueOf(player1.getTotalWinnings()));
	private Text p2NameTxt = new Text("PLAYER 2");
	private Text p2Winnings = new Text("Winnings = $");
	private Text p2MoneyTxt = new Text(String.valueOf(player2.getTotalWinnings()));
	
	// PLAYER HANDS
	private ArrayList<Card> dealerHand;
	private boolean queenHigh = true;
	
	// Game Desgin
	private int gameDesgin = 1;
	private BorderPane root = new BorderPane();
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Three Card Poker");
				
		// OPTIONS MENU
		Menu options = new Menu("Options");
		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().add(options);
		
		// FRESH START BUTTON
		MenuItem freshStart = new MenuItem("Fresh Start");
		
		// FRESH START BUTTON ACTION
		freshStart.setOnAction((event)-> {
			// Fixing button Setup
			startBtn.setText("Deal");
			startBtn.setDisable(false);
			betBtn.setDisable(true);
			foldBtn.setDisable(true);
	
			// Dealer Reset
			dealer.newGame();
			dealerCard1.setImage(grey);
			dealerCard2.setImage(grey);
			dealerCard3.setImage(grey);
			
			// PLAYER 1 RESET
			// player 1 cards
			player1.newGame();
			p1Card1.setImage(grey);
			p1Card2.setImage(grey);
			p1Card3.setImage(grey);
			
			// player 1 textfield
			p1AnteBetField.setDisable(false);
			p1PairBetField.setDisable(false);
			p1AnteBetField.setText("Enter Ante Bet $5-$25");
			p1PairBetField.setText("Enter Pair Plus Bet");
			p1PlayBetField.setText("");
			
			// player money
			p1MoneyTxt.setText(String.valueOf(player1.getTotalWinnings()));
			
			// PLAYER 2 RESET
			// player 2 cards
			player2.newGame();
			p2Card1.setImage(grey);
			p2Card2.setImage(grey);
			p2Card3.setImage(grey);
			
			// player 2 textfield
			p2AnteBetField.setDisable(false);
			p2PairBetField.setDisable(false);
			p2AnteBetField.setText("Enter Ante Bet $5-$25");
			p2PairBetField.setText("Enter Pair Plus Bet");
			p2PlayBetField.setText("");
			
			// player 2 money
			p2MoneyTxt.setText(String.valueOf(player2.getTotalWinnings()));
			
			// RESETING GAME INFO
			gameInfoText.setText("Players Enter Bets Then Press Deal");
			roundInfo.setText("");
			
			// reseting game status
			turn = 0;
			startGame = false;
			queenHigh = true;
		});
		
		// NEW LOOK BUTTON
		MenuItem newLook = new MenuItem("New Look");
		newLook.setOnAction((event) -> {
			if(gameDesgin == 2) {
			    root.setBackground(new Background(new BackgroundFill(Color.GREEN, null, null)));
			    gameDesgin = 1;

			    ArrayList<Card> p1Hand = player1.getHand();
			    ArrayList<Card> p2Hand = player2.getHand();
			    ArrayList<Card> dHand = dealer.getHand();
			    
			    if(p1Hand != null) {
					Image p1Card1Image = new Image("deckOfCards" + gameDesgin + "/" + p1Hand.get(0).toString() + ".png");
					p1Card1.setImage(p1Card1Image);
					Image p1Card2Image = new Image("deckOfCards" + gameDesgin + "/" + p1Hand.get(1).toString() + ".png");
					p1Card2.setImage(p1Card2Image);
					Image p1Card3Image = new Image("deckOfCards" + gameDesgin + "/" + p1Hand.get(2).toString() + ".png");
					p1Card3.setImage(p1Card3Image);
			    }
			    if(p2Hand != null) {
					Image p2Card1Image = new Image("deckOfCards" + gameDesgin + "/" + p2Hand.get(0).toString() + ".png");
					p2Card1.setImage(p2Card1Image);
					Image p2Card2Image = new Image("deckOfCards" + gameDesgin + "/" + p2Hand.get(1).toString() + ".png");
					p2Card2.setImage(p2Card2Image);
					Image p2Card3Image = new Image("deckOfCards" + gameDesgin + "/" + p2Hand.get(2).toString() + ".png");
					p2Card3.setImage(p2Card3Image);
			    }
			    if(dHand != null) {
			    	if(dealerCard1.getImage() != backOfCard) {
						Image dealerCard1Image = new Image("deckOfCards" + gameDesgin + "/" + dealerHand.get(0).toString() + ".png");
						dealerCard1.setImage(dealerCard1Image);
						Image dealerCard2Image = new Image("deckOfCards" + gameDesgin + "/" + dealerHand.get(1).toString() + ".png");
						dealerCard2.setImage(dealerCard2Image);
						Image dealerCard3Image = new Image("deckOfCards" + gameDesgin + "/" + dealerHand.get(2).toString() + ".png");
						dealerCard3.setImage(dealerCard3Image);
			    	}
			    }
			    
				
			} else if (gameDesgin == 1) {
			    root.setBackground(new Background(new BackgroundFill(Color.TAN, null, null)));
			    gameDesgin = 2;

			    ArrayList<Card> p1Hand = player1.getHand();
			    ArrayList<Card> p2Hand = player2.getHand();
			    ArrayList<Card> dHand = dealer.getHand();
			    
			    if(p1Hand != null) {
					Image p1Card1Image = new Image("deckOfCards" + gameDesgin + "/" + p1Hand.get(0).toString() + ".png");
					p1Card1.setImage(p1Card1Image);
					Image p1Card2Image = new Image("deckOfCards" + gameDesgin + "/" + p1Hand.get(1).toString() + ".png");
					p1Card2.setImage(p1Card2Image);
					Image p1Card3Image = new Image("deckOfCards" + gameDesgin + "/" + p1Hand.get(2).toString() + ".png");
					p1Card3.setImage(p1Card3Image);
			    }
			    if(p2Hand != null) {
					Image p2Card1Image = new Image("deckOfCards" + gameDesgin + "/" + p2Hand.get(0).toString() + ".png");
					p2Card1.setImage(p2Card1Image);
					Image p2Card2Image = new Image("deckOfCards" + gameDesgin + "/" + p2Hand.get(1).toString() + ".png");
					p2Card2.setImage(p2Card2Image);
					Image p2Card3Image = new Image("deckOfCards" + gameDesgin + "/" + p2Hand.get(2).toString() + ".png");
					p2Card3.setImage(p2Card3Image);
			    }
			    if(dHand != null) {
			    	if(dealerCard1.getImage() != backOfCard) {
						Image dealerCard1Image = new Image("deckOfCards" + gameDesgin + "/" + dealerHand.get(0).toString() + ".png");
						dealerCard1.setImage(dealerCard1Image);
						Image dealerCard2Image = new Image("deckOfCards" + gameDesgin + "/" + dealerHand.get(1).toString() + ".png");
						dealerCard2.setImage(dealerCard2Image);
						Image dealerCard3Image = new Image("deckOfCards" + gameDesgin + "/" + dealerHand.get(2).toString() + ".png");
						dealerCard3.setImage(dealerCard3Image);
			    	}
			    }
			    
			}
		});
		
		// EXIT BUTTON
		MenuItem exit = new MenuItem("Exit");
		exit.setOnAction((event) -> {
			primaryStage.close();
		});

		options.getItems().addAll(freshStart, newLook, exit);

		
		// DEALER 
		// DEALER CARDS
		dealerCard1.setFitWidth(125);
		dealerCard1.setFitHeight(175);
		dealerCard2.setFitWidth(125);
		dealerCard2.setFitHeight(175);
		dealerCard3.setFitWidth(125);
		dealerCard3.setFitHeight(175);
		HBox dealerCards = new HBox(20, dealerCard1, dealerCard2, dealerCard3);
		dealerCards.setAlignment(Pos.CENTER);

		// DEALER TEXT
		dealerTxt.setFont(Font.font(60));
		
		VBox dealerSetup = new VBox(20, dealerTxt, dealerCards);
		dealerSetup.setAlignment(Pos.CENTER);
		
		
		// PLAYER 1
		// PLAYER 1 CARDS
		p1Card1.setFitWidth(125);
		p1Card1.setFitHeight(175);
		p1Card2.setFitWidth(125);
		p1Card2.setFitHeight(175);
		p1Card3.setFitWidth(125);
		p1Card3.setFitHeight(175);
		HBox p1Cards = new HBox(20, p1Card1, p1Card2, p1Card3);
		p1Cards.setAlignment(Pos.CENTER);

		// Player 1 TEXT
		p1NameTxt.setFont(Font.font(45));
		p1Winnings.setFont(Font.font(20));
		p1MoneyTxt.setFont(Font.font(20));
		HBox p1Money = new HBox(5, p1Winnings, p1MoneyTxt);
		p1Money.setAlignment(Pos.CENTER);
		VBox p1Txt = new VBox(5, p1NameTxt, p1Money);
		p1Txt.setAlignment(Pos.CENTER);
		
		VBox p1Setup = new VBox(20, p1Txt, p1Cards);
		p1Setup.setAlignment(Pos.CENTER);
		
		
		// PLAYER 2
		// PLAYER 2 CARDS
		p2Card1.setFitWidth(125);
		p2Card1.setFitHeight(175);
		p2Card2.setFitWidth(125);
		p2Card2.setFitHeight(175);
		p2Card3.setFitWidth(125);
		p2Card3.setFitHeight(175);
		
		HBox p2Cards = new HBox(20, p2Card1, p2Card2, p2Card3);
		p2Cards.setAlignment(Pos.CENTER);

		// Player 2 TEXT
		p2NameTxt.setFont(Font.font(45));
		p2Winnings.setFont(Font.font(20));
		p2MoneyTxt.setFont(Font.font(20));
		HBox p2Money = new HBox(5, p2Winnings, p2MoneyTxt);
		p2Money.setAlignment(Pos.CENTER);
		VBox p2Txt = new VBox(5, p2NameTxt, p2Money);
		p2Txt.setAlignment(Pos.CENTER);
		
		VBox p2Setup = new VBox(20, p2Txt, p2Cards);
		p2Setup.setAlignment(Pos.CENTER);
		

		
		// PLAYER 1 BET FIELD		
		Text p1AnteBetTxt = new Text("Ante Bet: ");
		Text p1PairBetTxt = new Text("Pair Bet: ");
		Text p1PlayBetTxt = new Text("Play Bet: ");
		p1PlayBetField.setDisable(true);;
		VBox p1BetTxt = new VBox(20, p1AnteBetTxt, p1PairBetTxt, p1PlayBetTxt);
		VBox p1BetField = new VBox(5, p1AnteBetField, p1PairBetField, p1PlayBetField);
		HBox p1Bets = new HBox(5, p1BetTxt, p1BetField);
		
		// PLAUER 2 BET FIELD
		Text p2AnteBetTxt = new Text("Ante Bet: ");
		Text p2PairBetTxt = new Text("Pair Bet: ");
		Text p2PlayBetTxt = new Text("Play Bet: ");
		p2PlayBetField.setDisable(true);
		VBox p2BetTxt = new VBox(20, p2AnteBetTxt, p2PairBetTxt, p2PlayBetTxt);
		VBox p2BetField = new VBox(5, p2AnteBetField, p2PairBetField, p2PlayBetField);
		HBox p2Bets = new HBox(5, p2BetTxt, p2BetField);
		
		// GAME INFO
		Rectangle gameInfoBox = new Rectangle(400, 150);
		gameInfoBox.setFill(Color.TRANSPARENT);
		gameInfoBox.setStroke(Color.BLACK);
		StackPane gameInfo = new StackPane();
		gameInfo.getChildren().addAll(gameInfoBox, gameInfoText);
		
		HBox betField = new HBox(10, p1Bets, gameInfo, p2Bets);
		betField.setAlignment(Pos.CENTER);
		
		// GAME INFO FONT
		gameInfoText.setFont(Font.font(20));
		roundInfo.setFont(Font.font(20));
		
		// CONTROL BUTTONS
		// Start | NewRound Button
		startBtn.setMinHeight(50);
		startBtn.setMinWidth(100);
		startBtn.setOnAction((event)-> {
			if(startGame) { // reseting the board for a new round
				// fixing the buttons
				startBtn.setText("Deal");
				betBtn.setDisable(true);
				foldBtn.setDisable(true);
				
				// RESETING CARDS
				// dealer cards
				dealerCard1.setImage(grey);
				dealerCard2.setImage(grey);
				dealerCard3.setImage(grey);
				
				// player 1 cards
				p1Card1.setImage(grey);
				p1Card2.setImage(grey);
				p1Card3.setImage(grey);

				// player 2 cards
				p2Card1.setImage(grey);
				p2Card2.setImage(grey);
				p2Card3.setImage(grey);
				
					
				// RESETING TEXTFIELD
				p1AnteBetField.setDisable(false);
				p1PairBetField.setDisable(false);
				p2AnteBetField.setDisable(false);
				p2PairBetField.setDisable(false);
				p1PlayBetField.setText("");
				p2PlayBetField.setText("");
				
				dealer.newRound();
				player1.newRound();
				player2.newRound();
				
				// reseting the gameInfo
				gameInfoText.setText("Players Enter Bets Then Press Deal");
				roundInfo.setText("");
				
				// game states
				startGame = false;
				turn = 0;
			} else {
				try {
					// Get Player Bets
					player1.setAnteBet(Integer.parseInt(p1AnteBetField.getText()));
					player2.setAnteBet(Integer.parseInt(p2AnteBetField.getText()));
					player1.setPairPlusBet(Integer.parseInt(p1PairBetField.getText()));
					player2.setPairPlusBet(Integer.parseInt(p2PairBetField.getText()));
					
					if((player1.getAnteBet() < 5 || player1.getAnteBet() > 25
							|| player1.getPairPlusBet() < 5 || player1.getPairPlusBet() > 25)
							&& player1.getPairPlusBet() != 0) {
						throw new NumberFormatException();
					}
					if((player2.getAnteBet() < 5 || player2.getAnteBet() > 25
							|| player2.getPairPlusBet() < 5 || player2.getPairPlusBet() > 25) 
							&& player2.getPairPlusBet() != 0) {
						throw new NumberFormatException();
					}
					
					// Setting up Buttons
					startBtn.setDisable(true);
					startBtn.setText("New Round");
					betBtn.setDisable(false);
					foldBtn.setDisable(false);	
					
					// Game States
					startGame = true;
					queenHigh = true;
					turn = 1; // sets turn to player 1
					
					// Fixing Game Info
					gameInfoText.setText("Player 1's Turn!\nWould You Like To Play or Fold.");
					
					// Disable Text Fields
					p1AnteBetField.setDisable(true);
					p1PairBetField.setDisable(true);
					p2AnteBetField.setDisable(true);
					p2PairBetField.setDisable(true);
					
					// Dealing Cards To Players
					player1.setHand(dealer.dealHand());
					player2.setHand(dealer.dealHand());
					dealer.setHand(dealer.dealHand());
					
					// Displaying Cards
					// player 1
					ArrayList<Card> p1Hand = player1.getHand();
					Image p1Card1Image = new Image("deckOfCards" + gameDesgin + "/" + p1Hand.get(0).toString() + ".png");
					p1Card1.setImage(p1Card1Image);
					Image p1Card2Image = new Image("deckOfCards" + gameDesgin + "/" + p1Hand.get(1).toString() + ".png");
					p1Card2.setImage(p1Card2Image);
					Image p1Card3Image = new Image("deckOfCards" + gameDesgin + "/" + p1Hand.get(2).toString() + ".png");
					p1Card3.setImage(p1Card3Image);
					
					// player 2
					ArrayList<Card> p2Hand = player2.getHand();
					Image p2Card1Image = new Image("deckOfCards" + gameDesgin + "/" + p2Hand.get(0).toString() + ".png");
					p2Card1.setImage(p2Card1Image);
					Image p2Card2Image = new Image("deckOfCards" + gameDesgin + "/" + p2Hand.get(1).toString() + ".png");
					p2Card2.setImage(p2Card2Image);
					Image p2Card3Image = new Image("deckOfCards" + gameDesgin + "/" + p2Hand.get(2).toString() + ".png");
					p2Card3.setImage(p2Card3Image);
					
					// dealer
					dealerCard1.setImage(backOfCard);
					dealerCard2.setImage(backOfCard);
					dealerCard3.setImage(backOfCard);
				} catch(NumberFormatException e) {
					gameInfoText.setText("Please Enter Number From 5-25");
				}
			}
		});
		
		
		// Bet Button
		betBtn.setMinHeight(50);
		betBtn.setMinWidth(100);
		betBtn.setDisable(true);
		betBtn.setOnAction((event) -> {
			// Player 1's turn
			if(turn == 1) {
				// Game State
				gameInfoText.setText("Player 2's Turn!\nWould You Like To Play or Fold.");
				turn = 2; // setting to player 2's turn
				
				// setting player 1 play bet
				player1.setPlayBet(Integer.parseInt(p1AnteBetField.getText()));
				p1PlayBetField.setText(String.valueOf(player1.getPlayBet()));
				
				
			// Player 2's Turn
			} else if (turn == 2){
				// Setting player 2 play bet
				player2.setPlayBet(Integer.parseInt(p2AnteBetField.getText()));
				p2PlayBetField.setText(String.valueOf(player2.getPlayBet()));
				
				// Flip Dealer Cards
				dealerHand = dealer.getHand();
				Image dealerCard1Image = new Image("deckOfCards" + gameDesgin + "/" + dealerHand.get(0).toString() + ".png");
				dealerCard1.setImage(dealerCard1Image);
				Image dealerCard2Image = new Image("deckOfCards" + gameDesgin + "/" + dealerHand.get(1).toString() + ".png");
				dealerCard2.setImage(dealerCard2Image);
				Image dealerCard3Image = new Image("deckOfCards" + gameDesgin + "/" + dealerHand.get(2).toString() + ".png");
				dealerCard3.setImage(dealerCard3Image);
				
				// Check Queen High
				int dealerEval = ThreeCardLogic.evalHand(dealerHand);
				if(dealerEval == 0) {
					queenHigh = ThreeCardLogic.testQueenHigh(dealerHand);
				}
				
				// Check Dealer Hand Strength
				if(!queenHigh) {
					roundInfo.setText(roundInfo.getText() + "Dealer does not have atleast Queen High\n");
				}
				
				// Player 1 Play Bet
				String player1Results =  player1.PlayBet(dealerHand, queenHigh);
				if(player1Results != "") {
					roundInfo.setText(roundInfo.getText() + "Player 1 " + player1Results + "\n");
				}

				// Player 1 Pair Plus Bet
				roundInfo.setText(roundInfo.getText() + "Player 1 " + player1.pairPlusBet() + "\n");
				
				// Player 2 Play Bet
				String player2Results =  player2.PlayBet(dealerHand, queenHigh);
				if(player2Results != "") {
					roundInfo.setText(roundInfo.getText() + "Player 2 " + player2Results + "\n");
				}
				
				// Player 2 Pair Plus Bet
				roundInfo.setText(roundInfo.getText() + "Player 2 " + player2.pairPlusBet());
				
				// updating money
				p1MoneyTxt.setText(String.valueOf(player1.getTotalWinnings()));
				p2MoneyTxt.setText(String.valueOf(player2.getTotalWinnings()));
				
				// updating buttons
				startBtn.setDisable(false);
				betBtn.setDisable(true);
				foldBtn.setDisable(true);
								
				// displaying round info
				gameInfoText.setText(roundInfo.getText());
				turn = 0;
			}
		});
		
		foldBtn.setMinHeight(50);
		foldBtn.setMinWidth(100);
		foldBtn.setDisable(true);
		foldBtn.setOnAction((event)-> {
			// Player 1 Turn
			if(turn == 1) {
				// Game State
				gameInfoText.setText("Player 2's Turn!\nWould You Like To Play or Fold.");
				turn = 2;
				
				// Play Bet
				player1.setPlayBet(0);
				p1PlayBetField.setText(String.valueOf(player1.getPlayBet()));
				
				// Player 1 Folded
				player1.setFolded(true);
				
			// Player 2 Turn
			} else if (turn == 2) {
				// Player 2 Folded
				player2.setFolded(true);
				
				// Play Bet
				player2.setPlayBet(0);
				p2PlayBetField.setText(String.valueOf(player2.getPlayBet()));

				// Flip Dealer Hand
				dealerHand = dealer.getHand();
				Image dealerCard1Image = new Image("deckOfCards" + gameDesgin + "/" + dealerHand.get(0).toString() + ".png");
				dealerCard1.setImage(dealerCard1Image);
				Image dealerCard2Image = new Image("deckOfCards" + gameDesgin + "/" + dealerHand.get(1).toString() + ".png");
				dealerCard2.setImage(dealerCard2Image);
				Image dealerCard3Image = new Image("deckOfCards" + gameDesgin + "/" + dealerHand.get(2).toString() + ".png");
				dealerCard3.setImage(dealerCard3Image);
				
				// Check Queen High
				int dealerEval = ThreeCardLogic.evalHand(dealerHand);
				if(dealerEval == 0) {
					queenHigh = ThreeCardLogic.testQueenHigh(dealerHand);
				}
				
				// Check Dealer Hand Strength
				if(!queenHigh) {
					roundInfo.setText(roundInfo.getText() + "Dealer does not have atleast Queen High\n");
				}
				
				// Round Calculations
				
				String player1Results = player1.PlayBet(dealerHand, queenHigh);
				if(player1Results != "") 
					roundInfo.setText(roundInfo.getText() + "Player 1 " + player1Results + "\n");
				roundInfo.setText(roundInfo.getText() + "Player 1 " + player1.pairPlusBet() + "\n");
			
				String player2Results = player2.PlayBet(dealerHand, queenHigh);
				if(player2Results != "") 
					roundInfo.setText(roundInfo.getText() + "Player 2 " + player2Results + "\n");
				roundInfo.setText(roundInfo.getText() + "Player 2 " + player2.pairPlusBet());

				// updating money
				p1MoneyTxt.setText(String.valueOf(player1.getTotalWinnings()));
				p2MoneyTxt.setText(String.valueOf(player2.getTotalWinnings()));
				
				// updating buttons
				startBtn.setDisable(false);
				betBtn.setDisable(true);
				foldBtn.setDisable(true);
				
				// displaying round info
				gameInfoText.setText(roundInfo.getText());
				turn = 0;
			}
		});
		
		VBox controlBtn = new VBox(10, startBtn, betBtn, foldBtn);
		controlBtn.setAlignment(Pos.BOTTOM_CENTER);
		
		HBox playerSetup = new HBox(10, p1Setup, controlBtn, p2Setup);
		playerSetup.setAlignment(Pos.CENTER);
		
		VBox game = new VBox(20, dealerSetup, playerSetup, betField);
		game.setAlignment(Pos.CENTER);
		
	    root.setBackground(new Background(new BackgroundFill(Color.GREEN, null, null)));
	    root.setTop(menuBar);
		root.setCenter(game);
		
		Scene scene = new Scene(root, 1180, 1024);
		primaryStage.setResizable(false);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}

