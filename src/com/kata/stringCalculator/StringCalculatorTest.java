package com.kata.stringCalculator;

import static org.hamcrest.CoreMatchers.is;

import static org.junit.Assert.assertThat;

import org.junit.Test;

public class StringCalculatorTest {
	
	@Test
	public void sumEmptyStringToZero() {
		assertThat(StringCalculator.Add(""),is(0));
	}
	
	@Test
	public void sumSingleDigitToItself() {
		assertThat(StringCalculator.Add("1"),is(1));
	}
	
	@Test
	public void sumTwoNumbersCommaSeperated() {
		assertThat(StringCalculator.Add("1,2"),is(3));
		assertThat(StringCalculator.Add("1,3"),is(4));
	}
	
	@Test
	public void sumAnyNumbersCommaSerperated() {
		assertThat(StringCalculator.Add("1,2,3"),is(6));
		assertThat(StringCalculator.Add("1,2,3,4"),is(10));
	}
	
	@Test
	public void sumNumberDelimitedbyNewLine() {
		assertThat(StringCalculator.Add("1\n2"),is(3));
	}
	
	@Test
	public void sumNumberDelimitedbyNewLineOrComma() {
		assertThat(StringCalculator.Add("1\n2,3"),is(6));
		assertThat(StringCalculator.Add("1,2\n3"),is(6));
	}

}
