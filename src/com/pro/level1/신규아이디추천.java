package com.pro.level1;

public class 신규아이디추천 {

	public static void main(String[] args) {
		System.out.println(solution("abcdefghijklmn.p"));
	}

	public static String solution(String new_id) {

		// 1단계 : 대소문자 전환
		new_id = new_id.toLowerCase();

		// 2단계 : 소문자, 숫자, -, _, .가 아닌 문자 제거
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < new_id.length(); i++) {
			char a = new_id.charAt(i);

			if (('a' <= a && a <= 'z') || a == '-' || a == '_' || a == '.' || Character.isDigit(a))
				sb.append(a);
		}

		// 3단계 : . 2번 이상이면 하나만 사용
		for (int i = 0; i < sb.length(); i++) {
			char a = sb.charAt(i);

			if (a == '.') // 자기 뒤에오는 마침표는 모두 제거
				while (i + 1 < sb.length() && sb.charAt(i + 1) == '.')
					sb.deleteCharAt(i + 1);
		}

		// 4단계 : 맨 앞과 맨 뒤 . 제거
		if (sb.charAt(0) == '.')
			sb.deleteCharAt(0);
		if (sb.length() != 0 && sb.charAt(sb.length() - 1) == '.')
			sb.deleteCharAt(sb.length() - 1);

		// 5단계 : 빈 문자열이면, a 대입
		if (sb.length() == 0)
			sb.append('a');
		
		// 6단계 : 문자 길이는 15자까지만
		if(sb.length() >= 16) {
			sb = new StringBuilder(sb.substring(0, 15));
			
			if (sb.charAt(sb.length() - 1) == '.')	// 맨 뒤 .제거
				sb.deleteCharAt(sb.length() - 1);
		}
		
		// 7단계 : 2자이하면, 글자 길이 3자가될때까지 마지막 문자 복사
		if(sb.length() <= 2) {
			char a = sb.charAt(sb.length()-1);
			while(sb.length() < 3)
				sb.append(a);
		}

		return sb.toString();
	}
}
