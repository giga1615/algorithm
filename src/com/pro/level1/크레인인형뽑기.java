package com.pro.level1;

import java.util.Stack;

public class 크레인인형뽑기 {

	public static void main(String[] args) {
		int[][] board = { { 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 3 }, { 0, 2, 5, 0, 1 }, { 4, 2, 4, 4, 2 },
				{ 3, 5, 1, 3, 1 } };
		int[] moves = { 1, 5, 3, 5, 1, 2, 1, 4 };
		System.out.println(solution(board, moves));
	}

	public static int solution(int[][] board, int[] moves) {
		int answer = 0;

		Stack<Integer> stack = new Stack<Integer>();

		for (int i = 0; i < moves.length; i++) {
			int n = moves[i] - 1; // 인형 꺼낼 칸

			for (int j = 0; j < board.length; j++) {
				if (board[j][n] != 0) {
					if (!stack.isEmpty() && stack.peek() == board[j][n]) {
						answer += 2;
						stack.pop();
					} else {
						stack.add(board[j][n]);
					}
					
					board[j][n] = 0;
					break;
				}
			}
		}

		return answer;
	}

}
