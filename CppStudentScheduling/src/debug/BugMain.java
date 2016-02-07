package debug;

import javax.print.attribute.standard.MediaSize.Engineering;

import core.CPP;
import course.Coursee;
import course.English;
import majors.Chemistry;
import majors.ComputerScience;
import majors.Geology;
import majors.Major;
import majors.Physics;
import people.Student;

public class BugMain {

	public static void main(String[] args){
		CPP cpp = new CPP();
		Student ali = new Student("Ali M Alaali", 781735, CPP.LVL_AR, new ComputerScience());
		Coursee eng021 = new English("x", 1, 2, null, null, CPP.LVL_AR);
//		ali.addCourse(eng021);
//		ali.passCourse(eng021);
//		
		Major chemistRist = new Major();
		Coursee sd = new English("d", null, eng021, false, false, chemistRist);
//		
//		System.out.println(sd.canStudy(ali));
		
//		Coursee[] c = cpp.getAvailableCourses();
//		for (int i = 0; i < c.length; i++) {
//			ali.addCourse(c[i]);
//		}
//		ali.passCourse(ali.findCourse("PF1"));
//		ali.addCourse(c[10]);
//		ali.printCourses();
		
//		Coursee[] c1 = {eng021, sd, sd, sd, sd};
//		Coursee[] c2 = {sd, eng021, eng021};
//		Coursee[] c3 = Coursee.mergeCourses(c1, c2);
//		for (int i = 0; i < c3.length; i++) {
//			System.out.println(c3[i].getSubject());
//		}
//	
		System.out.println(Coursee.isInstanceOf(new Chemistry(), new Geology()));
	}
}
