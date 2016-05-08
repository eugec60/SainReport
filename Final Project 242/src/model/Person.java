package model;

import java.io.Serializable;

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

	public Person() {
		count++;
		this.id = count;

	}

	public Person(String fname, String lname, String phone, String adress,String username,String password) {
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
