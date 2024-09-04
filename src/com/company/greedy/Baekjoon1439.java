package com.company.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon1439 {

    public static void main(String[] args) throws IOException {
        List<String> setZero = new ArrayList<>();
        List<String> setOne = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        char prev = '3';
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0' && prev != s.charAt(i)) {
                setZero.add("0");
                prev = '0';
            } else if (s.charAt(i) == '1' && prev != s.charAt(i)) {
                setOne.add("1");
                prev = '1';
            }
        }
        int answer = Math.min(setZero.size(), setOne.size());
        System.out.println(answer);

    }
}