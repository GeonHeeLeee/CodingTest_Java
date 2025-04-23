import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        PriorityQueue<String> pq = new PriorityQueue<>((a,b) -> (b+a).compareTo(a+b));
        
        for(int number : numbers) {
            pq.offer(String.valueOf(number));
        }
        
        if(pq.peek().equals("0")) {
            return "0";
        }
        while(!pq.isEmpty()) {
            sb.append(pq.poll());
        }
        return sb.toString();
    }
}