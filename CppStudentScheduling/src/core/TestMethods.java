package core;

import java.util.ArrayList;

import majors.Electrical;
import people.Student;
import course.Coursee;
import course.English;

public class TestMethods {

	public static void main(String[] args) {
		
//		ClassRoom room = new ClassRoom("D132", null);
//		Coursee c = new English("ENGLISH", null, null, true);
//		 c.setPeriodsADay(2);
//		
//		 System.out.println(new CPP().findEmptyNormalRoom(0, 0, 2));
//		if(room.isFree(0, 0)){
//			room.getSchedule().setPeriod(0, 0, c);
//			room.getSchedule().setPeriod(0, 1, c);
//		}
//		
//		room.getSchedule().printFormat();
//		System.out.println(room.isFree(0, 0));
		
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
				for (int days = 0; days < 5; days++) {
				if(c[i].getSpecialRequirement() == null && (r=cpp.findEmptyNormalRoom(days, p, c[i].getPeriodsADay()))!= null){//check if and get the best teacher can take this
					r.Book(c[i].getPeriodsADay());
					//set teacher schedule
					while(!r.isFull()){
						for (int j = 0; j < stu.size(); j++) {
							if(stu.get(j).findCourse(c[i]) != null && !stu.get(j).isBusy(1, days, p)){
								//add the subject to his schedule
								
									for (int cl = 0; cl < c[i].getPeriodsADay(); cl++) {
										c[i].setRoom(r.getRoomId());
										stu.get(j).getSchedule(1).setPeriod(days, p + cl, c[i]);
										r.addStudent(stu.get(j));
										r.getSchedule().setPeriod(days, p + cl, c[i]);
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
			}}
		}
		
		
		for (int i = 0; i < stu.size(); i++) {
			System.out.println(stu.get(i).getName() + "  M: " + stu.get(i).getMajor().getClass().getSimpleName());
			stu.get(i).getSchedule(1).printFormat();
			System.out.println();
		}
		
		for (int i = 0; i < cpp.getClassRooms().size(); i++) {
			System.out.println(cpp.getClassRooms().get(i));
			cpp.getClassRooms().get(i).getSchedule().printFormat();
			System.out.println();
		}
		
	}
}
