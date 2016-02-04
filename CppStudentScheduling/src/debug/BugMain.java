package debug;

import majors.Business;
import majors.ComputerScience;
import people.Student;
import course.BusinessCourse;
import course.Coursee;

public class BugMain {

	public static void main(String[] args){
		
		Student ali = new Student("Ali M Alaali", 781735, "CR", new ComputerScience("comoputersciecne"));
		Coursee sd = new BusinessCourse("Nothing", null, null, false, false);
		
		System.out.println(sd.isQualified(ali));
	}
}
