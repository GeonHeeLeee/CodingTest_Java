import java.util.*;
class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        int lastTime = 0;
        Map<Integer, Integer> attackMap = new HashMap();
        for(int i = 0; i < attacks.length; i ++) {
            lastTime = Math.max(lastTime, attacks[i][0]);
            attackMap.put(attacks[i][0], attacks[i][1]);
        }
        
        int maxHealth = health;
        int coolDown = bandage[0];
        int healPerTime = bandage[1];
        int plusHeal = bandage[2];
        
        int count = 0;
        for(int i = 0; i <= lastTime; i ++) {
            if(attackMap.containsKey(i)) {
                count = 0;
                health -= attackMap.get(i);
                if(health <= 0) {
                    health = -1;
                    break;
                }
            } else {
                count ++;
                health += healPerTime;
                if(count == coolDown) {
                    health += plusHeal;
                    count = 0;
                }
                if(health >= maxHealth) {
                    health = maxHealth;
                }
            }
        }

        return health;
    }
}