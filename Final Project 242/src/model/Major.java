package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Major implements Serializable{
	
	private String majorName;
	private ArrayList courseRequired = new ArrayList<>();
	
	
	public Major(String majorName, ArrayList courseRequired) {
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


	public void setCourseRequired(ArrayList courseRequired) {
		this.courseRequired = courseRequired;
	}
	
	
	
	
	
	
	
	
	

}