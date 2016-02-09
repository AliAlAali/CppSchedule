package majors;

import course.ChemistryCourse;
import course.ComputerStudies;
import course.Coursee;
import course.English;
import course.GeneralStudies;
import course.Mathematics;
import course.PhysicsCourse;

public class Business extends Major{

	public Business() {
		
	}

	@Override
	public boolean instanceOf(Object son) {
		return super.isInstanceOf(new Business(), son);
	}
	
	@Override
	public int relation(Coursee course) {
		int score = 0;
		if(course instanceof English || course instanceof GeneralStudies || course instanceof ComputerStudies || course instanceof Mathematics){
			score = 8;
		}else if(course instanceof PhysicsCourse){
			score = 1;
		}else if(course instanceof ChemistryCourse){
			score = 0;
		}else{
			score = 10;
		}
		return score;
	}
}
