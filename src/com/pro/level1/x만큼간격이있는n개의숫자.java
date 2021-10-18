package com.pro.level1;

import java.util.Arrays;

public class x만큼간격이있는n개의숫자 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(2, 5)));
	}

	public static long[] solution(int x, int n) {
		long[] answer = new long[n];
		for (int i = 0; i < n; i++)
			answer[i] = (long) x * (i + 1);

		return answer;
	}
}
