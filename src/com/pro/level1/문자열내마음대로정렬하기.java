package com.pro.level1;

import java.util.Arrays;
import java.util.Comparator;

public class 문자열내마음대로정렬하기 {

	public static void main(String[] args) {
		String[] strings = { "abce", "abcd", "cdx" };
		int n = 2;
		System.out.println(Arrays.toString(solution(strings, n)));
	}

	public static String[] solution(String[] strings, int n) {

		String[][] str = new String[strings.length][2];
		for (int i = 0; i < strings.length; i++) {
			str[i][0] = strings[i].charAt(n) + "";
			str[i][1] = strings[i];
		}

		Arrays.sort(str, new Comparator<String[]>() {
			@Override
			public int compare(String[] o1, String[] o2) {
				if (o1[0].equals(o2[0]))
					return o1[1].compareTo(o2[1]);
				return o1[0].compareTo(o2[0]);
			}
		});

		String[] answer = new String[strings.length];
		for (int i = 0; i < answer.length; i++)
			answer[i] = str[i][1];

		return answer;
	}
}
