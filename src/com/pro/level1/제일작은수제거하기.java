package com.pro.level1;

import java.util.Arrays;

public class 제일작은수제거하기 {

	public static void main(String[] args) {
		int[] arr = { 4, 3, 2, 1 };
		System.out.println(Arrays.toString(solution(arr)));
	}

	public static int[] solution(int[] arr) {
		if(arr.length == 1)
			return new int[] {-1};
		
		int min = Arrays.stream(arr).min().getAsInt();	// 가장 작은 원소
		
		int index = 0;
		int[] answer = new int[arr.length -1];
		for (int i = 0; i < arr.length; i++) 
			if(arr[i] != min)
				answer[index++] = arr[i];

		return answer;
	}
}
