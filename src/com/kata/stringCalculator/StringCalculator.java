package com.kata.stringCalculator;

public class StringCalculator {

	public static int Add(String numbers) {
		if(numbers.isEmpty())
			return 0;
		else if (numbers.contains(",")) {
			String input[] = numbers.split(",");
			return Integer.parseInt(input[0])+Integer.parseInt(input[1]);
		}
		else
			return Integer.parseInt(numbers);
	}
}
