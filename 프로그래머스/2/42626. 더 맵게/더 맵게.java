import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int food : scoville) {
            pq.offer(food);
        }
        
        while(pq.size() >= 2) {
            int leastSpicy = pq.poll();
            if(leastSpicy >= K) {
                return answer;
            }
            int secondSpicy = pq.poll();
            pq.offer(leastSpicy + secondSpicy * 2);
            answer ++;
        }
        if(!pq.isEmpty() && pq.peek() >= K) {
            return answer;
        }
        return -1;
    }
}