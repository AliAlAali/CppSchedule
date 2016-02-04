package course;

import majors.Major;
import people.Student;


public class Coursee {



	
	private int credit; // used to prioritize the course over other courses. + balance the schedule. 
	private int periodsPerWeek;
	private int periodsADay;

	private Coursee required;
	private Major[] strictTo;
	
	private String specialRequirement; // like gym, lab, computer lab
	private String subject;
	
	private boolean passed;
	private boolean honor;
	private boolean priority;
	
	public Coursee(String subject, String tool, Coursee required, boolean priority){
		this.subject = subject;
		this.specialRequirement = tool;
		this.required = required;
		this.priority = priority;
		this.honor = false;
		this.strictTo = null;
	}
	
	public Coursee(String subject,int dailyPer, String tool, Coursee required, boolean priority){
		this.subject = subject;
		this.specialRequirement = tool;
		this.required = required;
		this.priority = priority;
		this.honor = false;
		this.periodsADay = dailyPer;
		this.strictTo = null;
	}
	
	public Coursee(String subject, String tool, Coursee required, boolean priority, boolean honor){
		this.subject = subject;
		this.specialRequirement = tool;
		this.required = required;
		this.priority = priority;
		this.honor = honor;
		this.strictTo = null;
	}
	
	public Coursee(String subject, String tool, Coursee required, boolean priority, boolean honor,Major strict){
		this.subject = subject;
		this.specialRequirement = tool;
		this.required = required;
		this.priority = priority;
		this.honor = honor;
		this.strictTo = new Major[1];
		this.strictTo[0] = strict;
	}
	
	
	public Coursee(String subject, String tool, Coursee required, boolean priority, boolean honor,Major[] strict){
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
	
	public boolean isQualified(Student student){
		if(strictTo == null){
			return true;
		}
		for (int i = 0; i < strictTo.length; i++) {
			if(student.getMajor().equals(strictTo[i])){
				return true;
			}
		}
		return false;
	}
	
	
	

}


