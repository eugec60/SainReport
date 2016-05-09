package view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import eventListnersAndObjects.StudentEventListener;
import eventListnersAndObjects.StudentEventObjs;

/**
 * This class will build the View For a non EditTable Sain Pane. All
 * user(Admin,Student, Faculty Will be able to see it.
 * 
 * @author Caio
 *
 */
public class SainPane {
	Label nameL, majorL, idL;
	private ListView coursesTakingList;
	private ListView coursesTakenList;
	private ListView coursesNeededList;
	private GridPane sainGrid;
	private TextField idT;
	private StudentEventListener studentEventListener;

	/**
	 * Constructor that uses JavaFx to build A sain report that the user can
	 * see. User will search for student by id then a new Window will come up
	 * that will generate the students sain report.
	 */
	public SainPane() {

		coursesTakingList = new ListView<String>();
		coursesTakingList.setMaxSize(70, 120);
		coursesTakenList = new ListView<String>();
		coursesTakenList.setMaxSize(70, 120);
		coursesNeededList = new ListView<String>();
		coursesNeededList.setMaxSize(70, 120);

		nameL = new Label();
		majorL = new Label();
		idL = new Label();

		sainGrid = new GridPane();
		sainGrid.setAlignment(Pos.CENTER);

		Label usernameL = new Label("Enter Students ID");
		idT = new TextField();
		Button searchB = new Button("Search");

		sainGrid.add(usernameL, 0, 0);
		sainGrid.add(idT, 0, 1);
		sainGrid.add(searchB, 1, 1);

		searchB.setOnAction(e -> {

			StudentEventObjs ev = new StudentEventObjs(this, Integer
					.parseInt(idT.getText()));
			if (studentEventListener != null) {
				studentEventListener.buttonClicked(ev);
			}

			HBox studentInfo = new HBox();
			Label lb1 = new Label("      Name: ");

			Label lb2 = new Label("      Major: ");

			Label lb3 = new Label("      ID: ");

			studentInfo.getChildren().addAll(lb1, nameL, lb2, majorL, lb3, idL);

			GridPane secondaryDisplay = new GridPane();
			secondaryDisplay.setAlignment(Pos.TOP_CENTER);
			secondaryDisplay.setHgap(10);
			secondaryDisplay.setVgap(10);
			Stage secondaryStage = new Stage();

			Label cTakingL = new Label("Course Taking");
			secondaryDisplay.add(cTakingL, 3, 0);
			secondaryDisplay.add(coursesTakingList, 3, 1);

			Label cTakenL = new Label("Course Taken");
			secondaryDisplay.add(cTakenL, 1, 0);
			secondaryDisplay.add(coursesTakenList, 1, 1);

			Label cNeededL = new Label("Course Needed");
			secondaryDisplay.add(cNeededL, 5, 0);
			secondaryDisplay.add(coursesNeededList, 5, 1);

			BorderPane root = new BorderPane();
			root.setTop(studentInfo);
			root.setCenter(secondaryDisplay);

			secondaryStage.setScene(new Scene(root, 450, 300));
			secondaryStage.show();

		});

	}

	/**
	 * 
	 * @return Will return Built Sain Grid
	 */
	public GridPane getSainGrid() {
		return sainGrid;
	}

	public void setStudentEventListener(
			StudentEventListener studentEventListener) {
		this.studentEventListener = studentEventListener;
	}

	public ListView getCoursesTakingList() {
		return coursesTakingList;
	}

	public ListView getCoursesTakenList() {
		return coursesTakenList;
	}

	public ListView getCoursesNeededList() {
		return coursesNeededList;
	}

	/**
	 * Will return Label that can be set to student first name;
	 * @return Label that can be set to student first name;
	 */
	public Label getNameL() {
		return nameL;
	}

	/**
	 * Will return Label that can be set to student Major
	 * @return Label that can be set to student Major
	 */
	public Label getMajorL() {
		return majorL;
	}

	/**
	 * Will return Label that can be set to student ID
	 * @return Label that can be set to student ID
	 */
	public Label getIdL() {
		return idL;
	}

}
