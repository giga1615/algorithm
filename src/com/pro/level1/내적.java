package com.pro.level1;

public class 내적 {

	public static void main(String[] args) {
		int[] a = { -1, 0, 1 };
		int[] b = { 1, 0, -1 };
		System.out.println(solution(a, b));
	}

	public static int solution(int[] a, int[] b) {
		int answer = 0;

		for (int i = 0; i < b.length; i++)
			answer += a[i] * b[i];

		return answer;
	}
}
