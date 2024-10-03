package com.company.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BaekJoon2667 {
    static int N;
    static int[][] map;
    static boolean[][] check;
    static boolean[][] visited;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {-1,1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        check = new boolean[N][N];
        visited = new boolean[N][N];
        for(int i = 0; i < N; i++){
          String line = br.readLine();
          String[] temp = line.split("");
          for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(temp[j]);
            }
        }

        List<Integer> answer = new ArrayList<>();



        for(int i =0; i<N; i++){
            for(int j = 0; j < N; j++){
                if(!visited[i][j] && map[i][j] == 1){
                    answer.add(bfs(new Node(i,j)));
                }
            }
        }
        Collections.sort(answer);
        System.out.println(answer.size());
        for(Integer i : answer){
            System.out.println(i);
        }

    }


    public static int bfs(Node node){
        Queue<Node> q = new LinkedList();
        int cnt = 1;
        q.add(node);
        while(!q.isEmpty()){
            Node n = q.poll();
            visited[n.x][n.y] = true;
            for(int i = 0; i<4; i++){
                int newX = n.x + dx[i];
                int newY = n.y + dy[i];
                if(newX >= 0 && newY >= 0 && newX < N && newY < N){
                    if(!visited[newX][newY] && map[newX][newY]==1){
                        q.add(new Node(newX,newY));
                        cnt++;
                        visited[newX][newY] = true;

                    }
                }
            }
        }


        return cnt;


    }



    public static class Node{
        int x;
        int y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }

    }
}
