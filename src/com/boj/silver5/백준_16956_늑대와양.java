package com.boj.silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_16956_늑대와양 {
	static int R, C, dr[] = { -1, 1, 0, 0 }, dc[] = { 0, 0, -1, 1 }, answer = 1;
	static char[][] pasture;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken()); // 목장 가로길이
		C = Integer.parseInt(st.nextToken()); // 목장 세로길이

		pasture = new char[R][C]; // 목장 입력 받기
		for (int i = 0; i < R; i++)
			pasture[i] = br.readLine().toCharArray();

		// 늑대 찾아서, 주위에 울타리 치기
		// answer==1 이면, 바로옆에 양이 있다는 것, 따라서 바로 0출력
		for (int i = 0; i < R && answer == 1; i++) {
			for (int j = 0; j < C && answer == 1; j++) {
				if (pasture[i][j] == 'W') {	// 늑대를 만나면, 바로 옆에 양이 있는지 사방 탐색
					for (int k = 0; k < 4 && answer == 1; k++) {
						int r = i + dr[k];
						int c = j + dc[k];

						if (r < 0 || c < 0 || r >= R || c >= C)
							continue;

						if (pasture[r][c] == 'S')	// 양을 만나면, 답을 0 출력하도록 처리
							answer = 0;
						else if (pasture[r][c] == '.')	// 주변이 빈칸이면, 죄다 울타리 쳐버리기
							pasture[r][c] = 'D';
					}
				}
			}
		}

		System.out.println(answer);
		if (answer == 1) {	// 울타리를 칠 수 있으면, 그 울타리 친 방법도 출력하자
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++)
					System.out.print(pasture[i][j]);
				System.out.println();
			}
		}
	}
}
