package com.company.study;

import java.io.InputStreamReader;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;


public class test {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N+1];
        Map<Integer,Boolean> noNumberMap = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= N; i++){
            noNumberMap.put(i,true);
        }
        for(int i = 1; i <=N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            noNumberMap.put(arr[i],false);
        }
        for(Map.Entry<Integer,Boolean> entry : noNumberMap.entrySet()){
            if(entry.getValue()){
                q.add(entry.getKey());
            }
        }
        solution(arr,N,q);

    }
    // N = 5 /  2, 1, 5, 5, 2 , 2 = > 1 + 3 + 5
    public static void solution(int[] arr,int N,Queue<Integer> q){
            int sum = 0;
            Map<Integer, Integer> map = new HashMap();
            for(int i = 1 ; i <= N ; i++){
                // 중복으로 바꾼경우
                if(map.containsKey(arr[i])){
                    sum += map.get(arr[i]);
                    map.put(arr[i],i);
                }
                // N 보다 커서 바꾼경우
                else if(arr[i] > N){
                    sum += i;
                }else{
                    map.put(arr[i],i);

                }
            }
            System.out.println(sum);
        //5
        // 2 3 4 5 1
        // 1 + 2 + 3 + 4

        //2
        // 6 6
        // 1 + 2 = 3

        // 3
        // 3 4 5
        // 2 + 3 = 6

        // 3
        // 4 5 6
        // 1 + 2 + 3

        // 3
        // 4 4 4
        // 1 + 2 + 3

        // 4
        // 2 1 2 2
        // 1 + 3
        // 4
    }
}
