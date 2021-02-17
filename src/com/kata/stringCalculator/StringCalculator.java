package com.kata.stringCalculator;

import java.util.Arrays;
import java.util.stream.Stream;

public class StringCalculator {
	
	private String delimeter;
	private String numbers;
	
	private StringCalculator(String delimeter,String numbers) {
		this.delimeter = delimeter;
		this.numbers = numbers;
	}
	
	private int sum() {
		return Arrays.stream(numbers.split(delimeter))
				.mapToInt(Integer::parseInt)
				.sum();
	}

	public static int Add(String numbers) {
		if(numbers.isEmpty())
			return 0;
		
		return parseInt(numbers).sum();
	}
	
	private static StringCalculator parseInt(String input) {
		if(input.startsWith("//")) {
			String [] parts = input.split("\n",2);
			return new StringCalculator(parts[0].substring(2),parts[1]);
		}
		else {
			return new StringCalculator(",|\n",input);
		}
	}
}
