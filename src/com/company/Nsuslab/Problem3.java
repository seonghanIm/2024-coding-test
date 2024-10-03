package com.company.Nsuslab;

import java.util.ArrayList;
import java.util.List;

public class Problem3 {
    public enum Direction {
        EAST("E"),
        WEST("W"),
        NORTH("N"),
        SOUTH("S"),
        LEFT("left"),
        RIGHT("right");

        private String direction;

        Direction(String direction) {
            this.direction = direction;
        }
    }

    public class Navigation {
        public int time;
        public int meter;
        public String direction;

        public Navigation(int time, int meter, String direction) {
            this.time = time;
            this.meter = meter;
            this.direction = direction;
        }

        public String toString() {
            return "Time " + time + ": Go straight " + meter + "m and turn " + direction;
        }
    }


    public String[] solution(String path) {
        String[] pathArr = path.split("");
        String prevChar = pathArr[0];
        List<Navigation> navigationList = new ArrayList<>();
        int time = 0;
        int meter = 0;
        for(int i = 0; i < pathArr.length; i++){
            // 출발 직후 방향 변경
//            if(i!=0 && navigationList.isEmpty() && !prevChar.equals(pathArr[i])){
//                Navigation navigation = new Navigation(0,meter,getDirection(prevChar,pathArr[i]));
//                navigationList.add(navigation);
//                meter = 0;
//                prevChar = pathArr[i];
//                continue;
//            }

            // 다음 방향 번경 지점까지의 거리가 500m
            if(!prevChar.equals(pathArr[i]) && meter > 500){
                // 현재 거리에서 5 를 빼주면 그 시간
                time = i - 5;
                Navigation navigation = new Navigation(time,500,getDirection(prevChar,pathArr[i]));
                navigationList.add(navigation);
                meter = 100;
                prevChar = pathArr[i];
                continue;
            }
            // 방향 변경 직후 다음 방향 지점 까지의 거리가 500m 이하
            if(!prevChar.equals(pathArr[i]) && meter <= 500){
                if(pathArr.length - i < 5){
                    continue;
                }
                time = i - meter/100;
                Navigation navigation = new Navigation(time, meter, getDirection(prevChar,pathArr[i]));
                navigationList.add(navigation);
                meter = 100;
                prevChar = pathArr[i];
                continue;
            }
            meter += 100;
            prevChar = pathArr[i];


        }

        String[] answer = new String[navigationList.size()];
        for (int i = 0; i < navigationList.size(); i++) {
            answer[i] = navigationList.get(i).toString();
        }
        return answer;
    }


    // E -> N  , E -> S,
    // W -> N  , W -> S,
    // N -> E , N -> W,
    // S -> E , S - > W
    public String getDirection(String prev, String current) {
        if (prev.equals(Direction.EAST.direction)) {
            if (current.equals(Direction.NORTH.direction)) {
                return Direction.LEFT.direction;
            }
            if (current.equals(Direction.SOUTH.direction)) {
                return Direction.RIGHT.direction;
            }
        }

        if (prev.equals(Direction.WEST.direction)) {
            if (current.equals(Direction.NORTH.direction)) {
                return Direction.RIGHT.direction;
            }
            if (current.equals(Direction.SOUTH.direction)) {
                return Direction.LEFT.direction;
            }
        }

        if (prev.equals(Direction.NORTH.direction)) {
            if (current.equals(Direction.WEST.direction)) {
                return Direction.LEFT.direction;
            }
            if (current.equals(Direction.EAST.direction)) {
                return Direction.RIGHT.direction;
            }
        }

        if (prev.equals(Direction.SOUTH.direction)) {
            if (current.equals(Direction.WEST.direction)) {
                return Direction.RIGHT.direction;
            }
            if (current.equals(Direction.EAST.direction)) {
                return Direction.LEFT.direction;
            }
        }

        return "";
    }
}
