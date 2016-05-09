package eventListnersAndObjects;

import java.util.EventObject;

/**
 * This class creates A faculty Event Object that stores information captured
 * from textfield in the facultyPane and sends it to RAM so that the controller
 * can use the data from it to create faculty Objects.
 * 
 * @author Caio Eugenio
 *
 */
public class FacultyEventObjs extends EventObject {

	private String fname;
	private String lname;
	private String phone;
	private String adress;
	private String username;
	private String password;
	private String id;
	private String officeAdress;
	private String title;
	private String department;
	private String payScale;

	public FacultyEventObjs(Object source) {
		super(source);
	}

	/**
	 * Creates faculty event Object that gets sent to ram to be read from
	 * controller.
	 * 
	 * @param source
	 * @param fname
	 *            First name from textfield
	 * @param lname
	 *            Last name form Textfield
	 * @param phone
	 *            Phone Number from textfield
	 * @param adress
	 *            Address from textfield
	 * @param username
	 *            Username From textfield
	 * @param password
	 *            password from textField
	 * @param officeAdress
	 *            Office address from TextField
	 * @param title
	 *            Job Title From textField
	 * @param department
	 *            Department of work from Textfield
	 * @param payScale
	 *            pay Amount from textfield
	 */
	public FacultyEventObjs(Object source, String fname, String lname,
			String phone, String adress, String username, String password,
			String officeAdress, String title, String department,
			String payScale) {
		super(source);
		this.fname = fname;
		this.lname = lname;
		this.phone = phone;
		this.adress = adress;
		this.username = username;
		this.password = password;
		this.officeAdress = officeAdress;
		this.title = title;
		this.department = department;
		this.payScale = payScale;
	}

	public String getFname() {
		return fname;
	}

	public String getLname() {
		return lname;
	}

	public String getPhone() {
		return phone;
	}

	public String getAdress() {
		return adress;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getOfficeAdress() {
		return officeAdress;
	}

	public String getTitle() {
		return title;
	}

	public String getDepartment() {
		return department;
	}

	public String getPayScale() {
		return payScale;
	}

}
