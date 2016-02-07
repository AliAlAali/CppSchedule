package majors;

import course.Coursee;
import course.Science;

public class Physics extends Engineering{

	public Physics() {
		courses = Coursee.mergeCourses(super.prepareCourses(), prepareCourses());
	}

	@Override
	public Coursee[] prepareCourses() {
		Major[] mechanical_electrical_stric = {new Mechanical(), new Electrical()};
		Major[] geology_geophysics_stric = {new Geology(), new Geophysics()};
		
		//pure science
		Coursee appp031 = new Science("APPP031", 1,4, null, null, true);
		Coursee appp032 = new Science("APPP032", 1, 4, null, appp031, true);
		Coursee appc033 = new Science("APPC033", 1, 4, null, appp032, true);
		Coursee phys045 = new Science("PHYS045", 1, 4, null, appc033,false, true, mechanical_electrical_stric);
		Coursee geo020 = new Science("GEO020", 1, 4, null, null, false, true, geology_geophysics_stric);
		
		
		Coursee[] c = {appc033};
		return c;
	}
}
