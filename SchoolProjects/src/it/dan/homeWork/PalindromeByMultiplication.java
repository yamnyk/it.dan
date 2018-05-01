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
		String multiplString = multiplication.toString();
		boolean answer = true;
		
		for (int indexOfSymbol = 0; indexOfSymbol < multiplString.length(); indexOfSymbol++) {
			int firstSymbol = multiplString.charAt(indexOfSymbol);
			int lastSymbol = multiplString.charAt(multiplString.length() - 1 - indexOfSymbol);
			
			if (firstSymbol != lastSymbol) {
				answer =  false;
			}	

		}
		return answer;
	}

}
