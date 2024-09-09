package com.company.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon2606 {
    static List<Integer> visited = new ArrayList<>();
    static int computerCount;
    static int[][] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        computerCount = Integer.parseInt(br.readLine());
        int networkCount = Integer.parseInt(br.readLine());
        check = new int[computerCount+1][computerCount+1];
        StringTokenizer st;
        for(int i = 1 ; i <= networkCount; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            check[a][b] = check[b][a] = 1;
        }

        dfs(1);
        System.out.println(visited.size());

    }




    public static void dfs(int start){
        if(start != 1){
            visited.add(start);
        }

        for(int i = 1; i <= computerCount; i++){
            if(!visited.contains(i) && check[i][start] == 1){
                dfs(i);
            }
        }
    }
}
