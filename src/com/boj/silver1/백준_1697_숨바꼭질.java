package com.boj.silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_1697_숨바꼭질 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		boolean road[] = new boolean[200001];
		road[N] = true; // 방문처리

		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(N);

		int time = 0;
		boolean isFind = false;
		while (!queue.isEmpty() && !isFind) {
			int size = queue.size();

			while (--size >= 0 && !isFind) {
				int num = queue.poll();

				if (num == K) {
					isFind = true;
					break;
				}

				if (num > 0 && !road[num - 1]) {
					queue.offer(num - 1);
					road[num - 1] = true;
				}

				if (num + 1 < 200000 && !road[num + 1]) {
					queue.offer(num + 1);
					road[num + 1] = true;
				}

				if (num * 2 < 200000 && !road[num * 2]) {
					queue.offer(num * 2);
					road[num * 2] = true;
				}
			}

			time++;
		}
		System.out.println(time - 1);

	}

}
