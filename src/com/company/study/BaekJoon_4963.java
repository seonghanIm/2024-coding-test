package com.company.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BaekJoon_4963 {
    static int w;
    static int h;
    static boolean[][] board;
    static boolean[][] visited;
    static int dx[] = {0, 0, 1, -1, 1, -1, -1, 1};
    static int dy[] = {1, -1, 0, 0, 1, 1, -1, -1};

    public static void main(String[] args) throws IOException {
        List<Integer> answerList = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if (w == 0 && h == 0) {
                break;
            }
            board = new boolean[h][w];
            visited = new boolean[h][w];
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    if (Integer.parseInt(st.nextToken()) == 1) {
                        board[i][j] = true;
                    }
                }
            }
            int count = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (!visited[i][j] && board[i][j]) {
                        dfs(i, j);
                        count++;
                    }
                }
            }
            answerList.add(count);
        }

        for(Integer i : answerList){
            System.out.println(i);
        }
    }

    public static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 8; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            if (newX >= 0 && newY >= 0 && newX < h && newY < w) {
                if (!visited[newX][newY] && board[newX][newY]) {
                    visited[newX][newY] = true;
                    dfs(newX, newY);
                }
            }
        }
    }
}
