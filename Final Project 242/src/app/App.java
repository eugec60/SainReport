package app;

import controller.MainWindow;
import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {

	public static void main(String[] args) {
		launch();

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		new MainWindow(primaryStage);
		
	}

}
