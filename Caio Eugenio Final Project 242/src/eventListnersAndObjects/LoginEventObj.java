package eventListnersAndObjects;

import java.util.EventObject;

/**
 * This class creates A Login Event Object that stores information captured from
 * textfield in the loginPane and sends it to RAM so that the controller can use
 * the data from it so that user can login.
 * 
 * @author Caio Eugenio
 *
 */
public class LoginEventObj extends EventObject {
	String name;
	String password;

	/**
	 * Sends the strings inside the textfields to ram.
	 * @param source
	 * @param name String from Username TextField.
	 * @param password String from Password TextField.
	 */
	public LoginEventObj(Object source, String name, String password) {
		super(source);
		this.name = name;
		this.password = password;
	}

	/**
	 * 
	 * @return UserName from textField
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @return Password from TextField
	 */
	public String getPassword() {
		return password;
	}

}
