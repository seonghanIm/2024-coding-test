package com.company.test3;

import java.util.HashMap;
import java.util.Map;

public class Problem3 {
    public static void main(String[] args) {
        // 고객 수 (0시 ~ 23시)
        int[] customersPerHour = {100, 120, 150};

        // 모델들이 한 시간에 처리할 수 있는 고객 수
        int[] modelCapacity = {40, 60};

        // 모델 비용
        int[] modelCost = {100, 150};

        // 고객 상담을 처리하는 최소 비용 구하기
        int totalMinCost = calculateMinCost(customersPerHour, modelCapacity, modelCost);

        // 결과 출력
        System.out.println("최소 비용: " + totalMinCost);
    }

    // 최소 비용을 계산하는 함수
    public static int calculateMinCost(int[] customersPerHour, int[] modelCapacity, int[] modelCost) {
        int n = customersPerHour.length; // 24시간
        int m = modelCapacity.length;    // 모델의 개수
        int totalCost = 0;

        // 각 시간대별로 고객을 처리하기 위한 최소 비용 계산
        for (int i = 0; i < n; i++) {
            int customers = customersPerHour[i];
            int minCost = Integer.MAX_VALUE;

            // 가능한 모델들 중 비용 대비 처리 효율이 가장 좋은 모델을 찾아야 함
            for (int j = 0; j < m; j++) {
                int capacity = modelCapacity[j];
                int cost = modelCost[j];

                // 1명당 처리 비용 계산
                double costPerCustomer = (double) cost / capacity;

                // 필요한 모델 수를 계산하고 그에 따른 비용 계산
                int modelsNeeded = (int) Math.ceil((double) customers / capacity);
                int totalModelCost = modelsNeeded * cost;

                // 최소 비용을 업데이트
                minCost = Math.min(minCost, totalModelCost);
            }

            // 해당 시간대의 최소 비용을 전체 비용에 추가
            totalCost += minCost;
        }

        return totalCost;
    }
}
