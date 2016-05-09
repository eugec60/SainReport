package model;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class will create an ArrayList for caulty objects to be stored
 * 
 * @author Caio Eugenio
 * @version 1.0
 *
 */
public class FacultyBag {

	private ArrayList<Faculty> facultyList = new ArrayList<>();

	public ArrayList<Faculty> getFacultyList() {
		return facultyList;
	}

	// SAVE TO BINARY FILE
	/**
	 * Saves faculty ArrayList into a binary file that can be read later.
	 */
	public void save() {
		FileOutputStream fos;
		try {
			fos = new FileOutputStream("facultyData.dat");

			ObjectOutputStream oos;
			try {
				oos = new ObjectOutputStream(fos);

				oos.writeObject(facultyList);
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
	/**
	 * Read arrayList from a binary file and populate the current arrayList from
	 * it.
	 */
	public void read() {
		FileInputStream fis;
		try {
			fis = new FileInputStream("facultyData.dat");

			ObjectInputStream ois;
			try {
				ois = new ObjectInputStream(fis);
				try {
					facultyList = (ArrayList<Faculty>) ois.readObject();
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

	/**
	 * Adds a faculty object to the Faculty ArrayList
	 * 
	 * @param Faculty
	 *            Faculty Object
	 */
	// ADD METHOD
	public void add(Faculty Faculty) {
		facultyList.add(Faculty);
	}

	/**
	 * This method looks through the Faculty ArrayList to find a faculty object
	 * that matches the username and password field from the loginPane.
	 * 
	 * @param username
	 *            username from LoginPane textfield
	 * @param password
	 *            password from LoginPane textfield
	 * @return faculty Object if matches occur, otherwise returns null.
	 */
	// FIND Faculty METHOD
	public Faculty facultyLogin(String username, String password) {

		for (int i = 0; i < facultyList.size(); i++) {

			if (facultyList.get(i).getUsername().equals(username)
					&& facultyList.get(i).getPassword().equals(password)) {
				return facultyList.get(i);
			}

		}
		return null;

	}

	/**
	 * Read count number from the count binary file.
	 */
	// READ COUNT FROM BINARY FILE
	public void readID() {
		DataInputStream dis;
		try {
			dis = new DataInputStream(new FileInputStream("count.dat"));

			int a = dis.readInt();

			Person.setCount(a);

			dis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Saves count to a binary file. Count is the number that is incremented
	 * when an object that is inherited from person is created.
	 */
	// SAVES COUNT TO BINARY
	public void saveID() {
		try {
			DataOutputStream os = new DataOutputStream(new FileOutputStream(
					"count.dat"));
			os.writeInt(Person.getCount());
			os.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
