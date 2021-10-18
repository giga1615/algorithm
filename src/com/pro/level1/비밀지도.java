package com.pro.level1;

import java.util.Arrays;

public class 비밀지도 {

	public static void main(String[] args) {
		int n = 6;
		int[] arr1 = { 46, 33, 33, 22, 31, 50 };
		int[] arr2 = { 27, 56, 19, 14, 14, 10 };
		System.out.println(Arrays.deepToString(solution(n, arr1, arr2)));
	}

	public static String[] solution(int n, int[] arr1, int[] arr2) {

		String[] answer = new String[n];

		for (int i = 0; i < n; i++) {
//			answer[i] = String.format("%" + n + "s", Integer.toBinaryString(arr1[i] | arr2[i]));
			answer[i] = Integer.toBinaryString(arr1[i] | arr2[i]);
			answer[i] = answer[i].replace('1', '#');
			answer[i] = answer[i].replace('0', ' ');

			// 자릿수 맞추기
			while (answer[i].length() != n)
				answer[i] = " " + answer[i];
		}

		return answer;
	}
}
