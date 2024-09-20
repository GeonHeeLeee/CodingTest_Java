import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue();
        for(int i : scoville) {
            minHeap.add(i);
        }
        while(minHeap.size() >= 2) {
            if(minHeap.peek() < K) {
                minHeap.add(minHeap.poll() + minHeap.poll()*2);
                answer ++;
            } else {
                return answer;
            }
        }
        if(minHeap.peek() >= K) {
            return answer;
        } else {
            return -1;
        }
    }
}