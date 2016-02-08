package majors;

public class Geophysics extends Physics{

	public Geophysics() {
		
	}

	@Override
	public boolean instanceOf(Object son) {
		return super.isInstanceOf(new Geophysics(), son);
	}
}
