package exam1;

import java.util.Scanner;

public class TimeConverter {
	public static void main(String args[]) {
		Scanner scnr = new Scanner(System.in);
		double metersIn = 0;
		double result = 0;
		String conversion;

		System.out.print("How many meters? ");
		metersIn = scnr.nextDouble();

		System.out.print("Convert to cm or km? ");
		conversion = scnr.next();

		if (conversion.equals("cm")) {
			result = metersIn * 100;
		} else if (conversion.equals("km")) {
			result = metersIn / 1000;
		}

		if (result != 0) {
			System.out.print("The measurment is: " + result + " " + conversion);
		} else {
			System.out.print("The requested conversion is not possible.");
		}
	}
}
