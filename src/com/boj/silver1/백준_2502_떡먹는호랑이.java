package com.boj.silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_2502_떡먹는호랑이 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int D = Integer.parseInt(st.nextToken()); // 할머니가 넘어온 날
		int K = Integer.parseInt(st.nextToken()); // 호랑이에게 준 떡 개수

		int dp[][] = new int[31][2]; // day
		dp[1][0] = 1;
		dp[2][1] = 1;
		for (int i = 3; i <= D; i++)
			for (int j = 0; j < 2; j++)
				dp[i][j] = dp[i - 2][j] + dp[i - 1][j];
		
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= K; i++) {
			if((K - dp[D][0] * i) % dp[D][1] == 0) {
				sb.append(i + "\n");
				sb.append((K - dp[D][0] * i) / dp[D][1]);
				break;
			}
		}
		System.out.println(sb.toString());
	}

}
