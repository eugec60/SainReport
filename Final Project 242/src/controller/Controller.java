package controller;

import eventListnersAndObjects.CourseEventListener;
import eventListnersAndObjects.CourseEventObjs;
import eventListnersAndObjects.FacultyEventListener;
import eventListnersAndObjects.FacultyEventObjs;
import eventListnersAndObjects.MajorEventListener;
import eventListnersAndObjects.MajorEventObj;
import eventListnersAndObjects.StudentEventListener;
import eventListnersAndObjects.StudentEventObjs;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Course;
import model.CourseBag;
import model.Faculty;
import model.FacultyBag;
import model.MajorBag;
import model.Student;
import model.StudentBag;
import view.MainWindow;

public class Controller {

	CourseBag cb;
	MajorBag mb;
	StudentBag sb;
	FacultyBag fb;
	ObservableList courseData, majorData, studentData, facultyData;

	public Controller(MainWindow mainWindow) {
		cb = new CourseBag();
		mb = new MajorBag();
		sb = new StudentBag();
		fb = new FacultyBag();
		
		courseData = FXCollections.observableArrayList(cb.getCourseList());
		majorData = FXCollections.observableArrayList(cb.getCourseList());
		studentData = FXCollections.observableArrayList(sb.getStudentList());
		facultyData = FXCollections.observableArrayList(fb.getFacultyList());
		
		
	
		
		mainWindow.getTabsPane().getfPane()
				.setFacultyDisplayTable(buildFacultyTable());
		mainWindow.getTabsPane().getMajorPane().setCourseDisplayTable(buildCourseTableView());
		mainWindow.getTabsPane().getsPane()
				.setStudentDisplayTable(buildStudentTable());
		mainWindow.getTabsPane().getcPane().setCourseDisplayTable(buildCourseTableView());

		facultyAddB(mainWindow);
		studentAddB(mainWindow);
		courseAddB(mainWindow);
	}

	// STUDENT TABLE VIEW

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public TableView buildStudentTable() {

		TableView studentDisplayTable = new TableView();

		TableColumn fNameCol = new TableColumn("First Name");
		fNameCol.setCellValueFactory(new PropertyValueFactory<Student, String>(
				"fname"));

		TableColumn lnameCol = new TableColumn("Last Name");
		lnameCol.setCellValueFactory(new PropertyValueFactory<Student, String>(
				"lname"));

		TableColumn phoneCol = new TableColumn("Phone");
		phoneCol.setCellValueFactory(new PropertyValueFactory<Student, String>(
				"phone"));

		TableColumn addressCol = new TableColumn("Address");
		addressCol
				.setCellValueFactory(new PropertyValueFactory<Student, String>(
						"adress"));

		TableColumn idCol = new TableColumn("Id");
		idCol.setCellValueFactory(new PropertyValueFactory<Student, String>(
				"id"));

		TableColumn majorCol = new TableColumn("Major");
		majorCol.setCellValueFactory(new PropertyValueFactory<Student, String>(
				"major"));

		TableColumn gpaCol = new TableColumn("Gpa");
		gpaCol.setCellValueFactory(new PropertyValueFactory<Student, String>(
				"gpa"));

		TableColumn creditsCol = new TableColumn("Credits");
		creditsCol
				.setCellValueFactory(new PropertyValueFactory<Student, String>(
						"credits"));

		studentDisplayTable.getColumns().addAll(fNameCol, lnameCol, phoneCol,
				addressCol, idCol, majorCol, gpaCol, creditsCol);

		studentDisplayTable.setItems(studentData);

		return studentDisplayTable;

	}

	// FACULTY TABLE VIEW

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

	// COURSE TABLE VIEW

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public TableView buildCourseTableView() {
		TableView facultyDisplayTable = new TableView();
		facultyDisplayTable.getSelectionModel().setSelectionMode(
				SelectionMode.MULTIPLE);

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
				addressCol, creditsCol);

		facultyDisplayTable.setItems(courseData);
		
		

		return facultyDisplayTable;

	}

	// Faculty Add Button
	public void facultyAddB(MainWindow mainWindow) {
		mainWindow.getTabsPane().getfPane()
				.setFacultyEventListener(new FacultyEventListener() {

					@SuppressWarnings("unchecked")
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

	// Student Add Button
	public void studentAddB(MainWindow mainWindow) {
		mainWindow.getTabsPane().getsPane()
				.setStudentEventListener(new StudentEventListener() {

					@SuppressWarnings("unchecked")
					@Override
					public void buttonClicked(StudentEventObjs ev) {
						Student student = new Student(ev.getFname(), ev
								.getLname(), ev.getAdress(), ev.getPhone(), ev
								.getId(), ev.getGpa(), ev.getMajor(), ev
								.getCredits());

						studentData.add(student);

					}
				});

	}
	
	//Course Add Button
	
	public void courseAddB(MainWindow mainWindow){
		
		mainWindow.getTabsPane().getcPane().setCourseEventListener(new CourseEventListener() {

			@SuppressWarnings("unchecked")
			@Override
			public void ButtonClicked(CourseEventObjs ev) {
				Course course = new Course(ev.getCourseTitle(), ev
						.getCourseNum(), ev.getCrn(), ev
						.getClassAdress(), ev.getCredits());
				courseData.add(course);

			}
		});
		
	}
	
	public void majorAddB(MainWindow mainWindow){
		
		mainWindow.getTabsPane().getMajorPane().setMajorEventListerner(new MajorEventListener(){

			@Override
			public void ButtonClicked(MajorEventObj ev) {
				//String Crn = ev.getCrn();
				
			}
			
		}); 		
	}
}
