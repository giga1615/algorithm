package com.boj.silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준_1026_보물 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int A[] = new int[N];
		int B[] = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
			B[i] = Integer.parseInt(st2.nextToken());
		}

		// 오름차순 정렬
		Arrays.sort(A);
		Arrays.sort(B);

		int result = 0;
		for (int i = 0; i < N; i++) 
			result += A[i] * B[N - i - 1];	// A작은것 * B큰것
		
		System.out.println(result);
	}

}
