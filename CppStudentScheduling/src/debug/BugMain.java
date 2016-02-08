package debug;

import javax.print.attribute.standard.MediaSize.Engineering;

import core.CPP;
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
		Student ali = new Student("Ali M Alaali", 781735, CPP.LVL_CR, new ComputerScience());
//		Coursee eng021 = new English("x", 1, 2, null, null, CPP.LVL_AR);
//		ali.addCourse(eng021);
//		ali.passCourse(eng021);
//		
//		Major chemistRist = new Major();
		//Coursee sd = new English("d", null, eng021, false, false, null);
//		Major[] strictions = {new Geophysics(), new Mechanical()};
//		Coursee phys = new Science("d",1,2, null, null, false, false, null);
//		System.out.println(phys.canStudy(ali));
//		
		Coursee[] c = cpp.getAvailableCourses();
		for (int i = 0; i < c.length; i++) {
			ali.addCourse(c[i]);
		}
		ali.printAllCourses();

		ali.passAllCourses();
		for (int i = 0; i < c.length; i++) {
			ali.addCourse(c[i]);
		}
		ali.printCurrentCourses();
		
		
//		Coursee[] c1 = {eng021, sd, sd, sd, sd};
//		Coursee[] c2 = {sd, eng021, eng021};
//		Coursee[] c3 = Coursee.mergeCourses(c1, c2);
//		for (int i = 0; i < c3.length; i++) {
//			System.out.println(c3[i].getSubject());
//		}
//	
		//System.out.println(new Mechanical().instanceOf(ali.getMajor()));
	}
}
