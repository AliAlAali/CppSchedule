package course;

import core.CPP;
import majors.Major;
import people.Student;

public class Coursee {

	private int credit; // used to prioritize the course over other courses. +
						// balance the schedule.
	private int periodsPerWeek;
	private int periodsADay;

	private Coursee required;
	private Major[] strictTo;
	

	private String specialRequirement; // like gym, lab, computer lab
	private String subject;
	private String level;

	private boolean passed;
	private boolean honor;
	private boolean priority;

	public Coursee(String subject, String tool, Coursee required, boolean priority) {
		this.subject = subject;
		this.specialRequirement = tool;
		this.required = required;
		this.priority = priority;
		this.honor = false;
		this.strictTo = null;
	}

	public Coursee(String subject, int dailyPer, int weekPer, String tool, Coursee required, boolean priority) {
		this.subject = subject;
		this.specialRequirement = tool;
		this.required = required;
		this.priority = priority;
		this.honor = false;
		this.periodsADay = dailyPer;
		this.periodsPerWeek = weekPer;
		this.strictTo = null;
	}

	public Coursee(String subject, String tool, Coursee required, boolean priority, boolean honor) {
		this.subject = subject;
		this.specialRequirement = tool;
		this.required = required;
		this.priority = priority;
		this.honor = honor;
		this.strictTo = null;
	}

	public Coursee(String subject, String tool, Coursee required, boolean priority, boolean honor, Major strict) {
		this.subject = subject;
		this.specialRequirement = tool;
		this.required = required;
		this.priority = priority;
		this.honor = honor;
		this.strictTo = new Major[1];
		this.strictTo[0] = strict;
	}

	public Coursee(String subject, String tool, Coursee required, boolean priority, boolean honor, Major[] strict) {
		this.subject = subject;
		this.specialRequirement = tool;
		this.required = required;
		this.priority = priority;
		this.honor = honor;
		this.strictTo = strict;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public int getPeriodsPerWeek() {
		return periodsPerWeek;
	}

	public void setPeriodsPerWeek(int periodsPerWeek) {
		this.periodsPerWeek = periodsPerWeek;
	}

	public Coursee getRequired() {
		return required;
	}

	public void setRequired(Coursee required) {
		this.required = required;
	}

	public String getSpecialRequirement() {
		return specialRequirement;
	}

	public void setSpecialRequirement(String specialRequirement) {
		this.specialRequirement = specialRequirement;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public boolean isPassed() {
		return passed;
	}

	public void setPassed(boolean passed) {
		this.passed = passed;
	}

	public boolean isPriority() {
		return priority;
	}

	public void setPriority(boolean priority) {
		this.priority = priority;
	}

	public boolean isHonor() {
		return honor;
	}

	public void setHonor(boolean h) {
		this.honor = h;
	}

	public int getPeriodsADay() {
		return periodsADay;
	}

	public void setPeriodsADay(int periodsADay) {
		this.periodsADay = periodsADay;
	}

	public boolean isQualified(Student student) {
		if (strictTo == null) {
			return true;
		}
		for (int i = 0; i < strictTo.length; i++) {
			if (Major.isInstanceOf(strictTo[i], student.getMajor())) {
				return true;
			}
		}
		return false;
	}

	

	public boolean canStudy(Student student) {
		int diff = CPP.getDifficulty(getLevel());
		int stDif = CPP.getDifficulty(student.getLevel());
		if (!isQualified(student)) {
			return false;
		}
		if (diff == 0) {
			return hasPassedReq(student);
		} else if (diff > 0) {
			if (diff <= stDif) {
				return hasPassedReq(student);
			}
		} else {
			if (diff <= stDif && stDif < 0) {
				return hasPassedReq(student);
			}
		}
		return false;
	}

	public boolean hasPassedReq(Student student) {
		if (required != null) {
			for (int i = 0; i < student.getCourses().size(); i++) {
				if (student.getCourses().get(i).getSubject().equals(required.getSubject())) {
					return student.getCourses().get(i).isPassed();
				}
			}
		} else {
			return true;
		}
		return false;
	}

	public static Coursee[] mergeCourses(Coursee[] c1, Coursee[] c2) {
		if (c1 == null || c2 == null) {
			if (c1 == null && c2 != null) {
				return c2;
			} else if (c1 != null && c2 == null) {
				return c1;
			} else {
				return null;
			}
		}
		Coursee[] c = new Coursee[c1.length + c2.length];
		int ind = 0;
		for (int i = 0; i < c.length; i++) {
			if (i < c1.length) {
				c[i] = c1[i];
			} else {
				if (ind < c2.length) {
					c[i] = c2[ind];
					ind++;
				}
			}
		}

		return c;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}
	
	public Major[] getStrictions(){
		return strictTo;
	}
	
	public int getWeekHours(){
		return periodsADay*periodsPerWeek;
	}

}
