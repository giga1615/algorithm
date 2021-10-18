package com.pro.level1;

import java.util.Arrays;

public class 로또의최고순위와최저순위 {

	public static void main(String[] args) {
		int[] lottos = { 44, 1, 0, 0, 31, 25 };
		int[] win_nums = { 31, 10, 45, 1, 6, 19 };

		int answer[] = solution(lottos, win_nums);
		System.out.println(Arrays.toString(answer));
	}

	public static int[] solution(int[] lottos, int[] win_nums) {

		boolean num[] = new boolean[46];
		for (int i = 0; i < 6; i++)
			num[win_nums[i]] = true; // 로또 정답인 숫자 true

		int zero = 0; // 0개수
		int correct = 0; // 맞은 숫자개수
		for (int i = 0; i < 6; i++) {
			if (lottos[i] == 0)
				zero++;
			else if (num[lottos[i]])
				correct++;
		}

		int min = correct <= 1 ? 6 : 7 - correct;
		int max = (correct + zero) <= 1 ? 6 : 7 - (zero + correct);

		int[] answer = { max, min };
		return answer;
	}
}
