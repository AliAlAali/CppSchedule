package course;

import core.CPP;
import majors.Major;

public class Science extends Coursee{

	public Science(String subject, int dailyPer, int weekPer, String tool,
			Coursee required, boolean priority) {
		super(subject, dailyPer, weekPer, tool, required, priority);
		setHonor(false);
		setLevel(CPP.LVL_ALL);
	}

	public Science(String subject,int dailyPer, int weekPer ,String tool, Coursee required, boolean priority, boolean honor, Major strict) {
		super(subject, tool, required, priority, honor, strict);
		setPeriodsPerWeek(weekPer);
		setPeriodsADay(dailyPer);
		setLevel(CPP.LVL_ALL);
	}

	public Science(String subject,int dailyPer, int weekPer ,String tool, Coursee required, boolean priority, boolean honor, Major[] strict) {
		super(subject, tool, required, priority, honor, strict);
		setPeriodsPerWeek(weekPer);
		setPeriodsADay(dailyPer);
		setLevel(CPP.LVL_ALL);
		// TODO Auto-generated constructor stub
	}

	public Science(String subject, String tool, Coursee required, boolean priority, boolean honor) {
		super(subject, tool, required, priority, honor);
		setLevel(CPP.LVL_ALL);
		// TODO Auto-generated constructor stub
	}

	public Science(String subject, String tool, Coursee required, boolean priority) {
		super(subject, tool, required, priority);
		// TODO Auto-generated constructor stub
		setLevel(CPP.LVL_ALL);
	}
	
	

	
}
