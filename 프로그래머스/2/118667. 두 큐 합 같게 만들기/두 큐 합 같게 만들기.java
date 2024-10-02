import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = -1;
        long sum1 = 0;
        long sum2 = 0;
        int count = 0;
        Queue<Long> q1 = new LinkedList();
        Queue<Long> q2 = new LinkedList();
        for(int i = 0; i < queue1.length; i ++) {
            q1.add((long)queue1[i]);
            q2.add((long)queue2[i]);
            sum1 += (long)queue1[i];
            sum2 += (long)queue2[i];
        }
        
        while(sum1 != sum2 && count <= queue1.length + queue2.length + 1) {
            count ++;
            if(sum1 > sum2) {
                long num = q1.poll();
                sum1 -= num;
                sum2 += num;
                q2.add(num);
            } else if(sum1 < sum2) {
                long num = q2.poll();
                sum1 += num;
                sum2 -= num;
                q1.add(num);
            }
        }
        return sum1 == sum2 ? count : answer;
    }
}