import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
        PriorityQueue<int[]> requestPQ = new PriorityQueue<>(
                Comparator.comparingInt((int[] a) -> a[0])
                .thenComparingInt(a -> a[1]));
        PriorityQueue<int[]> jobPQ = new PriorityQueue<>(
                Comparator.comparingInt((int[] a) -> a[1])
                .thenComparingInt(a -> a[0]));
        for(int[] job : jobs) {
            requestPQ.offer(job);
        }
        int time = 0;
        int workingTime = 0;
        while(!requestPQ.isEmpty() || !jobPQ.isEmpty()) {
            while(!requestPQ.isEmpty() && requestPQ.peek()[0] <= time) {
                jobPQ.offer(requestPQ.poll());
            }
            if(!jobPQ.isEmpty()) {
                int[] job = jobPQ.poll();
                int requiredTime = job[1];
                int requestTime = job[0];
                if(time < requestTime) {
                    time += requestTime;
                }
                time += requiredTime;
                workingTime += (time - requestTime);
            } else {
                time ++;
            }
        }

        return workingTime / jobs.length;
    }
}