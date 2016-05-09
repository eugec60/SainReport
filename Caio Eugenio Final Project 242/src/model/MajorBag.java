package model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * This Class will store Major objects into an arrayList that can be saved and
 * loaded when the user wants.
 * 
 * @author Caio Eugenio
 * @version 1.0
 *
 */
public class MajorBag implements Serializable {
	private ArrayList<Major> majorList = new ArrayList<>();

	public ArrayList<Major> getMajorList() {
		return majorList;
	}

	/**
	 * Add a major object into major ArrayList.
	 * 
	 * @param Major
	 *            major you want to add to arrayList.
	 */
	public void addMajor(Major major) {
		majorList.add(major);
	}

	/**
	 * Saves major arrayList to a binary file.
	 */
	// SAVE TO BINARY FILE
	public void save() {
		FileOutputStream fos;
		try {
			fos = new FileOutputStream("majorData.dat");

			ObjectOutputStream oos;
			try {
				oos = new ObjectOutputStream(fos);

				oos.writeObject(majorList);
				oos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out
				.println("Major bag File is finished writing to the hard drive");
	}

	/**
	 * Read major ArrayList from binary File and then populates current major
	 * arrayList with it.
	 */
	// READ FROM BINARY FILE
	public void read() {
		FileInputStream fis;
		try {
			fis = new FileInputStream("majorData.dat");

			ObjectInputStream ois;
			try {
				ois = new ObjectInputStream(fis);
				try {
					majorList = (ArrayList<Major>) ois.readObject();
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

}
