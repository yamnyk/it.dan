package it.dan.SecondContest;

import java.util.Scanner;

public class Race {
	public static void main(String[] args) {
		Scanner in = new Scanner(inputData());
		String input = in.next();
		System.out.print(find(input));
	}
	
	public static String find(String input) {
		char[] directions = {'a', 'd', 's', 'w'};
		int[] inertion = {0, 0, 0, 0};
		int x = 0;
		int y = 0;
		
		for (int i = 0; i < input.length(); i++) {
			char symbol = input.charAt(i);
			for (int j = 0; j < 4; j++) {
				if(symbol == directions[j]) {
					inertion[j] = Math.min(Math.max(inertion[j]*2, 1), 64);
				} else {
					inertion[j] = inertion[j] / 4;
				}
			}
			x -= inertion[0];
			x += inertion[1];
			y -= inertion[2];
			y += inertion[3];
		}
		for (int i = 0; i < input.length(); i++) {
			for (int j = 0; j < 4; j++) {
				inertion[j] = inertion[j] / 4;
			}
			x -= inertion[0];
			x += inertion[1];
			y -= inertion[2];
			y += inertion[3];
		}
		return String.format("%d %d", x, y);
	}
	
	
	public static String inputData() {
		String s = "ddddddddd"; //answer 276 0
		String s1 = "ddda"; //answer 7 0
		String s2 = "wwsswwwwaaddaawwssddddssddssssssddddwwdd";//answer 37 -56
		return s;
	}

}
