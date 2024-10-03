package com.company.Nsuslab;

import java.util.ArrayList;
import java.util.List;

public class Problem2 {
    public static void main(String[] args) {
        Problem3 p = new Problem3();
        String[] a = p.solution("EEESEEEEEENNNN");
        for(int i = 0 ; i < a.length; i++ ){
            System.out.println(a[i]);
        }
//        int[][] fees = {
//                {200,910,93},
//                {400,1600,188},
//                {655,7300,281},
//                {0,15372,435}
//        };
//        solution(fees,320);
//        int[][] fees = {
//                {1851,1000,100},
//                {0,2000,155}
//        };
//        solution(fees,1205);
//        int[][] fees = {
//                {100, 415, 90},
//                {250, 1600, 389},
//                {0, 7000, 480}
//        };
//        solution(fees, 530);
    }

    public static int solution(int[][] fees, int usage) {
        int answer = 0;
        List<Fees> feesList = new ArrayList<>();
        for (int i = 0; i < fees.length; i++) {
            Fees fee = new Fees(fees[i][0], fees[i][1], fees[i][2], false);
            feesList.add(fee);
        }
        answer += getBaseFee(feesList, usage);
        answer += getKhwFee(feesList, usage);


        return answer;
    }


    public static class Fees {
        int max;
        int baseFee;
        int khwFee;
        boolean baseHere;

        public Fees(int max, int baseFee, int khwFee, boolean baseHere) {
            this.max = max;
            this.baseFee = baseFee;
            this.khwFee = khwFee;
            this.baseHere = baseHere;
        }
    }


    public static int getBaseFee(List<Fees> feesList, int usage) {
        for (Fees f : feesList) {
            if (f.max > usage) {
                f.baseHere = true;
                return f.baseFee;
            }
        }
        feesList.get(feesList.size() - 1).baseHere = true;
        return feesList.get(feesList.size() - 1).baseFee;
    }

    public static int getKhwFee(List<Fees> feesList, int usage) {
        int fee = 0;
        int prev = 0;
        for (Fees f : feesList) {
            if (f.baseHere) {
                fee +=  f.khwFee * (usage - prev);
                return fee;
            }
            fee += f.khwFee * (f.max - prev);
            prev = f.max;

        }
        return fee;
    }


}
