package com.kata.stringCalculator;

import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StringCalculator {
	
	private String delimeter;
	private String numbers;
	static int count = 0;
	
	private StringCalculator(String delimeter,String numbers) {
		this.delimeter = delimeter;
		this.numbers = numbers;
	}
	
	private int sum() {
		checkIfNegativeNumbers();
		return getnumbers().sum();
	}
	
	private void checkIfNegativeNumbers() {
		String negativeNumberSequence = getnumbers().filter(i -> i<0)
				.mapToObj(Integer::toString)
				.collect(Collectors.joining(","));
		if(!negativeNumberSequence.isEmpty()) {
			throw new IllegalArgumentException("negative not allowed : "+negativeNumberSequence);
		}
	}
	
	private IntStream getnumbers() {
		if(numbers.isEmpty()) {
			return IntStream.empty();
		}
		else {
			return Arrays.stream(numbers.split(delimeter))
					.mapToInt(Integer::parseInt).filter(i -> i<=1000);
		}
	}

	public static int Add(String numbers) {
		count++;
		return parseInt(numbers).sum();
	}
	
	public static int getCalledCount() {
		return count-1;
	}
	
	private static StringCalculator parseInt(String input) {
		if(input.startsWith("//")) {
			String [] parts = input.split("\n",2);
			return new StringCalculator(parseDelimeter(parts[0]),parts[1]);
		}
		else {
			return new StringCalculator(",|\n",input);
		}
	}
	
	private static String parseDelimeter(String header) {
		String delimeter = header.substring(2);
		if(delimeter.startsWith("[")) {
			delimeter = delimeter.substring(1, delimeter.length()-1);
		}
		return Stream.of(delimeter.split("]\\["))
				.map(Pattern::quote)
				.collect(Collectors.joining("|"));
	}
}
