package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.Textbook;
import model.TextbookBag;
import view.MainWindow;
import eventListnersAndObjects.EnterButtonListener;
import eventListnersAndObjects.TextbookEnterButton;

public class TextbookController {

	TextbookBag tb = new TextbookBag();

	public TextbookController(MainWindow mainWindow) {

		TableView textbookDisplayTable = new TableView();
		TableColumn title = new TableColumn("Title");
		TableColumn author = new TableColumn("Author");
		TableColumn publisher = new TableColumn("Publisher");
		TableColumn price = new TableColumn("Price");
		TableColumn isbn = new TableColumn("Isbn");
		TableColumn year = new TableColumn("Year");
		textbookDisplayTable.getColumns().addAll(title, author, publisher,
				price, isbn, year);
		mainWindow.getTabsPane().gettPane()
				.setTextbookDisplayTable(textbookDisplayTable);

		// TEXTBOOK PANE BUTTONS
		mainWindow.getTabsPane().gettPane()
				.setEnterButtonListener(new EnterButtonListener() {
					
					@SuppressWarnings("unchecked")
					@Override
					public void enterButtonClicked(TextbookEnterButton ev) {
						Textbook textbook = new Textbook(ev.getTitle(), ev
								.getAuthor(), ev.getPublisher(), ev.getPrice(),
								ev.getIsbn(), ev.getYear());
						ObservableList<Textbook> textbookData = FXCollections
								.observableArrayList(tb.getTextbookList());
						mainWindow.getTabsPane().gettPane()
								.getTextbookDisplayTable()
								.setItems(textbookData);

						tb.getTextbookList().add(textbook);
						System.out.println(tb.getTextbookList().get(0));
						System.out.println(tb.getTextbookList().get(1));

					}
				});

	}
}
