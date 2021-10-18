package com.pro.level2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 행렬테두리회전하기 {

	public static void main(String[] args) {
		int rows = 6;
		int columns = 6;
		int[][] queries = { { 2, 2, 5, 4 }, { 3, 3, 6, 6 }, { 5, 1, 6, 3 } };
		System.out.println(Arrays.toString(solution(rows, columns, queries)));
	}

	public static int[] solution(int rows, int columns, int[][] queries) {
		int[] answer = new int[queries.length];

		// 배열 만들기
		int[][] matrix = new int[rows][columns];
		int num = 1;
		for (int i = 0; i < rows; i++)
			for (int j = 0; j < columns; j++)
				matrix[i][j] = num++;

		int[] dr = { 0, 1, 0, -1 }, dc = { 1, 0, -1, 0 };

		// 회전
		for (int i = 0; i < queries.length; i++) {
			int min = Integer.MAX_VALUE;

			// 회전하면서 들릴 꼭짓점 순서대로 넣어주기
			Queue<int[]> queue = new LinkedList<int[]>();
			queue.offer(new int[] { queries[i][0] - 1, queries[i][3] - 1 });
			queue.offer(new int[] { queries[i][2] - 1, queries[i][3] - 1 });
			queue.offer(new int[] { queries[i][2] - 1, queries[i][1] - 1 });
			queue.offer(new int[] { queries[i][0] - 1, queries[i][1] - 1 });

			int temp = 0, d = 0;
			int r = queries[i][0] - 1, c = queries[i][1] - 1;

			while (!queue.isEmpty()) {
				// 바꾸고
				int value = matrix[r][c]; // 원래 값 저장
				min = Math.min(min, value);

				if (temp != 0)
					matrix[r][c] = temp;

				// 이동
				// 현재 위치가 꼭짓점이면, d증가
				int p[] = queue.peek();
				if (r == p[0] && c == p[1]) {
					queue.poll();
					if (queue.isEmpty())
						break;
					d++;
				}

				r += dr[d];
				c += dc[d];
				temp = value;
			}

			answer[i] = min;
		}

		return answer;
	}
}
