package com.pro.level1;

public class 하샤드수 {

	public static void main(String[] args) {
		System.out.println(solution(10));
	}

	static int sum = 0;
	public static boolean solution(int x) {
		Integer.toString(x).chars().forEach(c -> sum += c - '0');
		return x % sum == 0 ? true : false;
	}
}
