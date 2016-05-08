package controller;

import java.util.ArrayList;

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
import model.Major;
import model.MajorBag;
import model.Student;
import model.StudentBag;
import view.MainWindow;
import eventListnersAndObjects.CourseEventListener;
import eventListnersAndObjects.CourseEventObjs;
import eventListnersAndObjects.FacultyEventListener;
import eventListnersAndObjects.FacultyEventObjs;
import eventListnersAndObjects.LoginEventListener;
import eventListnersAndObjects.LoginEventObj;
import eventListnersAndObjects.MajorEventListener;
import eventListnersAndObjects.MajorEventObj;
import eventListnersAndObjects.StudentEventListener;
import eventListnersAndObjects.StudentEventObjs;

public class Controller {

	CourseBag cb;
	MajorBag mb;
	StudentBag sb;
	FacultyBag fb;
	ObservableList courseData, majorData, studentData, facultyData,
			majorIdOList, courseNameOList, courseNeededOList,
			courseTakingOList, courseTakenOList;

	public Controller(MainWindow mainWindow) {

		cb = new CourseBag();
		mb = new MajorBag();
		sb = new StudentBag();
		fb = new FacultyBag();
		load(mainWindow);
		
		System.out.println(sb.getStudentList().get(0));

		courseData = FXCollections.observableArrayList(cb.getCourseList());

		majorData = FXCollections.observableArrayList(mb.getMajorList());
		studentData = FXCollections.observableArrayList(sb.getStudentList());
		facultyData = FXCollections.observableArrayList(fb.getFacultyList());

		populateList(mainWindow);

		login(mainWindow);
		facultyAddB(mainWindow);
		studentAddB(mainWindow);
		courseAddB(mainWindow);
		findStudent(mainWindow);
		save(mainWindow);
		generateSain(mainWindow);
		// editSain(mainWindow);
		majorAddB(mainWindow);
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

		TableColumn idCol = new TableColumn("Id");
		idCol.setCellValueFactory(new PropertyValueFactory<Faculty, String>(
				"id"));

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
				addressCol, idCol, oAddressCol, titleCol, departmentCol,
				payScaleCol);

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
								.getUsername(), ev.getPassword(), ev
								.getOfficeAdress(), ev.getTitle(), ev
								.getDepartment(), ev.getPayScale());

						fb.getFacultyList().add(faculty);

						facultyData.add(faculty);
					}
				});
	}

	// Major ADD BUTTON

	public void majorAddB(MainWindow mainWindow) {

		mainWindow.getTabsPane().getMajorPane()
				.setMajorEventListerner(new MajorEventListener() {

					@Override
					public void ButtonClicked(MajorEventObj ev) {
						Major major = new Major(ev.getMajorName(), ev
								.getCourseRequiredM());

						mb.getMajorList().add(major);
						majorData.add(major);
						majorIdOList.add(ev.getMajorName());

					}

				});

	}

	public void copyMajortoCoursesNeeded(Student student, String major) {
		for (int i = 0; i < mb.getMajorList().size(); i++) {
			if (mb.getMajorList().get(i).getMajorName().equals(major)) {
				student.setCoursesToGraduate((ArrayList<String>) mb
						.getMajorList().get(i).getCourseRequired());
			}
		}
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
								.getUsername(), ev.getPassword(), ev.getGpa(),
								ev.getMajor(), ev.getCredits());

						copyMajortoCoursesNeeded(student, student.getMajor());
						System.out.println(student);

						sb.add(student);
						studentData.add(student);

					}
				});

	}

	// Course Add Button

	public void courseAddB(MainWindow mainWindow) {

		mainWindow.getTabsPane().getcPane()
				.setCourseEventListener(new CourseEventListener() {

					@SuppressWarnings("unchecked")
					@Override
					public void ButtonClicked(CourseEventObjs ev) {
						Course course = new Course(ev.getCourseTitle(), ev
								.getCourseNum(), ev.getCrn(), ev
								.getClassAdress(), ev.getCredits());
						cb.getCourseList().add(course);
						courseData.add(course);
						courseNameOList.add(course.getCourseTitle());

					}
				});

	}

	// public void majorAddB(MainWindow mainWindow){
	//
	// mainWindow.getTabsPane().getMajorPane().setMajorEventListerner(new
	// MajorEventListener(){
	//
	// @Override
	// public void ButtonClicked(MajorEventObj ev) {
	// //String Crn = ev.getCrn();
	//
	// }
	//
	// });
	// }

	public void login(MainWindow mainWindow) {

		mainWindow.getTabsPane().getLoginPane()
				.setLoginEventListener(new LoginEventListener() {

					@Override
					public void ButtonClicked(LoginEventObj ev) {

						String name = ev.getName();
						String password = ev.getPassword();
						if (name.equals("Admin") && password.equals("Password")) {
							mainWindow.getTabsPane().getTabPanes().getTabs()
									.remove(0);
							mainWindow
									.getTabsPane()
									.getTabPanes()
									.getTabs()
									.addAll(mainWindow.getTabsPane()
											.getCourseTab());
							mainWindow
									.getTabsPane()
									.getTabPanes()
									.getTabs()
									.addAll(mainWindow.getTabsPane()
											.getStudentTab());
							mainWindow
									.getTabsPane()
									.getTabPanes()
									.getTabs()
									.addAll(mainWindow.getTabsPane()
											.getFacultyTab());
							mainWindow
									.getTabsPane()
									.getTabPanes()
									.getTabs()
									.addAll(mainWindow.getTabsPane()
											.getMajorTab());
							mainWindow
									.getTabsPane()
									.getTabPanes()
									.getTabs()
									.addAll(mainWindow.getTabsPane()
											.getFindStudentTab());

							mainWindow
									.getTabsPane()
									.getTabPanes()
									.getTabs()
									.addAll(mainWindow.getTabsPane()
											.getSainTab());

							mainWindow
									.getTabsPane()
									.getTabPanes()
									.getTabs()
									.addAll(mainWindow.getTabsPane()
											.getEditStudentSainTab());
						} else if (sb.findStudent(name,password) != null) {

							mainWindow.getTabsPane().getTabPanes().getTabs()
									.remove(0);
							mainWindow
									.getTabsPane()
									.getTabPanes()
									.getTabs()
									.addAll(mainWindow.getTabsPane()
											.getSainTab());
							mainWindow
									.getTabsPane()
									.getTabPanes()
									.getTabs()
									.addAll(mainWindow.getTabsPane()
											.getWhatIfTab());
						} else if (fb.findFacutly(name,password) != null) {
							mainWindow.getTabsPane().getTabPanes().getTabs()
									.remove(0);
							mainWindow
									.getTabsPane()
									.getTabPanes()
									.getTabs()
									.addAll(mainWindow.getTabsPane()
											.getFacultyTab());
						} else{
							
						}
							
					}

				});

	}

	// FIND STUDENT
	public void findStudent(MainWindow mainWindow) {

		mainWindow.getTabsPane().getFindStudentPane()
				.setStudentDisplayTable(buildStudentTable());
		mainWindow.getTabsPane().getFindStudentPane()
				.setStudentEventListener(new StudentEventListener() {

					@SuppressWarnings("unchecked")
					@Override
					public void buttonClicked(StudentEventObjs ev) {
						int id = ev.getId();

						Student s1 = sb.find(id);
						ArrayList<Student> tempStu = new ArrayList<>();
						tempStu.add(s1);

						ObservableList<Student> tempStuO = FXCollections
								.observableArrayList(tempStu);
						mainWindow.getTabsPane().getFindStudentPane()
								.getStudentDisplayTable().setItems(tempStuO);

					}
				});

	}

	// GENERATE SAIN
	public void generateSain(MainWindow mainWindow) {
		mainWindow.getTabsPane().getSainPane()
				.setStudentEventListener(new StudentEventListener() {

					@SuppressWarnings("unchecked")
					@Override
					public void buttonClicked(StudentEventObjs event) {
						int id = event.getId();
						System.out.println(id);

						for (int i = 0; i < sb.getStudentList().size(); i++) {
							if (sb.getStudentList().get(i).getId() == id) {
								System.out.println(sb.getStudentList().get(i)
										.getCoursesToGraduate());
								courseNeededOList = FXCollections
										.observableArrayList(sb
												.getStudentList().get(i)
												.getCoursesToGraduate());
							}
							mainWindow.getTabsPane().getSainPane()
									.getCoursesNeededList()
									.setItems(courseNeededOList);

						}

					}
				});
	}

	public void save(MainWindow mainWindow) {

		mainWindow.getMenu().setLoginEventListener(new LoginEventListener() {

			@Override
			public void ButtonClicked(LoginEventObj ev) {
				fb.saveID();
				sb.save();
				fb.save();
				cb.save();
				mb.save();

			}

		});

	}

	public void load(MainWindow mainWindow) {

		fb.readID();
		sb.read();
		fb.read();
		cb.read();
		mb.read();

	}

	public void populateList(MainWindow mainWindow) {
		mainWindow.getTabsPane().getfPane()
				.setFacultyDisplayTable(buildFacultyTable());
		mainWindow.getTabsPane().getsPane()
				.setStudentDisplayTable(buildStudentTable());
		mainWindow.getTabsPane().getcPane()
				.setCourseDisplayTable(buildCourseTableView());

		// POPULATE COURSE LIST IN MAJOR PANE
		ArrayList<String> courseNameList = new ArrayList();

		for (int i = 0; i < cb.getCourseList().size(); i++) {
			courseNameList.add(cb.getCourseList().get(i).getCourseTitle());

		}

		courseNameOList = FXCollections.observableArrayList(courseNameList);
		mainWindow.getTabsPane().getMajorPane().getCourseListView()
				.setItems(courseNameOList);

		// UPDATE MAJOR ID COMBO BOX IN STUDENT PANE
		ArrayList<String> majorIdList = new ArrayList<String>();
		for (int i = 0; i < mb.getMajorList().size(); i++) {
			majorIdList.add(mb.getMajorList().get(i).getMajorName());
		}
		majorIdOList = FXCollections.observableArrayList(majorIdList);
		mainWindow.getTabsPane().getMajorPane().getMajorListView()
				.setItems(majorIdOList);

		mainWindow.getTabsPane().getsPane().getMajorCombo()
				.setItems(majorIdOList);

	}

	// // SAIN COURSE EDITOR
	// public void editSain(MainWindow mainWindow){
	//
	// mainWindow.getTabsPane().getEditStudentSainPane()
	// .setStudentEventListener(new StudentEventListener() {
	//
	// @SuppressWarnings("unchecked")
	// @Override
	// public void buttonClicked(StudentEventObjs ev) {
	// int id = ev.getId();
	// System.out.println(id);
	//
	//
	// for (int i = 0; i<sb.getStudentList().size();i++){
	// if(sb.getStudentList().get(i).getId()==id){
	//
	// courseNeededOList =
	// FXCollections.observableArrayList(sb.getStudentList().get(i).getCoursesToGraduate());
	// courseTakingOList =
	// FXCollections.observableArrayList(sb.getStudentList().get(i).getCurrentCourses());
	// courseTakenOList =
	// FXCollections.observableArrayList(sb.getStudentList().get(i).getCoursesTaken());
	//
	// mainWindow.getTabsPane().getEditStudentSainPane().getCoursesNeededList().setItems(courseNeededOList);
	// mainWindow.getTabsPane().getEditStudentSainPane().getCoursesTakingList().setItems(courseTakingOList);
	// mainWindow.getTabsPane().getEditStudentSainPane().getCoursesTakenList().setItems(courseTakenOList);
	// //mainWindow.getTabsPane().getEditStudentSainPane().getNameL().setText(sb.getStudentList().get(i).getFname());
	// //mainWindow.getTabsPane().getEditStudentSainPane().getMajorL().setText(sb.getStudentList().get(i).getMajor());
	// //mainWindow.getTabsPane().getEditStudentSainPane().getIdL().setText(Integer.toString((sb.getStudentList().get(i).getId())));
	// }
	//
	// }
	//
	// mainWindow.getTabsPane().getEditStudentSainPane()
	// .setCourseEventListener(new CourseEventListener(){
	//
	// @Override
	// public void ButtonClicked(CourseEventObjs ev) {
	// mainWindow.getTabsPane().getEditStudentSainPane().getCoursesTakenList().getSelectionModel().getSelectedItem().remove()
	//
	// }
	//
	// });
	//
	//
	//
	//
	// }
	// });

	// }

}
