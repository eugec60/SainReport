package eventListnersAndObjects;

import java.util.EventObject;

public class LoginEventObj extends EventObject {
	String name;
	String password;
	
	
	
	public LoginEventObj(Object source) {
		super(source);
	}
	public LoginEventObj(Object source, String name, String password) {
		super(source);
		this.name = name;
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public String getPassword() {
		return password;
	}
	
	

}
