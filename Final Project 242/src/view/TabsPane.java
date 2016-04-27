package view;

import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;

public class TabsPane {
	private TabPane tabPanes;
	StudentPane sPane = new StudentPane();
	FacultyPane fPane = new FacultyPane();
	CoursePane cPane = new CoursePane();
	TextbookPane tPane = new TextbookPane();
	SainPane sainPane = new SainPane();
	LoginPane loginPane = new LoginPane();
	WhatIfPane whatIfPane = new WhatIfPane();

	public TabsPane() {
		
		//STUDENT TAB
		tabPanes = new TabPane();
		tabPanes.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
		Tab studentTab = new Tab("Student");
		studentTab.setContent(sPane.getStudentPane());
		
		//FacultyTab
		
		
		Tab facultyTab = new Tab("Faculty");
		facultyTab.setContent(fPane.getFacultyPane());
		
		//Course Tab
		
		Tab courseTab = new Tab("Course");
		courseTab.setContent(cPane.getCoursePane());
		
		
		
		//Textbook Tab
		
		Tab textbookTab = new Tab("Textbook");
		textbookTab.setContent(tPane.getTextbookPane());
		
		//Sain Tab
		
		Tab sainTab = new Tab("SAIN");
		sainTab.setContent(sainPane.getSainGrid());
		//WhatIfPane
		
		Tab whatIfTab = new Tab("What If");
		whatIfTab.setContent(whatIfPane.getWhatIfPane());
		
		
		Tab loginTab = new Tab("Login");
		loginTab.setContent(loginPane.getLoginGrid());
		
		
		
		
		
		tabPanes.getTabs().addAll(loginTab,studentTab,facultyTab,courseTab,textbookTab, sainTab,whatIfTab);
		
		
		
	}

	public TabPane getTabPanes() {
		return tabPanes;
	}

	public StudentPane getsPane() {
		return sPane;
	}

	public FacultyPane getfPane() {
		return fPane;
	}

	public CoursePane getcPane() {
		return cPane;
	}

	public TextbookPane gettPane() {
		return tPane;
	}

	public SainPane getSainPane() {
		return sainPane;
	}

	public LoginPane getLoginPane() {
		return loginPane;
	}

	public WhatIfPane getWhatIfPane() {
		return whatIfPane;
	}
	
	
	
	
	
	

}
