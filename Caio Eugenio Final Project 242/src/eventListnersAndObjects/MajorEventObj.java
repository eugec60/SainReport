package eventListnersAndObjects;

import java.util.ArrayList;
import java.util.EventObject;

/**
 * This class creates A major Event Object that stores information captured from
 * textfield and listView in the majorPane and sends it to RAM so that the
 * controller can use the data from it to create major Objects.
 */
public class MajorEventObj extends EventObject {

	String majorName;
	ArrayList<String> courseRequiredM;

	/**
	 * 
	 * @param source
	 *            button that was pressed.
	 * @param majorName
	 *            Name of the major captured from the textfield.
	 * @param crn
	 */
	public MajorEventObj(Object source, String majorName, ArrayList<String> crn) {
		super(source);
		this.majorName = majorName;
		this.courseRequiredM = crn;
	}

	/**
	 * 
	 * @return Major name captured from Textfield
	 */
	public String getMajorName() {
		return majorName;
	}

	/**
	 * 
	 * @return arraylist of courses required to complete Major
	 */
	public ArrayList<String> getCourseRequiredM() {
		return courseRequiredM;
	}

}
