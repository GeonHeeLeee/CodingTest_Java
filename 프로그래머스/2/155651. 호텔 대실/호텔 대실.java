import java.util.*;
class Solution {
    public int solution(String[][] book_time) {
        int answer = 1;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        PriorityQueue<Integer> lastest = new PriorityQueue<>();
        for(String[] time : book_time) {
            String start = time[0];
            String end = time[1];
            
            int startHour = Integer.parseInt(start.split(":")[0]) * 60;
            int startMin = Integer.parseInt(start.split(":")[1]);
            
            int endHour = Integer.parseInt(end.split(":")[0]) * 60;
            int endMin = Integer.parseInt(end.split(":")[1]);
            
            pq.offer(new int[]{startHour + startMin, endHour + endMin + 10});
        }

        lastest.offer(pq.poll()[1]);
        while(!pq.isEmpty()) {
            int[] current = pq.poll();
            int curStart = current[0];
            int curEnd = current[1];
            
            if(!lastest.isEmpty()) {
                if(lastest.peek() > curStart) {
                    lastest.offer(curEnd);
                    answer ++;
                } else {
                    lastest.poll();
                    lastest.offer(curEnd);
                }
            }
            
        }
        return answer;
    }
}