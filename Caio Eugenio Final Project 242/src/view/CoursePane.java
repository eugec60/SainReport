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

/**
 * CoursePane class builds GridPane using JavaFX that will allow the user to add
 * Course Objects to to courseList array. The CoursePane will also be able to
 * display all the course that are Available in the courseList.
 * 
 * @author Caio Eugenio
 * @version 1.0
 *
 */
public class CoursePane {
	private GridPane coursePane;
	private TextField cTitleT;
	private TextField courseNumT;
	private TextField crnT;
	private TextField classAdressT;
	private TextField creditsT;
	private Button addB, searchB, updateB, displayB;
	private TableView courseDisplayTable;
	private CourseEventListener courseEventListener;

	/**
	 * Course Pane construcors build The gridPane and fills it with Textfields
	 * and button that allows it to add course to courseList and also display
	 * all the courses created.
	 */
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
					courseNumT.getText(), crnT.getText(), classAdressT
							.getText(), Integer.parseInt(creditsT.getText()));
			if (courseEventListener != null) {
				courseEventListener.ButtonClicked(ev);
			}
			;
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

	/**
	 * Returns coursePane that the constructor created
	 * @return CoursePane
	 */
	public GridPane getCoursePane() {
		return coursePane;
	}
	
	/**
	 * Set the courseDisplayTable view with a TableView/
	 * @param courseDisplayTable TableView display course information.
	 */
	public void setCourseDisplayTable(TableView courseDisplayTable) {
		this.courseDisplayTable = courseDisplayTable;
	}

	/**
	 * 
	 * @param courseEventListener courseEventListener interface
	 */
	public void setCourseEventListener(CourseEventListener courseEventListener) {
		this.courseEventListener = courseEventListener;
	}

}
