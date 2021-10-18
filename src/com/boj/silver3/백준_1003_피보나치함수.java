package com.boj.silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준_1003_피보나치함수 {
	static int dp[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		dp = new int[41][2];
		dp[0] = new int[] { 1, 0 };
		dp[1] = new int[] { 0, 1 };

		for (int i = 0; i < T; i++) {
			int answer[] = fibonacci(Integer.parseInt(br.readLine()));
			System.out.println(answer[0] + " " + answer[1]);
		}
	}

	private static int[] fibonacci(int n) {
		if (n >= 2 && dp[n][0] == 0 && dp[n][1] == 0) {
			int a[] = fibonacci(n - 1);
			int b[] = fibonacci(n - 2);
			dp[n][0] = a[0] + b[0];
			dp[n][1] = a[1] + b[1];
		}

		return dp[n];
	}
}
