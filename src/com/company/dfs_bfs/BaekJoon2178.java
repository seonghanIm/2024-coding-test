package com.company.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BaekJoon2178 {
    private static int[] dx = {0, 0, -1, 1}; // 상하좌우
    private static int[] dy = {1, -1, 0, 0};
    private static boolean[][] visited;
    private static int N = 0;
    private static int M = 0;
    private static int[][] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            String[] tempArr = temp.split("");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(tempArr[j]);
            }
        }
        visited = new boolean[N][M];

        solutiion(0, 0);

        System.out.println(arr[N - 1][M - 1]);

    }


    public static void solutiion(int x, int y) {
        Queue<int[]> queue = new LinkedList();
        queue.add(new int[]{x, y});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentX = current[0];
            int currentY = current[1];

            for (int i = 0; i < 4; i++) {
                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) {
                    continue;
                }
                if (visited[nextX][nextY] || arr[nextX][nextY] == 0) {
                    continue;
                }

                queue.add(new int[]{nextX, nextY});
                arr[nextX][nextY] = arr[currentX][currentY] + 1;
                visited[nextX][nextY] = true;


            }


        }
    }
}
