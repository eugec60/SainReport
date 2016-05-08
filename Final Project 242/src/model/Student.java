package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Student extends Person implements Serializable {

	private double gpa;
	private String major;
	private ArrayList<String> coursesTaken;
	private ArrayList<String> currentCourses;
	private ArrayList<String> coursesToGraduate;
	private int credits;
	

	public Student(String fname, String lname, String phone, String adress,String username, String password,
			double gpa, String major, int credits, Course courseTaken,
			Course currentCourses2, Course coursesToGraduate2) {
		super(fname, lname, phone, adress,username,password);
		
		this.gpa = gpa;
		this.major = major;
		this.credits = credits;
		coursesTaken = new ArrayList<>();
		currentCourses = new ArrayList<>();
		coursesToGraduate = new ArrayList<>();

	

	
	}

	public Student(String fname, String lname, String phone, String adress, String username, String password,
			double gpa, String major, int credits) {
		super(fname, lname, phone, adress,username, password);
		
		this.gpa = gpa;
		this.major = major;
		this.credits = credits;
		coursesTaken = new ArrayList<>();
		currentCourses = new ArrayList<>();
		coursesToGraduate = new ArrayList<>();
		


	}

	public Student(Student student) {// ************************COPY
										// CONSTRUCTOR!!!!*************************
		setFname(student.getFname());
		setLname(student.getLname());
		setPhone(student.getPhone());
		setAdress(student.getAdress());
		setUsername(student.getUsername());
		setPassword(student.getPassword());
		this.gpa = student.getGpa();
		this.major = student.getMajor();
		this.credits = student.getCredits();

		

	}

	// public Student copy(Student student) { // ***COPY METHOD***
	// name = student.name;
	// phone = student.phone;
	// major = student.major;
	// gpa = student.gpa;
	// return student;
	// }

	

	

	
	
	public double getGpa() {
		return gpa;
	}

	public ArrayList<String> getCoursesTaken() {
		return coursesTaken;
	}

	public void setCoursesTaken(ArrayList<String> coursesTaken) {
		this.coursesTaken = coursesTaken;
	}

	public ArrayList<String> getCurrentCourses() {
		return currentCourses;
	}

	public void setCurrentCourses(ArrayList<String> currentCourses) {
		this.currentCourses = currentCourses;
	}

	public ArrayList<String> getCoursesToGraduate() {
		return coursesToGraduate;
	}

	public void setCoursesToGraduate(ArrayList<String> coursesToGraduate) {
		this.coursesToGraduate = coursesToGraduate;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	@Override
	public String toString() {
		return "Student [gpa=" + gpa + ", major=" + major + ", coursesTaken="
				+ coursesTaken + ", currentCourses=" + currentCourses
				+ ", coursesToGraduate=" + coursesToGraduate + ", credits="
				+ credits + ", getFname()=" + getFname() + ", getLname()="
				+ getLname() + ", getId()=" + getId() + ", getPhone()="
				+ getPhone() + ", getAdress()=" + getAdress()
				+ ", getUsername()=" + getUsername() + ", getPassword()="
				+ getPassword() + "]";
	}

	
	
	

	

	

}
