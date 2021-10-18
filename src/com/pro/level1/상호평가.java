package com.pro.level1;

public class 상호평가 {

	public static void main(String[] args) {
		int[][] scores = { { 70, 49, 90 }, { 68, 50, 38 }, { 73, 31, 100 } };
		System.out.println(solution(scores));
	}

	public static String solution(int[][] scores) {

		StringBuilder sb = new StringBuilder();

		for (int c = 0; c < scores.length; c++) {
			int max = 0, min = 999999, sum = 0; // 최대값, 최소값, 총합
			boolean max_same = false, min_same = false; // 같은 숫자 중복 유무

			for (int r = 0; r < scores.length; r++) {
				sum += scores[r][c];

				if (max == scores[r][c])
					max_same = true;
				else if (max < scores[r][c]) {
					max = scores[r][c];
					max_same = false;
				}

				if (min == scores[r][c])
					min_same = true;
				else if (min > scores[r][c]) {
					min = scores[r][c];
					min_same = false;
				}
			}

			double avg = 0.0;
			if ((scores[c][c] == max && !max_same) || (scores[c][c] == min && !min_same)) {
				sum -= scores[c][c];
				avg = (double) sum / (double) (scores.length - 1);
			} else
				avg = (double) sum / (double) scores.length;

			sb.append(getScore(avg));
		}

		return sb.toString();
	}

	private static char getScore(double avg) {
		if (avg >= 90)
			return 'A';
		else if (avg >= 80)
			return 'B';
		else if (avg >= 70)
			return 'C';
		else if (avg >= 50)
			return 'D';

		return 'F';
	}
}
