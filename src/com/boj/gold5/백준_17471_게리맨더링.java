package com.boj.gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 백준_17471_게리맨더링 {
	static int N, matrix[][], people[], result = Integer.MAX_VALUE;
	static boolean isSelected[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 구역 수
		people = new int[N + 1]; // 인구 수
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++)
			people[i] = Integer.parseInt(st.nextToken());

		// 인접행렬 만들기
		matrix = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken()); // N구역이 인접한 구역 수
			for (int j = 0; j < M; j++)
				matrix[i][Integer.parseInt(st.nextToken())] = 1;
		}

		// 2개 지역구 부분집합 구하기
		isSelected = new boolean[N + 1];
		subset(1);
		
		// 출력 : 팀을 만들 수 없는 경우에는 -1 출력
		System.out.println(result == Integer.MAX_VALUE ? -1 : result);
	}

	// 부분집합 만들기
	private static void subset(int cnt) {
		if (cnt == N + 1) {
			// 두 팀이 각각 연결되어있는지 확인
			if (checkTeam(true) && checkTeam(false))
				result = Math.min(result, gap());
			return;
		}
		// 부분집합에 포함
		isSelected[cnt] = true;
		subset(cnt + 1); // 다음 원소

		// 부분집합에 비포함
		isSelected[cnt] = false;
		subset(cnt + 1); // 다음 원소
	}

	// 팀이 연결되어있는지 체크
	private static boolean checkTeam(boolean flag) {
		boolean isVisited[] = new boolean[N + 1];
		LinkedList<Integer> list = new LinkedList<Integer>();

		// 시작점 찾기
		for (int i = 1; i <= N; i++) {
			if (isSelected[i] == flag) {
				list.addLast(i);
				isVisited[i] = true;
				break;
			}
		}

		// n에서 출발하여 연결된 정점 방문 & flag에 해당하는 팀 찾아서 방문처리
		while (!list.isEmpty()) {
			int n = list.pollFirst();

			for (int i = 1; i <= N; i++) {
				// 시작점 또는 flag와 다른 팀이면 스킵
				if (isVisited[i] || flag != isSelected[i])
					continue;

				if (matrix[n][i] == 1) {
					list.addLast(i);
					isVisited[i] = true;
				}
			}
		}

		// 같은 flag팀인데 방문 안 한 곳이 있는지 확인
		for (int i = 1; i <= N; i++) {
			if (isSelected[i] == flag && !isVisited[i]) // 모든 정점이 연결되지 않은 것
				return false;
		}

		return true;
	}
	
	// 두 팀의 점수 차 확인
	private static int gap() {
		int teamA = 0, teamB = 0;

		for (int i = 1; i <= N; i++) {
			if (isSelected[i])	// 부분집합에 포함된 팀
				teamA += people[i];
			else				// 미 포함 팀
				teamB += people[i];
		}

		return Math.abs(teamA - teamB);
	}

}
