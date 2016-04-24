package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class TextbookPane {
	
	TextField titleT, authorT, publisherT, priceT, isbnT, yearT;
	GridPane textbookGrid;
	
	public  TextbookPane() {
		
		textbookGrid = new GridPane();
		textbookGrid.setAlignment(Pos.TOP_CENTER);
		textbookGrid.setHgap(10);
		textbookGrid.setVgap(10);
		textbookGrid.setPadding(new Insets(25, 25, 25, 25));
		
		Label titleL = new Label("Title");
		titleT = new TextField();
		textbookGrid.add(titleL, 0, 2);
		textbookGrid.add(titleT, 0, 3);
		
		Label authorL = new Label("Author");
		authorT = new TextField();
		textbookGrid.add(authorL, 1, 2);
		textbookGrid.add(authorT, 1, 3);
		
		Label publisherL = new Label("Publisher");
		publisherT = new TextField();
		textbookGrid.add(publisherL, 2, 2);
		textbookGrid.add(publisherT, 2, 3);
		
		Label priceL = new Label("Price");
		priceT = new TextField();
		textbookGrid.add(priceL, 0, 5);
		textbookGrid.add(priceT, 0, 6);
		
		Label isbnL = new Label("Isbn");
		isbnT = new TextField();
		textbookGrid.add(isbnL, 1, 5);
		textbookGrid.add(isbnT, 1, 6);
		
		Label yearL = new Label("Year");
		yearT = new TextField();
		textbookGrid.add(yearL, 2, 5);
		textbookGrid.add(yearT, 2, 6);
		
		
		
		
		
	}

	public GridPane getTextbookGrid() {
		return textbookGrid;
	}
	
	

}
