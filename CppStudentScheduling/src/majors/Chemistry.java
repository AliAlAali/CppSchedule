package majors;

public class Chemistry extends Engineering{

	public Chemistry() {
		
	}

	@Override
	public boolean instanceOf(Object son) {
		return super.isInstanceOf(new Chemistry(), son);
	}
}
