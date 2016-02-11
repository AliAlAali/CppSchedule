package core;

import course.Coursee;

public class Schedule {

	public static final int MAX = 3;

	private Coursee[][] sch;
	private int trim;

	public Schedule(int trim) {
		sch = new Coursee[5][7];
		this.trim = trim;
	}

	public void setPeriod(int d, int p, Coursee value) {
		this.sch[d][p] = value;
	}

	public Coursee getPeriod(int d, int p) {
		return sch[d][p];
	}

	public boolean amend(int day, Coursee course) {
		/*
		 * Replace first null value that comes after a non-null value from the
		 * end
		 */
		int index = -1;
		for (int i = sch[day].length - 1; i > 0; i--) {
			if (sch[day][i] == null && sch[day][i - 1] != null) {
				index = i;
			}
		}

		if (index > -1) {
			sch[day][index] = course;
			return true;
		} else {
			return false;
		}
	}

	public void swap(int d1, int p1, int d2, int p2) {
		Coursee holder = sch[d1][p1];
		sch[d1][p2] = sch[d1][p1];
		sch[d2][p2] = holder;
	}

	public void remove(int d, int p) {
		// remove one value check removeCourse() for removing a whole one
		sch[d][p] = null;
	}

	public void removeCourse(Coursee course) {
		for (int i = 0; i < sch.length; i++) {
			for (int j = 0; j < sch[i].length; j++) {
				if (course.getSubject().equals(sch[i][j].getSubject())) {
					remove(i, j);
				}
			}
		}
	}

	/*
	 * checks whether a course exist in the schedule
	 */
	public boolean exist(Coursee course) {
		for (int i = 0; i < sch.length; i++) {
			for (int j = 0; j < sch[i].length; j++) {
				if (sch[i][j] != null
						&& sch[i][j].getSubject().equals(course.getSubject())) {
					return true;
				}
			}
		}
		return false;
	}

	/*
	 * checks whether a course exist in the schedule at a particular day
	 */
	public boolean exist(Coursee course, int day) {
		for (int j = 0; j < sch[day].length; j++) {
			if (sch[day][j] != null
					&& sch[day][j].getSubject().equals(course.getSubject())) {
				return true;
			}
		}

		return false;
	}

	/*
	 * checks whether a course exist in the schedule
	 */
	public boolean exist(String course) {
		for (int i = 0; i < sch.length; i++) {
			for (int j = 0; j < sch[i].length; j++) {
				if (sch[i][j] != null && sch[i][j].getSubject().equals(course)) {
					return true;
				}
			}
		}
		return false;
	}

	public int getTrim() {
		return trim;
	}

	public void setTrim(int trim) {
		this.trim = trim;
	}

	public Coursee[][] getCourses() {
		return sch;
	}

	public void printData() {
		for (int i = 0; i < sch.length; i++) {
			for (int j = 0; j < sch[i].length; j++) {
				if (sch[i][j] != null) {
					System.out.print(sch[i][j].getSubject() + " ");
				}
			}
			System.out.println();
		}
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i < sch.length; i++) {
			for (int j = 0; j < sch[i].length; j++) {
				if (sch[i][j] != null) {
					s += sch[i][j].getSubject() + "   ";
				} else {
					s += " - ";
				}
			}
			s += "\n";
		}
		return s;
	}

	public void printFormat() {
		for (int i = 0; i < sch.length; i++) {
			for (int j = 0; j < sch[i].length; j++) {
				if (sch[i][j] != null) {
					System.out.printf("%5s ", sch[i][j].getSubject());
				} else {
					System.out.printf("%5s ", "[ - ]");
				}
			}
			System.out.println();

		}
	}

}
