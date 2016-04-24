package view;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class FacultyPane {
	
	private TextField fnameT, lnameT, addressT, phoneT, oAddressT,titleT,departmentT,payScaleT;
	private GridPane facultyPane;
	
	public FacultyPane(){
		
		
		facultyPane = new GridPane();
		facultyPane.setHgap(10);
		facultyPane.setVgap(10);
		facultyPane.setPadding(new Insets(25, 25, 50, 75));
		
		Label fnameL = new Label("First name");
		fnameT = new TextField();
		facultyPane.add(fnameL,0,2);
		facultyPane.add(fnameT,0,3);

		Label lnameL = new Label("Last Name");
		lnameT = new TextField();
		facultyPane.add(lnameL,1,2);
		facultyPane.add(lnameT,1,3);
		

		Label addressL = new Label("Adress");
		addressT = new TextField();
		facultyPane.add(addressL,2,2);
		facultyPane.add(addressT,2,3);

		Label phoneL = new Label("Phone");
		phoneT = new TextField();
		facultyPane.add(phoneL,3,2);
		facultyPane.add(phoneT,3,3);

		Label oAddressL = new Label("Office Adress");
		oAddressT = new TextField("2");
		facultyPane.add(oAddressL,0,5);
		facultyPane.add(oAddressT,0,6);

		Label titleL = new Label("Title");
		titleT = new TextField();
		facultyPane.add(titleL,1,5);
		facultyPane.add(titleT,1,6);
		
		Label departmentL = new Label("Department");
		departmentT = new TextField();
		facultyPane.add(departmentL,2,5);
		facultyPane.add(departmentT,2,6);
		
		Label payScaleL = new Label("Pay Scale");
		payScaleT = new TextField("2");
		facultyPane.add(payScaleL,3,5);
		facultyPane.add(payScaleT,3,6);
		
		
		
		
	}

	public GridPane getFacultyPane() {
		return facultyPane;
	}
	
	
	
	

}
