package eventListnersAndObjects;

import java.util.ArrayList;
import java.util.EventObject;



public class CourseEventObjs extends EventObject {
	private String courseTitle;
	private String courseNum;
	private String crn;
	private String classAdress;
	private int credits;

	public CourseEventObjs(Object arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public CourseEventObjs(Object source, String courseTitle, String courseNum,
			String crn, String classAdress,int credits) {
		super(source);
		this.courseTitle = courseTitle;
		this.courseNum = courseNum;
		this.crn = crn;
		this.classAdress = classAdress;
		this.credits = credits;
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


	public String getClassAdress() {
		return classAdress;
	}

	public int getCredits() {
		return credits;
	}
	
	
	
	

}
