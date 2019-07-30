package calculator;

public class Calculator implements CalculatorInterface {

	private double angle;

	@Override
	public LastTangent backupCalculation() {
		return new LastTangent(angle);
	}

	@Override
	public void restoreLastTangent(LastTangentToCareTaker previousTangent) {
		Double previousAngle = (Double) ((LastTangentToOriginator) previousTangent).getAngle();
		if (!previousAngle.isNaN()) {
			this.angle = ((LastTangentToOriginator) previousTangent).getAngle();
		}
	}

	@Override
	public void setAngle(double angle) {
		this.angle = angle;
	}

	public void setAngle(String userInput) {
		try {
			this.angle = Double.parseDouble(userInput);
		} catch (NumberFormatException ex) {
			throw new NumberFormatException("User input is incorrect. Please enter a valid number");
		}
	}

	@Override
	public double calculateTangent() throws Exception {
		// TODO Auto-generated method stub
		return tan(this.angle);
	}

	/*
	 * function to calculate tangent of the given angle
	 */
	public double tan(double x) throws Exception {

		try {
			// Check periodicity i.e. reduce x to the range 0<= x <= 180
			if (!(x >= 0.0 && x <= 180.0)) {
				int multiplier = (int) x / 180;
				x = x - (180.0 * multiplier);
			}
			// check 90 and corresponding angles
			if (x == 90.0) {
				return Double.NaN;
			}

			// Check symmetry i.e. if x is in 1st quadrant or not
			// Reduce x to first quadrant
			if (x > 90.0 && x <= 180.0) {
				x = x - 180.0;
			}

			// if x is negative at this point
			int y = 1;
			if (x < 0) {
				y = -1;
			}

			// Use co-function
			if (Math.abs(x) > 45.0 && Math.abs(x) < 90.0) {
				return (y) * (1 / tan(90.0 - Math.abs(x)));
			}

			if (Math.abs(x) >= 22.5 && Math.abs(x) <= 45.0) {
				double result = tan(Math.abs(x) / 2);
				return (double) y * ((2 * result) / (1 - Math.pow(result, 2)));
			}
			if (Math.abs(x) >= 0 && Math.abs(x) <= 22.5) {
				double radians = Math.abs(x) * (Math.PI / 180);
				double result = radians + (Math.pow(radians, 3) / 3) + (2 * Math.pow(radians, 5) / 15)
						+ (17 * Math.pow(radians, 7) / 315);
				return (y) * result;
			}
		} catch (Exception ex) {
			throw new Exception("Problem occured while calculating tan(x). Please try again. ");
		}
		return Double.NaN;
	}
}
