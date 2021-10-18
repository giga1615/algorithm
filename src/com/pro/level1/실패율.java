package com.pro.level1;

import java.util.Arrays;

public class 실패율 {

	public static void main(String[] args) {
		int N = 5;
		int[] stages = { 2, 1, 2, 6, 2, 4, 3, 3 };
		System.out.println(Arrays.toString(solution(N, stages)));
	}

	public static int[] solution(int N, int[] stages) {
		int[] answer = new int[N];

		double player[][] = new double[N][2];
		for (int i = 0; i < N; i++)
			player[i][0] = i + 1; // 스테이지 번호

		int people = stages.length; // 총 플레이어 수
		for (int i = 0; i < people; i++) {
			if (stages[i] <= N)
				player[stages[i] - 1][1]++; // 머물러있는 사람 수 증가
		}

		int low_stage = 0; // 아직 도달하지 못한 사람 수
		for (int i = 0; i < N; i++) {
			double temp = player[i][1];
			player[i][1] = player[i][1] / (people - low_stage); // 실패율
			low_stage += temp;
			if (low_stage == people)
				break;
		}

		Arrays.sort(player, (o1, o2) -> {
			if (o1[1] == o2[1])
				return Double.compare(o1[0], o2[0]); // 실패율 같으면 번호 오름차순
			return -Double.compare(o1[1], o2[1]); // 실패율 내림차순
		});

		for (int i = 0; i < N; i++)
			answer[i] = (int) player[i][0];

		return answer;
	}
}
