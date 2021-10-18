package com.pro.level1;

public class 이상한문자만들기 {

	public static void main(String[] args) {
		System.out.println(solution("try hello world"));
	}

	public static String solution(String s) {
		char[] c = s.toCharArray();
		for (int i = 0, index = 0; i < c.length; i++, index++) {
			if (c[i] != ' ')
				c[i] = index % 2 == 0 ? Character.toUpperCase(c[i]) : Character.toLowerCase(c[i]);
			else
				index = -1;
		}

		return String.copyValueOf(c);
	}
}
