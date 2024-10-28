import java.util.*;
class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());
        
        for(int enemyNum : enemy) {
            pq.add(enemyNum);
            n -= enemyNum;
            
            if(n < 0) {
                if(!pq.isEmpty() && k > 0) {
                    k --;
                    n += pq.poll();
                } else {
                    break;
                }
            }
            answer ++;
        }
        return answer;
    }
}