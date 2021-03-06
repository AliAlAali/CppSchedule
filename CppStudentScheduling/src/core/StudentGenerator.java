/*
*Ali alAali
*781735
*/
package core;

import java.util.ArrayList;
import java.util.Random;

import majors.ChemicalEngineering;
import majors.ChemistryMajor;
import majors.ComputerEngineer;
import majors.ComputerScience;
import majors.Electrical;
import majors.Geology;
import majors.Geophysics;
import majors.Major;
import majors.Mechanical;
import majors.Petroleum;
import majors.Physics;
import people.Student;

public class StudentGenerator {

	static ArrayList<Student> students;
	
	public static void main(String[] args) {

		String[] first = { "Ahmad", "Ali", "Raif", "Khalid", "Saud", "Abdullah", "Omar", "Mohammad" };
		String[] last = { "Sulaimy", "Alaali", "Bakulka", "Abdulrahman", "Jacob", "Mohaideb" };
		String[] midInt = { "A", "B", "S", "J", "C", "M", "O", "R" };
		String[] lvl = { CPP.LVL_AR, CPP.LVL_BR, CPP.LVL_CR, CPP.LVL_CH };
		String name;
		int badge = 781620;
		CPP cpp = new CPP();
		Student student = new Student("Ali", 78172, CPP.LVL_AR, new ComputerEngineer());
		Random r = new Random();
		
		 students = new ArrayList<Student>();
		 add();
		System.out.println(percentOf(new ChemicalEngineering()));
//		for (int i = 0; i < 300; i++) {
//			name = first[r.nextInt(first.length)] + " " + last[r.nextInt(last.length)];
//			System.out.println("students.add(new Student(\"" + name + "\"," + badge++ + ", CPP.LVL_" +  lvl[r.nextInt(lvl.length)]
//					+ ", new " + cpp.getMajors()[r.nextInt(cpp.getMajors().length)].getClass().getSimpleName() + "()));");
//			
//
//		}
		
		
	}
	
	public static double percentOf(Major m){
		double sum = 0.0;
		for (Student s : students) {
			if(m.instanceOf(s.getMajor())){
				sum++;
			}
		}
		return sum;
	}
	public static void add(){
		students.add(new Student("Mohammad Alaali",781620, CPP.LVL_CH, new ComputerEngineer()));
		students.add(new Student("Mohammad Mohaideb",781621, CPP.LVL_CR, new Mechanical()));
		students.add(new Student("Ahmad Bakulka",781622, CPP.LVL_CR, new Physics()));
		students.add(new Student("Khalid Bakulka",781623, CPP.LVL_BR, new ComputerEngineer()));
		students.add(new Student("Omar Jacob",781624, CPP.LVL_BR, new ChemistryMajor()));
		students.add(new Student("Saud Bakulka",781625, CPP.LVL_CR, new Petroleum()));
		students.add(new Student("Abdullah Alaali",781626, CPP.LVL_AR, new ComputerEngineer()));
		students.add(new Student("Raif Abdulrahman",781627, CPP.LVL_BR, new Electrical()));
		students.add(new Student("Mohammad Jacob",781628, CPP.LVL_AR, new ComputerScience()));
		students.add(new Student("Khalid Alaali",781629, CPP.LVL_CH, new Mechanical()));
		students.add(new Student("Ahmad Jacob",781630, CPP.LVL_BR, new Physics()));
		students.add(new Student("Khalid Alaali",781631, CPP.LVL_BR, new Mechanical()));
		students.add(new Student("Ali Abdulrahman",781632, CPP.LVL_CH, new ComputerScience()));
		students.add(new Student("Abdullah Bakulka",781633, CPP.LVL_CH, new Geophysics()));
		students.add(new Student("Ali Sulaimy",781634, CPP.LVL_AR, new Physics()));
		students.add(new Student("Mohammad Mohaideb",781635, CPP.LVL_CR, new Geophysics()));
		students.add(new Student("Mohammad Bakulka",781636, CPP.LVL_CR, new ChemicalEngineering()));
		students.add(new Student("Mohammad Alaali",781637, CPP.LVL_CR, new ComputerScience()));
		students.add(new Student("Khalid Jacob",781638, CPP.LVL_CR, new Electrical()));
		students.add(new Student("Ali Jacob",781639, CPP.LVL_CH, new Geophysics()));
		students.add(new Student("Raif Jacob",781640, CPP.LVL_CH, new ComputerScience()));
		students.add(new Student("Omar Sulaimy",781641, CPP.LVL_BR, new ComputerScience()));
		students.add(new Student("Ahmad Jacob",781642, CPP.LVL_CR, new Petroleum()));
		students.add(new Student("Ali Alaali",781643, CPP.LVL_CH, new Electrical()));
		students.add(new Student("Abdullah Alaali",781644, CPP.LVL_BR, new Mechanical()));
		students.add(new Student("Raif Mohaideb",781645, CPP.LVL_AR, new ChemistryMajor()));
		students.add(new Student("Omar Bakulka",781646, CPP.LVL_AR, new Electrical()));
		students.add(new Student("Ahmad Alaali",781647, CPP.LVL_AR, new Geophysics()));
		students.add(new Student("Raif Bakulka",781648, CPP.LVL_CR, new ComputerEngineer()));
		students.add(new Student("Omar Alaali",781649, CPP.LVL_CR, new ComputerScience()));
		students.add(new Student("Saud Alaali",781650, CPP.LVL_BR, new Mechanical()));
		students.add(new Student("Ali Bakulka",781651, CPP.LVL_CH, new ChemistryMajor()));
		students.add(new Student("Omar Sulaimy",781652, CPP.LVL_AR, new Mechanical()));
		students.add(new Student("Raif Alaali",781653, CPP.LVL_CR, new ChemicalEngineering()));
		students.add(new Student("Raif Bakulka",781654, CPP.LVL_CR, new Geophysics()));
		students.add(new Student("Mohammad Bakulka",781655, CPP.LVL_AR, new Physics()));
		students.add(new Student("Khalid Abdulrahman",781656, CPP.LVL_AR, new ChemistryMajor()));
		students.add(new Student("Mohammad Jacob",781657, CPP.LVL_CR, new ChemistryMajor()));
		students.add(new Student("Ahmad Abdulrahman",781658, CPP.LVL_CR, new ChemicalEngineering()));
		students.add(new Student("Omar Bakulka",781659, CPP.LVL_CR, new Mechanical()));
		students.add(new Student("Raif Bakulka",781660, CPP.LVL_BR, new ComputerScience()));
		students.add(new Student("Mohammad Abdulrahman",781661, CPP.LVL_CR, new Geophysics()));
		students.add(new Student("Omar Jacob",781662, CPP.LVL_BR, new ChemicalEngineering()));
		students.add(new Student("Ahmad Sulaimy",781663, CPP.LVL_AR, new Geology()));
		students.add(new Student("Omar Alaali",781664, CPP.LVL_CR, new Electrical()));
		students.add(new Student("Khalid Sulaimy",781665, CPP.LVL_CH, new ChemistryMajor()));
		students.add(new Student("Omar Abdulrahman",781666, CPP.LVL_CH, new Mechanical()));
		students.add(new Student("Omar Abdulrahman",781667, CPP.LVL_CH, new ComputerEngineer()));
		students.add(new Student("Raif Alaali",781668, CPP.LVL_CH, new Electrical()));
		students.add(new Student("Saud Mohaideb",781669, CPP.LVL_CH, new Petroleum()));
		students.add(new Student("Ali Sulaimy",781670, CPP.LVL_CH, new ComputerScience()));
		students.add(new Student("Ali Bakulka",781671, CPP.LVL_CR, new Physics()));
		students.add(new Student("Mohammad Bakulka",781672, CPP.LVL_AR, new Geophysics()));
		students.add(new Student("Omar Bakulka",781673, CPP.LVL_CH, new Geophysics()));
		students.add(new Student("Ali Bakulka",781674, CPP.LVL_CR, new ComputerScience()));
		students.add(new Student("Abdullah Mohaideb",781675, CPP.LVL_CR, new ChemistryMajor()));
		students.add(new Student("Omar Mohaideb",781676, CPP.LVL_BR, new ComputerEngineer()));
		students.add(new Student("Saud Mohaideb",781677, CPP.LVL_CR, new Geology()));
		students.add(new Student("Saud Mohaideb",781678, CPP.LVL_CH, new Petroleum()));
		students.add(new Student("Ahmad Sulaimy",781679, CPP.LVL_CR, new Geology()));
		students.add(new Student("Omar Sulaimy",781680, CPP.LVL_BR, new Geophysics()));
		students.add(new Student("Ahmad Bakulka",781681, CPP.LVL_CR, new Electrical()));
		students.add(new Student("Saud Jacob",781682, CPP.LVL_CR, new ComputerScience()));
		students.add(new Student("Mohammad Bakulka",781683, CPP.LVL_CH, new Geology()));
		students.add(new Student("Saud Bakulka",781684, CPP.LVL_CR, new Geophysics()));
		students.add(new Student("Abdullah Alaali",781685, CPP.LVL_CH, new Geophysics()));
		students.add(new Student("Ali Bakulka",781686, CPP.LVL_BR, new ComputerScience()));
		students.add(new Student("Saud Abdulrahman",781687, CPP.LVL_CH, new ComputerScience()));
		students.add(new Student("Ali Abdulrahman",781688, CPP.LVL_AR, new ComputerEngineer()));
		students.add(new Student("Ahmad Jacob",781689, CPP.LVL_CH, new ChemicalEngineering()));
		students.add(new Student("Mohammad Jacob",781690, CPP.LVL_CH, new ChemistryMajor()));
		students.add(new Student("Saud Mohaideb",781691, CPP.LVL_AR, new Geophysics()));
		students.add(new Student("Abdullah Sulaimy",781692, CPP.LVL_BR, new ComputerScience()));
		students.add(new Student("Saud Bakulka",781693, CPP.LVL_CH, new Electrical()));
		students.add(new Student("Ali Bakulka",781694, CPP.LVL_BR, new ChemicalEngineering()));
		students.add(new Student("Abdullah Mohaideb",781695, CPP.LVL_CR, new Geology()));
		students.add(new Student("Ali Jacob",781696, CPP.LVL_CR, new ChemicalEngineering()));
		students.add(new Student("Khalid Sulaimy",781697, CPP.LVL_BR, new Physics()));
		students.add(new Student("Khalid Mohaideb",781698, CPP.LVL_AR, new Electrical()));
		students.add(new Student("Ali Bakulka",781699, CPP.LVL_CR, new ComputerScience()));
		students.add(new Student("Khalid Alaali",781700, CPP.LVL_BR, new ComputerScience()));
		students.add(new Student("Raif Jacob",781701, CPP.LVL_CH, new ComputerEngineer()));
		students.add(new Student("Saud Alaali",781702, CPP.LVL_CH, new Geophysics()));
		students.add(new Student("Mohammad Sulaimy",781703, CPP.LVL_CR, new ChemistryMajor()));
		students.add(new Student("Khalid Sulaimy",781704, CPP.LVL_AR, new Geology()));
		students.add(new Student("Saud Bakulka",781705, CPP.LVL_AR, new ChemicalEngineering()));
		students.add(new Student("Saud Mohaideb",781706, CPP.LVL_CH, new Mechanical()));
		students.add(new Student("Ahmad Jacob",781707, CPP.LVL_CR, new Electrical()));
		students.add(new Student("Saud Bakulka",781708, CPP.LVL_AR, new Physics()));
		students.add(new Student("Mohammad Alaali",781709, CPP.LVL_AR, new ChemistryMajor()));
		students.add(new Student("Raif Alaali",781710, CPP.LVL_CR, new Petroleum()));
		students.add(new Student("Raif Mohaideb",781711, CPP.LVL_CR, new Electrical()));
		students.add(new Student("Khalid Jacob",781712, CPP.LVL_CR, new ComputerEngineer()));
		students.add(new Student("Khalid Jacob",781713, CPP.LVL_AR, new ChemicalEngineering()));
		students.add(new Student("Mohammad Abdulrahman",781714, CPP.LVL_CH, new Geology()));
		students.add(new Student("Omar Abdulrahman",781715, CPP.LVL_AR, new Petroleum()));
		students.add(new Student("Raif Mohaideb",781716, CPP.LVL_BR, new Geophysics()));
		students.add(new Student("Abdullah Jacob",781717, CPP.LVL_CR, new ChemicalEngineering()));
		students.add(new Student("Ahmad Sulaimy",781718, CPP.LVL_BR, new ChemistryMajor()));
		students.add(new Student("Khalid Jacob",781719, CPP.LVL_BR, new Geophysics()));
		students.add(new Student("Khalid Jacob",781720, CPP.LVL_CH, new ChemistryMajor()));
		students.add(new Student("Khalid Jacob",781721, CPP.LVL_BR, new Petroleum()));
		students.add(new Student("Abdullah Abdulrahman",781722, CPP.LVL_BR, new ComputerEngineer()));
		students.add(new Student("Raif Alaali",781723, CPP.LVL_CH, new Geophysics()));
		students.add(new Student("Saud Abdulrahman",781724, CPP.LVL_CR, new Electrical()));
		students.add(new Student("Omar Alaali",781725, CPP.LVL_BR, new Mechanical()));
		students.add(new Student("Ahmad Alaali",781726, CPP.LVL_BR, new Geology()));
		students.add(new Student("Mohammad Sulaimy",781727, CPP.LVL_CH, new Geophysics()));
		students.add(new Student("Ali Jacob",781728, CPP.LVL_AR, new Physics()));
		students.add(new Student("Khalid Abdulrahman",781729, CPP.LVL_CH, new Electrical()));
		students.add(new Student("Ahmad Abdulrahman",781730, CPP.LVL_CR, new Petroleum()));
		students.add(new Student("Saud Alaali",781731, CPP.LVL_AR, new ChemistryMajor()));
		students.add(new Student("Omar Mohaideb",781732, CPP.LVL_AR, new ChemicalEngineering()));
		students.add(new Student("Mohammad Sulaimy",781733, CPP.LVL_CH, new ChemistryMajor()));
		students.add(new Student("Ali Mohaideb",781734, CPP.LVL_CR, new Geophysics()));
		students.add(new Student("Ahmad Mohaideb",781735, CPP.LVL_BR, new Petroleum()));
		students.add(new Student("Omar Mohaideb",781736, CPP.LVL_CH, new ComputerEngineer()));
		students.add(new Student("Khalid Alaali",781737, CPP.LVL_CR, new Physics()));
		students.add(new Student("Abdullah Abdulrahman",781738, CPP.LVL_BR, new Mechanical()));
		students.add(new Student("Omar Mohaideb",781739, CPP.LVL_BR, new ChemistryMajor()));
		students.add(new Student("Saud Mohaideb",781740, CPP.LVL_CH, new Physics()));
		students.add(new Student("Ahmad Abdulrahman",781741, CPP.LVL_BR, new Mechanical()));
		students.add(new Student("Raif Alaali",781742, CPP.LVL_CR, new ComputerScience()));
		students.add(new Student("Ali Abdulrahman",781743, CPP.LVL_CR, new ComputerScience()));
		students.add(new Student("Khalid Mohaideb",781744, CPP.LVL_CH, new Mechanical()));
		students.add(new Student("Ahmad Sulaimy",781745, CPP.LVL_CH, new ComputerEngineer()));
		students.add(new Student("Raif Abdulrahman",781746, CPP.LVL_BR, new ComputerEngineer()));
		students.add(new Student("Omar Bakulka",781747, CPP.LVL_CR, new Geophysics()));
		students.add(new Student("Ahmad Bakulka",781748, CPP.LVL_BR, new Geology()));
		students.add(new Student("Mohammad Jacob",781749, CPP.LVL_CH, new ChemistryMajor()));
		students.add(new Student("Raif Sulaimy",781750, CPP.LVL_BR, new ChemicalEngineering()));
		students.add(new Student("Ali Abdulrahman",781751, CPP.LVL_AR, new ComputerScience()));
		students.add(new Student("Ali Abdulrahman",781752, CPP.LVL_BR, new Petroleum()));
		students.add(new Student("Abdullah Jacob",781753, CPP.LVL_BR, new ComputerEngineer()));
		students.add(new Student("Abdullah Abdulrahman",781754, CPP.LVL_AR, new Geology()));
		students.add(new Student("Khalid Alaali",781755, CPP.LVL_CR, new ChemistryMajor()));
		students.add(new Student("Ahmad Alaali",781756, CPP.LVL_CH, new Mechanical()));
		students.add(new Student("Saud Alaali",781757, CPP.LVL_AR, new Physics()));
		students.add(new Student("Ahmad Sulaimy",781758, CPP.LVL_CR, new Geophysics()));
		students.add(new Student("Saud Jacob",781759, CPP.LVL_CR, new Physics()));
		students.add(new Student("Saud Jacob",781760, CPP.LVL_CR, new Geology()));
		students.add(new Student("Raif Sulaimy",781761, CPP.LVL_BR, new Petroleum()));
		students.add(new Student("Omar Sulaimy",781762, CPP.LVL_BR, new Geophysics()));
		students.add(new Student("Abdullah Jacob",781763, CPP.LVL_CR, new ComputerEngineer()));
		students.add(new Student("Khalid Sulaimy",781764, CPP.LVL_AR, new ChemistryMajor()));
		students.add(new Student("Abdullah Abdulrahman",781765, CPP.LVL_CH, new Electrical()));
		students.add(new Student("Abdullah Alaali",781766, CPP.LVL_BR, new Mechanical()));
		students.add(new Student("Khalid Sulaimy",781767, CPP.LVL_CR, new Geophysics()));
		students.add(new Student("Mohammad Sulaimy",781768, CPP.LVL_CH, new ChemicalEngineering()));
		students.add(new Student("Ahmad Mohaideb",781769, CPP.LVL_BR, new ChemistryMajor()));
		students.add(new Student("Ali Bakulka",781770, CPP.LVL_CR, new Physics()));
		students.add(new Student("Ali Abdulrahman",781771, CPP.LVL_CR, new ChemistryMajor()));
		students.add(new Student("Saud Mohaideb",781772, CPP.LVL_BR, new ComputerScience()));
		students.add(new Student("Ali Bakulka",781773, CPP.LVL_CH, new Physics()));
		students.add(new Student("Ahmad Alaali",781774, CPP.LVL_AR, new Mechanical()));
		students.add(new Student("Mohammad Mohaideb",781775, CPP.LVL_CR, new ChemicalEngineering()));
		students.add(new Student("Saud Bakulka",781776, CPP.LVL_CH, new Physics()));
		students.add(new Student("Omar Mohaideb",781777, CPP.LVL_BR, new Geology()));
		students.add(new Student("Khalid Sulaimy",781778, CPP.LVL_AR, new ChemicalEngineering()));
		students.add(new Student("Saud Jacob",781779, CPP.LVL_CR, new Physics()));
		students.add(new Student("Raif Alaali",781780, CPP.LVL_CR, new Petroleum()));
		students.add(new Student("Ali Jacob",781781, CPP.LVL_AR, new Geophysics()));
		students.add(new Student("Saud Alaali",781782, CPP.LVL_CR, new Geophysics()));
		students.add(new Student("Ahmad Sulaimy",781783, CPP.LVL_BR, new Geology()));
		students.add(new Student("Khalid Sulaimy",781784, CPP.LVL_CH, new Geophysics()));
		students.add(new Student("Ahmad Abdulrahman",781785, CPP.LVL_AR, new Geophysics()));
		students.add(new Student("Mohammad Abdulrahman",781786, CPP.LVL_CR, new ComputerEngineer()));
		students.add(new Student("Saud Sulaimy",781787, CPP.LVL_AR, new ChemicalEngineering()));
		students.add(new Student("Omar Abdulrahman",781788, CPP.LVL_BR, new Electrical()));
		students.add(new Student("Mohammad Abdulrahman",781789, CPP.LVL_CH, new Mechanical()));
		students.add(new Student("Ali Sulaimy",781790, CPP.LVL_CR, new ChemicalEngineering()));
		students.add(new Student("Saud Alaali",781791, CPP.LVL_AR, new Mechanical()));
		students.add(new Student("Khalid Alaali",781792, CPP.LVL_CR, new ChemicalEngineering()));
		students.add(new Student("Ali Mohaideb",781793, CPP.LVL_BR, new ComputerScience()));
		students.add(new Student("Ahmad Alaali",781794, CPP.LVL_CH, new Geophysics()));
		students.add(new Student("Ali Abdulrahman",781795, CPP.LVL_AR, new Physics()));
		students.add(new Student("Abdullah Mohaideb",781796, CPP.LVL_BR, new Mechanical()));
		students.add(new Student("Omar Bakulka",781797, CPP.LVL_AR, new Physics()));
		students.add(new Student("Ahmad Alaali",781798, CPP.LVL_CR, new ComputerEngineer()));
		students.add(new Student("Ali Bakulka",781799, CPP.LVL_BR, new ComputerEngineer()));
		students.add(new Student("Saud Abdulrahman",781800, CPP.LVL_CR, new ComputerEngineer()));
		students.add(new Student("Ahmad Mohaideb",781801, CPP.LVL_BR, new ChemicalEngineering()));
		students.add(new Student("Mohammad Mohaideb",781802, CPP.LVL_AR, new Geophysics()));
		students.add(new Student("Khalid Jacob",781803, CPP.LVL_AR, new Geology()));
		students.add(new Student("Ali Alaali",781804, CPP.LVL_AR, new Geophysics()));
		students.add(new Student("Ali Bakulka",781805, CPP.LVL_CH, new Petroleum()));
		students.add(new Student("Ahmad Sulaimy",781806, CPP.LVL_CR, new Physics()));
		students.add(new Student("Saud Bakulka",781807, CPP.LVL_CR, new ComputerScience()));
		students.add(new Student("Ali Mohaideb",781808, CPP.LVL_CR, new Mechanical()));
		students.add(new Student("Omar Jacob",781809, CPP.LVL_CH, new ComputerScience()));
		students.add(new Student("Khalid Sulaimy",781810, CPP.LVL_CH, new Geology()));
		students.add(new Student("Mohammad Sulaimy",781811, CPP.LVL_CR, new ComputerScience()));
		students.add(new Student("Mohammad Bakulka",781812, CPP.LVL_BR, new Petroleum()));
		students.add(new Student("Raif Mohaideb",781813, CPP.LVL_CH, new Mechanical()));
		students.add(new Student("Khalid Alaali",781814, CPP.LVL_CR, new ComputerScience()));
		students.add(new Student("Khalid Jacob",781815, CPP.LVL_CH, new ChemistryMajor()));
		students.add(new Student("Abdullah Jacob",781816, CPP.LVL_CR, new Geology()));
		students.add(new Student("Omar Abdulrahman",781817, CPP.LVL_BR, new ComputerScience()));
		students.add(new Student("Ahmad Sulaimy",781818, CPP.LVL_CH, new Geophysics()));
		students.add(new Student("Ali Jacob",781819, CPP.LVL_BR, new ChemistryMajor()));
		students.add(new Student("Ali Alaali",781820, CPP.LVL_AR, new Electrical()));
		students.add(new Student("Mohammad Bakulka",781821, CPP.LVL_AR, new Petroleum()));
		students.add(new Student("Mohammad Sulaimy",781822, CPP.LVL_CH, new Geology()));
		students.add(new Student("Ali Bakulka",781823, CPP.LVL_CH, new ChemicalEngineering()));
		students.add(new Student("Mohammad Jacob",781824, CPP.LVL_CH, new Electrical()));
		students.add(new Student("Saud Sulaimy",781825, CPP.LVL_CR, new ComputerEngineer()));
		students.add(new Student("Ahmad Abdulrahman",781826, CPP.LVL_CR, new ChemicalEngineering()));
		students.add(new Student("Ali Abdulrahman",781827, CPP.LVL_CR, new Mechanical()));
		students.add(new Student("Ali Sulaimy",781828, CPP.LVL_AR, new ComputerEngineer()));
		students.add(new Student("Raif Abdulrahman",781829, CPP.LVL_BR, new Physics()));
		students.add(new Student("Saud Abdulrahman",781830, CPP.LVL_CH, new Geology()));
		students.add(new Student("Ali Sulaimy",781831, CPP.LVL_CR, new Physics()));
		students.add(new Student("Raif Bakulka",781832, CPP.LVL_CR, new ChemistryMajor()));
		students.add(new Student("Abdullah Abdulrahman",781833, CPP.LVL_BR, new ComputerScience()));
		students.add(new Student("Ali Sulaimy",781834, CPP.LVL_BR, new Geology()));
		students.add(new Student("Khalid Bakulka",781835, CPP.LVL_CH, new ComputerEngineer()));
		students.add(new Student("Ahmad Jacob",781836, CPP.LVL_BR, new ComputerScience()));
		students.add(new Student("Mohammad Jacob",781837, CPP.LVL_CR, new Physics()));
		students.add(new Student("Raif Jacob",781838, CPP.LVL_AR, new Geology()));
		students.add(new Student("Raif Abdulrahman",781839, CPP.LVL_CR, new ChemicalEngineering()));
		students.add(new Student("Mohammad Jacob",781840, CPP.LVL_BR, new ChemistryMajor()));
		students.add(new Student("Ahmad Abdulrahman",781841, CPP.LVL_BR, new Mechanical()));
		students.add(new Student("Khalid Sulaimy",781842, CPP.LVL_AR, new ComputerEngineer()));
		students.add(new Student("Abdullah Mohaideb",781843, CPP.LVL_CR, new Petroleum()));
		students.add(new Student("Abdullah Sulaimy",781844, CPP.LVL_CH, new ComputerScience()));
		students.add(new Student("Raif Sulaimy",781845, CPP.LVL_AR, new Electrical()));
		students.add(new Student("Saud Bakulka",781846, CPP.LVL_CR, new ComputerScience()));
		students.add(new Student("Ali Jacob",781847, CPP.LVL_AR, new ChemicalEngineering()));
		students.add(new Student("Raif Sulaimy",781848, CPP.LVL_BR, new ComputerScience()));
		students.add(new Student("Khalid Sulaimy",781849, CPP.LVL_CH, new ComputerEngineer()));
		students.add(new Student("Raif Mohaideb",781850, CPP.LVL_CR, new Mechanical()));
		students.add(new Student("Khalid Bakulka",781851, CPP.LVL_CH, new Petroleum()));
		students.add(new Student("Khalid Bakulka",781852, CPP.LVL_AR, new Geophysics()));
		students.add(new Student("Mohammad Alaali",781853, CPP.LVL_CR, new Physics()));
		students.add(new Student("Mohammad Abdulrahman",781854, CPP.LVL_AR, new Geology()));
		students.add(new Student("Ahmad Mohaideb",781855, CPP.LVL_CR, new ComputerScience()));
		students.add(new Student("Mohammad Mohaideb",781856, CPP.LVL_CH, new Mechanical()));
		students.add(new Student("Saud Bakulka",781857, CPP.LVL_BR, new ComputerScience()));
		students.add(new Student("Raif Abdulrahman",781858, CPP.LVL_CR, new ChemistryMajor()));
		students.add(new Student("Raif Bakulka",781859, CPP.LVL_CH, new ChemicalEngineering()));
		students.add(new Student("Khalid Bakulka",781860, CPP.LVL_CR, new Electrical()));
		students.add(new Student("Saud Jacob",781861, CPP.LVL_CR, new Geology()));
		students.add(new Student("Raif Jacob",781862, CPP.LVL_CH, new Physics()));
		students.add(new Student("Khalid Sulaimy",781863, CPP.LVL_AR, new Petroleum()));
		students.add(new Student("Ahmad Bakulka",781864, CPP.LVL_CH, new Electrical()));
		students.add(new Student("Ahmad Jacob",781865, CPP.LVL_BR, new ChemicalEngineering()));
		students.add(new Student("Khalid Abdulrahman",781866, CPP.LVL_AR, new Electrical()));
		students.add(new Student("Saud Sulaimy",781867, CPP.LVL_CR, new Physics()));
		students.add(new Student("Khalid Abdulrahman",781868, CPP.LVL_CR, new Petroleum()));
		students.add(new Student("Raif Bakulka",781869, CPP.LVL_BR, new Electrical()));
		students.add(new Student("Abdullah Bakulka",781870, CPP.LVL_CH, new Petroleum()));
		students.add(new Student("Ahmad Mohaideb",781871, CPP.LVL_CH, new ChemicalEngineering()));
		students.add(new Student("Omar Sulaimy",781872, CPP.LVL_BR, new Geophysics()));
		students.add(new Student("Saud Mohaideb",781873, CPP.LVL_BR, new Petroleum()));
		students.add(new Student("Saud Bakulka",781874, CPP.LVL_CR, new Petroleum()));
		students.add(new Student("Ahmad Sulaimy",781875, CPP.LVL_BR, new Electrical()));
		students.add(new Student("Khalid Bakulka",781876, CPP.LVL_CR, new Mechanical()));
		students.add(new Student("Mohammad Alaali",781877, CPP.LVL_BR, new Electrical()));
		students.add(new Student("Saud Alaali",781878, CPP.LVL_AR, new Mechanical()));
		students.add(new Student("Abdullah Mohaideb",781879, CPP.LVL_CR, new Petroleum()));
		students.add(new Student("Ali Alaali",781880, CPP.LVL_CH, new Petroleum()));
		students.add(new Student("Saud Abdulrahman",781881, CPP.LVL_AR, new Geology()));
		students.add(new Student("Ahmad Mohaideb",781882, CPP.LVL_CR, new Physics()));
		students.add(new Student("Raif Sulaimy",781883, CPP.LVL_AR, new ComputerScience()));
		students.add(new Student("Ahmad Mohaideb",781884, CPP.LVL_BR, new ChemicalEngineering()));
		students.add(new Student("Raif Mohaideb",781885, CPP.LVL_AR, new Physics()));
		students.add(new Student("Omar Sulaimy",781886, CPP.LVL_CR, new Electrical()));
		students.add(new Student("Abdullah Alaali",781887, CPP.LVL_AR, new Geology()));
		students.add(new Student("Saud Abdulrahman",781888, CPP.LVL_AR, new Geology()));
		students.add(new Student("Ali Sulaimy",781889, CPP.LVL_BR, new Electrical()));
		students.add(new Student("Raif Bakulka",781890, CPP.LVL_CR, new Geophysics()));
		students.add(new Student("Saud Jacob",781891, CPP.LVL_CH, new ComputerEngineer()));
		students.add(new Student("Ahmad Alaali",781892, CPP.LVL_CH, new Physics()));
		students.add(new Student("Ahmad Bakulka",781893, CPP.LVL_CR, new Mechanical()));
		students.add(new Student("Saud Alaali",781894, CPP.LVL_CH, new ChemistryMajor()));
		students.add(new Student("Khalid Alaali",781895, CPP.LVL_CR, new Geology()));
		students.add(new Student("Khalid Abdulrahman",781896, CPP.LVL_CH, new Geophysics()));
		students.add(new Student("Omar Bakulka",781897, CPP.LVL_CR, new ComputerEngineer()));
		students.add(new Student("Khalid Mohaideb",781898, CPP.LVL_BR, new Petroleum()));
		students.add(new Student("Ahmad Abdulrahman",781899, CPP.LVL_CR, new ChemicalEngineering()));
		students.add(new Student("Ahmad Abdulrahman",781900, CPP.LVL_CR, new Petroleum()));
		students.add(new Student("Saud Alaali",781901, CPP.LVL_AR, new Geophysics()));
		students.add(new Student("Khalid Jacob",781902, CPP.LVL_BR, new Geology()));
		students.add(new Student("Saud Mohaideb",781903, CPP.LVL_CH, new ComputerScience()));
		students.add(new Student("Khalid Bakulka",781904, CPP.LVL_CR, new Petroleum()));
		students.add(new Student("Ahmad Jacob",781905, CPP.LVL_CH, new ComputerScience()));
		students.add(new Student("Abdullah Mohaideb",781906, CPP.LVL_AR, new Electrical()));
		students.add(new Student("Raif Bakulka",781907, CPP.LVL_CH, new ChemistryMajor()));
		students.add(new Student("Omar Mohaideb",781908, CPP.LVL_CR, new Petroleum()));
		students.add(new Student("Ali Sulaimy",781909, CPP.LVL_CH, new Petroleum()));
		students.add(new Student("Saud Alaali",781910, CPP.LVL_AR, new Electrical()));
		students.add(new Student("Abdullah Mohaideb",781911, CPP.LVL_BR, new Geophysics()));
		students.add(new Student("Khalid Alaali",781912, CPP.LVL_CH, new Petroleum()));
		students.add(new Student("Saud Abdulrahman",781913, CPP.LVL_AR, new Physics()));
		students.add(new Student("Mohammad Mohaideb",781914, CPP.LVL_CR, new ComputerEngineer()));
		students.add(new Student("Ahmad Alaali",781915, CPP.LVL_CR, new Petroleum()));
		students.add(new Student("Raif Alaali",781916, CPP.LVL_CR, new ComputerScience()));
		students.add(new Student("Abdullah Bakulka",781917, CPP.LVL_BR, new Mechanical()));
		students.add(new Student("Mohammad Jacob",781918, CPP.LVL_CR, new ComputerEngineer()));
		students.add(new Student("Raif Jacob",781919, CPP.LVL_BR, new ComputerEngineer()));

	}
}
