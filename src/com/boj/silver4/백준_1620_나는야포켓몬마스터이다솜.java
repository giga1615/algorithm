package com.boj.silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 백준_1620_나는야포켓몬마스터이다솜 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		// 포켓몬 목록 입력 받기
		HashMap<String, Integer> poketmon = new HashMap<String, Integer>();
		String p_List[] = new String[N + 1];
		for (int i = 1; i <= N; i++) {
			String s = br.readLine();
			poketmon.put(s, i); // 이름으로 검색
			p_List[i] = s; // 번호로 검색
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			String s = br.readLine();
			char c = s.charAt(0);
			if (!Character.isDigit(c))
				sb.append(poketmon.get(s) + "\n");
			else {
				sb.append(p_List[Integer.parseInt(s)] + "\n");
			}
		}
		System.out.println(sb);
	}

}
