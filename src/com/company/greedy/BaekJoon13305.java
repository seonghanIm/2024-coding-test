package com.company.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon13305 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] roadLength = new long[N - 1];
        for (int i = 0; i < N - 1; i++) {
            roadLength[i] = Long.valueOf(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        long[] oilPrice = new long[N];

        for (int i = 0; i < N; i++) {
            oilPrice[i] = Long.valueOf(st.nextToken());
        }

        solution(N,roadLength,oilPrice);
    }


    public static void solution(int cityCount, long[] roadLength, long[] oilPrice){
        long price = 0;
        long currentPrice = oilPrice[0];
        for(int i = 0; i < cityCount - 1; i++){
            long nextPrice = oilPrice[i+1];
            if(currentPrice >= nextPrice){
                price += currentPrice * roadLength[i];
                currentPrice = oilPrice[i + 1];
                continue;
            }else if(currentPrice < nextPrice){
                price += currentPrice * roadLength[i];
                oilPrice[i] = currentPrice;
            }

        }

        System.out.println(price);

    }
}
