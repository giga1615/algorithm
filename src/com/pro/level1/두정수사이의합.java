package com.pro.level1;

public class 두정수사이의합 {

	public static void main(String[] args) {
		System.out.println(solution(3, 5));
	}

	public static long solution(int a, int b) {
		long answer = 0;
		int start = Math.min(a, b);
		int end = Math.max(a, b);
		
		for (int i = start; i <= end; i++)
			answer += i;

		return answer;
	}

}
