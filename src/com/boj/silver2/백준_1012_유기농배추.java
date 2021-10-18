package com.boj.silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_1012_유기농배추 {
	static int M, N, K, answer;
	static int[][] farm;
	static int dr[] = { -1, 0, 1, 0 }, dc[] = { 0, 1, 0, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			answer = 0;

			// 배추가 심어져있는 밭 표시
			farm = new int[M][N];
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				farm[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
			}

			for (int r = 0; r < M; r++) {
				for (int c = 0; c < N; c++) {
					if (farm[r][c] == 1)
						goWorm(r, c);
				}
			}
			System.out.println(answer);
		}
	}

	// bfs로 1이 모여있는 그룹을 찾아 0으로 바꾼다.
	private static void goWorm(int r, int c) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[] { r, c });
		farm[r][c] = 0; // 방문처리

		while (!queue.isEmpty()) {
			int[] n = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nr = n[0] + dr[i];
				int nc = n[1] + dc[i];

				if (nr < 0 || nc < 0 || nr >= M || nc >= N || farm[nr][nc] == 0)
					continue;

				farm[nr][nc] = 0; // 방문처리
				queue.add(new int[] { nr, nc });
			}
		}
		answer++;
	}

}
