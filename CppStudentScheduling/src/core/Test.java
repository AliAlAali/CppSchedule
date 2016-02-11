/*
*Ali alAali
*781735
*/
package core;

import people.Teacher;
import course.ComputerStudies;
import course.Coursee;
import course.GeneralStudies;


public class Test {

	public static void main(String[] args) {
		
//		Reader r = new Reader();
//		for (int i = 0; i < r.getTeachers().size(); i++) {
//			System.out.println(r.getTeachers().get(i) + "\n");
//		}
		
		CPP cpp = new CPP();
		Teacher o;
		
		Coursee cs = new GeneralStudies("CS010", 1, null, null);
		Coursee wrd = new ComputerStudies("CSWP010", 1, 3, null, null, false, null);
		
		o = cpp.getSuggestedTeacher(cs);
		o.addWorkHours(5);
		System.out.println(o);
		
		o = cpp.getSuggestedTeacher(wrd);
		o.addWorkHours(5);
		System.out.println(o);
		
		o = cpp.getSuggestedTeacher(wrd);
		o.addWorkHours(4);
		System.out.println(o);
		
		System.out.println(cpp.getSuggestedTeacher(wrd));
		
	}
}
