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
	MajorPane majorPane = new MajorPane();
	FindStudentPane findStudentPane = new FindStudentPane();
	Tab loginTab,studentTab,facultyTab,courseTab,textbookTab, sainTab,whatIfTab,majorTab,findStudentTab;
	public TabsPane() {
		
		//STUDENT TAB
		tabPanes = new TabPane();
		tabPanes.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
		 studentTab = new Tab("Student");
		studentTab.setContent(sPane.getStudentPane());
		
		//FacultyTab
		
		
		 facultyTab = new Tab("Faculty");
		facultyTab.setContent(fPane.getFacultyPane());
		
		//Course Tab
		
		 courseTab = new Tab("Course");
		courseTab.setContent(cPane.getCoursePane());
		
		
		
		//Textbook Tab
		
		 textbookTab = new Tab("Textbook");
		textbookTab.setContent(tPane.getTextbookPane());
		
		//Sain Tab
		
		 sainTab = new Tab("SAIN");
		sainTab.setContent(sainPane.getSainGrid());
		//WhatIfPane
		
		 whatIfTab = new Tab("What If");
		whatIfTab.setContent(whatIfPane.getWhatIfPane());
		
		
		loginTab = new Tab("Login");
		loginTab.setContent(loginPane.getLoginGrid());
		
		 majorTab = new Tab("Major");
		majorTab.setContent(majorPane.getMajorGrid());
		
		findStudentTab = new Tab("Find Student");
		findStudentTab.setContent(findStudentPane.getFindStudentGrid());
		
		
		
		
		
		tabPanes.getTabs().addAll(loginTab);
		
		
		
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

	public MajorPane getMajorPane() {
		return majorPane;
	}
	
	

	public FindStudentPane getFindStudentPane() {
		return findStudentPane;
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
	
	
	
	
	
	
	
	
	
	
	

}
