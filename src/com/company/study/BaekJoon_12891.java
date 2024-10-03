package com.company.study;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BaekJoon_12891 {

    /**
     * 9 3
     * CCTGGATTG
     * 2 0 1 1
     *
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        char[] temp = {'A', 'C', 'G', 'T'};
        String str = br.readLine();

        Map<Character, Integer> validate = new HashMap<>();
        Map<Character, Integer> countMap = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++){
             validate.put(temp[i],Integer.parseInt(st.nextToken()));
             countMap.put(temp[i],0);
        }
        int answer = 0;
        String[] arr = str.split("");
        if(isCorrect(arr, 0, P, validate,countMap)){
           answer++;
        }
        //
        // GATA
        // GA
        // AT
        // TA
//        5 P - (P - 1)
//        GATGA
//        1 0 0 1
        // GAT
        // A
        for(int j = P; j < S; j++){
            int i = j-P;
            deletePoint(countMap,arr[i]);
            plusPoint(countMap, arr[j]);

            if(check(countMap,validate)){
                answer++;
            }
        }

        System.out.println(answer);
    }

    public static boolean isCorrect(String[] arr, int start, int end,Map<Character,Integer> validate,Map<Character, Integer> countMap){
        // start 부터 end 까지
        // A 가 validate[0]
        // C 가 validate[1]
        // G 가 validate[2]
        // T 가 validate[3] 번 이상 있나 확인
        boolean res = true;
        StringBuilder builder = new StringBuilder();
        for(int i = start; i < end; i++){
            builder.append(arr[i]);
        }
        for(Map.Entry<Character,Integer> entry : validate.entrySet()){
            char s = entry.getKey();
            int count = entry.getValue();
            int c = contains(builder.toString(),s);
            countMap.put(s,c);
            if(c < count){
                res = false;
            }
        }
        return res;

    }

    public static boolean check(Map<Character,Integer> countMap, Map<Character,Integer> validateMap){
        boolean res = true;
        for(Map.Entry<Character,Integer> entry : countMap.entrySet()){
            char s = entry.getKey();
            int count = entry.getValue();
            if(validateMap.get(s) > count){
                return false;
            }
        }
        return res;
    }
    // str 안에 s 가 몇번 있나
    public static int contains(String str, char s){
        // 몇개 들어있나
        int count = 0;
        for(int i = 0; i < str.length(); i++){
            if(s == str.charAt(i)){
                count++;
            }
        }
        return count;

    }

    public static void deletePoint(Map<Character, Integer> map, String s){
        for(Map.Entry<Character,Integer> entry : map.entrySet()){
            if(s.charAt(0) == entry.getKey()){
                int value = entry.getValue();
                map.put(s.charAt(0),--value);
            }
        }
    }

    public static void plusPoint(Map<Character, Integer> map, String s){
        for(Map.Entry<Character,Integer> entry : map.entrySet()){
            if(s.charAt(0) == entry.getKey()){
                int value = entry.getValue();
                map.put(s.charAt(0),++value);
            }
        }
    }

}
