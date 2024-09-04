package com.company.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon1931 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 회의 수
        int N = Integer.parseInt(br.readLine());
        List<MeetingTime> meetingTimeList = new ArrayList<>();
        for(int i = 0 ; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            MeetingTime meetingTime = new MeetingTime(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
            meetingTimeList.add(meetingTime);
        }
        solution(meetingTimeList);

    }

    public static class MeetingTime {
        int startTime;
        int endTime;
        int order;

        public MeetingTime(int startTime, int endTime){
            this.startTime = startTime;
            this.endTime = endTime;
            this.order = 0;
        }

        public int getDiff(){
            return this.endTime - this.startTime;
        }
    }

    public static void solution(List<MeetingTime> meetingTimeList){
        Collections.sort(meetingTimeList, new Comparator<MeetingTime>() {
            @Override
            public int compare(MeetingTime o1, MeetingTime o2) {
                if(o1.startTime != o2.startTime){
                    return Integer.compare(o1.startTime, o2.startTime);
                }
                return Integer.compare(o1.endTime,o1.endTime);
            }
        });

        for(int i = 0 ; i < meetingTimeList.size(); i++){
            meetingTimeList.get(i).order = i;
        }

        List<MeetingTime> selectedMeetingList = new ArrayList<>();
        MeetingTime previousMeetingTime = null;
        // 각 구간별로
        int count = 0;
        for(int i = 0; i < meetingTimeList.size(); i++){
            MeetingTime meetingTime = meetingTimeList.get(i);

            if(!selectedMeetingList.isEmpty()) {
                if(previousMeetingTime.endTime > meetingTime.startTime){
                    continue;
                }
            }
            List<MeetingTime> list = getInRangeMeeting(meetingTimeList,meetingTime);
            MeetingTime selectedMeeting = getMinDiffMeeting(list);
            selectedMeetingList.add(selectedMeeting);
            // 다음 선택 미팅 범위 지정
            i = selectedMeeting.order;
            previousMeetingTime = selectedMeeting;
        }

        System.out.println(selectedMeetingList.size());

    }


    public static List<MeetingTime> getInRangeMeeting(List<MeetingTime> meetingTimeList, MeetingTime meetingTime){
        List<MeetingTime> list = new ArrayList<>();
        for(MeetingTime m : meetingTimeList){
            if(m.startTime < meetingTime.endTime && m.order >= meetingTime.order ){
                list.add(m);
            }
        }
        return list;
    }


    public static MeetingTime getMinDiffMeeting(List<MeetingTime> meetingTimeList){
        MeetingTime meetingTime = new MeetingTime(0, Integer.MAX_VALUE);
        for(MeetingTime m : meetingTimeList){
            if(meetingTime.getDiff() > m.getDiff()){
                meetingTime = m;
            }
        }
        return meetingTime;
    }




}
