package course;

import majors.Major;

public class ChemistryCourse extends Science{

	public ChemistryCourse(String subject, int dailyPer, int weekPer,
			String tool, Coursee required, boolean priority, boolean honor,
			Major[] strict) {
		super(subject, dailyPer, weekPer, tool, required, priority, honor, strict);
		// TODO Auto-generated constructor stub
	}

	public ChemistryCourse(String subject, int dailyPer, int weekPer,
			String tool, Coursee required, boolean priority) {
		super(subject, dailyPer, weekPer, tool, required, priority);
		// TODO Auto-generated constructor stub
	}

	public ChemistryCourse(String subject, String tool, Coursee required,
			boolean priority, boolean honor) {
		super(subject, tool, required, priority, honor);
		// TODO Auto-generated constructor stub
	}

	public ChemistryCourse(String subject, String tool, Coursee required,
			boolean priority) {
		super(subject, tool, required, priority);
		// TODO Auto-generated constructor stub
	}

	
}
