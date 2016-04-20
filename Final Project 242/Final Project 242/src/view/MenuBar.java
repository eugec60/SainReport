package view;

import javafx.collections.ObservableList;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;





public class MenuBar {
	
	MenuBar menuBar = new MenuBar();
	
	// MENU BAR
		public void menuBar() {
			

			// file menu
			Menu fileMenu = new Menu("File");
			MenuItem loadTextMenuItem = new MenuItem("Load From Text File");
			MenuItem readBinMenuItem = new MenuItem("Read From Binary File");
			MenuItem saveMenuItem = new MenuItem("Save To Binary");
			MenuItem exitMenuItem = new MenuItem("Exit");

			fileMenu.getItems().addAll(loadTextMenuItem, saveMenuItem,
					readBinMenuItem, new SeparatorMenuItem(), exitMenuItem);

			menuBar.getMenus().addAll(fileMenu);
			

				
		}

		public MenuBar getMenuBar() {
			return menuBar;
		}
		
		

	
	
	


}
