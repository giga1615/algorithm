package com.pro.level1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class 두개뽑아서더하기 {

	public static void main(String[] args) {
		int[] numbers = { 5, 0, 2, 7 };
		System.out.println(Arrays.toString(solution(numbers)));
	}

	public static int[] solution(int[] numbers) {

		HashSet<Integer> sum = new HashSet<Integer>();
		for (int i = 0; i < numbers.length; i++) {
			for (int j = i + 1; j < numbers.length; j++) {
				sum.add(numbers[i] + numbers[j]);
			}
		}

		int[] answer = new int[sum.size()];
		int i = 0;
		Iterator<Integer> it = sum.iterator();
		while (it.hasNext())
			answer[i++] = it.next();

		Arrays.sort(answer);

		return answer;
	}

}
