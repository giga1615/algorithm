package com.boj.silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 백준_11502_세개의소수문제 {
	static boolean Eratos[], flag;
	static int K, numbers[];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		// 소수 만들기
		Eratos = new boolean[1000];
		Arrays.fill(Eratos, true);
		for (int i = 2; i * i < 1000; i++) {
			if (Eratos[i])
				for (int j = i * i; j < 1000; j = j + i)
					Eratos[j] = false;
		}

		for (int testCase = 1; testCase <= T; testCase++) {
			K = Integer.parseInt(br.readLine());
			flag = false;
			numbers = new int[3];
			perm(0, 0);
			
			// flag가 false면 안 되는 것
			if(!flag) System.out.println(0);
			else 
				for (int i = 0; i < 3; i++)
					System.out.print(numbers[i] + " ");
		}
	}

	// 중복 순열
	private static void perm(int cnt, int sum) {
		if(cnt == 3 ) {	// 3개 다 뽑았을때
			if(sum == K)	// 합이 K라면 찾은 것
				flag = true;
			return;
		}
		for (int i = 2; i < 1000 && !flag; i++) {
			if(Eratos[i] && sum +i <= K) {
				numbers[cnt] = i;
				perm(cnt+1, sum + i);
			}
		}
	}

}
