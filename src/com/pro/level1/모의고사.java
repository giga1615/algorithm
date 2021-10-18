package com.pro.level1;

import java.util.ArrayList;
import java.util.Arrays;

public class 모의고사 {

	public static void main(String[] args) {
		int[] answers = { 1, 2, 3, 4, 5 };
		System.out.println(Arrays.toString(solution(answers)));
	}

	public static int[] solution(int[] answers) {

		int[] one = { 1, 2, 3, 4, 5 };
		int[] two = { 2, 1, 2, 3, 2, 4, 2, 5 };
		int[] three = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };

		int count[] = new int[4];
		for (int i = 0; i < answers.length; i++) {
			count[1] += answers[i] == one[i % 5] ? 1 : 0;
			count[2] += answers[i] == two[i % 8] ? 1 : 0;
			count[3] += answers[i] == three[i % 10] ? 1 : 0;
		}

		int max = Math.max(count[1], Math.max(count[2], count[3]));
		ArrayList<Integer> num = new ArrayList<Integer>();
		for (int i = 1; i < count.length; i++)
			if (count[i] == max)
				num.add(i);

		int[] answer = new int[num.size()];
		for (int i = 0; i < num.size(); i++)
			answer[i] = num.get(i);

		return answer;
	}
}
