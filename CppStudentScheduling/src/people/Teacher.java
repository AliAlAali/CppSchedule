package people;
import java.util.ArrayList;

import majors.Major;
import course.Coursee;

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
	private String subjects[];
	private Major major;
	
	public Teacher(String n,Coursee[] teach){
		this.name = n;
		this.teach = teach;
	}
	
	public Teacher(String n,String[] teach){
		this.name = n;
		if(teach != null)
			this.subjects = teach;
	}
	public boolean canTeach(Coursee course){
		for (int i = 0; i < teach.length; i++) {
			if(course.getSubject().equals(teach[i].getSubject())){
				return true;
			}
		}
		return false;
	}
	
	public int getWorkingHoursPerWeek() {
		return hoursPerWeek;
	}
	
	public int getTeachingScore(Coursee course){
		/*
		 * Distinguish between teachers of the same course
		 * by the number of hourse they work
		 */
		if(canTeach(course)){
			return getWorkingHoursPerWeek() * -5 + 200;
		}else{
			return -1;
		}
	}
	
	public void setSubjects(String[] subjects) {
		this.subjects = subjects;
	}
	
	public Coursee[] getCourses(){
		return teach;
	}
	
	public void assignTeachingCourses(Coursee[] c){
		if(subjects == null){
			teach = new Coursee[0];
			return;
		}
		ArrayList<Coursee> courses = new ArrayList<Coursee>();
		for (int i = 0; i < c.length; i++) {
			for (int j = 0; j < subjects.length; j++) {
				if(c[i].getSubject().equalsIgnoreCase(subjects[j])){
					courses.add(c[i]);
				}
			}
		}
		
		teach = new Coursee[courses.size()];
		for (int i = 0; i < teach.length; i++) {
			teach[i] = courses.get(i);
		}
	}
	
	public void printCourses(){
		/*
		 * used for debugging
		 */
		for (int i = 0; i < teach.length; i++) {
			System.out.print(teach[i].getSubject() + " ");
		}
	}
	
	
	public void addWorkHours(int hrs){
		/*
		 * debugging
		 */
		this.hoursPerWeek += hrs;
	}
	
	@Override
	public String toString() {
		String s = name + "\n";
		if(subjects == null){
			return s;
		}
		for (int i = 0; i < subjects.length; i++) {
			s += subjects[i] + " ";
		}
		return s;
	}
}
