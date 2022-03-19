import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.sqlite.SQLiteDataSource;

public class TriviaMaze extends Application {

	private Maze myMaze;
	private GridPane myGrid;
	private Player myCurrentPlayer;
	private Question_Answer myCurrentQA;
	private String myCurrentQType;
	private boolean myEnterUnanswered;
	private boolean myMultUnanswered;
	private boolean myTrueFalseUnanswered;
	private boolean myNotAtEnd;
	private Door myCurrentDoor;
	private Button myAButton;
	private Button myBButton;
	private Button myCButton;
	private Button myDButton;
	private Button myEnterButton;
	private Button myTrueButton;
	private Button myFalseButton;
	private Button myUpButton;
	private Button myLeftButton;
	private Button myRightButton;
	private Button myDownButton;
	private TextArea myTextArea;
	private TextField myTextField;
	private TextArea myHelpTextArea;
	private TextField myNameTextField;
	private Button mySetNameButton;
	private Button mySubmitButton;
	private Button mySaveButton;
	private Button myLoadButton;
	private Button myRestartButton;
	private VBox mySetNameFieldAndSubmitBox;
	private HBox myLoadSaveBox;
	private String myMultipleChoiceSelection;
	private Room myCurrentRoom;
	private String myPlayerDirection;
	private VBox myFieldAndEnterBox;
	private HBox myabcdButtonsBox;
	private HBox myTrueFalseButtonsBox;
	private HBox myAllButtonsBox;
	private String[] myPlayerDataArray;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		primaryStage.setTitle("RuneScape Trivia Maze");
		
		myMaze = new Maze();
		
		myHelpTextArea = new TextArea();
		myHelpTextArea.setMinSize(300, 250);
		myHelpTextArea.setMaxSize(300, 250);
		myHelpTextArea.setEditable(false);
		myHelpTextArea.setWrapText(true);
		myHelpTextArea.setText("Welcome to the RuneScape Trivia Maze!\nSetting your name, saving, "
				+ "and loading is done below.\n \nTo play the game, you may go up, left, right, "
				+ "or down. The game will prompt you with a question and give you buttons to "
				+ "press. Answer the questions correctly to move. Getting to the red circle in "
				+ "the bottom right corner is the objective. \n\nGood luck!");
		
		myNameTextField = new TextField();
		myNameTextField.setMinSize(300, 30);
		myNameTextField.setMaxSize(300, 30);
		
		mySubmitButton = new Button();
		mySubmitButton.setText("Submit");
		mySubmitButton.setMinSize(100, 25);
		mySubmitButton.setMaxSize(100, 25);
		mySubmitButton.setOnAction(new EventHandler<ActionEvent>() {
		
		    @Override 
		    public void handle(ActionEvent e) {
		    	
		        myCurrentPlayer.setName(myNameTextField.getText());
		    	myGrid.add(myCurrentPlayer.getShape(), myCurrentPlayer.getColumn(), myCurrentPlayer.getRow());
		    	myNameTextField.clear();
		    	mySetNameFieldAndSubmitBox.setVisible(false);
		    	
		    }
		});
		
		mySetNameFieldAndSubmitBox = new VBox(10);
		mySetNameFieldAndSubmitBox.setAlignment(Pos.CENTER);
		mySetNameFieldAndSubmitBox.getChildren().addAll(myNameTextField, mySubmitButton);
		mySetNameFieldAndSubmitBox.setVisible(false);
		
		mySetNameButton = new Button();
		mySetNameButton.setText("Set Name");
		mySetNameButton.setMinSize(100, 25);
		mySetNameButton.setMaxSize(100, 25);
		mySetNameButton.setOnAction(new EventHandler<ActionEvent>() {
		
		    @Override 
		    public void handle(ActionEvent e) {
		    	mySetNameFieldAndSubmitBox.setVisible(true);  
		    }
		});
		
		mySaveButton = new Button();
		mySaveButton.setText("Save");
		mySaveButton.setMinSize(100, 25);
		mySaveButton.setMaxSize(100, 25);
		mySaveButton.setOnAction(new EventHandler<ActionEvent>() {
		
		    @Override 
		    public void handle(ActionEvent e) {
		    	
		        saveLogic();
		    	
		    }
		});
		
		myLoadButton = new Button();
		myLoadButton.setText("Load");
		myLoadButton.setMinSize(100, 25);
		myLoadButton.setMaxSize(100, 25);
		myLoadButton.setOnAction(new EventHandler<ActionEvent>() {
		
		    @Override 
		    public void handle(ActionEvent e) {
		    	
		    	loadLogic();
		    	
		    }
		});
		
		myRestartButton = new Button();
		myRestartButton.setText("Restart");
		myRestartButton.setMinSize(100, 25);
		myRestartButton.setMaxSize(100, 25);
		myRestartButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override 
			public void handle(ActionEvent e) {
		        
				restartLogic();
				
		    }
		});
		
		myLoadSaveBox = new HBox(25);
		myLoadSaveBox.getChildren().addAll(mySaveButton, myLoadButton);
		myLoadSaveBox.setAlignment(Pos.CENTER);
		
		VBox rightVBox = new VBox(40);
		rightVBox.setAlignment(Pos.CENTER);
		rightVBox.getChildren().addAll(myHelpTextArea, mySetNameButton, mySetNameFieldAndSubmitBox, myLoadSaveBox, myRestartButton);
		
		myTextArea = new TextArea();
		myTextArea.setMinSize(300, 250);
		myTextArea.setMaxSize(300, 250);
		myTextArea.setEditable(false);
		myTextArea.setWrapText(true);
		
		myTextField = new TextField();
		myTextField.setMinSize(300, 30);
		myTextField.setMaxSize(300, 30);
		
		myAButton = new Button();
		myAButton.setText("A");
		myAButton.setMinSize(50, 25);
		myAButton.setMaxSize(50, 25);
		myAButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				myMultipleChoiceSelection = "a";	
				if (myCurrentQType.equals("abcd") && (myMultUnanswered == true)) {
					if (gotItRightWithString(myCurrentQA, myMultipleChoiceSelection)) {
						movePlayer();
					} else {
						myCurrentDoor.setPermLocked(true);
						myTextArea.clear();
		    			myTextArea.appendText("Wrong! This door is now locked");
					}
					myabcdButtonsBox.setVisible(false);
					myAllButtonsBox.setVisible(true);
				}
			}	
		});
		
		myBButton = new Button();
		myBButton.setText("B");
		myBButton.setMinSize(50, 25);
		myBButton.setMaxSize(50, 25);
		myBButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				myMultipleChoiceSelection = "b";
				if (myCurrentQType.equals("abcd") && (myMultUnanswered == true)) {
					if (gotItRightWithString(myCurrentQA, myMultipleChoiceSelection)) {
						movePlayer();
					} else {
						myCurrentDoor.setPermLocked(true);
						myTextArea.clear();
		    			myTextArea.appendText("Wrong! This door is now locked");
					}
					myabcdButtonsBox.setVisible(false);
					myAllButtonsBox.setVisible(true);
				}
			}
			
		});
		
		myCButton = new Button();
		myCButton.setText("C");
		myCButton.setMinSize(50, 25);
		myCButton.setMaxSize(50, 25);
		myCButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				myMultipleChoiceSelection = "c";
				if (myCurrentQType.equals("abcd") && (myMultUnanswered == true)) {
					if (gotItRightWithString(myCurrentQA, myMultipleChoiceSelection)) {
						movePlayer();
					} else {
						myCurrentDoor.setPermLocked(true);
						myTextArea.clear();
		    			myTextArea.appendText("Wrong! This door is now locked");
					}
					myabcdButtonsBox.setVisible(false);
					myAllButtonsBox.setVisible(true);
				}
			}
			
		});
		
		myDButton = new Button();
		myDButton.setText("D");
		myDButton.setMinSize(50, 25);
		myDButton.setMaxSize(50, 25);
		myDButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				myMultipleChoiceSelection = "d";
				if (myCurrentQType.equals("abcd") && (myMultUnanswered == true)) {
					if (gotItRightWithString(myCurrentQA, myMultipleChoiceSelection)) {
						movePlayer();
					} else {
						myCurrentDoor.setPermLocked(true);
						myTextArea.clear();
		    			myTextArea.appendText("Wrong! This door is now locked");
					}
					myabcdButtonsBox.setVisible(false);
					myAllButtonsBox.setVisible(true);
				}
			}
			
		});
		
		myEnterButton = new Button();
		myEnterButton.setText("Enter");
		myEnterButton.setMinSize(100, 25);
		myEnterButton.setMaxSize(100, 25);
		myEnterButton.setOnAction(new EventHandler<ActionEvent>() {
		
		    @Override 
		    public void handle(ActionEvent e) {
		    	if (myCurrentQType.equals("Short Answer") && (myEnterUnanswered == true)) { 
		    		if (gotItRight(myCurrentQA)) {
		    			myTextField.clear();
		    			movePlayer();
		    		} else {
		    			myCurrentDoor.setPermLocked(true);
		    			myTextField.clear();
		    			myTextArea.clear();
		    			myTextArea.appendText("Wrong! This door is now locked");
		    		}
		    		myFieldAndEnterBox.setVisible(false);
		    		myAllButtonsBox.setVisible(true);
		    	} 
		    }
		});
		
		myFieldAndEnterBox = new VBox(10);
		myFieldAndEnterBox.setAlignment(Pos.CENTER);
		myFieldAndEnterBox.getChildren().addAll(myTextField, myEnterButton);
        myFieldAndEnterBox.setVisible(false);
		
		myabcdButtonsBox = new HBox(33);
		myabcdButtonsBox.getChildren().addAll(myAButton, myBButton, myCButton, myDButton);
		myabcdButtonsBox.setVisible(false);
		
		myTrueButton = new Button();
		myTrueButton.setText("True");
		myTrueButton.setMinSize(100, 25);
		myTrueButton.setMaxSize(100, 25);
		myTrueButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override public void handle(ActionEvent e) {
		    	if (myCurrentQType.equals("T/F") && (myTrueFalseUnanswered == true)) { 
		    		if (gotItRightWithString(myCurrentQA, "true")) {
		    			myTextField.clear();
		    			movePlayer();
		    		} else {
		    			myCurrentDoor.setPermLocked(true);
		    			myTextField.clear();
		    			myTextArea.clear();
		    			myTextArea.appendText("Wrong! This door is now locked");
		    		}
		    		myTrueFalseButtonsBox.setVisible(false);
		    		myAllButtonsBox.setVisible(true);
		    	} 
		    }
		});
		
		myFalseButton = new Button();
		myFalseButton.setText("False");
		myFalseButton.setMinSize(100, 25);
		myFalseButton.setMaxSize(100, 25);
		myFalseButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override public void handle(ActionEvent e) {
		    	if (myCurrentQType.equals("T/F") && (myTrueFalseUnanswered == true)) { 
		    		if (gotItRightWithString(myCurrentQA, "false")) {
		    			myTextField.clear();
		    			movePlayer();
		    		} else {
		    			myCurrentDoor.setPermLocked(true);
		    			myTextField.clear();
		    			myTextArea.clear();
		    			myTextArea.appendText("Wrong! This door is now locked");
		    		}
		    		myTrueFalseButtonsBox.setVisible(false);
		    		myAllButtonsBox.setVisible(true);
		    	} 
		    }
		});
		
		myTrueFalseButtonsBox = new HBox(25);
		myTrueFalseButtonsBox.getChildren().addAll(myTrueButton, myFalseButton);
		myTrueFalseButtonsBox.setAlignment(Pos.CENTER);
		myTrueFalseButtonsBox.setVisible(false);
		
		VBox leftVBox = new VBox(40);
		leftVBox.setAlignment(Pos.CENTER);
		leftVBox.getChildren().addAll(myTextArea, myFieldAndEnterBox, myabcdButtonsBox, myTrueFalseButtonsBox);
		
		myCurrentPlayer = new Player("Player", 0, 0);
		
		myGrid = new GridPane();
		myGrid.setAlignment(Pos.CENTER);
	    myGrid.setHgap(4);
		myGrid.setMinSize(360, 420);
		
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if ((i % 2 == 0) && (j % 2 == 0)) {
					Rectangle rect = new Rectangle(60, 60, 60, 60);
					rect.setFill(Color.WHITE);
					rect.setStroke(Color.BLACK);
					myGrid.add(rect, i, j);
				} else if ((j % 2 == 1) && (i % 2 == 0)) {
					myGrid.add(myMaze.getRoom(i, j - 1).getRightDoor().getShape(), j, i);
				} else if ((i % 2 == 1) && (j % 2 == 0)) {
					myGrid.add(myMaze.getRoom(i - 1, j).getBottomDoor().getShape(), j, i);
					GridPane.setHalignment(myMaze.getRoom(i-1, j).getBottomDoor().getShape(), HPos.CENTER);
				}
				
			}
		}
		
		myGrid.add(myCurrentPlayer.getShape(), 0, 0);
		myNotAtEnd = true;
		
		final Circle endCircle = new Circle(0,0,25);
		final Text endText = new Text("END");
		final  StackPane endObject = new StackPane();
		endCircle.setFill(Color.RED);
		endObject.getChildren().addAll(endCircle, endText);
		endObject.setVisible(true);
		myGrid.add(endObject, 8, 8);
		
		myUpButton = new Button();
		myUpButton.setText("Up");
		myUpButton.setMinSize(52, 25);
		myUpButton.setMaxSize(52, 25);
		myUpButton.setOnAction(new EventHandler<ActionEvent>() {
			
		    @Override public void handle(ActionEvent e) {
		    	if (myNotAtEnd) {
		    		if (myCurrentPlayer.getRow() > 0) {
		    			Room upperRoom = myMaze.getRoom(myCurrentPlayer.getRow() - 2, myCurrentPlayer.getColumn());
			    		myCurrentDoor = upperRoom.getBottomDoor();
			    		myCurrentQA = myCurrentDoor.getQuestion_Answer();
			    	    myCurrentQA.generate();
			    		if (!myCurrentDoor.getPermLockStat()) {
			    			myAllButtonsBox.setVisible(false);
			    			askQuestion(myCurrentQA);
			    			myPlayerDirection = "up";
			    		} else {
			    			myTextArea.clear();
			    			myTextArea.appendText("This door is permanently locked");
			    		}
		    		} else {
		    			myTextArea.clear();
			    		myTextArea.appendText("Cannot go up");
		    		}
		    	} else {
		    		myTextArea.clear();
	    			myTextArea.appendText("No need to move, you already won!");
		    	}
		    }
		});
		
		myLeftButton = new Button();
		myLeftButton.setText("Left");
		myLeftButton.setMinSize(50, 25);
		myLeftButton.setMaxSize(50, 25);
		myLeftButton.setOnAction(new EventHandler<ActionEvent>() {
			
		    @Override public void handle(ActionEvent e) {
		    	if (myNotAtEnd) {
		    		if (myCurrentPlayer.getColumn() > 0) {
		    			Room leftRoom = myMaze.getRoom(myCurrentPlayer.getRow(), myCurrentPlayer.getColumn() - 2);
			    		myCurrentDoor = leftRoom.getRightDoor();
			    		myCurrentQA = myCurrentDoor.getQuestion_Answer();
			    		myCurrentQA.generate();
			    		if (!myCurrentDoor.getPermLockStat()) {
			    			myAllButtonsBox.setVisible(false);
			    			askQuestion(myCurrentQA);
			    			myPlayerDirection = "left";
			    		} else {
			    			myTextArea.clear();
			    			myTextArea.appendText("This door is permanently locked");
			    		}
		    		} else {
		    			myTextArea.clear();
			    		myTextArea.appendText("Cannot go left");
		    		}
		    	} else {
		    		myTextArea.clear();
	    			myTextArea.appendText("No need to move, you already won!");
		    	}
		    }
		});
		
		myRightButton = new Button();
		myRightButton.setText("Right");
		myRightButton.setMinSize(50, 25);
		myRightButton.setMaxSize(50, 25);
		myRightButton.setOnAction(new EventHandler<ActionEvent>() {
			
		    @Override public void handle(ActionEvent e) {
		    	if (myNotAtEnd) {
		    		if (myCurrentPlayer.getColumn() < 8) {
		    			Room thisRoom = myMaze.getRoom(myCurrentPlayer.getRow(), myCurrentPlayer.getColumn());
			    		myCurrentDoor = thisRoom.getRightDoor();
			    		myCurrentQA = myCurrentDoor.getQuestion_Answer();
			    		myCurrentQA.generate();
			    		if (!myCurrentDoor.getPermLockStat()) {
			    			myAllButtonsBox.setVisible(false);
			    			askQuestion(myCurrentQA);
			    			myPlayerDirection = "right";
			    		} else {
			    			myTextArea.clear();
			    			myTextArea.appendText("This door is permanently locked");
			    		}
		    		} else {
		    			myTextArea.clear();
			    		myTextArea.appendText("Cannot go right");
		    		}
		    	} else {
		    		myTextArea.clear();
	    			myTextArea.appendText("No need to move, you already won!");
		    	}
		    }
		});
		
		myDownButton = new Button();
		myDownButton.setText("Down");
		myDownButton.setMinSize(52, 25);
		myDownButton.setMaxSize(52, 25);
		myDownButton.setOnAction(new EventHandler<ActionEvent>() {
			
		    @Override public void handle(ActionEvent e) {
		    	if (myNotAtEnd) {
		    		if (myCurrentPlayer.getRow() < 8) {
		    			Room thisRoom = myMaze.getRoom(myCurrentPlayer.getRow(), myCurrentPlayer.getColumn());
			    		myCurrentDoor = thisRoom.getBottomDoor();
			    		myCurrentQA = myCurrentDoor.getQuestion_Answer();
			    		myCurrentQA.generate();
			    		if (!myCurrentDoor.getPermLockStat()) {
			    			myAllButtonsBox.setVisible(false);
			    			askQuestion(myCurrentQA);
			    			myPlayerDirection = "down";
			    		} else {
			    			myTextArea.clear();
			    			myTextArea.appendText("This door is permanently locked");
			    		}
		    		} else {
		    			myTextArea.clear();
			    		myTextArea.appendText("Cannot go down");
		    		}
		    	} else {
		    		myTextArea.clear();
	    			myTextArea.appendText("No need to move, you already won!");
		    	}
		    }
		});
	
		VBox upDownButtonsBox = new VBox(25);
		upDownButtonsBox.setAlignment(Pos.CENTER);
		myAllButtonsBox = new HBox();
		upDownButtonsBox.getChildren().addAll(myUpButton, myDownButton);
		myAllButtonsBox.getChildren().addAll(myLeftButton, upDownButtonsBox, myRightButton);
		myAllButtonsBox.setMinSize(75, 150);
		myAllButtonsBox.setMaxSize(75, 150);
		myAllButtonsBox.setAlignment(Pos.CENTER);
		
		StackPane Pane = new StackPane();
		Pane.setStyle("-fx-background-color: DDDDDD");
		Pane.setMinSize(800, 650);
		Pane.setMaxSize(800, 650);
		
		VBox gridAndButtonsBox = new VBox();
		gridAndButtonsBox.getChildren().addAll(myGrid, myAllButtonsBox);
		gridAndButtonsBox.setAlignment(Pos.CENTER);
		
		HBox leftAndRightVBoxes = new HBox(25);
		leftAndRightVBoxes.setAlignment(Pos.CENTER);
		leftAndRightVBoxes.getChildren().addAll(leftVBox, gridAndButtonsBox, rightVBox);
		
		
		Pane.getChildren().add(leftAndRightVBoxes);
		StackPane.setAlignment(leftAndRightVBoxes, Pos.CENTER);
		
		Scene scene = new Scene(Pane, 1100, 650);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	void removePlayer(GridPane theGrid, Player theCurrentPlayer) {
		
	    for (final Node node : theGrid.getChildren()) {
		    if (node == theCurrentPlayer.getShape()) {
			    theGrid.getChildren().removeAll(node);
			    break;
	        }          
	    }  
	}
	
	private void askQuestion(Question_Answer theQA) {
		myCurrentQType = theQA.getQuestionType();
		if (myCurrentQType.equals("Short Answer")) {
			myMultUnanswered = false;
			myTrueFalseUnanswered = false;
			
			myFieldAndEnterBox.setVisible(true);
			myabcdButtonsBox.setVisible(false);
			myTrueFalseButtonsBox.setVisible(false);
			
			myEnterUnanswered = true;
		} else if (myCurrentQType.equals("abcd")) {
			myEnterUnanswered = false;
			myTrueFalseUnanswered = false;
			
			myFieldAndEnterBox.setVisible(false);
			myabcdButtonsBox.setVisible(true);
			myTrueFalseButtonsBox.setVisible(false);
			
			myMultUnanswered = true;
		} else if (myCurrentQType.equals("T/F")) {
			myEnterUnanswered = false;
			myMultUnanswered = false;
			
			myFieldAndEnterBox.setVisible(false);
			myabcdButtonsBox.setVisible(false);
			myTrueFalseButtonsBox.setVisible(true);
			
			myTrueFalseUnanswered = true;
		}
		myTextArea.clear();
		myTextArea.appendText(theQA.getQuestion());
		
	}
	
	private boolean gotItRight(Question_Answer theQA) {
		boolean gotItRight = false;
		String rightAnswer = theQA.getAnswer();
		String userAnswer = myTextField.getText();
		if (rightAnswer.equalsIgnoreCase(userAnswer)) {
			gotItRight = true;
		}
		return gotItRight;
	}
	
	private boolean gotItRightWithString(Question_Answer theQA, String theUserAnswer) {
		boolean gotItRight = false;
		String rightAnswer = theQA.getAnswer();
		if (rightAnswer.equalsIgnoreCase(theUserAnswer)) {
			gotItRight = true;
		}
		return gotItRight;
	}
	
	private void movePlayer() {
		switch (myPlayerDirection) {
    	case "up":

    		removePlayer(myGrid, myCurrentPlayer); 
    		myCurrentPlayer.setRow(myCurrentPlayer.getRow() - 2);
    		setPlayerSQL(myCurrentPlayer.getName(), myCurrentPlayer.getRow(), myCurrentPlayer.getColumn());
    		myGrid.add(myCurrentPlayer.getShape(), myCurrentPlayer.getColumn(), myCurrentPlayer.getRow());
    		myTextArea.clear();
			myTextArea.appendText("Correct!");
    		myMultUnanswered = false;
    		myEnterUnanswered = false;
    		myTrueFalseUnanswered = false;
    		if (myCurrentPlayer.getRow() == 8 && myCurrentPlayer.getColumn() == 8) {
    			myNotAtEnd = false;
    			myTextArea.clear();
    			myHelpTextArea.clear();
    			myHelpTextArea.appendText("Congratulations, you beat the Runescape Trivia Maze!\n \n To play again, press the restart button");
    		}
    		myPlayerDataArray = getPlayerSQL();
    		break;
    		
    	case "left":
    		
    		removePlayer(myGrid, myCurrentPlayer); 
    		myCurrentPlayer.setColumn(myCurrentPlayer.getColumn() - 2);
    		myGrid.add(myCurrentPlayer.getShape(), myCurrentPlayer.getColumn(), myCurrentPlayer.getRow());
    		myTextArea.clear();
			myTextArea.appendText("Correct!");
    		myMultUnanswered = false;
    		myEnterUnanswered = false;
    		myTrueFalseUnanswered = false;
    		if (myCurrentPlayer.getRow() == 8 && myCurrentPlayer.getColumn() == 8) {
    			myNotAtEnd = false;
    			myTextArea.clear();
    			myHelpTextArea.clear();
    			myHelpTextArea.appendText("Congratulations, you beat the Runescape Trivia Maze!\n \n To play again, press the restart button");
    		}
    		break;
    		
    	case "right":
    		
    		removePlayer(myGrid, myCurrentPlayer); 
    		myCurrentPlayer.setColumn(myCurrentPlayer.getColumn() + 2);
    		myGrid.add(myCurrentPlayer.getShape(), myCurrentPlayer.getColumn(), myCurrentPlayer.getRow());
    		myTextArea.clear();
			myTextArea.appendText("Correct!");
    		myMultUnanswered = false;
    		myEnterUnanswered = false;
    		myTrueFalseUnanswered = false;
    		if (myCurrentPlayer.getRow() == 8 && myCurrentPlayer.getColumn() == 8) {
    			myNotAtEnd = false;
    			myTextArea.clear();
    			myHelpTextArea.clear();
    			myHelpTextArea.appendText("Congratulations, you beat the Runescape Trivia Maze!\n \n To play again, press the restart button");
    		}
    		break;
    	
    	case "down":
    		
    		removePlayer(myGrid, myCurrentPlayer); 
    		myCurrentPlayer.setRow(myCurrentPlayer.getRow() + 2);
    		myGrid.add(myCurrentPlayer.getShape(), myCurrentPlayer.getColumn(), myCurrentPlayer.getRow());
    		myTextArea.clear();
			myTextArea.appendText("Correct!");
    		myMultUnanswered = false;
    		myEnterUnanswered = false;
    		myTrueFalseUnanswered = false;
    		if (myCurrentPlayer.getRow() == 8 && myCurrentPlayer.getColumn() == 8) {
    			myNotAtEnd = false;
    			myTextArea.clear();
    			myHelpTextArea.clear();
    			myHelpTextArea.appendText("Congratulations, you beat the Runescape Trivia Maze!\n \n To play again, press the restart button");
    		}
    		break;
    	}
	}
	
    private void setPlayerSQL(String theNameVariable, int theRowVariable, int theColumnVariable) {
	    SQLiteDataSource ds = null;
		try {
            ds = new SQLiteDataSource();
            ds.setUrl("jdbc:sqlite:players.db");
        } catch ( Exception e ) {
            e.printStackTrace();
            System.exit(0);
        }
		try ( Connection conn = ds.getConnection();
		    Statement stmt = conn.createStatement(); ){
		    String updateQuery = "UPDATE players SET NAME = '" + theNameVariable + "',  ROW = " + theRowVariable + ", COLUMN = " + theColumnVariable;
		    stmt.executeUpdate(updateQuery);

	    } catch ( SQLException e ) {
		      e.printStackTrace();
		      System.exit( 0 );
	    }
	}
	
	private String[] getPlayerSQL() {
		
		SQLiteDataSource ds = null;
		
		try {
            ds = new SQLiteDataSource();
            ds.setUrl("jdbc:sqlite:players.db");
        } catch ( Exception e ) {
            e.printStackTrace();
            System.exit(0);
        }
		
		String selectQuery = "SELECT * FROM players";
		String name = new String();
		String row = new String();
		String column = new String();
		
		try ( Connection conn = ds.getConnection();
	        Statement stmt = conn.createStatement(); ) {

	        ResultSet rs = stmt.executeQuery(selectQuery);

	        while ( rs.next() ) {
	            name = rs.getString( "NAME" );
	            row = rs.getString( "ROW" );
	            column = rs.getString( "COLUMN" );
	        }
	    } catch ( SQLException e ) {
	        e.printStackTrace();
	        System.exit( 0 );
	    }
		
		String[] returnArray = {name, row, column};
		
		return returnArray;
	}
	
	void saveLogic() {
		setPlayerSQL(myCurrentPlayer.getName(), myCurrentPlayer.getRow(), myCurrentPlayer.getColumn());
        
        SQLiteDataSource ds = null;
		try {
            ds = new SQLiteDataSource();
            ds.setUrl("jdbc:sqlite:doors.db");
        } catch ( Exception e1 ) {
            e1.printStackTrace();
            System.exit(0);
        }
		
        try ( Connection conn = ds.getConnection();
              Statement stmt = conn.createStatement(); ) {
            
            String deleteQuery = "delete from doors";
            stmt.executeUpdate(deleteQuery);
            
        } catch ( SQLException e1 ) {
            e1.printStackTrace();
            System.exit( 0 );
        }
		
		int increment = 1;
	    try ( Connection conn = ds.getConnection();
            Statement stmt = conn.createStatement(); ) {
	        for (int i = 0; i < 9; i = i + 2) {
			    for (int j = 0; j < 9; j = j + 2) {
			    	if ((i % 2 == 0) && (j % 2 == 0)) {
			    		
			    		myCurrentRoom = myMaze.getRoom(i, j);
			    		Door rightDoor = myCurrentRoom.getRightDoor();
			    		int rightDoorLocked = 0;
			    		if (rightDoor.getPermLockStat()) {
			    			rightDoorLocked = 1;
			    		}
			    		String query1 = "INSERT INTO doors ( ID, ISLOCKED ) VALUES ('" + increment + "', " + rightDoorLocked + ")";   // ('Joe', 0, 0)
			    		stmt.executeUpdate(query1);
			    		increment++;
			    		
			    		Door bottomDoor = myCurrentRoom.getBottomDoor();
			    		int bottomDoorLocked = 0;
			    		if (bottomDoor.getPermLockStat()) {
			    			bottomDoorLocked = 1;
			    		}
			    		String query2 = "INSERT INTO doors ( ID, ISLOCKED ) VALUES ('" + increment + "', " + bottomDoorLocked + ")";   // ('Joe', 0, 0)
			    	    stmt.executeUpdate(query2);
			    	    increment++;
			    	}
			    }
		    }
        } catch ( SQLException e1 ) {
	        e1.printStackTrace();
            System.exit( 0 );
        }
        myHelpTextArea.setText("Welcome to the RuneScape Trivia Maze!\nSetting your name, saving, "
				+ "and loading is done below.\n \nTo play the game, you may go up, left, right, "
				+ "or down. The game will prompt you with a question and give you buttons to "
				+ "press. Answer the questions correctly to move. Getting to the red circle in "
				+ "the bottom right corner is the objective. \n\nGood luck!");
    	
	}
	
	void loadLogic() {
		
		myNotAtEnd = true;
		myHelpTextArea.setText("Welcome to the RuneScape Trivia Maze!\nSetting your name, saving, "
				+ "and loading is done below.\n \nTo play the game, you may go up, left, right, "
				+ "or down. The game will prompt you with a question and give you buttons to "
				+ "press. Answer the questions correctly to move. Getting to the red circle in "
				+ "the bottom right corner is the objective. \n\nGood luck!");
		removePlayer(myGrid, myCurrentPlayer); 
        myPlayerDataArray = getPlayerSQL();
        myCurrentPlayer.setName(myPlayerDataArray[0]);
        myCurrentPlayer.setRow(Integer.parseInt(myPlayerDataArray[1]));
        myCurrentPlayer.setColumn(Integer.parseInt(myPlayerDataArray[2]));
		myGrid.add(myCurrentPlayer.getShape(), myCurrentPlayer.getColumn(), myCurrentPlayer.getRow());
		
	    SQLiteDataSource ds = null;
		try {
            ds = new SQLiteDataSource();
            ds.setUrl("jdbc:sqlite:doors.db");
        } catch ( Exception e1 ) {
            e1.printStackTrace();
            System.exit(0);
        }
		int increment = 1;
		String selectQuery = "SELECT * FROM doors";
		for (int i = 0; i < 9; i = i + 2) {
		    for (int j = 0; j < 9; j = j + 2) {
		    	if ((i % 2 == 0) && (j % 2 == 0)) {
		    		myCurrentRoom = myMaze.getRoom(i, j);
		    		try ( Connection conn = ds.getConnection();
			                Statement stmt = conn.createStatement(); ) {
		    			ResultSet rs = stmt.executeQuery(selectQuery);
		    			boolean rightDoorAssigned = false;
		    			boolean bottomDoorAssigned = false;
		    			while (rs.next()) {
		    				
		    				String iD = rs.getString( "ID" );
			    			String isLocked = rs.getString( "ISLOCKED" );
			    			
				    		Door rightDoor = myCurrentRoom.getRightDoor();
				    		Door bottomDoor = myCurrentRoom.getBottomDoor();
				            
				    		if (Integer.parseInt(iD) % 2 == 1) {
				    			
				    			if (iD.equals(String.valueOf(increment)) && isLocked.equals("1")) {
				    				
				    				rightDoor.setPermLocked(true);
				    				if (!rightDoorAssigned) {
				    					increment++;
				    				}
				    				rightDoorAssigned = true;
				    				
				    			} else if (iD.equals(String.valueOf(increment)) && isLocked.equals("0")) {
				    				
				    				rightDoor.setPermLocked(false);
				    				if (!rightDoorAssigned) {
				    					increment++;
				    				}
				    				rightDoorAssigned = true;
				    			} 
				    		}
				    		 
				    		if (Integer.parseInt(iD) % 2 == 0) {
				    			
				    			if (iD.equals(String.valueOf(increment)) && isLocked.equals("1")) {
				    				
				    				bottomDoor.setPermLocked(true);
				    				if (!bottomDoorAssigned) {
				    					increment++;
				    				}
				    				bottomDoorAssigned = true;
				    			} else if (iD.equals(String.valueOf(increment)) && isLocked.equals("0")) {
				    				
				    				bottomDoor.setPermLocked(false);
				    				if (!bottomDoorAssigned) {
				    					increment++;
				    				}
				    				bottomDoorAssigned = true;
				    			} 
				    		}
				    		
				    		if (rightDoorAssigned && bottomDoorAssigned) {
				    			break;
				    		}
		    			}
		    			
		    		} catch ( SQLException e1 ) {
				        e1.printStackTrace();
		                System.exit( 0 );
			        }
		    	}
		    }
		}
    }
	
	void restartLogic() {
		
		myNotAtEnd = true;
		myHelpTextArea.clear();
    	myHelpTextArea.setText("Welcome to the RuneScape Trivia Maze!\nSetting your name, saving, "
				+ "and loading is done below.\n \nTo play the game, you may go up, left, right, "
				+ "or down. The game will prompt you with a question and give you buttons to "
				+ "press. Answer the questions correctly to move. Getting to the red circle in "
				+ "the bottom right corner is the objective. \n\nGood luck!");
    	myCurrentPlayer.setName("Player");
    	myCurrentPlayer.setRow(0);
    	myCurrentPlayer.setColumn(0);
    	setPlayerSQL("Player", 0, 0);
    	removePlayer(myGrid, myCurrentPlayer);
		myGrid.add(myCurrentPlayer.getShape(), myCurrentPlayer.getColumn(), myCurrentPlayer.getRow());
		
		SQLiteDataSource ds = null;
		try {
            ds = new SQLiteDataSource();
            ds.setUrl("jdbc:sqlite:doors.db");
        } catch ( Exception e1 ) {
            e1.printStackTrace();
            System.exit(0);
        }
		int increment = 1;
		String selectQuery = "SELECT * FROM doors";
		for (int i = 0; i < 9; i = i + 2) {
		    for (int j = 0; j < 9; j = j + 2) {
		    	if ((i % 2 == 0) && (j % 2 == 0)) {
		    		myCurrentRoom = myMaze.getRoom(i, j);
		    		try ( Connection conn = ds.getConnection();
			                Statement stmt = conn.createStatement(); ) {
		    			ResultSet rs = stmt.executeQuery(selectQuery);
		    			boolean rightDoorAssigned = false;
		    			boolean bottomDoorAssigned = false;
		    			while (rs.next()) {
		    				
		    				String iD = rs.getString( "ID" );
			    			
				    		Door rightDoor = myCurrentRoom.getRightDoor();
				    		Door bottomDoor = myCurrentRoom.getBottomDoor();
				            
				    		if (Integer.parseInt(iD) % 2 == 1) {
				    			
				    			if (iD.equals(String.valueOf(increment))) {
				    				
				    				rightDoor.setPermLocked(false);
				    				if (!rightDoorAssigned) {
				    					increment++;
				    				}
				    				rightDoorAssigned = true;
				    				
				    			}
				    		}
				    		 
				    		if (Integer.parseInt(iD) % 2 == 0) {
				    			
				    			if (iD.equals(String.valueOf(increment))) {
				    				
				    				bottomDoor.setPermLocked(false);
				    				if (!bottomDoorAssigned) {
				    					increment++;
				    				}
				    				bottomDoorAssigned = true;
				    			}
				    		}
				    		
				    		if (rightDoorAssigned && bottomDoorAssigned) {
				    			break;
				    		}
		    			}
		    			
		    		} catch ( SQLException e1 ) {
				        e1.printStackTrace();
		                System.exit( 0 );
			        }
		    	}
		    }
		}
		setDoorSQLToZeros();
	}
	
	void setDoorSQLToZeros() {
		
		SQLiteDataSource ds = null;
		try {
            ds = new SQLiteDataSource();
            ds.setUrl("jdbc:sqlite:doors.db");
        } catch ( Exception e1 ) {
            e1.printStackTrace();
            System.exit(0);
        }
		
		try ( Connection conn = ds.getConnection();
	              Statement stmt = conn.createStatement(); ) {
	            
	            String deleteQuery = "delete from doors";
	            stmt.executeUpdate(deleteQuery);
	            
	        } catch ( SQLException e1 ) {
	            e1.printStackTrace();
	            System.exit( 0 );
	        }
			
			int increment = 1;
		    try ( Connection conn = ds.getConnection();
	            Statement stmt = conn.createStatement(); ) {
		        for (int i = 0; i < 9; i = i + 2) {
				    for (int j = 0; j < 9; j = j + 2) {
				    	if ((i % 2 == 0) && (j % 2 == 0)) {
				    		
				    		int rightDoorLocked = 0;
			
				    		String query1 = "INSERT INTO doors ( ID, ISLOCKED ) VALUES ('" + increment + "', " + rightDoorLocked + ")";
				    		stmt.executeUpdate(query1);
				    		increment++;
				    		
				    		int bottomDoorLocked = 0;
				    		
				    		String query2 = "INSERT INTO doors ( ID, ISLOCKED ) VALUES ('" + increment + "', " + bottomDoorLocked + ")";
				    	    stmt.executeUpdate(query2);
				    	    increment++;
				    	}
				    }
			    }
	        } catch ( SQLException e1 ) {
		        e1.printStackTrace();
	            System.exit( 0 );
	        }
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}