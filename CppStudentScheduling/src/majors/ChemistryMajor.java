package majors;

import course.ChemistryCourse;
import course.ComputerStudies;
import course.Coursee;
import course.English;
import course.GeneralStudies;
import course.Mathematics;
import course.PhysicsCourse;

public class ChemistryMajor extends Chemistry{

	@Override
	public int relation(Coursee course) {
		int score = 0;
		if(course instanceof English || course instanceof GeneralStudies || course instanceof ComputerStudies || course instanceof Mathematics){
			score = 10;
		}else if(course instanceof PhysicsCourse){
			score = 5;
		}else if(course instanceof ChemistryCourse){
			score = 10;
		}else{
			score = 3;
		}
		return score;
	}
}
