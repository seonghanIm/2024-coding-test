package com.company.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon1946 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            List<Score> scoreList = new ArrayList<>();
            StringTokenizer st;
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                Score score = new Score(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
                scoreList.add(score);
            }
            solution(scoreList);
        }
    }

    //
    public static void solution(List<Score> scoreList) {
        Collections.sort(scoreList);
        //자기 위에꺼만 보면 되네
        int answer = 1;
        Score prevScore = scoreList.get(0);
        for (int i = 1; i < scoreList.size(); i++) {
            if(prevScore.b > scoreList.get(i).b){
                answer++;
                prevScore = scoreList.get(i);
            }


        }

        System.out.println(answer);
    }

    public static class Score implements Comparable<Score> {
        private int a;
        private int b;

        public Score(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public String toString() {
            return "";
        }

        @Override
        public int compareTo(Score o) {
            return Integer.compare(this.a, o.a);
        }
    }

}


