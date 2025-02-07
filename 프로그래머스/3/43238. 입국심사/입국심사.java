import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        long left = 1;
        long right = (long) times[times.length-1] * n;
        Arrays.sort(times);
        while(left <= right) {
            long people = 0;
            long mid = (left + right) / 2;
            
            for(long time : times) {
                people += mid / time;
                if(people >= n) {
                    break;
                }
            }
            
            if(people >= n) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return answer;
    }
}