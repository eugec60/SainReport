package eventListnersAndObjects;

import java.util.ArrayList;
import java.util.EventObject;

import model.Course;

public class StudentEventObjs extends EventObject {
	
	private String fname;
	private String lname;
	private String phone;
	private String adress;
	private int id;
	private double gpa;
	private String major;
	private int credits;

	public StudentEventObjs(Object source) {
		super(source);
	}

	public StudentEventObjs(Object source, String fname, String lname,
			String phone, String adress, int id, double gpa, String major,
			int credits) {
		super(source);
		this.fname = fname;
		this.lname = lname;
		this.phone = phone;
		this.adress = adress;
		this.id = id;
		this.gpa = gpa;
		this.major = major;
		this.credits = credits;
	}
	
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
	
	

}
