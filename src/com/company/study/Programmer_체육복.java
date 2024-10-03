package com.company.study;


public class Programmer_체육복 {


    public static void main(String[] args){
        int n = 5;
        int[] lost = {1,2};
        int[] reserve = {2,3};
        System.out.println(solution(n,lost,reserve));
    }

        public static int solution(int n, int[] lost, int[] reserve) {
            // lost 에도 없고, reserve 에도 없는 학생은 + 1
            // lost 에도 있고, reserve 에도 있는 학생은 + 1
            // lost 에는 있고, reserve 에 없는 학생은 => 앞뒤 체크
            // lost 에는 없고 reserve 에만 있는 학생 ++;
            int answer = 0;
            // 겹치는거 제거 후에 ++
            for(int i = 0; i < lost.length; i ++){
                if(contains(reserve,lost[i])){
                    removeReserve(reserve,lost[i]);
                    removeReserve(lost,lost[i]);
                }
            }

            for(int i = 1; i <= n; i++){
                // 체육복을 가진 경우
                if(!contains(lost,i) && !contains(reserve,i)){
                    answer++;
                    // 잃어버렸지만, 여유분이 있는 경우
                }else if(contains(lost,i) && contains(reserve,i)){
                    answer++;
                    // 잃어버리지도 않았고 여유분도 있는 경우
                }else if(!contains(lost,i) && contains(reserve,i)){
                    answer++;
                }else{
                    // 잃어버린경우
                    // 체육복은 두벌씩인듯 => 한번 빌려줬으면 reserve 에서 빼야함
                    if(contains(reserve,i-1)){
                        answer++;
                        removeReserve(reserve,i-1);
                    }else if(contains(reserve, i+1)){
                        answer++;
                        removeReserve(reserve,i+1);
                    }
                }
            }
            return answer;
        }

        public static boolean contains(int[] arr, int num){
            for(int i = 0; i < arr.length; i++){
                if(arr[i] == num){
                    return true;
                }
            }
            return false;
        }

        public static void removeReserve(int[] arr, int num){
            for(int i = 0; i < arr.length; i++){
                if(arr[i] == num){
                    arr[i] = 100;
                }
            }
        }

}
