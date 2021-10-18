package com.boj.silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_1541_잃어버린괄호 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), "-");	// - 기준으로 문자열 분리
	
		Queue<Integer> queue = new LinkedList<Integer>();
		while(st.hasMoreTokens()) {
			StringTokenizer s = new StringTokenizer(st.nextToken(), "+");
			
			int sum = 0;
			while(s.hasMoreTokens()) 
				sum += Integer.parseInt(s.nextToken());
			queue.offer(sum);
		}
		
		int ans = queue.poll();
		while(!queue.isEmpty())
			ans -= queue.poll();
		
		System.out.println(ans);
	}

}
