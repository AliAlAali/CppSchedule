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

		

		CPP cpp = new CPP();
		Teacher o;

		Coursee cs = new GeneralStudies("CS010", 1, null, null);
		Coursee wrd = new ComputerStudies("CSWP010", 1, 3, null, null, false,
				null);

		o = cpp.getSuggestedTeacher(cs);

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 7; j++) {
					o.getSchedule(1).setPeriod(i, j, cs);
			}
		}
		
		o.getSchedule(1).printFormat();

	

	}
}
