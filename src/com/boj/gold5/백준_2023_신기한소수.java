package com.boj.gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준_2023_신기한소수 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int prime[] = { 2, 3, 5, 7 };
		
		// 첫 번째 숫자는 소수 & 홀수인 2, 3, 5, 7 중 하나
		for (int i = 0; i < 4; i++) 
			recursive(prime[i], N - 1);
	}

	private static void recursive(int first, int n) {
		if (n == 0) 
			System.out.println(first);
		
		for (int i = 1; i < 10; i = i + 2) {
			int num = first * 10 + i;
			if(isPrime(num)) {
				recursive(num, n-1);
			}
		}
	}

	// 소수인지 확인
	private static boolean isPrime(int num) {
		if(num < 2) return false;
		for (int i = 2; i * i <= num; i++) 
			if(num % i == 0) return false;
		
		return true;
	}

}
