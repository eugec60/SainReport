package view;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class FacultyPane {
	
	private TextField fnameT, lnameT, addressT, phoneT, oAddressT,titleT,departmentT,payScaleT;
	
	public GridPane buildFacultyPane(){
		
		
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

		Label oAddressL = new Label("Office Adress");
		oAddressT = new TextField("2");
		grid.add(oAddressL,0,5);
		grid.add(oAddressT,0,6);

		Label titleL = new Label("Title");
		titleT = new TextField();
		grid.add(titleL,1,5);
		grid.add(titleT,1,6);
		
		Label departmentL = new Label("Department");
		departmentT = new TextField();
		grid.add(departmentL,2,5);
		grid.add(departmentT,2,6);
		
		Label payScaleL = new Label("Pay Scale");
		payScaleT = new TextField("2");
		grid.add(payScaleL,3,5);
		grid.add(payScaleT,3,6);
		
		
		
		return grid;
	}
	
	

}
