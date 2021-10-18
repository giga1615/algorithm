package com.pro.level1;

import java.util.Arrays;

public class 소수만들기 {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 7, 6, 4 };
		System.out.println(solution(nums));
	}

	static int answer;
	static boolean Eratos[];

	public static int solution(int[] nums) {
		// 소수인 것 찾기
		Eratos = new boolean[3001];
		Arrays.fill(Eratos, true);
		for (int i = 2; i * i <= 3000; i++) {
			if (Eratos[i])
				for (int j = i * i; j <= 3000; j += i)
					Eratos[j] = false;
		}

		combination(0, 0, 0, nums);

		return answer;
	}

	// 3개씩 고르는 경우의 수
	private static void combination(int cnt, int cur, int sum, int[] nums) {
		if (cnt == 3) {
			if (Eratos[sum] == true)
				answer++;
			return;
		}

		for (int i = cur; i < nums.length; i++) {
			combination(cnt + 1, i + 1, nums[i] + sum, nums);
		}
	}
}
