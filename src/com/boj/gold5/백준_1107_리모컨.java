package com.boj.gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_1107_리모컨 {
	static int N, M, ch = 100, ans;
	static boolean num[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		num = new boolean[10];
		if (M != 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++)
				num[Integer.parseInt(st.nextToken())] = true; // 고장
		}

		ans = Math.abs(N - ch);
		turnChannel();

		System.out.println(ans);
	}

	private static void turnChannel() {
		for (int i = 0; i <= 999999; i++) {
			String s = i + ""; // 문자열로 바꾸기
			int len = s.length(); // 숫자길이

			boolean isOk = true;
			for (int j = 0; j < len && isOk; j++) {
				if (num[s.charAt(j) - '0']) {
					isOk = false;
					break;
				}
			}

			if (isOk) {
				ans = Math.min(ans, Math.abs(N - i) + len);
			}
		}
	}

}
