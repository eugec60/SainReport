
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

	public class CourseBag {
		private ArrayList<Course> courseList = new ArrayList<>();

		public ArrayList<Course> courseList() {
			return courseList;
		}

		// IMPORT COURSE FROM TEXTFILE
		public void load(String filename) {
			File input = new File(filename);
			Scanner readFile;
			try {
				readFile = new Scanner(input);

				while (readFile.hasNextLine()) {
					String str = readFile.nextLine();
					String[] temp = str.split(",");
					String courseTitle = temp[0];
					String courseNum = temp[1];
					String crn = temp[2];
					String classAdress = temp[3];
					Course c1 = new Course(courseTitle, courseNum, crn, classAdress);
					courseList.add(c1);
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

			System.out.println("File is finished writing to the hard drive");
		}

		// READ FROM BINARY FILE
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

		public void display() {
			for (int i = 0; i < courseList.size(); i++) {
				System.out.println(courseList.get(i));
			}
		}

		// ADD METHOD
		public void add(Course course) {
			courseList.add(course);
		}

		// Search method
		public Course find(String crn) {

			for (int i = 0; i < courseList.size(); i++) {

				if (courseList.get(i).getCrn().equals(crn)) {
					return courseList.get(i);
				}
			}
			return null;
		}

		// REMOVE BUTTON
		public void remove(String crn) {

			for (int i = 0; i < courseList.size(); i++) {

				if (courseList.get(i).getCrn().equals(crn)) {
					courseList.remove(i);
					System.out.println("item was removed");
				}
			}
		}
		
		public Course findCourse ( String title)
		{ 
			
			for (int i = 0; i < courseList.size(); i++) {
				//System.out.println(title);
				//System.out.println(courseList.get(i).getCourseTitle());
				
				if (courseList.get(i).getCourseTitle().equals(title)) {
					return courseList.get(i);

				}

			}
			return null;
			
		}

	}


