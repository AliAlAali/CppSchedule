package debug;


import core.CPP;
import core.ClassRoom;
import course.Coursee;
import course.English;
import course.Science;
import majors.Chemistry;
import majors.ComputerEngineer;
import majors.ComputerScience;
import majors.Geology;
import majors.Geophysics;
import majors.Major;
import majors.Mechanical;
import majors.Physics;
import people.Student;

public class BugMain {

	public static void main(String[] args){
		CPP cpp = new CPP();
		Student ali = new Student("Ali M Alaali", 781735, CPP.LVL_AR, new Mechanical());
		
		Coursee[] c = cpp.getAvailableCourses();
		
		ali.selectiveCourseAdd(c);
		ali.printCurrentCourses();
		ali.passAllCourses();
		ali.selectiveCourseAdd(c);
		ali.printCurrentCourses();
		
		
		
	}
}
