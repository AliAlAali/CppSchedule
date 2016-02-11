package core;

import java.util.ArrayList;

import course.Coursee;
import majors.Electrical;
import people.Student;

public class TestMethods {

	public static void main(String[] args) {

		
		CPP cpp = new CPP();
		Coursee[] c = cpp.getAvailableCourses();
		ArrayList<Student> stu = cpp.getStudents();
		ClassRoom r;

		for (int i = 0; i < Schedule.MAX; i++) {
			// code will be implemented here later to cover all trim
			// and days
		}

		for (int i = 0; i < stu.size(); i++) {
			stu.get(i).selectiveCourseAdd(c);
		}
		

		for (int day = 0; day < CPP.DAYS_WEEK; day++) {
			for (int per = 0; per < 6; per++) {
				for (int i = 0; i < c.length; i++) {
					if ((!c[i].isPriority() || cpp.numOfStudentHaveCourse(c[i]) <= 0) || c[i].getSpecialRequirement() != null) {
						continue;
					}
					//System.out.println(2 + "  " + per);
					r = cpp.findEmptyNormalRoom(day, per, c[i].getPeriodsADay());
					addclass:while (cpp.numOfStudentHaveCourse(c[i]) - cpp.numOfStudentEnrolled(c[i], 1, day) > 0 && r != null) {
//						System.out.println("Have: " + cpp.numOfStudentHaveCourse(c[i]) + "  Enroll: " + cpp.numOfStudentEnrolled(c[i], 1));
//						System.out.println(r);
//						r.getSchedule().printFormat();
						if (r != null) {
							for (int s = 0; s < stu.size(); s++) {
								if (stu.get(s).findCourse(c[i]) != null
										&& stu.get(s).getSchedule(1).getPeriod(day, per) == null && !stu.get(s).isCourseScheduled(1, day, c[i])) {
									if (!r.isFull()) {
										for (int cl = 0; cl < c[i].getPeriodsADay(); cl++) {
											stu.get(s).getSchedule(1).setPeriod(day, per + cl, c[i]);
											r.getSchedule().setPeriod(day, per + cl, c[i]);
										}
										r.addStudent(stu.get(s));
										c[i].setRoom(r.getRoomId());
										
									}
								}else{
									if(s >= stu.size()-1 && r != null){
										break addclass;
									}
								}
							}
						}
						r = cpp.findEmptyNormalRoom(day, per, c[i].getPeriodsADay());
					}

				}
				cpp.clearRooms();
			}
			
		}

		for (int i = 0; i < stu.size(); i++) {
			System.out.println(stu.get(i).getName() + "  M: " + stu.get(i).getMajor().getClass().getSimpleName());
			stu.get(i).getSchedule(1).printFormat();
			System.out.println();
		}
		
		System.out.println("============================= ROOMS =================================");

		for (int i = 0; i < cpp.getClassRooms().size(); i++) {
			System.out.println(cpp.getClassRooms().get(i));
			cpp.getClassRooms().get(i).getSchedule().printFormat();
			System.out.println();
		}

	}
}
