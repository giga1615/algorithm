package com.pro.level1;

import java.util.StringTokenizer;

public class 직업군추천하기 {

	public static void main(String[] args) {
		String[] table = { "SI JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++",
				"HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP",
				"GAME C++ C# JAVASCRIPT C JAVA" };
		String[] languages = { "PYTHON", "C++", "SQL" };
		int[] preference = { 7, 5, 5 };
		System.out.println(solution(table, languages, preference));
	}

	public static String solution(String[] table, String[] languages, int[] preference) {

		int max = 0, max_num = 0;
		int[] scores = new int[table.length];
		for (int i = 0; i < languages.length; i++) {
			for (int j = 0; j < table.length; j++) {
				StringTokenizer st = new StringTokenizer(table[j]);
				st.nextToken();
				for (int k = 5; k >= 1; k--) {
					if (languages[i].compareTo(st.nextToken()) == 0) {
						scores[j] += preference[i] * k;
						if (max < scores[j]) {
							max = scores[j];
							max_num = j;
						} else if (max == scores[j]) {
							if (table[j].charAt(0) < table[max_num].charAt(0))
								max_num = j;
						}
						break;
					}
				}
			}
		}

		StringTokenizer st = new StringTokenizer(table[max_num]);

		return st.nextToken();
	}

}
