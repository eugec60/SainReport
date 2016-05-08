package eventListnersAndObjects;

import java.util.ArrayList;
import java.util.EventObject;

public class MajorEventObj extends EventObject {

	String majorName;
	ArrayList<String> courseRequiredM = new ArrayList<>();
	
	public MajorEventObj(Object source, String majorName, ArrayList<String> crn) {
		super(source);
		this.majorName = majorName;
		this.courseRequiredM = crn;
	}
	public String getMajorName() {
		return majorName;
	}
	public ArrayList<String> getCourseRequiredM() {
		return courseRequiredM;
	}
	
	
	
	
	

}
