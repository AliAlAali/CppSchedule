package people;

import java.util.ArrayList;
import java.util.List;

import core.Schedule;
import majors.Major;
import course.Coursee;

/*
*Ali alAali
*781735
*/

public class Student {

	public static int MAX_PERIODS_WEEK = 35;
	public static int MAX_PERIODS_DAY = 7;
	
	
	private int badge;
	private int trimester;
	private int periodsAWeek;
	
	private String name;
	private String level;	//CH CR BR AR
	private Major major;
	private Schedule sch[];

	private char gender;
	
	private ArrayList<Coursee> courses; //That are must to graduate according to the major
	
	public Student(String name, int badge, String lvl, Major major){
		this.name = name;
		this.badge  = badge;
		this.level = lvl;
		this.major = major;
		courses = new ArrayList<Coursee>();
		sch = new Schedule[3];
		sch[0] = new Schedule(1);
		sch[1] = new Schedule(2);
		sch[2] = new Schedule(3);
	}
	
	public String getLevel(){
		return level;
	}
	
	public Major getMajor(){
		return major;
	}
	
	public ArrayList<Coursee> getCourses(){
		return courses;
	}
	
	public String getName(){
		return this.name;
	}
	public boolean addCourse(Coursee course){
		if(course != null){
			for (int i = 0; i < courses.size(); i++) {
				if(course.getSubject().equals(courses.get(i).getSubject())){
					return false;
				}
			}
			if(course.canStudy(this)){
				courses.add(course);
				return true;
			}
		}
		return false;
	}
	
	public Coursee findCourse(String subject){
		for (int i = 0; i < courses.size(); i++) {
			if(courses.get(i).getSubject().equals(subject)){
				return courses.get(i);
			}
		}
		return null;
	}
	
	public Coursee findCourse(Coursee course){
		for (int i = 0; i < courses.size(); i++) {
			if(courses.get(i).getSubject().equals(course.getSubject())){
				return courses.get(i);
			}
		}
		return null;
	}
	
	public boolean isCourseScheduled(int trim,int d,Coursee course){
		/*
		 * check whether student have the course in the schedule 
		 * in a particular day of a trim
		 */
		int num = 0;
		for (int i = 0; i < sch[trim - 1].getCourses()[d].length; i++) {
			if(sch[trim - 1].getCourses()[d][i] != null && sch[trim - 1].getCourses()[d][i].getSubject().equals(course.getSubject())){
				num++;
			}
		}
		if(num >= course.getPeriodsADay()){
			return true;
		}else{
			return false;
		}
	}
	
	public void passCourse(Coursee course){
		for (int i = 0; i < courses.size(); i++) {
			if(course.getSubject().equals(courses.get(i).getSubject())){
				courses.get(i).setPassed(true);
			}
		}
	}
	
	public void printAllCourses(){
		for (int i = 0; i < courses.size(); i++) {
			System.out.print(courses.get(i).getSubject() + " ");
		}
		System.out.println();
	}
	
	public void printCurrentCourses(){
		for (Coursee coursee : courses) {
			if(!coursee.isPassed())
				System.out.print(coursee.getSubject()+ " ");
		}
		System.out.println();
	}
	
	public void passAllCourses(){
		for (Coursee coursee : courses) {
			coursee.setPassed(true);
		}
	}
	
	public int getCurrentWeekHours(){
		int hours = 0;
		for (int i = 0; i < courses.size(); i++) {
			if(!courses.get(i).isPassed()){
				hours += courses.get(i).getPeriodsADay()*courses.get(i).getPeriodsPerWeek();
			}
		}
		return hours;
	}
	
	public Schedule getSchedule(int trim){
		for (int i = 0; i < sch.length; i++) {
			if(sch[i].getTrim() == trim){
				return sch[i];
			}
		}
		return null;
	}
	
	public boolean isBusy(int trim,int d, int p){
		if(getSchedule(trim).getPeriod(d,p) == null){
			return false;
		}else{
			return true;
		}
	}
	
	public void printScheduleData(int trim){
		for (int i = 0; i < sch[trim].getCourses().length; i++) {
			for (int j = 0; j < sch[trim].getCourses()[i].length; j++) {
				if(sch[trim].getCourses()[i][j] != null){
				System.out.print(sch[trim].getCourses()[i][j].getSubject() + " ");
				}
			}
			System.out.println();
		}
	}
	
	public int getNumCourseSchedule(int trim, Coursee course){
		int n = 0;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 7; j++) {
				if(getSchedule(trim).getPeriod(i, j) != null && getSchedule(trim).getPeriod(i, j).getSubject().equals(course.getSubject())){
					n++;
				}
			}
		}
		return n;
	}
	
	public void passAllScheduleCourses(int trim, Coursee[] c){
		for (int i = 0; i < c.length; i++) {
			if(getSchedule(trim).exist(c[i])){
				findCourse(c[i]).setPassed(true);
			}
		}
	}
	
	public boolean hasPassedCourse(Coursee course){
		for (int i = 0; i < courses.size(); i++) {
			if(course.getSubject().equals(courses.get(i).getSubject())){
				if(courses.get(i).isPassed()){
					return true;
				}
			}
		}
		return false;
	}
	public void selectiveCourseAdd(Coursee[] c){
		/*
		 * This method can be called to add new courses each trimester
		 *  1 - Add courses that student can study (Parioriy) within the time available
		 *  2 - Add rest of the courses student can study(non-pariority ones)
		 *  3...
		 *  TODO IN TRIMISTER 3 ADD LOWER RELATION COURSES USING DIFFERENT METHOD
		 */
		
		for (int i = 0; i < c.length; i++) {
			if(getCurrentWeekHours()  + c[i].getWeekHours() < MAX_PERIODS_WEEK  && c[i].isPriority() && getMajor().relation(c[i]) >= Major.MAX_RELATION_SCORE){
				addCourse(c[i]);
			}
		}
		for (int i = 0; i < c.length; i++) {
			if(getCurrentWeekHours()  + c[i].getWeekHours() < MAX_PERIODS_WEEK  && getMajor().relation(c[i]) >= Major.MAX_RELATION_SCORE){
				addCourse(c[i]);
			}
		}
	}

}
