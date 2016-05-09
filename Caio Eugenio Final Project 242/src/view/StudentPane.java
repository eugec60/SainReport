package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import eventListnersAndObjects.StudentEventListener;
import eventListnersAndObjects.StudentEventObjs;

/**
 * This class will build the View For a Student Pane where the user can build
 * Student Object. Student info will then be sent to Ram. Where the controller
 * will make a student object. Display button will pop up a new window that
 * displays all Student in an ArrayList.
 * 
 * @author Caio
 *
 */
public class StudentPane {

	private TextField fnameT, lnameT, addressT, phoneT, usernameT, passwordT,
			gpaT, creditsT;
	private ComboBox<String> majorCombo;
	private GridPane studentPane;
	private TableView studentDisplayTable;
	private ObservableList majorIdOList;
	private Button addB, searchB, updateB, displayB;
	private StudentEventListener studentEventListener;

	/**
	 * Will build a GridPane with TextFields that will allow the user to put in
	 * info that can be used to create a student object. Display Button will
	 * also display studentArrayList in a new window with a TableView.
	 */
	public StudentPane() {

		studentPane = new GridPane();
		studentPane.setHgap(10);
		studentPane.setVgap(10);
		studentPane.setPadding(new Insets(25, 25, 50, 75));

		Label fnameL = new Label("First name");
		fnameT = new TextField();
		studentPane.add(fnameL, 0, 2);
		studentPane.add(fnameT, 0, 3);

		Label lnameL = new Label("Last Name");
		lnameT = new TextField();
		studentPane.add(lnameL, 1, 2);
		studentPane.add(lnameT, 1, 3);

		Label addressL = new Label("Adress");
		addressT = new TextField();
		studentPane.add(addressL, 2, 2);
		studentPane.add(addressT, 2, 3);

		Label phoneL = new Label("Phone");
		phoneT = new TextField();
		studentPane.add(phoneL, 3, 2);
		studentPane.add(phoneT, 3, 3);

		Label usernameL = new Label("Username");
		usernameT = new TextField();
		studentPane.add(usernameL, 0, 5);
		studentPane.add(usernameT, 0, 6);

		Label passwordL = new Label("Password");
		passwordT = new TextField();
		studentPane.add(passwordL, 1, 5);
		studentPane.add(passwordT, 1, 6);

		Label gpaL = new Label("Gpa");
		gpaT = new TextField("2");
		studentPane.add(gpaL, 2, 5);
		studentPane.add(gpaT, 2, 6);

		Label majorL = new Label("Major");
		majorCombo = new ComboBox<String>();
		studentPane.add(majorL, 3, 5);
		studentPane.add(majorCombo, 3, 6);

		Label creditsL = new Label("Credits:");
		creditsT = new TextField("2");
		studentPane.add(creditsL, 0, 8);
		studentPane.add(creditsT, 0, 9);

		// ADD BUTTON
		addB = new Button("Add");
		studentPane.add(addB, 0, 10);

		addB.setOnAction(e -> {
			StudentEventObjs ev = new StudentEventObjs(this, fnameT.getText(),
					lnameT.getText(), addressT.getText(), phoneT.getText(),
					usernameT.getText(), passwordT.getText(), Double
							.parseDouble(gpaT.getText()), (String) majorCombo
							.getSelectionModel().getSelectedItem(), Integer
							.parseInt(creditsT.getText()));
			if (studentEventListener != null) {
				studentEventListener.buttonClicked(ev);
			}
			;
		});

		// Display BUTTON
		displayB = new Button("Display");
		studentPane.add(displayB, 3, 10);

		displayB.setOnAction(e -> {
			Stage secondaryStage = new Stage();
			GridPane displayPane = new GridPane();
			displayPane.setAlignment(Pos.CENTER);
			Label l1 = new Label("Students:");

			displayPane.add(l1, 0, 0);
			displayPane.add(studentDisplayTable, 0, 1);

			secondaryStage.setScene(new Scene(displayPane, 700, 350));
			secondaryStage.showAndWait();

		});
	}

	/**
	 * Return a Student Pane
	 * 
	 * @return Built student Pane
	 */
	public GridPane getStudentPane() {
		return studentPane;
	}

	public Button getAddB() {
		return addB;
	}

	public TextField getFnameT() {
		return fnameT;
	}

	public TextField getLnameT() {
		return lnameT;
	}

	public TextField getAddressT() {
		return addressT;
	}

	public TextField getPhoneT() {
		return phoneT;
	}

	public TextField getGpaT() {
		return gpaT;
	}

	public ComboBox getMajorCombo() {
		return majorCombo;
	}

	public TextField getCreditsT() {
		return creditsT;
	}

	public void setStudentDisplayTable(TableView studentDisplayTable) {
		this.studentDisplayTable = studentDisplayTable;
	}

	public void setStudentEventListener(
			StudentEventListener studentEventListener) {
		this.studentEventListener = studentEventListener;
	}

}