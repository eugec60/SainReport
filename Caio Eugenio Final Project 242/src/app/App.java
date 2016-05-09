package app;

import javafx.application.Application;
import javafx.stage.Stage;
import view.MainWindow;
import controller.Controller;

/**
 * This is the Main for My Project. My final project will let you create
 * student, faculty, and course object. To login as administrator the Username
 * is "Admin" and the password is "Password".
 * 
 * @author Caio Eugenio
 * @version 1.0
 */
public class App extends Application {

	public static void main(String[] args) {
		launch();

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		MainWindow mainWindow = new MainWindow(primaryStage);
		Controller controller = new Controller(mainWindow);

	}

}
