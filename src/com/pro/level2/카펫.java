package com.pro.level2;

import java.util.Arrays;

public class 카펫 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(10, 2)));
	}

	public static int[] solution(int brown, int yellow) {
		// (r + 2) * (c + 2) = y + b일 때, r * c = y임을 이용
		for (int c = 1; c <= yellow / 2 + 1; c++) {
			if (yellow % c == 0) {
				int r = yellow / c;
				if ((r + 2) * (c + 2) == yellow + brown)
					return new int[] { r + 2, c + 2 };
			}
		}

		return new int[] {};
	}
}
