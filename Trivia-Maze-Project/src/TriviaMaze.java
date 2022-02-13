import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class TriviaMaze extends Application{

	Button upButton;
	Button leftButton;
	Button rightButton;
	Button downButton;
		
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		primaryStage.setTitle("RuneScape Trivia Maze");
		
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
		
		upButton = new Button();
		upButton.setText("Up");
		upButton.setMinSize(50, 25);
		upButton.setMaxSize(50, 25);
		
		leftButton = new Button();
		leftButton.setText("Left");
		leftButton.setMinSize(50, 25);
		leftButton.setMaxSize(50, 25);
		
		rightButton = new Button();
		rightButton.setText("Right");
		rightButton.setMinSize(50, 25);
		rightButton.setMaxSize(50, 25);
		
		downButton = new Button();
		downButton.setText("Down");
		downButton.setMinSize(50, 25);
		downButton.setMaxSize(50, 25);
		
		VBox upDownButtonsBox = new VBox(25);
		upDownButtonsBox.setAlignment(Pos.CENTER);
		HBox allButtonsBox = new HBox();
		upDownButtonsBox.getChildren().addAll(upButton, downButton);
		allButtonsBox.getChildren().addAll(leftButton, upDownButtonsBox, rightButton);
		allButtonsBox.setMinSize(75, 150);
		allButtonsBox.setMaxSize(75, 150);
		allButtonsBox.setAlignment(Pos.CENTER);
		
		StackPane layout = new StackPane();
		layout.setMinSize(325, 450);
		layout.setMaxSize(325, 450);
		
		VBox gridAndButtonsBox = new VBox(25);
		gridAndButtonsBox.getChildren().addAll(grid, allButtonsBox);
		gridAndButtonsBox.setAlignment(Pos.CENTER);
		
		
		layout.getChildren().add(gridAndButtonsBox);
		StackPane.setAlignment(gridAndButtonsBox, Pos.CENTER);
		//layout.getChildren().add(allButtonsBox);
		//layout.getChildren().add(grid);
		//StackPane.setAlignment(grid, Pos.CENTER);
		//StackPane.setAlignment(allButtonsBox, Pos.BOTTOM_CENTER);
		
		Scene scene = new Scene(layout, 325, 450);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}


}
