import java.util.*;
class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets, (a,b) -> Integer.compare(b[1], a[1]));

        int curStart = Integer.MAX_VALUE;
        for(int[] target : targets) {
            int end = target[1];

            if(curStart < end) {
                curStart = Math.max(curStart, target[0]);
                continue;
            }
            
            answer ++;
            curStart = target[0];
        }
        return answer;
    }
}