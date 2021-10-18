package com.boj.silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 백준_1743_음식물피하기 {
	static int N, M, max = Integer.MIN_VALUE, cnt;
	static int dr[] = { -1, 1, 0, 0 }, dc[] = { 0, 0, -1, 1 };
	static ArrayList<int[]> trash;
	static boolean board[][], isVisited[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 세로
		M = Integer.parseInt(st.nextToken()); // 가로

		board = new boolean[N][M];
		int K = Integer.parseInt(st.nextToken()); // 음식물 쓰레기 수
		trash = new ArrayList<int[]>(); // 쓰레기 위치 저장
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			board[r][c] = true;
			trash.add(new int[] { r, c });
		}

		// 쓰레기 각각 옆으로 한칸씩 나아가면서 주변에 몇개의 쓰레기와 이어져있는지 체크
		isVisited = new boolean[N][M];
		for (int i = 0; i < trash.size(); i++) {
			if (!isVisited[trash.get(i)[0]][trash.get(i)[1]]) {
				cnt = 0;
				dfs(trash.get(i)[0], trash.get(i)[1]);
				max = Math.max(max, cnt);
			}
		}

		System.out.println(max);
	}

	private static void dfs(int r, int c) {
		isVisited[r][c] = true; // 방문 처리
		cnt++; // 쓰레기 숫자 증가

		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			// 방문했거나, 쓰레기가 아니면 패스
			if (nr < 0 || nc < 0 || nr >= N || nc >= M || isVisited[nr][nc] || !board[nr][nc])
				continue;
			dfs(nr, nc);
		}
	}

}
