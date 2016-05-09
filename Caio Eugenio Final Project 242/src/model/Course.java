package model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * This class makes a course object that will let courses be created.
 * 
 * @author Caio Eugenio
 * @version 1.0
 *
 */
public class Course implements Serializable {
	private String courseTitle;
	private String courseNum;
	private String crn;
	private String classAdress;
	private int credits;

	/**
	 * No argument constructor for course Class
	 */
	public Course() {

	}

	/**
	 * This contructs a course object with a title,course number, Crn, Class
	 * address and Credits it is worth.
	 * 
	 * @param courseTitle
	 *            Title of Course
	 * @param courseNum
	 *            Course Number
	 * @param crn
	 *            Crn Code For Course
	 * @param classAdress
	 *            Address for the Course
	 * @param credits
	 *            How many credits it is worth
	 */
	public Course(String courseTitle, String courseNum, String crn,
			String classAdress, int credits) {
		super();
		this.courseTitle = courseTitle;
		this.courseNum = courseNum;
		this.crn = crn;
		this.classAdress = classAdress;
		this.credits = credits;

	}

	/**
	 * Makes a copy of a course object
	 * 
	 * @param course
	 *            Course object to be copied
	 */
	public Course(Course course) {
		this.courseTitle = course.getCourseTitle();
		this.courseNum = course.getCourseNum();
		this.crn = course.getCrn();
		this.classAdress = course.getClassAdress();
	}

	/**
	 * 
	 * @return Course Title
	 */
	public String getCourseTitle() {
		return courseTitle;
	}

	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}

	public String getCourseNum() {
		return courseNum;
	}

	public void setCourseNum(String courseNum) {
		this.courseNum = courseNum;
	}

	public String getCrn() {
		return crn;
	}

	public void setCrn(String crn) {
		this.crn = crn;
	}

	public String getClassAdress() {
		return classAdress;
	}

	public void setClassAdress(String classAdress) {
		this.classAdress = classAdress;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	@Override
	public String toString() {
		return "Course [Course Title: " + courseTitle + ", Course Num: "
				+ courseNum + ", CRN: " + crn + ", Class Adress: ="
				+ classAdress + "]\n";
	}

}