package com.kata.stringCalculator;

import java.util.Arrays;
import java.util.stream.Stream;

public class StringCalculator {

	public static int Add(String numbers) {
		if(numbers.isEmpty())
			return 0;
		else {
			Stream<String> input  = Arrays.stream(numbers.split(",|\n"));
			return input.mapToInt(Integer::parseInt).sum();
		}
		
	}
}
