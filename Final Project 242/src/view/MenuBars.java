package view;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;

public class MenuBars {

	private MenuBar menuBars;;

	// MENU BAR
	public  MenuBars() {
		
		menuBars = new MenuBar();

		Menu fileMenu = new Menu("File");
		MenuItem loadTextMenuItem = new MenuItem("Load From Text File");
		MenuItem readBinMenuItem = new MenuItem("Read From Binary File");
		MenuItem saveMenuItem = new MenuItem("Save To Binary");
		MenuItem exitMenuItem = new MenuItem("Exit");

		fileMenu.getItems().addAll(loadTextMenuItem, saveMenuItem,
				readBinMenuItem, new SeparatorMenuItem(), exitMenuItem);

		menuBars.getMenus().addAll(fileMenu);

	}

	public MenuBar getMenuBars() {
		return menuBars;
	}

}
