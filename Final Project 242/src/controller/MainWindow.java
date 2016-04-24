package controller;

import java.io.IOException;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import view.CoursePane;
import view.FacultyPane;
import view.MenuBars;
import view.StudentPane;
import view.TabsPane;
import view.TextbookPane;

public class MainWindow {
	
	
	TabsPane tabsPane = new TabsPane();
	
	MenuBars menu = new MenuBars();
	
	public MainWindow(Stage primaryStage) throws IOException, Exception {
		primaryStage.setTitle("Caio Eugenios Final");

		BorderPane root = new BorderPane();
		root.setTop(menu.getMenuBars());

		root.setCenter(tabsPane.getTabPanes());
		
		primaryStage.setScene(new Scene(root, 800, 400));
		primaryStage.show();

	}
	
	

}