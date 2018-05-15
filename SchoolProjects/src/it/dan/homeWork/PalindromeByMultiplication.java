package it.dan.homeWork;

import java.util.PriorityQueue;

public class PalindromeByMultiplication {
	public static void main(String[] args) {
		PriorityQueue<Integer> maximums = new PriorityQueue<>((o1, o2) -> o2-o1);
		
		for (int factor1 = 999; factor1 > 99; factor1--) {
			for (int factor2 = 999; factor2 > 99; factor2--) {
				Integer multiplication = factor1 * factor2;
				if (isPalindrome(multiplication)) {
					maximums.add(multiplication);
				}
			}			
		}
		System.out.printf("The maximum value of multiplication of "
				+ "two numbers from 100 to 999 is %d", maximums.poll());
	}

	private static boolean isPalindrome(Integer multiplication) {
		Integer number = multiplication;
		Integer reverse = 0;
		while(number != 0){
			int temp = number % 10;
			reverse = reverse * 10 + temp;
			number = number / 10;
		}
		return multiplication.equals(reverse);
	}

}
