package people;

import java.util.List;

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
	private String track;	//engineer, science, etc.
	private String level;	//CH CR BR AR
	//private String department;
	private String major;
	private Major majorr;

	private char gender;
	
	private List<Coursee> courses; //That are must to graduate according to the major
	
	public Student(String name, int badge, String lvl, Major major){
		this.name = name;
		this.badge  = badge;
		this.level = lvl;
		this.majorr = major;
	}
	
	public String getLevel(){
		return level;
	}
	
	public String getTrack(){
		return track;
	}
	
	
	
	public Major getMajor(){
		return majorr;
	}

}
