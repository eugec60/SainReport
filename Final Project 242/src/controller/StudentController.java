package controller;

import model.Student;
import model.StudentBag;
import view.MainWindow;
import eventListnersAndObjects.StudentEventListener;
import eventListnersAndObjects.StudentEventObjs;


public class StudentController {

	StudentBag sb = new StudentBag();

	public StudentController(MainWindow mainWindow) {

		// Student PANE BUTTONS
		mainWindow.getTabsPane().getsPane()
				.setStudentEventListener(new StudentEventListener() {

					@Override
					public void buttonClicked(StudentEventObjs ev) {
						Student student = new Student(ev.getFname(), ev
								.getLname(), ev.getAdress(), ev.getPhone(), ev
								.getId(), ev.getGpa(), ev.getMajor(), ev
								.getCredits());


						sb.getStudentList().add(student);
						System.out.println("asddddddddddd");
						System.out.println(sb.getStudentList().get(0));

					}
				});

	}
}
