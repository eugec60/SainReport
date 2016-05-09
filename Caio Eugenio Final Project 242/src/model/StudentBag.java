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
 * Student Bag class will store all the student objects created into an Array
 * List that can be saved and read from.
 * 
 * @author Caio Eugenio
 * @version 1.0
 */
public class StudentBag implements Serializable {

	private ArrayList<Student> studentList = new ArrayList<>();

	public ArrayList<Student> getStudentList() {
		return studentList;
	}

	// SAVE TO BINARY FILE
	/**
	 * Saves studentList ArrayList into a binary file.
	 */
	public void save() {
		FileOutputStream fos;
		try {
			fos = new FileOutputStream("studentData.dat");

			ObjectOutputStream oos;
			try {
				oos = new ObjectOutputStream(fos);

				oos.writeObject(studentList);
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

	/**
	 * Reads studentList arrayList from binary file and sets the current
	 * studentList arrayList to the one from the binary file.
	 */
	// READ FROM BINARY FILE
	public void read() {
		FileInputStream fis;
		try {
			fis = new FileInputStream("studentData.dat");

			ObjectInputStream ois;
			try {
				ois = new ObjectInputStream(fis);
				try {
					studentList = (ArrayList<Student>) ois.readObject();
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
	 * Adds student to studentList ArrayList.
	 * 
	 * @param student
	 *            student you want stored.
	 */
	// ADD METHOD
	public void add(Student student) {
		studentList.add(student);
	}

	/**
	 * Searches through arrayList containing all the student Objects for one
	 * that has an ID that matches with the one entered.
	 * 
	 * @param id
	 *            ID of student your are looking for.
	 * @return
	 */
	// FIND METHOD
	public Student find(int id) {

		for (int i = 0; i < studentList.size(); i++) {
			if (studentList.get(i).getId() == id) {
				return studentList.get(i);

			}

		}
		return null;

	}

	/**
	 * Searches through studentList for username and password that matches the
	 * one that is received from the login pane.
	 * 
	 * @param username
	 *            username from loginPane textField
	 * @param password
	 *            password from loginPane textfied
	 * @return Student Object
	 */
	// Student Login Method
	public Student studentLogin(String username, String password) {

		for (int i = 0; i < studentList.size(); i++) {

			if (studentList.get(i).getUsername().equals(username)
					&& studentList.get(i).getPassword().equals(password)) {
				return studentList.get(i);
			}

		}
		return null;

	}

	/**
	 * Will search through the ArrayList that cointains courseTitle and matches
	 * it with the string from the observable list. If a match is found that
	 * courseTitle will be removed from the ArrayList.
	 * 
	 * @param list
	 *            The arrayList you want to search through
	 * @param name
	 *            Course Name that you want removed from that arrayList.
	 */
	public void searchAndRemove(ArrayList<String> list, String name) {
		for (int i = 0; i < list.size(); i++) {
			if (name.equals(list.get(i))) {
				list.remove(i);
			}
		}

	}

}
