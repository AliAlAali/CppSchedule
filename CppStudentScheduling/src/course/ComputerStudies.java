package course;

import core.CPP;
import majors.Major;

public class ComputerStudies extends Coursee{

	public ComputerStudies(String subject, int dailyPer, int weekPer,
			String tool, Coursee required, boolean priority, Major[] strictTo) {
		super(subject,  tool, required, priority, false, strictTo);
		setLevel(CPP.LVL_ALL);
		setPeriodsADay(dailyPer);
		setPeriodsPerWeek(weekPer);
	}
	
	public ComputerStudies(String subject, int dailyPer, int weekPer,
			String tool, Coursee required, boolean priority, String lvl ,Major[] strictTo) {
		super(subject,  tool, required, priority, false, strictTo);
		setLevel(lvl);
		setPeriodsADay(dailyPer);
		setPeriodsPerWeek(weekPer);
	}

	

}
