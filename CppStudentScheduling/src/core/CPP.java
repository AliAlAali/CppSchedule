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
import course.ComputerStudies;
import course.Coursee;
import course.English;
import course.GeneralStudies;
import course.Mathematics;
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

	private Coursee[] courses; // array of offered courses
	private Major[] majorrs;

	private List<Teacher> teachers;
	private List<Student> students;

	private List<ClassRoom> rooms;
	private Major[] majors;
	
	public CPP() {
		teachers = new ArrayList<Teacher>();
		students = new ArrayList<Student>();
		rooms = new ArrayList<ClassRoom>();
		courses = initializeCourses();
		majors = initializeMajors();
	}

	public CPP(List<Teacher> teachers) {

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
		Coursee eng021 = new English("ENGL021", 2, 10, null, null, CPP.LVL_AR);
		Coursee eng023 = new English("ENGL023", 2, 10, null, eng021, CPP.LVL_AR);
		Coursee eng024 = new English("ENGL024", 2, 10, null, eng023, CPP.LVL_AR);
		Coursee eng031 = new English("ENGL031", 1, 4, null, null);
		eng031.setPriority(false);
		Coursee eng033 = new English("ENGL033", 2, 10, null, eng024, CPP.LVL_AR);
		Coursee eng025 = new English("ENG025", 2, 10, null, null, LVL_C);
		Coursee eng035 = new English("ENG035", 2, 10, null, eng025, LVL_C);
		Coursee eng036 = new English("ENGL036", 2, 10, null, eng025);
		Coursee eng043 = new English("ENGL043", 2, 10, null, eng036, CPP.LVL_AR);

		// General Studies
		Coursee pf1 = new GeneralStudies("PF1", 2, ClassRoom.DES_GYM, null);
		Coursee pf2 = new GeneralStudies("PF2", 2, ClassRoom.DES_GYM, pf1);
		Coursee cs010 = new GeneralStudies("CS010", 1, null, null);
		Coursee hs010 = new GeneralStudies("HS010", 1, null, null);
		Coursee icut030 = new GeneralStudies("ICUT030", 1, null, null);

		// pure science - NEED TO PUT RESTRICTIONS TO THE MAJOR AND INSTANCE OF
		Coursee appp031 = new Science("APPP031", 1, 4, null, null, true, false, null);
		Coursee appp032 = new Science("APPP032", 1, 4, null, appp031, true, false, physics);
		Coursee appc033 = new Science("APPC033", 1, 4, null, appp032, true, false, physics);
		Coursee phys045 = new Science("PHYS045", 1, 4, ClassRoom.DES_PH_LAB, appc033, false, true, mechanical_electrical_stric);
		Coursee geo020 = new Science("GEO020", 1, 4, null, null, false, true, geology_geophysics_Pertl_stric);
		Coursee apcp035 = new Science("APCP035", 1, 4, null, null, true, false, null);
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
		Coursee cswp010 = new ComputerStudies("CSWP010", 1, 4, ClassRoom.DES_COM_LAB, null, false, null);
		Coursee csas030 = new ComputerStudies("CSAS030", 1, 4, ClassRoom.DES_COM_LAB, null, false, null);
		Coursee csjv101 = new ComputerStudies("CSJV010", 1, 4, ClassRoom.DES_COM_LAB, null, false, CPP.LVL_C ,engineer);
		Coursee cscp101 = new ComputerStudies("CSCP010", 1, 4, ClassRoom.DES_COM_LAB, null, false ,CPP.LVL_AR, null);
		Coursee cscp0101 = new ComputerStudies("CSCP010", 1, 4, ClassRoom.DES_COM_LAB, null, false, CPP.LVL_C ,business);
		Coursee csdb101 = new ComputerStudies("CSCP010", 1, 4, ClassRoom.DES_COM_LAB, null, false, CPP.LVL_C ,business);
		Coursee apcs101 = new ComputerStudies("APCS101", 1, 4, null, null, false ,compSc);
		Coursee apcs102 = new ComputerStudies("APCS102", 1, 4, null, apcs101, false ,compSc);
		Coursee apcs103 = new ComputerStudies("APCS103", 1, 4, null, apcs102, false ,compSc);
		Coursee csca101 = new ComputerStudies("CSCA101", 1, 4, null, null, false ,computers);

		

		Coursee[] courses = { eng021, eng023, eng024, eng025, eng031, eng033,
				eng035, eng036, eng043, pf1, pf2, cs010, hs010, icut030, appp031, appp032, appc033, phys045,geo020,
				apcp035 , appp041, apch050, apch051, chem041, math101, math102, apca040, csdm101, cswp010, csas030,
				csjv101, cscp101, cscp0101, csdb101, apcs101, apcs102, apcs103, csca101};
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
}
