package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class StudentPane {
	
	private TextField fnameT, lnameT, addressT, phoneT, gpaT, majorT,
	creditsT;
	
	public GridPane buildStudentPane(){
		
		
		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 50, 75));
		
		Label fnameL = new Label("First name");
		fnameT = new TextField();
		grid.add(fnameL,0,2);
		grid.add(fnameT,0,3);

		Label lnameL = new Label("Last Name");
		lnameT = new TextField();
		grid.add(lnameL,1,2);
		grid.add(lnameT,1,3);
		

		Label addressL = new Label("Adress");
		addressT = new TextField();
		grid.add(addressL,2,2);
		grid.add(addressT,2,3);

		Label phoneL = new Label("Phone");
		phoneT = new TextField();
		grid.add(phoneL,3,2);
		grid.add(phoneT,3,3);

		Label gpaL = new Label("Gpa");
		gpaT = new TextField("2");
		grid.add(gpaL,0,5);
		grid.add(gpaT,0,6);

		Label majorL = new Label("Major");
		majorT = new TextField();
		grid.add(majorL,1,5);
		grid.add(majorT,1,6);
		
		Label creditsL = new Label("Credits:");
		creditsT = new TextField("2");
		grid.add(creditsL,2,5);
		grid.add(creditsT,2,6);
		
		
		
		return grid;
	}
	

}