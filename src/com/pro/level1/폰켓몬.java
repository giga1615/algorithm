package com.pro.level1;

import java.util.HashMap;

public class 폰켓몬 {

	public static void main(String[] args) {
		int[] nums = { 3, 3, 3, 2, 2, 2 };
		System.out.println(solution(nums));
	}

	public static int solution(int[] nums) {

		HashMap<Integer, Integer> ponketmon = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (ponketmon.containsKey(nums[i]))
				ponketmon.put(nums[i], ponketmon.get(nums[i]) + 1);
			else
				ponketmon.put(nums[i], 1);
		}

		return ponketmon.size() > nums.length / 2 ? nums.length / 2 : ponketmon.size();
	}
}
