package controller;

import java.io.IOException;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import view.CoursePane;
import view.FacultyPane;
import view.StudentPane;
import view.TextbookPane;

public class MainWindow {
	
	StudentPane sPane = new StudentPane();
	FacultyPane fPane = new FacultyPane();
	CoursePane cPane = new CoursePane();
	TextbookPane tPane = new TextbookPane();
	
	public MainWindow(Stage primaryStage) throws IOException, Exception {
		primaryStage.setTitle("Caio Eugenios Final");
		
		BorderPane root = new BorderPane();
		root.setCenter(tPane.buildTextbookPane());
		
		primaryStage.setScene(new Scene(root, 800, 400));
		primaryStage.show();

	}
	
	

}