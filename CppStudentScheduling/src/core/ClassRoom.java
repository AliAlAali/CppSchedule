package core;

import java.util.ArrayList;
import java.util.List;

import people.Student;

/*
*Ali alAali
*781735
*/

public class ClassRoom {

	public static String DES_GYM = "Gym";
	public static String DES_COM_LAB = "Computer Lab";
	public static String DES_PH_LAB =  "Physics & Chemistry Lab";
	public static String DES_CH_LAB = "Physics & Chemistry Lab";
	public static String DES_GEOL_LAB = "Geology Lab";

	public static int MAX_STUDENTS = 18;

	private String roomId;
	private String tools;
	private int booked;
	private char building;
	private int size;

	private List<Student> students;

	public ClassRoom(String id, String tools, int size) {
		students = new ArrayList<Student>();
		this.tools = tools;
		this.roomId = id;
		this.building =  id.toUpperCase().charAt(0);
		this.size = size;
		this.booked = 0;
	}
	
	public ClassRoom(String id, String tools, int size, char build) {
		students = new ArrayList<Student>();
		this.tools = tools;
		this.roomId = id;
		this.building =  build;
		this.size = size;
		this.booked = 0;
	}
	
	public ClassRoom(String id, String tools) {
		students = new ArrayList<Student>();
		this.tools = tools;
		this.roomId = id.toUpperCase();
		this.building =  id.toUpperCase().charAt(0);
		this.size = MAX_STUDENTS;
		this.booked = 0;
	}

	public ClassRoom(String id) {
		students = new ArrayList<Student>();
		this.tools = null;
		this.roomId = id.toUpperCase();
		this.building =  id.toUpperCase().charAt(0);
		this.size = MAX_STUDENTS;
		this.booked = 0;
	}
	
	@Override
	public String toString() {
		return "R: " + roomId + "\nBuilding: " + building + "\nTools: " + tools ;
	}

	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
		this.building =  roomId.toUpperCase().charAt(0);
	}

	public String getTools() {
		return tools;
	}

	public void setTools(String tools) {
		this.tools = tools;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getBooked() {
		return booked;
	}

	public void Book(int booked) {
		this.booked = booked;
	}
	
	public boolean isFull(){
		if(size > students.size()){
			return false;
		}
		return true;
	}
	
	public void addStudent(Student student){
		if(!isFull()){
			students.add(student);
		}
	}
	
	
	
	
}
