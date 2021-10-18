package com.pro.level1;

import java.util.ArrayList;
import java.util.Arrays;

public class 서울에서김서방찾기 {

	public static void main(String[] args) {
		String[] seoul = { "Jane", "Kim" };
		System.out.println(solution(seoul));
	}

	public static String solution(String[] seoul) {
		ArrayList<String> s = new ArrayList<String>(Arrays.asList(seoul));
		
		StringBuilder sb = new StringBuilder("김서방은 ");
		sb.append(s.indexOf("Kim"));
		sb.append("에 있다");
		return sb.toString();
	}
}
