package core;

import java.util.ArrayList;
import java.util.List;

import majors.Business;
import majors.ChemicalEngineering;
import majors.Chemistry;
import majors.ChemistryMajor;
import majors.ComputerEngineer;
import majors.ComputerScience;
import majors.Electrical;
import majors.Engineering;
import majors.Geology;
import majors.Geophysics;
import majors.Major;
import majors.Mechanical;
import majors.Petroleum;
import majors.Physics;
import people.Student;
import people.Teacher;
import course.ChemistryCourse;
import course.ComputerStudies;
import course.Coursee;
import course.English;
import course.GeneralStudies;
import course.Mathematics;
import course.PhysicsCourse;
import course.Science;

/*
 *Ali alAali
 *781735
 */

public class CPP {

	/*
	 * Here Rules and Abstract information about the program
	 */

	public static final String LVL_AR = "AR";
	public static final String LVL_BR = "BR";
	public static final String LVL_ALL = "ALL";
	public static final String LVL_C = "C";
	public static final String LVL_CR = "CR";
	public static final String LVL_CH = "CH";
	
	public static final int studentNum = 300;
	public static final int DAYS_WEEK = 5;

	private Coursee[] courses; // array of offered courses

	private List<Teacher> teachers;
	private ArrayList<Student> students;

	private List<ClassRoom> rooms;
	private Major[] majors;
	
	public CPP() {
		teachers = new ArrayList<Teacher>();
		students = new ArrayList<Student>();
		rooms = new ArrayList<ClassRoom>();
		courses = initializeCourses();
		majors = initializeMajors();
		addStudents();
		addRooms();
	}

	public int numOfStudentEnrolled(Coursee course, int trim){
		/*
		 * Returns the number of students who have the course in their schedule
		 */
		int num = 0;
		for (int i = 0; i < students.size(); i++) {
			if(students.get(i).getSchedule(trim).exist(course)){
				num++;
			}
		}
		return num;
	}
	
	public int numOfStudentHaveCourse(Coursee course){
		/*
		 * Returns the number of students who should study a course
		 */
		int num = 0;
		for (int i = 0; i < students.size(); i++) {
			if(students.get(i).findCourse(course.getSubject()) != null){
				num++;
			}
		}
		return num;
	}
	
	public int numOfStudentHaveCourse(String course){
		/*
		 * Returns the number of students who should study a course
		 */
		int num = 0;
		for (int i = 0; i < students.size(); i++) {
			if(students.get(i).findCourse(course) != null){
				num++;
			}
		}
		return num;
	}
	
	public int numOfStudentEnrolled(String course, int trim){
		/*
		 * Returns the number of students who have the course in their schedule
		 */
		int num = 0;
		for (int i = 0; i < students.size(); i++) {
			if(students.get(i).getSchedule(trim).exist(course)){
				num++;
			}
		}
		return num;
	}
	
	public ClassRoom findNormalRoom(){
		for (int i = 0; i < rooms.size(); i++) {
			if(rooms.get(i).getBooked() == 0 && rooms.get(i).getTools() == null){
				return rooms.get(i);
			}
		}
		return null;
	}
	
	public void UnbookAllClasses(){
		for (int i = 0; i < rooms.size(); i++) {
			rooms.get(i).Book(0);;
		}
	}
	
	public ClassRoom findEmptyNormalRoom(int d, int p, int num){
		mainloop:for (int i = 0; i < rooms.size(); i++) {
			if(rooms.get(i).getTools() == null && rooms.get(i).isFree(d, p)){
				for (int j = p; j < p + num; j++) {
					if(!rooms.get(i).isFree(d, j)){
						 continue mainloop;
					}
				}
				return rooms.get(i);
			}
		}
		return null;
	}
	
	private Major[] initializeMajors(){
		Major comSc = new ComputerScience();
		Major comEng = new ComputerEngineer();
		Major chemisrty = new ChemistryMajor();
		Major chemEng = new ChemicalEngineering();
		Major eleMajor = new Electrical();
		Major mechMajor = new Mechanical();
		Major geoMajor = new Geology();
		Major geofMajor = new Geophysics();
		Major petrMajor = new Petroleum();
		Major civilMajor = new Physics();
		Major[] m = {comSc, comEng, chemisrty, chemEng, eleMajor, mechMajor,
				geofMajor, geoMajor, petrMajor, civilMajor};
		return m;
	}

	private Coursee[] initializeCourses() {
		/*
		 * English, General, ComputerStudies, other unrelated courses
		 */

		// restrictions
		Major[] mechanical_electrical_stric = { new Mechanical(), new Electrical() };
		Major[] geology_geophysics_Pertl_stric = { new Geology(), new Geophysics() };
		Major[] physics = {new Physics()};
		Major[] chemist = {new Chemistry()};
		Major[] business = {new Business()};
		Major[] engineer = {new Engineering()};
		Major[] compSc = {new ComputerScience()};
		Major[] computers = {new ComputerScience(), new ComputerEngineer()};
		Major[] chemDirect = {new ChemicalEngineering(), new ChemistryMajor()};
		Major[] petrol = {new Petroleum()};
		Major[] eng_comSc = {new ComputerScience(), new Engineering()};

		// English courses
		Coursee eng021 = new English("ENGL021", 2, 5, null, null, CPP.LVL_AR);
		Coursee eng023 = new English("ENGL023", 2, 5, null, eng021, CPP.LVL_AR);
		Coursee eng024 = new English("ENGL024", 2, 5, null, eng023, CPP.LVL_AR);
		Coursee eng031 = new English("ENGL031", 1, 4, null, null);
		eng031.setPriority(false);
		Coursee eng033 = new English("ENGL033", 2, 5, null, eng024, CPP.LVL_AR);
		Coursee eng025 = new English("ENG025", 2, 5, null, null, LVL_C);
		Coursee eng035 = new English("ENG035", 2, 5, null, eng025, LVL_C);
		Coursee eng036 = new English("ENGL036", 2, 5, null, eng025);
		Coursee eng043 = new English("ENGL043", 2, 5, null, eng036, CPP.LVL_AR);

		// General Studies
		Coursee pf1 = new GeneralStudies("PF1", 2, ClassRoom.DES_GYM, null);
		Coursee pf2 = new GeneralStudies("PF2", 2, ClassRoom.DES_GYM, pf1);
		Coursee cs010 = new GeneralStudies("CS010", 1, null, null);
		Coursee hs010 = new GeneralStudies("HS010", 1, null, null);
		hs010.setPeriodsPerWeek(2);
		Coursee icut030 = new GeneralStudies("ICUT030", 1, null, cs010);

		// pure science - NEED TO PUT RESTRICTIONS TO THE MAJOR AND INSTANCE OF
		Coursee appp031 = new PhysicsCourse("APPP031", 1, 4, null, null, true, false, null);
		Coursee appp032 = new Science("APPP032", 1, 4, null, appp031, true, false, physics);
		Coursee appc033 = new Science("APPC033", 1, 4, null, appp032, true, false, physics);
		Coursee phys045 = new Science("PHYS045", 1, 4, ClassRoom.DES_PH_LAB, appc033, false, true, mechanical_electrical_stric);
		Coursee geo020 = new Science("GEO020", 1, 4, ClassRoom.DES_GEOL_LAB, null, false, true, geology_geophysics_Pertl_stric);
		Coursee apcp035 = new ChemistryCourse("APCP035", 1, 4, null, null, true, false, null);
		Coursee appp041 = new Science("APPP041", 1, 4, null, null, true, false, petrol);
		Coursee apch050 = new Science("APCH050", 1, 4, null, appp041, true, false, chemist);
		Coursee apch051 = new Science("APCH051", 1, 4, null, apch050, true, false, chemist);
		Coursee chem041 = new Science("CHEM041", 1, 4, ClassRoom.DES_CH_LAB, apcp035, true, true, chemDirect);
		
		//Mathematics
		Coursee math101 = new Mathematics("MATH101", 1, 5, null, null, true, false, null);
		Coursee math102 = new Mathematics("MATH102", 1, 5, null, math101, true, false, null);
		Coursee apca040 = new Mathematics("APCA040", 1, 5, null, math102, true, false, eng_comSc);
		Coursee csdm101 = new Mathematics("CSDM101", 1, 4, null, math101, true, false, null);
		
		//Business
		
		//Computer Studies & Technology
		Coursee apcs101 = new ComputerStudies("APCS101", 1, 4, null, null, true ,compSc);
		Coursee apcs102 = new ComputerStudies("APCS102", 1, 4, null, apcs101, true ,compSc);
		Coursee apcs103 = new ComputerStudies("APCS103", 1, 4, null, apcs102, true ,compSc);
		Coursee csca101 = new ComputerStudies("CSCA101", 1, 4, null, null, false ,computers);
		Coursee cswp010 = new ComputerStudies("CSWP010", 1, 3, ClassRoom.DES_COM_LAB, null, false, null);
		Coursee csas030 = new ComputerStudies("CSAS030", 1, 4, ClassRoom.DES_COM_LAB, null, false, null);
		Coursee csjv101 = new ComputerStudies("CSJV010", 1, 4, ClassRoom.DES_COM_LAB, null, false, CPP.LVL_C ,engineer);
		Coursee cscp101 = new ComputerStudies("CSCP010", 1, 4, ClassRoom.DES_COM_LAB, null, false ,CPP.LVL_AR, null);
		Coursee cscp0101 = new ComputerStudies("CSCP010", 1, 4, ClassRoom.DES_COM_LAB, null, false, CPP.LVL_C ,business);
		Coursee csdb101 = new ComputerStudies("CSCP010", 1, 4, ClassRoom.DES_COM_LAB, null, false, CPP.LVL_C ,business);
		

		

		Coursee[] courses = { eng021, eng023, eng024, eng025, eng031, eng033,
				eng035, eng036, eng043, pf1, pf2, cs010, hs010, icut030, appp031, appp032, appc033, phys045,geo020,
				apcp035 , appp041, apch050, apch051, chem041, math101, math102, apca040, csdm101, apcs101, apcs102, apcs103,cswp010, csas030,
				csjv101, cscp101, cscp0101, csdb101,  csca101};
		return courses;

	}

	public static int getDifficulty(String level) {
		if (level.equals(LVL_AR)) {
			return -2;
		} else if (level.equals(LVL_BR)) {
			return -1;
		} else if (level.equals(LVL_ALL)) {
			return 0;
		} else if (level.equals(LVL_CR)) {
			return 1;
		} else if (level.equals(LVL_C)) {
			return 1;
		} else {
			return 2;
		}
	}

	public Coursee findCourse(String subject) {
		for (int i = 0; i < courses.length; i++) {
			if (courses[i].getSubject().equals(subject)) {
				return courses[i];
			}
		}
		return null;
	}

	public Coursee[] getAvailableCourses() {
		return courses;
	}
	
	public Major[] getMajors(){
		return majors;
	}
	
	public ArrayList<ClassRoom> getClassRooms(){
		return (ArrayList<ClassRoom>) this.rooms;
	}
	
	private void addRooms(){
		rooms.add(new ClassRoom("d132"));
		rooms.add(new ClassRoom("d123", ClassRoom.DES_GEOL_LAB));
		rooms.add(new ClassRoom("d110", ClassRoom.DES_COM_LAB));
		rooms.add(new ClassRoom("d109", ClassRoom.DES_COM_LAB));
		rooms.add(new ClassRoom("d108", ClassRoom.DES_COM_LAB));
		rooms.add(new ClassRoom("d107", ClassRoom.DES_COM_LAB));
		rooms.add(new ClassRoom("d106", ClassRoom.DES_COM_LAB));
		rooms.add(new ClassRoom("d104", ClassRoom.DES_COM_LAB));
		rooms.add(new ClassRoom("d102", ClassRoom.DES_COM_LAB));
		rooms.add(new ClassRoom("d226"));
		rooms.add(new ClassRoom("d224"));
		rooms.add(new ClassRoom("d222"));
		rooms.add(new ClassRoom("d220"));
		rooms.add(new ClassRoom("d215"));
		rooms.add(new ClassRoom("d213"));
		rooms.add(new ClassRoom("d211"));
		rooms.add(new ClassRoom("d209"));
		rooms.add(new ClassRoom("d210"));
		rooms.add(new ClassRoom("d208"));
		rooms.add(new ClassRoom("d207"));
		rooms.add(new ClassRoom("d206"));
		rooms.add(new ClassRoom("d205"));
		rooms.add(new ClassRoom("d203"));
		rooms.add(new ClassRoom("d204"));
		rooms.add(new ClassRoom("d202"));
		rooms.add(new ClassRoom("d201"));
		rooms.add(new ClassRoom("d132"));
		rooms.add(new ClassRoom("e104"));
		rooms.add(new ClassRoom("e106"));
		rooms.add(new ClassRoom("e108"));
		rooms.add(new ClassRoom("e108"));
		rooms.add(new ClassRoom("e110"));
		rooms.add(new ClassRoom("Lab", ClassRoom.DES_PH_LAB, 40, 'E'));
		rooms.add(new ClassRoom("GYM", ClassRoom.DES_GYM));






		
	}
	
	private void addStudents(){
		students.add(new Student("Mohammad Alaali",781620, CPP.LVL_CH, new ComputerScience()));
		students.add(new Student("Mohammad Mohaideb",781621, CPP.LVL_CR, new Mechanical()));
		students.add(new Student("Ahmad Bakulka",781622, CPP.LVL_CR, new Physics()));
//		students.add(new Student("Khalid Bakulka",781623, CPP.LVL_BR, new ComputerEngineer()));
		students.add(new Student("Omar Jacob",781624, CPP.LVL_BR, new ChemistryMajor()));
		students.add(new Student("Saud Bakulka",781625, CPP.LVL_CR, new Petroleum()));
//		students.add(new Student("Abdullah Alaali",781626, CPP.LVL_AR, new ComputerEngineer()));
		students.add(new Student("Raif Abdulrahman",781627, CPP.LVL_BR, new Electrical()));
		students.add(new Student("Mohammad Jacob",781628, CPP.LVL_AR, new ComputerScience()));
//		students.add(new Student("Khalid Alaali",781629, CPP.LVL_CH, new Mechanical()));
//		students.add(new Student("Ahmad Jacob",781630, CPP.LVL_BR, new Physics()));
//		students.add(new Student("Khalid Alaali",781631, CPP.LVL_BR, new Mechanical()));
//		students.add(new Student("Ali Abdulrahman",781632, CPP.LVL_CH, new ComputerScience()));
		students.add(new Student("Abdullah Bakulka",781633, CPP.LVL_CH, new Geophysics()));
//		students.add(new Student("Ali Sulaimy",781634, CPP.LVL_AR, new Physics()));
		students.add(new Student("Ahmad Sulaimy",781679, CPP.LVL_CR, new Geology()));
//		students.add(new Student("Mohammad Mohaideb",781635, CPP.LVL_CR, new Geophysics()));
		students.add(new Student("Mohammad Bakulka",781636, CPP.LVL_CR, new ChemicalEngineering()));
//		students.add(new Student("Mohammad Alaali",781637, CPP.LVL_CR, new ComputerScience()));
//		students.add(new Student("Khalid Jacob",781638, CPP.LVL_CR, new Electrical()));
//		students.add(new Student("Ali Jacob",781639, CPP.LVL_CH, new Geophysics()));
//		students.add(new Student("Raif Jacob",781640, CPP.LVL_CH, new ComputerScience()));
//		students.add(new Student("Omar Sulaimy",781641, CPP.LVL_BR, new ComputerScience()));
//		students.add(new Student("Ahmad Jacob",781642, CPP.LVL_CR, new Petroleum()));
//		students.add(new Student("Ali Alaali",781643, CPP.LVL_CH, new Electrical()));
//		students.add(new Student("Abdullah Alaali",781644, CPP.LVL_BR, new Mechanical()));
//		students.add(new Student("Raif Mohaideb",781645, CPP.LVL_AR, new ChemistryMajor()));
//		students.add(new Student("Omar Bakulka",781646, CPP.LVL_AR, new Electrical()));
//		students.add(new Student("Ahmad Alaali",781647, CPP.LVL_AR, new Geophysics()));
//		students.add(new Student("Raif Bakulka",781648, CPP.LVL_CR, new ComputerEngineer()));
//		students.add(new Student("Omar Alaali",781649, CPP.LVL_CR, new ComputerScience()));
//		students.add(new Student("Saud Alaali",781650, CPP.LVL_BR, new Mechanical()));
//		students.add(new Student("Ali Bakulka",781651, CPP.LVL_CH, new ChemistryMajor()));
//		students.add(new Student("Omar Sulaimy",781652, CPP.LVL_AR, new Mechanical()));
//		students.add(new Student("Raif Alaali",781653, CPP.LVL_CR, new ChemicalEngineering()));
//		students.add(new Student("Raif Bakulka",781654, CPP.LVL_CR, new Geophysics()));
//		students.add(new Student("Mohammad Bakulka",781655, CPP.LVL_AR, new Physics()));
//		students.add(new Student("Khalid Abdulrahman",781656, CPP.LVL_AR, new ChemistryMajor()));
//		students.add(new Student("Mohammad Jacob",781657, CPP.LVL_CR, new ChemistryMajor()));
//		students.add(new Student("Ahmad Abdulrahman",781658, CPP.LVL_CR, new ChemicalEngineering()));
//		students.add(new Student("Omar Bakulka",781659, CPP.LVL_CR, new Mechanical()));
//		students.add(new Student("Raif Bakulka",781660, CPP.LVL_BR, new ComputerScience()));
//		students.add(new Student("Mohammad Abdulrahman",781661, CPP.LVL_CR, new Geophysics()));
//		students.add(new Student("Omar Jacob",781662, CPP.LVL_BR, new ChemicalEngineering()));
//		students.add(new Student("Ahmad Sulaimy",781663, CPP.LVL_AR, new Geology()));
//		students.add(new Student("Omar Alaali",781664, CPP.LVL_CR, new Electrical()));
//		students.add(new Student("Khalid Sulaimy",781665, CPP.LVL_CH, new ChemistryMajor()));
//		students.add(new Student("Omar Abdulrahman",781666, CPP.LVL_CH, new Mechanical()));
//		students.add(new Student("Omar Abdulrahman",781667, CPP.LVL_CH, new ComputerEngineer()));
//		students.add(new Student("Raif Alaali",781668, CPP.LVL_CH, new Electrical()));
//		students.add(new Student("Saud Mohaideb",781669, CPP.LVL_CH, new Petroleum()));
//		students.add(new Student("Ali Sulaimy",781670, CPP.LVL_CH, new ComputerScience()));
//		students.add(new Student("Ali Bakulka",781671, CPP.LVL_CR, new Physics()));
//		students.add(new Student("Mohammad Bakulka",781672, CPP.LVL_AR, new Geophysics()));
//		students.add(new Student("Omar Bakulka",781673, CPP.LVL_CH, new Geophysics()));
//		students.add(new Student("Ali Bakulka",781674, CPP.LVL_CR, new ComputerScience()));
//		students.add(new Student("Abdullah Mohaideb",781675, CPP.LVL_CR, new ChemistryMajor()));
//		students.add(new Student("Omar Mohaideb",781676, CPP.LVL_BR, new ComputerEngineer()));
//		students.add(new Student("Saud Mohaideb",781677, CPP.LVL_CR, new Geology()));
//		students.add(new Student("Saud Mohaideb",781678, CPP.LVL_CH, new Petroleum()));
//		students.add(new Student("Omar Sulaimy",781680, CPP.LVL_BR, new Geophysics()));
//		students.add(new Student("Ahmad Bakulka",781681, CPP.LVL_CR, new Electrical()));
//		students.add(new Student("Saud Jacob",781682, CPP.LVL_CR, new ComputerScience()));
//		students.add(new Student("Mohammad Bakulka",781683, CPP.LVL_CH, new Geology()));
//		students.add(new Student("Saud Bakulka",781684, CPP.LVL_CR, new Geophysics()));
//		students.add(new Student("Abdullah Alaali",781685, CPP.LVL_CH, new Geophysics()));
//		students.add(new Student("Ali Bakulka",781686, CPP.LVL_BR, new ComputerScience()));
//		students.add(new Student("Saud Abdulrahman",781687, CPP.LVL_CH, new ComputerScience()));
//		students.add(new Student("Ali Abdulrahman",781688, CPP.LVL_AR, new ComputerEngineer()));
//		students.add(new Student("Ahmad Jacob",781689, CPP.LVL_CH, new ChemicalEngineering()));
//		students.add(new Student("Mohammad Jacob",781690, CPP.LVL_CH, new ChemistryMajor()));
//		students.add(new Student("Saud Mohaideb",781691, CPP.LVL_AR, new Geophysics()));
//		students.add(new Student("Abdullah Sulaimy",781692, CPP.LVL_BR, new ComputerScience()));
//		students.add(new Student("Saud Bakulka",781693, CPP.LVL_CH, new Electrical()));
//		students.add(new Student("Ali Bakulka",781694, CPP.LVL_BR, new ChemicalEngineering()));
//		students.add(new Student("Abdullah Mohaideb",781695, CPP.LVL_CR, new Geology()));
//		students.add(new Student("Ali Jacob",781696, CPP.LVL_CR, new ChemicalEngineering()));
//		students.add(new Student("Khalid Sulaimy",781697, CPP.LVL_BR, new Physics()));
//		students.add(new Student("Khalid Mohaideb",781698, CPP.LVL_AR, new Electrical()));
//		students.add(new Student("Ali Bakulka",781699, CPP.LVL_CR, new ComputerScience()));
//		students.add(new Student("Khalid Alaali",781700, CPP.LVL_BR, new ComputerScience()));
//		students.add(new Student("Raif Jacob",781701, CPP.LVL_CH, new ComputerEngineer()));
//		students.add(new Student("Saud Alaali",781702, CPP.LVL_CH, new Geophysics()));
//		students.add(new Student("Mohammad Sulaimy",781703, CPP.LVL_CR, new ChemistryMajor()));
//		students.add(new Student("Khalid Sulaimy",781704, CPP.LVL_AR, new Geology()));
//		students.add(new Student("Saud Bakulka",781705, CPP.LVL_AR, new ChemicalEngineering()));
//		students.add(new Student("Saud Mohaideb",781706, CPP.LVL_CH, new Mechanical()));
//		students.add(new Student("Ahmad Jacob",781707, CPP.LVL_CR, new Electrical()));
//		students.add(new Student("Saud Bakulka",781708, CPP.LVL_AR, new Physics()));
//		students.add(new Student("Mohammad Alaali",781709, CPP.LVL_AR, new ChemistryMajor()));
//		students.add(new Student("Raif Alaali",781710, CPP.LVL_CR, new Petroleum()));
//		students.add(new Student("Raif Mohaideb",781711, CPP.LVL_CR, new Electrical()));
//		students.add(new Student("Khalid Jacob",781712, CPP.LVL_CR, new ComputerEngineer()));
//		students.add(new Student("Khalid Jacob",781713, CPP.LVL_AR, new ChemicalEngineering()));
//		students.add(new Student("Mohammad Abdulrahman",781714, CPP.LVL_CH, new Geology()));
//		students.add(new Student("Omar Abdulrahman",781715, CPP.LVL_AR, new Petroleum()));
//		students.add(new Student("Raif Mohaideb",781716, CPP.LVL_BR, new Geophysics()));
//		students.add(new Student("Abdullah Jacob",781717, CPP.LVL_CR, new ChemicalEngineering()));
//		students.add(new Student("Ahmad Sulaimy",781718, CPP.LVL_BR, new ChemistryMajor()));
//		students.add(new Student("Khalid Jacob",781719, CPP.LVL_BR, new Geophysics()));
//		students.add(new Student("Khalid Jacob",781720, CPP.LVL_CH, new ChemistryMajor()));
//		students.add(new Student("Khalid Jacob",781721, CPP.LVL_BR, new Petroleum()));
//		students.add(new Student("Abdullah Abdulrahman",781722, CPP.LVL_BR, new ComputerEngineer()));
//		students.add(new Student("Raif Alaali",781723, CPP.LVL_CH, new Geophysics()));
//		students.add(new Student("Saud Abdulrahman",781724, CPP.LVL_CR, new Electrical()));
//		students.add(new Student("Omar Alaali",781725, CPP.LVL_BR, new Mechanical()));
//		students.add(new Student("Ahmad Alaali",781726, CPP.LVL_BR, new Geology()));
//		students.add(new Student("Mohammad Sulaimy",781727, CPP.LVL_CH, new Geophysics()));
//		students.add(new Student("Ali Jacob",781728, CPP.LVL_AR, new Physics()));
//		students.add(new Student("Khalid Abdulrahman",781729, CPP.LVL_CH, new Electrical()));
//		students.add(new Student("Ahmad Abdulrahman",781730, CPP.LVL_CR, new Petroleum()));
//		students.add(new Student("Saud Alaali",781731, CPP.LVL_AR, new ChemistryMajor()));
//		students.add(new Student("Omar Mohaideb",781732, CPP.LVL_AR, new ChemicalEngineering()));
//		students.add(new Student("Mohammad Sulaimy",781733, CPP.LVL_CH, new ChemistryMajor()));
//		students.add(new Student("Ali Mohaideb",781734, CPP.LVL_CR, new Geophysics()));
//		students.add(new Student("Ahmad Mohaideb",781735, CPP.LVL_BR, new Petroleum()));
//		students.add(new Student("Omar Mohaideb",781736, CPP.LVL_CH, new ComputerEngineer()));
//		students.add(new Student("Khalid Alaali",781737, CPP.LVL_CR, new Physics()));
//		students.add(new Student("Abdullah Abdulrahman",781738, CPP.LVL_BR, new Mechanical()));
//		students.add(new Student("Omar Mohaideb",781739, CPP.LVL_BR, new ChemistryMajor()));
//		students.add(new Student("Saud Mohaideb",781740, CPP.LVL_CH, new Physics()));
//		students.add(new Student("Ahmad Abdulrahman",781741, CPP.LVL_BR, new Mechanical()));
//		students.add(new Student("Raif Alaali",781742, CPP.LVL_CR, new ComputerScience()));
//		students.add(new Student("Ali Abdulrahman",781743, CPP.LVL_CR, new ComputerScience()));
//		students.add(new Student("Khalid Mohaideb",781744, CPP.LVL_CH, new Mechanical()));
//		students.add(new Student("Ahmad Sulaimy",781745, CPP.LVL_CH, new ComputerEngineer()));
//		students.add(new Student("Raif Abdulrahman",781746, CPP.LVL_BR, new ComputerEngineer()));
//		students.add(new Student("Omar Bakulka",781747, CPP.LVL_CR, new Geophysics()));
//		students.add(new Student("Ahmad Bakulka",781748, CPP.LVL_BR, new Geology()));
//		students.add(new Student("Mohammad Jacob",781749, CPP.LVL_CH, new ChemistryMajor()));
//		students.add(new Student("Raif Sulaimy",781750, CPP.LVL_BR, new ChemicalEngineering()));
//		students.add(new Student("Ali Abdulrahman",781751, CPP.LVL_AR, new ComputerScience()));
//		students.add(new Student("Ali Abdulrahman",781752, CPP.LVL_BR, new Petroleum()));
//		students.add(new Student("Abdullah Jacob",781753, CPP.LVL_BR, new ComputerEngineer()));
//		students.add(new Student("Abdullah Abdulrahman",781754, CPP.LVL_AR, new Geology()));
//		students.add(new Student("Khalid Alaali",781755, CPP.LVL_CR, new ChemistryMajor()));
//		students.add(new Student("Ahmad Alaali",781756, CPP.LVL_CH, new Mechanical()));
//		students.add(new Student("Saud Alaali",781757, CPP.LVL_AR, new Physics()));
//		students.add(new Student("Ahmad Sulaimy",781758, CPP.LVL_CR, new Geophysics()));
//		students.add(new Student("Saud Jacob",781759, CPP.LVL_CR, new Physics()));
//		students.add(new Student("Saud Jacob",781760, CPP.LVL_CR, new Geology()));
//		students.add(new Student("Raif Sulaimy",781761, CPP.LVL_BR, new Petroleum()));
//		students.add(new Student("Omar Sulaimy",781762, CPP.LVL_BR, new Geophysics()));
//		students.add(new Student("Abdullah Jacob",781763, CPP.LVL_CR, new ComputerEngineer()));
//		students.add(new Student("Khalid Sulaimy",781764, CPP.LVL_AR, new ChemistryMajor()));
//		students.add(new Student("Abdullah Abdulrahman",781765, CPP.LVL_CH, new Electrical()));
//		students.add(new Student("Abdullah Alaali",781766, CPP.LVL_BR, new Mechanical()));
//		students.add(new Student("Khalid Sulaimy",781767, CPP.LVL_CR, new Geophysics()));
//		students.add(new Student("Mohammad Sulaimy",781768, CPP.LVL_CH, new ChemicalEngineering()));
//		students.add(new Student("Ahmad Mohaideb",781769, CPP.LVL_BR, new ChemistryMajor()));
//		students.add(new Student("Ali Bakulka",781770, CPP.LVL_CR, new Physics()));
//		students.add(new Student("Ali Abdulrahman",781771, CPP.LVL_CR, new ChemistryMajor()));
//		students.add(new Student("Saud Mohaideb",781772, CPP.LVL_BR, new ComputerScience()));
//		students.add(new Student("Ali Bakulka",781773, CPP.LVL_CH, new Physics()));
//		students.add(new Student("Ahmad Alaali",781774, CPP.LVL_AR, new Mechanical()));
//		students.add(new Student("Mohammad Mohaideb",781775, CPP.LVL_CR, new ChemicalEngineering()));
//		students.add(new Student("Saud Bakulka",781776, CPP.LVL_CH, new Physics()));
//		students.add(new Student("Omar Mohaideb",781777, CPP.LVL_BR, new Geology()));
//		students.add(new Student("Khalid Sulaimy",781778, CPP.LVL_AR, new ChemicalEngineering()));
//		students.add(new Student("Saud Jacob",781779, CPP.LVL_CR, new Physics()));
//		students.add(new Student("Raif Alaali",781780, CPP.LVL_CR, new Petroleum()));
//		students.add(new Student("Ali Jacob",781781, CPP.LVL_AR, new Geophysics()));
//		students.add(new Student("Saud Alaali",781782, CPP.LVL_CR, new Geophysics()));
//		students.add(new Student("Ahmad Sulaimy",781783, CPP.LVL_BR, new Geology()));
//		students.add(new Student("Khalid Sulaimy",781784, CPP.LVL_CH, new Geophysics()));
//		students.add(new Student("Ahmad Abdulrahman",781785, CPP.LVL_AR, new Geophysics()));
//		students.add(new Student("Mohammad Abdulrahman",781786, CPP.LVL_CR, new ComputerEngineer()));
//		students.add(new Student("Saud Sulaimy",781787, CPP.LVL_AR, new ChemicalEngineering()));
//		students.add(new Student("Omar Abdulrahman",781788, CPP.LVL_BR, new Electrical()));
//		students.add(new Student("Mohammad Abdulrahman",781789, CPP.LVL_CH, new Mechanical()));
//		students.add(new Student("Ali Sulaimy",781790, CPP.LVL_CR, new ChemicalEngineering()));
//		students.add(new Student("Saud Alaali",781791, CPP.LVL_AR, new Mechanical()));
//		students.add(new Student("Khalid Alaali",781792, CPP.LVL_CR, new ChemicalEngineering()));
//		students.add(new Student("Ali Mohaideb",781793, CPP.LVL_BR, new ComputerScience()));
//		students.add(new Student("Ahmad Alaali",781794, CPP.LVL_CH, new Geophysics()));
//		students.add(new Student("Ali Abdulrahman",781795, CPP.LVL_AR, new Physics()));
//		students.add(new Student("Abdullah Mohaideb",781796, CPP.LVL_BR, new Mechanical()));
//		students.add(new Student("Omar Bakulka",781797, CPP.LVL_AR, new Physics()));
//		students.add(new Student("Ahmad Alaali",781798, CPP.LVL_CR, new ComputerEngineer()));
//		students.add(new Student("Ali Bakulka",781799, CPP.LVL_BR, new ComputerEngineer()));
//		students.add(new Student("Saud Abdulrahman",781800, CPP.LVL_CR, new ComputerEngineer()));
//		students.add(new Student("Ahmad Mohaideb",781801, CPP.LVL_BR, new ChemicalEngineering()));
//		students.add(new Student("Mohammad Mohaideb",781802, CPP.LVL_AR, new Geophysics()));
//		students.add(new Student("Khalid Jacob",781803, CPP.LVL_AR, new Geology()));
//		students.add(new Student("Ali Alaali",781804, CPP.LVL_AR, new Geophysics()));
//		students.add(new Student("Ali Bakulka",781805, CPP.LVL_CH, new Petroleum()));
//		students.add(new Student("Ahmad Sulaimy",781806, CPP.LVL_CR, new Physics()));
//		students.add(new Student("Saud Bakulka",781807, CPP.LVL_CR, new ComputerScience()));
//		students.add(new Student("Ali Mohaideb",781808, CPP.LVL_CR, new Mechanical()));
//		students.add(new Student("Omar Jacob",781809, CPP.LVL_CH, new ComputerScience()));
//		students.add(new Student("Khalid Sulaimy",781810, CPP.LVL_CH, new Geology()));
//		students.add(new Student("Mohammad Sulaimy",781811, CPP.LVL_CR, new ComputerScience()));
//		students.add(new Student("Mohammad Bakulka",781812, CPP.LVL_BR, new Petroleum()));
//		students.add(new Student("Raif Mohaideb",781813, CPP.LVL_CH, new Mechanical()));
//		students.add(new Student("Khalid Alaali",781814, CPP.LVL_CR, new ComputerScience()));
//		students.add(new Student("Khalid Jacob",781815, CPP.LVL_CH, new ChemistryMajor()));
//		students.add(new Student("Abdullah Jacob",781816, CPP.LVL_CR, new Geology()));
//		students.add(new Student("Omar Abdulrahman",781817, CPP.LVL_BR, new ComputerScience()));
//		students.add(new Student("Ahmad Sulaimy",781818, CPP.LVL_CH, new Geophysics()));
//		students.add(new Student("Ali Jacob",781819, CPP.LVL_BR, new ChemistryMajor()));
//		students.add(new Student("Ali Alaali",781820, CPP.LVL_AR, new Electrical()));
//		students.add(new Student("Mohammad Bakulka",781821, CPP.LVL_AR, new Petroleum()));
//		students.add(new Student("Mohammad Sulaimy",781822, CPP.LVL_CH, new Geology()));
//		students.add(new Student("Ali Bakulka",781823, CPP.LVL_CH, new ChemicalEngineering()));
//		students.add(new Student("Mohammad Jacob",781824, CPP.LVL_CH, new Electrical()));
//		students.add(new Student("Saud Sulaimy",781825, CPP.LVL_CR, new ComputerEngineer()));
//		students.add(new Student("Ahmad Abdulrahman",781826, CPP.LVL_CR, new ChemicalEngineering()));
//		students.add(new Student("Ali Abdulrahman",781827, CPP.LVL_CR, new Mechanical()));
//		students.add(new Student("Ali Sulaimy",781828, CPP.LVL_AR, new ComputerEngineer()));
//		students.add(new Student("Raif Abdulrahman",781829, CPP.LVL_BR, new Physics()));
//		students.add(new Student("Saud Abdulrahman",781830, CPP.LVL_CH, new Geology()));
//		students.add(new Student("Ali Sulaimy",781831, CPP.LVL_CR, new Physics()));
//		students.add(new Student("Raif Bakulka",781832, CPP.LVL_CR, new ChemistryMajor()));
//		students.add(new Student("Abdullah Abdulrahman",781833, CPP.LVL_BR, new ComputerScience()));
//		students.add(new Student("Ali Sulaimy",781834, CPP.LVL_BR, new Geology()));
//		students.add(new Student("Khalid Bakulka",781835, CPP.LVL_CH, new ComputerEngineer()));
//		students.add(new Student("Ahmad Jacob",781836, CPP.LVL_BR, new ComputerScience()));
//		students.add(new Student("Mohammad Jacob",781837, CPP.LVL_CR, new Physics()));
//		students.add(new Student("Raif Jacob",781838, CPP.LVL_AR, new Geology()));
//		students.add(new Student("Raif Abdulrahman",781839, CPP.LVL_CR, new ChemicalEngineering()));
//		students.add(new Student("Mohammad Jacob",781840, CPP.LVL_BR, new ChemistryMajor()));
//		students.add(new Student("Ahmad Abdulrahman",781841, CPP.LVL_BR, new Mechanical()));
//		students.add(new Student("Khalid Sulaimy",781842, CPP.LVL_AR, new ComputerEngineer()));
//		students.add(new Student("Abdullah Mohaideb",781843, CPP.LVL_CR, new Petroleum()));
//		students.add(new Student("Abdullah Sulaimy",781844, CPP.LVL_CH, new ComputerScience()));
//		students.add(new Student("Raif Sulaimy",781845, CPP.LVL_AR, new Electrical()));
//		students.add(new Student("Saud Bakulka",781846, CPP.LVL_CR, new ComputerScience()));
//		students.add(new Student("Ali Jacob",781847, CPP.LVL_AR, new ChemicalEngineering()));
//		students.add(new Student("Raif Sulaimy",781848, CPP.LVL_BR, new ComputerScience()));
//		students.add(new Student("Khalid Sulaimy",781849, CPP.LVL_CH, new ComputerEngineer()));
//		students.add(new Student("Raif Mohaideb",781850, CPP.LVL_CR, new Mechanical()));
//		students.add(new Student("Khalid Bakulka",781851, CPP.LVL_CH, new Petroleum()));
//		students.add(new Student("Khalid Bakulka",781852, CPP.LVL_AR, new Geophysics()));
//		students.add(new Student("Mohammad Alaali",781853, CPP.LVL_CR, new Physics()));
//		students.add(new Student("Mohammad Abdulrahman",781854, CPP.LVL_AR, new Geology()));
//		students.add(new Student("Ahmad Mohaideb",781855, CPP.LVL_CR, new ComputerScience()));
//		students.add(new Student("Mohammad Mohaideb",781856, CPP.LVL_CH, new Mechanical()));
//		students.add(new Student("Saud Bakulka",781857, CPP.LVL_BR, new ComputerScience()));
//		students.add(new Student("Raif Abdulrahman",781858, CPP.LVL_CR, new ChemistryMajor()));
//		students.add(new Student("Raif Bakulka",781859, CPP.LVL_CH, new ChemicalEngineering()));
//		students.add(new Student("Khalid Bakulka",781860, CPP.LVL_CR, new Electrical()));
//		students.add(new Student("Saud Jacob",781861, CPP.LVL_CR, new Geology()));
//		students.add(new Student("Raif Jacob",781862, CPP.LVL_CH, new Physics()));
//		students.add(new Student("Khalid Sulaimy",781863, CPP.LVL_AR, new Petroleum()));
//		students.add(new Student("Ahmad Bakulka",781864, CPP.LVL_CH, new Electrical()));
//		students.add(new Student("Ahmad Jacob",781865, CPP.LVL_BR, new ChemicalEngineering()));
//		students.add(new Student("Khalid Abdulrahman",781866, CPP.LVL_AR, new Electrical()));
//		students.add(new Student("Saud Sulaimy",781867, CPP.LVL_CR, new Physics()));
//		students.add(new Student("Khalid Abdulrahman",781868, CPP.LVL_CR, new Petroleum()));
//		students.add(new Student("Raif Bakulka",781869, CPP.LVL_BR, new Electrical()));
//		students.add(new Student("Abdullah Bakulka",781870, CPP.LVL_CH, new Petroleum()));
//		students.add(new Student("Ahmad Mohaideb",781871, CPP.LVL_CH, new ChemicalEngineering()));
//		students.add(new Student("Omar Sulaimy",781872, CPP.LVL_BR, new Geophysics()));
//		students.add(new Student("Saud Mohaideb",781873, CPP.LVL_BR, new Petroleum()));
//		students.add(new Student("Saud Bakulka",781874, CPP.LVL_CR, new Petroleum()));
//		students.add(new Student("Ahmad Sulaimy",781875, CPP.LVL_BR, new Electrical()));
//		students.add(new Student("Khalid Bakulka",781876, CPP.LVL_CR, new Mechanical()));
//		students.add(new Student("Mohammad Alaali",781877, CPP.LVL_BR, new Electrical()));
//		students.add(new Student("Saud Alaali",781878, CPP.LVL_AR, new Mechanical()));
//		students.add(new Student("Abdullah Mohaideb",781879, CPP.LVL_CR, new Petroleum()));
//		students.add(new Student("Ali Alaali",781880, CPP.LVL_CH, new Petroleum()));
//		students.add(new Student("Saud Abdulrahman",781881, CPP.LVL_AR, new Geology()));
//		students.add(new Student("Ahmad Mohaideb",781882, CPP.LVL_CR, new Physics()));
//		students.add(new Student("Raif Sulaimy",781883, CPP.LVL_AR, new ComputerScience()));
//		students.add(new Student("Ahmad Mohaideb",781884, CPP.LVL_BR, new ChemicalEngineering()));
//		students.add(new Student("Raif Mohaideb",781885, CPP.LVL_AR, new Physics()));
//		students.add(new Student("Omar Sulaimy",781886, CPP.LVL_CR, new Electrical()));
//		students.add(new Student("Abdullah Alaali",781887, CPP.LVL_AR, new Geology()));
//		students.add(new Student("Saud Abdulrahman",781888, CPP.LVL_AR, new Geology()));
//		students.add(new Student("Ali Sulaimy",781889, CPP.LVL_BR, new Electrical()));
//		students.add(new Student("Raif Bakulka",781890, CPP.LVL_CR, new Geophysics()));
//		students.add(new Student("Saud Jacob",781891, CPP.LVL_CH, new ComputerEngineer()));
//		students.add(new Student("Ahmad Alaali",781892, CPP.LVL_CH, new Physics()));
//		students.add(new Student("Ahmad Bakulka",781893, CPP.LVL_CR, new Mechanical()));
//		students.add(new Student("Saud Alaali",781894, CPP.LVL_CH, new ChemistryMajor()));
//		students.add(new Student("Khalid Alaali",781895, CPP.LVL_CR, new Geology()));
//		students.add(new Student("Khalid Abdulrahman",781896, CPP.LVL_CH, new Geophysics()));
//		students.add(new Student("Omar Bakulka",781897, CPP.LVL_CR, new ComputerEngineer()));
//		students.add(new Student("Khalid Mohaideb",781898, CPP.LVL_BR, new Petroleum()));
//		students.add(new Student("Ahmad Abdulrahman",781899, CPP.LVL_CR, new ChemicalEngineering()));
//		students.add(new Student("Ahmad Abdulrahman",781900, CPP.LVL_CR, new Petroleum()));
//		students.add(new Student("Saud Alaali",781901, CPP.LVL_AR, new Geophysics()));
//		students.add(new Student("Khalid Jacob",781902, CPP.LVL_BR, new Geology()));
//		students.add(new Student("Saud Mohaideb",781903, CPP.LVL_CH, new ComputerScience()));
//		students.add(new Student("Khalid Bakulka",781904, CPP.LVL_CR, new Petroleum()));
//		students.add(new Student("Ahmad Jacob",781905, CPP.LVL_CH, new ComputerScience()));
//		students.add(new Student("Abdullah Mohaideb",781906, CPP.LVL_AR, new Electrical()));
//		students.add(new Student("Raif Bakulka",781907, CPP.LVL_CH, new ChemistryMajor()));
//		students.add(new Student("Omar Mohaideb",781908, CPP.LVL_CR, new Petroleum()));
//		students.add(new Student("Ali Sulaimy",781909, CPP.LVL_CH, new Petroleum()));
//		students.add(new Student("Saud Alaali",781910, CPP.LVL_AR, new Electrical()));
//		students.add(new Student("Abdullah Mohaideb",781911, CPP.LVL_BR, new Geophysics()));
//		students.add(new Student("Khalid Alaali",781912, CPP.LVL_CH, new Petroleum()));
//		students.add(new Student("Saud Abdulrahman",781913, CPP.LVL_AR, new Physics()));
//		students.add(new Student("Mohammad Mohaideb",781914, CPP.LVL_CR, new ComputerEngineer()));
//		students.add(new Student("Ahmad Alaali",781915, CPP.LVL_CR, new Petroleum()));
//		students.add(new Student("Raif Alaali",781916, CPP.LVL_CR, new ComputerScience()));
//		students.add(new Student("Abdullah Bakulka",781917, CPP.LVL_BR, new Mechanical()));
//		students.add(new Student("Mohammad Jacob",781918, CPP.LVL_CR, new ComputerEngineer()));
//		students.add(new Student("Raif Jacob",781919, CPP.LVL_BR, new ComputerEngineer()));
	}
	
	public ArrayList<Student> getStudents(){
		return students;
	}
}
