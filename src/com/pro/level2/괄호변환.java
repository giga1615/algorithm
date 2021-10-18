package com.pro.level2;

import java.util.Stack;

public class 괄호변환 {

	public static void main(String[] args) {
		System.out.println(solution("()))((()"));
	}

	static int index = 0;

	public static String solution(String p) {
		// 1 - 빈 문자열 반환
		if (p.equals(""))
			return p;

		// 2 - 균형잡힌 괄호 문자열 u, v로 분리
		boolean isCorrect = divide(p);
		String u = p.substring(0, index);
		String v = p.substring(index);

		// 3 - u가 올바른 문자열이면, v에 대해 처리
		if (isCorrect)
			return u + solution(v);

		// 4
		StringBuilder sb = new StringBuilder();
		sb.append("("); // 4-1
		sb.append(solution(v)); // 4-2
		sb.append(")"); // 4-3

		// 4-4
		for (int i = 1; i < u.length() - 1; i++) {
			if (u.charAt(i) == '(')
				sb.append(')');
			else
				sb.append('(');
		}

		// 4-5
		return sb.toString();
	}

	private static boolean divide(String p) {
		boolean isCorrect = true; // 올바른 괄호 문자열인가
		int left = 0, right = 0;
		Stack<Character> stack = new Stack<Character>();

		for (int i = 0; i < p.length(); i++) {
			char ch = p.charAt(i);

			if (ch == '(') {
				stack.add('(');
				left++;
			} else {
				right++;
				if (!stack.isEmpty() && stack.peek() == '(')
					stack.pop();
				else {
					stack.add(')');
					isCorrect = false;
				}
			}

			if (left == right) {
				index = i + 1;
				break;
			}
		}

		return isCorrect;
	}
}
