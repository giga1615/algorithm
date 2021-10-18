package com.pro.level1;

import java.util.ArrayList;
import java.util.Arrays;

public class 자연수뒤집어배열로만들기 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(12345)));
	}

	public static int[] solution(long n) {
		ArrayList<Integer> num = new ArrayList<Integer>();
		while (n > 0) {
			num.add((int) (n % 10));
			n /= 10;
		}

		return num.stream().mapToInt(i -> i).toArray();
	}
}
