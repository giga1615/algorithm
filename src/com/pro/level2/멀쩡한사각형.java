package com.pro.level2;

public class 멀쩡한사각형 {

	public static void main(String[] args) {
		System.out.println(solution(8, 12));
	}

	public static long solution(int w, int h) {
		long answer = 0;

		// 일차방정식 y = ax 이용
		for (long i = 1; i < w; i++) {
			System.out.println(Math.floor(h * i / (double) w));
			answer += Math.floor(h * i / (double) w);
		}

		return answer * 2;
	}
}
