package majors;

import course.Coursee;

/*
*Ali alAali
*781735
*/

public class Major {
	
	public static final int MAX_RELATION_SCORE = 10;
	
	protected Coursee[] courses;
	protected String title;

	public Coursee[] prepareCourses(){
		return courses;
		}
	
	public static boolean isInstanceOf(Object father, Object son) {
		Object c = son;
		if(son.getClass().getSimpleName().equals(father.getClass().getSimpleName())){
			return true;
		}
		while (!c.getClass().getSuperclass().getSimpleName().equals("Object")) {
			if (son.getClass().getSuperclass().getSimpleName().equals(father.getClass().getSimpleName())) {
				return true;
			}
			c = c.getClass().getSuperclass();
		}
		return false;
	}

	
	public boolean instanceOf(Object son){
		return isInstanceOf(new Major(), son);
	}
	
	public int relation(Coursee course){
		return 10;
	}
	
	
}
