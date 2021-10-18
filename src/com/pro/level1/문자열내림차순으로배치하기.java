package com.pro.level1;

import java.util.Arrays;

public class 문자열내림차순으로배치하기 {

	public static void main(String[] args) {
		System.out.println(solution("Zbcdefg"));
	}

	public static String solution(String s) {
		char c[] = s.toCharArray();
		Arrays.sort(c);
		StringBuilder sb =  new StringBuilder(String.copyValueOf(c));
		return sb.reverse().toString();
	}

}
