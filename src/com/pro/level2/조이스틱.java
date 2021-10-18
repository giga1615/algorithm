package com.pro.level2;

public class 조이스틱 {

	public static void main(String[] args) {
		System.out.println(solution("JAN"));
	}

	public static int solution(String name) {
		int answer = 0;
		int min = name.length() - 1; // 한 방향 이동

		for (int i = 0; i < name.length(); i++) {
			// 상, 하
			answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);

			// 좌, 우
			int next = i + 1;
			while (next < name.length() && name.charAt(next) == 'A')
				next++;

			min = Math.min(min, 2 * i + name.length() - next);
		}

		return answer + min;
	}
}
