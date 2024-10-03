package com.company.study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class leetCode_322 {
    public static void main(String[] args){
        int coins[] = {186,419,83,408};
        int amount =  6249;

        System.out.println(coinChange(coins,amount));
    }
    public static int coinChange(int[] coins, int amount) {
        // 그리디
        // 역순 정렬
        // 반복문
        // amount - coin[i]
        Arrays.sort(coins);
        int cnt = 0;

        if(amount == 0){
            return 0;
        }
        for (int i = coins.length -1 ; i >= 0; i--){
            cnt += amount / coins[i];
            amount = amount % coins[i];

        }

        if(amount != 0){
            cnt = -1;
        }
        return cnt;
    }
}
