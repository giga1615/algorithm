package com.pro.level1;

import java.util.ArrayList;
import java.util.Arrays;

public class 나누어떨어지는숫자배열 {

	public static void main(String[] args) {
		int[] arr= { 5, 9, 7, 10};
		int divisor = 5;
		System.out.println(Arrays.toString(solution(arr, divisor)));
	}
	public static int[] solution(int[] arr, int divisor) {
        
		ArrayList<Integer> num = new ArrayList<Integer>();
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] % divisor == 0)
				num.add(arr[i]);
		}
		
		int[] answer = new int[num.size()];
		for (int i = 0; i < answer.length; i++) 
			answer[i] = num.get(i);
		
		Arrays.sort(answer);
		
		return answer.length == 0 ? new int[] { -1 } : answer;
	}
}
