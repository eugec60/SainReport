package eventListnersAndObjects;

import java.util.ArrayList;
import java.util.EventObject;

public class MajorEventObj extends EventObject {

	String majorName;
	ArrayList<String> crn = new ArrayList<>();
	
	public MajorEventObj(Object source, String majorName, ArrayList<String> crn) {
		super(source);
		this.majorName = majorName;
		this.crn = crn;
	}
	public String getMajorName() {
		return majorName;
	}
	public ArrayList<String> getCrn() {
		return crn;
	}
	
	
	
	
	

}
