package com.company.greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BaekJoon {
    public int ATM_11399(int personNum, List<Integer> list) {
        int answer = 0;
        int sum = 0;
        Collections.sort(list);
        for (int i = 0; i < personNum; i++) {
            answer = answer + sum + list.get(i);
            sum += list.get(i);
        }
        return answer;
    }
}
