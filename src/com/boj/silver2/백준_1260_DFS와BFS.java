package com.boj.silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Iterator;
import java.util.StringTokenizer;

public class 백준_1260_DFS와BFS {
	static int N, M, V;
	static boolean isVisited[];
	static boolean matrix[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 정점수
		M = Integer.parseInt(st.nextToken()); // 간선수
		V = Integer.parseInt(st.nextToken()); // 탐색 할 정점

		matrix = new boolean[N + 1][N + 1];

		// 간선
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			matrix[s][e] = true;
			matrix[e][s] = true;
		}

		isVisited = new boolean[N + 1]; // 1번부터 세려고
		dfs(V);
		System.out.println();
		isVisited = new boolean[N + 1]; // 1번부터 세려고
		bfs();
	}

	private static void dfs(int vertex) {
		isVisited[vertex] = true;
		System.out.print(vertex + " ");

		for (int i = 1; i <= N; i++) {
			if (!isVisited[i] && matrix[vertex][i])
				dfs(i);
		}
	}

	private static void bfs() {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(V);
		isVisited[V] = true;

		while (!queue.isEmpty()) {
			int n = queue.poll();
			System.out.print(n + " ");

			for (int i = 1; i <= N; i++) {
				if (matrix[n][i] == true && !isVisited[i]) {
					queue.add(i);
					isVisited[i] = true;
				}
			}
		}
	}

}
