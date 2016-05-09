package model;

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
 * This class stores course Object into an arrayList so that information can be
 * stored and found.
 * 
 * @author Caio Eugenio
 *
 */
public class CourseBag implements Serializable {
	private ArrayList<Course> courseList = new ArrayList<>();

	public ArrayList<Course> getCourseList() {
		return courseList;
	}

	/**
	 * Saves course arrayList, which contains all course objects, into a binary
	 * file.
	 */
	public void save() {
		FileOutputStream fos;
		try {
			fos = new FileOutputStream("courseData.dat");

			ObjectOutputStream oos;
			try {
				oos = new ObjectOutputStream(fos);

				oos.writeObject(courseList);
				oos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// READ FROM BINARY FILE
	/**
	 * Load arraylist in binary file into the current active course ArrayList.
	 */
	public void read() {
		FileInputStream fis;
		try {
			fis = new FileInputStream("courseData.dat");
			ObjectInputStream ois;
			try {
				ois = new ObjectInputStream(fis);
				try {
					courseList = (ArrayList<Course>) ois.readObject();
					ois.close();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

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
	 * Adds a course object into a Course ArrayList.
	 * 
	 * @param course
	 *            Course
	 */
	// ADD METHOD
	public void add(Course course) {
		courseList.add(course);
	}
	
	



}
