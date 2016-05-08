package view;

import java.util.ArrayList;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import eventListnersAndObjects.MajorEventListener;
import eventListnersAndObjects.MajorEventObj;

public class MajorPane {

	GridPane majorGrid;
	TextField majorNameT;
	Button addB, displayB;
	ListView<String> courseListView, majorListView;
	MajorEventListener majorEventListener;

	public MajorPane() {
		courseListView = new ListView<String>();
		majorListView = new ListView<String>();

		majorGrid = new GridPane();
		majorGrid.setAlignment(Pos.CENTER);
		majorGrid.setHgap(20);
		majorGrid.setVgap(20);

		// ADD BUTTON
		majorNameT = new TextField();
		addB = new Button("Enter");
		majorGrid.add(majorNameT, 0, 3);
		majorGrid.add(addB, 0, 4);

		addB.setOnAction(e -> {

			Stage secondaryStage = new Stage();
			GridPane displayGrid = new GridPane();
			displayGrid.setAlignment(Pos.CENTER);

			ArrayList<String> crnList = new ArrayList<String>();
			String majorName = new String(majorNameT.getText());

			Label lbl2 = new Label("What course are Required");
			displayGrid.add(lbl2, 1, 1);
			displayGrid.add(courseListView, 1, 2);
			Button btn1 = new Button("Add to major");
			Button doneB = new Button("Finished Creating major");
			displayGrid.add(btn1, 2, 2);
			displayGrid.add(doneB, 5, 5);

			secondaryStage.setScene(new Scene(displayGrid, 700, 300));
			secondaryStage.show();

			btn1.setOnAction(a -> {

				crnList.add((String) courseListView.getSelectionModel()
						.getSelectedItem());

			});

			doneB.setOnAction(a -> {
				secondaryStage.close();

				MajorEventObj ev = new MajorEventObj(this, majorName, crnList);

				if (majorEventListener != null) {
					majorEventListener.ButtonClicked(ev);

				}

			});

		});
		
		
		// Display Button
		
		displayB = new Button("Display Majors");
		majorGrid.add(displayB,9, 9);
		displayB.setOnAction(e->{
			Stage secondaryStage = new Stage();
			GridPane displayPane = new GridPane();
			displayPane.setAlignment(Pos.CENTER);
			Label l1 = new Label("Majors");
			displayPane.add(l1, 0, 0);
			

				
			
			displayPane.add(majorListView, 0, 1);

			secondaryStage.setScene(new Scene(displayPane, 700, 300));
			secondaryStage.showAndWait();
		});
	

	}

	public GridPane getMajorGrid() {
		return majorGrid;
	}

	public void setMajorEventListerner(MajorEventListener majorEventListerner) {
		this.majorEventListener = majorEventListerner;
	}

	public ListView<String> getCourseListView() {
		return courseListView;
	}

	public ListView<String> getMajorListView() {
		return majorListView;
	}


	
	
	
	

}