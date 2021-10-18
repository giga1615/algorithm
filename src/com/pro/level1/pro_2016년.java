package com.pro.level1;

public class pro_2016년 {

	public static void main(String[] args) {
		System.out.println(solution(5, 24));
	}

	public static String solution(int a, int b) {
		String[] days = { "THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED" }; // 1일 = days[1] = FRI
		int[] months = { 0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

		int n = b;
		for (int i = 1; i < a; i++)
			n += months[i];

		return days[n % 7];
	}
}
