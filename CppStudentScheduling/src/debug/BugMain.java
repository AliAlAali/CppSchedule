package debug;


import java.util.ArrayList;

import core.CPP;
import core.ClassRoom;
import core.Schedule;
import course.Coursee;
import course.English;
import majors.ChemicalEngineering;
import majors.ComputerScience;
import majors.Electrical;
import majors.Geology;
import majors.Mechanical;
import people.Student;

public class BugMain {

	public static void main(String[] args){
		CPP cpp = new CPP();
		Student ali = new Student("Ali M Alaali", 781735, CPP.LVL_AR, new Electrical());
		
		Coursee[] c = cpp.getAvailableCourses();
		ArrayList<Student> stu = cpp.getStudents();
		ClassRoom r;
		
		
		
		for (int i = 0; i < Schedule.MAX; i++) {
			//code will be implemented here later to cover all trim
			//and days
		}
		
		for (int i = 0; i < stu.size(); i++) {
			stu.get(i).selectiveCourseAdd(c);
		}
		
		int p = 0;
		int d = 0;
		for (int i = 0; i < c.length; i++) {
			if(!c[i].isPriority()){
				continue;
			}
			classLoop:while(cpp.numOfStudentHaveCourse(c[i]) - cpp.numOfStudentEnrolled(c[i], 1) > 0 ){
				if(c[i].getSpecialRequirement() == null && (r=cpp.findNormalRoom())!= null){//check if and get the best teacher can take this
					r.Book(c[i].getPeriodsADay());
					//set teacher schedule
					while(!r.isFull()){
						for (int j = 0; j < stu.size(); j++) {
							if(stu.get(j).findCourse(c[i]) != null && !stu.get(j).isBusy(1, d, p)){
								//add the subject to his schedule
								for (int day = 0; day < CPP.DAYS_WEEK; day++) {
									for (int cl = 0; cl < c[i].getPeriodsADay(); cl++) {
										c[i].setRoom(r.getRoomId());
										stu.get(j).getSchedule(1).setPeriod(day, p + cl, c[i]);
										r.addStudent(stu.get(j));
									}
								}
							}else{
								if(j + 1 == stu.size()){
									break classLoop;
								}
							}
						}
					}
					
				}
			}
			
			
			if(cpp.numOfStudentEnrolled(c[i], 1) > 0 ){
				if(p + c[i].getPeriodsADay() < 7){
					p += c[i].getPeriodsADay();
				}else{
					p = 0;
				}
			}
		}
		
		
		for (int i = 0; i < stu.size(); i++) {
			System.out.println(stu.get(i).getName() + "  M: " + stu.get(i).getMajor().getClass().getSimpleName());
			stu.get(i).getSchedule(1).printFormat();
			System.out.println();
		}
		
		
	}
}
