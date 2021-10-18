package com.pro.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 기능개발 {

	public static void main(String[] args) {
		int[] progresses = { 93, 30, 55 };
		int[] speeds = { 1, 30, 5 };
		System.out.println(Arrays.toString(solution(progresses, speeds)));
	}

	public static int[] solution(int[] progresses, int[] speeds) {
		ArrayList<Integer> answer = new ArrayList<Integer>();
		Queue<Integer> task = new LinkedList<Integer>();

		for (int i = 0; i < speeds.length; i++) {
			double day = Math.ceil((100.0 - progresses[i]) / speeds[i]);
			if (!task.isEmpty() && day > task.peek()) {
				answer.add(task.size());
				task.clear();
			}
			task.offer((int) day);
		}

		if (!task.isEmpty())
			answer.add(task.size());

		return answer.stream().mapToInt(i -> i).toArray();
	}
}
