package com.company.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 5 3
 * 5 4 3 2 1
 * 1 3
 * 2 4
 * 5 5
 */

public class BaekJoon_11659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 숫자 갯수
        int N = Integer.parseInt(st.nextToken());
        // 합을 구해야하는 횟수
        int M = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i< N;i++){
            if(i == 0) {
                list.add(Integer.parseInt(st.nextToken()));
                continue;
            }

            list.add(list.get(i-1) + Integer.parseInt(st.nextToken()));
        }
        // {5,9,12,14,15}
        // start end
        // 2      4
        // [4] - [2 - 1]
        // end - [start - 1]
        // 1     3
        // 12 - [1 - 1]
        // [5] - [5-1]
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            int sum = 0;
            if(start == 0){
                sum = list.get(end);
            }else {
                sum = list.get(end) - list.get(start - 1);
            }
            System.out.println(sum);
        }
    }
}
