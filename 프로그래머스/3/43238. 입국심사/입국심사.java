class Solution {
    public long solution(int n, int[] times) {
        long answer = Long.MAX_VALUE;
        long maxTime = 0;
        for(int time : times) {
            maxTime = Math.max(maxTime, time);
        }
        
        long left = 0;
        long right = maxTime * n;
        
        while(left <= right) {
            long mid = (left + right) / 2;
            long count = 0;
            for(int time : times) {
                count += (mid / time);
            }
            
            if(count >= n) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return answer;
    }
}