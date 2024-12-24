import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> maxpq = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minpq = new PriorityQueue<>();
        
        for(String operation : operations) {
            String command = operation.split(" ")[0];
            int number = Integer.parseInt(operation.split(" ")[1]);
            
            if(command.equals("I")) {
                maxpq.offer(number);
                minpq.offer(number);
            } else if(!maxpq.isEmpty() && operation.equals("D 1")) {
                minpq.remove(maxpq.poll());
            } else if(!minpq.isEmpty() && operation.equals("D -1")) {
                maxpq.remove(minpq.poll());
            }
        }
        if(minpq.isEmpty() && maxpq.isEmpty()) {
            return new int[]{0,0};
        } else {
            return new int[]{maxpq.poll(), minpq.poll()};
        }

    }
}