package view;

import java.util.ArrayList;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import eventListnersAndObjects.MajorEventListener;
import eventListnersAndObjects.MajorEventObj;

public class MajorPane {

	GridPane majorGrid;
	TextField majorNameT;
	Button addB;
	TableView courseDisplayTable;
	MajorEventListener majorEventListerner;

	public MajorPane() {

		majorGrid = new GridPane();
		majorGrid.setAlignment(Pos.CENTER);
		majorGrid.setHgap(20);
		majorGrid.setVgap(20);

		// ADD BUTTON
		addB = new Button("Add a Major");
		majorGrid.add(addB, 0, 4);

		addB.setOnAction(e -> {
			majorGrid.getChildren().remove(addB);
			Button bt1 = new Button("Add to Majors");
			majorGrid.add(bt1, 0, 4);

			Label lbl1 = new Label("Major Name:");
			majorNameT = new TextField();
			majorGrid.add(lbl1, 0, 0);
			majorGrid.add(majorNameT, 0, 1);

			Label lbl2 = new Label("Course Required:");
			majorGrid.add(lbl2, 1, 1);
			majorGrid.add(courseDisplayTable, 1, 2);
			courseDisplayTable.getSelectionModel().setCellSelectionEnabled(true);
			

			bt1.setOnAction(a -> {
				ArrayList<String> crnList = new ArrayList<String>();
				crnList.addAll(courseDisplayTable.getSelectionModel().getSelectedCells());
				
				MajorEventObj ev = new MajorEventObj(this,
						majorNameT.getText(), crnList);
				System.out.println(crnList.get(0));
				System.out.println(crnList.get(1));
				

			});

		});

	}

	public GridPane getMajorGrid() {
		return majorGrid;
	}

	public void setCourseDisplayTable(TableView courseTableView) {
		this.courseDisplayTable = courseTableView;
	}

	public void setMajorEventListerner(MajorEventListener majorEventListerner) {
		this.majorEventListerner = majorEventListerner;
	}

}