package people;

import java.util.ArrayList;

import majors.Major;
import core.Schedule;
import course.Coursee;

/*
 *Ali alAali
 *781735
 */

public class Teacher {

	public static int MAX_WEEK_HOURS = 20;

	private int hoursPerWeek;

	private Coursee[] teach;// courses the teacher can teaches.
	private Schedule[] sch;
	private String name;
	private String subjects[];

	public Teacher(String n, Coursee[] teach) {
		this.name = n;
		this.teach = teach;
		this.sch = new Schedule[3];
		this.sch[0] = new Schedule(1);
		this.sch[1] = new Schedule(2);
		this.sch[2] = new Schedule(3);
	}

	public Teacher(String n, String[] teach) {
		this.name = n;
		if (teach != null)
			this.subjects = teach;
		this.sch = new Schedule[3];
		this.sch[0] = new Schedule(1);
		this.sch[1] = new Schedule(2);
		this.sch[2] = new Schedule(3);
	}

	public boolean canTeach(Coursee course) {
		for (int i = 0; i < teach.length; i++) {
			if (course.getSubject().equals(teach[i].getSubject())) {
				return true;
			}
		}
		return false;
	}

	public int getWorkingHoursPerWeek() {
		return hoursPerWeek;
	}

	public int getTeachingScore(Coursee course) {
		/*
		 * Distinguish between teachers of the same course by the number of
		 * hourse they work
		 */
		if (canTeach(course)) {
			return getWorkingHoursPerWeek() * -5 + 200;
		} else {
			return -1;
		}
	}

	public int getTeachingScore(int trim, int d, int per, int length,
			Coursee course) {
		/*
		 * Distinguish between teachers of the same course by the number of
		 * hourse they work, this one return -1 if the teacher is busy
		 */
		int dd = 0;
		if(d - 1 >= 0){
			dd = d - 1;
		}
		Coursee pre = getSchedule(trim).getPeriod(dd, per);
		if (isFree(trim, d, per, length) == true) {
			if (canTeach(course) && pre != null && pre.getSubject().equals(course.getSubject())) {
				return getWorkingHoursPerWeek() * -5 + 700;
			}else if(canTeach(course)){
				return getWorkingHoursPerWeek() * -5 + 200;
			} else {
				return -1;
			}
		} else {
			return -1;
		}
	}

	public void setSubjects(String[] subjects) {
		this.subjects = subjects;
	}

	public Coursee[] getCourses() {
		return teach;
	}

	public void assignTeachingCourses(Coursee[] c) {
		if (subjects == null) {
			teach = new Coursee[0];
			return;
		}
		ArrayList<Coursee> courses = new ArrayList<Coursee>();
		for (int i = 0; i < c.length; i++) {
			for (int j = 0; j < subjects.length; j++) {
				if (c[i].getSubject().equalsIgnoreCase(subjects[j])) {
					courses.add(c[i]);
				}
			}
		}

		teach = new Coursee[courses.size()];
		for (int i = 0; i < teach.length; i++) {
			teach[i] = courses.get(i);
		}
	}

	public void printCourses() {
		/*
		 * used for debugging
		 */
		for (int i = 0; i < teach.length; i++) {
			System.out.print(teach[i].getSubject() + " ");
		}
	}

	public void addWorkHours(int hrs) {
		/*
		 * debugging
		 */
		this.hoursPerWeek += hrs;
	}

	public Schedule getSchedule(int trim) {
		return sch[trim - 1];
	}

	/*
	 * Checks if a teacher is free to teach for class that consist of numPer
	 * periods
	 */
	public boolean isFree(int trim, int d, int per, int numPer) {
		for (int i = 0; i < numPer; i++) {
			if ((per + i) < 7 && getSchedule(trim).getPeriod(d, per + i) != null) {
				return false;
			}
		}
		return true;
	}
	
	public String getName() {
		return name;
	}
	

	@Override
	public String toString() {
		String s = name + "\n";
		if (subjects == null) {
			return s;
		}
		for (int i = 0; i < subjects.length; i++) {
			s += subjects[i] + " ";
		}
		return s;
	}
}
