package controller;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
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

/**
 * The controller class will let you manipulate Data from the class in the model
 * package and the classes from the view Package to create objects. The
 * controller will also populate the Panes in the View with information from
 * model package.
 * 
 * @author Caio Eugenio
 * @version 1.0
 *
 */
public class Controller {

	CourseBag cb;
	MajorBag mb;
	StudentBag sb;
	FacultyBag fb;
	int i;
	ObservableList courseData, majorData, studentData, facultyData,
			majorIdOList, courseNameOList, courseNeededOList,
			courseTakingOList, courseTakenOList;

	/**
	 * Will construct the controller class with the methods that will manipulate
	 * all the data from model and add it to the view for the user to see. And
	 * also grab data from the view and send it to model to get stored.
	 * 
	 * @param mainWindow
	 *            the Pane that you want to grab all the other panes from
	 */
	public Controller(MainWindow mainWindow) {

		cb = new CourseBag();
		mb = new MajorBag();
		sb = new StudentBag();
		fb = new FacultyBag();
		load(mainWindow);

		// Moves bags into Observale arrayLists
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
		editSain(mainWindow);
		majorAddB(mainWindow);
	}

	// STUDENT TABLE VIEW
	/**
	 * Builds TableView containing student Objects to be sent to the Student
	 * Pane
	 * 
	 * @return TableView for Display in Student Pane
	 */
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
	/**
	 * Builds TableView containing faculty Objects to be sent to the Student
	 * Pane
	 * 
	 * @return TableView for Display in Faculty Pane
	 */
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
	/**
	 * Builds TableView containing Course Objects to be sent to the Course Pane
	 * 
	 * @return TableView for Display in Faculty Pane
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public TableView buildCourseTableView() {
		TableView facultyDisplayTable = new TableView();

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
	/**
	 * This method will get infomation from faculty EventObject and create a
	 * faculty object with it. It will then add that object to facultyList,
	 * facultyData.
	 * 
	 * @param mainWindow
	 *            mainWindow to be displayed
	 */
	public void facultyAddB(MainWindow mainWindow) {
		mainWindow.getTabsPane().getfPane()
				.setFacultyEventListener(new FacultyEventListener() { // Gets
																		// FacultyEventObg

							@SuppressWarnings("unchecked")
							@Override
							public void ButtonClicked(FacultyEventObjs ev) {
								Faculty faculty = new Faculty(ev.getFname(), ev // Creates faculty object when button is pressed

										.getLname(), ev.getPhone(), ev
										.getAdress(), ev.getUsername(), ev
										.getPassword(), ev.getOfficeAdress(),
										ev.getTitle(), ev.getDepartment(), ev
												.getPayScale());

								fb.add(faculty);
								facultyData.add(faculty); // Sends object to facultyList, and// facultyData
							}
						});
	}

	// Major ADD BUTTON
	/**
	 * This method will get ifomation from major EventObject and create a major
	 * object with it. It will then add that object to majorList, majorIdList.
	 * 
	 * @param mainWindow
	 *            mainWindow to be displayed
	 */
	public void majorAddB(MainWindow mainWindow) {

		mainWindow.getTabsPane().getMajorPane()
				.setMajorEventListerner(new MajorEventListener() { // Gets major Event Object

							@Override
							public void ButtonClicked(MajorEventObj ev) {
								Major major = new Major(ev.getMajorName(), ev
										.getCourseRequiredM()); // Creates majorObject

								mb.getMajorList().add(major); // updates list with new major Object
								majorData.add(major);
								majorIdOList.add(ev.getMajorName());

							}

						});

	}

	/**
	 * This method will search through a majorBag and find the major name that
	 * matches the parameter. It will then copy that majors CourseRequired to
	 * graduate and copy it to a students courseNeeded array.
	 * 
	 * @param student student who want their array to 
	 * @param major
	 */
	@SuppressWarnings("unchecked")
	public void copyMajortoCoursesNeeded(Student student, String major) {
		for (int i = 0; i < mb.getMajorList().size(); i++) {
			if (mb.getMajorList().get(i).getMajorName().equals(major)) {
				student.setCoursesToGraduate((ArrayList<String>) mb
						.getMajorList().get(i).getCourseRequired());
			}
		}
	}

	// Student Add Button
	/**
	 * This method will get infomation from student Event Object and create a student
	 * object with it. It will then populate the students courses needed list with the
	 *  majors arrayList and send the student object to the appropriate arrayLists.
	 * @param mainWindow mainWindow to be displayed
	 */
	public void studentAddB(MainWindow mainWindow) {
		mainWindow.getTabsPane().getsPane()
				.setStudentEventListener(new StudentEventListener() { //Gets Student Event Object

					@SuppressWarnings("unchecked")
					@Override
					public void buttonClicked(StudentEventObjs ev) {
						Student student = new Student(ev.getFname(), ev
								.getLname(), ev.getAdress(), ev.getPhone(), ev //creates student object
								.getUsername(), ev.getPassword(), ev.getGpa(),
								ev.getMajor(), ev.getCredits());

						copyMajortoCoursesNeeded(student, student.getMajor());//populates courses needed
						sb.add(student);
						studentData.add(student); //sends to student bag and student observable list.

					}
				});

	}

	// Course Add Button
	/**
	 * This method will get infomation from course EventObject and create a course
	 * object with it. It will then add that object to courseList, courseList.
	 * @param mainWindow mainWindow to be displayed
	 */
	public void courseAddB(MainWindow mainWindow) {

		mainWindow.getTabsPane().getcPane()
				.setCourseEventListener(new CourseEventListener() {// gets course event object

					@SuppressWarnings("unchecked")
					@Override
					public void ButtonClicked(CourseEventObjs ev) {
						Course course = new Course(ev.getCourseTitle(), ev
								.getCourseNum(), ev.getCrn(), ev	// Creates course Object
								.getClassAdress(), ev.getCredits());
						cb.add(course);
						courseData.add(course);
						courseNameOList.add(course.getCourseTitle()); // Sends objects to list

					}
				});

	}

	/**
	 * Login method will get info from the username and password textfield and 
	 * search through facultyBag and studentBag for appriate users. If it matches
	 * then it will set the view for the particular user.
	 * @param mainWindow Pane to be Displayed
	 */
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
							//Adds Course Tab
							mainWindow
									.getTabsPane()
									.getTabPanes()
									.getTabs()
									.addAll(mainWindow.getTabsPane()
											.getCourseTab());
							//Adds Student Tab
							mainWindow
									.getTabsPane()
									.getTabPanes()
									.getTabs()
									.addAll(mainWindow.getTabsPane()
											.getStudentTab());
							//Adds FacultyTab
							mainWindow
									.getTabsPane()
									.getTabPanes()
									.getTabs()
									.addAll(mainWindow.getTabsPane()
											.getFacultyTab());
							//Adds MajorTab
							mainWindow
									.getTabsPane()
									.getTabPanes()
									.getTabs()
									.addAll(mainWindow.getTabsPane()
											.getMajorTab());
							//Adds Find Student Tab
							mainWindow
									.getTabsPane()
									.getTabPanes()
									.getTabs()
									.addAll(mainWindow.getTabsPane()
											.getFindStudentTab());
							// Adds Sain Tab
							mainWindow
									.getTabsPane()
									.getTabPanes()
									.getTabs()
									.addAll(mainWindow.getTabsPane()
											.getSainTab());
							//Adds Edit Sain Tab
							mainWindow
									.getTabsPane()
									.getTabPanes()
									.getTabs()
									.addAll(mainWindow.getTabsPane()
											.getEditStudentSainTab());
							
							
						} else if (sb.studentLogin(name, password) != null) {

							mainWindow.getTabsPane().getTabPanes().getTabs()
									.remove(0);
							// Adds Sain Tab
							mainWindow
									.getTabsPane()
									.getTabPanes()
									.getTabs()
									.addAll(mainWindow.getTabsPane()
											.getSainTab());
							//Adds What If Tab
							mainWindow
									.getTabsPane()
									.getTabPanes()
									.getTabs()
									.addAll(mainWindow.getTabsPane()
											.getWhatIfTab());
						} else if (fb.facultyLogin(name, password) != null) {
							mainWindow.getTabsPane().getTabPanes().getTabs()
									.remove(0);
							//Add Find Student Tab
							mainWindow
									.getTabsPane()
									.getTabPanes()
									.getTabs()
									.addAll(mainWindow.getTabsPane()
											.getFindStudentTab());
							
							// Adds Sain Tab
							mainWindow
									.getTabsPane()
									.getTabPanes()
									.getTabs()
									.addAll(mainWindow.getTabsPane()
											.getSainTab());
						} else {
							// NEW WINDOW POPS UP SAYING INVALID ADDRESS
							HBox h1 = new HBox();
							h1.setAlignment(Pos.CENTER);
							Label lb1 = new Label("INVALID USERNAME OR PASSWORD");
							h1.getChildren().add(lb1);
							Stage secondaryStage = new Stage();
							secondaryStage.setScene(new Scene(h1, 200,100));
							secondaryStage.show();

						}

					}

				});

	}

	// FIND STUDENT
	/**
	 * This method will search through Student Bag and find a students ID
	 * and display their info in a table view
	 * @param mainWindow mainWindow Pane to be Displayed
	 */
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
	/**
	 * This method will search through studentBag for student then display their sain
	 * report.
	 * @param mainWindow mainWindow Pane to be Displayed
	 */
	public void generateSain(MainWindow mainWindow) {
		mainWindow.getTabsPane().getSainPane()
				.setStudentEventListener(new StudentEventListener() {

					@SuppressWarnings("unchecked")
					@Override
					public void buttonClicked(StudentEventObjs event) {
						int id = event.getId();
						System.out.println(id);

						for (i = 0; i < sb.getStudentList().size(); i++) {
							if (sb.getStudentList().get(i).getId() == id) {

								courseNeededOList = FXCollections
										.observableArrayList(sb
												.getStudentList().get(i)
												.getCoursesToGraduate());

								courseTakingOList = FXCollections
										.observableArrayList(sb
												.getStudentList().get(i)
												.getCurrentCourses());

								courseTakenOList = FXCollections
										.observableArrayList(sb
												.getStudentList().get(i)
												.getCoursesTaken());

								mainWindow.getTabsPane().getSainPane()
										.getCoursesNeededList()
										.setItems(courseNeededOList);

								mainWindow.getTabsPane().getSainPane()
										.getCoursesTakingList()
										.setItems(courseTakingOList);

								mainWindow.getTabsPane().getSainPane()
										.getCoursesTakenList()
										.setItems(courseTakenOList);
								mainWindow
										.getTabsPane()
										.getSainPane()
										.getNameL()
										.setText(
												sb.getStudentList().get(i)
														.getFname());
								mainWindow
										.getTabsPane()
										.getSainPane()
										.getMajorL()
										.setText(
												sb.getStudentList().get(i)
														.getMajor());
								mainWindow
										.getTabsPane()
										.getSainPane()
										.getIdL()
										.setText(
												Integer.toString((sb
														.getStudentList()
														.get(i).getId())));
							}
						}
					}
				});
	}

	/**
	 * Will save all the Bags to a binary file so that it can be loaded later
	 * @param mainWindow mainWindow Pane to be Displayed
	 */
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
	/**
	 * Will load from binary file and populate all the bag with the proper objects
	 * @param mainWindow mainWindow Pane to be Displayed
	 */
	public void load(MainWindow mainWindow) {

		fb.readID();
		sb.read();
		fb.read();
		cb.read();
		mb.read();

	}
	
	/**
	 * Populates all observable items in the program with the 
	 * right information
	 * @param mainWindow mainWindow Pane to be Displayed
	 */
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
		
		mainWindow.getTabsPane().getWhatIfPane().getMajorC().setItems(majorIdOList);

	}

	/**
	 * Will create an editable  version of the Sain report that only the Admin can see.
	 * The admin will be able to move the courses from all each of the students arrayList.
	 * @param mainWindow mainWindow Pane to be Displayed
	 */
	// SAIN COURSE EDITOR
	public void editSain(MainWindow mainWindow) {

		mainWindow.getTabsPane().getEditStudentSainPane()
				.setStudentEventListener(new StudentEventListener() {

					@SuppressWarnings("unchecked")
					@Override
					public void buttonClicked(StudentEventObjs ev) {
						int id = ev.getId();
						System.out.println(id);

						for (int a = 0; a < sb.getStudentList().size(); a++) {
							if (sb.getStudentList().get(a).getId() == id) {

								courseNeededOList = FXCollections.observableArrayList(sb.getStudentList().get(a).getCoursesToGraduate());
								courseTakingOList = FXCollections.observableArrayList(sb.getStudentList().get(a).getCurrentCourses());
								courseTakenOList = FXCollections.observableArrayList(sb.getStudentList().get(a).getCoursesTaken());

								mainWindow.getTabsPane().getEditStudentSainPane().getCoursesNeededList().setItems(courseNeededOList);
								mainWindow.getTabsPane().getEditStudentSainPane().getCoursesTakingList().setItems(courseTakingOList);	
								mainWindow.getTabsPane().getEditStudentSainPane().getCoursesTakenList().setItems(courseTakenOList);
								mainWindow.getTabsPane().getEditStudentSainPane().getNameL().setText(sb.getStudentList().get(a).getFname());
								mainWindow.getTabsPane().getEditStudentSainPane().getMajorL().setText(sb.getStudentList().get(a).getMajor());
								mainWindow.getTabsPane().getEditStudentSainPane().getIdL().setText(Integer.toString((sb.getStudentList().get(a).getId())));
								System.out.println(a);
								i =a;
								
							}
						}
						
						
						// MOVE COURSE FROM COURSESTAKEN >>>> COURSES TAKING
						mainWindow.getTabsPane().getEditStudentSainPane().getMoveRight1().setOnAction(e -> {

											if (mainWindow.getTabsPane().getEditStudentSainPane().getCoursesTakenList().getSelectionModel().getSelectedItem() != null) {
												courseTakingOList.add(mainWindow.getTabsPane().getEditStudentSainPane().getCoursesTakenList().getSelectionModel().getSelectedItem());
												sb.getStudentList().get((i)).getCurrentCourses().add((String) mainWindow.getTabsPane().getEditStudentSainPane().getCoursesTakenList().getSelectionModel().getSelectedItem());
												sb.searchAndRemove(sb.getStudentList().get(i).getCoursesTaken(),(String) mainWindow.getTabsPane().getEditStudentSainPane().getCoursesTakenList().getSelectionModel().getSelectedItem());

												courseTakenOList.remove(mainWindow.getTabsPane().getEditStudentSainPane().getCoursesTakenList().getSelectionModel().getSelectedItem());

											}
										});
						//MOVE COURSE FROM COURSES TAKING >>> COURSES NEEDED
						mainWindow.getTabsPane().getEditStudentSainPane().getMoveRight2().setOnAction(e -> {
											if (mainWindow.getTabsPane().getEditStudentSainPane().getCoursesTakingList().getSelectionModel().getSelectedItem() != null) {
												courseNeededOList.add(mainWindow.getTabsPane().getEditStudentSainPane().getCoursesTakingList().getSelectionModel().getSelectedItem());
												sb.getStudentList().get(i).getCoursesToGraduate().add((String) mainWindow.getTabsPane().getEditStudentSainPane().getCoursesTakingList().getSelectionModel().getSelectedItem());
												sb.searchAndRemove(sb.getStudentList().get(i).getCurrentCourses(),(String) mainWindow.getTabsPane().getEditStudentSainPane().getCoursesTakingList().getSelectionModel().getSelectedItem());
												courseTakingOList.remove(mainWindow.getTabsPane().getEditStudentSainPane().getCoursesTakingList().getSelectionModel().getSelectedItem());

											}

										});
						//MOVE FROM COURSE TAKING >>>>> COURSES TAKEN
						mainWindow.getTabsPane().getEditStudentSainPane().getMoveLeft1().setOnAction(e -> {
											if (mainWindow.getTabsPane().getEditStudentSainPane().getCoursesTakingList().getSelectionModel().getSelectedItem() != null) {
												courseTakenOList.add(mainWindow.getTabsPane().getEditStudentSainPane().getCoursesTakingList().getSelectionModel().getSelectedItem());
												sb.getStudentList().get(i).getCoursesTaken().add((String) mainWindow.getTabsPane().getEditStudentSainPane().getCoursesTakingList().getSelectionModel().getSelectedItem());
												sb.searchAndRemove(sb.getStudentList().get(i).getCurrentCourses(),(String) mainWindow.getTabsPane().getEditStudentSainPane().getCoursesTakingList().getSelectionModel().getSelectedItem());
												courseTakingOList.remove(mainWindow.getTabsPane().getEditStudentSainPane().getCoursesTakingList().getSelectionModel().getSelectedItem());

											}

										});
						//MOVE FROM COURSES NEEDED TO  COURSES TAKING
						mainWindow.getTabsPane().getEditStudentSainPane().getMoveLeft2().setOnAction(e -> {	
							if (mainWindow.getTabsPane().getEditStudentSainPane().getCoursesNeededList().getSelectionModel().getSelectedItem() != null) {
												courseTakingOList.add(mainWindow.getTabsPane().getEditStudentSainPane().getCoursesNeededList().getSelectionModel().getSelectedItem());
												sb.getStudentList().get(i).getCurrentCourses().add((String) mainWindow.getTabsPane().getEditStudentSainPane().getCoursesNeededList().getSelectionModel().getSelectedItem());
												sb.searchAndRemove(sb.getStudentList().get(i).getCoursesToGraduate(),(String) mainWindow.getTabsPane().getEditStudentSainPane().getCoursesNeededList().getSelectionModel().getSelectedItem());
												courseNeededOList.remove(mainWindow.getTabsPane().getEditStudentSainPane().getCoursesNeededList().getSelectionModel().getSelectedItem());

											}

										});
					}
				});

	}

}
