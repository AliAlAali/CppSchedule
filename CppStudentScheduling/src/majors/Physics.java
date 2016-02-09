package majors;

import course.ChemistryCourse;
import course.ComputerStudies;
import course.Coursee;
import course.English;
import course.GeneralStudies;
import course.Mathematics;
import course.PhysicsCourse;
import course.Science;

public class Physics extends Engineering{

	public Physics() {
		this.title = "Physics";
	}
	
	@Override
	public boolean instanceOf(Object son) {
		return super.isInstanceOf(new Physics(), son);
	}

	@Override
	public int relation(Coursee course) {
		int score = 0;
		if(course instanceof English || course instanceof GeneralStudies || course instanceof ComputerStudies || course instanceof Mathematics){
			score = 10;
		}else if(course instanceof PhysicsCourse){
			score = 10;
		}else if(course instanceof ChemistryCourse){
			score = 5;
		}else{
			score = 2;
		}
		return score;
	}
	
}
