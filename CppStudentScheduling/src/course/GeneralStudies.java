package course;

import core.CPP;

public class GeneralStudies extends Coursee {

	public GeneralStudies(String subject, int dailyPer, String tool,
			Coursee required) {
		super(subject, dailyPer, 1, tool, required, false);
		setLevel(CPP.LVL_ALL);
	}

}
