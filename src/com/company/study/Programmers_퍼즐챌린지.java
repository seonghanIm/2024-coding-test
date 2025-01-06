package com.company.study;

import java.util.Arrays;

public class Programmers_퍼즐챌린지 {
    public static void main(String[] args){

    }

    // 1,5,3 => diffs
    // 2,4,7 => times
    // 30    => limit
    // 3     => result
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        int maxDiff = Arrays.stream(diffs).max().getAsInt();

        int[] levelArr = new int[maxDiff];

        int start = 0;
        int mid = maxDiff/2;
        int end = maxDiff;
//        while(true){
//            if(getTime(diffs,times,limit,start)){
//
//            }
//        }

        return answer;
    }

    // 레벨 1 일때 해결 가능한지?
    public static boolean getTime(int[] diffs, int[] times, long limit, int currentLevel){
        long tempLimit = limit;
        for(int i = 0; i < diffs.length; i++){
            if(diffs[i] <= currentLevel){
                tempLimit -= times[i];
            }else{
                tempLimit = tempLimit - ((times[i-1] + times[i]) * (diffs[i] - currentLevel) + times[i]);
            }
        }

        if(tempLimit >= 0){
            return true;
        }
        return false;
    }
    // 레벨보다 난이도가 낮거나 같으면 걍 해결
    //  레벨보다 난이도가 높으면 diff - level 번 틀림
    //
    // diff  times  limit = 30
    //  1      2      30
    //  5      4
    //  3      7

    // level 1일때 해결가능?
    // level 2일때 해결가능?
    // level 3일때 해결가능?
    // 이걸 이진 탐색으로 하면되는거지?


}
