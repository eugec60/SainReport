package view;

import eventListnersAndObjects.CourseEventListener;
import eventListnersAndObjects.CourseEventObjs;
import eventListnersAndObjects.FacultyEventObjs;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CoursePane {
	private GridPane coursePane;
	private TextField cTitleT, courseNumT, crnT, classAdressT, creditsT;
	private Button addB, searchB, updateB, displayB;
	private TableView courseDisplayTable;
	private CourseEventListener courseEventListener;

	public CoursePane() {

		coursePane = new GridPane();
		coursePane.setHgap(10);
		coursePane.setVgap(10);
		coursePane.setPadding(new Insets(25, 25, 50, 75));

		Label cTitleL = new Label("Course Title");
		cTitleT = new TextField();
		coursePane.add(cTitleL, 0, 2);
		coursePane.add(cTitleT, 0, 3);

		Label courseNumL = new Label("Course Number");
		courseNumT = new TextField();
		coursePane.add(courseNumL, 1, 2);
		coursePane.add(courseNumT, 1, 3);

		Label crnL = new Label("Crn");
		crnT = new TextField();
		coursePane.add(crnL, 2, 2);
		coursePane.add(crnT, 2, 3);

		Label classAdressL = new Label("Class Adress");
		classAdressT = new TextField();
		coursePane.add(classAdressL, 0, 5);
		coursePane.add(classAdressT, 0, 6);

		Label creditsL = new Label("Credits");
		creditsT = new TextField();
		coursePane.add(creditsL, 1, 5);
		coursePane.add(creditsT, 1, 6);

		// ADD BUTTON
		addB = new Button("Add");
		coursePane.add(addB, 0, 10);

		
		addB.setOnAction(e -> {
			CourseEventObjs ev = new CourseEventObjs(this, cTitleT.getText(),
					courseNumT.getText(), crnT.getText(), classAdressT.getText(),
					Integer.parseInt(creditsT.getText()));
			if (courseEventListener != null) {
				courseEventListener.ButtonClicked(ev);
			}
			;
		});

		// SEARCH BUTTON
		searchB = new Button("Search");
		coursePane.add(searchB, 1, 10);

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
		coursePane.add(updateB, 2, 10);

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
		coursePane.add(displayB, 3, 10);

		displayB.setOnAction(e -> {
			Stage secondaryStage = new Stage();
			GridPane displayPane = new GridPane();
			displayPane.setAlignment(Pos.CENTER);
			Label l1 = new Label("Courses:");

			
			displayPane.add(l1, 0, 0);
			displayPane.add(courseDisplayTable, 0, 1);

			secondaryStage.setScene(new Scene(displayPane, 550, 300));
			secondaryStage.showAndWait();

		});

	}

	public GridPane getCoursePane() {
		return coursePane;
	}
	
	

	public void setCourseDisplayTable(TableView courseDisplayTable) {
		this.courseDisplayTable = courseDisplayTable;
	}

	public void setCourseEventListener(CourseEventListener courseEventListener) {
		this.courseEventListener = courseEventListener;
	}
	
	
}