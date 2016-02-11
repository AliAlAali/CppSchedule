/*
*Ali alAali
*781735
*/
package core;


public class Test {

	public static void main(String[] args) {
		
		Reader r = new Reader();
		for (int i = 0; i < r.getTeachers().size(); i++) {
			System.out.println(r.getTeachers().get(i) + "\n");
		}
	}
}
