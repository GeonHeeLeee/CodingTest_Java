import java.util.*;
class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        for(int work : works) {
            pq.add(work);
        }
        
        while(!pq.isEmpty() && n > 0) {
            if(pq.peek() == 0) {
                break;
            }
            int maxValue = pq.poll();
            pq.add(maxValue - 1);
            n --;
        }

        while(!pq.isEmpty()) {
            int maxValue = pq.poll();
            answer += maxValue * maxValue;
        }
        return answer;
    }
}