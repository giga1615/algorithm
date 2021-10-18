package com.pro.level2;

public class 타겟넘버 {
	static int answer = 0;

	public static void main(String[] args) {
		int[] numbers = { 1, 1, 1, 1, 1 };
		int target = 3;
		System.out.println(solution(numbers, target));
	}

	public static int solution(int[] numbers, int target) {

		makeTargetNum(numbers, target, 0, 0);

		return answer;
	}

	static void makeTargetNum(int[] numbers, int target, int cnt, int sum) {
		if (cnt == numbers.length) {
			if (sum == target)
				answer++;
			return;
		}

		makeTargetNum(numbers, target, cnt + 1, sum - numbers[cnt]);
		makeTargetNum(numbers, target, cnt + 1, sum + numbers[cnt]);
	}
}
