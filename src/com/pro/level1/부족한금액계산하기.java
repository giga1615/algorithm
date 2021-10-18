package com.pro.level1;

public class 부족한금액계산하기 {

	public static void main(String[] args) {
		System.out.println(solution(3, 20, 4));
	}

	public static long solution(int price, int money, int count) {
		long answer = (long) count * (count + 1) / 2 * price - money;
		return answer < 0 ? 0 : answer;
	}
}
