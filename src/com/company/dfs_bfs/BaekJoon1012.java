package com.company.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon1012 {
    static boolean[][] map;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int M;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //Test Case
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            // 가로
            M = Integer.parseInt(st.nextToken());
            // 세로
            N = Integer.parseInt(st.nextToken());
            // 배추의 갯수
            int K = Integer.parseInt(st.nextToken());

            map = new boolean[M][N];
            visited = new boolean[M][N];

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[x][y] = true;
            }
            int cnt = 0;
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] && !visited[i][j]) {
                        bfs(new Point(i, j));
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }


    }


    public static void bfs(Point point) {
        Queue<Point> q = new LinkedList<>();
        q.add(point);

        while (!q.isEmpty()) {
            Point p = q.poll();
            visited[p.x][p.y] = true;
            for (int i = 0; i < 4; i++) {
                int newX = p.x + dx[i];
                int newY = p.y + dy[i];
                if (newX >= 0 && newY >= 0 && newX < M && newY < N) {
                    if (!visited[newX][newY] && map[newX][newY]) {
                        q.add(new Point(newX, newY));
                        visited[newX][newY] = true;
                    }
                }

            }
        }
    }


    public static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
