package com.company.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BaekJoon1260 {
    private static int N;
    private static boolean check[][];
    private static Set<Integer> visited = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 정점 갯수
        N = Integer.parseInt(st.nextToken());
        // 간선 수
        int M = Integer.parseInt(st.nextToken());
        // 시작 번호
        int V = Integer.parseInt(st.nextToken());

        check = new boolean[N + 1][N + 1];
        boolean[][] v2 = new boolean[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            check[a][b] = check[b][a] = true;
        }

        dfs(V);
        System.out.println();
        visited = new HashSet<>();
        bfs(V);
    }


    public static void dfs(int start) {
        visited.add(start);
        System.out.print(start + " ");

        for (int i = 1; i <= N; i++) {
            if (!visited.contains(i) && check[start][i]) {
                dfs(i);
            }
        }
    }

    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();

        q.add(start);
        visited.add(start);

        while(!q.isEmpty()){
            int node = q.poll();
            System.out.print(node + " ");
            for(int i = 1; i<=N ; i++){
                if(!visited.contains(i) && check[node][i]){
                    q.add(i);
                    visited.add(i);
                }
            }
        }
    }


}
