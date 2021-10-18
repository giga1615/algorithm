package com.boj.silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_2644_촌수계산 {
	static int N, person1, person2, level;
	static boolean matrix[][], isVisited[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 전체 사람 수
		StringTokenizer st = new StringTokenizer(br.readLine());
		person1 = Integer.parseInt(st.nextToken()) - 1; // 사람1
		person2 = Integer.parseInt(st.nextToken()) - 1; // 사람2

		int M = Integer.parseInt(br.readLine()); // 관계 수
		matrix = new boolean[N][N]; // 관계를 나타내는 인접행렬
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int p1 = Integer.parseInt(st.nextToken()) - 1;
			int p2 = Integer.parseInt(st.nextToken()) - 1;
			matrix[p1][p2] = matrix[p2][p1] = true;
		}
		
		isVisited = new boolean[N];
		bfs();
		System.out.println(level);
	}

	private static void bfs() {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(person1);
		isVisited[person1] = true;

		while (!queue.isEmpty()) {
			int size = queue.size();
			level++; // 촌수 증가
			while (--size >= 0) {
				int start = queue.poll();
				for (int i = 0; i < N; i++) {
					if (matrix[start][i]) { // 인접한 것들 중에서
						if (i == person2) // 도착지와 같으면 끝
							return;
						else if(!isVisited[i]){ 	// 아니면, queue에 넣고 계속 탐색
							queue.offer(i);
							isVisited[i] = true;
						}
					}
				}
			}
		}
		level = -1;
	}

}
