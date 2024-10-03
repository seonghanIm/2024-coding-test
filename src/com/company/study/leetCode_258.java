package com.company.study;

public class leetCode_258 {

    public static void main(String[] args){
        System.out.println(addDigits(38));
    }

    public static int addDigits(int num){
        if(num / 10 == 0){
            return num;
        }
        return addDigits(divideAndSum(num));

    }


    public static int divideAndSum(int num){
        String[] numArr = String.valueOf(num).split("");
        int sum = 0;
        for(int i = 0; i < numArr.length; i++){
            sum += Integer.valueOf(numArr[i]);
        }
        return sum;
    }
}
