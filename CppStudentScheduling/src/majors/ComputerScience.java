package majors;

import course.ChemistryCourse;
import course.ComputerStudies;
import course.Coursee;
/*
*Ali alAali
*781735
*/
import course.English;
import course.GeneralStudies;
import course.Mathematics;
import course.PhysicsCourse;

public class ComputerScience extends Major{

	public ComputerScience() {
		
	}

	@Override
	public boolean instanceOf(Object son) {
		return super.isInstanceOf(new ComputerScience(), son);
	}
	
	@Override
	public int relation(Coursee course) {
		int score = 0;
		if(course instanceof English || course instanceof GeneralStudies || course instanceof ComputerStudies || course instanceof Mathematics){
			score = 10;
		}else if(course instanceof PhysicsCourse){
			score = 5;
		}else if(course instanceof ChemistryCourse){
			score = 2;
		}else{
			score = 3;
		}
		return score;
	}
}
