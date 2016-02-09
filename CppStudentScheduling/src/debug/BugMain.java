package debug;


import java.util.ArrayList;

import core.CPP;
import core.ClassRoom;
import core.Schedule;
import course.Coursee;
import course.English;
import majors.Mechanical;
import people.Student;

public class BugMain {

	public static void main(String[] args){
		CPP cpp = new CPP();
		Student ali = new Student("Ali M Alaali", 781735, CPP.LVL_AR, new Mechanical());
		
		Coursee[] c = cpp.getAvailableCourses();
		ArrayList<Student> stu = cpp.getStudents();
		ClassRoom r;
		
		for (int i = 0; i < Schedule.MAX; i++) {
			//code will be implemented here later to cover all trim
			//and days
		}
		
		int p = 0;
		int d = 0;
		for (int i = 0; i < c.length; i++) {
			while(cpp.numOfStudentHaveCourse(c[i]) > cpp.numOfStudentEnrolled(c[i], 1)){
				if(c[i].getSpecialRequirement() == null && (r=cpp.findNormalRoom())!= null){//check if and get the best teacher can take this
					r.Book(c[i].getPeriodsADay());
					//set teacher schedule
					while(!r.isFull()){
						for (int j = 0; j < stu.size(); j++) {
							//stu.get(i).selectiveCourseAdd();
							if(c[i].canStudy(stu.get(j)) &&!stu.get(j).isBusy(1, d, p)){
								//add the subject to his schedule
							}
						}
					}
					
					
				}
			}
		}
		
		
	}
}
