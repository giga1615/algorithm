package com.pro.level1;

import java.util.Arrays;

public class 행렬의덧셈 {

	public static void main(String[] args) {
		int[][] arr1 = { { 1 }, { 2 } };
		int[][] arr2 = { { 3 }, { 5 } };
		System.out.println(Arrays.deepToString(solution(arr1, arr2)));

	}

	public static int[][] solution(int[][] arr1, int[][] arr2) {
		int[][] answer = new int[arr1.length][arr1[0].length];
		for (int r = 0; r < arr1.length; r++)
			for (int c = 0; c < arr1[0].length; c++)
				answer[r][c] = arr1[r][c] + arr2[r][c];
		return answer;
	}
}
