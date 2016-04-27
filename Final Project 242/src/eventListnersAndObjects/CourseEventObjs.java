package eventListnersAndObjects;

import java.util.ArrayList;
import java.util.EventObject;



public class CourseEventObjs extends EventObject {
	private String courseTitle;
	private String courseNum;
	private String crn;
	private String textbook;
	private String faculty;
	private ArrayList<String> student;
	private String classAdress;

	public CourseEventObjs(Object arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public CourseEventObjs(Object source, String courseTitle, String courseNum,
			String crn, String textbook, String faculty,
			ArrayList<String> student, String classAdress) {
		super(source);
		this.courseTitle = courseTitle;
		this.courseNum = courseNum;
		this.crn = crn;
		this.textbook = textbook;
		this.faculty = faculty;
		this.student = student;
		this.classAdress = classAdress;
	}

	public String getCourseTitle() {
		return courseTitle;
	}

	public String getCourseNum() {
		return courseNum;
	}

	public String getCrn() {
		return crn;
	}

	public String getTextbook() {
		return textbook;
	}

	public String getFaculty() {
		return faculty;
	}

	public ArrayList<String> getStudent() {
		return student;
	}

	public String getClassAdress() {
		return classAdress;
	}
	
	

}
