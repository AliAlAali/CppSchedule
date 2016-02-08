package majors;

public class Petroleum extends Chemistry{

	public Petroleum() {
		
	}

	@Override
	public boolean instanceOf(Object son) {
		return super.isInstanceOf(new Petroleum(), son);
	}
}
