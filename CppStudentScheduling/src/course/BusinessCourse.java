package course;

import majors.Major;

public  class BusinessCourse extends Coursee{

	public BusinessCourse(String subject, int dailyPer, String tool,
			Coursee required, boolean priority) {
		super(subject, dailyPer, tool, required, priority);
		// TODO Auto-generated constructor stub
	}

	
	public BusinessCourse(String subject, String tool, Coursee required,
			boolean priority, boolean honor, Major strict) {
		super(subject, tool, required, priority, honor, strict);
		// TODO Auto-generated constructor stub
	}


	public BusinessCourse(String subject, String tool, Coursee required,
			boolean priority, boolean honor, Major[] strict) {
		super(subject, tool, required, priority, honor, strict);
		// TODO Auto-generated constructor stub
	}


	public BusinessCourse(String subject, String tool, Coursee required,
			boolean priority, boolean honor) {
		super(subject, tool, required, priority, honor);
		// TODO Auto-generated constructor stub
	}


	public BusinessCourse(String subject, String tool, Coursee required,
			boolean priority) {
		super(subject, tool, required, priority);
		// TODO Auto-generated constructor stub
	}


	public interface businessable{
		
	}
}
