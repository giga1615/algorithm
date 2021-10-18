package com.pro.level1;

public class 체육복 {

	public static void main(String[] args) {
		int n = 3;
		int[] lost = { 3 };
		int[] reserve = { 1 };

		System.out.println(solution(n, lost, reserve));
	}

	public static int solution(int n, int[] lost, int[] reserve) {
		int answer = 0;

		int clothes[] = new int[n + 1];
		for (int i = 0; i < lost.length; i++)
			clothes[lost[i]] = -1;

		for (int i = 0; i < reserve.length; i++) {
			if (clothes[reserve[i]] == -1)
				clothes[reserve[i]] = 0;
			else
				clothes[reserve[i]] = 1;
		}

		for (int i = 0; i < clothes.length; i++) {
			if (clothes[i] == -1) {
				if (i - 1 >= 1 && clothes[i - 1] == 1) {
					clothes[i] = clothes[i - 1] = 0;
					continue;
				} else if (i + 1 < clothes.length && clothes[i + 1] == 1) {
					clothes[i] = clothes[i + 1] = 0;
					continue;
				}
				answer--;
			}
		}

		return answer + n;
	}
}
