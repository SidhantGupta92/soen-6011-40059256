package calculator;

public interface CalculatorInterface {

	public LastTangent backupCalculation();

	public void restoreLastTangent(LastTangentToCareTaker previousTangent);

	public void setAngle(double angle);

	public double calculateTangent() throws Exception;
}
