package com.boj.silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_15486_퇴사2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] cost = new int[2][N + 2];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			cost[0][i] = Integer.parseInt(st.nextToken());
			cost[1][i] = Integer.parseInt(st.nextToken());
		}

		int max = 0;
		int[] dp = new int[N + 2];
		for (int i = 1; i < N + 2; i++) {
			max = Math.max(max, dp[i]);

			int day = i + cost[0][i];
			if (day < N + 2)
				dp[day] = Math.max(dp[day], max + cost[1][i]);
		}

		System.out.println(max);
	}

}
