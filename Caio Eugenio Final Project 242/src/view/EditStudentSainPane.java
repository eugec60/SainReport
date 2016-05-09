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
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import eventListnersAndObjects.CourseEventListener;
import eventListnersAndObjects.CourseEventObjs;
import eventListnersAndObjects.StudentEventListener;
import eventListnersAndObjects.StudentEventObjs;

/**
 * 
 * This class will build a sainPane that only administrator can access. It will
 * be able to search for a student by ID and then display his Sain Report. He
 * can then edit which course are in each arrayl list by clicking on the buttons
 * and moving them to others.
 * 
 * @author Caio Eugenio
 *
 */
public class EditStudentSainPane {
	Label nameL, majorL, idL;
	private ListView<String> coursesTakingList;
	private ListView<String> coursesTakenList;
	private ListView<String> coursesNeededList;
	private GridPane sainGrid;
	private TextField idT;
	private Button moveRight1, moveRight2, moveLeft1, moveLeft2;
	private StudentEventListener studentEventListener;

	/**
	 * Constructs using JavaFX all the necessary things for the admin to manipulate the Sain Report.
	 */
	public EditStudentSainPane() {
		coursesTakingList = new ListView();
		coursesTakingList.setMaxSize(70, 120);
		coursesTakenList = new ListView();
		coursesTakenList.setMaxSize(70, 120);
		coursesNeededList = new ListView();
		coursesNeededList.setMaxSize(70, 120);
		nameL = new Label();
		majorL = new Label();
		idL = new Label();
		moveRight1 = new Button("1>>>");
		moveRight2 = new Button("2>>> ");
		moveLeft1 = new Button("<<<1");
		moveLeft2 = new Button("<<<2");

		sainGrid = new GridPane();
		sainGrid.setAlignment(Pos.CENTER);
		// sainGrid.insetsProperty()In

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

			Label cTakenL = new Label("Course Taken");
			secondaryDisplay.add(cTakenL, 4, 3);
			secondaryDisplay.add(coursesTakenList, 4, 4);

			Label cTakingL = new Label("Course Taking");
			secondaryDisplay.add(cTakingL, 6, 3);
			secondaryDisplay.add(coursesTakingList, 6, 4);

			Label cNeededL = new Label("Course Needed");
			secondaryDisplay.add(cNeededL, 8, 3);
			secondaryDisplay.add(coursesNeededList, 8, 4);

			secondaryDisplay.add(moveRight1, 4, 5);
			secondaryDisplay.add(moveRight2, 6, 5);
			secondaryDisplay.add(moveLeft1, 6, 6);
			secondaryDisplay.add(moveLeft2, 8, 5);

			BorderPane root = new BorderPane();
			root.setTop(studentInfo);
			root.setCenter(secondaryDisplay);

			secondaryStage.setScene(new Scene(root, 450, 300));
			secondaryStage.show();

		});

	}

	/**
	 * 
	 * @return coursesTaking ListView
	 */
	public ListView getCoursesTakingList() {
		return coursesTakingList;
	}

	/**
	 * 
	 * @return course Taken List View
	 */
	public ListView getCoursesTakenList() {
		return coursesTakenList;
	}

	/**
	 * 
	 * @return courses Needed List View
	 */
	public ListView getCoursesNeededList() {
		return coursesNeededList;
	}

	public GridPane getSainGrid() {
		return sainGrid;
	}

	public TextField getIdT() {
		return idT;
	}

	public void setStudentEventListener(
			StudentEventListener studentEventListener) {
		this.studentEventListener = studentEventListener;
	}

	public void setCourseEventListener(CourseEventListener courseEventListener) {
	}

	public Label getNameL() {
		return nameL;
	}

	public Label getMajorL() {
		return majorL;
	}

	public Label getIdL() {
		return idL;
	}

	public Button getMoveRight1() {
		return moveRight1;
	}

	public Button getMoveRight2() {
		return moveRight2;
	}

	public Button getMoveLeft1() {
		return moveLeft1;
	}

	public Button getMoveLeft2() {
		return moveLeft2;
	}

}
