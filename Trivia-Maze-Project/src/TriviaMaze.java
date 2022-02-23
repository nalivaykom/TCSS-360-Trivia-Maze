import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.css.CssMetaData;
import javafx.css.Styleable;
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
import javafx.scene.text.TextAlignment;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import java.util.*;

public class TriviaMaze extends Application {

	Maze maze;
	GridPane grid;
	Player currentPlayer;
	Question_Answer currentQA;
	String currentQType;
	boolean enterUnanswered;
	boolean multUnanswered;
	boolean trueFalseUnanswered;
	Door currentDoor;
	Button aButton;
	Button bButton;
	Button cButton;
	Button dButton;
	Button enterButton;
	Button upButton;
	Button trueButton;
	Button falseButton;
	Button leftButton;
	Button rightButton;
	Button downButton;
	TextArea textArea;
	TextField textField;
	String userInput;
	String multipleChoiceSelection;
	Room currentRoom;
	Room adjacentRoom;
	String playerDirection;
	VBox fieldAndEnterBox;
	HBox abcdButtonsBox;
	HBox trueFalseButtonsBox;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		maze = new Maze();
		
		primaryStage.setTitle("RuneScape Trivia Maze");
		
		textArea = new TextArea();
		textArea.setMinSize(300, 250);
		textArea.setMaxSize(300, 250);
		textArea.setEditable(false);
		textArea.setWrapText(true);
		textArea.setText("Welcome to the RuneScape Trivia Maze!");
		
		textField = new TextField();
		textField.setMinSize(300, 30);
		textField.setMaxSize(300, 30);
		
		aButton = new Button();
		aButton.setText("A");
		aButton.setMinSize(50, 25);
		aButton.setMaxSize(50, 25);
		aButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				multipleChoiceSelection = "a";	
				if (currentQType.equals("abcd") && (multUnanswered == true)) {
					if (gotItRightWithString(currentQA, multipleChoiceSelection)) {
						movePlayer();
					} else {
						currentDoor.setPermLocked();
						textArea.clear();
		    			textArea.appendText("Wrong! This door is now locked");
					}
					abcdButtonsBox.setVisible(false);
				}
			}	
		});
		
		bButton = new Button();
		bButton.setText("B");
		bButton.setMinSize(50, 25);
		bButton.setMaxSize(50, 25);
		bButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				multipleChoiceSelection = "b";
				if (currentQType.equals("abcd") && (multUnanswered == true)) {
					if (gotItRightWithString(currentQA, multipleChoiceSelection)) {
						movePlayer();
					} else {
						currentDoor.setPermLocked();
						textArea.clear();
		    			textArea.appendText("Wrong! This door is now locked");
					}
					abcdButtonsBox.setVisible(false);
				}
			}
			
		});
		
		cButton = new Button();
		cButton.setText("C");
		cButton.setMinSize(50, 25);
		cButton.setMaxSize(50, 25);
		cButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				multipleChoiceSelection = "c";
				if (currentQType.equals("abcd") && (multUnanswered == true)) {
					if (gotItRightWithString(currentQA, multipleChoiceSelection)) {
						movePlayer();
					} else {
						currentDoor.setPermLocked();
						textArea.clear();
		    			textArea.appendText("Wrong! This door is now locked");
					}
					abcdButtonsBox.setVisible(false);
				}
			}
			
		});
		
		dButton = new Button();
		dButton.setText("D");
		dButton.setMinSize(50, 25);
		dButton.setMaxSize(50, 25);
		dButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				multipleChoiceSelection = "d";
				if (currentQType.equals("abcd") && (multUnanswered == true)) {
					if (gotItRightWithString(currentQA, multipleChoiceSelection)) {
						movePlayer();
					} else {
						currentDoor.setPermLocked();
						textArea.clear();
		    			textArea.appendText("Wrong! This door is now locked");
					}
					abcdButtonsBox.setVisible(false);
				}
			}
			
		});
		
		userInput = new String();
		enterButton = new Button();
		enterButton.setText("Enter");
		enterButton.setMinSize(100, 25);
		enterButton.setMaxSize(100, 25);
		enterButton.setOnAction(new EventHandler<ActionEvent>() {
		
		    @Override public void handle(ActionEvent e) {
		    	userInput = textField.getText();
		    	if (currentQType.equals("Short Answer") && (enterUnanswered == true)) { 
		    		if (gotItRight(currentQA)) {
		    			textField.clear();
		    			movePlayer();
		    		} else {
		    			currentDoor.setPermLocked();
		    			textField.clear();
		    			textArea.clear();
		    			textArea.appendText("Wrong! This door is now locked");
		    		}
		    		fieldAndEnterBox.setVisible(false);
		    	} 
		    }
		});
		
		fieldAndEnterBox = new VBox(10);
		fieldAndEnterBox.setAlignment(Pos.CENTER);
		fieldAndEnterBox.getChildren().addAll(textField, enterButton);
        fieldAndEnterBox.setVisible(false);
		
		abcdButtonsBox = new HBox(33);
		abcdButtonsBox.getChildren().addAll(aButton, bButton, cButton, dButton);
		abcdButtonsBox.setVisible(false);
		
		trueButton = new Button();
		trueButton.setText("True");
		trueButton.setMinSize(100, 25);
		trueButton.setMaxSize(100, 25);
		trueButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override public void handle(ActionEvent e) {
		    	if (currentQType.equals("T/F") && (trueFalseUnanswered == true)) { 
		    		if (gotItRightWithString(currentQA, "true")) {
		    			textField.clear();
		    			movePlayer();
		    		} else {
		    			currentDoor.setPermLocked();
		    			textField.clear();
		    			textArea.clear();
		    			textArea.appendText("Wrong! This door is now locked");
		    		}
		    		trueFalseButtonsBox.setVisible(false);
		    	} 
		    }
		});
		
		falseButton = new Button();
		falseButton.setText("False");
		falseButton.setMinSize(100, 25);
		falseButton.setMaxSize(100, 25);
		falseButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override public void handle(ActionEvent e) {
		    	if (currentQType.equals("T/F") && (trueFalseUnanswered == true)) { 
		    		if (gotItRightWithString(currentQA, "false")) {
		    			textField.clear();
		    			movePlayer();
		    		} else {
		    			currentDoor.setPermLocked();
		    			textField.clear();
		    			textArea.clear();
		    			textArea.appendText("Wrong! This door is now locked");
		    		}
		    		trueFalseButtonsBox.setVisible(false);
		    	} 
		    }
		});
		
		trueFalseButtonsBox = new HBox(25);
		trueFalseButtonsBox.getChildren().addAll(trueButton, falseButton);
		trueFalseButtonsBox.setAlignment(Pos.CENTER);
		trueFalseButtonsBox.setVisible(false);
		
		VBox leftVBox = new VBox(40);
		leftVBox.setAlignment(Pos.CENTER);
		leftVBox.getChildren().addAll(textArea, fieldAndEnterBox, abcdButtonsBox, trueFalseButtonsBox);
		
		
		//going to need to ask the player for their name here.
		currentPlayer = new Player("Player", 0, 0);
		
		grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
	    grid.setHgap(4);
		//grid.setVgap(3);
		//grid.setMinSize(360, 420);
		grid.setMinSize(360, 420);

		
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if ((i % 2 == 0) && (j % 2 == 0)) {
					Rectangle rect = new Rectangle(60, 60, 60, 60);
					rect.setFill(Color.WHITE);
					rect.setStroke(Color.BLACK);
					grid.add(rect, i, j);
				} else if ((j % 2 == 1) && (i % 2 == 0)) {
					grid.add(maze.getRoom(i, j - 1).getRightDoor().getShape(), j, i);
				} else if ((i % 2 == 1) && (j % 2 == 0)) {
					grid.add(maze.getRoom(i - 1, j).getBottomDoor().getShape(), j, i);
					GridPane.setHalignment(maze.getRoom(i-1, j).getBottomDoor().getShape(), HPos.CENTER);
				}
				
			}
		}
		
		grid.add(currentPlayer.getShape(), 0, 0);
		
		final Circle endCircle = new Circle(0,0,25);
		final Text endText = new Text("END");
		final  StackPane endObject = new StackPane();
		endCircle.setFill(Color.RED);
		endObject.getChildren().addAll(endCircle, endText);
		endObject.setVisible(true);
		grid.add(endObject, 8, 8);
		
		upButton = new Button();
		upButton.setText("Up");
		upButton.setMinSize(52, 25);
		upButton.setMaxSize(52, 25);
		upButton.setOnAction(new EventHandler<ActionEvent>() {
			
		    @Override public void handle(ActionEvent e) {
		    	
		    	if (currentPlayer.getRow() > 0) {
		    		Room upperRoom = maze.getRoom(currentPlayer.getRow() - 2, currentPlayer.getColumn());
		    		currentDoor = upperRoom.getBottomDoor();
		    		currentQA = currentDoor.getQuestion_Answer();
		    		if (!currentDoor.getPermLockStat()) {
		    			askQuestion(currentQA);
		    			playerDirection = "up";
		    		} else {
		    			textArea.clear();
		    			textArea.appendText("This door is permanently locked");
		    		}
		    	} else {
		    		textArea.clear();
		    		textArea.appendText("Cannot go up");
		    	}
		    	
		    }
		});
		
		leftButton = new Button();
		leftButton.setText("Left");
		leftButton.setMinSize(50, 25);
		leftButton.setMaxSize(50, 25);
		leftButton.setOnAction(new EventHandler<ActionEvent>() {
			
		    @Override public void handle(ActionEvent e) {
		    	if (currentPlayer.getColumn() > 0) {
		    		Room leftRoom = maze.getRoom(currentPlayer.getRow(), currentPlayer.getColumn() - 2);
		    		currentDoor = leftRoom.getRightDoor();
		    		currentQA = currentDoor.getQuestion_Answer();
		    		if (!currentDoor.getPermLockStat()) {
		    			askQuestion(currentQA);
		    			playerDirection = "left";
		    		} else {
		    			textArea.clear();
		    			textArea.appendText("This door is permanently locked");
		    		}
		    	} else {
		    		textArea.clear();
		    		textArea.appendText("Cannot go left");
		    	}
		    }
		});
		
		rightButton = new Button();
		rightButton.setText("Right");
		rightButton.setMinSize(50, 25);
		rightButton.setMaxSize(50, 25);
		rightButton.setOnAction(new EventHandler<ActionEvent>() {
			
		    @Override public void handle(ActionEvent e) {

		    	if (currentPlayer.getColumn() < 8) {
		    		Room thisRoom = maze.getRoom(currentPlayer.getRow(), currentPlayer.getColumn());
		    		currentDoor = thisRoom.getRightDoor();
		    		currentQA = currentDoor.getQuestion_Answer();
		    		if (!currentDoor.getPermLockStat()) {
		    			askQuestion(currentQA);
		    			playerDirection = "right";
		    		} else {
		    			textArea.clear();
		    			textArea.appendText("This door is permanently locked");
		    		}
		    	} else {
		    		textArea.clear();
		    		textArea.appendText("Cannot go right");
		    	}
		    }
		});
		
		downButton = new Button();
		downButton.setText("Down");
		downButton.setMinSize(52, 25);
		downButton.setMaxSize(52, 25);
		downButton.setOnAction(new EventHandler<ActionEvent>() {
			
		    @Override public void handle(ActionEvent e) {
		    	if (currentPlayer.getRow() < 8) {
		    		Room thisRoom = maze.getRoom(currentPlayer.getRow(), currentPlayer.getColumn());
		    		currentDoor = thisRoom.getBottomDoor();
		    		currentQA = currentDoor.getQuestion_Answer();
		    		if (!currentDoor.getPermLockStat()) {
		    			askQuestion(currentQA);
		    			playerDirection = "down";
		    		} else {
		    			textArea.clear();
		    			textArea.appendText("This door is permanently locked");
		    		}
		    	} else {
		    		textArea.clear();
		    		textArea.appendText("Cannot go down");
		    	}

		    }
		});
	
		VBox upDownButtonsBox = new VBox(25);
		upDownButtonsBox.setAlignment(Pos.CENTER);
		HBox allButtonsBox = new HBox();
		upDownButtonsBox.getChildren().addAll(upButton, downButton);
		allButtonsBox.getChildren().addAll(leftButton, upDownButtonsBox, rightButton);
		allButtonsBox.setMinSize(75, 150);
		allButtonsBox.setMaxSize(75, 150);
		allButtonsBox.setAlignment(Pos.CENTER);
		
		StackPane Pane = new StackPane();
		Pane.setStyle("-fx-background-color: DDDDDD");
		Pane.setMinSize(800, 650);
		Pane.setMaxSize(800, 650);
		
		VBox gridAndButtonsBox = new VBox();
		gridAndButtonsBox.getChildren().addAll(grid, allButtonsBox);
		gridAndButtonsBox.setAlignment(Pos.CENTER);
		
		HBox leftAndRightVBoxes = new HBox(25);
		leftAndRightVBoxes.setAlignment(Pos.CENTER);
		leftAndRightVBoxes.getChildren().addAll(leftVBox, gridAndButtonsBox);
		
		
		Pane.getChildren().add(leftAndRightVBoxes);
		StackPane.setAlignment(leftAndRightVBoxes, Pos.CENTER);
		
		Scene scene = new Scene(Pane, 800, 650);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	void removePlayer(GridPane grid, Player currentPlayer) {
		
	    for (final Node node : grid.getChildren()) {
		    if (node == currentPlayer.getShape()) {
			    grid.getChildren().removeAll(node);
			    break;
	        }          
	    }  
	}
	
	private void askQuestion(Question_Answer qA) {
		currentQType = qA.getQuestionType();
		if (currentQType.equals("Short Answer")) {
			multUnanswered = false;
			trueFalseUnanswered = false;
			
			fieldAndEnterBox.setVisible(true);
			abcdButtonsBox.setVisible(false);
			trueFalseButtonsBox.setVisible(false);
			
			enterUnanswered = true;
		} else if (currentQType.equals("abcd")) {
			enterUnanswered = false;
			trueFalseUnanswered = false;
			
			fieldAndEnterBox.setVisible(false);
			abcdButtonsBox.setVisible(true);
			trueFalseButtonsBox.setVisible(false);
			
			multUnanswered = true;
		} else if (currentQType.equals("T/F")) {
			enterUnanswered = false;
			multUnanswered = false;
			
			fieldAndEnterBox.setVisible(false);
			abcdButtonsBox.setVisible(false);
			trueFalseButtonsBox.setVisible(true);
			
			trueFalseUnanswered = true;
		}
		textArea.clear();
		textArea.appendText(qA.getQuestion());
	}
	
	private boolean gotItRight(Question_Answer qA) {
		boolean gotItRight = false;
		String rightAnswer = qA.getAnswer();
		String userAnswer = textField.getText();
		if (rightAnswer.equals(userAnswer)) {
			gotItRight = true;
		}
		return gotItRight;
	}
	
	private boolean gotItRightWithString(Question_Answer qA, String userAnswer) {
		boolean gotItRight = false;
		String rightAnswer = qA.getAnswer();
		if (rightAnswer.equals(userAnswer)) {
			gotItRight = true;
		}
		return gotItRight;
	}
	
	private void movePlayer() {
		switch (playerDirection) {
    	case "up":
   
    		removePlayer(grid, currentPlayer); 
    		currentPlayer.setRow(currentPlayer.getRow() - 2);
    		grid.add(currentPlayer.getShape(), currentPlayer.getColumn(), currentPlayer.getRow());
    		textArea.clear();
			textArea.appendText("Correct!");
    		multUnanswered = false;
    		enterUnanswered = false;
    		break;
    		
    	case "left":
    		
    		removePlayer(grid, currentPlayer); 
    		currentPlayer.setColumn(currentPlayer.getColumn() - 2);
    		grid.add(currentPlayer.getShape(), currentPlayer.getColumn(), currentPlayer.getRow());
    		textArea.clear();
			textArea.appendText("Correct!");
    		multUnanswered = false;
    		enterUnanswered = false;
    		break;
    		
    	case "right":
    		
    		removePlayer(grid, currentPlayer); 
    		currentPlayer.setColumn(currentPlayer.getColumn() + 2);
    		grid.add(currentPlayer.getShape(), currentPlayer.getColumn(), currentPlayer.getRow());
    		textArea.clear();
			textArea.appendText("Correct!");
    		multUnanswered = false;
    		enterUnanswered = false;
    		break;
    	
    	case "down":
    		
    		removePlayer(grid, currentPlayer); 
    		currentPlayer.setRow(currentPlayer.getRow() + 2);
    		grid.add(currentPlayer.getShape(), currentPlayer.getColumn(), currentPlayer.getRow());
    		textArea.clear();
			textArea.appendText("Correct!");
    		multUnanswered = false;
    		enterUnanswered = false;
    		break;
    	}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
