import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        long right = Long.MIN_VALUE;
        for(int time : times) {
            right = Math.max(right, time);
        }
        
        right = right * n + 1;
        long left = 0;
        
        while(left <= right) {
            long mid = (left + right) / 2;
            long people = 0;
            for(int time : times) {
                people += mid / time;
                if(people > n) {
                    break;
                }
            }
            
            if(people < n) {
                left = mid + 1;
            } else {
                answer = mid;
                right = mid - 1;
            }
        }
        
        return answer;
    }
}