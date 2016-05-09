package model;

import java.io.Serializable;

/**
 * This class creates a Faculty object.
 * 
 * @author Caio Eugenio
 * 
 *
 */
public class Faculty extends Person implements Serializable {
	private String officeAdress;
	private String title;
	private String department;
	private String payScale;
	private int id;
	private static int count;

	/**
	 * This is the faculty consturctor which creates a Faculty object with
	 * inheritance from Person Class
	 * 
	 * @param fname
	 *            First name of Faculty inherited from person
	 * @param lname
	 *            Last name of faculty inherited from person
	 * @param phone
	 *            Phone number of faculty inherited from person
	 * @param adress
	 *            Address of faculty inherited from person
	 * @param username
	 *            Username of faculty inherited from person
	 * @param password
	 *            Password of faculty Inherited from person
	 * @param officeAdress
	 *            Address of office/workplace
	 * @param title
	 *            Job title
	 * @param department
	 *            Department the faculty works at
	 * @param payScale
	 *            How much faculty gets paid
	 */
	public Faculty(String fname, String lname, String phone, String adress,
			String username, String password, String officeAdress,
			String title, String department, String payScale) {
		super(fname, lname, phone, adress, username, password);
		this.officeAdress = officeAdress;
		this.title = title;
		this.department = department;
		this.payScale = payScale;
	}

	/**
	 * Copy contructor for a faculty object.
	 * 
	 * @param faculty
	 *            faculty that the user would like to copy
	 */
	public Faculty(Faculty faculty) {
		setFname(faculty.getFname());
		setLname(faculty.getLname());
		setPhone(faculty.getPhone());
		setAdress(faculty.getAdress());
		this.officeAdress = faculty.getOfficeAdress();
		this.title = faculty.getTitle();
		this.department = faculty.getDepartment();
		this.payScale = faculty.getPayScale();

	}

	public String getOfficeAdress() {
		return officeAdress;
	}

	public void setOfficeAdress(String officeAdress) {
		this.officeAdress = officeAdress;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getPayScale() {
		return payScale;
	}

	public void setPayScale(String payScale) {
		this.payScale = payScale;
	}

	@Override
	public String toString() {
		return "Faculty [officeAdress=" + officeAdress + ", title=" + title
				+ ", department=" + department + ", payScale=" + payScale
				+ ", id=" + id + ", toString()=" + super.toString() + "]";
	}
	
	

	

}
