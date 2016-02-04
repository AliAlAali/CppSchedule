import java.util.ArrayList;
import java.util.List;

import people.Student;
import people.Teacher;
import majors.Major;

/*
*Ali alAali
*781735
*/

public class CPP {

	/*
	 * Here Rules and Abstract information about the program
	 */

	private Course[] courses; // array of offered courses
	private Major[] majorrs;

	private List<Teacher> teachers;
	private List<Student> students;

	private List<ClassRoom> rooms;

	private String[] majors;
	private String[] levels = { "CH", "CR", "BR", "AR" };
	private String[] tracks = { "Eng", "Sc", "Bus" }; // engineering, science,
														// business

	public CPP() {
		teachers = new ArrayList<Teacher>();
		students = new ArrayList<Student>();
		rooms = new ArrayList<ClassRoom>();
		courses = prepareCourses(); // fixed amount of courses that are offered
									// to
									// students
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

	private Course[] prepareCourses() {
		// Qualification for CH students only
		Course.Qualifiable ch_qualification = new Course.Qualifiable() {

			@Override
			public boolean isQualified(Student student) {
				if (student.getLevel().equals(getTrack(0))) {
					return true;
				} else {
					return false;
				}
			}
		};
		
		Course.Qualifiable ar_qualification = new Course.Qualifiable() {

			@Override
			public boolean isQualified(Student student) {
				if (student.getLevel().equals(getTrack(3))) {
					return true;
				} else {
					return false;
				}
			}
		};
		
		Course.Qualifiable br_qualification = new Course.Qualifiable() {

			@Override
			public boolean isQualified(Student student) {
				if (student.getLevel().equals(getTrack(2))) {
					return true;
				} else {
					return false;
				}
			}
		};
		
		Course.Qualifiable cr_qualification = new Course.Qualifiable() {

			@Override
			public boolean isQualified(Student student) {
				if (student.getLevel().equals(getTrack(1))) {
					return true;
				} else {
					return false;
				}
			}
		};
		
		
		

		Course.Qualifiable business_qualification = new Course.Qualifiable() {

			@Override
			public boolean isQualified(Student student) {
				if (student.getTrack().equals(getLevel(2))) {
					return true;
				} else {
					return false;
				}
			}
		};
		
		Course.Qualifiable nonBus_qualification = new Course.Qualifiable() {

			@Override
			public boolean isQualified(Student student) {
				if (!student.getTrack().equals(getLevel(2))) {
					return true;
				} else {
					return false;
				}
			}
		};
		
		Course.Qualifiable Elec_mech_qualification = new Course.Qualifiable() {

			@Override
			public boolean isQualified(Student student) {
				if (student.getMajor().equals(getMajor(2)) || student.getMajor().equals(getMajor(0))) {
					return true;
				} else {
					return false;
				}
			}
		};
		
		Course.Qualifiable comSc_qualification = new Course.Qualifiable() {

			@Override
			public boolean isQualified(Student student) {
				if (student.getTrack().equals(getLevel(1))) {
					return true;
				} else {
					return false;
				}
			}
		};
		
		Course.Qualifiable physics_qualification = new Course.Qualifiable() {

			@Override
			public boolean isQualified(Student student) {
				if (student.getMajor().equals(getMajor(0))) {
					return true;
				} else {
					return false;
				}
			}
		};
		
		Course.Qualifiable chemist_qualification = new Course.Qualifiable() {

			@Override
			public boolean isQualified(Student student) {
				if (student.getMajor().equals(getMajor(0))) {
					return true;
				} else {
					return false;
				}
			}
		};

		// Math courses
		Course math101 = new Course("MATH101", null, null, true);
		Course math102 = new Course("MATH102", null, math101, true);
		Course calcAB = new Course("APCS040", null, math102, true, false, nonBus_qualification);
		Course discreteMath = new Course("CSDM101", null, null, false, false, comSc_qualification);

		// Science courses
		Course physicsAP1 = new Course("APPP031", null, null, true);
		Course physicsAP2 = new Course("APPP032", null, physicsAP1, true, false, physics_qualification);
		Course physicsAP3 = new Course("APPP033", null, physicsAP2, true, false, physics_qualification);
		Course physicsFluid = new Course("PHYS045", ClassRoom.DES_PH_LAB, null, true, true, Elec_mech_qualification);
		Course physicsElectAP = new Course("APPC051", null, null, true, true, ch_qualification);

		Course chimAP1 = new Course("APCP035", null, null, true);
		Course chimAP2 = new Course("APCP050", null, chimAP1, true);
		Course chimAP3 = new Course("APCP0051", null, chimAP2, true);
		Course chimOrgan = new Course("CHEM041", ClassRoom.DES_CH_LAB, null, true, true);

		Course petrMech = new Course("APPP041", null, null, true);
		Course geology = new Course("GRO020", null, null, true);

		// Technology & Computer Studies
		Course word = new Course("CSWP010", null, null, false);
		Course comApp = new Course("CSAS030", null, null, false);
		Course cPlusPlus = new Course("CSCP101", null, null, false);
		Course dataBaseProg = new Course("CSAS030", null, null, false, false, business_qualification);
		Course comSc1 = new Course("APCS101", null, null, true, false, comSc_qualification);
		Course comSc2 = new Course("APCS102", null, comSc1, true, false, comSc_qualification);
		Course comSc3 = new Course("APCS103", null, comSc2, true, false, comSc_qualification);
		Course advJava = new Course("CSJV102", null, comSc3, true, false, comSc_qualification);

		Course[] courses = { math101, math102, calcAB, discreteMath, physicsAP1, physicsAP2, physicsAP3, physicsElectAP,
				physicsFluid, chimAP1, chimAP2, chimAP3, chimOrgan, petrMech, geology };
		return courses;
	}
}
