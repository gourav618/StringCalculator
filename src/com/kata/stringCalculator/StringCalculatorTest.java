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

}
