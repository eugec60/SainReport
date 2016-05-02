package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Course;
import model.CourseBag;
import view.MainWindow;
import eventListnersAndObjects.CourseEventListener;
import eventListnersAndObjects.CourseEventObjs;

public class CourseController {

	CourseBag cb;
	ObservableList<Course> courseData;

	public CourseController(MainWindow mainWindow) {
		cb = new CourseBag();

//		// Course Add Button
//		mainWindow.getTabsPane().getcPane()
//				.setCourseEventListener(new CourseEventListener() {
//
//					@Override
//					public void ButtonClicked(CourseEventObjs ev) {
//						Course course = new Course(ev.getCourseTitle(), ev
//								.getCourseNum(), ev.getCrn(), ev
//								.getClassAdress(), ev.getCredits());
//						cb.add(course);
//
//					}
//				});

	}

}
