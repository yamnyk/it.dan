package it.dan.homeWork;

import java.util.Scanner;

public class SumOfFiveDigitsNumber {
	public static void main(String[] args) {
		Scanner in = new Scanner(inputData());
		
		linearTimeSum(in);
		
		System.out.println("____________________");
		Scanner in1 = new Scanner(inputData());
		
		usingSplit(in1);
		
				
	}

	private static void usingSplit(Scanner in) {
		String[] digits = in.nextLine().split("");
		System.out.print("Random 5-digits number is ");
		int sum = 0;
		
		for (int forward = 0; forward < digits.length; forward++) {
			int digitValue = Integer.parseInt(digits[forward]);
			sum += digitValue;
			System.out.print(digitValue);
		}
		
		System.out.printf("\nSum of digits is %d", sum);
	}

	private static void linearTimeSum(Scanner in) {
		String number = in.nextLine();
		System.out.printf("Random 5-digits number is %s \n", number);
		int sum = 0;
		
		for (int indexOfString = 0; indexOfString < number.length(); indexOfString++) {
			int digit = number.charAt(indexOfString) - '0';
			sum += digit;
		}
		System.out.printf("Sum of digits is %d\n", sum);
		
	}

	private static String inputData() {
		StringBuilder fiveDigits = new StringBuilder(5);
		for (int i = 0; i < 5; i++) {
			double digit = Math.random()*10;
			fiveDigits.append((int)digit);
		}
		String result = fiveDigits.toString();
		return result;
	}

}
