package com.pro.level2;

import java.util.*;

public class 위장 {

	public static void main(String[] args) {
		String[][] clothes = { { "yellowhat", "headgear" }, { "bluesunglasses", "eyewear" },
				{ "green_turban", "headgear" } };
		System.out.println(solution(clothes));
	}

	public static int solution(String[][] clothes) {
		HashMap<String, Integer> dress = new HashMap<>();
		for (String[] c : clothes)
			dress.put(c[1], dress.containsKey(c[1]) ? dress.get(c[1]) + 1 : 1);

		int answer = 1;
		for (Integer num : dress.values())
			answer *= num + 1;

		return answer - 1;
	}
}
