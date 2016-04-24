package view;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;

public class SainPane {
	
	private TableView coursesTakingT = new TableView();
	private TableView coursesTakenT  = new TableView();
	private TableView coursesNeededT = new TableView();
	private GridPane sainGrid;
	
	public SainPane() {
		sainGrid = new GridPane();
		sainGrid.setAlignment(Pos.CENTER);
		
		Label cTakingL = new Label("Course Taking");
		sainGrid.add(cTakingL,0,0);
		sainGrid.add(coursesTakingT,0,1);
		
		Label cTakenL = new Label("Course Taken");
		sainGrid.add(cTakenL,0,2);
		sainGrid.add(coursesTakenT,0,3);
		
		Label cNeededL = new Label("Course Needed");
		sainGrid.add(cNeededL,0,4);
		sainGrid.add(coursesNeededT,0,5);
		
	}

	public GridPane getSainGrid() {
		return sainGrid;
	}
	
	

}
