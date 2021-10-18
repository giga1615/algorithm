package com.boj.gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class 백준_2812_크게만들기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		String num = br.readLine();

		int cnt = 0;
		boolean flag = true;
		Deque<Integer> stack = new ArrayDeque<Integer>();
		stack.addLast(num.charAt(0) - '0'); // 첫 숫자

		for (int i = 1; i < num.length(); i++) {
			int n = num.charAt(i) - '0';

			while (!stack.isEmpty() && flag) {
				if (cnt == K) { // 종료조건
					flag = false;
					break;
				}
				// 제일 뒤에있는 숫자보다 n이 더 크면 제거하자
				if (stack.peekLast() < n) {
					stack.pollLast();
					cnt++;
				} else
					break;
			}
			stack.addLast(n);
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N - K; i++) {
			sb.append(stack.pollFirst());
		}
		
		System.out.println(sb.toString());
	}

}
