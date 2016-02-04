import java.util.List;

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

	private char gender;
	
	private List<Course> courses; //That are must to graduate according to the major
	
	
	public String getLevel(){
		return level;
	}
	
	public String getTrack(){
		return track;
	}
	
	public String getMajor(){
		return major;
	}

}
