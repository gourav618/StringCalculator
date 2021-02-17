package com.kata.stringCalculator;

import static org.hamcrest.CoreMatchers.is;

import static org.junit.Assert.assertThat;

import org.junit.Rule;
import org.junit.Test;
import org.junit.internal.runners.statements.ExpectException;
import org.junit.rules.ExpectedException;

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
	
	@Test
	public void sumNumberbyDelimiterSpecified() {
		assertThat(StringCalculator.Add("//;\n1;2"),is(3));
		assertThat(StringCalculator.Add("//;\n1;2;3"),is(6));
	}
	
	@Rule
	public ExpectedException e = ExpectedException.none();
	
	@Test
	public void throwOnInputOfNegativeNumber() {
		e.expect(IllegalArgumentException.class);
		e.expectMessage("negative not allowed : -3");
		StringCalculator.Add("-3");
	}
	
	@Test
	public void throwOnInputOfNegativeNumbersWithAllNumber() {
		e.expect(IllegalArgumentException.class);
		e.expectMessage("negative not allowed : -3,-5,-7");
		StringCalculator.Add("1,-3,-5,13,-7");
		StringCalculator.Add("//,\n1,-3,-5,13,-7");
	}
	
	@Test
	public void getHowManytimeAddCalled() {
		assertThat(StringCalculator.Add("//;\n1;2"),is(3));
		assertThat(StringCalculator.Add("//;\n1;2;3"),is(6));
		assertThat(StringCalculator.Add("//;\n1;2;3"),is(6));
		
		assertThat(StringCalculator.getCalledCount(),is(3));
	}
	
	@Test
	public void sumNumbersIgnoringValueGreaterThan1000() {
		assertThat(StringCalculator.Add("1,1000"),is(1001));
		assertThat(StringCalculator.Add("2,1003"),is(2));
	}
	
	@Test
	public void acceptDelimeterOfAnyLength() {
		assertThat(StringCalculator.Add("//[***]\n1***2***3"),is(6));
	}
	
	@Test
	public void acceptSpecialCharacterAsDelimeter() {
		assertThat(StringCalculator.Add("//.\n1.2.3"),is(6));
	}
	
	@Test
	public void acceptMultipleDelimeter() {
		assertThat(StringCalculator.Add("//[*][%]\n1*2%3"),is(6));
	}
	
	@Test
	public void acceptMultipleDelimeterAndLength() {
		assertThat(StringCalculator.Add("//[***][%%%]\n1***2%%%3"),is(6));
	}

}
