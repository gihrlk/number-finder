package com.connective.challenge;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class NumberFinderApplicationTest {

	@Test
	void test_findIndices() {
		List<Integer> nums = Arrays.asList(2, 7, 11, 15);
		int target = 9;
		int[] expected = new int[] { 0, 1 };
		int[] actual = NumberFinderApplication.findNumbers(nums, target);
		assertTrue(Arrays.equals(expected, actual));
	}

	@Test
	void test_inputNumbers() {
		String inputString = "[2,7,11,15]";
		List<Integer> expected = Arrays.asList(2, 7, 11, 15);
		List<Integer> actual = NumberFinderApplication.getInputNumbers(inputString);
		assertTrue(expected.equals(actual));
	}
}
