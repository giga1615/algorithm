package com.boj.silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 백준_1427_소트인사이드 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] a = br.readLine().toCharArray();
		Arrays.sort(a);	// 오름차순 정렬

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < a.length; i++)
			sb.append(a[a.length - i - 1]);	// 뒤에서부터 하나씩 넣기

		System.out.println(sb.toString());
	}

}
