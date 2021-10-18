package com.pro.level2;

import java.util.Arrays;
import java.util.stream.Collectors;

public class 가장큰수 {

	public static void main(String[] args) {
		int[] numbers = { 3, 30, 34, 5, 9 };
		System.out.println(solution(numbers));
	}

	public static String solution(int[] numbers) {
		String[] nums = new String[numbers.length];
		for (int i = 0; i < numbers.length; i++)
			nums[i] = numbers[i] + "";

		Arrays.sort(nums, (n1, n2) -> (n2 + n1).compareTo(n1 + n2));

		return nums[0].equals("0") ? "0" : Arrays.stream(nums).collect(Collectors.joining());
	}
}
