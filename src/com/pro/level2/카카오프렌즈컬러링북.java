package com.pro.level2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 카카오프렌즈컬러링북 {

	public static void main(String[] args) {
		int m = 6;
		int n = 4;
		int[][] picture = { { 1, 1, 1, 0 }, { 1, 2, 2, 0 }, { 1, 0, 0, 1 }, { 0, 0, 0, 1 }, { 0, 0, 0, 3 },
				{ 0, 0, 0, 3 } };
		System.out.println(Arrays.toString(solution(m, n, picture)));
	}

	public static boolean[][] isVisited;

	public static int[] solution(int m, int n, int[][] picture) {
		int numberOfArea = 0;
		int maxSizeOfOneArea = 0;

		isVisited = new boolean[m][n];
		for (int r = 0; r < m; r++) {
			for (int c = 0; c < n; c++) {
				if (picture[r][c] != 0 && !isVisited[r][c]) {
					maxSizeOfOneArea = Math.max(maxSizeOfOneArea, bfs(r, c, m, n, picture));
					numberOfArea++;
				}
			}
		}

		return new int[] { numberOfArea, maxSizeOfOneArea };
	}

	private static int bfs(int r, int c, int m, int n, int[][] picture) {
		int[] dr = { -1, 1, 0, 0 }, dc = { 0, 0, -1, 1 };
		int sum = 1; // 면적(처음 시작점)
		int pivot = picture[r][c]; // 비교할 기준
		
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] { r, c });
		isVisited[r][c] = true; // 방문처리

		while (!queue.isEmpty()) {

			int[] p = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nr = p[0] + dr[i];
				int nc = p[1] + dc[i];

				if (nr < 0 || nc < 0 || nr >= m || nc >= n || picture[nr][nc] != pivot || isVisited[nr][nc])
					continue;

				queue.offer(new int[] { nr, nc });
				isVisited[nr][nc] = true;
				sum++;
			}
		}

		return sum;
	}
}
