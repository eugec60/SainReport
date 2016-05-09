package model;

import java.io.Serializable;

/**
 * The person creates a person with information that can be stored about the
 * person.
 * 
 * @author Caio Eugenio
 * @version 1.0
 *
 */
public class Person implements Serializable {

	private String fname;
	private String lname;
	private String phone;
	private String adress;
	private String username;
	private String password;
	private int id;
	private int status;

	private static int count;

	/**
	 * No arg constructor for the Person Class. Everytime a person object gets
	 * created count(a static int) gets incremented by 1. Count then is used to
	 * set the id of a person so that every Person object has a unique id.
	 * 
	 */
	public Person() {
		count++;
		this.id = count;

	}

	/**
	 * Construct for a Person Object. Everytime a person object gets created
	 * count(a static int) gets incremented by 1. Count then is used to set the
	 * id of a person so that every Person object has a unique id.
	 * 
	 * @param fname
	 *            First name of Person.
	 * @param lname
	 *            Last name of Person.
	 * @param phone
	 *            Phone number of Person.
	 * @param adress
	 *            Home Address
	 * @param username
	 *            Username for account
	 * @param password
	 *            Password for account
	 */
	public Person(String fname, String lname, String phone, String adress,
			String username, String password) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.phone = phone;
		this.adress = adress;
		this.username = username;
		this.password = password;
		count++;
		this.id = count;

	}

	public static int getCount() {
		return count;
	}

	public static void setCount(int count) {
		Person.count = count;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public int getId() {

		return id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Person [fname=" + fname + ", lname=" + lname + ", phone="
				+ phone + ", adress=" + adress + ", username=" + username
				+ ", password=" + password + ", id=" + id + ", status="
				+ status + "]";
	}

}
