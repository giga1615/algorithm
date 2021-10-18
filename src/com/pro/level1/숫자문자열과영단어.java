package com.pro.level1;

public class 숫자문자열과영단어 {

	public static void main(String[] args) {
		System.out.println(solution("123"));
	}

	public static int solution(String s) {
		String num[] = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
		String answer = s;
		
		for (int i = 0; i < num.length; i++) {
			answer = answer.replace(num[i], i + "");
		}

		return Integer.parseInt(answer);
	}
}
