package com.boj.gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_14503_로봇청소기 {
	static int N, M, r, c, d;
	static int board[][], dr[] = { -1, 0, 1, 0 }, dc[] = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 세로
		M = Integer.parseInt(st.nextToken()); // 가로
		board = new int[N][M];

		st = new StringTokenizer(br.readLine()); // 로봇청소기 좌표(r,c), 방향(d)
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int result = 0;
		while (true) {
			// 현재 위치 청소
			if (board[r][c] == 0) {
				result++;
				board[r][c] = 2; // 청소했음을 기록
			}

			// 청소할 방향 탐색
			boolean isClear = false;
			for (int i = 0; i < 4; i++) {
				int nd = (d + 3 - i) % 4;
				int nr = r + dr[nd];
				int nc = c + dc[nd];

				if (0 <= nr && 0 <= nc && nr < N && nc < M)
					if (board[nr][nc] == 0) {
						d = nd;
						r = nr;
						c = nc;
						isClear = true;
						break;
					}
			}

			// 네 방향 모두 청소가 되어 있는 경우 : 뒤쪽 방향 확인
			if (!isClear) {
				int nd = (d + 2) % 4;
				int nr = r + dr[nd];
				int nc = c + dc[nd];

				if (0 <= nr && 0 <= nc && nr < N && nc < M && board[nr][nc] != 1) { // 벽이 아니면 후진
					r = nr;
					c = nc;
				} else // 뒤쪽도 벽이면 작동을 멈춤
					break;
			}
		}

		System.out.println(result);
	}

}
