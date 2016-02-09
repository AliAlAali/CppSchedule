package people;
import course.Coursee;
import majors.Major;

/*
*Ali alAali
*781735
*/

public class Teacher{

	public static int MAX_WEEK_HOURS = 20;
	
	private int hoursPerWeek; 
	private int overTime;	//	number of overtime working hours.

	
	private Coursee[] teach;//courses the teacher can teaches.
	private String name;
	private Major major;
	
	public Teacher(String n, Major major,Coursee[] teach){
		this.name = n;
		this.major = major;
		this.teach = teach;
	}
	public boolean canTeach(Coursee course){
		for (int i = 0; i < teach.length; i++) {
			if(course.getSubject().equals(teach[i].getSubject())){
				return true;
			}
		}
		return false;
	}
	
	public int evaluateCourse(Coursee course){
		int score = 0;
		if(canTeach(course)){
			score = 75;
		}
		for (int i = 0; i < course.getStrictions().length; i++) {
			if(major.instanceOf(course.getStrictions()[i])){
				score += 5;
			}
		}
		return score;
	}
	
	//Should also cover teacher total working hours
	public int compareTo(Teacher o, Coursee course) {
		int me = evaluateCourse(course);
		int him = o.evaluateCourse(course);
		
		if(me > him){
			return him - me;
		}else if(him > me){
			return him - me;
		}else{
			return 0;
		}
	}
}
