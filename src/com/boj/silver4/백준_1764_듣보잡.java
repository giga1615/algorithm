package com.boj.silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class 백준_1764_듣보잡 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		// 듣도 못한 명단
		HashMap<String, Boolean> people = new HashMap();
		for (int i = 0; i < N; i++)
			people.put(br.readLine(), false);

		// 오름차순 정렬
		TreeMap<String, Boolean> tm = new TreeMap<String, Boolean>(people);
		Set<String> keyset = people.keySet();
		Iterator<String> keyiterator = tm.keySet().iterator();

		// 보도 못한 사람에도 속하면 true
		for (int i = 0; i < M; i++) {
			String person = br.readLine();
			if (tm.containsKey(person))
				tm.put(person, true);
		}

		int num = 0;
		StringBuilder sb = new StringBuilder();
		for (String key : tm.keySet()) {
			if (tm.get(key) == true) {
				num++;
				sb.append(key + "\n");
			}
		}
		
		System.out.println(num);
		System.out.println(sb.toString());
	}

}
