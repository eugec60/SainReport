package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Course;
import model.CourseBag;
import model.MajorBag;
import view.MainWindow;


public class MajorController {
	CourseBag cb;
	MajorBag mb;
	ObservableList<Course> courseData;

	public MajorController(MainWindow mainWindow) {
		cb = new CourseBag();
		mb = new MajorBag();
		courseData = FXCollections.observableArrayList(cb.getCourseList());
		
		
		mainWindow.getTabsPane().getMajorPane().getMajorGrid().add(buildCourseTableView(), 1, 2);
		
//		// Course Add Button
//				mainWindow.getTabsPane().getcPane()
//						.setCourseEventListener(new CourseEventListener() {
//
//							@Override
//							public void ButtonClicked(CourseEventObjs ev) {
//								Course course = new Course(ev.getCourseTitle(), ev
//										.getCourseNum(), ev.getCrn(), ev
//										.getClassAdress(), ev.getCredits());
//								courseData.add(course);
//
//							}
//						});
//		
		
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public TableView buildCourseTableView(){
		TableView<Course> facultyDisplayTable = new TableView<Course>();
		facultyDisplayTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		

		TableColumn fNameCol = new TableColumn("Course Title");
		fNameCol.setCellValueFactory(new PropertyValueFactory<Course, String>(
				"courseTitle"));

		TableColumn lnameCol = new TableColumn("Course Number");
		lnameCol.setCellValueFactory(new PropertyValueFactory<Course, String>(
				"courseNum"));

		TableColumn phoneCol = new TableColumn("Crn");
		phoneCol.setCellValueFactory(new PropertyValueFactory<Course, String>(
				"crn"));

		TableColumn addressCol = new TableColumn("Class Address");
		addressCol
				.setCellValueFactory(new PropertyValueFactory<Course, String>(
						"classAdress"));
		
		TableColumn creditsCol = new TableColumn("Credits");
		creditsCol
				.setCellValueFactory(new PropertyValueFactory<Course, Integer>(
						"credits"));

		

		facultyDisplayTable.getColumns().addAll(fNameCol, lnameCol, phoneCol,
				addressCol,creditsCol);

		facultyDisplayTable.setItems(courseData);

		return facultyDisplayTable;
		
	}

}
