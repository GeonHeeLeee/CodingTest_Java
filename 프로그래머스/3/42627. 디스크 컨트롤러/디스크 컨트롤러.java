import java.util.*;

class Task {
    int index;
    int requestTime;
    int workingTime;
    
    public Task(int index, int requestTime, int workingTime) {
        this.index = index;
        this.requestTime = requestTime;
        this.workingTime = workingTime;
    }
}

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        Arrays.sort(jobs, (a,b) -> Integer.compare(a[0], b[0]));
        Queue<int[]> disk = new LinkedList<>();
        PriorityQueue<Task> pq = new PriorityQueue<>((a,b) -> {
            int result = Integer.compare(a.workingTime, b.workingTime);
            if(result != 0) {
                return result;
            }
            result = Integer.compare(a.requestTime, b.requestTime);
            if(result != 0) {
                return result;
            }
            return Integer.compare(a.index, b.index);
        });
        
        int index = 0;
        int finished = 0;
        for(int time = 0; time < Integer.MAX_VALUE; time ++) {
            if(!disk.isEmpty() && disk.peek()[0] + disk.peek()[1] == time) {
                int[] endTask = disk.poll();
                answer += (time - endTask[2]);
                finished ++;
            }
            while(index < jobs.length) {
                if(jobs[index][0] <= time) {
                    pq.offer(new Task(index, jobs[index][0], jobs[index][1]));
                    index ++;
                } else {
                    break;
                }
            }

            if(disk.isEmpty() && !pq.isEmpty()) {
                Task task = pq.poll();
                disk.offer(new int[]{time, task.workingTime, task.requestTime});
            }
            
            if(finished == jobs.length) {
                break;
            }
        } 
        return answer / jobs.length;
    }
}