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

public class FacultyBag  {
	
	private ArrayList<Faculty> facultyList = new ArrayList<>();

	public ArrayList<Faculty> getFacultyList() {
		return facultyList;
	}

	// SAVE TO BINARY FILE

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

	

	// DISPLAY METHOD
	public void display() {
		for (int i = 0; i < facultyList.size(); i++) {
			System.out.println(facultyList.get(i));
		}
	}

	// ADD METHOD
	public void add(Faculty Faculty) {
		facultyList.add(Faculty);
	}

	// FIND METHOD
	public Faculty find(int id) {

		for (int i = 0; i < facultyList.size(); i++) {
			if (facultyList.get(i).getId() == id) {
				return facultyList.get(i);

			}

		}
		return null;

	}

	// FIND Faculty METHOD
	public Faculty findFacutly(String username, String password) {

		for (int i = 0; i < facultyList.size(); i++) {

			if (facultyList.get(i).getUsername().equals(username)&& facultyList.get(i).getPassword().equals(password)) {
				return  facultyList.get(i);
			}

		}
		return null;

	}

	

	// DELETE METHOD
	public void remove(int id) {
		for (int i = 0; i < facultyList.size(); i++) {

			if (facultyList.get(i).getId() == id) {
				System.out.println("Object was removed");
				facultyList.remove(i);
			}
		}
	}

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
