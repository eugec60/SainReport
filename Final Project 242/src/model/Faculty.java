package model;

import java.io.Serializable;

public class Faculty extends Person implements Serializable {
	private String officeAdress;
	private String title;
	private String department;
	private String payScale;
	private int id;
	private int status;

	private static int count;

	public Faculty(String fname, String lname, String phone, String adress,String username, String password,
			String officeAdress, String title, String department,
			String payScale) {
		super(fname, lname, phone, adress,username,password);
		this.officeAdress = officeAdress;
		this.title = title;
		this.department = department;
		this.payScale = payScale;
		setStatus(1);
		//count++;
		//this.id=count;
		
		//Person.setCount(Person.getCount()+1);
		//this.id = Person.getCount();
	}

	public Faculty(Faculty faculty) {
		setFname(faculty.getFname());
		setLname(faculty.getLname());
		setPhone(faculty.getPhone());
		setAdress(faculty.getAdress());
		this.officeAdress = faculty.getOfficeAdress();
		this.title = faculty.getTitle();
		this.department = faculty.getDepartment();
		this.payScale = faculty.getPayScale();

		setStatus(1);
		
		
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
				+ ", id=" + id + ", status=" + status + ", getFname()="
				+ getFname() + ", getLname()=" + getLname() + ", getId()="
				+ getId() + ", getPhone()=" + getPhone() + ", getAdress()="
				+ getAdress() + "]";
	}

	public String toString2(){
		return getLname();
	}

	

	
	

}
