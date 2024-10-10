import java.util.*;
import java.time.*;
class Solution {
    public int parseToMinutes(String time) {
        int hour = Integer.parseInt(time.split(":")[0]);
        int minutes = Integer.parseInt(time.split(":")[1]);
        
        return hour * 60 + minutes;
    }
    public int solution(String[][] book_time) {
        PriorityQueue<Integer> roomQueue = new PriorityQueue();
        Arrays.sort(book_time, Comparator.comparing(
            interval -> LocalTime.parse(interval[0])
        ));
        
        for(String[] time : book_time) {
            int startTime = parseToMinutes(time[0]);
            int endTime = parseToMinutes(time[1]) + 10;
            
            if(!roomQueue.isEmpty() && roomQueue.peek() <= startTime) {
                roomQueue.poll();
            }
            
            roomQueue.offer(endTime);
        }
        return roomQueue.size();
    }
}