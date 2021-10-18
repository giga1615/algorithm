package com.pro.level1;

public class 문자열다루기기본 {

	public static void main(String[] args) {
		System.out.println(solution("1234"));
	}

	public static boolean solution(String s) {
		return (s.length() == 4 || s.length() == 6) && s.chars().allMatch(c -> Character.isDigit(c));
	}
}
