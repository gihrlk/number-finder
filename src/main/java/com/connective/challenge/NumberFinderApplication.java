package com.connective.challenge;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class NumberFinderApplication {

	public static void main(String[] args) {
		System.out.println("Input: nums = " + args[0] + ", target " + args[1]);
		List<Integer> inputNumbers = getInputNumbers(args[0]);
		int target = Integer.parseInt(args[1]);
		int[] results = findNumbers(inputNumbers, target);
		System.out.println("Output: " + Arrays.toString(results));
	}

	/**
	 * Traverse though a list and find indices of two numbers that match the target
	 * 
	 * @param inputNumbers
	 * @param target
	 * @return
	 */
	static int[] findNumbers(List<Integer> inputNumbers, int target) {
		int index = 0, firstIndiceIndex = 0, secondIndiceIndex = 0;

		while (index < inputNumbers.size() && secondIndiceIndex == 0) {
			firstIndiceIndex = index;
			int currentValue = inputNumbers.get(firstIndiceIndex);
			int requiredValue = target - currentValue;
			// Input has exactly one answer
			if (inputNumbers.contains(requiredValue)) {
				OptionalInt indices = IntStream.range(1, inputNumbers.size())
						.filter(i -> inputNumbers.get(i) == requiredValue).findFirst();
				if (indices.isPresent()) {
					secondIndiceIndex = indices.getAsInt();
				}
			}
			index++;
		}

		return new int[] { firstIndiceIndex, secondIndiceIndex };
	}

	/**
	 * Converts input string to Integer List
	 * 
	 * @param inputString
	 * @return
	 */
	static List<Integer> getInputNumbers(String inputString) {
		// Remove open/close brackets and split the input string
		String[] splits = inputString.replace("[", "").replace("]", "").split(",");
		List<Integer> inputNumbers = Stream.of(splits).map(String::trim).mapToInt(Integer::parseInt).boxed()
				.collect(Collectors.toList());
		return inputNumbers;
	}
}
