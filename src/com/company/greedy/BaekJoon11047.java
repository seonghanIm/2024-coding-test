package com.company.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BaekJoon11047 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < n ; i++){
            list.add(Integer.parseInt(br.readLine()));
        }

        solution(n,k,list);
    }

    public static void solution(int n, int k, List<Integer> valueList) {
        Collections.sort(valueList, Collections.reverseOrder());
        int count = 0;
        for (Integer value : valueList) {
            while (true) {
                k -= value;
                if (k < 0) {
                    k += value;
                    break;
                } else if (k == 0) {
                    count++;
                    System.out.println(count);
                } else {
                    count++;
                }
            }
        }
    }
}
