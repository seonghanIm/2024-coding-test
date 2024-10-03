package com.company.study;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Programmers_가장먼노드 {

    public static void main(String[] args) {
        int n = 6;
        int[][] arr = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
        solution(n, arr);
    }


    static boolean[] visited;
    static int[] count;
    static int[][] check;
    static List<Integer>[] checkList;
    public static int solution(int n, int[][] edge) {
        int answer = 0;
        check = new int[n + 1][n + 1];
        visited = new boolean[n + 1];
        count = new int[n + 1];
        checkList = new List[n+1];
        //1
        //2
        //3 6
        //4
        //6 3
        for (int i = 0; i < edge.length; i++) {
            checkList[i] = new ArrayList<>();
        }
        for (int i = 0; i < edge.length; i++) {
            checkList[edge[i][0]].add(edge[i][1]);
            checkList[edge[i][1]].add(edge[i][0]);
        }

        Node node = new Node(1, 1);
        bfs(node, n);
        int max = 0;
        for (int i = 1; i < count.length; i++) {
            if (count[i] >= max) {
                max = count[i];
            }
        }
        for (int i = 1; i < count.length; i++) {
            if (count[i] >= max) {
                answer++;
            }
        }


        return answer;

    }

    public static void bfs(Node node, int n) {
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        visited[node.num] = true;

        while (!q.isEmpty()) {
            Node oldNode = q.poll();
            for (int i = 1; i <= n; i++) {
                if (!visited[i] && checkList[oldNode.num].contains(i)) {
                    Node newNode = new Node(i, oldNode.cnt + 1);
                    visited[i] = true;
                    count[i] = newNode.cnt;
                    q.add(newNode);
                }
            }
        }
    }

    public static class Node{
        int num;
        int cnt;
        public Node(int num, int cnt){
            this.num = num;
            this.cnt = cnt;
        }

    }

}

