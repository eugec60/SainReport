package view;

import javafx.geometry.Insets;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class CoursePane {

	private TextField cTitleT, courseNumT, crnT, classAdressT;
	private ComboBox textbookC;
	private ComboBox facultyCombo;
	private TextArea studentT;

	public GridPane buildCoursePane() {

		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 50, 75));

		

		Label cTitleL = new Label("Course Title");
		cTitleT = new TextField();
		grid.add(cTitleL, 0, 2);
		grid.add(cTitleT, 0, 3);

		Label courseNumL = new Label("Course Number");
		courseNumT = new TextField();
		grid.add(courseNumL, 1, 2);
		grid.add(courseNumT, 1, 3);

		Label crnL = new Label("Crn");
		crnT = new TextField();
		grid.add(crnL, 2, 2);
		grid.add(crnT, 2, 3);

		Label facultyL = new Label("Faculty");
		facultyCombo = new ComboBox();
		grid.add(facultyL, 3, 2);
		grid.add(facultyCombo, 3, 3);

		Label studentL = new Label("Students");
		studentT = new TextArea();
		studentT.setPrefSize(100, 50);
		grid.add(studentL, 0, 5);
		grid.add(studentT, 0, 6);

		Label classAdressL = new Label("Class Adress");
		classAdressT = new TextField();
		grid.add(classAdressL, 1, 5);
		grid.add(classAdressT, 1, 6);
		
		Label textbookL = new Label("TextBook");
		textbookC = new ComboBox();
		System.setProperty("glass.accessible.force", "false");
		grid.add(textbookL, 2, 5);
		grid.add(textbookC, 2, 6);
		
		return grid;
		

	}

}
