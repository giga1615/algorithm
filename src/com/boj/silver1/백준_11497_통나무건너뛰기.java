package com.boj.silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class 백준_11497_통나무건너뛰기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			Integer[] bridge = new Integer[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) 
				bridge[j] = Integer.parseInt(st.nextToken());
			
			// 통나무 높이순으로 정렬
			Arrays.sort(bridge, Collections.reverseOrder());
			
			// 크기가 비슷한 것 끼리 붙여놔야함 : 크기순 => 7 5 3 (1) 2 4 6
			int A = bridge[1];	// 2번째로 큰 수
			int B = bridge[2];	// 3번째로 큰 수
			int level = bridge[0] - B;	// 난이도 : 초기값 = 가장 큰 수 -  3번째로 큰 수
			for (int j = 3; j < bridge.length; j=j+2) {
				level = Math.max(level, A - bridge[j]);
				A = bridge[j];
				
				if(j+1 < bridge.length) {
					level = Math.max(level, B - bridge[j+1]);
					B = bridge[j+1];
				}
			}
			System.out.println(level);
		}
	}

}
