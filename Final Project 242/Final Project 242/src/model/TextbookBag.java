package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class TextbookBag {
	
	private ArrayList<Textbook> textbookList = new ArrayList<>();

	public ArrayList<Textbook> textbookList() {
		return textbookList;
	}

	// LOAD FROM TEXT FILE
	public void load(String filename)  {
		File input = new File(filename);
		Scanner readFile;
		try {
			readFile = new Scanner(input);
		
		while (readFile.hasNextLine()) {
			String str = readFile.nextLine();
			String[] temp = str.split(",");
			String title = temp[0];
			String author = temp[1];
			String publisher = temp[2];
			double price = Double.parseDouble(temp[3]);
			String isbn = temp[4];
			int year = Integer.parseInt(temp[5]);
			Textbook t1 = new Textbook(title, author, publisher, price, isbn,
					year);
			textbookList.add(t1);
		}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// SAVE TO BINARY FILE

	public void save() {
		FileOutputStream fos;
		try {
			fos = new FileOutputStream("textbookData.dat");
		
		ObjectOutputStream oos;
		try {
			oos = new ObjectOutputStream(fos);
		

		oos.writeObject(textbookList);
		oos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("File is finished writing to the hard drive");
	}

	// READ FROM BINARY FILE
	public void read() {
		FileInputStream fis;
		try {
			fis = new FileInputStream("textbookData.dat");

			ObjectInputStream ois;
			try {
				ois = new ObjectInputStream(fis);

				try {
					textbookList = (ArrayList<Textbook>) ois.readObject();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ois.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// DISPLAY METHOD
	public void display() {
		for (int i = 0; i < textbookList.size(); i++) {
			System.out.println(textbookList.get(i));
		}
	}

	// ADD METHOD
	public void add(Textbook textbook) {
		textbookList.add(textbook);
	}
	//FIND METHOD
	public Textbook find(String isbn) {

		for (int i = 0; i < textbookList.size(); i++) {

			if (textbookList.get(i).getIsbn().equals(isbn)) {
				return textbookList.get(i);
			}
		}
		return null;
	}
	
	public Textbook findTextbook ( String title)
	{
		for (int i = 0; i < textbookList.size(); i++) {
			if (textbookList.get(i).getTitle().equals(title)) {
				return textbookList.get(i);

			}

		}
		return null;
		
	}
	
	//REMOVE METHOD
	public void remove(String isbn) {

		for (int i = 0; i < textbookList.size(); i++) {

			if (textbookList.get(i).getIsbn().equals(isbn)) {
				textbookList.remove(i);
				System.out.println("item was removed");
			}
		}
	}


}
