package model;

import java.util.ArrayList;

public class Course {
	private String courseTitle;
	private String courseNum;
	private String crn;
	private Textbook textbook;
	private Faculty faculty;
	private ArrayList<Student> student;
	private String classAdress;
	
	public Course(){
		
	}
	
	public Course(String courseTitle, String courseNum, String crn,
			Textbook textbook, Faculty faculty,
			String classAdress) {
		super();
		this.courseTitle = courseTitle;
		this.courseNum = courseNum;
		this.crn = crn;
		this.textbook = textbook;
		this.faculty = faculty;
		this.student = student;
		this.classAdress = classAdress;
		this.student = null;
	}
	
	public Course(String courseTitle, String courseNum, String crn,
			Textbook textbook, Faculty faculty, ArrayList<Student> student,
			String classAdress) {
		super();
		this.courseTitle = courseTitle;
		this.courseNum = courseNum;
		this.crn = crn;
		this.textbook = textbook;
		this.faculty = faculty;
		this.student = student;
		this.classAdress = classAdress;
	}
	
	public Course(String courseTitle, String courseNum, String crn,
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




	public Faculty getFaculty() {
		return faculty;
	}


	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}



	public Textbook getTextbook() {
		return textbook;
	}

	public void setTextbook(Textbook textbook) {
		this.textbook = textbook;
	}

	public ArrayList<Student> getStudent() {
		return student;
	}

	public void setStudent(Student student2) {
		student.add(student2);
	}

	public String getClassAdress() {
		return classAdress;
	}


	public void setClassAdress(String classAdress) {
		this.classAdress = classAdress;
	}

	@Override
	public String toString() {
		return "Course [Course Title: " + courseTitle + ", Course Num: "
				+ courseNum + ", CRN: " + crn + ", Textbook: " + textbook
				+ ", Faculty: " + faculty + ", Student: " + student
				+ ", Class Adress: =" + classAdress + "]\n";
	}

}