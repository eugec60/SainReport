package view;

import javafx.geometry.Insets;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class CoursePane {
	private GridPane coursePane;
	private TextField cTitleT, courseNumT, crnT, classAdressT;
	private ComboBox textbookC;
	private ComboBox facultyCombo;
	private TextArea studentT;

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

		Label facultyL = new Label("Faculty");
		facultyCombo = new ComboBox();
		coursePane.add(facultyL, 3, 2);
		coursePane.add(facultyCombo, 3, 3);

		Label studentL = new Label("Students");
		studentT = new TextArea();
		studentT.setPrefSize(100, 50);
		coursePane.add(studentL, 0, 5);
		coursePane.add(studentT, 0, 6);

		Label classAdressL = new Label("Class Adress");
		classAdressT = new TextField();
		coursePane.add(classAdressL, 1, 5);
		coursePane.add(classAdressT, 1, 6);
		
		Label textbookL = new Label("TextBook");
		textbookC = new ComboBox();
		System.setProperty("glass.accessible.force", "false");
		coursePane.add(textbookL, 2, 5);
		coursePane.add(textbookC, 2, 6);
		
		
		

	}

	public GridPane getCoursePane() {
		return coursePane;
	}
	
	

}
