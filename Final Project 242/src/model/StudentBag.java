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

public class StudentBag implements Serializable {

	private ArrayList<Student> studentList = new ArrayList<>();

	public ArrayList<Student> getStudentList() {
		return studentList;
	}

	// SAVE TO BINARY FILE

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

	

	// DISPLAY METHOD
	public void display() {
		for (int i = 0; i < studentList.size(); i++) {
			System.out.println(studentList.get(i));
		}
	}

	// ADD METHOD
	public void add(Student student) {
		studentList.add(student);
	}

	// FIND METHOD
	public Student find(int id) {

		for (int i = 0; i < studentList.size(); i++) {
			if (studentList.get(i).getId() == id) {
				return studentList.get(i);

			}

		}
		return null;

	}

	// FIND STUDENT METHOD
	public Student findStudent( int id) {

		for (int i = 0; i < studentList.size(); i++) {

			if (studentList.get(i).getId() == id) {
				return (Student) studentList.get(i);
			}

		}
		return null;

	}
	
	public Student findStudent(String username, String password) {

		for (int i = 0; i < studentList.size(); i++) {

			if (studentList.get(i).getUsername().equals(username) && studentList.get(i).getPassword().equals(password)) {
				return  studentList.get(i);
			}

		}
		return null;

	}



	// DELETE METHOD
	public void remove(int id) {
		for (int i = 0; i < studentList.size(); i++) {

			if (studentList.get(i).getId() == id) {
				System.out.println("Object was removed");
				studentList.remove(i);
			}
		}
	}

	// READ COUNT FROM BINARY FILE
	public void readID() {
		DataInputStream dis;
		try {
			dis = new DataInputStream(new FileInputStream("count.dat"));

			int a = dis.readInt();

			Student.setCount(a);

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
			os.writeInt(Student.getCount());
			os.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
