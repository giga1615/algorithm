package com.boj.silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_2503_숫자야구 {
	static int number[], N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		number = new int[1000]; // 0~999

		// 민혁 질문
		StringTokenizer st;
		int num = 0, strike = 0, ball = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			num = Integer.parseInt(st.nextToken());
			strike = Integer.parseInt(st.nextToken());
			ball = Integer.parseInt(st.nextToken());

			// 규칙에 맞지 않는 것 제외
			check(num, strike, ball);
		}

		// 정답수 카운트
		int result = 0;
		for (int i = 123; i <= 987; i++)
			if (number[i] == N) // 민혁이의 N개 질문에 모두 적합한 숫자는 몇개? 
				result++;

		System.out.println(result);
	}

	// 볼과 스트라이크 수에 맞는 숫자인지 체크
	private static void check(int num, int strike, int ball) {
		int num3 = num;
		int num1 = num3 % 10; // 1자리
		num3 /= 10;
		int num2 = num3 % 10; // 10자리
		num3 /= 10; // 100자리

		for (int i = 123; i <= 987; i++) {
			int strike_cnt = 0;
			int ball_cnt = 0;

			int i3 = i;
			int i1 = i3 % 10;	// 1자리
			i3 /= 10;
			int i2 = i3 % 10;	// 10자리
			i3 /= 10;	// 100자리

			// 0이 들어있거나 같은 숫자인 것이 있으면 패스
			if (i1 == 0 || i2 == 0 || i3 == 0 || i1 == i2 || i2 == i3 || i1 == i3)
				continue;

			// 스트라이크와 볼 숫자 세기
			if (num1 == i1)
				strike_cnt++;
			else if (num1 == i2 || num1 == i3)
				ball_cnt++;
			if (num2 == i2)
				strike_cnt++;
			else if (num2 == i1 || num2 == i3)
				ball_cnt++;
			if (num3 == i3)
				strike_cnt++;
			else if (num3 == i1 || num3 == i2)
				ball_cnt++;

			// 민혁이의 질문에 대한 답과 같으면 +1
			if (ball_cnt == ball && strike_cnt == strike)
				number[i]++;
		}

	}
}
