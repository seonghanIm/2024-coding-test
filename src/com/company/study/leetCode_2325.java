package com.company.study;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class leetCode_2325 {

    public static void main(String[] args){
        System.out.println(decodeMessage("eljuxhpwnyrdgtqkviszcfmabo","zwx hnfx lqantp mnoeius ycgk vcnjrdb"));
    }

    public static String decodeMessage(String key, String message){
        // Map<key,abcd>
        Map<String,String> map = new HashMap<>();
        String[] keys = key.split("");
        char alpabet = 'a';
        for(int i = 0; i < keys.length; i++ ){
            if(map.containsKey(keys[i])){
                continue;
            }
            if(keys[i].equals(" ")){
                map.put(" "," ");
                continue;
            }
           map.put(keys[i],String.valueOf(alpabet));
           ++alpabet;
        }
        map.put(" "," ");
        StringBuilder builder = new StringBuilder();

        for(int i = 0; i < message.length(); i++){
            builder.append(map.get(String.valueOf(message.charAt(i))));
        }

        return builder.toString();
    }
}
