package view;

import java.io.IOException;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * This will hold the mainWindow constructor which is a BorderPane that brings
 * all the other Panes together.
 * 
 * @author Caio Eugenio
 * @version 1.0
 *
 */
public class MainWindow {

	TabsPane tabsPane;
	MenuBars menu;

	/**
	 * MainWindow constructor will create a borderPane that ties up Menu bar and
	 * Tabs Pane together.
	 * 
	 * @param primaryStage
	 *            Stage that the mainWindow will show up one
	 * @throws IOException
	 *             Throw IO exception when saving and loading files.
	 * 
	 */
	public MainWindow(Stage primaryStage) throws IOException {
		tabsPane = new TabsPane();
		menu = new MenuBars();
		primaryStage.setTitle("Caio Eugenios Final");

		BorderPane root = new BorderPane();
		root.setTop(menu.getMenuBars());

		root.setCenter(tabsPane.getTabPanes());

		primaryStage.setScene(new Scene(root, 800, 400));
		primaryStage.show();

	}

	/**
	 * 
	 * @return Tab Pane Facade
	 */
	public TabsPane getTabsPane() {
		return tabsPane;
	}

	/**
	 * 
	 * @return Menu bar that was created.
	 */
	public MenuBars getMenu() {
		return menu;
	}

}