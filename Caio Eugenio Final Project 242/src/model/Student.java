package model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * The student class inherits from person and also adds arrayList of all the
 * course that are required to achieve its major. The arraylist are not
 * populated until a method populates them.
 * 
 * @author Caio Eugenio
 * @version 1.0
 *
 */
public class Student extends Person implements Serializable {

	private double gpa;
	private String major;
	private ArrayList<String> coursesTaken;
	private ArrayList<String> currentCourses;
	private ArrayList<String> coursesToGraduate;
	private int credits;

	/**
	 * Creates student object that contains all the imformation about said student object.
	 * @param fname Student First Name.
	 * @param lname Student Last Name.
	 * @param phone Student Phone Number.
	 * @param adress Student Home address.
	 * @param username Student Username.
	 * @param password Student Password
	 * @param gpa Student GPA
	 * @param major Student's Major
	 * @param credits Student credit earned
	 */
	public Student(String fname, String lname, String phone, String adress,
			String username, String password, double gpa, String major,
			int credits) {
		super(fname, lname, phone, adress, username, password);

		this.gpa = gpa;
		this.major = major;
		this.credits = credits;
		coursesTaken = new ArrayList<>();
		currentCourses = new ArrayList<>();
		coursesToGraduate = new ArrayList<>();

	}

	/**
	 * Copy's student object
	 * @param student student object to be copied
	 */
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
