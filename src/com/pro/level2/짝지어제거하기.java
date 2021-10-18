package com.pro.level2;

import java.util.Stack;

public class 짝지어제거하기 {

	public static void main(String[] args) {
		System.out.println(solution("baabaa"));
	}

	public static int solution(String s) {
		Stack<Character> stack = new Stack<Character>();

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);

			if (!stack.isEmpty() && ch == stack.peek())
				stack.pop();
			else
				stack.add(ch);
		}

		return stack.isEmpty() ? 1 : 0;
	}
}
