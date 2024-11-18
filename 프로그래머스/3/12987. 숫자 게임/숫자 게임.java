import java.util.*;
class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        PriorityQueue<Integer> pqA = new PriorityQueue<Integer>(Collections.reverseOrder());
        PriorityQueue<Integer> pqB = new PriorityQueue<Integer>(Collections.reverseOrder());
        for(int i = 0; i < A.length; i ++) {
            pqA.add(A[i]);
            pqB.add(B[i]);
        }

        while(!pqA.isEmpty()) {
            int maxA = pqA.poll();
            int maxB = pqB.peek();
            if(maxA < maxB) {
                pqB.poll();
                answer ++;
            }
        }
        return answer;
    }
}
//1 3 5 7
//2 2 6 8

//5 7 10 13
//8 9 6 2