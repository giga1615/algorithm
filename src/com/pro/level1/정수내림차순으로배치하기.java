package com.pro.level1;

import java.util.Arrays;
import java.util.Comparator;

public class 정수내림차순으로배치하기 {

	public static void main(String[] args) {
		System.out.println(solution(118372));
	}

	public static long solution(long n) {
		String s = n + "";
		int[] num = s.chars().boxed()
				.sorted(Comparator.reverseOrder())
				.mapToInt(i -> i -= '0')
				.toArray();
		return Long.parseLong(Arrays.toString(num).replaceAll("[^0-9]", ""));
	}
}
