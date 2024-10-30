import java.util.*;
class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = -1;
        int minDiff = 1;
        int maxDiff = Arrays.stream(diffs).max().getAsInt();
        
        while(minDiff <= maxDiff) {
            int midDiff = (minDiff + maxDiff) / 2;
            long clearTime = 0;
            for(int i = 0; i < diffs.length; i ++) {
                int curDiff = diffs[i];
                int levelDiff = midDiff < curDiff ? curDiff - midDiff : 0;
                
                if(levelDiff > 0 && i > 0) {
                    clearTime += ((long) (times[i] + times[i-1]) * levelDiff + times[i]);
                } else {
                    clearTime += times[i];
                }
                
                if(clearTime > limit) {
                    break;
                }
            }
            if(clearTime > limit) {
                minDiff = midDiff + 1;
            } else {
                answer = midDiff;
                maxDiff = midDiff - 1;
            }
        }
        return answer;
    }
}