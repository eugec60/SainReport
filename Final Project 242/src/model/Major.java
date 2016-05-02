package model;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Major {
	
	private String majorName;
	private List courseRequired = new ArrayList<Course>();
	
	
	public Major(String majorName, List courseRequired) {
		super();
		this.majorName = majorName;
		this.courseRequired = courseRequired;
	}
	
	public void addCourseToMajor(Course course){
		courseRequired.add(course);
	}
	
	
	
	
	

}