package majors;

public class Geology extends Physics{

	public Geology() {
		
	}

	@Override
	public boolean instanceOf(Object son) {
		return super.isInstanceOf(new Geology(), son);
	}
}
