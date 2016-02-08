package majors;

public class Mechanical extends Physics{

	public Mechanical() {
		
	}

	@Override
	public boolean instanceOf(Object son) {
		return super.isInstanceOf(new Mechanical(), son);
	}
}
