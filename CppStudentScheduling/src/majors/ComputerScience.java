package majors;
/*
*Ali alAali
*781735
*/

public class ComputerScience extends Major{

	public ComputerScience() {
		
	}

	@Override
	public boolean instanceOf(Object son) {
		return super.isInstanceOf(new ComputerScience(), son);
	}
}
