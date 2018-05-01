package it.dan.SecondContest;

import java.util.Arrays;
import java.util.Scanner;

public class Pairs {
	public static void main(String[] args) {
		Scanner in = new Scanner(inputData());
		int quantityOfNumbers = in.nextInt();
		int givenSum = in.nextInt();
		int[] numbers = new int[quantityOfNumbers];
		
		for (int i = 0; i < quantityOfNumbers; i++) {
			numbers[i] = in.nextInt();
		}
		Arrays.sort(numbers);
		int count = 0;
		for (int i = 0; i < numbers.length; i++) {
			count += binarySearch(numbers, givenSum, numbers[i]);
		}
		System.out.println(count);
	}
	public static int binarySearch(int[] numbers, int givenSum, int number) {
		int pairs = 0;
		int start = 0;
		int end = numbers.length - 1;
		int middle = (start + end) / 2;
		
		for (int i = 0; i < numbers.length; i++) {
			if((number + numbers[middle]) > givenSum) {
				start = middle;
			} else if((number + numbers[middle]) < givenSum) {
				end = middle;
			} else if((number + numbers[middle]) < givenSum) {
				pairs++;
			}
		}
		
		return pairs;
	}
	
	public static String inputData() {
		String s = "5 6\n" + 
				"2 5 1 3 4";
		return s;
	}
}
