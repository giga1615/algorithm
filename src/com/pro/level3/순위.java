package com.pro.level3;

public class 순위 {

	public static void main(String[] args) {
		int n = 5;
		int[][] results = { { 4, 3 }, { 4, 2 }, { 3, 2 }, { 1, 2 }, { 2, 5 } };
		System.out.println(solution(n, results));
	}

	public static int solution(int n, int[][] results) {
		int answer = 0;

		int[][] matrix = new int[n][n];
		for (int i = 0; i < results.length; i++) {
			int win = results[i][0] - 1;
			int lose = results[i][1] - 1;
			matrix[win][lose] = 1;
			matrix[lose][win] = -1;
		}

		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (i == j || matrix[i][j] != 0)
						continue;
					if (matrix[i][k] == matrix[k][j])
						matrix[i][j] = matrix[i][k];
				}
			}
		}

		for (int i = 0; i < n; i++) {
			boolean isOk = true;
			for (int j = 0; j < n && isOk; j++)
				if (i != j && matrix[i][j] == 0)
					isOk = false;

			if (isOk)
				answer++;
		}

		return answer;
	}
}
