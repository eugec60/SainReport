package view;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import eventListnersAndObjects.LoginEventListener;
import eventListnersAndObjects.LoginEventObj;

/**
 * Builds menu Bar that allows for Saving the program.
 * 
 * @author Caio Eugenio
 * @version 1.0
 */
public class MenuBars {

	private MenuBar menuBars;;
	private LoginEventListener loginEventListener;

	// MENU BAR
	/**
	 * Builds menu bar and add an event handler on the save Menu Items
	 */
	public MenuBars() {

		menuBars = new MenuBar();

		Menu fileMenu = new Menu("File");
		MenuItem saveMenuItem = new MenuItem("Save To Binary");

		saveMenuItem.setOnAction(e -> {
			LoginEventObj ev = new LoginEventObj(this, "a", "a");
			if (loginEventListener != null) {
				loginEventListener.ButtonClicked(ev);
			}

		});

		fileMenu.getItems().addAll(saveMenuItem, new SeparatorMenuItem());

		menuBars.getMenus().addAll(fileMenu);

	}

	/**
	 * 
	 * @return Menu bar that is constructed
	 */
	public MenuBar getMenuBars() {
		return menuBars;
	}

	public void setLoginEventListener(LoginEventListener loginEventListener) {
		this.loginEventListener = loginEventListener;
	}

}
