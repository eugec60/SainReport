package view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import eventListnersAndObjects.StudentEventListener;
import eventListnersAndObjects.StudentEventObjs;

public class SainPane {
	
	private ListView coursesTakingList;
	private ListView coursesTakenList;
	private ListView coursesNeededList;
	private GridPane sainGrid;
	private TextField idT;
	private StudentEventListener studentEventListener;
	
	public SainPane() {
		
		coursesTakingList = new ListView();
		coursesTakenList  = new ListView();
		coursesNeededList = new ListView();
		
		
		
		sainGrid = new GridPane();
		sainGrid.setAlignment(Pos.CENTER);
		
		Label usernameL = new Label("Enter username");
		idT = new TextField();
		Button searchB = new Button("Search");
		
		sainGrid.add(usernameL, 0,0);
		sainGrid.add(idT,0,1);
		sainGrid.add(searchB, 1,1);
		
		searchB.setOnAction(e-> {
			
			
			StudentEventObjs ev = new StudentEventObjs(this, Integer.parseInt(idT.getText()));
			if (studentEventListener != null) {
				studentEventListener.buttonClicked(ev);
			}
			
			
			GridPane secondaryDisplay = new GridPane();
			Stage secondaryStage = new Stage();
			
			Label cTakingL = new Label("Course Taking");
			secondaryDisplay.add(cTakingL,1,0);
			secondaryDisplay.add(coursesTakingList,1,1);
			
			Label cTakenL = new Label("Course Taken");
			secondaryDisplay.add(cTakenL,3,0);
			secondaryDisplay.add(coursesTakenList,3,1);
			
			Label cNeededL = new Label("Course Needed");
			secondaryDisplay.add(cNeededL,5,0);
			secondaryDisplay.add(coursesNeededList,5,1);
			
			secondaryStage.setScene(new Scene(secondaryDisplay, 700, 300));
			secondaryStage.show();
			
			
			
		});
		
		
		
		
		
		

		
	}

	public GridPane getSainGrid() {
		return sainGrid;
	}

	public void setStudentEventListener(StudentEventListener studentEventListener) {
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
	
	
	
	
	
	

}
