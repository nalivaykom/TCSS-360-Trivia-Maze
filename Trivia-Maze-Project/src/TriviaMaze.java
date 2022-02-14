import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.css.CssMetaData;
import javafx.css.Styleable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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

	Button aButton;
	Button bButton;
	Button cButton;
	Button dButton;
	Button enterButton;
	Button upButton;
	Button leftButton;
	Button rightButton;
	Button downButton;
		
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Maze maze = new Maze();
		
		primaryStage.setTitle("RuneScape Trivia Maze");
		
		TextArea textArea = new TextArea();
		textArea.setMinSize(300, 250);
		textArea.setMaxSize(300, 250);
		textArea.setEditable(false);
		
		TextField textField = new TextField();
		textField.setMinSize(300, 30);
		textField.setMaxSize(300, 30);
		
		aButton = new Button();
		aButton.setText("A");
		aButton.setMinSize(50, 25);
		aButton.setMaxSize(50, 25);
		
		bButton = new Button();
		bButton.setText("B");
		bButton.setMinSize(50, 25);
		bButton.setMaxSize(50, 25);
		
		cButton = new Button();
		cButton.setText("C");
		cButton.setMinSize(50, 25);
		cButton.setMaxSize(50, 25);
		
		dButton = new Button();
		dButton.setText("D");
		dButton.setMinSize(50, 25);
		dButton.setMaxSize(50, 25);
		
		enterButton = new Button();
		enterButton.setText("Enter");
		enterButton.setMinSize(100, 25);
		enterButton.setMaxSize(100, 25);
		
		VBox fieldAndEnterBox = new VBox(10);
		fieldAndEnterBox.setAlignment(Pos.CENTER);
		fieldAndEnterBox.getChildren().addAll(textField, enterButton);
		
		HBox abcdButtons = new HBox(33);
		abcdButtons.getChildren().addAll(aButton, bButton, cButton, dButton);
		
		VBox leftVBox = new VBox(40);
		leftVBox.setAlignment(Pos.CENTER);
		leftVBox.getChildren().addAll(textArea, fieldAndEnterBox, abcdButtons);
		
		//going to need to ask the player for their name here.
		Player currentPlayer = new Player("Artur", 0, 0);
		
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setMinSize(300, 300);
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				Rectangle rect = new Rectangle(60, 60, 60, 60);
				rect.setFill(Color.WHITE);
				rect.setStroke(Color.BLACK);
				grid.add(rect, i, j);
			}
		}
		
		grid.add(currentPlayer.getShape(), 0, 0);
		
		final Circle endCircle = new Circle(0,0,25);
		final Text endText = new Text("END");
		final  StackPane endObject = new StackPane();
		endCircle.setFill(Color.RED);
		endObject.getChildren().addAll(endCircle, endText);
		endObject.setVisible(true);
		grid.add(endObject, 4, 4);
		
		upButton = new Button();
		upButton.setText("Up");
		upButton.setMinSize(52, 25);
		upButton.setMaxSize(52, 25);
		upButton.setOnAction(new EventHandler<ActionEvent>() {
			
		    @Override public void handle(ActionEvent e) {
		    	if (currentPlayer.getRow() > 0) {
			    	removeFromPane(grid, currentPlayer); 
			    	currentPlayer.setRow(currentPlayer.getRow() - 1);
			    	grid.add(currentPlayer.getShape(), currentPlayer.getColumn(), currentPlayer.getRow());
			    	
		    	} else {
		    		System.out.println("Cannot go up");
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
			    	removeFromPane(grid, currentPlayer); 
			    	currentPlayer.setColumn(currentPlayer.getColumn() - 1);
			    	grid.add(currentPlayer.getShape(), currentPlayer.getColumn(), currentPlayer.getRow());
		    	} else {
		    		System.out.println("Cannot go left");
		    	}
		    }
		});
		
		rightButton = new Button();
		rightButton.setText("Right");
		rightButton.setMinSize(50, 25);
		rightButton.setMaxSize(50, 25);
		rightButton.setOnAction(new EventHandler<ActionEvent>() {
			
		    @Override public void handle(ActionEvent e) {

		    	if (currentPlayer.getColumn() < 4) {
			    	removeFromPane(grid, currentPlayer); 
			    	currentPlayer.setColumn(currentPlayer.getColumn() + 1);
			    	grid.add(currentPlayer.getShape(), currentPlayer.getColumn(), currentPlayer.getRow());
			    	
		    	} else {
		    		System.out.println("Cannot go right");
		    	}
		    }
		});
		
		downButton = new Button();
		downButton.setText("Down");
		downButton.setMinSize(52, 25);
		downButton.setMaxSize(52, 25);
		downButton.setOnAction(new EventHandler<ActionEvent>() {
			
		    @Override public void handle(ActionEvent e) {
		    	if (currentPlayer.getRow() < 4) {
			    	removeFromPane(grid, currentPlayer); 
			    	currentPlayer.setRow(currentPlayer.getRow() + 1);
			    	grid.add(currentPlayer.getShape(), currentPlayer.getColumn(), currentPlayer.getRow());
		    	} else {
		    		System.out.println("Cannot go down");
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
		Pane.setStyle("-fx-background-color: #666699");
		Pane.setMinSize(700, 500);
		Pane.setMaxSize(700, 500);
		
		VBox gridAndButtonsBox = new VBox();
		gridAndButtonsBox.getChildren().addAll(grid, allButtonsBox);
		gridAndButtonsBox.setAlignment(Pos.CENTER);
		
		HBox leftAndRightVBoxes = new HBox(25);
		leftAndRightVBoxes.setAlignment(Pos.CENTER);
		leftAndRightVBoxes.getChildren().addAll(leftVBox, gridAndButtonsBox);
		
		
		Pane.getChildren().add(leftAndRightVBoxes);
		StackPane.setAlignment(leftAndRightVBoxes, Pos.CENTER);
		
		Scene scene = new Scene(Pane, 700, 500);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	void removeFromPane(GridPane grid, Player currentPlayer) {
		
	    for (final Node node : grid.getChildren()) {
	        if (node == currentPlayer.getShape()) {
	            grid.getChildren().removeAll(node);
	            break;
	        }          
	    }  
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}


}
