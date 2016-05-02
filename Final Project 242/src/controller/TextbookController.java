package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import model.Textbook;
import model.TextbookBag;
import view.MainWindow;
import eventListnersAndObjects.EnterButtonListener;
import eventListnersAndObjects.TextbookEnterButton;

public class TextbookController {

	TextbookBag tb;
	ObservableList<Textbook> textbookData;

	
	@SuppressWarnings("unchecked")
	public TextbookController(MainWindow mainWindow) {
		tb = new TextbookBag();
		textbookData = FXCollections.observableArrayList(tb.getTextbookList());
		


		mainWindow.getTabsPane().gettPane()
				.setTextbookDisplayTable(buildTable());

		// TEXTBOOK Display Button
		mainWindow.getTabsPane().gettPane()
				.setEnterButtonListener(new EnterButtonListener() {

					@Override
					public void enterButtonClicked(TextbookEnterButton ev) {
						Textbook textbook = new Textbook(ev.getTitle(), ev
								.getAuthor(), ev.getPublisher(), ev.getPrice(),
								ev.getIsbn(), ev.getYear());

						textbookData.add(textbook);
						mainWindow.getTabsPane().gettPane().getTextbookDisplayTable().setItems(textbookData);
						

					}
				});

	}

	
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public TableView buildTable() {

		TableView textbookDisplayTable = new TableView();

		TableColumn titleCol = new TableColumn("Title");
		titleCol.setCellValueFactory(new PropertyValueFactory<Textbook, String>(
				"title"));

		TableColumn authorCol = new TableColumn("Author");
		authorCol
				.setCellValueFactory(new PropertyValueFactory<Textbook, String>(
						"author"));

		TableColumn publisherCol = new TableColumn("Publisher");
		publisherCol
				.setCellValueFactory(new PropertyValueFactory<Textbook, String>(
						"publisher"));

		TableColumn priceCol = new TableColumn("Price");
		priceCol.setCellValueFactory(new PropertyValueFactory<Textbook, String>(
				"price"));

		TableColumn isbnCol = new TableColumn("Isbn");
		isbnCol.setCellValueFactory(new PropertyValueFactory<Textbook, String>(
				"isbn"));

		TableColumn yearCol = new TableColumn("Year");
		yearCol.setCellValueFactory(new PropertyValueFactory<Textbook, String>(
				"year"));

		textbookDisplayTable.getColumns().addAll(titleCol, authorCol,
				publisherCol, priceCol, isbnCol, yearCol);

		return textbookDisplayTable;

	}
}
