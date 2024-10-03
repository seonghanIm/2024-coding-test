package com.company.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class BaekJoon7576 {
    static int M;
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static Queue<Point> dayQueue = new LinkedList<>();
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int day = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        // 가로
        M = Integer.parseInt(st.nextToken());
        // 세로
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 일단 모든 토마토가 익지 못하는 경우를 얻어야하는데
        // 0 으로 BFS 를 돌고 고립된 경우 즉 1을 만나지 못하는 경우인데
        // 이럴 바에 그냥 1로 돌고 한바퀴 돌면서 0이 있나 찾는게 나을듯?

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    bfs(new Point(j,i));
                }
            }
        }
    }
    public static void bfs(Point point) {
        Queue<Point> q = new LinkedList<>();
        Queue<Point> dayQ = new LinkedList<>();
        visited[point.x][point.y] = true;
        q.add(point);
        dayQ.add(point);
        while (!q.isEmpty()) {
            Point p = q.poll();
            for (int i = 0; i < 4; i++) {
                int newX = p.x + dx[i];
                int newY = p.y + dy[i];
                if (newX >= 0 && newY >= 0 && newX < N && newY < M) {
                    if(!visited[newX][newY] && map[newX][newY] != -1){
                        q.add(point);
//                        dayQ.add(point);
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
