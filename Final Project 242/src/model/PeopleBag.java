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
import java.util.ArrayList;
import java.util.Scanner;

public class PeopleBag {
	
	private ArrayList<Person> personList = new ArrayList<>();

	public ArrayList<Person> personList() {
		return personList;
	}

	// SAVE TO BINARY FILE

	public void save() {
		FileOutputStream fos;
		try {
			fos = new FileOutputStream("studentData.dat");

			ObjectOutputStream oos;
			try {
				oos = new ObjectOutputStream(fos);

				oos.writeObject(personList);
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
					personList = (ArrayList<Person>) ois.readObject();
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
		for (int i = 0; i < personList.size(); i++) {
			System.out.println(personList.get(i));
		}
	}

	// ADD METHOD
	public void add(Student student) {
		personList.add(student);
	}

	public void add(Faculty faculty) {
		personList.add(faculty);
	}

	// FIND METHOD
	public Person find(int id) {

		for (int i = 0; i < personList.size(); i++) {
			if (personList.get(i).getId() == id) {
				return personList.get(i);

			}

		}
		return null;

	}

	// FIND STUDENT METHOD
	public Student findStudent(int id) {

		for (int i = 0; i < personList.size(); i++) {

			if (personList().get(i).getStatus() == 0) {
				if (personList.get(i).getId() == id) {
					return (Student) personList.get(i);
				}
			} else {

			}

		}
		return null;

	}
	public Student findStudentLN( String lastName)
	{
		
		for (int i = 0; i < personList.size(); i++) {
			
			if (personList().get(i).getStatus() == 0) {
				
				if (personList.get(i).getLname().equals(lastName)) {
					return  (Student) personList.get(i);
				}
			} else {

			}

		}
		return null;
		
		
	}
	
	//FIND FACULTY
		public Faculty findFaculty(int id) {

			for (int i = 0; i < personList.size(); i++) {

				if (personList().get(i).getStatus() == 1) {
					if (personList.get(i).getId() == id) {
						return (Faculty) personList.get(i);
					}
				} else {

				}

			}
			return null;

		}
		
		public Faculty findFacultyLN( String lastName)
		{
			
			for (int i = 0; i < personList.size(); i++) {
				
				if (personList().get(i).getStatus() == 1) {
					
					if (personList.get(i).getLname().equals(lastName)) {
						return  (Faculty) personList.get(i);
					}
				} else {

				}

			}
			return null;
			
			
		}
		

	// DELETE METHOD
	public void remove(int id) {
		for (int i = 0; i < personList.size(); i++) {

			if (personList.get(i).getId() == id) {
				System.out.println("Object was removed");
				personList.remove(i);
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
