package majors;

public class ComputerEngineer extends Physics{

	public ComputerEngineer() {
		
	}

	@Override
	public boolean instanceOf(Object son) {
		return super.isInstanceOf(new ComputerEngineer(), son);
	}
}
