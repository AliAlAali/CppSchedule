package debug;

import majors.Business;
import majors.ComputerScience;
import majors.Major;
import people.Student;
import core.CPP;
import course.BusinessCourse;
import course.Coursee;
import course.English;

public class BugMain {

	public static void main(String[] args){
		CPP cpp = new CPP();
		Student ali = new Student("Ali M Alaali", 781735, CPP.LVL_AR, new ComputerScience());
//		Coursee eng021 = new English("x", 1, 2, null, null, CPP.LVL_AR);
//		ali.addCourse(eng021);
//		ali.passCourse(eng021);
//		
//		Major chemistRist = new Major();
//		Coursee sd = new English("d", null, eng021, false, false, chemistRist);
//		
//		System.out.println(sd.canStudy(ali));
		
		Coursee[] c = cpp.getAvailableCourses();
		for (int i = 0; i < c.length; i++) {
			ali.addCourse(c[i]);
		}
		ali.passCourse(ali.findCourse("PF1"));
		ali.addCourse(c[10]);
		ali.printCourses();
	}
}
