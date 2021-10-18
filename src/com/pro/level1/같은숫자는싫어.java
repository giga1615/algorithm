package com.pro.level1;

import java.util.ArrayList;
import java.util.Arrays;

public class 같은숫자는싫어 {

	public static void main(String[] args) {
		int[] arr = { 4, 4, 4, 3, 3 };
		System.out.println(Arrays.toString(solution(arr)));
	}

	public static int[] solution(int[] arr) {
		ArrayList<Integer> num = new ArrayList<Integer>();
		num.add(arr[0]);
		for (int i = 1; i < arr.length; i++) {
			if (arr[i - 1] != arr[i])
				num.add(arr[i]);
		}

		int[] answer = new int[num.size()];
		for (int i = 0; i < answer.length; i++)
			answer[i] = num.get(i);

		return answer;
	}
}
