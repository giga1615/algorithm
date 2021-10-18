package com.pro.level3;

public class 네트워크 {
	static boolean[] isVisited;

	public static void main(String[] args) {
		int n = 3;
		int[][] computers = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };
		System.out.println(solution(n, computers));
	}

	public static int solution(int n, int[][] computers) {
		int answer = 0;

		isVisited = new boolean[n]; // 방문 처리
		for (int i = 0; i < n; i++) {
			if (!isVisited[i]) {
				dfs(i, computers);
				answer++;
			}
		}

		return answer;
	}

	static void dfs(int cur, int[][] computers) {
		isVisited[cur] = true;
		for (int j = 0; j < computers.length; j++) {
			if (!isVisited[j] && computers[cur][j] == 1) {
				dfs(j, computers);
			}
		}
	}
}
