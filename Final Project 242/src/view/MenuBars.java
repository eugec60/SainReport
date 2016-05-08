package view;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import eventListnersAndObjects.LoginEventListener;
import eventListnersAndObjects.LoginEventObj;

public class MenuBars {

	private MenuBar menuBars;;
	private LoginEventListener loginEventListener;

	// MENU BAR
	public  MenuBars() {
		
		menuBars = new MenuBar();

		Menu fileMenu = new Menu("File");
	//	MenuItem readBinMenuItem = new MenuItem("Read From Binary File");
		MenuItem saveMenuItem = new MenuItem("Save To Binary");
		MenuItem exitMenuItem = new MenuItem("Exit");
		
		saveMenuItem.setOnAction(e-> {
			LoginEventObj ev = new LoginEventObj(this,"a","a");
			if (loginEventListener != null) {
				loginEventListener.ButtonClicked(ev);
			}
			
		});
		
		
			

		fileMenu.getItems().addAll( saveMenuItem,
				 new SeparatorMenuItem(), exitMenuItem);

		menuBars.getMenus().addAll(fileMenu);

	}

	public MenuBar getMenuBars() {
		return menuBars;
	}

	public void setLoginEventListener(LoginEventListener loginEventListener) {
		this.loginEventListener = loginEventListener;
	}
	
	

}
