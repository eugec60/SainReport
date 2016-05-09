package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
/**
 * This class creates a major. The courseRequired arrayList is populated with CourseTitle Strings.
 * @author Caio Eugenio
 * @version 1.0
 *
 */
public class Major implements Serializable{
	
	private String majorName;
	private ArrayList<String> courseRequired;
	
	/**
	 * Create a major object and populates it with a different ArrayList.
	 * @param majorName Name of Major.
	 * @param courseRequired	Course required to complete the Major.
	 */
	public Major(String majorName, ArrayList<String> courseRequired) {
		super();
		this.majorName = majorName;
		this.courseRequired = courseRequired;
	}


	public String getMajorName() {
		return majorName;
	}


	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}


	public List getCourseRequired() {
		return courseRequired;
	}


	public void setCourseRequired(ArrayList<String> courseRequired) {
		this.courseRequired = courseRequired;
	}
	
	
	
	
	
	
	
	
	

}