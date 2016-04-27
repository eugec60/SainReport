package eventListnersAndObjects;

import java.util.EventObject;
import java.util.List;

public class TextbookEnterButton extends EventObject {
	private String title;
	private String author;
	private String publisher;
	private double price;
	private String isbn;
	private int year;

	

	public TextbookEnterButton(Object source) {
		super(source);
		// TODO Auto-generated constructor stub
	}


	public TextbookEnterButton(Object source, String title, String author,
			String publisher, double price, String isbn, int year) {
		super(source);
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
		this.isbn = isbn;
		this.year = year;
	}
	
	


	public String getTitle() {
		return title;
	}


	public String getAuthor() {
		return author;
	}


	public String getPublisher() {
		return publisher;
	}


	public double getPrice() {
		return price;
	}


	public String getIsbn() {
		return isbn;
	}


	public int getYear() {
		return year;
	}


	
	
	
	
	
	
	

}
