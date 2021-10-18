package com.pro.level2;

public class pro_124나라의숫자 {

	public static void main(String[] args) {
		System.out.println(solution(3));
	}

	public static String solution(int n) {
		String answer = "";
		String num[] = new String[] { "4", "1", "2" };

		while (n != 0) {
			answer = num[n % 3] + answer;
			if (n % 3 == 0)
				n -= 1;
			n /= 3;
		}

		return answer;
	}
}
