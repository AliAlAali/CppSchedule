package course;

import core.CPP;
import majors.Major;

public class Mathematics extends Coursee{

	public Mathematics(String subject, int dailyPer, int weekPer, String tool,
			Coursee required, boolean priority) {
		super(subject, dailyPer, weekPer, tool, required, priority);
		setLevel(CPP.LVL_ALL);
	}


	public Mathematics(String subject, int dailyPer, int weekPer, String tool, Coursee required, boolean priority, boolean honor, Major[] strict) {
		super(subject, tool, required, priority, honor, strict);
		setLevel(CPP.LVL_ALL);
		setPeriodsADay(dailyPer);
		setPeriodsPerWeek(weekPer);
		}

	public Mathematics(String subject, String tool, Coursee required, boolean priority, boolean honor) {
		super(subject, tool, required, priority, honor);
		setLevel(CPP.LVL_ALL);
		}

	public Mathematics(String subject, String tool, Coursee required, boolean priority) {
		super(subject, tool, required, priority);
		setLevel(CPP.LVL_ALL);
		}

	
	

}
