package majors;

import course.Coursee;
import course.Mathematics;

public class Engineering extends Major{

	public Engineering() {

	}
	
	@Override
	public Coursee[] prepareCourses() {
		
		Coursee apca040 = new Mathematics("APCA040", null, null, true);//TODO should be fixed later
		
		Coursee[] c = {};
		return c;
	}

	
}
