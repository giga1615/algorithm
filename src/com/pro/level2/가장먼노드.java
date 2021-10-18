package com.pro.level2;

import java.util.*;

public class 가장먼노드 {

	public static void main(String[] args) {
		int[][] edge = { { 3, 6 }, { 4, 3 }, { 3, 2 }, { 1, 3 }, { 1, 2 }, { 2, 4 }, { 5, 2 } };
		System.out.println(solution(6, edge));
	}

	static boolean matrix[][], isVisited[];
	static int answer;

	public static int solution(int n, int[][] edge) {
		matrix = new boolean[n + 1][n + 1];
		for (int i = 0; i < edge.length; i++)
			matrix[edge[i][0]][edge[i][1]] = matrix[edge[i][1]][edge[i][0]] = true;

		isVisited = new boolean[n + 1];
		bfs(1);

		return answer;
	}

	static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		isVisited[start] = true;
		queue.offer(start);

		while (!queue.isEmpty()) {
			int size = queue.size();
			answer = size;

			while (--size >= 0) {
				int n = queue.poll();
				for (int i = 1; i < matrix.length; i++) {
					if (!isVisited[i] && matrix[n][i]) {
						isVisited[i] = true;
						queue.offer(i);
					}
				}
			}
		}
	}
}
