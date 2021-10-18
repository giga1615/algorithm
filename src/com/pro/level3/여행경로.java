package com.pro.level3;

import java.util.*;

public class 여행경로 {

	public static void main(String[] args) {
		String[][] tickets = { { "ICN", "JFK" }, { "HND", "IAD" }, { "JFK", "HND" } };
		System.out.println(Arrays.deepToString(solution(tickets)));
	}

	static boolean isVisited[];
	static ArrayList<String> answer;

	public static String[] solution(String[][] tickets) {
		answer = new ArrayList<String>();
		isVisited = new boolean[tickets.length];
		dfs(tickets, "ICN", "ICN", 1);
		Collections.sort(answer);

		return answer.get(0).split(" ");
	}

	private static void dfs(String[][] tickets, String route, String des, int cnt) {
		if (cnt == tickets.length + 1) {
			answer.add(route);
			return;
		}

		for (int i = 0; i < tickets.length; i++) {
			if (!isVisited[i] && des.equals(tickets[i][0])) {
				isVisited[i] = true;
				dfs(tickets, route + " " + tickets[i][1], tickets[i][1], cnt + 1);
				isVisited[i] = false;
			}
		}
	}
}
