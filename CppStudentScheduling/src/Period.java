/*
*Ali alAali
*781735
*/

public class Period {
	/*
	 * This class represents a period in the schedule
	 */

	private int minutesStart; //the total minutes when the class starts based on 24H , getHour();
	private int number; // the place of the period within the day
	private String subject;
	private String teacher;
	private String roomId;
	private String day;
	
	//precondition  24 > minutesStart >= 0 
	public int getHour(){
		return minutesStart/60;
	}
	
	public int getMin(){
		return minutesStart%60;
	}
	
	public String startTimeToString(){
		return getHour() + ":" + getMin();
	}

	public int getMinutesStart() {
		return minutesStart;
	}

	public void setMinutesStart(int minutesStart) {
		this.minutesStart = minutesStart;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}
	
	
	
}
