package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import eventListnersAndObjects.EnterButtonListener;
import eventListnersAndObjects.TextbookEnterButton;

public class TextbookPane {

	private TextField titleT, authorT, publisherT, priceT, isbnT, yearT;
	private GridPane textbookPane;
	private Button addB, updateB,displayB;
	private EnterButtonListener enterButtonListener;
	private TableView textbookDisplayTable;

	public TextbookPane() {

		textbookPane = new GridPane();
		textbookPane.setAlignment(Pos.TOP_CENTER);
		textbookPane.setHgap(10);
		textbookPane.setVgap(10);
		textbookPane.setPadding(new Insets(25, 25, 25, 25));

		Label titleL = new Label("Title");
		titleT = new TextField();
		textbookPane.add(titleL, 0, 2);
		textbookPane.add(titleT, 0, 3);

		Label authorL = new Label("Author");
		authorT = new TextField();
		textbookPane.add(authorL, 1, 2);
		textbookPane.add(authorT, 1, 3);

		Label publisherL = new Label("Publisher");
		publisherT = new TextField();
		textbookPane.add(publisherL, 2, 2);
		textbookPane.add(publisherT, 2, 3);

		Label priceL = new Label("Price");
		priceT = new TextField();
		textbookPane.add(priceL, 0, 5);
		textbookPane.add(priceT, 0, 6);

		Label isbnL = new Label("Isbn");
		isbnT = new TextField();
		textbookPane.add(isbnL, 1, 5);
		textbookPane.add(isbnT, 1, 6);

		Label yearL = new Label("Year");
		yearT = new TextField();
		textbookPane.add(yearL, 2, 5);
		textbookPane.add(yearT, 2, 6);

		// ADD BUTTON
		addB = new Button("Add");
		textbookPane.add(addB, 0, 10);

		addB.setOnAction(e -> {
			TextbookEnterButton ev = new TextbookEnterButton(this, titleT
					.getText(), authorT.getText(), publisherT.getText(), Double.parseDouble(priceT
					.getText()), isbnT.getText(), Integer.parseInt(yearT.getText()));
			if (enterButtonListener != null) {
				enterButtonListener.enterButtonClicked(ev);
			}
			;

		});

		// UPDATE BUTTON
		updateB = new Button("Update");
		textbookPane.add(updateB, 2, 10);

		updateB.setOnAction(e -> {
			Stage secondaryStage = new Stage();
			GridPane searchPane = new GridPane();
			searchPane.setAlignment(Pos.CENTER);
			Label l1 = new Label("Enter Textbook Isbn");
			TextField idT = new TextField();
			searchPane.add(l1, 0, 0);
			searchPane.add(idT, 0, 1);
			Button b2 = new Button("Enter");
			searchPane.add(b2, 0, 2);
			b2.setOnAction(f -> {
				Stage searchDisplayStage = new Stage();
				secondaryStage.close();
				TextbookPane tp = new TextbookPane();
				tp.getTextbookPane().getChildren().removeAll(tp.getAddB());

				searchDisplayStage.setScene(new Scene(tp.getTextbookPane(),
						500, 300));
				searchDisplayStage.show();

			});

			secondaryStage.setScene(new Scene(searchPane, 200, 200));
			secondaryStage.showAndWait();

		});
		
		// Display BUTTON
		displayB = new Button("Display");
		textbookPane.add(displayB, 3, 10);

		displayB.setOnAction(e -> {
			Stage secondaryStage = new Stage();
			GridPane displayPane = new GridPane();
			displayPane.setAlignment(Pos.CENTER);
			Label l1 = new Label("Textbooks:");
			
//			textbookDisplayTable = new TableView();
//			 TableColumn title = new TableColumn("Title");
//		     TableColumn author = new TableColumn("Author");
//		     TableColumn publisher = new TableColumn("Publisher");
//		     TableColumn price = new TableColumn("Price");
//		     TableColumn isbn = new TableColumn("Isbn");
//		     TableColumn year = new TableColumn("Year");
//		     textbookDisplayTable.getColumns().addAll(title,author,publisher,price,isbn,year);
			
			displayPane.add(l1, 0, 0);
			displayPane.add(textbookDisplayTable, 0, 1);
			

			secondaryStage.setScene(new Scene(displayPane, 600,300));
			secondaryStage.showAndWait();

		});

	}

	public GridPane getTextbookPane() {
		return textbookPane;
	}

	public Button getAddB() {
		return addB;
	}

	public Button getUpdateB() {
		return updateB;
	}

	public TextField getTitleT() {
		return titleT;
	}

	public TextField getAuthorT() {
		return authorT;
	}

	public TextField getPublisherT() {
		return publisherT;
	}

	public TextField getPriceT() {
		return priceT;
	}

	public TextField getIsbnT() {
		return isbnT;
	}

	public TextField getYearT() {
		return yearT;
	}

	public void setEnterButtonListener(EnterButtonListener enterButtonListener) {
		this.enterButtonListener = enterButtonListener;
	}

	public TableView getTextbookDisplayTable() {
		return textbookDisplayTable;
	}

	public void setTextbookDisplayTable(TableView textbookDisplayTable) {
		this.textbookDisplayTable = textbookDisplayTable;
	}
	
	
	
	
	
	

}
