package majors;

public class Business extends Major{

	public Business() {
		
	}

	@Override
	public boolean instanceOf(Object son) {
		return super.isInstanceOf(new Business(), son);
	}
}
