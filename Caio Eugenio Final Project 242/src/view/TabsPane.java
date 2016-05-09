package view;

import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;

/**
 * This class will serve as the Facade Class that contains all Panes. Using this
 * class will allow the controller to choose which Panes show up depending on
 * the user that loged in. All panes are added to tabs. The tabs can then be
 * switched about.
 * 
 * @author Caio Eugenio
 * @version 1.0
 *
 */
public class TabsPane {
	private TabPane tabPanes;
	StudentPane sPane;
	FacultyPane fPane;
	CoursePane cPane;
	SainPane sainPane;
	LoginPane loginPane;
	WhatIfPane whatIfPane;
	MajorPane majorPane;
	EditStudentSainPane editStudentSainPane;
	FindStudentPane findStudentPane;

	Tab loginTab, studentTab, facultyTab, courseTab, textbookTab, sainTab,
			whatIfTab, majorTab, findStudentTab, editStudentSainTab;

	/**
	 * Will build a Tab Pane that contains all the other Panes. Panes will be
	 * added to Tabs. The controller will choose which tabs are displayed
	 * depending of who logged in.
	 */
	public TabsPane() {

		tabPanes = new TabPane();
		tabPanes.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);

		// STUDENT TAB
		studentTab = new Tab("Student");
		sPane = new StudentPane();
		studentTab.setContent(sPane.getStudentPane());

		// FacultyTab
		facultyTab = new Tab("Faculty");
		fPane = new FacultyPane();
		facultyTab.setContent(fPane.getFacultyPane());

		// Course Tab
		courseTab = new Tab("Course");
		cPane = new CoursePane();
		courseTab.setContent(cPane.getCoursePane());

		// Sain Tab
		sainTab = new Tab("SAIN");
		sainPane = new SainPane();
		sainTab.setContent(sainPane.getSainGrid());

		// WhatIf TAB
		whatIfTab = new Tab("What If");
		whatIfPane = new WhatIfPane();
		whatIfTab.setContent(whatIfPane.getWhatIfPane());

		//LOGIN TAB
		loginTab = new Tab("Login");
		loginPane = new LoginPane();
		loginTab.setContent(loginPane.getLoginGrid());

		//MAJOR TAB
		majorTab = new Tab("Major");
		majorPane = new MajorPane();
		majorTab.setContent(majorPane.getMajorGrid());

		//FIND STUDENT TAB
		findStudentTab = new Tab("Find Student");
		findStudentPane = new FindStudentPane();
		findStudentTab.setContent(findStudentPane.getFindStudentGrid());

		//EDIT STUDENT TAB
		editStudentSainTab = new Tab("EDIT SAIN");
		editStudentSainPane = new EditStudentSainPane();
		editStudentSainTab.setContent(editStudentSainPane.getSainGrid());

		tabPanes.getTabs().addAll(loginTab); // Sets the tab for when the program first Starts

	}

	/**
	 * 
	 * @return built tabsPane
	 */
	public TabPane getTabPanes() {
		return tabPanes;
	}

	/**
	 * 
	 * @return Built Student Pane
	 */
	public StudentPane getsPane() {
		return sPane;
	}

	/**
	 * 
	 * @return Built Faculty Pane
	 */
	public FacultyPane getfPane() {
		return fPane;
	}

	/**
	 * 
	 * @return built Course Pane
	 */
	public CoursePane getcPane() {
		return cPane;
	}

	/**
	 * 
	 * @return built SainPane
	 */
	public SainPane getSainPane() {
		return sainPane;
	}

	/**
	 * 
	 * @return Built Login Pane
	 */
	public LoginPane getLoginPane() {
		return loginPane;
	}

	/**
	 * 
	 * @return Built What If pane
	 */
	public WhatIfPane getWhatIfPane() {
		return whatIfPane;
	}

	/**
	 * 
	 * @return built Major Pane
	 */
	public MajorPane getMajorPane() {
		return majorPane;
	}

	/**
	 * 
	 * @return Find Student Pane
	 */
	public FindStudentPane getFindStudentPane() {
		return findStudentPane;
	}

	/**
	 * 
	 * @return Editable Sain Pane
	 */
	public EditStudentSainPane getEditStudentSainPane() {
		return editStudentSainPane;
	}

	public Tab getLoginTab() {
		return loginTab;
	}

	public Tab getStudentTab() {
		return studentTab;
	}

	public Tab getFacultyTab() {
		return facultyTab;
	}

	public Tab getCourseTab() {
		return courseTab;
	}

	public Tab getTextbookTab() {
		return textbookTab;
	}

	public Tab getSainTab() {
		return sainTab;
	}

	public Tab getWhatIfTab() {
		return whatIfTab;
	}

	public Tab getMajorTab() {
		return majorTab;
	}

	public Tab getFindStudentTab() {
		return findStudentTab;
	}

	public Tab getEditStudentSainTab() {
		return editStudentSainTab;
	}

}
