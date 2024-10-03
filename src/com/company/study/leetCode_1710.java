package com.company.study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class leetCode_1710 {
    public static void main(String[] args){
        int[][] boxTypes = {{1,3},{2,2},{3,1}};
        int truckSize = 4;
        System.out.println(maximumUnits(boxTypes,truckSize));
    }
    public static int maximumUnits(int[][] boxTypes, int truckSize){
        int result = 0;
        Arrays.sort(boxTypes,(a,b) -> Integer.compare(b[1],a[1]));

        for(int i = 0; i < boxTypes.length; i++){
            truckSize -= boxTypes[i][0];
            if(truckSize < 0){
                truckSize += boxTypes[i][0];
                result += truckSize * boxTypes[i][1];
                break;
            }
            result += boxTypes[i][0] * boxTypes[i][1];
        }

        return result;
    }


}
