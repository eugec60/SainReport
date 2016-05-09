package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import eventListnersAndObjects.LoginEventListener;
import eventListnersAndObjects.LoginEventObj;

/**
 * Class allows the user to call a constructor that will build a Login pane that
 * will prompt the user to enter a username and password to login to the
 * program.
 * 
 * @author Caio Eugenio
 *
 */
public class LoginPane {

	private GridPane loginGrid;
	private TextField usernameT;
	private PasswordField passwordT;
	private Button enterB;
	private LoginEventListener loginEventListener;
/**
 * Constructor will build a login pane
 */
	public LoginPane() {
		loginGrid = new GridPane();
		loginGrid.setHgap(10);
		loginGrid.setVgap(10);
		loginGrid.setPadding(new Insets(0, 0, 10, 0));

		loginGrid.setAlignment(Pos.CENTER);

		Label userNameL = new Label("Username:");
		usernameT = new TextField();
		loginGrid.add(userNameL, 0, 0);
		loginGrid.add(usernameT, 0, 1);

		Label passwordL = new Label("Password:");
		passwordT = new PasswordField();
		loginGrid.add(passwordL, 0, 3);
		loginGrid.add(passwordT, 0, 4);

		enterB = new Button("Enter");
		loginGrid.add(enterB, 0, 5);

		enterB.setOnAction(e -> {
			LoginEventObj ev = new LoginEventObj(this, usernameT.getText(),
					passwordT.getText());
			if (loginEventListener != null) {
				loginEventListener.ButtonClicked(ev);
			}

		});

	}

	public GridPane getLoginGrid() {
		return loginGrid;
	}

	public Button getEnterB() {
		return enterB;
	}

	public void setLoginEventListener(LoginEventListener loginEventListener) {
		this.loginEventListener = loginEventListener;
	}

}
