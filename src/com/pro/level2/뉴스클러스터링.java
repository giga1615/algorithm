package com.pro.level2;

import java.util.HashMap;

public class 뉴스클러스터링 {

	public static void main(String[] args) {
		System.out.println(solution("E=M*C^2", "e=m*c^2"));
	}

	static HashMap<String, Integer> jacard1, jacard2;

	public static int solution(String str1, String str2) {
		int min = 0, max = 0;

		jacard1 = new HashMap<String, Integer>();
		jacard2 = new HashMap<String, Integer>();

		str1 = str1.toLowerCase();
		str2 = str2.toLowerCase();

		// str1 : 두개씩 자르기
		for (int i = 0; i < str1.length() - 1; i++) {
			if (!Character.isAlphabetic(str1.charAt(i)) || !Character.isAlphabetic(str1.charAt(i + 1)))
				continue;

			String str = str1.substring(i, i + 2);
			jacard1.put(str, jacard1.containsKey(str) ? jacard1.get(str) + 1 : 1);
		}

		// str2 : 두개씩 자르기
		for (int i = 0; i < str2.length() - 1; i++) {
			if (!Character.isAlphabetic(str2.charAt(i)) || !Character.isAlphabetic(str2.charAt(i + 1)))
				continue;

			String str = str2.substring(i, i + 2);
			jacard2.put(str, jacard2.containsKey(str) ? jacard2.get(str) + 1 : 1);
			max++;

			if (jacard1.containsKey(str) && jacard1.get(str) > 0) {
				jacard1.put(str, jacard1.get(str) - 1);
				min++;
			}
		}

		// str1에서 살아남은 수 max에 추가
		for (String s : jacard1.keySet())
			if (jacard1.get(s) > 0)
				max += jacard1.get(s);

		return max == 0 ? 65536 : 65536 * min / max;
	}
}
