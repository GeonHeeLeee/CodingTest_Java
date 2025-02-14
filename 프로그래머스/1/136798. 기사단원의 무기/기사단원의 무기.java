import java.util.*;
class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        for(int i = 1; i <= number; i ++) {
            int count = 0;
            for(int k = 1; k < (int) Math.sqrt(i) + 1; k++) {
                if(i % k == 0) {
                    count ++;
                    if(Math.pow(k, 2) != i) {
                        count ++;
                    }
                }
                if(count > limit) {
                    count = power;
                    break;
                }
            }
            answer += count;
        }
        
        return answer;
    }
}