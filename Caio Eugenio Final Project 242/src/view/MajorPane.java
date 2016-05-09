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

/**
 * Major Pane class will build A Pane using JavaFx that allows the user to
 * create a major. The user will enter a major name and then press enter where a
 * second screen will pop up. In that screen the user will be ale to chose which
 * course he would like to make up that major. User then closes the stage and the major is created.
 * 
 * @author Caio Eugenio
 *
 */
public class MajorPane {

	GridPane majorGrid;
	TextField majorNameT;
	Button addB, displayB;
	ListView<String> courseListView, majorListView;
	MajorEventListener majorEventListener;

	/**
	 * Major Pane constructor that will build the pane that allows the user to create a major object.
	 */
	public MajorPane() {
		courseListView = new ListView<String>();
		majorListView = new ListView<String>();

		majorGrid = new GridPane();
		majorGrid.setAlignment(Pos.CENTER);
		majorGrid.setHgap(20);
		majorGrid.setVgap(10);

		Label lb1 = new Label("Name of New Major");
		majorNameT = new TextField();
		majorGrid.add(lb1, 0, 2);
		majorGrid.add(majorNameT, 0, 3);

		// ADD BUTTON
		addB = new Button("Enter");
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
		majorGrid.add(displayB, 9, 9);
		displayB.setOnAction(e -> {
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