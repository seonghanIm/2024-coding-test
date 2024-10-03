package com.company.Nsuslab;

public class Problem1 {
    public static void main(String[] args) {

//        System.out.println(solution(30,25,13,"0001",new int[] {0,29,30,119,120}));
        System.out.println(solution(1,1,1000,"7123",new int[] {2,3,4}));
    }


    // k 비밀번호 바뀌는 주기
    public static String[] solution(int k, int a, int b, String init_password, int[] times) {
        String[] answer = new String[times.length];

        for (int i = 0; i < times.length; i++) {
            int count = times[i]/k;
            int newPassword = getPassword(count,a,b,init_password);
            answer[i] = String.format("%04d",newPassword);
        }


        return answer;
    }


    public static int getPassword(int count, int a, int b, String password) {
        int newPassword = Integer.parseInt(password);
        for(int i = 0; i < count; i++){
            newPassword = (a * newPassword + b) % 10000;
        }
        return newPassword;
    }

}
