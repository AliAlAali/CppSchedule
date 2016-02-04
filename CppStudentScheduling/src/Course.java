/*
*Ali alAali
*781735
*/

public class Course {

	private Qualifiable qualifiable;
	
	private int credit; // used to prioritize the course over other courses. + balance the schedule. 
	private int periodsPerWeek;
	private int periodsADay;

	private Course required;
	
	private String specialRequirement; // like gym, lab, computer lab
	private String subject;
	
	private boolean passed;
	private boolean honor;
	private boolean priority;
	
	public Course(String subject, String tool, Course required, boolean priority){
		this.subject = subject;
		this.specialRequirement = tool;
		this.required = required;
		this.priority = priority;
		this.honor = false;
	}
	
	public Course(String subject,int dailyPer, String tool, Course required, boolean priority){
		this.subject = subject;
		this.specialRequirement = tool;
		this.required = required;
		this.priority = priority;
		this.honor = false;
		this.periodsADay = dailyPer;
	}
	
	public Course(String subject, String tool, Course required, boolean priority, boolean honor){
		this.subject = subject;
		this.specialRequirement = tool;
		this.required = required;
		this.priority = priority;
		this.honor = honor;
	}
	
	public Course(String subject, String tool, Course required, boolean priority, boolean honor ,Qualifiable qualifiable){
		this.subject = subject;
		this.specialRequirement = tool;
		this.required = required;
		this.priority = priority;
		this.honor = honor;
		this.qualifiable = qualifiable;
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

	public Course getRequired() {
		return required;
	}

	public void setRequired(Course required) {
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
	
	public void setQualifiable(Qualifiable qualifiable){
		this.qualifiable = qualifiable;
	}
	
	public boolean checkQualification(Student student){
		if(qualifiable == null){
			return true;
		}else{
			return qualifiable.isQualified(student);
		}
	}
	
	public interface Qualifiable{
		public boolean isQualified(Student student);
	}
	

}
