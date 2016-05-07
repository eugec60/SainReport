package view;

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

public class FindStudentPane {
	
	private GridPane findStudentGrid;
	private TextField idT;
	private TableView studentDisplayTable;
	private StudentEventListener studentEventListener;
	
	public FindStudentPane(){
		findStudentGrid = new GridPane();
		findStudentGrid.setAlignment(Pos.CENTER);
		
		Label idL = new Label("Enter student ID");
		idT = new TextField();
		findStudentGrid.add(idL,0,0);
		findStudentGrid.add(idT,0,1);
		
		
		Button searchB = new Button("Search");
		findStudentGrid.add(searchB,0,2);
		
		searchB.setOnAction(e-> {
			StudentEventObjs ev = new StudentEventObjs(this, Integer.parseInt(idT.getText()));
			if (studentEventListener != null) {
				studentEventListener.buttonClicked(ev);
			}
			
			
			Stage secondaryStage = new Stage();
			GridPane displayPane = new GridPane();
			displayPane.setAlignment(Pos.CENTER);
			Label l1 = new Label("Student:");

			displayPane.add(l1, 0, 0);
			displayPane.add(studentDisplayTable, 0, 1);

			secondaryStage.setScene(new Scene(displayPane, 700, 350));
			secondaryStage.showAndWait();
			
			
		});
		
	}

	public GridPane getFindStudentGrid() {
		return findStudentGrid;
	}

	public void setFindStudentGrid(GridPane findStudentGrid) {
		this.findStudentGrid = findStudentGrid;
	}

	public void setStudentDisplayTable(TableView studentDisplayTable) {
		this.studentDisplayTable = studentDisplayTable;
	}

	public void setStudentEventListener(StudentEventListener studentEventListener) {
		this.studentEventListener = studentEventListener;
	}

	public TableView getStudentDisplayTable() {
		return studentDisplayTable;
	}
	
	
	
	
	
	
	

}
