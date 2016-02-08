package majors;

public class Electrical extends Physics{

	public Electrical() {
	
	}

	@Override
	public boolean instanceOf(Object son) {
		return super.isInstanceOf(new Electrical(), son);
	}
}
