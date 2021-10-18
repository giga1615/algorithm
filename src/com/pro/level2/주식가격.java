package com.pro.level2;

import java.util.Arrays;

public class 주식가격 {

	public static void main(String[] args) {
		int[] prices = { 1, 2, 3, 2, 3 };
		System.out.println(Arrays.toString(solution(prices)));
	}

	public static int[] solution(int[] prices) {
		int[] answer = new int[prices.length];

		for (int i = 0; i < prices.length; i++) {
			int time = 0;
			for (int j = i + 1; j < prices.length; j++) {
				time++;
				if (prices[i] > prices[j])
					break;
			}
			answer[i] = time;
		}

		return answer;
	}
}
