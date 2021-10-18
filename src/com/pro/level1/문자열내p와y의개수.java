package com.pro.level1;

public class 문자열내p와y의개수 {

	public static void main(String[] args) {
		System.out.println(solution("ccY"));
	}

	public static boolean solution(String s) {

		s = s.toLowerCase();
		return s.chars().filter(c -> c == 'p').count() == s.chars().filter(c -> c == 'y').count();
	}
}
