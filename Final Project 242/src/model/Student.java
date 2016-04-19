package model;

public class Student {
	
	package model;

	import java.util.ArrayList;

	public class Student extends Person {
		
		private double gpa;
		private String major;
		private ArrayList<Course> coursesTaken = new ArrayList<>();
		private ArrayList<Course> currentCourses = new ArrayList<>();
		private ArrayList<Course> coursesToGraduate = new ArrayList<>();
		private int credits;
		private int id;
		private int status;

		 private static int count;

		public Student(String fname, String lname, String phone, String adress,
				double gpa, String major, int credits, Course courseTaken,
				Course currentCourses2, Course coursesToGraduate2) {
			super(fname, lname, phone, adress);
			this.gpa = gpa;
			this.major = major;
			this.credits = credits;
			setStatus(0);
			coursesTaken.add(courseTaken);
			currentCourses.add(currentCourses2);
			coursesToGraduate.add(coursesToGraduate2);
			
	/*
			splitCourse(courseTaken, this.coursesTaken);
			splitCourse(currentCourses, this.currentCourses);
			splitCourse(coursesToGraduate, this.coursesToGraduate);
			*/
		}

		public Student(String fname, String lname, String phone, String adress,
				double gpa, String major, int credits) {
			super(fname, lname, phone, adress);
			this.gpa = gpa;
			this.major = major;
			this.credits = credits;
			setStatus(0);
			
			
		}

		public Student(Student student) {// ************************COPY
											// CONSTRUCTOR!!!!*************************
			setFname(student.getFname());
			setLname(student.getLname());
			setPhone(student.getPhone());
			setAdress(student.getAdress());
			this.gpa = student.getGpa();
			this.major = student.getMajor();
			this.credits = student.getCredits();

			setStatus(0);
			
		}
		
//		public Student copy(Student student) {  // ***COPY METHOD***
//			name = student.name;
//			phone = student.phone;
//			major = student.major;
//			gpa = student.gpa;
//			return student;
//		}

		public ArrayList<Course> getCoursesTaken() {
			return coursesTaken;
		}

		public void setCoursesTaken(Course course) {
		coursesTaken.add(course);
		}

		public ArrayList<Course> getCurrentCourses() {
			return currentCourses;
		}

		public void setCurrentCourses(Course course) {
			this.currentCourses.add(course);
		}

		public ArrayList<Course> getCoursesToGraduate() {
			return coursesToGraduate;
		}

		public void setCoursesToGraduate(Course course) {
			coursesToGraduate.add(course);
		}

		public double getGpa() {
			return gpa;
		}

		public void setGpa(double gpa) {
			this.gpa = gpa;
		}

		public String getMajor() {
			return major;
		}

		public void setMajor(String major) {
			this.major = major;
		}

		public int getCredits() {
			return credits;
		}

		public void setCredits(int credits) {
			this.credits = credits;
		}

		public int getStatus() {
			return status;
		}

		public void setStatus(int status) {
			this.status = status;
		}

	}

}