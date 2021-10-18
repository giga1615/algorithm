package com.pro.level1;

import java.util.HashMap;

public class 완주하지못한선수 {

	public static void main(String[] args) {
		String[] participant = { "mislav", "stanko", "mislav", "ana" };
		String[] completion = { "stanko", "ana", "mislav" };
		System.out.println(solution(participant, completion));
	}

	public static String solution(String[] participant, String[] completion) {
		String answer = "";

		// 이름별 출전한 사람 수
		HashMap<String, Integer> people = new HashMap<String, Integer>();
		for (int i = 0; i < participant.length; i++) {
			if (people.containsKey(participant[i]))
				people.put(participant[i], people.get(participant[i]) + 1);
			else
				people.put(participant[i], 1);
		}

		for (int i = 0; i < completion.length; i++)
			people.put(completion[i], people.get(completion[i]) - 1);

		for (String person : people.keySet()) {
			if (people.get(person) != 0) {
				answer = person;
				break;
			}
		}

		return answer;
	}
}
