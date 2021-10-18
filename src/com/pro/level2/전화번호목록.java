package com.pro.level2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 전화번호목록 {

	public static void main(String[] args) {
		String[] phone_book = { "119", "97674223", "1195524421" };
		System.out.println(solution(phone_book));
	}

	public static boolean solution(String[] phone_book) {
		Set<String> num = new HashSet<>();
		num.addAll(Arrays.asList(phone_book));

		for (String phone : phone_book) {
			for (int i = 1; i < phone.length(); i++)
				if (num.contains(phone.substring(0, i)))
					return false;
		}

		return true;
	}
}
