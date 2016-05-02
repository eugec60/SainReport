package controller;

import eventListnersAndObjects.FacultyEventListener;
import eventListnersAndObjects.FacultyEventObjs;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Faculty;
import model.FacultyBag;
import model.Faculty;
import view.MainWindow;

public class FacultyController {
	FacultyBag fb;
	ObservableList<Faculty> facultyData;

	@SuppressWarnings("unchecked")
	public FacultyController(MainWindow mainWindow) {
		fb = new FacultyBag();
		facultyData = FXCollections.observableArrayList(fb.getFacultyList());

		mainWindow.getTabsPane().getfPane()
				.setFacultyDisplayTable(buildFacultyTable());

		// Faculty Add Button
		mainWindow.getTabsPane().getfPane()
				.setFacultyEventListener(new FacultyEventListener() {

					@Override
					public void ButtonClicked(FacultyEventObjs ev) {
						Faculty faculty = new Faculty(ev.getFname(), ev
								.getLname(), ev.getPhone(), ev.getAdress(), ev
								.getOfficeAdress(), ev.getTitle(), ev
								.getDepartment(), ev.getPayScale());

						facultyData.add(faculty);
					}
				});

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public TableView buildFacultyTable() {

		TableView facultyDisplayTable = new TableView();

		TableColumn fNameCol = new TableColumn("First Name");
		fNameCol.setCellValueFactory(new PropertyValueFactory<Faculty, String>(
				"fname"));

		TableColumn lnameCol = new TableColumn("Last Name");
		lnameCol.setCellValueFactory(new PropertyValueFactory<Faculty, String>(
				"lname"));

		TableColumn phoneCol = new TableColumn("Phone");
		phoneCol.setCellValueFactory(new PropertyValueFactory<Faculty, String>(
				"phone"));

		TableColumn addressCol = new TableColumn("Address");
		addressCol
				.setCellValueFactory(new PropertyValueFactory<Faculty, String>(
						"adress"));

		TableColumn oAddressCol = new TableColumn("Office Ad.");
		oAddressCol
				.setCellValueFactory(new PropertyValueFactory<Faculty, String>(
						"officeAdress"));

		TableColumn titleCol = new TableColumn("Title");
		titleCol.setCellValueFactory(new PropertyValueFactory<Faculty, String>(
				"title"));

		TableColumn departmentCol = new TableColumn("Department");
		departmentCol
				.setCellValueFactory(new PropertyValueFactory<Faculty, String>(
						"department"));

		TableColumn payScaleCol = new TableColumn("Pay");
		payScaleCol
				.setCellValueFactory(new PropertyValueFactory<Faculty, String>(
						"payScale"));

		facultyDisplayTable.getColumns().addAll(fNameCol, lnameCol, phoneCol,
				addressCol, oAddressCol, titleCol, departmentCol, payScaleCol);

		facultyDisplayTable.setItems(facultyData);

		return facultyDisplayTable;

	}

}
