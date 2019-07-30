package calculator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CalculatorDriver {

	public static void main(String[] args) {
		Calculator objCalculator = new Calculator();
		LastTangentToCareTaker lastTangent = null;
		boolean keepCalculating = true;
		Scanner objScanner;
		do {
			try {
				printMenu();
				objScanner = new Scanner(System.in);
				int userInput = Integer.parseInt(objScanner.nextLine());

				switch (userInput) {
				case 1:
					if (lastTangent == null) {
						objCalculator.setAngle(Double.NaN);
						lastTangent = objCalculator.backupCalculation();
					} else {
						lastTangent = objCalculator.backupCalculation();
					}

					System.out.println("Enter angle(degrees) : ");
					String inputAngle = objScanner.nextLine();
					objCalculator.setAngle(inputAngle);
					System.out.println("Result : " + objCalculator.calculateTangent());
					break;
				case 2:
					if (lastTangent != null) {
						objCalculator.restoreLastTangent(lastTangent);
						System.out.println("Result : " + objCalculator.calculateTangent());
					} else {
						System.out.println("No previous calculation avalaible.");
					}
					break;
				case 3:
					keepCalculating = false;
					break;
				default:
					System.out.println("No such option available. ");
				}
			} catch (ArithmeticException ex) {
				ex.getMessage();
			} catch (InputMismatchException ex) {
				System.out.println("Wrong Input. Please try again.");
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
			}
		} while (keepCalculating);
	}

	public static void printMenu() {
		System.out.println("\n");
		System.out.println("Scientific Calculator");
		System.out.println("Operation : tan(x)");
		System.out.println("1. Enter value for x : angle(degrees)");
		System.out.println("2. Restore previous calculation");
		System.out.println("3. Exit Calculator");
		System.out.println("Enter Choice : ");
	}
}
