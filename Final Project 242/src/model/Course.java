package model;

import java.util.ArrayList;

public class Course {
	private String courseTitle;
	private String courseNum;
	private String crn;
	private String classAdress;
	private int credits;
	
	public Course(){
		
	}
	
	public Course(String courseTitle, String courseNum, String crn,String classAdress, int credits) {
		super();
		this.courseTitle = courseTitle;
		this.courseNum = courseNum;
		this.crn = crn;
		this.classAdress = classAdress;
		this.credits = credits;

	}
	
	public Course(String courseTitle, String courseNum, String crn,
			Textbook textbook, Faculty faculty, ArrayList<Student> student,
			String classAdress) {
		super();
		this.courseTitle = courseTitle;
		this.courseNum = courseNum;
		this.crn = crn;
		this.classAdress = classAdress;
	}
	
	
	
	public Course(Course course) {
		this.courseTitle = course.getCourseTitle();
		this.courseNum = course.getCourseNum();
		this.crn= course.getCrn();
		
		this.classAdress=course.getClassAdress();
	}


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
				+ courseNum + ", CRN: " + crn + ", Class Adress: =" + classAdress + "]\n";
	}

}