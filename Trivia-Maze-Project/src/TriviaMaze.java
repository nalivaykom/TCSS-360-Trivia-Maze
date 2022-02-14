import javafx.application.Application;
import javafx.collections.ObservableList;
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
//import sun.security.provider.DSAKeyPairGenerator.Current;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class TriviaMaze extends Application{

	Button upButton;
	Button leftButton;
	Button rightButton;
	Button downButton;
	
	
		
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		primaryStage.setTitle("RuneScape Trivia Maze");
		
		
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
				
				if (i == 0 && j == 0) { //add player to start position
					grid.add(Player.getShape(), i, j);
				}
				
				if(i == 4 && j == 4) { // add a circle with "end to indicate the goal
					final Circle endCircle = new Circle(0,0,25);
					final Text endText = new Text("END");
					final  StackPane endObject = new StackPane();
					endCircle.setFill(Color.RED);
					endObject.getChildren().addAll(endCircle, endText);
					endObject.setVisible(true);
					grid.add(endObject, i, j);
				}
			}
		}
		
		upButton = new Button();
		upButton.setText("Up");
		upButton.setMinSize(50, 25);
		upButton.setMaxSize(50, 25);
		//add event listener for click and modify player
		
		leftButton = new Button();
		leftButton.setText("Left");
		leftButton.setMinSize(50, 25);
		leftButton.setMaxSize(50, 25);
		leftButton.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	//handle the left click
		    }
		});
		//add event listener for click and modify player

		
		rightButton = new Button();
		rightButton.setText("Right");
		rightButton.setMinSize(50, 25);
		rightButton.setMaxSize(50, 25);
		rightButton.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	
		    	
		    	//removePlayer(currentPlayer.getRow(),currentPlayer.getColumn(),grid, currentPlayer);
		    	
		    	//(Player.getShape(), currentPlayer.getRow(), currentPlayer.getColumn());
		    	
		    	removeFromPane(currentPlayer.hashCode(), grid); 

		    	currentPlayer.setRow(currentPlayer.getRow() + 1);
		    	System.out.println("current row is : " + currentPlayer.getRow());
		    	//handle the left click
		    }
		});
		//add event listener for click and modify player

		
		downButton = new Button();
		downButton.setText("Down");
		downButton.setMinSize(50, 25);
		downButton.setMaxSize(50, 25);
		//size is off, does not show full "down" only "do.."
		//add event listener for click and modify player

		
		VBox upDownButtonsBox = new VBox(25);
		upDownButtonsBox.setAlignment(Pos.CENTER);
		HBox allButtonsBox = new HBox();
		upDownButtonsBox.getChildren().addAll(upButton, downButton);
		allButtonsBox.getChildren().addAll(leftButton, upDownButtonsBox, rightButton);
		allButtonsBox.setMinSize(75, 150);
		allButtonsBox.setMaxSize(75, 150);
		allButtonsBox.setAlignment(Pos.CENTER);
		
		StackPane layout = new StackPane();
		layout.setStyle("-fx-background-color: #666699");
		layout.setMinSize(325, 500);
		layout.setMaxSize(325, 500);
		
		VBox gridAndButtonsBox = new VBox(25);
		gridAndButtonsBox.getChildren().addAll(grid, allButtonsBox);
		gridAndButtonsBox.setAlignment(Pos.CENTER);
		
		
		layout.getChildren().add(gridAndButtonsBox);
		StackPane.setAlignment(gridAndButtonsBox, Pos.CENTER);
		
		Scene scene = new Scene(layout, 325, 500);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	
	/*
	 * this removes the rectangles, cant figure out how to remove the player
	public void removePlayer(final int row,final int column,GridPane grid, Player currentPlayer) {

		ObservableList<Node> childrens = grid.getChildren();
		for(Node node : childrens) {
		    if(GridPane.getRowIndex(node) == currentPlayer.getRow() && GridPane.getColumnIndex(node) == currentPlayer.getColumn()) {
		    	
		    	grid.getChildren().remove(node);
		    	
		        break;
		    }
		}
		
}
*/
	
	void removeFromPane(int hash, GridPane grid) {
	    for (final Node node : grid.getChildren()) {
	        if (node != null 
	              && (node).getId() != null
	              && node.hashCode() == (hash)) {
	            grid.getChildren().remove(node);
	        }
	    }
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}


}
