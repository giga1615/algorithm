package com.boj.silver2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 백준_4948_베르트랑공준 {

	static int N, cnt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 소수 만들기
		boolean[] Eratos = new boolean[246913];
		Arrays.fill(Eratos, true);
		for (int i = 2; i * i < 246913; i++) {
			if (Eratos[i])
				for (int j = i * i; j < 246913; j = j + i)
					Eratos[j] = false;
		}

		while (true) {
			cnt = 0;
			N = Integer.parseInt(br.readLine());
			if (N == 0)
				break; // 0 입력 받으면 종료

			for (int i = N + 1; i < 246913 && i <= 2 * N; i++) {
				if (Eratos[i]) 
					cnt++;
			}

			System.out.println(cnt);
		}

	}

}