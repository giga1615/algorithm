package com.pro.level1;

public class 약수의개수와덧셈 {

	public static void main(String[] args) {
		System.out.println(solution(13, 17));
	}

	public static int solution(int left, int right) {
		int answer = 0;

		for (int i = left; i <= right; i++) {
			int n = 0;
			for (int j = 1; j <= i; j++)
				if (i % j == 0)
					n++;
			answer += n % 2 == 0 ? i : -i;
		}

		return answer;
	}
}
