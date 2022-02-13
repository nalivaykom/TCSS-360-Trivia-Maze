import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TriviaMaze extends Application{

	Button upButton;
	Button leftButton;
	Button rightButton;
	Button downButton;
		
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		primaryStage.setTitle("RuneScape Trivia Maze");
		
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
		HBox allButtonsBox = new HBox();
		upDownButtonsBox.getChildren().addAll(upButton, downButton);
		allButtonsBox.getChildren().addAll(leftButton, upDownButtonsBox, rightButton);
		allButtonsBox.setMinSize(75, 150);
		allButtonsBox.setMaxSize(75, 150);
		allButtonsBox.setAlignment(Pos.CENTER);
		
		StackPane layout = new StackPane();
		layout.setMinSize(300, 500);
		layout.setMaxSize(300, 500);
		layout.getChildren().add(allButtonsBox);
//		layout.getChildren().add(upButton);
//		layout.getChildren().add(leftButton);
//		layout.getChildren().add(rightButton);
//		layout.getChildren().add(downButton);
		
		Scene scene = new Scene(layout, 300, 500);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}


}
