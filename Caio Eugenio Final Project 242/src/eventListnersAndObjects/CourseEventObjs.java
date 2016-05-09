package eventListnersAndObjects;

import java.util.ArrayList;
import java.util.EventObject;

/**
 * This class creates A course Event Object that stores information captured
 * from textfield in the coursePane and sends it to RAM so that the controller
 * can use the data from it to create course Objects.
 * 
 * @author Caio Eugenio
 *
 */
public class CourseEventObjs extends EventObject {
	private String courseTitle;
	private String courseNum;
	private String crn;
	private String classAdress;
	private int credits;

	/**
	 * Saves the source of the action.
	 * 
	 * @param source
	 *            where its is listening to
	 */
	public CourseEventObjs(Object source) {
		super(source);
	}

	/**
	 * Creates event object that gets sent to RAM.
	 * 
	 * @param source
	 *            Button that was pressed
	 * @param courseTitle
	 *            Title of course from textfield
	 * @param courseNum
	 *            Course Number from textfield
	 * @param crn
	 *            CRN from Textfield
	 * @param classAdress
	 *            Class Address from TextField
	 * @param credits
	 *            credits From textField
	 */
	public CourseEventObjs(Object source, String courseTitle, String courseNum,
			String crn, String classAdress, int credits) {
		super(source);
		this.courseTitle = courseTitle;
		this.courseNum = courseNum;
		this.crn = crn;
		this.classAdress = classAdress;
		this.credits = credits;
	}

	/**
	 * 
	 * @return Course title
	 */
	public String getCourseTitle() {
		return courseTitle;
	}

	/**
	 * 
	 * @return Course Number
	 */
	public String getCourseNum() {
		return courseNum;
	}

	/**
	 * 
	 * @return CRN code from textfield
	 */
	public String getCrn() {
		return crn;
	}

	/**
	 * 
	 * @return Class address from textfield
	 */
	public String getClassAdress() {
		return classAdress;
	}

	/**
	 * 
	 * @return Credits from Textfield
	 */
	public int getCredits() {
		return credits;
	}

}
