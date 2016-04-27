package app;

import javafx.application.Application;
import javafx.stage.Stage;
import view.MainWindow;
import controller.StudentController;
import controller.TextbookController;

public class App extends Application {

	public static void main(String[] args) {
		launch();

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		MainWindow mainWindow = new MainWindow(primaryStage);
		TextbookController controller = new TextbookController(mainWindow);
		StudentController sController = new StudentController(mainWindow );
	}

}
