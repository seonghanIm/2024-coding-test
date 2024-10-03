package com.company.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Knapsack {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 최대 value 의 보물 훔치기
            // S = 최대 무게  N = 라인
            //   무게 , 밸류
            //    최대 4  , 최대 밸류?
            //
            // int[무게][밸류] dp = new int[][];
            /**
             *          value
             * weight    0   1  2  3  4  5
             *  0        0   1  2  3  4  5
             *  1        0   1  2  3  4  5
             *  2        0   2  1
             *  3
             *  4
             *  5
             */
        }

    }
}
