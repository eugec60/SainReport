package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class TextbookPane {
	
	TextField titleT, authorT, publisherT, priceT, isbnT, yearT;
	
	public GridPane buildTextbookPane() {
		
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.TOP_CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));
		
		Label titleL = new Label("Title");
		titleT = new TextField();
		grid.add(titleL, 0, 2);
		grid.add(titleT, 0, 3);
		
		Label authorL = new Label("Author");
		authorT = new TextField();
		grid.add(authorL, 1, 2);
		grid.add(authorT, 1, 3);
		
		Label publisherL = new Label("Publisher");
		publisherT = new TextField();
		grid.add(publisherL, 2, 2);
		grid.add(publisherT, 2, 3);
		
		Label priceL = new Label("Price");
		priceT = new TextField();
		grid.add(priceL, 0, 5);
		grid.add(priceT, 0, 6);
		
		Label isbnL = new Label("Isbn");
		isbnT = new TextField();
		grid.add(isbnL, 1, 5);
		grid.add(isbnT, 1, 6);
		
		Label yearL = new Label("Year");
		yearT = new TextField();
		grid.add(yearL, 2, 5);
		grid.add(yearT, 2, 6);
		
		
		
		return grid;
		
	}

}
