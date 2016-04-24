package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class LoginPane {

	private GridPane loginGrid;
	private TextField usernameT, passwordT;

	public LoginPane() {
		loginGrid = new GridPane();
		loginGrid.setHgap(10);
		loginGrid.setVgap(10);
		loginGrid.setPadding(new Insets(0,0,10,0));

		loginGrid.setAlignment(Pos.CENTER);

		Label userNameL = new Label("Username:");
		usernameT = new TextField();
		loginGrid.add(userNameL, 0, 0);
		loginGrid.add(usernameT, 0, 1);

		Label passwordL = new Label("Password:");
		passwordT = new TextField();
		loginGrid.add(passwordL, 0, 3);
		loginGrid.add(passwordT, 0, 4);

	}

	public GridPane getLoginGrid() {
		return loginGrid;
	}

}
