package core;

import java.util.ArrayList;

import course.Coursee;
import majors.Electrical;
import people.Student;
import people.Teacher;

public class TestMethods {

	public static void main(String[] args) {

		
		CPP cpp = new CPP();
		Coursee[] c = cpp.getAvailableCourses();
		ArrayList<Student> stu = cpp.getStudents();
		ClassRoom r;
		Coursee course;
		Teacher tch = null;

		for (int t = 1; t <= 3; t++) {
			// code will be implemented here later to cover all trim
			// and days
		

		for (int i = 0; i < stu.size(); i++) {
			stu.get(i).selectiveCourseAdd(c);
		}
		

		for (int day = 0; day < CPP.DAYS_WEEK; day++) {
			for (int per = 0; per < 7; per++) {
				for (int i = 0; i < c.length; i++) {
					if ((!c[i].isPriority() || cpp.numOfStudentHaveCourse(c[i]) <= 0) || c[i].getSpecialRequirement() != null) {
						continue;
					}
					course = c[i];
					r = cpp.findEmptyNormalRoom(day, per, c[i].getPeriodsADay());
					addclass:while (cpp.numOfStudentHaveCourse(c[i]) - cpp.numOfStudentEnrolled(c[i], t, day) > 0 && r != null) {					
						if (r != null) {
							tch = cpp.getSuggestedTeacher(t, day, per, c[i]);
							if(tch == null){
								break addclass;
							}
							for (int s = 0; s < stu.size(); s++) {
								if (stu.get(s).findCourse(c[i]) != null
										&& stu.get(s).getSchedule(t).getPeriod(day, per) == null && !stu.get(s).isCourseScheduled(t, day, c[i]) && !stu.get(s).addCourse(c[i])) {
									if (!r.isFull()) {
										for (int cl = 0; cl < c[i].getPeriodsADay(); cl++) {
											if(cl + per < 7){
												stu.get(s).getSchedule(t).setPeriod(day, per + cl, c[i],tch.getName(),r.getRoomId());
												r.getSchedule().setPeriod(day, per + cl, c[i], tch.getName());
											}
										}
										r.addStudent(stu.get(s));
										c[i].setRoom(r.getRoomId());
										if(tch.getSchedule(1).getPeriod(day, per) == null){
											tch.addWorkHours(c[i].getPeriodsADay());
										}
										tch.getSchedule(t).setPeriod(day, per,c[i], r.getRoomId());
										
									}else{
						
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
		
		
		

		for (int day = 0; day < CPP.DAYS_WEEK; day++) {
			for (int per = 0; per < 7; per++) {
				for (int i = 0; i < c.length; i++) {
					if ((c[i].isPriority() || cpp.numOfStudentHaveCourse(c[i]) <= 0)) {
						continue;
					}
					course = c[i];
					r = cpp.findProperRoom(day, per, c[i].getPeriodsADay(), c[i].getSpecialRequirement());
					addclass:while (cpp.numOfStudentHaveCourse(c[i]) - cpp.numOfStudentEnrolled(c[i], t, day) > 0 && r != null) {					
						if (r != null) {
							tch = cpp.getSuggestedTeacher(t, day, per, c[i]);
							if(tch == null){
								break addclass;
							}
							for (int s = 0; s < stu.size(); s++) {
								if (stu.get(s).findCourse(c[i]) != null
										&& stu.get(s).getSchedule(1).getPeriod(day, per) == null && !stu.get(s).isCourseScheduled(t, day, c[i]) && stu.get(s).getNumCourseSchedule(t, c[i]) <c[i].getWeekHours()) {
									if (!r.isFull()) {
										for (int cl = 0; cl < c[i].getPeriodsADay(); cl++) {
											if(cl + per < 7){
												stu.get(s).getSchedule(t).setPeriod(day, per + cl, c[i], tch.getName(), r.getRoomId());
												r.getSchedule().setPeriod(day, per + cl, c[i], tch.getName());
											}
										}
										r.addStudent(stu.get(s));
										c[i].setRoom(r.getRoomId());
										if(tch.getSchedule(1).getPeriod(day, per) == null){
											tch.addWorkHours(c[i].getPeriodsADay());
										}
										tch.getSchedule(t).setPeriod(day, per,c[i], r.getRoomId());
										
									}else{
						
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
		
		cpp.clearRooms();
		for (int i = 0; i < stu.size(); i++) {
			stu.get(i).passAllScheduleCourses(t, c);
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

		for (int i = 0; i < cpp.getTeachers().size(); i++) {
			System.out.println(cpp.getTeachers().get(i).getName());
			System.out.println(cpp.getTeachers().get(i).getWorkingHoursPerWeek());
			cpp.getTeachers().get(i).getSchedule(1).printFormat();
			System.out.println();
		}
	}
}
