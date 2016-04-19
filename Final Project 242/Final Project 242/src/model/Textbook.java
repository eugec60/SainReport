package model;

public class Textbook {
	
	private String title;
	private String author;
	private String publisher;
	private double price;
	private String isbn;
	private int year;
	
	
	public Textbook(String title, String author, String publisher,
			double price, String isbn, int year) {
		super();
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
		this.isbn = isbn;
		this.year = year;
	}
	
	public Textbook(Textbook textbook){
		this.title = textbook.getTitle();
		this.author = textbook.getAuthor();
		this.publisher = textbook.getPublisher();
		this.price = textbook.getPrice();
		this.isbn = textbook.getIsbn();
		this.year = textbook.getYear();
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "Textbook [Title: " + title + ", Author: " + author
				+ ", Publisher: " + publisher + ", Price: " + price + ", ISBN: "
				+ isbn + ", Year: " + year + "]\n";
	}

}
