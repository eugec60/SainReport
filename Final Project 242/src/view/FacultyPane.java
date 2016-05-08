package view;

import model.Faculty;
import eventListnersAndObjects.FacultyEventListener;
import eventListnersAndObjects.FacultyEventObjs;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FacultyPane {

	private TextField fnameT, lnameT, addressT, phoneT,usernameT,passwordT, oAddressT, titleT,
			departmentT, payScaleT;
	private GridPane facultyPane;
	private Button addB, updateB, displayB;
	private TableView facultyDisplayTable;
	private FacultyEventListener facultyEventListener;

	public FacultyPane() {

		facultyPane = new GridPane();
		facultyPane.setHgap(10);
		facultyPane.setVgap(10);
		facultyPane.setPadding(new Insets(25, 25, 50, 75));

		Label fnameL = new Label("First name");
		fnameT = new TextField();
		facultyPane.add(fnameL, 0, 2);
		facultyPane.add(fnameT, 0, 3);

		Label lnameL = new Label("Last Name");
		lnameT = new TextField();
		facultyPane.add(lnameL, 1, 2);
		facultyPane.add(lnameT, 1, 3);

		Label addressL = new Label("Adress");
		addressT = new TextField();
		facultyPane.add(addressL, 2, 2);
		facultyPane.add(addressT, 2, 3);

		Label phoneL = new Label("Phone");
		phoneT = new TextField();
		facultyPane.add(phoneL, 3, 2);
		facultyPane.add(phoneT, 3, 3);
		
		Label usernameL = new Label("Username");
		usernameT = new TextField();
		facultyPane.add(usernameL, 0, 5);
		facultyPane.add(usernameT, 0, 6);
		
		Label passwordL = new Label("Password");
		passwordT = new TextField();
		facultyPane.add(passwordL, 1, 5);
		facultyPane.add(passwordT, 1, 6);
		
		

		Label oAddressL = new Label("Office Adress");
		oAddressT = new TextField("2");
		facultyPane.add(oAddressL, 2, 5);
		facultyPane.add(oAddressT, 2, 6);

		Label titleL = new Label("Title");
		titleT = new TextField();
		facultyPane.add(titleL, 3, 5);
		facultyPane.add(titleT, 3, 6);

		Label departmentL = new Label("Department");
		departmentT = new TextField();
		facultyPane.add(departmentL, 0, 8);
		facultyPane.add(departmentT, 0, 9);

		Label payScaleL = new Label("Pay Scale");
		payScaleT = new TextField("2");
		facultyPane.add(payScaleL, 1, 8);
		facultyPane.add(payScaleT, 1, 9);

		// ADD BUTTON
		addB = new Button("Add");
		facultyPane.add(addB, 0, 12);

		addB.setOnAction(e -> {
			FacultyEventObjs ev = new FacultyEventObjs(this, fnameT.getText(),
					lnameT.getText(), phoneT.getText(), addressT.getText(),
					usernameT.getText(),passwordT.getText(), oAddressT.getText(),
					titleT.getText(), departmentT.getText(), payScaleT
							.getText());
			if (facultyEventListener != null) {
				facultyEventListener.ButtonClicked(ev);
			}
			;
		});

		// UPDATE BUTTON
		updateB = new Button("Update");
		facultyPane.add(updateB, 2, 12);

		updateB.setOnAction(e -> {
			Stage secondaryStage = new Stage();
			GridPane searchPane = new GridPane();
			searchPane.setAlignment(Pos.CENTER);
			Label l1 = new Label("Enter Faculty's ID");
			TextField idT = new TextField();
			searchPane.add(l1, 0, 0);
			searchPane.add(idT, 0, 1);
			Button b2 = new Button("Enter");
			searchPane.add(b2, 0, 2);
			b2.setOnAction(f -> {
				Stage searchDisplayStage = new Stage();
				secondaryStage.close();
				FacultyPane fp = new FacultyPane();
				fp.getFacultyPane().getChildren().removeAll(fp.getAddB());

				searchDisplayStage.setScene(new Scene(fp.getFacultyPane(), 500,
						300));
				searchDisplayStage.show();

			});

			secondaryStage.setScene(new Scene(searchPane, 200, 200));
			secondaryStage.showAndWait();

		});

		// Display BUTTON
		displayB = new Button("Display");
		facultyPane.add(displayB, 3, 12);

		displayB.setOnAction(e -> {
			Stage secondaryStage = new Stage();
			GridPane displayPane = new GridPane();
			displayPane.setAlignment(Pos.CENTER);
			Label l1 = new Label("Faculty:");
			displayPane.add(l1, 0, 0);
			

				
			
			displayPane.add(facultyDisplayTable, 0, 1);

			secondaryStage.setScene(new Scene(displayPane, 700, 300));
			secondaryStage.showAndWait();

		});

	}

	public GridPane getFacultyPane() {
		return facultyPane;
	}

	public Button getAddB() {
		return addB;
	}

	public Button getUpdateB() {
		return updateB;
	}

	public void setFacultyEventListener(FacultyEventListener facultyEventListener) {
		this.facultyEventListener = facultyEventListener;
	}

	public void setFacultyDisplayTable(TableView facultyDisplayTable) {
		this.facultyDisplayTable = facultyDisplayTable;
	}

	public TableView getFacultyDisplayTable() {
		return facultyDisplayTable;
	}
	
	
	
	
	
	
	
	

}
