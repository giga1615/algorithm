package com.boj.silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_1780_종이의개수 {
	static int N, paper[][], answer[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		// 입력
		paper = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		answer = new int[3]; // { -1, 0, 1로 채워진 수 개수 }
		search(1, 1, N);

		// -1, 0, 1로 이루어진 종이 수 출력
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 3; i++)
			sb.append(answer[i] + "\n");
		System.out.println(sb.toString());
	}

	// 종이개수 구하기
	private static void search(int r, int c, int n) {
		if (n < 1) // 종료조건
			return;

		// 같은 숫자로 채워져있으면, 종이 개수 세기
		if (checkNum(r, c, n)) {
			int num = paper[r][c];
			answer[num + 1]++;	// { -1, 0, 1로 채워진 수 개수 }
			return;
		}

		// 다른 숫자면, 9등분하여 다시 탐색
		int newNum = n / 3;
		
		search(r, c, newNum);
		search(r, c + newNum, newNum);
		search(r, c + 2 * newNum, newNum);
		search(r + newNum, c, newNum);
		search(r + newNum, c + newNum, newNum);
		search(r + newNum, c + 2 * newNum, newNum);
		search(r + 2 * newNum, c, newNum);
		search(r + 2 * newNum, c + newNum, newNum);
		search(r + 2 * newNum, c + 2 * newNum, newNum);
	}

	// 같은 숫자로 채워져있는지 확인
	private static boolean checkNum(int r, int c, int n) {
		int nr = r + n - 1;
		int nc = c + n - 1;

		int pivot = paper[r][c]; // 첫 좌표 값을 기준으로하여 비교
		boolean isSame = true;
		for (int i = r; i <= nr && isSame; i++) {
			for (int j = c; j <= nc && isSame; j++) {
				if (pivot != paper[i][j]) // 하나라도 다르면 false
					isSame = false;
			}
		}

		return isSame;
	}

}
