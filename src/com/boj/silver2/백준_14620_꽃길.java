package com.boj.silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_14620_꽃길 {
	static int N, min = Integer.MAX_VALUE;
	static int price[][], dr[] = { -1, 1, 0, 0 }, dc[] = { 0, 0, -1, 1 };
	static boolean isVisited[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine()); // 꽃밭 한 변 길이
		price = new int[N][N]; // 꽃밭 사용료
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				price[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 꽃 3개 배치
		isVisited = new boolean[N][N];
		flower(0, 0);
		System.out.println(min);
	}

	private static void flower(int cnt, int sum) {
		if (cnt == 3) { // 3개 배치 완료
			min = Math.min(min, sum);
			return;
		}
		for (int i = 1; i < N - 1; i++) {
			for (int j = 1; j < N - 1; j++) {
				if (isPossible(i, j)) {	// 꽃 배치가 가능한 자리라면
					int s = price[i][j] + price[i - 1][j] + price[i + 1][j] + price[i][j - 1] + price[i][j + 1];
					changeVisit(i, j, true);	// 방문 처리
					flower(cnt + 1, sum + s);	// 다음 꽃 배치하러가기
					changeVisit(i, j, false);	// 방문 처리 취소
				}
			}
		}

	}

	// b(T/F)로 방문처리를 변경해주기
	private static void changeVisit(int r, int c, boolean b) {
		isVisited[r][c] = b;	// 자신
		for (int i = 0; i < 4; i++) { // 자기 주위
			int nr = r + dr[i];
			int nc = c + dc[i];

			isVisited[nr][nc] = b;
		}
	}

	// 꽃 배치가 가능한 자리인지 확인
	private static boolean isPossible(int r, int c) {
		if (isVisited[r][c])
			return false; // 자기 위치 check

		for (int i = 0; i < 4; i++) { // 자기 주위 check(사방탐색)
			int nr = r + dr[i];
			int nc = c + dc[i];

			if (nr < 0 || nc < 0 || nr >= N || nc >= N || isVisited[nr][nc])
				return false;
		}
		return true;
	}

}
