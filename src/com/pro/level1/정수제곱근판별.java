package com.pro.level1;

public class 정수제곱근판별 {

	public static void main(String[] args) {
		System.out.println(solution(121));
	}

	public static long solution(long n) {
		long num = (long) Math.sqrt(n);
		return Math.pow(num++, 2) == n ? num * num : -1;
	}
}
