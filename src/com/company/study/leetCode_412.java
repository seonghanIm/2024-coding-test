package com.company.study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetCode_412 {
    public static void main(String[] args){

    }

    public static List<String> fizzBuzz(int n){
        List<String> answer = new ArrayList<>();
       for(int i = 1; i <=  n; i++){
           if(i % 3 == 0 && i % 5 == 0){
               answer.add("FizzBuzz");
               continue;
           }
           if(i % 3 == 0){
               answer.add("Fizz");
               continue;
           }
           if(i % 5 == 0){
               answer.add("Buzz");
               continue;
           }
           answer.add(String.valueOf(i));
       }
       return answer;
    }
}
