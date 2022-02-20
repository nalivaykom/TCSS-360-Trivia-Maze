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

public class TriviaMaze extends Application{

	Maze maze;
	Button aButton;
	Button bButton;
	Button cButton;
	Button dButton;
	Button enterButton;
	Button upButton;
	Button leftButton;
	Button rightButton;
	Button downButton;
	TextArea textArea;
	TextField textField;
	String userInput;
	String multipleChoiceSelection;
	Room currentRoom;
	Room adjacentRoom;
	
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
				multipleChoiceSelection = "A";	
			}	
		});
		
		bButton = new Button();
		bButton.setText("B");
		bButton.setMinSize(50, 25);
		bButton.setMaxSize(50, 25);
		bButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				multipleChoiceSelection = "B";
				
			}
			
		});
		
		cButton = new Button();
		cButton.setText("C");
		cButton.setMinSize(50, 25);
		cButton.setMaxSize(50, 25);
		cButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				multipleChoiceSelection = "C";
				
			}
			
		});
		
		dButton = new Button();
		dButton.setText("D");
		dButton.setMinSize(50, 25);
		dButton.setMaxSize(50, 25);
		dButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				multipleChoiceSelection = "D";
				
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
		    	
		    }
		    
		});
		
		VBox fieldAndEnterBox = new VBox(10);
		fieldAndEnterBox.setAlignment(Pos.CENTER);
		fieldAndEnterBox.getChildren().addAll(textField, enterButton);
		
		HBox abcdButtons = new HBox(33);
		abcdButtons.getChildren().addAll(aButton, bButton, cButton, dButton);
		
		VBox leftVBox = new VBox(40);
		leftVBox.setAlignment(Pos.CENTER);
		leftVBox.getChildren().addAll(textArea, fieldAndEnterBox, abcdButtons);
		
		//going to need to ask the player for their name here.
		Player currentPlayer = new Player("Player", 0, 0);
		
		GridPane grid = new GridPane();
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
					grid.add(maze.getRoom(i, j - 1).getBottomDoor().getShape(), i, j);
					GridPane.setHalignment(maze.getRoom(i, j - 1).getBottomDoor().getShape(), HPos.CENTER);
				} else if ((i % 2 == 1) && (j % 2 == 0)) {
					grid.add(maze.getRoom(i - 1, j).getRightDoor().getShape(), i, j);
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
		    		if (askQuestion()) {
				    	removePlayer(grid, currentPlayer); 
				    	currentPlayer.setRow(currentPlayer.getRow() - 2);
				    	grid.add(currentPlayer.getShape(), currentPlayer.getColumn(), currentPlayer.getRow());
		    		}
		    	} else {
		    		textArea.appendText("\nCannot go up");
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
			    	removePlayer(grid, currentPlayer); 
			    	currentPlayer.setColumn(currentPlayer.getColumn() - 2);
			    	grid.add(currentPlayer.getShape(), currentPlayer.getColumn(), currentPlayer.getRow());
		    	} else {
		    		textArea.appendText("\nCannot go left");
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
			    	removePlayer(grid, currentPlayer); 
			    	currentPlayer.setColumn(currentPlayer.getColumn() + 2);
			    	grid.add(currentPlayer.getShape(), currentPlayer.getColumn(), currentPlayer.getRow());
		    	} else {
		    		textArea.appendText("\nCannot go right");
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
			    	removePlayer(grid, currentPlayer); 
			    	currentPlayer.setRow(currentPlayer.getRow() + 2);
			    	grid.add(currentPlayer.getShape(), currentPlayer.getColumn(), currentPlayer.getRow());
		    	} else {
		    		textArea.appendText("\nCannot go down");
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
	
	boolean askQuestion() {
		boolean gotItRight = false;
		Question_Answer QA = new Question_Answer();
		textArea.clear();
		textArea.appendText(QA.getQuestion());
	    try {
			enterButton.wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	    
	    	
	    
	 
		textArea.appendText("\nWaited for enter button");
		
		return gotItRight;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
