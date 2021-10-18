package com.pro.level1;

public class 콜라츠추측 {

	public static void main(String[] args) {
		System.out.println(solution(626331));
	}

	public static int solution(int num) {
		int answer = 0;
		long n = num;
		while (n != 1) {
			if (answer++ >= 500)
				return -1;
			n = n % 2 == 0 ? n / 2 : n * 3 + 1;
		}
		return answer;
	}
}
