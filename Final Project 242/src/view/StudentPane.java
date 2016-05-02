package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import eventListnersAndObjects.StudentEventListener;
import eventListnersAndObjects.StudentEventObjs;

public class StudentPane {

	private TextField fnameT, lnameT, addressT, phoneT, idT, gpaT, majorT,
			creditsT;
	private GridPane studentPane;
	private Button addB, searchB, updateB, displayB;
	private StudentEventListener studentEventListener;
	private TableView studentDisplayTable;
	

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

		Label idL = new Label("Id");
		idT = new TextField();
		studentPane.add(idL, 0, 5);
		studentPane.add(idT, 0, 6);

		Label gpaL = new Label("Gpa");
		gpaT = new TextField("2");
		studentPane.add(gpaL, 1, 5);
		studentPane.add(gpaT, 1, 6);

		Label majorL = new Label("Major");
		majorT = new TextField();
		studentPane.add(majorL, 2, 5);
		studentPane.add(majorT, 2, 6);

		Label creditsL = new Label("Credits:");
		creditsT = new TextField("2");
		studentPane.add(creditsL, 3, 5);
		studentPane.add(creditsT, 3, 6);

		// ADD BUTTON
		addB = new Button("Add");
		studentPane.add(addB, 0, 10);

		addB.setOnAction(e -> {
			StudentEventObjs ev = new StudentEventObjs(this, fnameT.getText(),
					lnameT.getText(), addressT.getText(), phoneT.getText(),
					Integer.parseInt(idT.getText()), Double.parseDouble(gpaT.getText()),
					majorT.getText(), Integer.parseInt(creditsT.getText()));
			if (studentEventListener != null) {
				studentEventListener.buttonClicked(ev);
			}
			;
		});

		// SEARCH BUTTON
		searchB = new Button("Search");
		studentPane.add(searchB, 1, 10);

		searchB.setOnAction(e -> {
			Stage secondaryStage = new Stage();
			GridPane searchPane = new GridPane();
			searchPane.setAlignment(Pos.CENTER);
			Label l1 = new Label("Enter the Student ID");
			TextField idT = new TextField();
			searchPane.add(l1, 0, 0);
			searchPane.add(idT, 0, 1);
			Button b2 = new Button("Enter");
			searchPane.add(b2, 0, 2);

			b2.setOnAction(a -> {
				Stage searchDisplayStage = new Stage();
				secondaryStage.close();
				SainPane sainPane = new SainPane();

				searchDisplayStage.setScene(new Scene(sainPane.getSainGrid(),
						500, 300));
				searchDisplayStage.show();

			});

			secondaryStage.setScene(new Scene(searchPane, 200, 200));
			secondaryStage.showAndWait();

		});

		// UPDATE BUTTON
		updateB = new Button("Update");
		studentPane.add(updateB, 2, 10);

		updateB.setOnAction(e -> {
			Stage secondaryStage = new Stage();
			GridPane searchPane = new GridPane();
			searchPane.setAlignment(Pos.CENTER);
			Label l1 = new Label("Enter the Student ID");
			TextField idT = new TextField();
			searchPane.add(l1, 0, 0);
			searchPane.add(idT, 0, 1);
			Button b2 = new Button("Enter");
			searchPane.add(b2, 0, 2);
			b2.setOnAction(f -> {
				Stage searchDisplayStage = new Stage();
				secondaryStage.close();
				StudentPane sp = new StudentPane();
				sp.getStudentPane().getChildren()
						.removeAll(sp.getAddB(), sp.getSearchB());

				searchDisplayStage.setScene(new Scene(sp.getStudentPane(), 500,
						300));
				searchDisplayStage.show();

			});

			secondaryStage.setScene(new Scene(searchPane, 200, 200));
			secondaryStage.showAndWait();

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

	public GridPane getStudentPane() {
		return studentPane;
	}

	public Button getAddB() {
		return addB;
	}

	public Button getSearchB() {
		return searchB;
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

	public TextField getMajorT() {
		return majorT;
	}

	public TextField getCreditsT() {
		return creditsT;
	}
	
	

	

	public void setStudentDisplayTable(TableView studentDisplayTable) {
		this.studentDisplayTable = studentDisplayTable;
	}

	public void setStudentEventListener(StudentEventListener studentEventListener) {
		this.studentEventListener = studentEventListener;
	}

	

}