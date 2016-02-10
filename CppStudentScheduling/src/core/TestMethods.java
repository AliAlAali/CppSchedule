package core;

import java.util.ArrayList;

import course.Coursee;
import majors.Electrical;
import people.Student;

public class TestMethods {

	public static void main(String[] args) {

		// ClassRoom room = new ClassRoom("D132", null);
		// Coursee c = new English("ENGLISH", null, null, true);
		// c.setPeriodsADay(2);
		//
		// System.out.println(new CPP().findEmptyNormalRoom(0, 0, 2));
		// if(room.isFree(0, 0)){
		// room.getSchedule().setPeriod(0, 0, c);
		// room.getSchedule().setPeriod(0, 1, c);
		// }
		//
		// room.getSchedule().printFormat();
		// System.out.println(room.isFree(0, 0));

		CPP cpp = new CPP();
		Student ali = new Student("Ali M Alaali", 781735, CPP.LVL_AR, new Electrical());

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
					if (!c[i].isPriority() && cpp.numOfStudentHaveCourse(c[i]) <= 0) {
						continue;
					}
					System.out.println(day + "  " + per);
					r = cpp.findEmptyNormalRoom(day, per, c[i].getPeriodsADay());
					while (cpp.numOfStudentHaveCourse(c[i]) - cpp.numOfStudentEnrolled(c[i], 1) > 0 && r != null) {
						if (r != null) {
							for (int s = 0; s < stu.size(); s++) {
								if (stu.get(s).findCourse(c[i]) != null
										&& stu.get(s).getSchedule(1).getPeriod(day, per) == null) {
									if (!r.isFull()) {
										r.addStudent(stu.get(s));
										c[i].setRoom(r.getRoomId());
										r.getSchedule().setPeriod(day, per, c[i]);
									}
								}
							}
						}
						r = cpp.findEmptyNormalRoom(day, per, c[i].getPeriodsADay());
					}

				}
			}
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
