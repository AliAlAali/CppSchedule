/*
*Ali alAali
*781735
*/
package core;

import course.Coursee;
import course.English;

public class Test {

	public static void main(String[] args) {
		Coursee eng = new English("sub", null, null, true);
		eng.setPeriodsADay(2);
		ClassRoom room = new ClassRoom("daf");
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 7; j++) {
				if( (j == 4 || j == 5 )&& i == 2){
					
				}else if( (j == 2 || j == 3 || j == 4 )&& i == 4){
					
				}else{
					room.getSchedule().setPeriod(i, j, eng);
				}
			}
		}
		
		room.getSchedule().printFormat();
		System.out.println(findEmptyNormalRoom(2, 4, eng.getPeriodsADay(), room));
	}

	public static ClassRoom findEmptyNormalRoom(int d, int p, int num, ClassRoom rooms){
		mainloop:for (int i = 0; i < 1; i++) {
			if(rooms.getTools() == null && rooms.isFree(d, p)){
				for (int j = p; j < p + num; j++) {
					if(!rooms.isFree(d, j)){
						 continue mainloop;
					}
				}
				return rooms;
			}
		}
		return null;
	}
}
