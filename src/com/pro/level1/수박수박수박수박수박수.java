package com.pro.level1;

public class 수박수박수박수박수박수 {

	public static void main(String[] args) {
		System.out.println(solution(4));
	}

	public static String solution(int n) {
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++)
			sb.append(i % 2 == 0 ? "수" : "박");

		return sb.toString();
	}
}
