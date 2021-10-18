package com.boj.silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 백준_2607_비슷한단어 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		// 첫 번째 단어
		Map<Character, Integer> origin = new HashMap<Character, Integer>();
		char o[] = br.readLine().toCharArray();
		for (int i = 0; i < o.length; i++) { // 각 알파벳이 몇 번 나오는지 숫자 세기
			int n = origin.containsKey(o[i]) ? origin.get(o[i]) + 1 : 1;
			origin.put(o[i], n);
		}

		int result = 0;
		for (int i = 0; i < N - 1; i++) {
			char a[] = br.readLine().toCharArray();

			// 단어 길이 차이가 1개 이내가 아니면 패스
			int gap = Math.abs(a.length - o.length);
			if (gap > 1)
				continue;

			// 해당 단어의 알파벳 숫자 세기
			Map<Character, Integer> nWord = new HashMap<Character, Integer>();
			for (int j = 0; j < a.length; j++) { // 각 알파벳이 몇 번 나오는지 숫자 세기
				int n = nWord.containsKey(a[j]) ? nWord.get(a[j]) + 1 : 1;
				nWord.put(a[j], n);
			}

			int sub = 0; // 없는 단어 수
			for (Character key : origin.keySet()) {
				if (nWord.containsKey(key)) // 있는 단어면,
					nWord.put(key, nWord.get(key) - origin.get(key));
				else {
					nWord.put(key, -origin.get(key));
					sub++;
				}
			}

			int diff = 0;
			int zero = 0;
			boolean flag = false;
			for (Character k : nWord.keySet()) {
				diff += nWord.get(k);
				if (!origin.containsKey(k)) sub++;	// orgin에 없는 알파벳을 갖고있는가
				if (nWord.get(k) != 0) zero++;	// 숫자가 같지 않은 알파벳 숫자 세기
				if(Math.abs(nWord.get(k)) >= 2) {
					flag = true;	// 알파벳 개수 차이가 2를 넘어가면 안됨
					break;
				}
			}
			
			// 길이가 차이나는데, 다른 알파벳차이가 1 넘게 나면 안됨
			// TEST & TST(O), ABCDEFGH & DFDCDHEAG(X)
			if(zero + gap >2 || flag) continue;

			// 알파벳 수 차이가 1개이면, 없는 알파벳 종류 차이도 1개 이하여야됨
			if (diff == 0 || (Math.abs(diff) == 1 && sub <= 1)) {
				result++;
			}
		}

		System.out.println(result);
	}

}
