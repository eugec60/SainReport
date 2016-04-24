package controller;

import java.io.IOException;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainWindow {
	
	public MainWindow(Stage primaryStage) throws IOException, Exception {
		primaryStage.setTitle("Caio Eugenios Final");
		
		BorderPane root = new BorderPane();
		
		primaryStage.setScene(new Scene(root, 1300, 400));
		primaryStage.show();

	}

}