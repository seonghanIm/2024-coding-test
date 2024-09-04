package com.company.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon_1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        solution(list);
    }

    public static void solution(List<Integer> list) {
        PriorityQueue<Integer> que = new PriorityQueue();

        for(Integer n : list){
            que.add(n);
        }
        int sum = 0;
        while(que.size() != 1){
            int a = que.poll() + que.poll();
            sum += a;
            que.add(a);
        }

        System.out.println(sum);



    }
}
