package com.pro.level1;

import java.util.Arrays;

public class K번째수 {

	public static void main(String[] args) {
		int[] array = { 1, 5, 2, 6, 3, 7, 4 };
		int[][] commands = { { 2, 5, 3 }, { 4, 4, 1 }, { 1, 7, 3 } };
		int[] answer = solution(array, commands);
		System.out.println(Arrays.toString(answer));
	}

	public static int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];

		for (int i = 0; i < commands.length; i++) {
			int[] new_array = new int[commands[i][1] - commands[i][0] + 1];
			for (int j = commands[i][0], cnt = 0; j <= commands[i][1]; j++, cnt++)
				new_array[cnt] = array[j - 1];
			Arrays.sort(new_array);
			answer[i] = new_array[commands[i][2] - 1];
		}

		return answer;
	}
}
