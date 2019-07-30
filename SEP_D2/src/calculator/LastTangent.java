package calculator;

public class LastTangent implements LastTangentToCareTaker, LastTangentToOriginator {

	private double angle;

	public LastTangent(double angle) {
		this.angle = angle;
	}

	@Override
	public double getAngle() {
		return angle;
	}

}
