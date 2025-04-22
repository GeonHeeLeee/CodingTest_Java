import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>((a,b) -> Integer.compare(b, a));
        Map<Integer, Integer> countMap = new HashMap();
        
        for(String operation : operations) {
            String[] input = operation.split(" ");
            String command = input[0];
            int number = Integer.parseInt(input[1]);
            
            switch(command) {
                case "I" :
                    minPQ.offer(number);
                    maxPQ.offer(number);
                    countMap.put(number, countMap.getOrDefault(number, 0) + 1);
                    break;
                case "D" :
                    if(countMap.isEmpty()) {
                        continue;
                    }
                    
                    PriorityQueue<Integer> pq = number == 1 ? maxPQ : minPQ;
                    
                    while(!pq.isEmpty()) {
                        int removed = pq.poll();
                        if(countMap.containsKey(removed)) {
                            int count = countMap.get(removed);
                            if(count == 1) {
                                countMap.remove(removed);
                            } else {
                                countMap.put(removed, count - 1);
                            }
                            break;
                        }
                    }
            }
        }
        
        if(countMap.isEmpty()) {
            return new int[]{0, 0};
        }
        
        int max = 0;
        int min = 0;
        while(!minPQ.isEmpty()) {
            int current = minPQ.poll();
            if(countMap.containsKey(current)) {
                min = current;
                break;
            }
        }
               
        while(!maxPQ.isEmpty()) {
            int current = maxPQ.poll();
            if(countMap.containsKey(current)) {
                max = current;
                break;
            }
        }

        return new int[]{max, min};
    }
}