

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class TriviaMaze extends Application{

	Button upButton;
	Button leftButton;
	Button rightButton;
	Button downButton;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		primaryStage.setTitle("RuneScape Trivia Maze");
		
		upButton = new Button();
		upButton.setText("Up");
		leftButton = new Button();
		leftButton.setText("Left");
		rightButton = new Button();
		rightButton.setText("Right");
		downButton = new Button();
		downButton.setText("Down");
		
		StackPane layout = new StackPane();
		layout.getChildren().add(upButton);
		layout.getChildren().add(leftButton);
		layout.getChildren().add(rightButton);
		layout.getChildren().add(downButton);
		
		Scene scene = new Scene(layout, 300, 500);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
