package majors;

import course.Coursee;
import course.Mathematics;

public class Engineering extends Major{

	public Engineering() {

	}
	
	@Override
	public boolean instanceOf(Object son) {
		return super.isInstanceOf(new Engineering(), son);
	}
	
}
