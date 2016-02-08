package majors;

import course.Coursee;
import course.Science;

public class Physics extends Engineering{

	@Override
	public boolean instanceOf(Object son) {
		return super.isInstanceOf(new Physics(), son);
	}

	
}
