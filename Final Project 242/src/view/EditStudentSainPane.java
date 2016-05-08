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

public class EditStudentSainPane {
	Label nameL, majorL, idL;
	private ListView<String> coursesTakingList;
	private ListView<String> coursesTakenList;
	private ListView<String> coursesNeededList;
	private GridPane sainGrid;
	private TextField idT;
	private StudentEventListener studentEventListener;
	private CourseEventListener courseEventListener;

	public EditStudentSainPane() {
		coursesTakingList = new ListView();
		coursesTakingList.setMaxSize(70, 120);
		coursesTakenList = new ListView();
		coursesTakenList.setMaxSize(70, 120);
		coursesNeededList = new ListView();
		coursesNeededList.setMaxSize(70, 120);

		sainGrid = new GridPane();
		sainGrid.setAlignment(Pos.CENTER);
		// sainGrid.insetsProperty()In

		Label usernameL = new Label("Enter username");
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
			Label lb1 = new Label("      Name");
			nameL = new Label();

			Label lb2 = new Label("      Major");
			majorL = new Label();

			Label lb3 = new Label("      ID: ");
			idL = new Label();

			studentInfo.getChildren().addAll(lb1, nameL, lb2, majorL, lb3, idL);

			Button moveRight1 = new Button("1>>>");
			moveRight1.setOnAction(a -> {
				String course = new String((String) coursesTakenList.getSelectionModel()
						.getSelectedItem());
				
				
				CourseEventObjs event = new CourseEventObjs(this,course );
				if (courseEventListener != null) {
					courseEventListener.ButtonClicked(event);
				}

			});

			Button moveRight2 = new Button("2>>> ");
			moveRight2.setOnAction(a -> {
				String course = new String((String) coursesTakingList.getSelectionModel()
						.getSelectedItem());
				coursesTakingList.getSelectionModel()
				.getSelectedItem();
				CourseEventObjs event = new CourseEventObjs(this,course );
				if (courseEventListener != null) {
					courseEventListener.ButtonClicked(event);
				}

			});
			
			Button moveLeft1 = new Button("<<<1");
			moveLeft1.setOnAction(a -> {
				String course = new String((String) coursesTakingList.getSelectionModel()
						.getSelectedItem());
				CourseEventObjs event = new CourseEventObjs(this,course );
				if (courseEventListener != null) {
					courseEventListener.ButtonClicked(event);
				}

			});
			
			Button moveLeft2 = new Button("<<<2");
			moveLeft2.setOnAction(a -> {
				String course = new String((String) coursesNeededList.getSelectionModel()
						.getSelectedItem());
				CourseEventObjs event = new CourseEventObjs(this,course );
				if (courseEventListener != null) {
					courseEventListener.ButtonClicked(event);
				}

			});

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

	public ListView getCoursesTakingList() {
		return coursesTakingList;
	}

	public ListView getCoursesTakenList() {
		return coursesTakenList;
	}

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
		this.courseEventListener = courseEventListener;
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

}
