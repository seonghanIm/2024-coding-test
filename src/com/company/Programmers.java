package com.company;

public class Programmers {
    // bandage 시전시간, 초당 회복량, 추가회복량
    // health 최대 체력
    // attacks 공격시간,피해량
    // PCCP 기출 문제 1번
    public int solution(int[] bandage, int health, int[][] attacks) {
        // 연속 성공 횟수
        int maxHealth = health;
        int sucessTime = 0;
        int attackIndex = 0;
        // attacks 의 횟수의 가장 큰 시간 만큼 for 문
        int maxTime = attacks[attacks.length - 1][0];
        for (int currentTime = 0; currentTime <= maxTime; currentTime++) {
            if (currentTime == attacks[attackIndex][0]) {
                sucessTime = 0;
                health -= attacks[attackIndex][1];
                if (health <= 0) {
                    return -1;
                }
                attackIndex++;

            } else if (++sucessTime == bandage[0]) {
                // 연속 성공 => 초당 회복량 + 추가 회복량
                health = health + bandage[1] + bandage[2];
                if (health > maxHealth) {
                    health = maxHealth;
                }

                sucessTime = 0;
            } else {
                // 공격도 안받았고 그냥 초당 회복량만
                health += bandage[1];
                if (health > maxHealth) {
                    health = maxHealth;
                }
            }
        }
        if (maxHealth < health) {
            health = maxHealth;
        } else if (health <= 0) {
            health = -1;
        }

        return health;
    }
}
