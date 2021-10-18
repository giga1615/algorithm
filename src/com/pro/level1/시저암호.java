package com.pro.level1;

public class 시저암호 {

	public static void main(String[] args) {
		System.out.println(solution("a B z", 4));
	}

	public static String solution(String s, int n) {
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ' ') {
				sb.append(" ");
				continue;
			}

			char c = (char) (s.charAt(i) + n);

			if (c > 'z' && s.charAt(i) <= 'z')
				c = (char) (c - 'z' + 'a' - 1);
			else if (c > 'Z' && s.charAt(i) <= 'Z')
				c = (char) (c - 'Z' + 'A' - 1);

			sb.append(c);
		}

		return sb.toString();
	}
}
