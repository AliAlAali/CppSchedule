package course;

import majors.Major;
import core.CPP;

public class English extends Coursee{

	public English(String subject, int dailyPer, int weekPer, String tool,
			Coursee required) {
		super(subject, dailyPer, weekPer, tool, required, true);
		setLevel(CPP.LVL_ALL);
	}
	
	public English(String subject, int dailyPer, int weekPer, String tool,
			Coursee required, String level) {
		super(subject, dailyPer, weekPer, tool, required, true);
		setLevel(level);
	}

	public English(String subject, int dailyPer, int weekPer, String tool,
			Coursee required, boolean priority) {
		super(subject, dailyPer, weekPer, tool, required, priority);
		setLevel(CPP.LVL_ALL);
		// TODO Auto-generated constructor stub
	}

	public English(String subject, String tool, Coursee required,
			boolean priority, boolean honor, Major strict) {
		super(subject, tool, required, priority, honor, strict);
		setLevel(CPP.LVL_ALL);
		// TODO Auto-generated constructor stub
	}

	public English(String subject, String tool, Coursee required,
			boolean priority, boolean honor, Major[] strict) {
		super(subject, tool, required, priority, honor, strict);
		setLevel(CPP.LVL_ALL);
		// TODO Auto-generated constructor stub
	}

	public English(String subject, String tool, Coursee required,
			boolean priority, boolean honor) {
		super(subject, tool, required, priority, honor);
		setLevel(CPP.LVL_ALL);
		// TODO Auto-generated constructor stub
	}

	public English(String subject, String tool, Coursee required,
			boolean priority) {
		super(subject, tool, required, priority);
		setLevel(CPP.LVL_ALL);
		// TODO Auto-generated constructor stub
	}

	

}
