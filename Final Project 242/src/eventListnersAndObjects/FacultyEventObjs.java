package eventListnersAndObjects;

import java.util.EventObject;

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
		// TODO Auto-generated constructor stub
	}

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
