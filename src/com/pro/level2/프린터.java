package com.pro.level2;

import java.util.Comparator;
import java.util.PriorityQueue;

public class 프린터 {

	public static void main(String[] args) {
		int[] priorities = { 2, 1, 3, 2 };
		int location = 2;
		System.out.println(solution(priorities, location));
	}

	public static int solution(int[] priorities, int location) {
		int answer = 1;
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(Comparator.reverseOrder());
		for (int n : priorities)
			queue.offer(n);

		while (!queue.isEmpty()) {
			for (int i = 0; i < priorities.length; i++) {
				if (queue.peek() == priorities[i]) {
					if (location == i)
						return answer;
					answer++;
					queue.poll();
				}
			}
		}

		return answer;
	}
}
