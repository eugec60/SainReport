package model;

import java.io.Serializable;

public class Person implements Serializable {
	
	private String fname;
	private String lname;
	private String phone;
	private String adress;
	private int id;
	private int status;

	private static int count;

	public Person() {
		count++;
		this.id = count;

	}

	public Person(String fname, String lname, String phone, String adress) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.phone = phone;
		this.adress = adress;
		count++;
		this.id = count;

	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
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

	@Override
	public String toString() {
		return "Person [First Name=" + fname + ", Last Name=" + lname + ",Id="
				+ id + ", Phone=" + phone + ", Adress=" + adress + "]";
	}
	
	

}
