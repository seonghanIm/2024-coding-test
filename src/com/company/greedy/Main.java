package com.company.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
//    	BaekJoon baekJoon = new BaekJoon();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int person = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		List<Integer> list = new ArrayList<>();
		for(int i = 0 ; i < person; i++){
			list.add(Integer.parseInt(st.nextToken()));
		}
		System.out.println(ATM_11399(person,list));
    }

	public static int ATM_11399(int person, List<Integer> list) {
		int answer = 0;
		int sum = 0;
		Collections.sort(list);
		for (int i = 0; i < person; i++) {
			answer = answer + sum + list.get(i);
			sum += list.get(i);
		}
		return answer;
	}
}
