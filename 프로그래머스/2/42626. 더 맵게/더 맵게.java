import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int food : scoville) {
            pq.offer(food);
        }
        
        boolean isMade = false;
        while(pq.size() > 1) {
            if(pq.peek() >= K) {
                isMade = true;
                break;
                
            }
            pq.offer(pq.poll() + pq.poll() * 2);
            answer ++;
        }
        
        if(!pq.isEmpty() && pq.peek() >= K) {
            isMade = true;
        }
        
        return isMade ? answer : -1;
    }
}