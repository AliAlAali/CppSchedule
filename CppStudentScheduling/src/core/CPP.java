package core;
import java.util.ArrayList;
import java.util.List;

import majors.Major;
import people.Student;
import people.Teacher;
import course.Coursee;
import course.English;
import course.GeneralStudies;

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

	//private List<ClassRoom> rooms;

	private String[] majors;
	private String[] levels = { "CH", "CR", "BR", "AR" };
	private String[] tracks = { "Eng", "Sc", "Bus" }; // engineering, science,
														// business

	public CPP() {
		teachers = new ArrayList<Teacher>();
		students = new ArrayList<Student>();
		//rooms = new ArrayList<ClassRoom>();
		//courses = prepareCourses(); // fixed amount of courses that are offered
									// to
									// students
		courses = initializeCourses();
	}

	public CPP(List<Teacher> teachers) {

	}

	public String getLevel(int rank) {
		return levels[rank];
	}

	/*
	 *@param ind 0: engineering, 1: computer science, 2:business
	 */
	public String getTrack(int ind) {
		return tracks[ind];
	}
	
	public String getMajor(int ind){
		return majors[ind];
	}
	
	private Coursee[] initializeCourses(){
		/*
		 * English, General, ComputerStudies, other unrelated courses
		 */
		
		//English courses
		Coursee eng021 = new English("ENGL021", 2, 10, null, null, CPP.LVL_AR);
		Coursee eng023 = new English("ENGL023", 2, 10, null, eng021, CPP.LVL_AR);
		Coursee eng024 = new English("ENGL024", 2, 10, null, eng023, CPP.LVL_AR);
		Coursee eng031 = new English("ENGL031", 1, 4, null, null);
		Coursee eng033 = new English("ENGL033", 2, 10, null, eng024, CPP.LVL_AR);
		Coursee eng036 = new English("ENGL036", 2, 10, null, eng031);
		Coursee eng043 = new English("ENGL043", 2, 10, null, eng036, CPP.LVL_AR);
		Coursee eng025 = new English("ENG025", 2, 10, null, null, LVL_C);
		Coursee eng035 = new English("ENG035", 2, 10, null, eng025, LVL_C);
		
		//General Studies
		Coursee pf1 = new GeneralStudies("PF1", 2, ClassRoom.DES_GYM, null);
		Coursee pf2 = new GeneralStudies("PF2", 2, ClassRoom.DES_GYM, pf1);
		Coursee cs010 = new GeneralStudies("CS010", 1, null, null);
		Coursee hs010 = new GeneralStudies("HS010", 1, null, null);
		Coursee icut030 = new GeneralStudies("ICUT030", 1, null, null);
	
		
		
		Coursee[] courses = {eng021, eng023, eng024, eng025, eng031, eng033, eng035, eng036, eng043, pf1, pf2, cs010, hs010, icut030};
		return courses;
		
	}
	
	public static int getDifficulty(String level){
		if(level.equals(LVL_AR)){
			return -2;
		}else if(level.equals(LVL_BR)){
			return -1;
		}else if(level.equals(LVL_ALL)){
			return 0;
		}else if(level.equals(LVL_CR)){
			return 1;
		}else if(level.equals(LVL_C)){
			return 1;
		}else{
			return 2;
		}
	}
	
	public Coursee findCourse(String subject){
		for (int i = 0; i < courses.length; i++) {
			if(courses[i].getSubject().equals(subject)){
				return courses[i];
			}
		}
		return null;
	}

	private Coursee[] prepareCourses() {
//		// Qualification for CH students only
//		Course.Qualifiable ch_qualification = new Course.Qualifiable() {
//
//			@Override
//			public boolean isQualified(Student student) {
//				if (student.getLevel().equals(getTrack(0))) {
//					return true;
//				} else {
//					return false;
//				}
//			}
//		};
//		
//		Course.Qualifiable ar_qualification = new Course.Qualifiable() {
//
//			@Override
//			public boolean isQualified(Student student) {
//				if (student.getLevel().equals(getTrack(3))) {
//					return true;
//				} else {
//					return false;
//				}
//			}
//		};
//		
//		Course.Qualifiable br_qualification = new Course.Qualifiable() {
//
//			@Override
//			public boolean isQualified(Student student) {
//				if (student.getLevel().equals(getTrack(2))) {
//					return true;
//				} else {
//					return false;
//				}
//			}
//		};
//		
//		Course.Qualifiable cr_qualification = new Course.Qualifiable() {
//
//			@Override
//			public boolean isQualified(Student student) {
//				if (student.getLevel().equals(getTrack(1))) {
//					return true;
//				} else {
//					return false;
//				}
//			}
//		};
//		
//		
//		
//
//		Course.Qualifiable business_qualification = new Course.Qualifiable() {
//
//			@Override
//			public boolean isQualified(Student student) {
//				if (student.getTrack().equals(getLevel(2))) {
//					return true;
//				} else {
//					return false;
//				}
//			}
//		};
//		
//		Course.Qualifiable nonBus_qualification = new Course.Qualifiable() {
//
//			@Override
//			public boolean isQualified(Student student) {
//				if (!student.getTrack().equals(getLevel(2))) {
//					return true;
//				} else {
//					return false;
//				}
//			}
//		};
//		
//		Course.Qualifiable Elec_mech_qualification = new Course.Qualifiable() {
//
//			@Override
//			public boolean isQualified(Student student) {
//				if (student.getMajor().equals(getMajor(2)) || student.getMajor().equals(getMajor(0))) {
//					return true;
//				} else {
//					return false;
//				}
//			}
//		};
//		
//		Course.Qualifiable comSc_qualification = new Course.Qualifiable() {
//
//			@Override
//			public boolean isQualified(Student student) {
//				if (student.getTrack().equals(getLevel(1))) {
//					return true;
//				} else {
//					return false;
//				}
//			}
//		};
//		
//		Course.Qualifiable physics_qualification = new Course.Qualifiable() {
//
//			@Override
//			public boolean isQualified(Student student) {
//				if (student.getMajor().equals(getMajor(0))) {
//					return true;
//				} else {
//					return false;
//				}
//			}
//		};
//		
//		Course.Qualifiable chemist_qualification = new Course.Qualifiable() {
//
//			@Override
//			public boolean isQualified(Student student) {
//				if (student.getMajor().equals(getMajor(0))) {
//					return true;
//				} else {
//					return false;
//				}
//			}
//		};
//
//		// Math courses
//		Course math101 = new Course("MATH101", null, null, true);
//		Course math102 = new Course("MATH102", null, math101, true);
//		Course calcAB = new Course("APCS040", null, math102, true, false, nonBus_qualification);
//		Course discreteMath = new Course("CSDM101", null, null, false, false, comSc_qualification);
//
//		// Science courses
//		Course physicsAP1 = new Course("APPP031", null, null, true);
//		Course physicsAP2 = new Course("APPP032", null, physicsAP1, true, false, physics_qualification);
//		Course physicsAP3 = new Course("APPP033", null, physicsAP2, true, false, physics_qualification);
//		Course physicsFluid = new Course("PHYS045", ClassRoom.DES_PH_LAB, null, true, true, Elec_mech_qualification);
//		Course physicsElectAP = new Course("APPC051", null, null, true, true, ch_qualification);
//
//		Course chimAP1 = new Course("APCP035", null, null, true);
//		Course chimAP2 = new Course("APCP050", null, chimAP1, true);
//		Course chimAP3 = new Course("APCP0051", null, chimAP2, true);
//		Course chimOrgan = new Course("CHEM041", ClassRoom.DES_CH_LAB, null, true, true);
//
//		Course petrMech = new Course("APPP041", null, null, true);
//		Course geology = new Course("GRO020", null, null, true);
//
//		// Technology & Computer Studies
//		Course word = new Course("CSWP010", null, null, false);
//		Course comApp = new Course("CSAS030", null, null, false);
//		Course cPlusPlus = new Course("CSCP101", null, null, false);
//		Course dataBaseProg = new Course("CSAS030", null, null, false, false, business_qualification);
//		Course comSc1 = new Course("APCS101", null, null, true, false, comSc_qualification);
//		Course comSc2 = new Course("APCS102", null, comSc1, true, false, comSc_qualification);
//		Course comSc3 = new Course("APCS103", null, comSc2, true, false, comSc_qualification);
//		Course advJava = new Course("CSJV102", null, comSc3, true, false, comSc_qualification);
//
//		Course[] courses = { math101, math102, calcAB, discreteMath, physicsAP1, physicsAP2, physicsAP3, physicsElectAP,
//				physicsFluid, chimAP1, chimAP2, chimAP3, chimOrgan, petrMech, geology };
//		return courses;
		return null;
	}
	
	public Coursee[] getAvailableCourses(){
		return courses;
	}
}
