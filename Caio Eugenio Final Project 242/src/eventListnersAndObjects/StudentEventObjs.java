package eventListnersAndObjects;

import java.util.ArrayList;
import java.util.EventObject;

import model.Course;

/**
 * This class creates A student Event Object that stores information captured
 * from textfield in the studentPane and sends it to RAM so that the controller
 * can use the data from it to create Student Objects.
 * 
 * @author Caio Eugenio
 *
 */
public class StudentEventObjs extends EventObject {

	private String fname;
	private String lname;
	private String phone;
	private String adress;
	private String username;
	private String password;
	private int id;
	private double gpa;
	private String major;
	private int credits;

	/**
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
	 * @param gpa
	 *            gpa from TextField
	 * @param major
	 *            major From TextField
	 * @param credits
	 *            Credits from Textfield
	 */
	public StudentEventObjs(Object source, String fname, String lname,
			String phone, String adress, String username, String password,
			double gpa, String major, int credits) {
		super(source);
		this.fname = fname;
		this.lname = lname;
		this.phone = phone;
		this.adress = adress;
		this.username = username;
		this.password = password;
		this.gpa = gpa;
		this.major = major;
		this.credits = credits;
	}

	/**
	 * This constructor send ID textField for controller to receive
	 * 
	 * @param source
	 *            source of button clicked
	 * @param id
	 */
	public StudentEventObjs(Object source, int id) {
		super(source);
		this.id = id;
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

	public int getId() {
		return id;
	}

	public double getGpa() {
		return gpa;
	}

	public String getMajor() {
		return major;
	}

	public int getCredits() {
		return credits;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

}
