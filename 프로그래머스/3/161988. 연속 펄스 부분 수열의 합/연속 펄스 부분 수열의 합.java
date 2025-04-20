import java.util.*;
class Solution {
    public long solution(int[] sequence) {
        int n = sequence.length;
        long max = Long.MIN_VALUE;
        long sum1 = 0, sum2 = 0;
        
        for(int i = 0; i < n; i ++) {
            int pulse1 = (i % 2 == 0) ? 1 : - 1;
            int pulse2 = (i % 2 == 0) ? -1 : 1;
            
            sum1 = Math.max(sequence[i] * pulse1, sum1 + sequence[i] * pulse1);
            sum2 = Math.max(sequence[i] * pulse2, sum2 + sequence[i] * pulse2);
            
            max = Math.max(max, Math.max(sum1, sum2));
        }
        
        return max;
    }
}