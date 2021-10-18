package com.pro.level2;

public class 문자열압축 {

	public static void main(String[] args) {
		System.out.println(solution("a"));
	}

	public static int solution(String s) {
		int answer = Integer.MAX_VALUE;

		int len = s.length();

		if (len == 1) return 1;

		for (int size = 1; size <= len / 2; size++) {
			int i = 0; // index 번호
			int sum = len;

			for (; i + size <= len;) {
				String str = s.substring(i, i + size);
				i += size;

				int cnt = 0;
				for (; i + size <= len;) {
					String new_str = s.substring(i, i + size);
					if (str.equals(new_str)) {
						cnt++;
						i += size;
					} else
						break;
				}

				String s_cnt = (cnt + 1) + ""; // 개수는 자기자신 포함
				if (cnt > 0)
					sum = sum - cnt * size + s_cnt.length();
			}
			answer = Math.min(answer, sum);
		}

		return answer;
	}
}
