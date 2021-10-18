package com.pro.level1;

public class 키패드누르기 {

	public static void main(String[] args) {
		int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
		String hand = "right";
		System.out.println(solution(numbers, hand));
	}

	public static String solution(int[] numbers, String hand) {

		// 0~9, *, # 키패드의 좌표를 저장
		int[][] keypad = { { 3, 1 }, { 0, 0 }, { 0, 1 }, { 0, 2 }, { 1, 0 }, { 1, 1 }, { 1, 2 }, { 2, 0 }, { 2, 1 },
				{ 2, 2 }, { 3, 0 }, { 3, 2 } };
		int leftHand = 10; // *
		int rightHand = 11; // #

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < numbers.length; i++) {
			int n = numbers[i];

			if (n == 1 || n == 4 || n == 7) { // 왼손 무조건
				leftHand = n;
				sb.append('L');
			} else if (n == 3 || n == 6 || n == 9) { // 오른손 무조건
				rightHand = n;
				sb.append("R");
			} else {	// 두 손의 거리 비교
				int ld = Math.abs(keypad[leftHand][0] - keypad[n][0]) + Math.abs(keypad[leftHand][1] - keypad[n][1]);
				int rd = Math.abs(keypad[rightHand][0] - keypad[n][0]) + Math.abs(keypad[rightHand][1] - keypad[n][1]);
				char dir = ld == rd ? hand.compareTo("right") == 0 ? 'r' : 'l' : ld < rd ? 'l' : 'r';

				if (dir == 'l') {
					leftHand = n;
					sb.append('L');
				} else {
					rightHand = n;
					sb.append("R");
				}
			}
		}

		return sb.toString();
	}

}
