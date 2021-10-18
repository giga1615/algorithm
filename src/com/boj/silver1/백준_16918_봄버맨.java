package com.boj.silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_16918_봄버맨 {
	static int R, C, dr[] = { -1, 1, 0, 0 }, dc[] = { 0, 0, -1, 1 };
	static char[][] board;
	static Queue<int[]> bombs;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken()); // 행
		C = Integer.parseInt(st.nextToken()); // 열
		int N = Integer.parseInt(st.nextToken()); // 시간

		board = new char[R][C]; // 격자판
		bombs = new LinkedList<int[]>(); // 폭탄 좌표
		for (int i = 0; i < R; i++) {
			board[i] = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				// 폭탄좌표 저장
				if (board[i][j] == 'O')
					bombs.offer(new int[] { i, j });
			}
		}

		// 처음 1초는 아무것도 하지 않으므로 1부터 시작
		for (int time = 1; time < N; time++) {
			if (time % 2 == 1) // 모든 칸에 폭탄을 설치한다.
				makeBomb();

			if (time % 2 == 0) // 폭탄 폭발
				explode();
		}

		// 결과 출력
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++)
				System.out.print(board[i][j]);
			System.out.println();
		}
	}

	private static void explode() {
		// 폭탄 폭발
		while (!bombs.isEmpty()) {
			int[] p = bombs.poll();
			board[p[0]][p[1]] = '.'; // 자기 위치 폭탄 터짐 처리

			// 주변도 폭탄 처리하기
			for (int i = 0; i < 4; i++) {
				int r = p[0] + dr[i];
				int c = p[1] + dc[i];

				if (r < 0 || c < 0 || r >= R || c >= C) continue;

				board[r][c] = '.';
			}
		}

		// 바뀐 폭탄 위치 저장
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (board[i][j] == 'O')
					bombs.offer(new int[] { i, j });
			}
		}
	}

	// 모든 칸에 폭탄 설치
	private static void makeBomb() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (board[i][j] == '.')
					board[i][j] = 'O';
			}
		}
	}

}
