package com.pro.level2;

import java.util.HashSet;
import java.util.Set;

public class 소수찾기 {

	public static void main(String[] args) {
		System.out.println(solution("17"));
	}

	static boolean isUsed[];
	static Set<Integer> prime;

	public static int solution(String numbers) {
		prime = new HashSet<Integer>();
		isUsed = new boolean[numbers.length()];
		for (int i = 1; i <= numbers.length(); i++)
			comb(i, "", numbers);

		return prime.size();
	}

	static void comb(int N, String num, String numbers) {
		if (num.length() == N) {
			int n = Integer.parseInt(num);
			if (n > 1 && isPrime(n))
				prime.add(n);
		}

		for (int i = 0; i < numbers.length(); i++) {
			if (!isUsed[i]) {
				isUsed[i] = true;
				comb(N, num + numbers.charAt(i), numbers);
				isUsed[i] = false;
			}
		}
	}

	static boolean isPrime(int n) {
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}
}
