package com.pro.level2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 오픈채팅방 {

	public static void main(String[] args) {
		String[] record = { "Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo",
				"Change uid4567 Ryan" };
		System.out.println(Arrays.toString(solution(record)));
	}

	public static String[] solution(String[] record) {

		HashMap<String, String> nickName = new HashMap<String, String>(); // (아이디, 닉네임)
		Queue<String[]> chat = new LinkedList<String[]>();
		for (int i = 0; i < record.length; i++) {
			StringTokenizer st = new StringTokenizer(record[i]);
			String action = st.nextToken(); // 행동
			String id = st.nextToken(); // 아이디

			if (!action.equals("Leave"))
				nickName.put(id, st.nextToken());

			if (!action.equals("Change"))
				chat.offer(new String[] { action, id }); // 입퇴장여부, 아이디
		}

		int i = 0;
		String[] answer = new String[chat.size()];
		while (!chat.isEmpty()) {
			String[] s = chat.poll();

			if (s[0].equals("Enter"))
				answer[i++] = nickName.get(s[1]) + "님이 들어왔습니다.";
			else
				answer[i++] = nickName.get(s[1]) + "님이 나갔습니다.";
		}

		return answer;
	}
}
