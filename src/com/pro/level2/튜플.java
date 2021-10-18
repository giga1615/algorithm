package com.pro.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class 튜플 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution("{{2},{2,1},{2,1,3},{2,1,3,4}}")));
	}

	public static int[] solution(String s) {
		// 숫자만 자르기
		StringTokenizer st = new StringTokenizer(s, "},{");

		// 숫자가 나온 횟수 세기
		HashMap<Integer, Integer> num = new HashMap<Integer, Integer>();
		while (st.hasMoreTokens()) {
			int n = Integer.parseInt(st.nextToken());
			num.put(n, num.containsKey(n) ? num.get(n) + 1 : 1);
		}

		// 횟수기준 내림차순 정렬
		List<Integer> keySet = new ArrayList<Integer>(num.keySet());
		Collections.sort(keySet, (v1, v2) -> (num.get(v2) - num.get(v1)));

		int[] answer = new int[keySet.size()];
		for (int i = 0; i < keySet.size(); i++)
			answer[i] = keySet.get(i);

		return answer;
	}
}
