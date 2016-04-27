package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class WhatIfPane {
	
	GridPane whatIfPane;
	Button enterB;
	
	public WhatIfPane(){
		whatIfPane = new GridPane();
		whatIfPane.setHgap(10);
		whatIfPane.setVgap(10);
		whatIfPane.setPadding(new Insets(25, 25, 50, 75));
		whatIfPane.setAlignment(Pos.CENTER);
		
		Label l1 = new Label("What Major would you like to transfer to:");
		ComboBox majorC = new ComboBox();
		enterB = new Button("Enter");
		whatIfPane.add(l1,0,0);
		whatIfPane.add(majorC,0,1);
		whatIfPane.add(enterB,1,1);
		
	}

	public GridPane getWhatIfPane() {
		return whatIfPane;
	}

	public Button getEnterB() {
		return enterB;
	}
	
	

}
