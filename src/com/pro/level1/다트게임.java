package com.pro.level1;

import java.util.HashMap;
import java.util.Stack;

public class 다트게임 {

	public static void main(String[] args) {
		System.out.println(solution("1D2S#10S"));
	}

	public static int solution(String dartResult) {
		int answer = 0;
		HashMap<Character, Integer> score = new HashMap<Character, Integer>();
		score.put('S', 1);
		score.put('D', 2);
		score.put('T', 3);

		Stack<Integer> num = new Stack<Integer>();
		for (int i = 0; i < dartResult.length(); i++) {
			StringBuilder sb = new StringBuilder();
			while(Character.isDigit(dartResult.charAt(i)))
					sb.append(dartResult.charAt(i++));
			int n = Integer.parseInt(sb.toString());	// 숫자
			
			n = (int) Math.pow(n, score.get(dartResult.charAt(i)));	// n제곱

			// 마지막에 옵션 없는 경우 =>  종료
			if (i + 1 >= dartResult.length()) {	
				num.add(n);
				continue;
			}

			// 옵션 처리
			char option = dartResult.charAt(i + 1);
			if (!Character.isDigit(option)) {
				if (option == '*') {
					if (!num.isEmpty())
						num.add(num.pop() * 2);
					num.add(n * 2);
				} else
					num.add(-n);
				i++;
			} else
				num.add(n);
		}

		while (!num.isEmpty())
			answer += num.pop();

		return answer;
	}
}
